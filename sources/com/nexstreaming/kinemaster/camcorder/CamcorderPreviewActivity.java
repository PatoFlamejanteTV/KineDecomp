package com.nexstreaming.kinemaster.camcorder;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.VideoView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* loaded from: classes.dex */
public class CamcorderPreviewActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private VideoView f3263a;
    private ImageButton b;
    private boolean c = false;
    private String d;
    private View e;
    private View f;
    private View g;
    private View h;
    private MediaPlayer i;
    private View j;
    private boolean k;
    private boolean l;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.camcorder_preview_activity);
        this.f3263a = (VideoView) findViewById(R.id.video_preview);
        this.b = (ImageButton) findViewById(R.id.button_play);
        this.e = findViewById(R.id.video_preview_holder);
        this.f = findViewById(R.id.button_accept);
        this.g = findViewById(R.id.button_reject);
        this.h = findViewById(R.id.button_accept_layer);
        this.j = findViewById(R.id.busy_indicator);
        this.b.setOnClickListener(new j(this));
        this.e.setClickable(true);
        this.e.setOnClickListener(new k(this));
        Intent intent = getIntent();
        if (intent != null) {
            this.d = intent.getStringExtra("VIDEO_PATH");
            this.k = intent.getBooleanExtra("USE_AS_LAYER", false);
            this.l = intent.getBooleanExtra("IS_SUPPORT_LAYER", false);
        }
        this.f3263a.setOnCompletionListener(new l(this));
        this.f3263a.setOnPreparedListener(new m(this));
        this.f.setOnClickListener(new o(this));
        if (this.l && this.k) {
            this.h.setVisibility(0);
        } else {
            this.h.setVisibility(8);
        }
        this.h.setOnClickListener(new q(this));
        this.g.setOnClickListener(new s(this));
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onResume() {
        if (this.d != null) {
            this.f3263a.setVideoPath(this.d);
        }
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onStart() {
        KMUsage.Activity_CamcorderPreview.begin();
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onStop() {
        KMUsage.Activity_CamcorderPreview.end();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.b.setVisibility(0);
        this.f.setVisibility(0);
        this.g.setVisibility(0);
        if (this.l && this.k) {
            this.h.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.c) {
            this.f3263a.stopPlayback();
            this.f3263a.setVideoPath(this.d);
            this.c = false;
            a();
            return;
        }
        this.b.setVisibility(4);
        this.f.setVisibility(4);
        if (this.l && this.k) {
            this.h.setVisibility(4);
        }
        this.g.setVisibility(4);
        this.f3263a.seekTo(1);
        this.f3263a.start();
        this.c = true;
    }
}
