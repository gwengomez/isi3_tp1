
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Epulapp
 */
public class Main {
        /**
     * @param args Create and display the window
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //TODO
                //build Tortue
                //Build controller passing tortue as parameter
                //Build UI passing tortue and controller as parameter
                logoInit.SimpleLogo fenetre = new logoInit.SimpleLogo();
                fenetre.setVisible(true);
            }
        });

    }
}