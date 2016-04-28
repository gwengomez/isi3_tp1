/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personne;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import persons.*;

/**
 *
 * @author Epulapp
 */
public class OutilsPerson {
    
    /**
    * Méthode cherchant dans une liste de personnes celles dont l'age à une date donnée est compris dans un intervalle d'age donné.
    * Si l'age minimum est supèrieur à l'age maximum, la méthode renvoie une exception.
    * Si la condition qui vérifie si l'age de la personne est compris dans l'intervalle échoue, la méthode renvoie une exception.
    * 
    * @param lesPersonnes liste de personnes initiale
    * @param date date à laquelle l'age est choisi
    * @param ageMinimal borne inférieure de l'intervalle d'age
    * @param ageMaximal borne supèrieure de l'intervalle d'age
    * @return personnesSelectionees les personnes de la liste initiale dont l'age est compris dans l'intervalle donné
    * 
    */
    public static List<IPerson> liste_intervalle(List<IPerson> lesPersonnes, GregorianCalendar date, int ageMinimal, int ageMaximal) {
        if (ageMinimal > ageMaximal)
            throw new IllegalArgumentException("L'âge minimum est supèrieur à l'âge maximum");
        List<IPerson> personnesSelectionnees = new ArrayList<>();
        for (IPerson p : lesPersonnes) {
            try {
                if ((p.getAge(date) >= ageMinimal) && (p.getAge(date) <= ageMaximal)) {
                    personnesSelectionnees.add(p);
                }
            } catch (IllegalArgumentException e){}
        }
        return personnesSelectionnees;
    }
    
    /**
    * Méthode qui cherche parmi une liste de personnes donnée le doyen à une date donnée.
    * Si la liste est vide, la méthode renvoie -1.
    * Si la récupération de l'age d'une personne ou la condition qui vérifie si la personne est le nouveau doyen temporaire échouent, la méthode renvoie une exception.
    * 
    * @param lesPersonnes liste de personnes initiale
    * @param date date à laquelle l'age est choisi
    * @return age l'age du doyen de la liste
    * 
    */
    public static int chercher_doyen(List<IPerson> lesPersonnes, GregorianCalendar date) {
        int age = -1;
        int ageP = 0;
        for (IPerson p : lesPersonnes) {
            try {
                ageP = p.getAge(date);
                if (ageP > age)
                    age = ageP;
            } catch (IllegalArgumentException e) {}
        }
        return age;
    }
}
