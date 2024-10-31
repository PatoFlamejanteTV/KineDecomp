package com.nexstreaming.kinemaster.ui.previewplay;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.ba;
import com.nextreaming.nexvideoeditor.NexThemeView;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

/* loaded from: classes.dex */
public class PreviewPlayActivity extends ba implements View.OnSystemUiVisibilityChangeListener, VideoEditor.d, VideoEditor.f, VideoEditor.g {

    /* renamed from: a, reason: collision with root package name */
    private NexThemeView f3718a;
    private File b;
    private VideoEditor c;
    private SeekBar g;
    private View h;
    private TextView i;
    private TextView j;
    private boolean l;
    private int m;
    private View p;
    private int e = 0;
    private boolean f = true;
    private boolean k = false;
    private boolean n = false;
    private boolean o = false;
    private long q = 0;
    private boolean r = true;
    private boolean s = false;
    private Runnable t = new k(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.v3_playback_activity);
        this.f3718a = (NexThemeView) findViewById(R.id.previewView);
        this.c = new VideoEditor(E(), this, false, this.f3718a);
        this.h = findViewById(R.id.playPauseButton);
        this.g = (SeekBar) findViewById(R.id.videoSeekBar);
        this.i = (TextView) findViewById(R.id.elapsedTime);
        this.j = (TextView) findViewById(R.id.totalTime);
        this.p = findViewById(R.id.playerControls);
        this.f3718a.setOnSystemUiVisibilityChangeListener(this);
        e();
        f();
        this.l = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("show_cts_centisecond", false);
        this.c.a((VideoEditor.g) this);
        this.c.a((VideoEditor.f) this);
        this.c.a((VideoEditor.d) this);
        Intent intent = getIntent();
        this.b = null;
        if (intent != null && intent.getData() != null && intent.getData().toString() != null) {
            try {
                this.b = new File(new URI(intent.getData().toString()));
            } catch (URISyntaxException e) {
                Log.e("PreviewPlayActivity", "", e);
            }
        }
        if (this.b == null || !this.b.exists()) {
            finish();
            return;
        }
        if (bundle != null) {
            this.e = bundle.getInt("currentTime");
            this.f = bundle.getBoolean("requestedPlay");
        }
        b().b(this.b).onComplete(new b(this)).onFailure(new a(this));
        b().c(false);
        b().a(EditorGlobal.c("up"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.h.setOnClickListener(new e(this));
        this.f3718a.setOnClickListener(new f(this));
        this.p.setOnTouchListener(new g(this));
        this.g.setOnSeekBarChangeListener(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("requestedPlay", this.f);
        bundle.putInt("currentTime", this.e);
        super.onSaveInstanceState(bundle);
    }

    public VideoEditor b() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onStart() {
        KMUsage.Activity_PreviewPlay.begin();
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onStop() {
        KMUsage.Activity_PreviewPlay.end();
        b().p();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onPause() {
        this.k = true;
        b().p();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onResume() {
        if (this.k && this.f) {
            b().r();
        }
        this.k = false;
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba
    public void a(boolean z) {
        super.a(z);
        if (B()) {
            b().c(false);
            b().a(EditorGlobal.c("up"));
        } else {
            b().c(true);
            b().a(EditorGlobal.c("std"));
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.g
    public void a(int i, int i2) {
        this.e = i;
        if (!this.n && !this.o && b().t() == VideoEditor.State.Playing) {
            this.g.setProgress(this.e);
        }
        this.i.setText(a(this.e));
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.f
    public void a(VideoEditor.State state) {
        if (state == VideoEditor.State.Playing && !this.s) {
            getWindow().addFlags(128);
            this.s = true;
        } else if (state != VideoEditor.State.Playing && this.s) {
            getWindow().clearFlags(128);
            this.s = false;
        }
        switch (state) {
            case Playing:
                f();
                this.h.setSelected(true);
                return;
            default:
                if (EditorGlobal.f != EditorGlobal.VersionType.ShowDemo) {
                    e();
                }
                this.h.setSelected(false);
                return;
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.d
    public void a() {
        if (EditorGlobal.f == EditorGlobal.VersionType.ShowDemo) {
            b().p();
            b().a(0);
            b().r();
        } else {
            b().p();
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i) {
        return this.l ? String.format("%02d:%02d:%02d.%02d", Integer.valueOf(i / 3600000), Integer.valueOf((i % 3600000) / 60000), Integer.valueOf((i % 60000) / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED), Integer.valueOf((i % LicenseErrCode.LICENSE_STATUS_NOT_LICENSED) / 10)) : String.format("%02d:%02d:%02d.%01d", Integer.valueOf(i / 3600000), Integer.valueOf((i % 3600000) / 60000), Integer.valueOf((i % 60000) / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED), Integer.valueOf((i % LicenseErrCode.LICENSE_STATUS_NOT_LICENSED) / 100));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f3718a.setSystemUiVisibility(1028);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f3718a.removeCallbacks(this.t);
        this.f3718a.setSystemUiVisibility(1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f3718a.removeCallbacks(this.t);
        this.f3718a.postDelayed(this.t, 2000L);
    }

    private void g() {
        this.p.animate().alpha(0.0f);
        this.h.setEnabled(false);
        this.g.setEnabled(false);
        this.r = false;
    }

    private void h() {
        this.p.animate().alpha(1.0f);
        this.h.setEnabled(true);
        this.g.setEnabled(true);
        this.r = true;
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public void onSystemUiVisibilityChange(int i) {
        this.q = System.nanoTime();
        if ((i & 4) != 0) {
            g();
        } else {
            h();
        }
    }
}
