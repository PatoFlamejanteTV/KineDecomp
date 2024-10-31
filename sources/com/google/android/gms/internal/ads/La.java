package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final /* synthetic */ class La implements Runnable {

    /* renamed from: a */
    private final zzaii f11652a;

    private La(zzaii zzaiiVar) {
        this.f11652a = zzaiiVar;
    }

    public static Runnable a(zzaii zzaiiVar) {
        return new La(zzaiiVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11652a.destroy();
    }
}
