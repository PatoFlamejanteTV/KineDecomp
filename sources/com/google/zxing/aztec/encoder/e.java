package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

/* compiled from: Token.java */
/* loaded from: classes2.dex */
public abstract class e {

    /* renamed from: a */
    static final e f18993a = new c(null, 0, 0);

    /* renamed from: b */
    private final e f18994b;

    public e(e eVar) {
        this.f18994b = eVar;
    }

    public final e a() {
        return this.f18994b;
    }

    public abstract void a(BitArray bitArray, byte[] bArr);

    public final e b(int i, int i2) {
        return new a(this, i, i2);
    }

    public final e a(int i, int i2) {
        return new c(this, i, i2);
    }
}
