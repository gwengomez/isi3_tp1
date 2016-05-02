/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.FormeStrategy;

import Model.Tortue;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author Epulapp
 */
public class TriangleTortue implements DrawingStrategy {

    @Override
    public Polygon getPolygon(Tortue t) {
         //Calcule les 3 coins du triangle a partir de
        // la position de la tortue p
        int x = t.getX();
        int y = t.getY();
        Point p = new Point(x, y);
        Polygon arrow = new Polygon();

        //Calcule des deux bases
        //Angle de la droite
        double theta = Tortue.ratioDegRad * (-t.getDir());
        //Demi angle au sommet du triangle
        double alpha = Math.atan((float) Tortue.rb / (float) Tortue.rp);
        //Rayon de la fleche
        double r = Math.sqrt(Tortue.rp * Tortue.rp + Tortue.rb * Tortue.rb);
		//Sens de la fleche

        //Pointe
        Point p2 = new Point((int) Math.round(p.x + r * Math.cos(theta)),
                (int) Math.round(p.y - r * Math.sin(theta)));
        arrow.addPoint(p2.x, p2.y);
        arrow.addPoint((int) Math.round(p2.x - r * Math.cos(theta + alpha)),
                (int) Math.round(p2.y + r * Math.sin(theta + alpha)));

        //Base2
        arrow.addPoint((int) Math.round(p2.x - r * Math.cos(theta - alpha)),
                (int) Math.round(p2.y + r * Math.sin(theta - alpha)));

        return arrow;
    }
    
}
