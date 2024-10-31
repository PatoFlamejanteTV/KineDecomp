package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Oe implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbdk f11732a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Oe(zzbdk zzbdkVar) {
        this.f11732a = zzbdkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11732a.zzb("surfaceDestroyed", new String[0]);
    }
}
