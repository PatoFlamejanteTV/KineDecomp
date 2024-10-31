package com.google.android.gms.ads.internal;

/* loaded from: classes.dex */
final /* synthetic */ class F implements Runnable {

    /* renamed from: a */
    private final zzbl f9993a;

    private F(zzbl zzblVar) {
        this.f9993a = zzblVar;
    }

    public static Runnable a(zzbl zzblVar) {
        return new F(zzblVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9993a.b();
    }
}
