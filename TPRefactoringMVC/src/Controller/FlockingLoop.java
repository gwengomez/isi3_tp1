/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Tortue;
import Model.TortueAutonome;
import java.util.ArrayList;

/**
 *
 * @author Erwan
 */
public class FlockingLoop extends GameLoop {
    
    public FlockingLoop(ArrayList<Tortue> tortues) {
        super(tortues);
    }

    @Override
    protected void doGameUpdates(double delta) {
        for (Tortue t : tortues) {
            ((TortueAutonome)t).nextStep();
        }
    }

}
