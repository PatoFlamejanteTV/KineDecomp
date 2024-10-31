package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final /* synthetic */ class Pa implements Runnable {

    /* renamed from: a */
    private final zzaii f11744a;

    private Pa(zzaii zzaiiVar) {
        this.f11744a = zzaiiVar;
    }

    public static Runnable a(zzaii zzaiiVar) {
        return new Pa(zzaiiVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11744a.destroy();
    }
}
