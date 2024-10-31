package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class _l implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ int f12045a;

    /* renamed from: b */
    private final /* synthetic */ long f12046b;

    /* renamed from: c */
    private final /* synthetic */ zzqv f12047c;

    public _l(zzqv zzqvVar, int i, long j) {
        this.f12047c = zzqvVar;
        this.f12045a = i;
        this.f12046b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqu zzquVar;
        zzquVar = this.f12047c.zzbko;
        zzquVar.zzh(this.f12045a, this.f12046b);
    }
}
