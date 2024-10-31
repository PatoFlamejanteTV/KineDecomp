package com.adobe.xmp.b;

import com.adobe.xmp.XMPException;

/* compiled from: PropertyOptions.java */
/* loaded from: classes.dex */
public final class e extends c {
    public e() {
    }

    public e a(boolean z) {
        a(512, z);
        return this;
    }

    @Override // com.adobe.xmp.b.c
    protected int b() {
        return -2147475470;
    }

    public e b(boolean z) {
        a(4096, z);
        return this;
    }

    public boolean c() {
        return b(64);
    }

    public boolean d() {
        return b(512);
    }

    public e e(boolean z) {
        a(64, z);
        return this;
    }

    public e f(boolean z) {
        a(16, z);
        return this;
    }

    public e g(boolean z) {
        a(128, z);
        return this;
    }

    public e h(boolean z) {
        a(32, z);
        return this;
    }

    public e i(boolean z) {
        a(Integer.MIN_VALUE, z);
        return this;
    }

    public boolean j() {
        return b(32);
    }

    public e k(boolean z) {
        a(2, z);
        return this;
    }

    public boolean l() {
        return (a() & 768) == 0;
    }

    public boolean m() {
        return b(256);
    }

    public boolean n() {
        return b(2);
    }

    public e(int i) throws XMPException {
        super(i);
    }

    public void a(e eVar) throws XMPException {
        if (eVar != null) {
            c(eVar.a() | a());
        }
    }

    public e c(boolean z) {
        a(2048, z);
        return this;
    }

    public e d(boolean z) {
        a(1024, z);
        return this;
    }

    public boolean e() {
        return b(4096);
    }

    public boolean f() {
        return b(2048);
    }

    public boolean g() {
        return b(1024);
    }

    public boolean h() {
        return (a() & 768) > 0;
    }

    public boolean i() {
        return (a() & (-7681)) == 0;
    }

    public e j(boolean z) {
        a(256, z);
        return this;
    }

    public boolean k() {
        return b(Integer.MIN_VALUE);
    }

    @Override // com.adobe.xmp.b.c
    public void a(int i) throws XMPException {
        if ((i & 256) > 0 && (i & 512) > 0) {
            throw new XMPException("IsStruct and IsArray options are mutually exclusive", 103);
        }
        if ((i & 2) > 0 && (i & 768) > 0) {
            throw new XMPException("Structs and arrays can't have \"value\" options", 103);
        }
    }
}
