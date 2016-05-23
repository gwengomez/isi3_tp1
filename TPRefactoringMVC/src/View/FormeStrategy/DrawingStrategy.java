/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.FormeStrategy;

import Model.Tortue;
import java.awt.Graphics;

/**
 *
 * @author Epulapp
 */
public interface DrawingStrategy {
    public void draw(Tortue t, Graphics g);
}
