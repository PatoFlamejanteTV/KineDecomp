package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.bk */
/* loaded from: classes2.dex */
public final class RunnableC0848bk implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f12086a;

    /* renamed from: b */
    private final /* synthetic */ long f12087b;

    /* renamed from: c */
    private final /* synthetic */ long f12088c;

    /* renamed from: d */
    private final /* synthetic */ zzgl f12089d;

    public RunnableC0848bk(zzgl zzglVar, String str, long j, long j2) {
        this.f12089d = zzglVar;
        this.f12086a = str;
        this.f12087b = j;
        this.f12088c = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgk zzgkVar;
        zzgkVar = this.f12089d.zzabi;
        zzgkVar.zza(this.f12086a, this.f12087b, this.f12088c);
    }
}
