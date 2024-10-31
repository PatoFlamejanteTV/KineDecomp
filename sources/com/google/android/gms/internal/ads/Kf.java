package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Kf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbgr f11642a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Kf(zzbgr zzbgrVar) {
        this.f11642a = zzbgrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbgg zzbggVar;
        zzbggVar = this.f11642a.zzezc;
        zzbggVar.destroy();
    }
}
