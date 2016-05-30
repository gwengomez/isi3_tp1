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
import View.TortuesView;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Epulapp
 */
public class LogoController extends AbstractTortuesController implements ActionListener {

    private Tortue courante;
    private ArrayList<Tortue> tortues;
    private SimpleLogo sLogoView;

    public void reset() {
        for (Tortue t : tortues) {
            t.reset();
        }
    }
    
    public void setSimpleLogo(TortuesView v) {
        super.setView(v);
        this.sLogoView = (SimpleLogo)v;
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
        switch (forme) {
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
        this.courante.setX(d.width / 2);
        this.courante.setY(d.height / 2);
    }

    public void selectTortue(Point p) {
        for (Tortue t : this.tortues) {
            if (BoundingBox.isInTortue(p, t)) {
                this.courante = t;
                break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();

        // actions des boutons du haut
        if (c.equals("Avancer")) {
            try {
                int v = Integer.parseInt(this.sLogoView.getInputValue());
                this.avancer(v);
            } catch (NumberFormatException ex) {
                System.err.println("ce n'est pas un nombre : " + this.sLogoView.getInputValue());
            }

        } else if (c.equals("Droite")) {
            try {
                int v = Integer.parseInt(this.sLogoView.getInputValue());
                this.droite(v);
            } catch (NumberFormatException ex) {
                System.err.println("ce n'est pas un nombre : " + this.sLogoView.getInputValue());
            }
        } else if (c.equals("Gauche")) {
            try {
                int v = Integer.parseInt(this.sLogoView.getInputValue());
                this.gauche(v);
            } catch (NumberFormatException ex) {
                System.err.println("ce n'est pas un nombre : " + this.sLogoView.getInputValue());
            }
        } else if (c.equals("Add Tortue")) {
            JComboBox cb = (JComboBox) e.getSource();
            String forme = (String) cb.getSelectedItem();
            int color = this.sLogoView.getColorListIndex();
            this.addTortue(forme, color);
        } else if (c.equals("Colorer")) {
            JComboBox cb = (JComboBox) e.getSource();
            int n = cb.getSelectedIndex();
            this.colorerCrayon(n);
        }// actions des boutons du bas
        else if (c.equals("Proc1")) {
            this.carre();
        } else if (c.equals("Proc2")) {
            this.poly(60, 8);
        } else if (c.equals("Proc3")) {
            this.spiral(50, 40, 6);
        } else if (c.equals("Effacer")) {
            this.sLogoView.effacer();
            this.reset();
        } else if (c.equals("Quitter")) {
            this.v.quitter();
        }
    }

    @Override
    protected void generateTortues(int n) {

    }

    @Override
    public void stop() {
        
    }

    @Override
    public void init() {
        this.v.addMyMouseListener(new ViewMouseListener(this));
        this.tortues = new ArrayList<>();
        this.addTortue("triangle", 0);
    }
}
