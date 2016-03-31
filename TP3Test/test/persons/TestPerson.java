/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons;

import org.junit.Before;

/**
 *
 * @author Epulapp
 */
public class TestPerson extends TestIPerson{

    public TestPerson() {
    }

    @Before
    public void setUp() {
        //test avec Person
        p = new Person("Gomez", "Gwendoline", 1994, 10, 13);
    }
}
