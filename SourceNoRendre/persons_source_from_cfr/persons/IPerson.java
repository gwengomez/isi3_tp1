/*
 * Decompiled with CFR 0_114.
 */
package persons;

import java.util.GregorianCalendar;

public interface IPerson {
    public String getFirstName();

    public String getName();

    public boolean wasBorn(GregorianCalendar var1);

    public int getAge(GregorianCalendar var1);
}

