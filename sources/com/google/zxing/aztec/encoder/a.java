package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BinaryShiftToken.java */
/* loaded from: classes2.dex */
public final class a extends e {

    /* renamed from: c */
    private final short f18983c;

    /* renamed from: d */
    private final short f18984d;

    public a(e eVar, int i, int i2) {
        super(eVar);
        this.f18983c = (short) i;
        this.f18984d = (short) i2;
    }

    @Override // com.google.zxing.aztec.encoder.e
    public void a(BitArray bitArray, byte[] bArr) {
        int i = 0;
        while (true) {
            short s = this.f18984d;
            if (i >= s) {
                return;
            }
            if (i == 0 || (i == 31 && s <= 62)) {
                bitArray.a(31, 5);
                short s2 = this.f18984d;
                if (s2 > 62) {
                    bitArray.a(s2 - 31, 16);
                } else if (i == 0) {
                    bitArray.a(Math.min((int) s2, 31), 5);
                } else {
                    bitArray.a(s2 - 31, 5);
                }
            }
            bitArray.a(bArr[this.f18983c + i], 8);
            i++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append((int) this.f18983c);
        sb.append("::");
        sb.append((this.f18983c + this.f18984d) - 1);
        sb.append('>');
        return sb.toString();
    }
}
