/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelTest;

import Model.Forme;
import Model.Tortue;
import Model.TortueAutonome;
import Model.TortueFlocking;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Epulapp
 */
public class TestTortueFlocking extends TestTortueAutonome {

    ArrayList<TortueAutonome> inVision;
    ArrayList<TortueAutonome> inRange;
    ArrayList<TortueAutonome> farAway;
    ArrayList<Tortue> all;

    public TestTortueFlocking() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.t = new TortueFlocking();
        this.all = new ArrayList<>();
        this.inVision = new ArrayList<>();
        this.inRange = new ArrayList<>();
        this.farAway = new ArrayList<>();

        this.all.add((TortueAutonome) this.t);

        //Tortue in vision (and are also in range)
        for (int i = 0; i < 3; i++) {
            TortueAutonome te = new TortueAutonome();
            te.avancer((i + 1) * 3); //Tortue will be ahead of our default Tortue
            this.inVision.add(te);
            this.inRange.add(te);
            this.all.add(te);
        }

        //Tortue only in range
        for (int i = 0; i < 3; i++) {
            TortueAutonome te = new TortueAutonome();
            te.setDir(this.t.getDir() + 180); //go in opposite direction
            te.avancer((i + 1) * 3); //Tortue will be behind our default Tortue
            this.inRange.add(te);
            this.all.add(te);
        }

        for (int i = 0; i < 3; i++) {
            TortueAutonome te = new TortueAutonome();
            te.setDir(this.t.getDir() + 180); //go in opposite direction
            te.avancer((i + 1) * 100); //Tortue will be far away behind
            this.farAway.add(te);
            this.all.add(te);
        }

        for (int i = 0; i < 3; i++) {
            TortueAutonome te = new TortueAutonome();
            te.setDir(this.t.getDir()); //go in same direction
            te.avancer((i + 1) * 100); //Tortue will be far away beyond
            this.farAway.add(te);
            this.all.add(te);
        }

        TortueFlocking.tortues = this.all;
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testInVision() {
        ArrayList<TortueAutonome> toTest = ((TortueFlocking) this.t).getTortueInVision();
        assertArrayEquals(this.inVision.toArray(), toTest.toArray());
        for (TortueAutonome te : this.farAway) {
            assertEquals(toTest.contains(te), false);
        }
    }

    @Test
    public void testInRange() {
        ArrayList<TortueAutonome> toTest = ((TortueFlocking) this.t).getTortueInRange();
        assertArrayEquals(this.inRange.toArray(), toTest.toArray());
        for (TortueAutonome te : this.farAway) {
            assertEquals(toTest.contains(te), false);
        }
    }
}
