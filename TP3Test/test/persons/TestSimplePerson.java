/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import people.SimplePerson;

/**
 *
 * @author Epulapp
 */
public class TestSimplePerson extends TestIPerson{

    public TestSimplePerson() {
    }

    @Before
    public void setUp() {
        //test avec SimplePerson
        p = new SimplePerson("Gomez", "Gwendoline", 1994, 10, 13);    
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
