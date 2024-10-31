package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzl;

/* renamed from: com.google.android.gms.ads.internal.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class RunnableC0782h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AdOverlayInfoParcel f10082a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ C0781g f10083b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0782h(C0781g c0781g, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.f10083b = c0781g;
        this.f10082a = adOverlayInfoParcel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbv.c();
        zzl.a(this.f10083b.f10033b.zzbls.f10251c, this.f10082a, true);
    }
}
