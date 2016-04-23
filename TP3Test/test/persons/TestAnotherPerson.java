/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons;

import org.junit.Before;
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

    // Erreur dans testAgeInvalid2 :
    // Expected : IllegalArgumentException
    // Résultat : AssertionFailedError
}
