package com.google.api.client.util.escape;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* loaded from: classes2.dex */
public final class CharEscapers {

    /* renamed from: a */
    private static final Escaper f14984a = new PercentEscaper("-_.*", true);

    /* renamed from: b */
    private static final Escaper f14985b = new PercentEscaper("-_.!~*'()@:$&,;=", false);

    /* renamed from: c */
    private static final Escaper f14986c = new PercentEscaper("-_.!~*'()@:$&,;=+/?", false);

    /* renamed from: d */
    private static final Escaper f14987d = new PercentEscaper("-_.!~*'():$&,;=", false);

    /* renamed from: e */
    private static final Escaper f14988e = new PercentEscaper("-_.!~*'()@:$,;/?:", false);

    private CharEscapers() {
    }

    public static String a(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String b(String str) {
        return f14984a.a(str);
    }

    public static String c(String str) {
        return f14985b.a(str);
    }

    public static String d(String str) {
        return f14986c.a(str);
    }

    public static String e(String str) {
        return f14988e.a(str);
    }

    public static String f(String str) {
        return f14987d.a(str);
    }
}
