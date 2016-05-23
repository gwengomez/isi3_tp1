
import Controller.LogoController;
import Model.Forme;
import Model.Tortue;
import View.ModeChooser;
import View.SimpleLogoOLD;
import java.awt.Dimension;
import java.awt.Toolkit;
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
                ModeChooser m = new ModeChooser();
                //center approximatively the window
                Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                m.setLocation((dimension.width / 2) - (m.getWidth() / 2), (dimension.height / 2) - (m.getHeight()));
                m.setVisible(true);
            }
        });

    }
}
