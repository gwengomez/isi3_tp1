/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons;

import Personne.OutilsPerson;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Epulapp
 */
public class TestOutilsPerson {
    
    private IPerson mockPerson1;
    private IPerson mockPerson2;
    private IPerson mockPerson3;
    private IPerson mockPerson4;
    private GregorianCalendar date;
    
    public TestOutilsPerson() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        mockPerson1 = mock(IPerson.class);
        mockPerson2 = mock(IPerson.class);
        mockPerson3 = mock(IPerson.class);
        mockPerson4 = mock(IPerson.class);
        date = new GregorianCalendar(2050, Calendar.MAY, 10);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testMock() {
        when(mockPerson2.getAge(date)).thenReturn(54);
        when(mockPerson2.getAge(date)).thenReturn(62);
        when(mockPerson2.getAge(date)).thenReturn(64);
        when(mockPerson2.getAge(date)).thenReturn(70);
        
        List<IPerson> lesPersonnes = new ArrayList<>();
        lesPersonnes.add(mockPerson1);
        lesPersonnes.add(mockPerson2);
        lesPersonnes.add(mockPerson3);
        lesPersonnes.add(mockPerson4);
        
        List<IPerson> personnesSelectionnees = new ArrayList<>();
        personnesSelectionnees.add(mockPerson2);
        personnesSelectionnees.add(mockPerson3);
        
        OutilsPerson outilsPerson = new OutilsPerson();
        Assert.assertEquals(personnesSelectionnees, outilsPerson.liste_intervalle(lesPersonnes, date, 60, 65));
    }
}
