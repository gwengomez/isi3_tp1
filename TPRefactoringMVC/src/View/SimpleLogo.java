/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.LogoController;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/**
 *
 * @author Epulapp
 */
public class SimpleLogo extends TortuesView implements Observer {
    //dimension (height and width) of both gaps

    public static final Dimension VGAP = new Dimension(1, 5);
    public static final Dimension HGAP = new Dimension(5, 1);

    //ref to a JTextField
    private JTextField inputValue;
    //ref to a combobox (color picker)
    private JComboBox colorList, formeList;
    //controller
    private LogoController controleur;

    /**
     * Constructor Call JFrame constructor and init function then add a listener
     * on the window closing event
     */
    public SimpleLogo() {
        super();
    }
    /**
     * create all the UI items and instanciate the Tortue and FeuilleDessin
     */
    @Override
    public void addComponents() {
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
        //addButton(toolBar, "+ Tortue", "Ajouter une tortue", null);

        String[] colorStrings = {"noir", "bleu", "cyan", "gris fonce", "rouge",
            "vert", "gris clair", "magenta", "orange",
            "gris", "rose", "jaune"};

        // Create the combo box (for color)
        toolBar.add(Box.createRigidArea(HGAP));
        JLabel colorLabel = new JLabel("   Couleur: ");
        toolBar.add(colorLabel);
        colorList = new JComboBox(colorStrings);
        toolBar.add(colorList);
        colorList.setActionCommand("Colorer");

        colorList.addActionListener(listener);
        
        String[] formeStrings = {"ronde", "carré", "triangle"};
        
        // Create the comboBox (to add a tortue)              
        toolBar.add(Box.createRigidArea(HGAP));
        JLabel formeLabel = new JLabel("Ajouter Tortue: ");
        toolBar.add(formeLabel);
        formeList = new JComboBox(formeStrings);
        toolBar.add(formeList);
        formeList.setActionCommand("Add Tortue");
        formeList.setSelectedIndex(0);
        formeList.addActionListener(listener);
        
        // Menus

        addMenuItem(menuFile, "Effacer", "Effacer", KeyEvent.VK_N);

        JMenu menuCommandes = new JMenu("Commandes"); // on installe le premier menu
        menubar.add(menuCommandes);
        addMenuItem(menuCommandes, "Avancer", "Avancer", -1);
        addMenuItem(menuCommandes, "Droite", "Droite", -1);
        addMenuItem(menuCommandes, "Gauche", "Gauche", -1);

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
        
        this.feuille.addMouseListener(new SimpleLogoMouseListener());
        pack();
        setVisible(true);
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
    
    public void registerController(LogoController c) {
        this.controleur = c;
    }

    // efface tout et reinitialise la feuille
    public void effacer() {
        feuille.reset();
        feuille.repaint();

        //Reset la position de toutes les tortues
        this.controleur.reset();
    }

    @Override
    public void setActionListener() {
        this.listener = new SimpleLogoListener();
    }

    public class SimpleLogoListener implements ActionListener {

        /**
         * la gestion des actions des boutons
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            String c = e.getActionCommand();

            // actions des boutons du haut
            if (c.equals("Avancer")) {
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
            } else if(c.equals("Add Tortue")) {
                JComboBox cb = (JComboBox) e.getSource();
                String forme = (String)cb.getSelectedItem();
                int color = colorList.getSelectedIndex();
                controleur.addTortue(forme, color);                
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
        }
    }

   public class SimpleLogoMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            controleur.selectTortue(e.getPoint());
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
       
   }
}
