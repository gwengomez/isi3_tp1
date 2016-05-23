/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Tortue;
import Model.TortueAutonome;
import View.TortuesView;
import java.util.ArrayList;

/**
 *
 * @author Epulapp
 */
public class TortuesController {
    private TortuesView v;
    private ArrayList<TortueAutonome> tortues;

    public TortuesController(TortuesView v) {
        this.v = v;
        this.tortues = new ArrayList<>();      
        generateTortues(10);
        
    }
    
    private void generateTortues(int n) {
        
    }
    
}
