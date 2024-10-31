package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Ik {

    /* renamed from: a */
    public final int f11608a;

    /* renamed from: b */
    public int f11609b;

    /* renamed from: c */
    public int f11610c;

    /* renamed from: d */
    public long f11611d;

    /* renamed from: e */
    private final boolean f11612e;

    /* renamed from: f */
    private final zzpx f11613f;

    /* renamed from: g */
    private final zzpx f11614g;

    /* renamed from: h */
    private int f11615h;
    private int i;

    public Ik(zzpx zzpxVar, zzpx zzpxVar2, boolean z) {
        this.f11614g = zzpxVar;
        this.f11613f = zzpxVar2;
        this.f11612e = z;
        zzpxVar2.setPosition(12);
        this.f11608a = zzpxVar2.zzhg();
        zzpxVar.setPosition(12);
        this.i = zzpxVar.zzhg();
        zzpo.checkState(zzpxVar.readInt() == 1, "first_chunk must be 1");
        this.f11609b = -1;
    }

    public final boolean a() {
        int i = this.f11609b + 1;
        this.f11609b = i;
        if (i == this.f11608a) {
            return false;
        }
        this.f11611d = this.f11612e ? this.f11613f.zzhh() : this.f11613f.zzhd();
        if (this.f11609b == this.f11615h) {
            this.f11610c = this.f11614g.zzhg();
            this.f11614g.zzbl(4);
            int i2 = this.i - 1;
            this.i = i2;
            this.f11615h = i2 > 0 ? this.f11614g.zzhg() - 1 : -1;
        }
        return true;
    }
}
