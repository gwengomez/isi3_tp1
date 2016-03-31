/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  persons.IPerson
 */
package people;

import java.util.GregorianCalendar;
import persons.IPerson;

public class SmallCodePerson
implements IPerson {
    protected GregorianCalendar birthDate;
    protected String firstName;
    protected String lastName;

    public SmallCodePerson(String lastName, String firstName, int birthYear, int birthMonth, int birthDay) {
        if (birthYear < 1582 || birthYear > 3000) {
            throw new IllegalArgumentException();
        }
        if (birthMonth > 12 || birthMonth < 1) {
            throw new IllegalArgumentException();
        }
        if (birthDay < 1 || birthDay > 31) {
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = new GregorianCalendar(birthYear, birthMonth - 1, birthDay);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getName() {
        return this.lastName;
    }

    public boolean wasBorn(GregorianCalendar date) {
        if (date.after(this.birthDate)) {
            return true;
        }
        return false;
    }

    public int getAge(GregorianCalendar date) {
        if (!this.wasBorn(date)) {
            throw new IllegalArgumentException();
        }
        if (this.birthDate.get(1) == date.get(1)) {
            if (this.birthDate.get(2) == date.get(2)) {
                if (this.birthDate.get(5) <= date.get(5)) {
                    return 0;
                }
                throw new IllegalArgumentException();
            }
            if (this.birthDate.get(2) < date.get(2)) {
                return 0;
            }
            throw new IllegalArgumentException();
        }
        if (this.birthDate.get(1) < date.get(1)) {
            if (this.birthDate.get(2) < date.get(2)) {
                return date.get(1) - this.birthDate.get(1);
            }
            if (this.birthDate.get(2) == date.get(2)) {
                if (this.birthDate.get(5) <= date.get(5)) {
                    return date.get(1) - this.birthDate.get(1);
                }
                return date.get(1) - this.birthDate.get(1) - 1;
            }
            return date.get(1) - this.birthDate.get(1) - 1;
        }
        throw new IllegalArgumentException();
    }
}

