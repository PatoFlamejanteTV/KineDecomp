package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.dk */
/* loaded from: classes2.dex */
public final class RunnableC0878dk implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ int f12129a;

    /* renamed from: b */
    private final /* synthetic */ long f12130b;

    /* renamed from: c */
    private final /* synthetic */ long f12131c;

    /* renamed from: d */
    private final /* synthetic */ zzgl f12132d;

    public RunnableC0878dk(zzgl zzglVar, int i, long j, long j2) {
        this.f12132d = zzglVar;
        this.f12129a = i;
        this.f12130b = j;
        this.f12131c = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgk zzgkVar;
        zzgkVar = this.f12132d.zzabi;
        zzgkVar.zza(this.f12129a, this.f12130b, this.f12131c);
    }
}
