package Adapter;

import java.util.Calendar;
import java.util.GregorianCalendar;
import people.*;
import persons.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Epulapp
 */
public class PersonneAdapter extends Personne implements IPerson {

    public PersonneAdapter(String nom, String prenom, int annee, int mois, int jour) {
        super(nom, prenom, annee, mois, jour);
    }

    @Override
    public String getFirstName() {
        return this.getPrenom();
    }

    @Override
    public String getName() {
        return this.getNom();
    }

    @Override
    public boolean wasBorn(GregorianCalendar gc) {
        if (gc.after(this.dateNaissance) || gc.equals(this.dateNaissance)) {
            return true;
        }
        return false;
    }

    @Override
    public int getAge(GregorianCalendar gc) {
        int age = this.getAge(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH) + 1, gc.get(Calendar.DAY_OF_MONTH));
        if (age < 0) {
            throw new IllegalArgumentException("Person was not born");
        }
        return age;
    }

}
