package io.grpc.okhttp.internal.framed;

/* compiled from: Settings.java */
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a */
    private int f27955a;

    /* renamed from: b */
    private int f27956b;

    /* renamed from: c */
    private int f27957c;

    /* renamed from: d */
    private final int[] f27958d = new int[10];

    public g a(int i, int i2, int i3) {
        if (i >= this.f27958d.length) {
            return this;
        }
        int i4 = 1 << i;
        this.f27955a |= i4;
        if ((i2 & 1) != 0) {
            this.f27956b |= i4;
        } else {
            this.f27956b &= i4 ^ (-1);
        }
        if ((i2 & 2) != 0) {
            this.f27957c |= i4;
        } else {
            this.f27957c &= i4 ^ (-1);
        }
        this.f27958d[i] = i3;
        return this;
    }

    public int b() {
        return Integer.bitCount(this.f27955a);
    }

    public boolean c(int i) {
        return ((1 << i) & this.f27955a) != 0;
    }

    public int b(int i) {
        return (this.f27955a & 32) != 0 ? this.f27958d[5] : i;
    }

    public int a(int i) {
        return this.f27958d[i];
    }

    public int a() {
        if ((this.f27955a & 2) != 0) {
            return this.f27958d[1];
        }
        return -1;
    }
}
