/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;
import Model.Tortue;
import View.FormeStrategy.CarreTortue;
import View.FormeStrategy.TriangleTortue;
import java.awt.Polygon;

/**
 *
 * @author Epulapp
 */
public class FeuilleDessin extends JPanel {

    private ArrayList<Tortue> tortues; // la liste des tortues enregistrees

    public FeuilleDessin() {
        tortues = new ArrayList<Tortue>();
    }

    public void addTortue(Tortue o) {
        tortues.add(o);
    }

    public void reset() {
        for (Iterator it = tortues.iterator(); it.hasNext();) {
            Tortue t = (Tortue) it.next();
            t.reset();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color c = g.getColor();

        Dimension dim = getSize();
        g.setColor(Color.white);
        g.fillRect(0, 0, dim.width, dim.height);
        g.setColor(c);

        showTurtles(g);
    }

    public void showTurtles(Graphics g) {
        for (Iterator it = tortues.iterator(); it.hasNext();) {
            Tortue t = (Tortue) it.next();
            this.drawTurtle(g, t);
        }
    }

    private void drawTurtle(Graphics g, Tortue t) {
        Polygon p;
        g.setColor(decodeColor(t.getCoul()));
        switch (t.getForme()) {
            case RONDE:
                g.fillOval(t.getX(), t.getY(), Tortue.rp, Tortue.rp);
                return;
            case CARRE:
                p = new CarreTortue().getPolygon(t);
                break;
            case TRIANGLE:
            default:
                p = new TriangleTortue().getPolygon(t);
                break;
        }
        g.fillPolygon(p);
    }

    public Color decodeColor(int c) {
        switch (c) {
            case 0:
                return (Color.black);
            case 1:
                return (Color.blue);
            case 2:
                return (Color.cyan);
            case 3:
                return (Color.darkGray);
            case 4:
                return (Color.red);
            case 5:
                return (Color.green);
            case 6:
                return (Color.lightGray);
            case 7:
                return (Color.magenta);
            case 8:
                return (Color.orange);
            case 9:
                return (Color.gray);
            case 10:
                return (Color.pink);
            case 11:
                return (Color.yellow);
            default:
                return (Color.black);
        }
    }
}
