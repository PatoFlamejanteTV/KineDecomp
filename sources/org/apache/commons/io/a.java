package org.apache.commons.io;

import java.nio.charset.Charset;

/* compiled from: Charsets.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a */
    public static final Charset f29301a = Charset.forName("ISO-8859-1");

    /* renamed from: b */
    public static final Charset f29302b = Charset.forName("US-ASCII");

    /* renamed from: c */
    public static final Charset f29303c = Charset.forName("UTF-16");

    /* renamed from: d */
    public static final Charset f29304d = Charset.forName("UTF-16BE");

    /* renamed from: e */
    public static final Charset f29305e = Charset.forName("UTF-16LE");

    /* renamed from: f */
    public static final Charset f29306f = Charset.forName("UTF-8");

    public static Charset a(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }
}
