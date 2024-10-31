package com.fasterxml.jackson.core.io;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class CharacterEscapes implements Serializable {
    public static final int ESCAPE_CUSTOM = -2;
    public static final int ESCAPE_NONE = 0;
    public static final int ESCAPE_STANDARD = -1;
    private static final long serialVersionUID = 1;

    public abstract int[] getEscapeCodesForAscii();

    public abstract com.fasterxml.jackson.core.e getEscapeSequence(int i);

    public static int[] standardAsciiEscapesForJSON() {
        int[] f = b.f();
        int[] iArr = new int[f.length];
        System.arraycopy(f, 0, iArr, 0, f.length);
        return iArr;
    }
}
