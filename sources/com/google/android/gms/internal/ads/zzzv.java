package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* loaded from: classes2.dex */
public final class zzzv extends zzyt {
    private final VideoController.VideoLifecycleCallbacks zzwc;

    public zzzv(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.zzwc = videoLifecycleCallbacks;
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final void onVideoEnd() {
        this.zzwc.onVideoEnd();
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final void onVideoMute(boolean z) {
        this.zzwc.onVideoMute(z);
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final void onVideoPause() {
        this.zzwc.onVideoPause();
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final void onVideoPlay() {
        this.zzwc.onVideoPlay();
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final void onVideoStart() {
        this.zzwc.onVideoStart();
    }
}
