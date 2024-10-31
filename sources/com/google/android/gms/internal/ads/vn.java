package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class vn extends zzww {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzyz f12617a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public vn(zzyz zzyzVar) {
        this.f12617a = zzyzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzww, com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(int i) {
        VideoController videoController;
        videoController = this.f12617a.zzcml;
        videoController.a(this.f12617a.zzbc());
        super.onAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.internal.ads.zzww, com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        VideoController videoController;
        videoController = this.f12617a.zzcml;
        videoController.a(this.f12617a.zzbc());
        super.onAdLoaded();
    }
}
