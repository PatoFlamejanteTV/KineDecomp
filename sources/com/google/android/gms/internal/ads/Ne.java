package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Ne implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbdk f11710a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ne(zzbdk zzbdkVar) {
        this.f11710a = zzbdkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11710a.zzb("surfaceCreated", new String[0]);
    }
}
