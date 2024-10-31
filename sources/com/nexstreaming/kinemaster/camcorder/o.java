package com.nexstreaming.kinemaster.camcorder;

import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.VideoView;

/* compiled from: CamcorderPreviewActivity.java */
/* loaded from: classes.dex */
class o implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CamcorderPreviewActivity f3279a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(CamcorderPreviewActivity camcorderPreviewActivity) {
        this.f3279a = camcorderPreviewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        VideoView videoView;
        View view2;
        View view3;
        View view4;
        ImageButton imageButton;
        View view5;
        MediaPlayer mediaPlayer;
        View view6;
        MediaPlayer mediaPlayer2;
        String str2;
        Intent intent = this.f3279a.getIntent();
        str = this.f3279a.d;
        if (str != null) {
            str2 = this.f3279a.d;
            intent.putExtra("VIDEO_PATH", str2);
            intent.putExtra("USE_AS_LAYER", false);
        }
        this.f3279a.setResult(-1, intent);
        videoView = this.f3279a.f3263a;
        videoView.setVisibility(8);
        view2 = this.f3279a.f;
        view2.setVisibility(8);
        view3 = this.f3279a.h;
        view3.setVisibility(8);
        view4 = this.f3279a.g;
        view4.setVisibility(8);
        imageButton = this.f3279a.b;
        imageButton.setVisibility(8);
        view5 = this.f3279a.j;
        view5.setVisibility(0);
        mediaPlayer = this.f3279a.i;
        if (mediaPlayer != null) {
            mediaPlayer2 = this.f3279a.i;
            mediaPlayer2.release();
            this.f3279a.i = null;
        }
        view6 = this.f3279a.f;
        view6.postDelayed(new p(this), 500L);
    }
}
