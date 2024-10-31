package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Yk {

    /* renamed from: a */
    public Pk f11988a;

    /* renamed from: b */
    public long f11989b;

    /* renamed from: c */
    public long f11990c;

    /* renamed from: d */
    public long f11991d;

    /* renamed from: e */
    public int f11992e;

    /* renamed from: f */
    public int f11993f;

    /* renamed from: g */
    public long[] f11994g;

    /* renamed from: h */
    public int[] f11995h;
    public int[] i;
    public int[] j;
    public long[] k;
    public boolean[] l;
    public boolean m;
    public boolean[] n;
    public zzjt o;
    public int p;
    public zzpx q;
    public boolean r;
    public long s;

    public final void a(int i) {
        zzpx zzpxVar = this.q;
        if (zzpxVar == null || zzpxVar.limit() < i) {
            this.q = new zzpx(i);
        }
        this.p = i;
        this.m = true;
        this.r = true;
    }

    public final long b(int i) {
        return this.k[i] + this.j[i];
    }
}
