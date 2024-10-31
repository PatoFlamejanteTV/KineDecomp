package com.google.common.primitives;

import com.google.common.annotations.GwtIncompatible;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class Doubles {

    /* renamed from: a */
    @GwtIncompatible
    static final Pattern f16038a = a();

    private Doubles() {
    }

    @GwtIncompatible
    private static Pattern a() {
        return Pattern.compile("[+-]?(?:NaN|Infinity|" + ("(?:\\d++(?:\\.\\d*+)?|\\.\\d++)(?:[eE][+-]?\\d++)?[fFdD]?") + "|" + ("0[xX](?:\\p{XDigit}++(?:\\.\\p{XDigit}*+)?|\\.\\p{XDigit}++)[pP][+-]?\\d++[fFdD]?") + ")");
    }

    public static boolean a(double d2) {
        return (Double.NEGATIVE_INFINITY < d2) & (d2 < Double.POSITIVE_INFINITY);
    }
}
