package com.nexstreaming.kinemaster.ui.previewplay;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.I;
import com.nextreaming.nexeditorui.ProjectAspectRatio;
import com.nextreaming.nexvideoeditor.NexThemeView;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes.dex */
public class PreviewPlayActivity extends I implements VideoEditor.g, VideoEditor.f, VideoEditor.d, View.OnSystemUiVisibilityChangeListener, com.nexstreaming.app.general.iab.a.a {
    private NexThemeView H;
    private VideoEditor I;
    private SeekBar J;
    private View K;
    private TextView L;
    private TextView M;
    private View N;
    private int O = 0;
    private int P = 0;
    private int Q = -1;
    private int R = 0;
    private long S = 0;
    private boolean T = false;
    private boolean U = false;
    private boolean V = false;
    private boolean W = false;
    private boolean X = true;
    private boolean Y = true;
    private boolean Z = false;
    private Runnable aa = new Runnable() { // from class: com.nexstreaming.kinemaster.ui.previewplay.b
        @Override // java.lang.Runnable
        public final void run() {
            PreviewPlayActivity.this.G();
        }
    };

    private VideoEditor K() {
        return this.I;
    }

    private void L() {
        this.H.setSystemUiVisibility(1028);
    }

    private void M() {
        this.H.removeCallbacks(this.aa);
        this.H.postDelayed(this.aa, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        this.U = true;
        S();
        this.Z = true;
        this.Q = -1;
        K().M().onComplete(new Task.OnTaskEventListener() { // from class: com.nexstreaming.kinemaster.ui.previewplay.a
            @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
            public final void onTaskEvent(Task task, Task.Event event) {
                PreviewPlayActivity.this.c(task, event);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        this.U = false;
        T();
    }

    private void P() {
        this.N.animate().alpha(0.0f);
        this.K.setEnabled(false);
        this.J.setEnabled(false);
        this.X = false;
    }

    private void Q() {
        this.N.animate().alpha(1.0f);
        this.K.setEnabled(true);
        this.J.setEnabled(true);
        this.X = true;
    }

    private void R() {
        S();
        this.Y = !this.Y;
        if (this.Y) {
            K().D();
        } else {
            K().M();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        this.H.removeCallbacks(this.aa);
        this.H.setSystemUiVisibility(1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        if (this.Z) {
            return;
        }
        int i = this.Q;
        if (i >= 0) {
            this.Q = -1;
            this.R++;
            final int i2 = this.R;
            this.V = true;
            K().b(i).onComplete(new Task.OnTaskEventListener() { // from class: com.nexstreaming.kinemaster.ui.previewplay.d
                @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
                public final void onTaskEvent(Task task, Task.Event event) {
                    PreviewPlayActivity.this.a(i2, task, event);
                }
            });
            return;
        }
        if (this.V || this.U || !this.Y) {
            return;
        }
        K().D();
        M();
    }

    private void U() {
        this.K.setOnClickListener(new View.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.previewplay.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewPlayActivity.this.a(view);
            }
        });
        this.H.setOnClickListener(new View.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.previewplay.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewPlayActivity.this.b(view);
            }
        });
        this.N.setOnTouchListener(new j(this));
        this.J.setOnSeekBarChangeListener(new k(this));
    }

    public /* synthetic */ void G() {
        if (this.Y) {
            L();
        }
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> linkedHashMap) {
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(boolean z, Purchase purchase, String str) {
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 62) {
            R();
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I
    public void g(boolean z) {
        super.g(z);
        if (C()) {
            K().c(false);
            K().b(EditorGlobal.a("up"));
        } else {
            K().c(true);
            K().b(EditorGlobal.a("std"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        File file;
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        setContentView(R.layout.v3_playback_activity);
        y().a((com.nexstreaming.app.general.iab.a.a) this);
        this.H = (NexThemeView) findViewById(R.id.previewView);
        this.H.setOnSystemUiVisibilityChangeListener(this);
        this.I = new VideoEditor(z(), this, false, this.H);
        this.K = findViewById(R.id.playPauseButton);
        this.J = (SeekBar) findViewById(R.id.videoSeekBar);
        this.L = (TextView) findViewById(R.id.elapsedTime);
        this.M = (TextView) findViewById(R.id.totalTime);
        this.N = findViewById(R.id.playerControls);
        S();
        M();
        this.I.a((VideoEditor.g) this);
        this.I.a((VideoEditor.f) this);
        this.I.a((VideoEditor.d) this);
        Intent intent = getIntent();
        if (intent != null && intent.getData() != null && intent.getData().toString() != null) {
            try {
                file = new File(new URI(intent.getData().toString()));
            } catch (URISyntaxException e2) {
                Log.e("PreviewPlayActivity", "", e2);
            }
            if (file == null && file.exists()) {
                if (bundle != null) {
                    this.O = bundle.getInt("mCurrentTime");
                    this.Y = bundle.getBoolean("isRequestedPlay");
                }
                K().a(file).onComplete(new Task.OnTaskEventListener() { // from class: com.nexstreaming.kinemaster.ui.previewplay.g
                    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
                    public final void onTaskEvent(Task task, Task.Event event) {
                        PreviewPlayActivity.this.b(task, event);
                    }
                }).onFailure(new Task.OnFailListener() { // from class: com.nexstreaming.kinemaster.ui.previewplay.f
                    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
                    public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
                        PreviewPlayActivity.this.a(task, event, taskError);
                    }
                });
                K().c(false);
                K().b(EditorGlobal.a("up"));
                return;
            }
            finish();
        }
        file = null;
        if (file == null) {
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        y().b((com.nexstreaming.app.general.iab.a.a) this);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 21) {
            N();
            int progress = this.J.getProgress() - 3000;
            if (progress < 0) {
                this.J.setProgress(0);
                progress = 0;
            }
            this.J.setProgress(progress);
            this.L.setText(d(progress));
            this.Q = progress;
            T();
            return false;
        }
        if (i == 22) {
            N();
            int progress2 = this.J.getProgress() + 3000;
            if (progress2 > this.J.getMax()) {
                progress2 = this.J.getMax();
            }
            this.J.setProgress(progress2);
            this.L.setText(d(progress2));
            this.Q = progress2;
            T();
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 21) {
            O();
            return false;
        }
        if (i == 22) {
            O();
            return false;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        this.T = true;
        K().M();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        if (this.T && this.Y) {
            K().D();
        }
        this.T = false;
        y().a((com.nexstreaming.app.general.iab.a.a) this);
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("isRequestedPlay", this.Y);
        bundle.putInt("mCurrentTime", this.O);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        K().M();
        super.onStop();
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public void onSystemUiVisibilityChange(int i) {
        this.S = System.nanoTime();
        if ((i & 4) != 0) {
            P();
        } else {
            Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(int i) {
        return String.format("%02d:%02d:%02d.%01d", Integer.valueOf(i / 3600000), Integer.valueOf((i % 3600000) / 60000), Integer.valueOf((i % 60000) / 1000), Integer.valueOf((i % 1000) / 100));
    }

    public /* synthetic */ void c(Task task, Task.Event event) {
        this.Z = false;
        T();
    }

    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        finish();
    }

    public /* synthetic */ void b(Task task, Task.Event event) {
        ProjectAspectRatio projectRatio = K().s().a().getProjectRatio();
        if (projectRatio == ProjectAspectRatio.R_9_16) {
            EditorGlobal.a(0.5625f);
        } else if (projectRatio == ProjectAspectRatio.SQUARE) {
            EditorGlobal.a(1.0f);
        } else {
            EditorGlobal.a(1.7777778f);
        }
        this.H.requestLayout();
        if (!K().s().a().checkReadyToPlay()) {
            if (isFinishing()) {
                return;
            }
            e.a aVar = new e.a(this);
            aVar.c(R.string.play_fail_notready);
            aVar.a(false);
            aVar.c(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.previewplay.h
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    PreviewPlayActivity.this.a(dialogInterface, i);
                }
            });
            aVar.a().show();
            return;
        }
        K().b(this.O).onComplete(new Task.OnTaskEventListener() { // from class: com.nexstreaming.kinemaster.ui.previewplay.c
            @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
            public final void onTaskEvent(Task task2, Task.Event event2) {
                PreviewPlayActivity.this.a(task2, event2);
            }
        });
    }

    public /* synthetic */ void a(Task task, Task.Event event) {
        this.P = K().s().a().getTotalTime();
        this.M.setText(d(this.P));
        this.J.setMax(this.P);
        if (this.Y) {
            K().D();
        }
        U();
    }

    public /* synthetic */ void a(Task task, Task.Event event, Task.TaskError taskError) {
        finish();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.g
    public void a(int i, int i2) {
        this.O = i;
        if (!this.U && !this.V && K().w() == VideoEditor.State.Playing) {
            this.J.setProgress(this.O);
        }
        this.L.setText(d(this.O));
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.f
    public void a(VideoEditor.State state) {
        if (isFinishing()) {
            return;
        }
        if (state == VideoEditor.State.Playing && !this.W) {
            getWindow().addFlags(128);
            this.W = true;
        } else if (state != VideoEditor.State.Playing && this.W) {
            getWindow().clearFlags(128);
            this.W = false;
        }
        if (l.f21733a[state.ordinal()] != 1) {
            if (EditorGlobal.f24026e != EditorGlobal.VersionType.ShowDemo) {
                S();
            }
            this.K.setSelected(false);
        } else {
            M();
            this.K.setSelected(true);
        }
    }

    public /* synthetic */ void b(View view) {
        if ((System.nanoTime() - this.S) / 1000000 < 200) {
            return;
        }
        if (this.X) {
            L();
        } else {
            S();
            M();
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.d
    public void a() {
        if (EditorGlobal.f24026e == EditorGlobal.VersionType.ShowDemo) {
            K().M();
            K().b(0);
            K().D();
        } else {
            K().M();
            finish();
        }
    }

    public /* synthetic */ void a(View view) {
        R();
    }

    public /* synthetic */ void a(int i, Task task, Task.Event event) {
        if (i == this.R) {
            this.V = false;
            T();
        }
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(boolean z, int i, boolean z2) {
        g(y().t());
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(LinkedHashMap<IABConstant.SKUType, List<Purchase>> linkedHashMap, IABError iABError, String str) {
        g(linkedHashMap != null && y().t());
    }
}
