package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Ou */
/* loaded from: assets/audience_network.dex */
public final class C0632Ou {

    @Nullable
    public String A02;

    @Nullable
    public String A03;
    public final C2S A04;
    public final C00572c A05;
    public final C0362Ec A06;
    public C2T A01 = C2T.A01(null);
    public int A00 = 1000;

    public C0632Ou(C0362Ec c0362Ec, C2S c2s, C00572c c00572c) {
        this.A06 = c0362Ec;
        this.A04 = c2s;
        this.A05 = c00572c;
    }

    public static /* synthetic */ int A00(C0632Ou c0632Ou) {
        return c0632Ou.A00;
    }

    public static /* synthetic */ C2S A01(C0632Ou c0632Ou) {
        return c0632Ou.A04;
    }

    public static /* synthetic */ C2T A02(C0632Ou c0632Ou) {
        return c0632Ou.A01;
    }

    public static /* synthetic */ C00572c A03(C0632Ou c0632Ou) {
        return c0632Ou.A05;
    }

    public static /* synthetic */ C0362Ec A04(C0632Ou c0632Ou) {
        return c0632Ou.A06;
    }

    public static /* synthetic */ String A05(C0632Ou c0632Ou) {
        return c0632Ou.A03;
    }

    public static /* synthetic */ String A06(C0632Ou c0632Ou) {
        return c0632Ou.A02;
    }

    public final C0632Ou A07(int i) {
        this.A00 = i;
        return this;
    }

    public final C0632Ou A08(C2T c2t) {
        this.A01 = c2t;
        return this;
    }

    public final C0632Ou A09(String str) {
        this.A02 = str;
        return this;
    }

    public final C0632Ou A0A(String str) {
        this.A03 = str;
        return this;
    }

    public final C0633Ov A0B() {
        return new C0633Ov(this, null);
    }
}
