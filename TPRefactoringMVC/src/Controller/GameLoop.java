/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Tortue;
import java.util.ArrayList;

/**
 *
 * @author Epulapp
 */
public abstract class GameLoop implements Runnable {

    private volatile boolean gameRunning = true;
    protected ArrayList<Tortue> tortues;

    public GameLoop(ArrayList<Tortue> tortues) {
        this.tortues = tortues;
    }

    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }

    @Override
    public void run() {
        this.gameLoop();
    }
    
    public boolean isGameRunning() {
        return this.gameRunning;
    }

    public void gameLoop() {
        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

        // keep looping round til the game ends
        while (gameRunning) {
            // work out how long its been since the last update, this
            // will be used to calculate how far the entities should
            // move this loop
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double) OPTIMAL_TIME);

            // update the game logic
            doGameUpdates(delta);

            // we want each frame to take 10 milliseconds, to do this
            // we've recorded when we started the frame. We add 10 milliseconds
            // to this and then factor in the current time to give 
            // us our final value to wait for
            // remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
            try {
                long a = (lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000;
                Thread.sleep(a);
            } catch (Exception e) {

            }
        }
    }

    /*private void doGameUpdates(double delta) {
        for (TortueAutonome t : tortues) {
           for(int i = 0; i < delta; i++) {
               t.nextStep();
           }
        }
    }*/
    
    protected abstract void doGameUpdates(double delta);

}
