package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.ek */
/* loaded from: classes2.dex */
public final class RunnableC0892ek implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzhn f12147a;

    /* renamed from: b */
    private final /* synthetic */ zzgl f12148b;

    public RunnableC0892ek(zzgl zzglVar, zzhn zzhnVar) {
        this.f12148b = zzglVar;
        this.f12147a = zzhnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgk zzgkVar;
        this.f12147a.zzds();
        zzgkVar = this.f12148b.zzabi;
        zzgkVar.zzb(this.f12147a);
    }
}
