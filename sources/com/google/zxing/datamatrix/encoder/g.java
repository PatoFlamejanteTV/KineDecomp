package com.google.zxing.datamatrix.encoder;

import com.google.zxing.Dimension;
import java.nio.charset.Charset;

/* compiled from: EncoderContext.java */
/* loaded from: classes2.dex */
final class g {

    /* renamed from: a */
    private final String f19122a;

    /* renamed from: b */
    private SymbolShapeHint f19123b;

    /* renamed from: c */
    private Dimension f19124c;

    /* renamed from: d */
    private Dimension f19125d;

    /* renamed from: e */
    private final StringBuilder f19126e;

    /* renamed from: f */
    int f19127f;

    /* renamed from: g */
    private int f19128g;

    /* renamed from: h */
    private SymbolInfo f19129h;
    private int i;

    public g(String str) {
        byte[] bytes = str.getBytes(Charset.forName("ISO-8859-1"));
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            char c2 = (char) (bytes[i] & 255);
            if (c2 == '?' && str.charAt(i) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c2);
        }
        this.f19122a = sb.toString();
        this.f19123b = SymbolShapeHint.FORCE_NONE;
        this.f19126e = new StringBuilder(str.length());
        this.f19128g = -1;
    }

    private int l() {
        return this.f19122a.length() - this.i;
    }

    public void a(SymbolShapeHint symbolShapeHint) {
        this.f19123b = symbolShapeHint;
    }

    public StringBuilder b() {
        return this.f19126e;
    }

    public char c() {
        return this.f19122a.charAt(this.f19127f);
    }

    public String d() {
        return this.f19122a;
    }

    public int e() {
        return this.f19128g;
    }

    public int f() {
        return l() - this.f19127f;
    }

    public SymbolInfo g() {
        return this.f19129h;
    }

    public boolean h() {
        return this.f19127f < l();
    }

    public void i() {
        this.f19128g = -1;
    }

    public void j() {
        this.f19129h = null;
    }

    public void k() {
        c(a());
    }

    public void a(Dimension dimension, Dimension dimension2) {
        this.f19124c = dimension;
        this.f19125d = dimension2;
    }

    public void b(int i) {
        this.f19128g = i;
    }

    public void c(int i) {
        SymbolInfo symbolInfo = this.f19129h;
        if (symbolInfo == null || i > symbolInfo.a()) {
            this.f19129h = SymbolInfo.a(i, this.f19123b, this.f19124c, this.f19125d, true);
        }
    }

    public void a(int i) {
        this.i = i;
    }

    public void a(String str) {
        this.f19126e.append(str);
    }

    public void a(char c2) {
        this.f19126e.append(c2);
    }

    public int a() {
        return this.f19126e.length();
    }
}
