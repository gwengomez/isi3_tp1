/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.FormeStrategy;

import Model.Tortue;
import Tools.BoundingBox;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author Epulapp
 */
public class CarreTortue implements DrawingStrategy{

    @Override
    public void draw(Tortue t, Graphics g) {     
        g.fillPolygon(BoundingBox.GetCarre(t.getX(), t.getY(), Tortue.rp));
    }
    
}
