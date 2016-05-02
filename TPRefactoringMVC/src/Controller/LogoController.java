/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Tortue;
import java.awt.Dimension;
//import View.SimpleLogo;

/**
 *
 * @author Epulapp
 */
public class LogoController {

    //private SimpleLogo view;
    private Tortue tortue;

    public LogoController(Tortue tortue) {
        this.tortue = tortue;
    }

    public void avancer(int v) {        
        tortue.avancer(v);
    }

    public void droite(int v) {
        tortue.droite(v);
    }

    public void gauche(int v) {
        tortue.gauche(v);
    }

    public void colorerCrayon(int v) {
        tortue.setCoul(v % 12);
    }

    public void carre() {
        tortue.carre();
    }

    public void poly(int n, int a) {
        tortue.poly(n, a);
    }

    public void spiral(int n, int k, int a) {
        tortue.spiral(n, k, a);
    }

    public void reset() {
        tortue.reset();
    }

    public void moveToCenter(Dimension dimension) {
        this.tortue.setX((int) (dimension.getWidth()/2));
        this.tortue.setY((int) (dimension.getHeight()/2));
    }
}
