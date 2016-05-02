/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.LogoController;
import Model.Tortue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

/**
 *
 * @author Epulapp
 */
public class SimpleLogo extends JFrame implements Observer {
    //dimension (height and width) of both gaps

    public static final Dimension VGAP = new Dimension(1, 5);
    public static final Dimension HGAP = new Dimension(5, 1);

    //ref to FeuilleDessin
    private FeuilleDessin feuille;
    //ref to Tortue
    private Tortue courante;
    //ref to a JTextField
    private JTextField inputValue;
    //ref to a combobox (color picker)
    private JComboBox colorList;
    //ref to inner class instance of Actionlistener
    private SimpleLogoListener listener;
    //ref to controller
    private LogoController controleur;

    /**
     * Constructor Call JFrame constructor and init function then add a listener
     * on the window closing event
     */
    public SimpleLogo(LogoController ctrl, Tortue t) {
        super("un logo tout simple");
        this.controleur = ctrl;
        this.courante = t;
        this.listener = new SimpleLogoListener();
        logoInit();
        t.addObserver(this);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                super.windowClosing(arg0);
                System.exit(0);
            }
        });
    }

    /**
     * create all the UI items and instanciate the Tortue and FeuilleDessin
     */
    public void logoInit() {
        getContentPane().setLayout(new BorderLayout(10, 10));

        // Boutons
        JToolBar toolBar = new JToolBar();
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(toolBar);

        getContentPane().add(buttonPanel, "North");

        addButton(toolBar, "Effacer", "Nouveau dessin", "/icons/index.png");

        toolBar.add(Box.createRigidArea(HGAP));
        inputValue = new JTextField("45", 5);
        toolBar.add(inputValue);
        addButton(toolBar, "Avancer", "Avancer 50", null);
        addButton(toolBar, "Droite", "Droite 45", null);
        addButton(toolBar, "Gauche", "Gauche 45", null);

        String[] colorStrings = {"noir", "bleu", "cyan", "gris fonce", "rouge",
            "vert", "gris clair", "magenta", "orange",
            "gris", "rose", "jaune"};

        // Create the combo box
        toolBar.add(Box.createRigidArea(HGAP));
        JLabel colorLabel = new JLabel("   Couleur: ");
        toolBar.add(colorLabel);
        colorList = new JComboBox(colorStrings);
        toolBar.add(colorList);
        colorList.setActionCommand("Colorer");

        colorList.addActionListener(listener);
        // Menus
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);	// on installe le menu bar
        JMenu menuFile = new JMenu("File"); // on installe le premier menu
        menubar.add(menuFile);

        addMenuItem(menuFile, "Effacer", "Effacer", KeyEvent.VK_N);
        addMenuItem(menuFile, "Quitter", "Quitter", KeyEvent.VK_Q);

        JMenu menuCommandes = new JMenu("Commandes"); // on installe le premier menu
        menubar.add(menuCommandes);
        addMenuItem(menuCommandes, "Avancer", "Avancer", -1);
        addMenuItem(menuCommandes, "Droite", "Droite", -1);
        addMenuItem(menuCommandes, "Gauche", "Gauche", -1);
        addMenuItem(menuCommandes, "Lever Crayon", "Lever", -1);
        addMenuItem(menuCommandes, "Baisser Crayon", "Baisser", -1);
        addMenuItem(menuCommandes, "Colorer Crayon", "Colorer", -1);

        JMenu menuHelp = new JMenu("Aide"); // on installe le premier menu
        menubar.add(menuHelp);
        addMenuItem(menuHelp, "Aide", "Help", -1);
        addMenuItem(menuHelp, "A propos", "About", -1);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // les boutons du bas
        JPanel p2 = new JPanel(new GridLayout());
        JButton b20 = new JButton("Proc1");
        p2.add(b20);
        b20.addActionListener(listener);
        JButton b21 = new JButton("Proc2");
        p2.add(b21);
        b21.addActionListener(listener);
        JButton b22 = new JButton("Proc3");
        p2.add(b22);
        b22.addActionListener(listener);

        getContentPane().add(p2, "South");

        feuille = new FeuilleDessin(); //500, 400);
        feuille.setBackground(Color.white);
        feuille.setSize(new Dimension(600, 400));
        feuille.setPreferredSize(new Dimension(600, 400));

        getContentPane().add(feuille, "Center");

        // Deplacement de la tortue au centre de la feuille
        this.controleur.moveToCenter(new Dimension(500, 400));

        feuille.addTortue(this.courante);
        
        pack();
        setVisible(true);
    }

    /**
     * exit the app
     */
    private void quitter() {
        System.exit(0);
    }

    /**
     * Get the value of the input text
     *
     * @return inputValue value
     */
    public String getInputValue() {
        String s = inputValue.getText();
        return (s);
    }

    // efface tout et reinitialise la feuille
    public void effacer() {
        feuille.reset();
        feuille.repaint();

        // Replace la tortue au centre
        this.controleur.reset();
        this.controleur.moveToCenter(feuille.getSize());
    }

    //utilitaires pour installer des boutons et des menus
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

    @Override
    public void update(Observable o, Object arg) {
        //this.feuille.
        this.repaint();
    }

    public class SimpleLogoListener implements ActionListener {

        @Override
        /**
         * la gestion des actions des boutons
         */
        public void actionPerformed(ActionEvent e) {
            String c = e.getActionCommand();

            // actions des boutons du haut
            if (c.equals("Avancer")) {
                System.out.println("command avancer");
                try {
                    int v = Integer.parseInt(inputValue.getText());
                    controleur.avancer(v);
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre : " + inputValue.getText());
                }

            } else if (c.equals("Droite")) {
                try {
                    int v = Integer.parseInt(inputValue.getText());
                    controleur.droite(v);
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre : " + inputValue.getText());
                }
            } else if (c.equals("Gauche")) {
                try {
                    int v = Integer.parseInt(inputValue.getText());
                    controleur.gauche(v);
                } catch (NumberFormatException ex) {
                    System.err.println("ce n'est pas un nombre : " + inputValue.getText());
                }
            } else if (c.equals("Colorer")) {
                JComboBox cb = (JComboBox) e.getSource();
                int n = cb.getSelectedIndex();
                controleur.colorerCrayon(n);                
            }// actions des boutons du bas
            else if (c.equals("Proc1")) {
                controleur.carre();
            } else if (c.equals("Proc2")) {
                controleur.poly(60, 8);
            } else if (c.equals("Proc3")) {
                controleur.spiral(50, 40, 6);
            } else if (c.equals("Effacer")) {
                effacer();
            } else if (c.equals("Quitter")) {
                quitter();
            }

            //UI refresh
            feuille.repaint();
        }

    }

}
