package com.nexstreaming.kinemaster.camcorder;

import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.VideoView;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CamcorderPreviewActivity.java */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CamcorderPreviewActivity f20009a;

    public t(CamcorderPreviewActivity camcorderPreviewActivity) {
        this.f20009a = camcorderPreviewActivity;
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
        File s;
        String str2;
        Intent intent = this.f20009a.getIntent();
        str = this.f20009a.f19980d;
        if (str != null) {
            s = this.f20009a.s();
            this.f20009a.f19980d = s.getAbsolutePath();
            str2 = this.f20009a.f19980d;
            intent.putExtra("VIDEO_PATH", str2);
            intent.putExtra("USE_AS_LAYER", true);
        }
        this.f20009a.setResult(-1, intent);
        videoView = this.f20009a.f19977a;
        videoView.setVisibility(8);
        view2 = this.f20009a.f19982f;
        view2.setVisibility(8);
        view3 = this.f20009a.f19984h;
        view3.setVisibility(8);
        view4 = this.f20009a.f19983g;
        view4.setVisibility(8);
        imageButton = this.f20009a.f19978b;
        imageButton.setVisibility(8);
        view5 = this.f20009a.j;
        view5.setVisibility(0);
        mediaPlayer = this.f20009a.i;
        if (mediaPlayer != null) {
            mediaPlayer2 = this.f20009a.i;
            mediaPlayer2.release();
            this.f20009a.i = null;
        }
        view6 = this.f20009a.f19984h;
        view6.postDelayed(new s(this), 500L);
    }
}
