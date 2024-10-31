package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class Xl implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzhn f11968a;

    /* renamed from: b */
    private final /* synthetic */ zzqv f11969b;

    public Xl(zzqv zzqvVar, zzhn zzhnVar) {
        this.f11969b = zzqvVar;
        this.f11968a = zzhnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqu zzquVar;
        zzquVar = this.f11969b.zzbko;
        zzquVar.zze(this.f11968a);
    }
}
