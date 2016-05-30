/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Tortue;
import View.TortuesView;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Erwan
 */
public abstract class AbstractTortuesController implements ActionListener {

    protected TortuesView v;
    protected ArrayList<Tortue> tortues;
    
    public AbstractTortuesController() {
        this.tortues = new ArrayList<>();
    }
    
    protected abstract void generateTortues(int n);
   
    public abstract void stop();
    
    public void setView(TortuesView v) {
        this.v = v;
    }
    
    public abstract void init();
}
