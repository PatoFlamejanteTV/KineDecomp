package com.google.android.gms.internal.ads;

import android.app.Activity;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;

/* loaded from: classes2.dex */
final class Hb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AdOverlayInfoParcel f11559a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzanu f11560b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Hb(zzanu zzanuVar, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.f11560b = zzanuVar;
        this.f11559a = adOverlayInfoParcel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Activity activity;
        com.google.android.gms.ads.internal.zzbv.c();
        activity = this.f11560b.zzdow;
        com.google.android.gms.ads.internal.overlay.zzl.a(activity, this.f11559a, true);
    }
}
