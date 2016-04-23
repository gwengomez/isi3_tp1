/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons;

import Personne.OutilsPerson;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author Epulapp
 */
public class TestOutilsPerson {

    private IPerson mockPerson;
    private IPerson mockPerson1; //age < ageMin
    private IPerson mockPerson2; //age > ageMax
    private IPerson mockPerson3; //age = ageMin
    private IPerson mockPerson4; //age = ageMax
    private IPerson mockPerson5; //ageMin <= age <= ageMax
    private GregorianCalendar date;
    private int ageMin;
    private int ageMax;
    private OutilsPerson op;
    private List<IPerson> persons;

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

        ageMin = 30;
        ageMax = 50;
        mockPerson = mock(IPerson.class);
        mockPerson1 = mock(IPerson.class);
        mockPerson2 = mock(IPerson.class);
        mockPerson3 = mock(IPerson.class);
        mockPerson4 = mock(IPerson.class);
        mockPerson5 = mock(IPerson.class);
        date = new GregorianCalendar(2050, Calendar.MAY, 10); //10 mai 2050
        op = new OutilsPerson();
        persons = new ArrayList<IPerson>();
        persons.add(mockPerson);
    }

    @After
    public void tearDown() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListIntervalleException1() {
        when(mockPerson.getAge(date)).thenReturn(25);
        op.liste_intervalle(persons, date, ageMax, ageMin);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListIntervalleException2() {
        when(mockPerson.getAge(date)).thenReturn(55);
        op.liste_intervalle(persons, date, ageMax, ageMin);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListIntervalleException3() {
        when(mockPerson.getAge(date)).thenReturn(30);
        op.liste_intervalle(persons, date, ageMax, ageMin);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListIntervalleException4() {
        when(mockPerson.getAge(date)).thenReturn(50);
        op.liste_intervalle(persons, date, ageMax, ageMin);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListIntervalleException5() {
        when(mockPerson.getAge(date)).thenReturn(40);
        op.liste_intervalle(persons, date, ageMax, ageMin);
    }

    @Test
    public void testListe_intervalle1() {
        when(mockPerson.getAge(date)).thenReturn(25);
        Assert.assertEquals(new ArrayList<IPerson>(), op.liste_intervalle(persons, date, ageMin, ageMax));
    }

    @Test
    public void testListe_intervalle2() {
        when(mockPerson.getAge(date)).thenReturn(55);
        Assert.assertEquals(new ArrayList<IPerson>(), op.liste_intervalle(persons, date, ageMin, ageMax));
    }

    @Test
    public void testListe_intervalle3() {
        when(mockPerson.getAge(date)).thenReturn(30);
        Assert.assertEquals(new ArrayList<IPerson>(Collections.singletonList(mockPerson)), op.liste_intervalle(persons, date, ageMin, ageMax));
    }

    @Test
    public void testListe_intervalle4() {
        when(mockPerson.getAge(date)).thenReturn(50);
        Assert.assertEquals(new ArrayList<IPerson>(Collections.singletonList(mockPerson)), op.liste_intervalle(persons, date, ageMin, ageMax));
    }

    @Test
    public void testListe_intervalle5() {
        when(mockPerson.getAge(date)).thenReturn(40);
        Assert.assertEquals(new ArrayList<IPerson>(Collections.singletonList(mockPerson)), op.liste_intervalle(persons, date, ageMin, ageMax));
    }

    @Test
    public void testListe_all() {
        when(mockPerson1.getAge(date)).thenReturn(25);
        when(mockPerson2.getAge(date)).thenReturn(55);
        when(mockPerson3.getAge(date)).thenReturn(30);
        when(mockPerson4.getAge(date)).thenReturn(50);
        when(mockPerson5.getAge(date)).thenReturn(40);
        ArrayList<IPerson> full = new ArrayList<>();
        full.add(mockPerson1);
        full.add(mockPerson2);
        full.add(mockPerson3);
        full.add(mockPerson4);
        full.add(mockPerson5);

        ArrayList<IPerson> expected = new ArrayList<>();
        expected.add(mockPerson3);
        expected.add(mockPerson4);
        expected.add(mockPerson5);

        Assert.assertEquals(expected, op.liste_intervalle(full, date, ageMin, ageMax));
    }

    @Test
    public void testChercher_doyen1() {
        when(mockPerson.getAge(date)).thenThrow(new IllegalArgumentException());
        Assert.assertEquals(-1, op.chercher_doyen(persons, date));
    }

    @Test
    public void testChercher_doyen2() {
        when(mockPerson.getAge(date)).thenReturn(30);
        Assert.assertEquals(30, op.chercher_doyen(persons, date));
    }

    @Test
    public void testChercher_doyen3() {
        when(mockPerson.getAge(date)).thenReturn(0);
        Assert.assertEquals(0, op.chercher_doyen(persons, date));
    }

    @Test
    public void testChercher_doyen_all() {
        List<IPerson> full = new ArrayList<>();
        when(mockPerson1.getAge(date)).thenThrow(new IllegalArgumentException());
        when(mockPerson2.getAge(date)).thenReturn(30);
        when(mockPerson3.getAge(date)).thenReturn(0);
        full.add(mockPerson1);
        full.add(mockPerson2);
        full.add(mockPerson3);     
        Assert.assertEquals(30, op.chercher_doyen(full, date));
    }

}
