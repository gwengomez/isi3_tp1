package Model;

import java.util.Observable;

/**
 * ***********************************************************************
 *
 * Un petit Logo minimal qui devra etre ameliore par la suite
 *
 * Source originale : J. Ferber - 1999-2001
 *
 * Cours de DESS TNI - Montpellier II
 *
 * @version 2.0
 * @date 25/09/2001
 *
 *************************************************************************
 */
public class Tortue extends Observable {

    protected int x, y;
    protected int dir;
    protected int coul;
    protected Forme forme;
    public static final double ratioDegRad = 0.0174533;
    public static final int rp = 10, rb = 5; // Taille de la pointe et de la base de la fleche

    public Tortue(int x, int y, int dir, int coul, Forme forme) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.coul = coul;
        this.forme = forme;
    }

    public Tortue() {
        this(0, 0, -90, 0, Forme.TRIANGLE);
    }

    public Tortue(Forme f) {
        this(0, 0, -90, 0, f);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        this.setChangedAndNotify();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getCoul() {
        return coul;
    }

    public void setCoul(int coul) {
        this.coul = coul;
        this.setChangedAndNotify();
    }

    public Forme getForme() {
        return forme;
    }

    public void setForme(Forme forme) {
        this.forme = forme;
        this.setChangedAndNotify();
    }

    public void reset() {
        x = 0;
        y = 0;
        dir = -90;
        coul = 0;
    }

    private void setChangedAndNotify() {
        this.setChanged();
        this.notifyObservers();
    }

    public void avancer(int v) {

        this.x = (int) Math.round(x + v * Math.cos(ratioDegRad * this.dir));
        this.y = (int) Math.round(y + v * Math.sin(ratioDegRad * this.dir));
        this.setChangedAndNotify();
    }

    public void droite(int v) {
        this.dir = (this.dir + v) % 360;
        this.setChangedAndNotify();
    }

    public void gauche(int v) {
        this.dir = (this.dir - v) % 360;
        this.setChangedAndNotify();
    }

    public void spiral(int n, int k, int a) {
        for (int i = 0; i < k; i++) {
            couleur(this.getCoul() + 1);
            avancer(n);
            droite(360 / a);
            n = n + 1;
        }
    }

    public void couleur(int n) {
        this.setCoul(n % 12);
    }

    public void poly(int n, int a) {
        for (int j = 0; j < a; j++) {
            avancer(n);
            droite(360 / a);
        }
    }

    public void carre() {
        for (int i = 0; i < 4; i++) {
            avancer(100);
            droite(90);
        }
    }
}
