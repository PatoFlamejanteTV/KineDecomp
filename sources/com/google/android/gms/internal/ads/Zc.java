package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Zc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaxg f12004a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzauo f12005b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Zc(zzauo zzauoVar, zzaxg zzaxgVar) {
        this.f12005b = zzauoVar;
        this.f12004a = zzaxgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12005b.zzb(new zzaxf(this.f12004a, null, null, null, null, null, null, null));
    }
}
