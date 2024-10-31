package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Nk implements Kk {

    /* renamed from: a */
    private final zzpx f11719a;

    /* renamed from: b */
    private final int f11720b;

    /* renamed from: c */
    private final int f11721c;

    /* renamed from: d */
    private int f11722d;

    /* renamed from: e */
    private int f11723e;

    public Nk(Gk gk) {
        this.f11719a = gk.Qa;
        this.f11719a.setPosition(12);
        this.f11721c = this.f11719a.zzhg() & 255;
        this.f11720b = this.f11719a.zzhg();
    }

    @Override // com.google.android.gms.internal.ads.Kk
    public final int a() {
        int i = this.f11721c;
        if (i == 8) {
            return this.f11719a.readUnsignedByte();
        }
        if (i == 16) {
            return this.f11719a.readUnsignedShort();
        }
        int i2 = this.f11722d;
        this.f11722d = i2 + 1;
        if (i2 % 2 == 0) {
            this.f11723e = this.f11719a.readUnsignedByte();
            return (this.f11723e & 240) >> 4;
        }
        return this.f11723e & 15;
    }

    @Override // com.google.android.gms.internal.ads.Kk
    public final boolean b() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.Kk
    public final int c() {
        return this.f11720b;
    }
}
