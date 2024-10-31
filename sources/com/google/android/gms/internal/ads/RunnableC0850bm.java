package com.google.android.gms.internal.ads;

import android.view.Surface;

/* renamed from: com.google.android.gms.internal.ads.bm */
/* loaded from: classes2.dex */
public final class RunnableC0850bm implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Surface f12090a;

    /* renamed from: b */
    private final /* synthetic */ zzqv f12091b;

    public RunnableC0850bm(zzqv zzqvVar, Surface surface) {
        this.f12091b = zzqvVar;
        this.f12090a = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqu zzquVar;
        zzquVar = this.f12091b.zzbko;
        zzquVar.zza(this.f12090a);
    }
}
