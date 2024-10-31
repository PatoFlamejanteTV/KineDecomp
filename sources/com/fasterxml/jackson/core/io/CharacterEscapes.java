package com.fasterxml.jackson.core.io;

import java.io.Serializable;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class CharacterEscapes implements Serializable {
    public static final int ESCAPE_CUSTOM = -2;
    public static final int ESCAPE_NONE = 0;
    public static final int ESCAPE_STANDARD = -1;

    public static int[] standardAsciiEscapesForJSON() {
        int[] c2 = a.c();
        return Arrays.copyOf(c2, c2.length);
    }

    public abstract int[] getEscapeCodesForAscii();

    public abstract com.fasterxml.jackson.core.e getEscapeSequence(int i);
}
