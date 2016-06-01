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
    protected static int maxX, maxY;

    public TortueAutonome(int x, int y, int dir, int coul, Forme forme, int vitesse) {
        super(x, y, dir, coul, forme);
        this.vitesse = vitesse;
    }

    public TortueAutonome(Forme f, int vitesse, int dir) {
        this(0, 0, dir, 0, f, vitesse);
    }
    
    public TortueAutonome() {
        super();
        this.vitesse = 20;
    }

    public static void setFieldBoundaries(int maxX, int maxY) {
        TortueAutonome.maxX = maxX;
        TortueAutonome.maxY = maxY;
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

        if (this.x > maxX) {
            this.x = this.x - maxX;
        } else if (this.x < 0) {
            this.x = maxX + this.x;
        }
        if (this.y > maxY) {
            this.y = this.y - maxY;
        } else if (this.y < 0) {
            this.y = maxY + this.y;
        }
        this.setChangedAndNotify();
    }
}
