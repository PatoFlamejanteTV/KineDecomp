package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class Zl implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzfs f12019a;

    /* renamed from: b */
    private final /* synthetic */ zzqv f12020b;

    public Zl(zzqv zzqvVar, zzfs zzfsVar) {
        this.f12020b = zzqvVar;
        this.f12019a = zzfsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqu zzquVar;
        zzquVar = this.f12020b.zzbko;
        zzquVar.zzl(this.f12019a);
    }
}
