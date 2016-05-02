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
public class CarreTortue implements DrawingStrategy{

    @Override
    public Polygon getPolygon(Tortue t) {
        //Calcule les 3 coins du triangle a partir de
        // la position de la tortue p
        int x = t.getX();
        int y = t.getY();
        Point p = new Point(x, y);
        Polygon carre = new Polygon();
        
        int sideLength = Tortue.rp;
        
        carre.addPoint(x, y);
        carre.addPoint(x + sideLength, y);
        carre.addPoint(x + sideLength, y + sideLength);
        carre.addPoint(x, y + sideLength);
        
        return carre;
    }
    
}
