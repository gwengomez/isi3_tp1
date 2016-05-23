/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Epulapp
 */
public class TortueAutonome extends Tortue {
    
    private int vitesse;
    
    public TortueAutonome(int x, int y, int dir, int coul, Forme forme, int vitesse) {
        super(x, y, dir, coul, forme);
        this.vitesse = vitesse;
    }
    
    public TortueAutonome() {
        this(0, 0, -90, 0, Forme.TRIANGLE, 45);
    }
    
    public TortueAutonome(Forme f, int vitesse) {
        this(0, 0, -90, 0, f, vitesse);
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }
    
    public void avancer() {
        this.avancer(this.vitesse);
    }
}
