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
import people.OneMorePerson;

/**
 *
 * @author Epulapp
 */
public class OneMorePersonTest extends IPersonTest {

    public OneMorePersonTest() {
    }

    @Before
    public void setUp() {
        //test avec OneMorePerson
        p = new OneMorePerson("Gomez", "Gwendoline", 1994, 10, 13);    
    }

    // Erreur dans testGetAge :
    // Expected : 0
    // Résultat : -1
}
