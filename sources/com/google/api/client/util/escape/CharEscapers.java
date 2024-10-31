package com.google.api.client.util.escape;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
public final class CharEscapers {

    /* renamed from: a, reason: collision with root package name */
    private static final Escaper f2551a = new PercentEscaper("-_.*", true);
    private static final Escaper b = new PercentEscaper("-_.!~*'()@:$&,;=", false);
    private static final Escaper c = new PercentEscaper("-_.!~*'()@:$&,;=+/?", false);
    private static final Escaper d = new PercentEscaper("-_.!~*'():$&,;=", false);
    private static final Escaper e = new PercentEscaper("-_.!~*'()@:$,;/?:", false);

    public static String a(String str) {
        return f2551a.a(str);
    }

    public static String b(String str) {
        try {
            return URLDecoder.decode(str, Keyczar.DEFAULT_ENCODING);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String c(String str) {
        return b.a(str);
    }

    public static String d(String str) {
        return c.a(str);
    }

    public static String e(String str) {
        return d.a(str);
    }

    public static String f(String str) {
        return e.a(str);
    }

    private CharEscapers() {
    }
}
