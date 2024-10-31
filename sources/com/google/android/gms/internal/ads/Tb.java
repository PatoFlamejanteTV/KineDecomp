package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Tb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaxf f11839a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzapo f11840b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tb(zzapo zzapoVar, zzaxf zzaxfVar) {
        this.f11840b = zzapoVar;
        this.f11839a = zzaxfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzapm zzapmVar;
        zzapmVar = this.f11840b.zzdsj;
        zzapmVar.zzb(this.f11839a);
    }
}
