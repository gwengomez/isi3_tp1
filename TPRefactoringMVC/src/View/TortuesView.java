/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Tortue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author Epulapp
 */
public abstract class TortuesView extends JFrame implements Observer {
    //dimension (height and width) of both gaps

    public static final Dimension VGAP = new Dimension(1, 5);
    public static final Dimension HGAP = new Dimension(5, 1);

    //ref to FeuilleDessin
    protected FeuilleDessin feuille;
    //listener to event
    protected ActionListener listener;
    //JMenu, for class who whish to edit the menus
    protected JMenu menuFile;
    protected JMenu menuHelp;
    protected JMenuBar menubar;

    /**
     * Constructor Call JFrame constructor and init function then add a listener
     * on the window closing event
     */
    public TortuesView(ActionListener l) {
        super("Tortues");
        this.listener = l;
        logoInit();
        addComponents();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                super.windowClosing(arg0);
                System.exit(0);
            }
        });
        this.setResizable(false);
    }

    /**
     * create all the UI items and instanciate the Tortue and FeuilleDessin
     */
    public abstract void addComponents();

    private void logoInit() {
        getContentPane().setLayout(new BorderLayout(10, 10));

        // Menus
        this.menubar = new JMenuBar();
        setJMenuBar(menubar);	// on installe le menu bar
        this.menuFile = new JMenu("File"); // on installe le premier menu
        menubar.add(menuFile);

        addMenuItem(menuFile, "Quitter", "Quitter", KeyEvent.VK_Q);

        this.menuHelp = new JMenu("Aide"); // on installe le premier menu
        menubar.add(menuHelp);
        addMenuItem(menuHelp, "Aide", "Help", -1);
        addMenuItem(menuHelp, "A propos", "About", -1);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        feuille = new FeuilleDessin();
        feuille.setBackground(Color.white);
        feuille.setSize(new Dimension(600, 400));
        feuille.setPreferredSize(new Dimension(600, 400));

        getContentPane().add(feuille, "Center");

        pack();
        setVisible(true);
    }

    public void registerTortue(Tortue t) {
        this.feuille.addTortue(t);
        t.addObserver(this);
    }

    public Dimension getFeuilleDimension() {
        return this.feuille.getSize();
    }

    /**
     * exit the app
     */
    public void quitter() {
        System.exit(0);
    }

    public void addMenuItem(JMenu m, String label, String command, int key) {
        JMenuItem menuItem;
        menuItem = new JMenuItem(label);
        m.add(menuItem);

        menuItem.setActionCommand(command);
        menuItem.addActionListener(listener);
        if (key > 0) {
            if (key != KeyEvent.VK_DELETE) {
                menuItem.setAccelerator(KeyStroke.getKeyStroke(key, Event.CTRL_MASK, false));
            } else {
                menuItem.setAccelerator(KeyStroke.getKeyStroke(key, 0, false));
            }
        }
    }

    public void addButton(JComponent p, String name, String tooltiptext, String imageName) {
        JButton b;
        if ((imageName == null) || (imageName.equals(""))) {
            b = (JButton) p.add(new JButton(name));
        } else {
            java.net.URL u = this.getClass().getResource(imageName);
            if (u != null) {
                ImageIcon im = new ImageIcon(u);
                b = (JButton) p.add(new JButton(im));
            } else {
                b = (JButton) p.add(new JButton(name));
            }
            b.setActionCommand(name);
        }

        b.setToolTipText(tooltiptext);
        b.setBorder(BorderFactory.createRaisedBevelBorder());
        b.setMargin(new Insets(0, 0, 0, 0));
        b.addActionListener(listener);
    }
    
    public void addMyMouseListener(MouseListener ml) {
        this.feuille.addMouseListener(ml);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.feuille.repaint();
    }
}
