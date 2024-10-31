package com.google.android.gms.ads.internal;

/* loaded from: classes.dex */
final /* synthetic */ class G implements Runnable {

    /* renamed from: a */
    private final zzbl f9994a;

    private G(zzbl zzblVar) {
        this.f9994a = zzblVar;
    }

    public static Runnable a(zzbl zzblVar) {
        return new G(zzblVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9994a.c();
    }
}
