package com.adobe.xmp.b;

import com.adobe.xmp.XMPException;

/* compiled from: SerializeOptions.java */
/* loaded from: classes.dex */
public final class f extends c {

    /* renamed from: c */
    private int f7578c;

    /* renamed from: d */
    private String f7579d;

    /* renamed from: e */
    private String f7580e;

    /* renamed from: f */
    private int f7581f;

    /* renamed from: g */
    private boolean f7582g;

    public f() {
        this.f7578c = 2048;
        this.f7579d = "\n";
        this.f7580e = "  ";
        this.f7581f = 0;
        this.f7582g = false;
    }

    public f a(boolean z) {
        a(3, false);
        a(2, z);
        return this;
    }

    @Override // com.adobe.xmp.b.c
    protected int b() {
        return 13168;
    }

    public f b(String str) {
        this.f7579d = str;
        return this;
    }

    public int c() {
        return this.f7581f;
    }

    public Object clone() throws CloneNotSupportedException {
        try {
            f fVar = new f(a());
            fVar.d(this.f7581f);
            fVar.a(this.f7580e);
            fVar.b(this.f7579d);
            fVar.e(this.f7578c);
            return fVar;
        } catch (XMPException unused) {
            return null;
        }
    }

    public boolean d() {
        return (a() & 3) == 2;
    }

    public boolean e() {
        return (a() & 3) == 3;
    }

    public String f() {
        return d() ? "UTF-16BE" : e() ? "UTF-16LE" : "UTF-8";
    }

    public boolean g() {
        return b(512);
    }

    public boolean h() {
        return b(256);
    }

    public String i() {
        return this.f7580e;
    }

    public String j() {
        return this.f7579d;
    }

    public boolean k() {
        return b(16);
    }

    public boolean l() {
        return this.f7582g;
    }

    public boolean m() {
        return b(4096);
    }

    public int n() {
        return this.f7578c;
    }

    public boolean o() {
        return b(32);
    }

    public boolean p() {
        return b(8192);
    }

    public boolean q() {
        return b(128);
    }

    public f d(int i) {
        this.f7581f = i;
        return this;
    }

    public f e(int i) {
        this.f7578c = i;
        return this;
    }

    public f a(String str) {
        this.f7580e = str;
        return this;
    }

    public f(int i) throws XMPException {
        super(i);
        this.f7578c = 2048;
        this.f7579d = "\n";
        this.f7580e = "  ";
        this.f7581f = 0;
        this.f7582g = false;
    }
}
