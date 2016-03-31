/*
 * Decompiled with CFR 0_114.
 */
package people;

import java.util.GregorianCalendar;

public class Personne {
    protected GregorianCalendar dateNaissance;
    protected String nom;
    protected String prenom;

    public Personne(String nom, String prenom, int annee, int mois, int jour) {
        if (annee < 1582 || annee > 3000) {
            throw new IllegalArgumentException();
        }
        if (mois > 12 || mois < 1) {
            throw new IllegalArgumentException();
        }
        if (jour < 1 || jour > 31) {
            throw new IllegalArgumentException();
        }
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = new GregorianCalendar(annee, mois - 1, jour);
    }

    public int getAge(int annee, int mois, int jour) {
        GregorianCalendar date = new GregorianCalendar(annee, mois - 1, jour);
        if (this.dateNaissance.get(1) == date.get(1)) {
            if (this.dateNaissance.get(2) == date.get(2)) {
                if (this.dateNaissance.get(5) <= date.get(5)) {
                    return 0;
                }
                return -1;
            }
            if (this.dateNaissance.get(2) < date.get(2)) {
                return 0;
            }
            return -1;
        }
        if (this.dateNaissance.get(1) < date.get(1)) {
            if (this.dateNaissance.get(2) < date.get(2)) {
                return date.get(1) - this.dateNaissance.get(1);
            }
            if (this.dateNaissance.get(2) == date.get(2)) {
                if (this.dateNaissance.get(5) <= date.get(5)) {
                    return date.get(1) - this.dateNaissance.get(1);
                }
                return date.get(1) - this.dateNaissance.get(1) - 1;
            }
            return date.get(1) - this.dateNaissance.get(1) - 1;
        }
        return -1;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getNom() {
        return this.nom;
    }
}

