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
    
    public List<IPerson> liste_intervalle(List<IPerson> lesPersonnes, GregorianCalendar date, int ageMinimal, int ageMaximal) {
        if (ageMinimal > ageMaximal)
            throw new IllegalArgumentException("L'âge minimum est supèrieur à l'âge maximum");
        List<IPerson> personnesSelectionnees = new ArrayList<>();
        for (IPerson p : personnesSelectionnees) {
            try {
                if ((p.getAge(date) >= ageMinimal) || (p.getAge(date) <= ageMaximal)) {
                    personnesSelectionnees.add(p);
                }
            } catch (IllegalArgumentException e){}
        }
        return personnesSelectionnees;
    }
    
    public int chercher_doyen(List<IPerson> lesPersonnes, GregorianCalendar date) {
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
