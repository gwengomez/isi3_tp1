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
import people.AnotherPerson;

/**
 *
 * @author Epulapp
 */
public class TestAnotherPerson extends TestIPerson {

    public TestAnotherPerson() {
    }

    @Before
    public void setUp() {
        //test avec AnotherPerson
        p = new AnotherPerson("Gomez", "Gwendoline", 1994, 10, 13);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
