/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Forme;
import Model.TortueAutonome;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Epulapp
 */
public class TortuesController extends AbstractTortuesController {

    private Thread t;
    private GameLoop gl;

    @Override
    protected void generateTortues(int n) {
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
            int vitesse = rand.nextInt(20) + 1; // between 1 and 10
            int dir = rand.nextInt(361); //between 0 and 360
            TortueAutonome t = new TortueAutonome(x, y, dir, 0, f, vitesse);
            this.tortues.add(t);
            t.addObserver(v);
            this.v.registerTortue(t);
        }
    }

    public void stop() {
        this.gl.setGameRunning(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();
        if (c.equals("Quitter")) {
            this.v.quitter();
        } else if (c.equals("Stop")) {
            this.stop();
        }
    }

    @Override
    public void init() {
        TortueAutonome.setFieldBoundaries(this.v.getFeuilleDimension().width, this.v.getFeuilleDimension().height);
        this.tortues = new ArrayList<>();
        generateTortues(20);
        gl = new AutonomeLoop(tortues);
        t = new Thread(gl);
        t.start();
    }
}
