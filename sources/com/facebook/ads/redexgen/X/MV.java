package com.facebook.ads.redexgen.X;

/* loaded from: assets/audience_network.dex */
public class MV {
    public int A00;
    public KM A01;
    public MX A02;
    public String A03;
    public String A04;
    public String A05;
    public String A06;
    public final C0362Ec A0C;
    public boolean A0A = true;
    public boolean A0B = true;
    public boolean A09 = true;
    public boolean A07 = true;
    public boolean A08 = true;

    public MV(C0362Ec c0362Ec, MX mx) {
        this.A0C = c0362Ec;
        this.A02 = mx;
    }

    public static /* synthetic */ int A00(MV mv) {
        return mv.A00;
    }

    public static /* synthetic */ C0362Ec A01(MV mv) {
        return mv.A0C;
    }

    public static /* synthetic */ KM A02(MV mv) {
        return mv.A01;
    }

    public static /* synthetic */ MX A03(MV mv) {
        return mv.A02;
    }

    public static /* synthetic */ String A04(MV mv) {
        return mv.A06;
    }

    public static /* synthetic */ String A05(MV mv) {
        return mv.A05;
    }

    public static /* synthetic */ String A06(MV mv) {
        return mv.A04;
    }

    public static /* synthetic */ String A07(MV mv) {
        return mv.A03;
    }

    public static /* synthetic */ boolean A08(MV mv) {
        return mv.A09;
    }

    public static /* synthetic */ boolean A09(MV mv) {
        return mv.A0B;
    }

    public static /* synthetic */ boolean A0A(MV mv) {
        return mv.A07;
    }

    public static /* synthetic */ boolean A0B(MV mv) {
        return mv.A08;
    }

    public static /* synthetic */ boolean A0C(MV mv) {
        return mv.A0A;
    }

    public final MV A0D(int i) {
        this.A00 = i;
        return this;
    }

    public final MV A0E(KM km) {
        this.A01 = km;
        return this;
    }

    public final MV A0F(String str) {
        this.A03 = str;
        return this;
    }

    public final MV A0G(String str) {
        this.A04 = str;
        return this;
    }

    public final MV A0H(String str) {
        this.A05 = str;
        return this;
    }

    public final MV A0I(String str) {
        this.A06 = str;
        return this;
    }

    public final MV A0J(boolean z) {
        this.A09 = z;
        return this;
    }

    public final MV A0K(boolean z) {
        this.A0A = z;
        return this;
    }

    public final MV A0L(boolean z) {
        this.A0B = z;
        return this;
    }

    public final MW A0M() {
        return new MW(this, null);
    }
}
