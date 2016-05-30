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
 * @author Epulapp
 */
public class AutonomeLoop extends GameLoop {

    public AutonomeLoop(ArrayList<Tortue> tortues) {
        super(tortues);
    }

    @Override
    protected void doGameUpdates(double delta) {
        for (Tortue t : tortues) {
            for (int i = 0; i < delta; i++) {
                ((TortueAutonome)t).nextStep();
            }
        }
    }

}
