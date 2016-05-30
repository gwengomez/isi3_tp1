/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Forme;
import Model.TortueAutonome;
import Model.TortueFlocking;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Erwan
 */
public class FlockingController extends AbstractTortuesController {

    //private ArrayList<TortueAutonome> tortues;
    private Thread t;
    private GameLoop gl;

    @Override
    protected void generateTortues(int n) {
        Random rand = new Random();
        Dimension d = this.v.getFeuilleDimension();
        for (int i = 0; i < n; i++) {
            int x = rand.nextInt(d.width);
            int y = rand.nextInt(d.height);
            int forme = rand.nextInt(3) + 1; //between 1 and 3
            Forme f;
            switch (forme) {
                case 1:
                    f = Forme.CARRE;
                    break;
                case 2:
                    f = Forme.RONDE;
                    break;
                case 3:
                default:
                    f = Forme.TRIANGLE;
                    break;
            }
            int vitesse = rand.nextInt(5) + 1; // between 1 and 15
            int dir = rand.nextInt(361); //between 0 and 360
            TortueFlocking t = new TortueFlocking(x, y, dir, 0, f, vitesse);
            this.tortues.add(t);
            t.addObserver(v);
            this.v.registerTortue(t);
        }
    }

    @Override
    public void stop() {
        this.gl.setGameRunning(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void init() {
        TortueAutonome.setFieldBoundaries(this.v.getFeuilleDimension().width, this.v.getFeuilleDimension().height);
        this.tortues = new ArrayList<>();
        generateTortues(30);
        TortueFlocking.tortues = this.tortues;
        gl = new FlockingLoop(tortues);
        t = new Thread(gl);
        t.start();
    }
}
