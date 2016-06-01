/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelTest;

import Model.TortueAutonome;
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
public class TestTortueAutonome extends TestTortue{

    
    public TestTortueAutonome() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        t = new TortueAutonome();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testVitesse() {
        int[] v = {0, 10, 20, 30};
        for(int i = 0; i < v.length; i++) {
            ((TortueAutonome)this.t).setVitesse(v[i]);
            assertEquals(v[i], ((TortueAutonome)this.t).getVitesse());
        }
    }
}
