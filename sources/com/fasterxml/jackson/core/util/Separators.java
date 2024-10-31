package com.fasterxml.jackson.core.util;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Separators implements Serializable {
    private static final long serialVersionUID = 1;
    private final char arrayValueSeparator;
    private final char objectEntrySeparator;
    private final char objectFieldValueSeparator;

    public Separators() {
        this(':', ',', ',');
    }

    public static Separators createDefaultInstance() {
        return new Separators();
    }

    public char getArrayValueSeparator() {
        return this.arrayValueSeparator;
    }

    public char getObjectEntrySeparator() {
        return this.objectEntrySeparator;
    }

    public char getObjectFieldValueSeparator() {
        return this.objectFieldValueSeparator;
    }

    public Separators withArrayValueSeparator(char c2) {
        return this.arrayValueSeparator == c2 ? this : new Separators(this.objectFieldValueSeparator, this.objectEntrySeparator, c2);
    }

    public Separators withObjectEntrySeparator(char c2) {
        return this.objectEntrySeparator == c2 ? this : new Separators(this.objectFieldValueSeparator, c2, this.arrayValueSeparator);
    }

    public Separators withObjectFieldValueSeparator(char c2) {
        return this.objectFieldValueSeparator == c2 ? this : new Separators(c2, this.objectEntrySeparator, this.arrayValueSeparator);
    }

    public Separators(char c2, char c3, char c4) {
        this.objectFieldValueSeparator = c2;
        this.objectEntrySeparator = c3;
        this.arrayValueSeparator = c4;
    }
}
