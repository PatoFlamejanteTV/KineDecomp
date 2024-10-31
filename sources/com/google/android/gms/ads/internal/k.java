package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzaxf;
import com.google.android.gms.internal.ads.zzaxg;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class K implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaxg f9998a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzh f9999b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public K(zzh zzhVar, zzaxg zzaxgVar) {
        this.f9999b = zzhVar;
        this.f9998a = zzaxgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9999b.zzb(new zzaxf(this.f9998a, null, null, null, null, null, null, null));
    }
}
