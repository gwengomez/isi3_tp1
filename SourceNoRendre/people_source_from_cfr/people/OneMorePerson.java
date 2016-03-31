/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  persons.IPerson
 */
package people;

import java.util.GregorianCalendar;
import persons.IPerson;

public class OneMorePerson
implements IPerson {
    protected GregorianCalendar birthdate;
    protected String firstname;
    protected String lastname;

    public OneMorePerson(String lastName, String firstName, int birthYear, int birthMonth, int birthDay) {
        if (birthYear < 1582 || birthYear > 3000) {
            throw new IllegalArgumentException();
        }
        if (birthMonth > 12 || birthMonth < 1) {
            throw new IllegalArgumentException();
        }
        if (birthDay < 1 || birthDay > 31) {
            throw new IllegalArgumentException();
        }
        this.firstname = firstName;
        this.lastname = lastName;
        this.birthdate = new GregorianCalendar(birthYear, birthMonth - 1, birthDay);
    }

    public String getFirstName() {
        return this.firstname;
    }

    public String getName() {
        return this.lastname;
    }

    public boolean wasBorn(GregorianCalendar date) {
        if (date.equals(this.birthdate)) {
            return true;
        }
        if (date.after(this.birthdate) || this.birthdate.equals(date)) {
            return true;
        }
        return false;
    }

    public int getAge(GregorianCalendar date) {
        if (!this.wasBorn(date)) {
            throw new IllegalArgumentException();
        }
        if (this.birthdate.get(1) == date.get(1)) {
            if (this.birthdate.get(2) == date.get(2)) {
                if (this.birthdate.get(5) == date.get(5)) {
                    return -1;
                }
                if (this.birthdate.get(5) < date.get(5)) {
                    return 0;
                }
                throw new IllegalArgumentException();
            }
            if (this.birthdate.get(2) < date.get(2)) {
                return 0;
            }
            throw new IllegalArgumentException();
        }
        if (this.birthdate.get(1) < date.get(1)) {
            if (this.birthdate.get(2) < date.get(2)) {
                return date.get(1) - this.birthdate.get(1);
            }
            if (this.birthdate.get(2) == date.get(2)) {
                if (this.birthdate.get(5) <= date.get(5)) {
                    return date.get(1) - this.birthdate.get(1);
                }
                return date.get(1) - this.birthdate.get(1) - 1;
            }
            return date.get(1) - this.birthdate.get(1) - 1;
        }
        throw new IllegalArgumentException();
    }
}

