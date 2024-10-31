package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.zzk;

/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdOverlayInfoParcel f582a;
    final /* synthetic */ zzk.b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(zzk.b bVar, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.b = bVar;
        this.f582a = adOverlayInfoParcel;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzp.c().a(zzk.this.zzot.c, this.f582a);
    }
}
