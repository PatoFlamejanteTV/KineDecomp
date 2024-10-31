package com.adobe.xmp.b;

import com.adobe.xmp.XMPException;

/* compiled from: AliasOptions.java */
/* loaded from: classes.dex */
public final class a extends c {
    public a() {
    }

    public a a(boolean z) {
        a(7680, z);
        return this;
    }

    @Override // com.adobe.xmp.b.c
    protected int b() {
        return 7680;
    }

    public a b(boolean z) {
        a(1536, z);
        return this;
    }

    public boolean c() {
        return b(512);
    }

    public boolean d() {
        return b(4096);
    }

    public boolean e() {
        return a() == 0;
    }

    public e f() throws XMPException {
        return new e(a());
    }

    public a(int i) throws XMPException {
        super(i);
    }
}
