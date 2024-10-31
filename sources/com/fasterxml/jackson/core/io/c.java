package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.JsonEncoding;

/* compiled from: IOContext.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    protected final Object f9756a;

    /* renamed from: b */
    protected JsonEncoding f9757b;

    /* renamed from: c */
    protected final boolean f9758c;

    /* renamed from: d */
    protected final com.fasterxml.jackson.core.util.a f9759d;

    /* renamed from: e */
    protected byte[] f9760e;

    /* renamed from: f */
    protected byte[] f9761f;

    /* renamed from: g */
    protected char[] f9762g;

    /* renamed from: h */
    protected char[] f9763h;
    protected char[] i;

    public c(com.fasterxml.jackson.core.util.a aVar, Object obj, boolean z) {
        this.f9759d = aVar;
        this.f9756a = obj;
        this.f9758c = z;
    }

    private IllegalArgumentException i() {
        return new IllegalArgumentException("Trying to release buffer smaller than original");
    }

    public void a(JsonEncoding jsonEncoding) {
        this.f9757b = jsonEncoding;
    }

    public byte[] b() {
        a((Object) this.f9760e);
        byte[] a2 = this.f9759d.a(0);
        this.f9760e = a2;
        return a2;
    }

    public char[] c() {
        a((Object) this.f9762g);
        char[] b2 = this.f9759d.b(0);
        this.f9762g = b2;
        return b2;
    }

    public byte[] d() {
        a((Object) this.f9761f);
        byte[] a2 = this.f9759d.a(1);
        this.f9761f = a2;
        return a2;
    }

    public com.fasterxml.jackson.core.util.e e() {
        return new com.fasterxml.jackson.core.util.e(this.f9759d);
    }

    public JsonEncoding f() {
        return this.f9757b;
    }

    public Object g() {
        return this.f9756a;
    }

    public boolean h() {
        return this.f9758c;
    }

    public char[] a(int i) {
        a((Object) this.f9762g);
        char[] b2 = this.f9759d.b(0, i);
        this.f9762g = b2;
        return b2;
    }

    public void b(byte[] bArr) {
        if (bArr != null) {
            a(bArr, this.f9761f);
            this.f9761f = null;
            this.f9759d.a(1, bArr);
        }
    }

    public void c(char[] cArr) {
        if (cArr != null) {
            a(cArr, this.f9762g);
            this.f9762g = null;
            this.f9759d.a(0, cArr);
        }
    }

    public char[] a() {
        a((Object) this.f9763h);
        char[] b2 = this.f9759d.b(1);
        this.f9763h = b2;
        return b2;
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            a(bArr, this.f9760e);
            this.f9760e = null;
            this.f9759d.a(0, bArr);
        }
    }

    public void b(char[] cArr) {
        if (cArr != null) {
            a(cArr, this.i);
            this.i = null;
            this.f9759d.a(3, cArr);
        }
    }

    public void a(char[] cArr) {
        if (cArr != null) {
            a(cArr, this.f9763h);
            this.f9763h = null;
            this.f9759d.a(1, cArr);
        }
    }

    protected final void a(Object obj) {
        if (obj != null) {
            throw new IllegalStateException("Trying to call same allocXxx() method second time");
        }
    }

    protected final void a(byte[] bArr, byte[] bArr2) {
        if (bArr != bArr2 && bArr.length < bArr2.length) {
            throw i();
        }
    }

    protected final void a(char[] cArr, char[] cArr2) {
        if (cArr != cArr2 && cArr.length < cArr2.length) {
            throw i();
        }
    }
}
