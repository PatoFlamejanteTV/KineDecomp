package org.apache.commons.io;

import java.io.Serializable;

/* loaded from: classes3.dex */
public final class IOCase implements Serializable {
    private static final long serialVersionUID = -6343169151696340687L;

    /* renamed from: a */
    private final transient boolean f29300a;
    private final String name;
    public static final IOCase SENSITIVE = new IOCase("Sensitive", true);
    public static final IOCase INSENSITIVE = new IOCase("Insensitive", false);
    public static final IOCase SYSTEM = new IOCase("System", true ^ c.a());

    private IOCase(String str, boolean z) {
        this.name = str;
        this.f29300a = z;
    }

    public static IOCase forName(String str) {
        if (SENSITIVE.name.equals(str)) {
            return SENSITIVE;
        }
        if (INSENSITIVE.name.equals(str)) {
            return INSENSITIVE;
        }
        if (SYSTEM.name.equals(str)) {
            return SYSTEM;
        }
        throw new IllegalArgumentException("Invalid IOCase name: " + str);
    }

    private Object readResolve() {
        return forName(this.name);
    }

    public int checkCompareTo(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("The strings must not be null");
        }
        return this.f29300a ? str.compareTo(str2) : str.compareToIgnoreCase(str2);
    }

    public boolean checkEndsWith(String str, String str2) {
        int length = str2.length();
        return str.regionMatches(!this.f29300a, str.length() - length, str2, 0, length);
    }

    public boolean checkEquals(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("The strings must not be null");
        }
        return this.f29300a ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public int checkIndexOf(String str, int i, String str2) {
        int length = str.length() - str2.length();
        if (length < i) {
            return -1;
        }
        while (i <= length) {
            if (checkRegionMatches(str, i, str2)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public boolean checkRegionMatches(String str, int i, String str2) {
        return str.regionMatches(!this.f29300a, i, str2, 0, str2.length());
    }

    public boolean checkStartsWith(String str, String str2) {
        return str.regionMatches(!this.f29300a, 0, str2, 0, str2.length());
    }

    public String getName() {
        return this.name;
    }

    public boolean isCaseSensitive() {
        return this.f29300a;
    }

    public String toString() {
        return this.name;
    }
}
