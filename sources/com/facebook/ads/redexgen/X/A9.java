package com.facebook.ads.redexgen.X;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* loaded from: assets/audience_network.dex */
public class A9 {
    public double A00;
    public float A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public long A07;
    public long A08;
    public long A09;
    public A5 A0A;
    public A3 A0B;
    public A1 A0C;
    public EnumC0349Dp A0D;
    public EB A0E;
    public EC A0F;
    public Class A0G;

    @Nullable
    public String A0H;

    @Nullable
    public String A0I;
    public String A0J;
    public HashMap<Integer, Integer> A0K;
    public Map<Integer, String> A0L;
    public ScheduledExecutorService A0M;
    public boolean A0N;

    public final A9 A00(double d) {
        this.A00 = d;
        return this;
    }

    public final A9 A01(float f) {
        this.A01 = f;
        return this;
    }

    public final A9 A02(int i) {
        this.A02 = i;
        return this;
    }

    public final A9 A03(int i) {
        this.A03 = i;
        return this;
    }

    public final A9 A04(int i) {
        this.A04 = i;
        return this;
    }

    public final A9 A05(int i) {
        this.A05 = i;
        return this;
    }

    public final A9 A06(int i) {
        this.A06 = i;
        return this;
    }

    public final A9 A07(long j) {
        this.A07 = j;
        return this;
    }

    public final A9 A08(long j) {
        this.A08 = j;
        return this;
    }

    public final A9 A09(A5 a5) {
        this.A0A = a5;
        return this;
    }

    public final A9 A0A(A3 a3) {
        this.A0B = a3;
        return this;
    }

    public final A9 A0B(A1 a1) {
        this.A0C = a1;
        return this;
    }

    public final A9 A0C(EnumC0349Dp enumC0349Dp) {
        this.A0D = enumC0349Dp;
        return this;
    }

    public final A9 A0D(Class cls) {
        this.A0G = cls;
        return this;
    }

    public final A9 A0E(@Nullable String str) {
        this.A0I = str;
        return this;
    }

    public final A9 A0F(String str) {
        this.A0J = str;
        return this;
    }

    public final A9 A0G(HashMap<Integer, Integer> circularBufferLengthMap) {
        this.A0K = circularBufferLengthMap;
        return this;
    }

    public final A9 A0H(Map map) {
        this.A0L = map;
        return this;
    }

    public final A9 A0I(boolean z) {
        this.A0N = z;
        return this;
    }

    public final AA A0J() {
        AA aa = new AA();
        aa.A0J = this.A0N;
        aa.A02 = this.A04;
        aa.A0G = this.A0K;
        aa.A01 = this.A03;
        aa.A00 = this.A02;
        aa.A04 = this.A06;
        aa.A0F = this.A0J;
        aa.A07 = this.A0B;
        aa.A06 = this.A0A;
        double unused = AA.A0K = this.A00;
        aa.A09 = this.A0D;
        aa.A0H = this.A0L;
        aa.A03 = this.A05;
        aa.A0C = this.A0G;
        aa.A08 = this.A0C;
        float unused2 = AA.A0L = this.A01;
        long unused3 = AA.A0N = this.A08;
        long unused4 = AA.A0M = this.A07;
        aa.A05 = this.A09;
        aa.A0B = this.A0F;
        aa.A0A = this.A0E;
        aa.A0I = this.A0M;
        aa.A0D = this.A0H;
        aa.A0E = this.A0I;
        return aa;
    }
}
