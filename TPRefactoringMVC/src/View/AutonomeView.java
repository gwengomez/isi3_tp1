/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AbstractTortuesController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Epulapp
 */
public class AutonomeView extends TortuesView {
    
    private AbstractTortuesController ctrl;

    @Override
    public void addComponents() {
        addMenuItem(this.menuFile, "Stop", "Stop", -1);
    }

    @Override
    public void setActionListener() {
        this.listener = new TortuesViewListener();
    }
    
    public void registerController(AbstractTortuesController c) {
        this.ctrl = c;
    }

    public class TortuesViewListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String c = e.getActionCommand();
            if (c.equals("Quitter")) {
                quitter();
            } else if(c.equals("Stop")) {
                ctrl.stop();
            }
        }
    }

}
