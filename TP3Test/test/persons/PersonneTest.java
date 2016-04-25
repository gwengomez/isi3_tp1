/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons;

import Personne.PersonneAdapter;
import org.junit.Before;

/**
 *
 * @author Epulapp
 */
public class PersonneTest extends IPersonTest{
    
    public PersonneTest() {
    }
    
    @Before
    public void setUp() {
        this.p = new PersonneAdapter("Gomez", "Gwendoline", 1994, 10, 13);
    }
}
