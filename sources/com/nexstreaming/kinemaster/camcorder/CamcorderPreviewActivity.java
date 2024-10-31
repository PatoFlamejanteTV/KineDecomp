package com.nexstreaming.kinemaster.camcorder;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.VideoView;
import com.nexstreaming.app.kinemasterfree.R;
import java.io.File;

/* loaded from: classes.dex */
public class CamcorderPreviewActivity extends AppCompatActivity {

    /* renamed from: a */
    private VideoView f19977a;

    /* renamed from: b */
    private ImageButton f19978b;

    /* renamed from: c */
    private boolean f19979c = false;

    /* renamed from: d */
    private String f19980d;

    /* renamed from: e */
    private View f19981e;

    /* renamed from: f */
    private View f19982f;

    /* renamed from: g */
    private View f19983g;

    /* renamed from: h */
    private View f19984h;
    private MediaPlayer i;
    private View j;
    private boolean k;
    private boolean l;
    private String m;

    public File s() {
        String str = this.f19980d;
        if (str == null) {
            return null;
        }
        File file = new File(str);
        File file2 = new File(this.f19980d.substring(0, this.f19980d.indexOf(".tmp")));
        if (file.exists()) {
            file.renameTo(file2);
        }
        return file2;
    }

    public void t() {
        this.f19978b.setVisibility(0);
        this.f19982f.setVisibility(0);
        this.f19983g.setVisibility(0);
        if (this.l && this.k) {
            this.f19984h.setVisibility(0);
        }
    }

    public void u() {
        if (this.f19979c) {
            this.f19977a.stopPlayback();
            this.f19977a.setVideoPath(this.f19980d);
            this.f19979c = false;
            t();
            return;
        }
        this.f19978b.setVisibility(4);
        this.f19982f.setVisibility(4);
        if (this.l && this.k) {
            this.f19984h.setVisibility(4);
        }
        this.f19983g.setVisibility(4);
        this.f19977a.seekTo(1);
        this.f19977a.start();
        this.f19979c = true;
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        setContentView(R.layout.camcorder_preview_activity);
        this.f19977a = (VideoView) findViewById(R.id.video_preview);
        this.f19978b = (ImageButton) findViewById(R.id.button_play);
        this.f19981e = findViewById(R.id.video_preview_holder);
        this.f19982f = findViewById(R.id.button_accept);
        this.f19983g = findViewById(R.id.button_reject);
        this.f19984h = findViewById(R.id.button_accept_layer);
        this.j = findViewById(R.id.busy_indicator);
        this.f19978b.setOnClickListener(new l(this));
        this.f19981e.setClickable(true);
        this.f19981e.setOnClickListener(new m(this));
        Intent intent = getIntent();
        if (intent != null) {
            this.f19980d = intent.getStringExtra("VIDEO_PATH");
            this.m = intent.getStringExtra("PROJECT_NAME");
            this.k = intent.getBooleanExtra("USE_AS_LAYER", false);
            this.l = intent.getBooleanExtra("IS_SUPPORT_LAYER", false);
        }
        this.f19977a.setOnCompletionListener(new n(this));
        this.f19977a.setOnPreparedListener(new p(this));
        this.f19982f.setOnClickListener(new r(this));
        if (this.l && this.k) {
            this.f19984h.setVisibility(0);
        } else {
            this.f19984h.setVisibility(8);
        }
        this.f19984h.setOnClickListener(new t(this));
        this.f19983g.setOnClickListener(new u(this));
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        String str = this.f19980d;
        if (str != null) {
            this.f19977a.setVideoPath(str);
        }
        super.onResume();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
