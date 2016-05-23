/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Epulapp
 */
public class AutonomeView extends TortuesView {

    @Override
    public void addComponents() {}

    @Override
    public void setActionListener() {
        this.listener = new TortuesViewListener();
    }

    public class TortuesViewListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String c = e.getActionCommand();
            if (c.equals("Quitter")) {
                quitter();
            }
        }
    }

}
