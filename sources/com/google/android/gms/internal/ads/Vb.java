package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Vb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaxf f11899a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzapt f11900b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Vb(zzapt zzaptVar, zzaxf zzaxfVar) {
        this.f11900b = zzaptVar;
        this.f11899a = zzaxfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzapm zzapmVar;
        zzapmVar = this.f11900b.zzdsj;
        zzapmVar.zzb(this.f11899a);
    }
}
