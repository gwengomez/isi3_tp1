/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Tortue;
import View.SimpleLogo;

/**
 *
 * @author Epulapp
 */
public class LogoController {

    private SimpleLogo view;
    private Tortue tortue;

    public LogoController(SimpleLogo view, Tortue tortue) {
        this.view = view;
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

    public void leverCrayon() {
        tortue.setCrayon(false);
    }

    public void baisserCrayon() {
        tortue.setCrayon(true);
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
}
