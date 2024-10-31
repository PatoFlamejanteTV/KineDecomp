package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final /* synthetic */ class Le implements Runnable {

    /* renamed from: a */
    private final zzbdi f11657a;

    private Le(zzbdi zzbdiVar) {
        this.f11657a = zzbdiVar;
    }

    public static Runnable a(zzbdi zzbdiVar) {
        return new Le(zzbdiVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11657a.stop();
    }
}
