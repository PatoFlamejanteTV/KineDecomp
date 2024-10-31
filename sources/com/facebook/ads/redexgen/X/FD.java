package com.facebook.ads.redexgen.X;

import java.util.Map;

/* loaded from: assets/audience_network.dex */
public final class FD {
    public double A00;
    public double A01 = System.currentTimeMillis() / 1000.0d;
    public String A02;
    public Map<String, String> A03;

    public FD(double d, String str, Map<String, String> map) {
        this.A00 = d;
        this.A02 = str;
        this.A03 = map;
    }

    public final double A00() {
        return this.A00;
    }

    public final double A01() {
        return this.A01;
    }

    public final String A02() {
        return this.A02;
    }

    public final String A03() {
        return EnumC0427Gq.A09.toString();
    }

    public final Map<String, String> A04() {
        return this.A03;
    }
}
