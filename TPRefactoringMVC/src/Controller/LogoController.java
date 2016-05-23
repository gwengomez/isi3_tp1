/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Forme;
import Model.Tortue;
import Tools.BoundingBox;
import View.SimpleLogo;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Epulapp
 */
public class LogoController{

    private Tortue courante;
    private SimpleLogo v;
    private ArrayList<Tortue> tortues;

    public LogoController(SimpleLogo v) {
        this.v = v;
        this.tortues = new ArrayList<>();      
        this.v.registerController(this);
        this.addTortue("triangle", 0);
    }

    public void reset() {
       for(Tortue t : tortues) {
           t.reset();
       }    
    }
    
    public void avancer(int v) {     
        courante.avancer(v);
    }

    public void droite(int v) {
        courante.droite(v);
    }

    public void gauche(int v) {
        courante.gauche(v);
    }

    public void colorerCrayon(int v) {
        courante.setCoul(v % 12);
    }

    public void carre() {
        courante.carre();
    }

    public void poly(int n, int a) {
        courante.poly(n, a);
    }

    public void spiral(int n, int k, int a) {
        courante.spiral(n, k, a);
    }

    public void moveTo(int x, int y) {
        this.courante.setX(x);
        this.courante.setY(y);
    }

    public void addTortue(String forme, int color) {
        Forme f;
        switch(forme) {
            case "ronde":
                f = Forme.RONDE;
                break;
            case "triangle":
                f = Forme.TRIANGLE;
                break;
            case "carré":
            default:
                f = Forme.CARRE;
                break;
        }
        this.courante = new Tortue(f);
        this.courante.setCoul(color);
        this.tortues.add(courante);
        this.v.registerTortue(courante);
        Dimension d = this.v.getFeuilleDimension();
        this.courante.setX(d.width/2);
        this.courante.setY(d.height/2);
    }

    public void selectTortue(Point p) {
        for(Tortue t : this.tortues) {
            if(BoundingBox.isInTortue(p, t)) {
                this.courante = t;
                break;
            }
        }
    }
}
