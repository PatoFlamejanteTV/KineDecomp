package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.2p, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C00702p {
    public int A00;
    public int A01;
    public String A02;

    public C00702p(String str, int i, int i2) {
        this.A02 = str;
        this.A01 = Math.min(KE.A02.widthPixels, (int) (i * KE.A01));
        this.A00 = Math.min(KE.A02.heightPixels, (int) (i2 * KE.A01));
    }

    public final int A00() {
        return this.A00;
    }

    public final int A01() {
        return this.A01;
    }

    public final String A02() {
        return this.A02;
    }
}
