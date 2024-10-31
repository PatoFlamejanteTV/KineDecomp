package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Pe implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f11747a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzbdk f11748b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pe(zzbdk zzbdkVar, boolean z) {
        this.f11748b = zzbdkVar;
        this.f11747a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11748b.zzb("windowVisibilityChanged", "isVisible", String.valueOf(this.f11747a));
    }
}
