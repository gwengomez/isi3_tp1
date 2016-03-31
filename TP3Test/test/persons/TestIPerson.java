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
    
    private static GregorianCalendar ybmbdb;
    private static GregorianCalendar ybmbd;
    private static GregorianCalendar ybmbda;
    private static GregorianCalendar ybmdb;
    private static GregorianCalendar ybmd;
    private static GregorianCalendar ybmda;
    private static GregorianCalendar ybmadb;
    private static GregorianCalendar ybmad;
    private static GregorianCalendar ybmada;
    
    private static GregorianCalendar yambdb;
    private static GregorianCalendar yambd;
    private static GregorianCalendar yambda;
    private static GregorianCalendar yamdb;
    private static GregorianCalendar yamd;
    private static GregorianCalendar yamda;
    private static GregorianCalendar yamadb;
    private static GregorianCalendar yamad;
    private static GregorianCalendar yamada;
    
    private static GregorianCalendar ymbdb;
    private static GregorianCalendar ymbd;
    private static GregorianCalendar ymbda;
    private static GregorianCalendar ymdb;
    private static GregorianCalendar ymd;
    private static GregorianCalendar ymda;
    private static GregorianCalendar ymadb;
    private static GregorianCalendar ymad;
    private static GregorianCalendar ymada;
    
    
    private static int yb;
    private static int y;
    private static int ya;
    private static int mb;
    private static int m;
    private static int ma;
    private static int db;
    private static int d;
    private static int da;

    public TestIPerson() {
    }

    @BeforeClass
    public static void setUpClass() {
        yb = 1993;
        y = 1994;
        ya = 1995;
        mb = GregorianCalendar.SEPTEMBER;
        m = GregorianCalendar.OCTOBER;
        ma = GregorianCalendar.NOVEMBER;
        db = 12;
        d = 13;
        da = 14;
        
        ybmbdb = new GregorianCalendar(yb, mb, db);
        ybmbd = new GregorianCalendar(yb, mb, d);
        ybmbda = new GregorianCalendar(yb, mb, da);
        ybmdb = new GregorianCalendar(yb, m, db);
        ybmd = new GregorianCalendar(yb, m, d);
        ybmda = new GregorianCalendar(yb, m, da);
        ybmadb = new GregorianCalendar(yb, ma, db);
        ybmad = new GregorianCalendar(yb, ma, d);
        ybmada = new GregorianCalendar(yb, ma, da);
    
        yambdb = new GregorianCalendar(ya, mb, db);
        yambd = new GregorianCalendar(ya, mb, d);
        yambda = new GregorianCalendar(ya, mb, da);
        yamdb = new GregorianCalendar(ya, m, db);
        yamd = new GregorianCalendar(ya, m, d);
        yamda = new GregorianCalendar(ya, m, da);
        yamadb = new GregorianCalendar(ya, ma, db);
        yamad = new GregorianCalendar(ya, ma, d);
        yamada = new GregorianCalendar(ya, ma, da);
    
        ymbdb = new GregorianCalendar(y, mb, db);
        ymbd = new GregorianCalendar(y, mb, d);
        ymbda = new GregorianCalendar(y, mb, da);
        ymdb = new GregorianCalendar(y, m, db);
        ymd = new GregorianCalendar(y, m, d);
        ymda = new GregorianCalendar(y, m, da);
        ymadb = new GregorianCalendar(y, ma, db);
        ymad = new GregorianCalendar(y, ma, d);
        ymada = new GregorianCalendar(y, ma, da);
        
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
        Assert.assertFalse(p.wasBorn(ybmbdb));
        Assert.assertFalse(p.wasBorn(ybmbd));
        Assert.assertFalse(p.wasBorn(ybmbda));
        Assert.assertFalse(p.wasBorn(ybmadb));
        Assert.assertFalse(p.wasBorn(ybmad));
        Assert.assertFalse(p.wasBorn(ybmada));
        Assert.assertFalse(p.wasBorn(ybmdb));
        Assert.assertFalse(p.wasBorn(ybmd));
        Assert.assertFalse(p.wasBorn(ybmda));
        
        Assert.assertTrue(p.wasBorn(yambdb));
        Assert.assertTrue(p.wasBorn(yambd));
        Assert.assertTrue(p.wasBorn(yambda));
        Assert.assertTrue(p.wasBorn(yamadb));
        Assert.assertTrue(p.wasBorn(yamad));
        Assert.assertTrue(p.wasBorn(yamada));
        Assert.assertTrue(p.wasBorn(yamdb));
        Assert.assertTrue(p.wasBorn(yamd));
        Assert.assertTrue(p.wasBorn(yamda));
        
        Assert.assertFalse(p.wasBorn(ymbdb));
        Assert.assertFalse(p.wasBorn(ymbd));
        Assert.assertFalse(p.wasBorn(ymbda));
        Assert.assertFalse(p.wasBorn(ymdb));
        Assert.assertTrue(p.wasBorn(ymd));
        Assert.assertTrue(p.wasBorn(ymda));
        Assert.assertTrue(p.wasBorn(ymadb));
        Assert.assertTrue(p.wasBorn(ymad));
        Assert.assertTrue(p.wasBorn(ymada));
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
        Assert.assertEquals(0, p.getAge(yambdb));
        Assert.assertEquals(0, p.getAge(yambd));
        Assert.assertEquals(0, p.getAge(yambda));
        Assert.assertEquals(0, p.getAge(yamdb));
        Assert.assertEquals(1, p.getAge(yamd));
        Assert.assertEquals(1, p.getAge(yamda));
        Assert.assertEquals(1, p.getAge(yamadb));
        Assert.assertEquals(1, p.getAge(yamad));
        Assert.assertEquals(1, p.getAge(yamada));
        
        Assert.assertEquals(0, p.getAge(ymd));
        Assert.assertEquals(0, p.getAge(ymda));
        Assert.assertEquals(0, p.getAge(ymadb));
        Assert.assertEquals(0, p.getAge(ymad));
        Assert.assertEquals(0, p.getAge(ymada));
    }

    /**
     * cf commentaire précédent
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetAgeInvalidYbMbDb() {
        p.getAge(ybmbdb);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAgeInvalidYbMbD() {
        p.getAge(ybmbd);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetAgeInvalidYbMbDa() {
        p.getAge(ybmbda);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetAgeInvalidYbMaDb() {
        p.getAge(ybmadb);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetAgeInvalidYbMaD() {
        p.getAge(ybmad);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetAgeInvalidYbMaDa() {
        p.getAge(ybmada);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetAgeInvalidYbMDb() {
        p.getAge(ybmdb);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetAgeInvalidYbMD() {
        p.getAge(ybmd);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetAgeInvalidYbMDa() {
        p.getAge(ybmda);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetAgeInvalidYMbDb() {
        p.getAge(ymbdb);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetAgeInvalidYMbD() {
        p.getAge(ymbdb);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetAgeInvalidYMbDa() {
        p.getAge(ymbda);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetAgeInvalidYMDb() {
        p.getAge(ymdb);
    }
    
    /*@Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testGetAgeInvalid() {
        exception.expect(IllegalArgumentException.class);
        p.getAge(ybmbdb);
        p.getAge(ybmbd);
        p.getAge(ybmbda);
        p.getAge(ybmadb);
        p.getAge(ybmad);
        p.getAge(ybmada);
        p.getAge(ybmdb);
        p.getAge(ybmd);
        p.getAge(ybmda);
        p.getAge(ymbdb);
        p.getAge(ymbdb);
        p.getAge(ymbda);
        p.getAge(ymdb);
    }*/
    
    // Erreur 364 jours apres la naissance (année suivante, même mois, jour précédent)
}
