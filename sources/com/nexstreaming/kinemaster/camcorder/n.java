package com.nexstreaming.kinemaster.camcorder;

import android.media.MediaPlayer;

/* compiled from: CamcorderPreviewActivity.java */
/* loaded from: classes.dex */
class n implements MediaPlayer.OnCompletionListener {

    /* renamed from: a */
    final /* synthetic */ CamcorderPreviewActivity f20003a;

    public n(CamcorderPreviewActivity camcorderPreviewActivity) {
        this.f20003a = camcorderPreviewActivity;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f20003a.f19979c = false;
        this.f20003a.t();
    }
}
