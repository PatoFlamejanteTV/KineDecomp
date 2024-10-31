package com.nexstreaming.kinemaster.camcorder;

import android.media.MediaPlayer;
import android.widget.VideoView;

/* compiled from: CamcorderPreviewActivity.java */
/* loaded from: classes.dex */
class m implements MediaPlayer.OnPreparedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CamcorderPreviewActivity f3277a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(CamcorderPreviewActivity camcorderPreviewActivity) {
        this.f3277a = camcorderPreviewActivity;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        VideoView videoView;
        VideoView videoView2;
        VideoView videoView3;
        this.f3277a.i = mediaPlayer;
        videoView = this.f3277a.f3263a;
        videoView.seekTo(1);
        videoView2 = this.f3277a.f3263a;
        videoView2.start();
        videoView3 = this.f3277a.f3263a;
        videoView3.postDelayed(new n(this), 5L);
    }
}
