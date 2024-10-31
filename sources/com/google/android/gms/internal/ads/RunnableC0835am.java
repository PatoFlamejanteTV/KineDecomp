package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.am */
/* loaded from: classes2.dex */
public final class RunnableC0835am implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ int f12069a;

    /* renamed from: b */
    private final /* synthetic */ int f12070b;

    /* renamed from: c */
    private final /* synthetic */ int f12071c;

    /* renamed from: d */
    private final /* synthetic */ float f12072d;

    /* renamed from: e */
    private final /* synthetic */ zzqv f12073e;

    public RunnableC0835am(zzqv zzqvVar, int i, int i2, int i3, float f2) {
        this.f12073e = zzqvVar;
        this.f12069a = i;
        this.f12070b = i2;
        this.f12071c = i3;
        this.f12072d = f2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqu zzquVar;
        zzquVar = this.f12073e.zzbko;
        zzquVar.zza(this.f12069a, this.f12070b, this.f12071c, this.f12072d);
    }
}
