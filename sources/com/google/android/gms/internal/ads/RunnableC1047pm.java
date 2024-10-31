package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaf;

/* renamed from: com.google.android.gms.internal.ads.pm */
/* loaded from: classes2.dex */
public final class RunnableC1047pm implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f12436a;

    /* renamed from: b */
    private final /* synthetic */ long f12437b;

    /* renamed from: c */
    private final /* synthetic */ zzr f12438c;

    public RunnableC1047pm(zzr zzrVar, String str, long j) {
        this.f12438c = zzrVar;
        this.f12436a = str;
        this.f12437b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaf.a aVar;
        zzaf.a aVar2;
        aVar = this.f12438c.zzae;
        aVar.a(this.f12436a, this.f12437b);
        aVar2 = this.f12438c.zzae;
        aVar2.a(this.f12438c.toString());
    }
}
