package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzavr;
import com.google.android.gms.internal.ads.zzawd;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.ads.internal.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0780f implements zzavr {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzal f10031a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0780f(zzal zzalVar) {
        this.f10031a = zzalVar;
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void onRewardedVideoAdClosed() {
        this.f10031a.zziv();
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void onRewardedVideoAdLeftApplication() {
        this.f10031a.zzij();
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void onRewardedVideoAdOpened() {
        this.f10031a.zziw();
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void onRewardedVideoCompleted() {
        this.f10031a.w();
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void onRewardedVideoStarted() {
        this.f10031a.v();
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void zzc(zzawd zzawdVar) {
        this.f10031a.a(zzawdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void zzkh() {
        this.f10031a.onAdClicked();
    }
}
