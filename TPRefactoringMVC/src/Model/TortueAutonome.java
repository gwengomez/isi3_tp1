/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;

/**
 *
 * @author Epulapp
 */
public class TortueAutonome extends Tortue {

    private int vitesse;
    private int maxX, maxY;

    public TortueAutonome(int x, int y, int dir, int coul, Forme forme, int vitesse, int maxX, int maxY) {
        super(x, y, dir, coul, forme);
        this.vitesse = vitesse;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public TortueAutonome(int maxX, int maxY) {
        this(0, 0, -90, 0, Forme.TRIANGLE, 45, maxX, maxY);
    }

    public TortueAutonome(Forme f, int vitesse, int dir, int maxX, int maxY) {
        this(0, 0, dir, 0, f, vitesse, maxX, maxY);
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public void nextStep() {
        Random rand = new Random();
        int dirChange = rand.nextInt(91) - 45; //between -45 and 45
        
        this.dir += dirChange;        
        this.x = (int) Math.round(x + this.vitesse * Math.cos(ratioDegRad * this.dir));
        this.y = (int) Math.round(y + this.vitesse * Math.sin(ratioDegRad * this.dir));
        
        if(this.x > this.maxX) {
            this.x = this.x - this.maxX;
        } else if(this.x < 0) {
            this.x = this.maxX + this.x;
        }
        if(this.y > this.maxY) {
            this.y = this.y - this.maxY;
        } else if(this.y < 0) {
            this.y = this.maxY + this.y;
        }
        this.setChangedAndNotify();
    }
}
