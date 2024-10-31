package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Mk implements Kk {

    /* renamed from: a */
    private final int f11694a;

    /* renamed from: b */
    private final int f11695b;

    /* renamed from: c */
    private final zzpx f11696c;

    public Mk(Gk gk) {
        this.f11696c = gk.Qa;
        this.f11696c.setPosition(12);
        this.f11694a = this.f11696c.zzhg();
        this.f11695b = this.f11696c.zzhg();
    }

    @Override // com.google.android.gms.internal.ads.Kk
    public final int a() {
        int i = this.f11694a;
        return i == 0 ? this.f11696c.zzhg() : i;
    }

    @Override // com.google.android.gms.internal.ads.Kk
    public final boolean b() {
        return this.f11694a != 0;
    }

    @Override // com.google.android.gms.internal.ads.Kk
    public final int c() {
        return this.f11695b;
    }
}
