/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Model.Tortue;

import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author Erwan
 */
public class BoundingBox {
    
    public static boolean isInTortue(Point p, Tortue t) {
        switch (t.getForme()) {
            case RONDE:
                return isInTortueRonde(p, t);
            case CARRE:
                return isInTortueCarre(p, t);
            case TRIANGLE:
            default:
                return isInTortueTriangle(p, t);
        }
    }

    private static boolean isInTortueRonde(Point p, Tortue t) {
        float distance = (float)Math.sqrt(Math.pow(t.getX() - p.x, 2) + Math.pow(t.getY() - p.y, 2));
        return distance <= Tortue.rp;
    }

    private static boolean isInTortueCarre(Point p, Tortue t) {
        return GetCarre(t.getX(), t.getY(), Tortue.rp).contains(p);
    }

    private static boolean isInTortueTriangle(Point p, Tortue t) {
        return GetTriangle(t.getX(), t.getY(), Tortue.ratioDegRad, t.getDir(), Tortue.rb, Tortue.rp).contains(p);
    }
    
    public static Polygon GetCarre(int x, int y, int cote) {
         //Calcule les 4 coins du carré a partir de la position de la tortue p
        Point p = new Point(x, y);
        Polygon carre = new Polygon();
        
        int sideLength = cote;
        
        carre.addPoint(x, y);
        carre.addPoint(x + sideLength, y);
        carre.addPoint(x + sideLength, y + sideLength);
        carre.addPoint(x, y + sideLength);
        
        return carre;
    }
    
    public static Polygon GetTriangle(int x, int y, double angle, int dir, int base, int pointe) {
        //Calcule les 3 coins du triangle a partir de x et y
        Point p = new Point(x, y);
        Polygon arrow = new Polygon();

        //Calcule des deux bases
        //Angle de la droite
        double theta = angle * (-dir);
        //Demi angle au sommet du triangle
        double alpha = Math.atan((float) base / (float) pointe);
        //Rayon de la fleche
        double r = Math.sqrt(pointe * pointe + base * base);
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
