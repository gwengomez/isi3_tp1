/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.FormeStrategy;

import Model.Tortue;
import Tools.BoundingBox;
import java.awt.Graphics;

/**
 *
 * @author Epulapp
 */
public class TriangleTortue implements DrawingStrategy {

    @Override
    public void draw(Tortue t, Graphics g) {
        g.fillPolygon(BoundingBox.GetTriangle(t.getX(), t.getY(), Tortue.ratioDegRad, t.getDir(), Tortue.rb, Tortue.rp));
    }
    
}
