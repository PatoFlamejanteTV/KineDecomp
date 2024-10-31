package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SimpleToken.java */
/* loaded from: classes2.dex */
public final class c extends e {

    /* renamed from: c */
    private final short f18986c;

    /* renamed from: d */
    private final short f18987d;

    public c(e eVar, int i, int i2) {
        super(eVar);
        this.f18986c = (short) i;
        this.f18987d = (short) i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.zxing.aztec.encoder.e
    public void a(BitArray bitArray, byte[] bArr) {
        bitArray.a(this.f18986c, this.f18987d);
    }

    public String toString() {
        short s = this.f18986c;
        short s2 = this.f18987d;
        return "<" + Integer.toBinaryString((s & ((1 << s2) - 1)) | (1 << s2) | (1 << this.f18987d)).substring(1) + '>';
    }
}
