package com.nexstreaming.kinemaster.camcorder;

import android.media.MediaPlayer;
import android.widget.VideoView;

/* compiled from: CamcorderPreviewActivity.java */
/* loaded from: classes.dex */
public class p implements MediaPlayer.OnPreparedListener {

    /* renamed from: a */
    final /* synthetic */ CamcorderPreviewActivity f20005a;

    public p(CamcorderPreviewActivity camcorderPreviewActivity) {
        this.f20005a = camcorderPreviewActivity;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        VideoView videoView;
        VideoView videoView2;
        VideoView videoView3;
        this.f20005a.i = mediaPlayer;
        videoView = this.f20005a.f19977a;
        videoView.seekTo(1);
        videoView2 = this.f20005a.f19977a;
        videoView2.start();
        videoView3 = this.f20005a.f19977a;
        videoView3.postDelayed(new o(this), 5L);
    }
}
