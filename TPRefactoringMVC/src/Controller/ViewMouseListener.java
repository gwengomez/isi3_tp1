/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Epulapp
 */
public class ViewMouseListener implements MouseListener{
    
    private LogoController ctrl;
    
    public ViewMouseListener(LogoController ctrl) {
        this.ctrl = ctrl;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.ctrl.selectTortue(e.getPoint());
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
