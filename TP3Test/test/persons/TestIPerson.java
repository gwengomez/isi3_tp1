/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons;

import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Epulapp
 */
public abstract class TestIPerson {

    protected IPerson p;
    private static GregorianCalendar before;
    private static GregorianCalendar birthdate;
    private static GregorianCalendar after;
    private static GregorianCalendar dayBefore;
    private static GregorianCalendar dayAfter;

    public TestIPerson() {
    }

    @BeforeClass
    public static void setUpClass() {
        before = new GregorianCalendar(1800, GregorianCalendar.OCTOBER, 23);
        birthdate = new GregorianCalendar(1994, GregorianCalendar.OCTOBER, 13);
        after = new GregorianCalendar(2500, GregorianCalendar.AUGUST, 17);
        dayBefore = new GregorianCalendar(1994, GregorianCalendar.OCTOBER, 12);
        dayAfter = new GregorianCalendar(1994, GregorianCalendar.OCTOBER, 14);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    //dans le but de ne pas réécrire nos tests pour chaque classe uniquement cette méthode est modifiée (instanciation de différentes classes toutes implémentants l'interface IPerson)
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test de la méthode wasBorn de l'interface IPerson On découpe notre test
     * en trois classes, soit X la date de naissance de la personne : 1ère
     * classe : date < X
     * 2nde classse : date = X
     * 3ème classe : date > X
     */
    @Test
    public void testWasBorn() {
        Assert.assertFalse(p.wasBorn(before));
        Assert.assertFalse(p.wasBorn(dayBefore));
        Assert.assertTrue(p.wasBorn(birthdate));
        Assert.assertTrue(p.wasBorn(after));
        Assert.assertTrue(p.wasBorn(dayAfter));
    }

    /**
     * Test de la méthode getAge de l'interface IPerson On découpe notre test en
     * trois classes, soit X la date de naissance de la personne : 1ère classe :
     * date < X (cf testGetAgeInvalid)
     * 2nde classse : date = X
     * 3ème classe : date > X
     */
    @Test
    public void testGetAge() {
        Assert.assertEquals(0, p.getAge(birthdate));
        Assert.assertEquals(505, p.getAge(after));
        Assert.assertEquals(0, p.getAge(dayAfter));
    }

    /**
     * cf commentaire précédent
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetAgeInvalid1() {
        p.getAge(before);
    }

    /**
     * cf commentaire précédent
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetAgeInvalid2() {
        p.getAge(dayBefore);
    }

}
