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
public class OutilsPersonTest {

    private IPerson mockPerson; // personne non définie (utilisée toute seule)
    private IPerson mockPerson1; //age < ageMin
    private IPerson mockPerson2; //age > ageMax
    private IPerson mockPerson3; //age = ageMin
    private IPerson mockPerson4; //age = ageMax
    private IPerson mockPerson5; //ageMin <= age <= ageMax
    private GregorianCalendar date;
    private int ageMin;
    private int ageMax;
    private List<IPerson> onePerson;
    private List<IPerson> persons;

    public OutilsPersonTest() {
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
        onePerson = new ArrayList<IPerson>();
        onePerson.add(mockPerson);
        persons = new ArrayList<IPerson>();
        persons.add(mockPerson1);
        persons.add(mockPerson2);
        persons.add(mockPerson3);
        persons.add(mockPerson4);
        persons.add(mockPerson5);
    }

    @After
    public void tearDown() {

    }
    
    // TESTS : inversion de l'age min et de l'age max dans l'appel de la méthode
    // Celle ci doit renvoyer une exception dans chacun des cas
    
    // L'age de la personne est inférieur à l'intervalle d'age selectionné
    @Test(expected = IllegalArgumentException.class)
    public void testListIntervalleException1() {
        when(mockPerson.getAge(date)).thenReturn(25);
        OutilsPerson.liste_intervalle(onePerson, date, ageMax, ageMin);
    }
    
    // L'age de la personne est supérieur à l'intervalle d'age selectionné
    @Test(expected = IllegalArgumentException.class)
    public void testListIntervalleException2() {
        when(mockPerson.getAge(date)).thenReturn(55);
        OutilsPerson.liste_intervalle(onePerson, date, ageMax, ageMin);
    }

    // L'age de la personne est égale à la borne inférieure de l'intervalle d'age selectionné
    @Test(expected = IllegalArgumentException.class)
    public void testListIntervalleException3() {
        when(mockPerson.getAge(date)).thenReturn(30);
        OutilsPerson.liste_intervalle(onePerson, date, ageMax, ageMin);
    }

    // L'age de la personne est égal à la borne supérieure de l'intervalle d'age selectionné
    @Test(expected = IllegalArgumentException.class)
    public void testListIntervalleException4() {
        when(mockPerson.getAge(date)).thenReturn(50);
        OutilsPerson.liste_intervalle(onePerson, date, ageMax, ageMin);
    }

    // L'age de la personne est compris dans l'intervalle d'age selectionné
    @Test(expected = IllegalArgumentException.class)
    public void testListIntervalleException5() {
        when(mockPerson.getAge(date)).thenReturn(40);
        OutilsPerson.liste_intervalle(onePerson, date, ageMax, ageMin);
    }
    
    
    // TESTS : pour chaque cas de personne, on teste le comportement de la méthode
    // Celle-ci ne doit renvoyer la personne que si son age est compris dans l'intervalle sélectionné
    
    // L'age de la personne est inférieur à l'intervalle d'age selectionné
    @Test
    public void testListe_intervalle1() {
        when(mockPerson.getAge(date)).thenReturn(25);
        Assert.assertEquals(new ArrayList<IPerson>(), OutilsPerson.liste_intervalle(onePerson, date, ageMin, ageMax));
    }

    // L'age de la personne est supérieur à l'intervalle d'age selectionné
    @Test
    public void testListe_intervalle2() {
        when(mockPerson.getAge(date)).thenReturn(55);
        Assert.assertEquals(new ArrayList<IPerson>(), OutilsPerson.liste_intervalle(onePerson, date, ageMin, ageMax));
    }

    // L'age de la personne est égale à la borne inférieure de l'intervalle d'age selectionné
    @Test
    public void testListe_intervalle3() {
        when(mockPerson.getAge(date)).thenReturn(30);
        Assert.assertEquals(new ArrayList<IPerson>(Collections.singletonList(mockPerson)), OutilsPerson.liste_intervalle(onePerson, date, ageMin, ageMax));
    }

    // L'age de la personne est égal à la borne supérieure de l'intervalle d'age selectionné
    @Test
    public void testListe_intervalle4() {
        when(mockPerson.getAge(date)).thenReturn(50);
        Assert.assertEquals(new ArrayList<IPerson>(Collections.singletonList(mockPerson)), OutilsPerson.liste_intervalle(onePerson, date, ageMin, ageMax));
    }

    // L'age de la personne est compris dans l'intervalle d'age selectionné
    @Test
    public void testListe_intervalle5() {
        when(mockPerson.getAge(date)).thenReturn(40);
        Assert.assertEquals(new ArrayList<IPerson>(Collections.singletonList(mockPerson)), OutilsPerson.liste_intervalle(onePerson, date, ageMin, ageMax));
    }

    
    // TESTS : tous les cas sont placés dans la liste qui est passée en paramètre de la méthode à tester
    // Celle ci ne doit renvoyer que les personnes dont l'age est compris dans l'intervalle testé.
    
    @Test
    public void testListe_all() {
        when(mockPerson1.getAge(date)).thenReturn(25);
        when(mockPerson2.getAge(date)).thenReturn(55);
        when(mockPerson3.getAge(date)).thenReturn(30);
        when(mockPerson4.getAge(date)).thenReturn(50);
        when(mockPerson5.getAge(date)).thenReturn(40);

        ArrayList<IPerson> expected = new ArrayList<>();
        expected.add(mockPerson3);
        expected.add(mockPerson4);
        expected.add(mockPerson5);

        Assert.assertEquals(expected, OutilsPerson.liste_intervalle(persons, date, ageMin, ageMax));
    }
    
    
    // TESTS : on choisi un cas dont l'age est compris dans l'intervalle d'age sélectionné
    // La méthode ne doit pas appeler certaines méthodes de la classe IPerson
    
    // Pas d'appel de getName()
    @Test
    public void testList_intervalle_name() {
        when(mockPerson.getAge(date)).thenReturn(40);
        Assert.assertEquals(new ArrayList<IPerson>(Collections.singletonList(mockPerson)), OutilsPerson.liste_intervalle(onePerson, date, ageMin, ageMax));
        verify(mockPerson, times(0)).getName();
        verify(mockPerson, atLeastOnce()).getAge(date);
    }

    // Pas d'appel de getFirstName()
    @Test
    public void testList_intervalle_firstname() {
        when(mockPerson.getAge(date)).thenReturn(40);
        Assert.assertEquals(new ArrayList<IPerson>(Collections.singletonList(mockPerson)), OutilsPerson.liste_intervalle(onePerson, date, ageMin, ageMax));
        verify(mockPerson, times(0)).getFirstName();
        verify(mockPerson, atLeastOnce()).getAge(date);
    }
    
    
    // TESTS : méthode chercher_doyen
    // On vérifie le comportement de la méthode

    // Lorsque la méthode getAge() renvoie une erreur, la méthode doit renvoyer -1
    @Test
    public void testChercher_doyen1() {
        when(mockPerson.getAge(date)).thenThrow(new IllegalArgumentException());
        Assert.assertEquals(-1, OutilsPerson.chercher_doyen(onePerson, date));
    }

    // La méthode renvoie bien l'age max
    @Test
    public void testChercher_doyen2() {
        when(mockPerson.getAge(date)).thenReturn(30);
        Assert.assertEquals(30, OutilsPerson.chercher_doyen(onePerson, date));
    }

    // Il ne doit pas y avoir d'erreur lorsque l'age max est 0 : la méthode doit renvoyer 0
    @Test
    public void testChercher_doyen3() {
        when(mockPerson.getAge(date)).thenReturn(0);
        Assert.assertEquals(0, OutilsPerson.chercher_doyen(onePerson, date));
    }
    
    // On place les 3 cas ci-dessus dans une liste à tester : la méthode doit renvoyer la valeur maximum
    @Test
    public void testChercher_doyen_all() {
        List<IPerson> full = new ArrayList<>();
        when(mockPerson1.getAge(date)).thenThrow(new IllegalArgumentException());
        when(mockPerson2.getAge(date)).thenReturn(30);
        when(mockPerson3.getAge(date)).thenReturn(0);
        Assert.assertEquals(30, OutilsPerson.chercher_doyen(persons, date));
    }

}
