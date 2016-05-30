/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.FormeStrategy;

import Model.Forme;

/**
 *
 * @author Epulapp
 */
public class DrawingStrategyFactory {

    public DrawingStrategy getStrategy(Forme f) {
        switch (f) {
            case RONDE:
                return new RondeTortue();
            case CARRE:
                return new CarreTortue();
            case TRIANGLE:
            default:
                return new TriangleTortue();
        }
    }
}
