/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Forme;
import Model.TortueAutonome;
import View.AutonomeView;
import View.TortuesView;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Epulapp
 */
public class TortuesController {

    private TortuesView v;
    private ArrayList<TortueAutonome> tortues;
    private Thread t;
    private GameLoop gl;

    public TortuesController(TortuesView v) {
        this.v = v;
        ((AutonomeView)this.v).registerController(this);
        this.tortues = new ArrayList<>();
        generateTortues(20);
        gl = new GameLoop(tortues);
        t = new Thread(gl);
        t.start();

    }

    private void generateTortues(int n) {
        Random rand = new Random();
        Dimension d = this.v.getFeuilleDimension();
        int x = d.width / 2;
        int y = d.height / 2;
        for (int i = 0; i < n; i++) {
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
            int vitesse = rand.nextInt(10) + 1; // between 1 and 10
            int dir = rand.nextInt(361); //between 0 and 360
            TortueAutonome t = new TortueAutonome(x, y, dir, 0, f, vitesse, d.width, d.height);
            this.tortues.add(t);
            t.addObserver(v);
            this.v.registerTortue(t);
        }
    }
    
    public void stop() {
        this.gl.gameRunning = false;
    }
}
