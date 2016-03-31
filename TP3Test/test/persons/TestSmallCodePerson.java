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
import people.SmallCodePerson;

/**
 *
 * @author Epulapp
 */
public class TestSmallCodePerson extends TestIPerson {

    public TestSmallCodePerson() {
    }

    @Before
    public void setUp() {
        //test avec SmallCodePerson
        p = new SmallCodePerson("Gomez", "Gwendoline", 1994, 10, 13);
    }
    
    // Erreur dans testWasBorn :
    // Date de naissance qui ne va pas
}
