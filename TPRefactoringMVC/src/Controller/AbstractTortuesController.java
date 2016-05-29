/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Forme;
import Model.TortueAutonome;
import View.AutonomeView;
import View.TortuesView;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Erwan
 */
public abstract class AbstractTortuesController {

    protected abstract void generateTortues(int n);
   
    public abstract void stop();
}
