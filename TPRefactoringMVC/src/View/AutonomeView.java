/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AbstractTortuesController;
import java.awt.event.ActionListener;

/**
 *
 * @author Epulapp
 */
public class AutonomeView extends TortuesView {
    
    private AbstractTortuesController ctrl;

    public AutonomeView(ActionListener l) {
        super(l);
    }

    @Override
    public void addComponents() {
        addMenuItem(this.menuFile, "Stop", "Stop", -1);
    }
}
