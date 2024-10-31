package com.facebook.ads.redexgen.X;

import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Ge, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0415Ge {
    public double A00;
    public EnumC0426Gp A01;
    public EnumC0427Gq A02;
    public String A03;
    public String A04;
    public Map<String, String> A05;
    public boolean A06;

    public final C0415Ge A00(double d) {
        this.A00 = d;
        return this;
    }

    public final C0415Ge A01(EnumC0426Gp enumC0426Gp) {
        this.A01 = enumC0426Gp;
        return this;
    }

    public final C0415Ge A02(EnumC0427Gq enumC0427Gq) {
        this.A02 = enumC0427Gq;
        return this;
    }

    public final C0415Ge A03(String str) {
        this.A03 = str;
        return this;
    }

    public final C0415Ge A04(String str) {
        this.A04 = str;
        return this;
    }

    public final C0415Ge A05(Map<String, String> mData) {
        this.A05 = mData;
        return this;
    }

    public final C0415Ge A06(boolean z) {
        this.A06 = z;
        return this;
    }

    public final C0416Gf A07(C0361Eb c0361Eb) {
        return new C0416Gf(c0361Eb, this.A04, this.A00, this.A03, this.A05, this.A01, this.A02, this.A06);
    }
}
