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
public class LogoController{
    private SimpleLogo view;
    private Tortue tortue;
    private static final double ratioDegRad = 0.0174533;

    public LogoController(SimpleLogo view, Tortue tortue) {
        this.view = view;
        this.tortue = tortue;
    }
    
    public void avancer(int v) {
        
        int newX = (int) Math.round(tortue.getX() + v * Math.cos(ratioDegRad * tortue.getDir()));
        int newY = (int) Math.round(tortue.getY() + v * Math.sin(ratioDegRad * tortue.getDir()));

        tortue.setX(newX);
        tortue.setY(newY);
    }
    
    public void droite(int v) {
        tortue.setDir((tortue.getDir() + v) % 360);
    }
    
    public void gauche(int v) {
        tortue.setDir((tortue.getDir() - v) % 360);
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
}
