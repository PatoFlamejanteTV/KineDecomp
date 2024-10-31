package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Sb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaxf f11821a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzaph f11822b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sb(zzaph zzaphVar, zzaxf zzaxfVar) {
        this.f11822b = zzaphVar;
        this.f11821a = zzaxfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f11822b.mLock) {
            zzaph zzaphVar = this.f11822b;
            zzaphVar.zzdsj.zzb(this.f11821a);
        }
    }
}
