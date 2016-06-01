/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelTest;

import Model.Forme;
import Model.Tortue;
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
public class TestTortue {

    Tortue t;

    public TestTortue() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        t = new Tortue();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testDefault() {
        assertEquals(0, t.getX());
        assertEquals(0, t.getY());
        assertEquals(-90, t.getDir());
        assertEquals(0, t.getCoul());
        assertEquals(Forme.TRIANGLE, t.getForme());
    }

    @Test
    public void testPosition() {
        int[] pos = {0, 10, 50, 100, 1000};
        for (int i = 0; i < pos.length; i++) {
            t.setX(pos[i]);
            for (int k = 0; k < pos.length; k++) {
                t.setY(pos[k]);
                assertEquals(pos[i], this.t.getX());
                assertEquals(pos[k], this.t.getY());
            }
            for (int k = 0; k < pos.length; k++) {
                t.setY(-pos[k]);
                assertEquals(pos[i], this.t.getX());
                assertEquals(-pos[k], this.t.getY());
            }
        }

        for (int i = 0; i < pos.length; i++) {
            t.setX(-pos[i]);
            for (int k = 0; k < pos.length; k++) {
                t.setY(pos[k]);
                assertEquals(-pos[i], this.t.getX());
                assertEquals(pos[k], this.t.getY());
            }
            for (int k = 0; k < pos.length; k++) {
                t.setY(-pos[k]);
                assertEquals(-pos[i], this.t.getX());
                assertEquals(-pos[k], this.t.getY());
            }
        }
    }

    @Test
    public void testCoul() {
        for (int i = 0; i < 12; i++) {
            this.t.setCoul(i);
            assertEquals(i, this.t.getCoul());
        }
    }

    @Test
    public void testReset() {
        t.setX(852);
        t.setY(78);
        t.setDir(41);
        t.setCoul(5);
        t.reset();

        assertEquals(0, t.getX());
        assertEquals(0, t.getY());
        assertEquals(-90, t.getDir());
        assertEquals(0, t.getCoul());
    }

    @Test
    public void testForme() {
        this.t.setForme(Forme.RONDE);
        assertEquals(Forme.RONDE, this.t.getForme());
        this.t.setForme(Forme.CARRE);
        assertEquals(Forme.CARRE, this.t.getForme());
        this.t.setForme(Forme.TRIANGLE);
        assertEquals(Forme.TRIANGLE, this.t.getForme());
    }

    @Test
    public void testDroiteGauche() {
        int originDir = this.t.getDir();

        for (int i = 0; i <= 360; i += 10) {
            this.t.droite(i);
            assertEquals((originDir + i) % 360, this.t.getDir());
            this.t.setDir(originDir);
        }

        for (int i = 0; i <= 360; i += 10) {
            this.t.gauche(i);
            assertEquals((originDir - i) % 360, this.t.getDir());
            this.t.setDir(originDir);
        }

    }

    @Test
    public void testAvancer() {

        int[] dirs = new int[]{0, 45, 90, 135, 180, 225, 270, 315, 360};
        int[] vitesse = new int[]{0, 5, 10, 20};

        int x = this.t.getX();
        int y = this.t.getY();

        //positive direction
        for (int i = 0; i < dirs.length; i++) {
            for (int k = 0; k < vitesse.length; k++) {
                this.t.setDir(dirs[i]);
                this.t.avancer(vitesse[k]);
                assertEquals((int) Math.round(x + vitesse[k] * Math.cos(Tortue.ratioDegRad * dirs[i])), this.t.getX());
                assertEquals((int) Math.round(y + vitesse[k] * Math.sin(Tortue.ratioDegRad * dirs[i])), this.t.getY());
                this.t.reset();
            }
        }

        //negative direction
        for (int i = 0; i < dirs.length; i++) {
            for (int k = 0; k < vitesse.length; k++) {
                this.t.setDir(-dirs[i]);
                this.t.avancer(vitesse[k]);
                assertEquals((int) Math.round(x + vitesse[k] * Math.cos(Tortue.ratioDegRad * -dirs[i])), this.t.getX());
                assertEquals((int) Math.round(y + vitesse[k] * Math.sin(Tortue.ratioDegRad * -dirs[i])), this.t.getY());
                this.t.reset();
            }
        }

    }

    @Test
    public void testPoly() {
        int x = t.getX(), y = t.getY();
        t.poly(y, y);
        assertEquals(x, this.t.getX());
        assertEquals(y, this.t.getY());
    }

    @Test
    public void testCarre() {
        int x = t.getX(), y = t.getY();
        t.carre();
        assertEquals(x, this.t.getX());
        assertEquals(y, this.t.getY());
    }

    @Test
    public void testSpiral() {
        int k = 8, n = 20, a = 30;
        int x = this.t.getX();
        int y = this.t.getY();
        int dir = this.t.getDir();
        for (int i = 0; i < k; i++) {
            x = (int) Math.round(x + n * Math.cos(Tortue.ratioDegRad * dir));
            y = (int) Math.round(y + n * Math.sin(Tortue.ratioDegRad * dir));
            dir = (dir + (360 / a)) % 360;
            n = n + 1;
        }
        k = 8;
        n = 20;
        a = 30;
        this.t.spiral(n, k, a);
        
        assertEquals(x, this.t.getX());
        assertEquals(y, this.t.getY());
    }

}
