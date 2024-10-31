package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.9e, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C02359e {
    public final long A00;
    public final EnumC02349d A01;
    public final String A02;
    public final boolean A03;

    public C02359e(String str, boolean z, EnumC02349d enumC02349d) {
        this(str, z, enumC02349d, System.currentTimeMillis());
    }

    public C02359e(String str, boolean z, EnumC02349d enumC02349d, long j) {
        this.A02 = str;
        this.A03 = z;
        this.A01 = enumC02349d;
        this.A00 = j;
    }

    public static C02359e A00() {
        return new C02359e("", true, EnumC02349d.A05, -1L);
    }

    public final long A01() {
        return this.A00;
    }

    public final EnumC02349d A02() {
        return this.A01;
    }

    public final String A03() {
        return this.A02;
    }

    public final boolean A04() {
        return this.A03;
    }
}
