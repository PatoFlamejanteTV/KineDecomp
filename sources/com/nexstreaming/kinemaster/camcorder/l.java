package com.nexstreaming.kinemaster.camcorder;

import android.media.MediaPlayer;

/* compiled from: CamcorderPreviewActivity.java */
/* loaded from: classes.dex */
class l implements MediaPlayer.OnCompletionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CamcorderPreviewActivity f3276a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(CamcorderPreviewActivity camcorderPreviewActivity) {
        this.f3276a = camcorderPreviewActivity;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f3276a.c = false;
        this.f3276a.a();
    }
}
