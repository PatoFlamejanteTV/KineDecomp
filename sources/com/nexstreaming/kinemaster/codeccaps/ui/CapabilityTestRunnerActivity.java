package com.nexstreaming.kinemaster.codeccaps.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.codeccaps.C1719g;
import com.nexstreaming.kinemaster.codeccaps.CapabilityChecker;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nextreaming.nexeditorui.I;
import java.util.HashMap;

/* loaded from: classes.dex */
public class CapabilityTestRunnerActivity extends I implements Handler.Callback {
    private CapabilityChecker H;
    ProgressBar M;
    private Handler N;
    private long O;
    private String I = "";
    private int J = 0;
    private com.nexstreaming.kinemaster.ui.a.e K = null;
    private boolean L = false;
    private boolean P = false;

    public void K() {
        e.a aVar = new e.a(this);
        aVar.e(R.string.capa_hw_perform_analysis_complete_title);
        aVar.c(R.string.capa_hw_perform_analysis_complete_msg);
        aVar.a(R.string.show_results, new b(this));
        aVar.c(R.string.button_ok, new m(this));
        aVar.a().show();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.L) {
            super.onBackPressed();
            return;
        }
        if (this.K == null) {
            e.a aVar = new e.a(this);
            aVar.c(R.string.capa_hw_perform_cancel_popup_msg);
            aVar.a(R.string.stop_analysis, new f(this));
            aVar.c(R.string.capa_hw_perform_cancel_popup_continue, new e(this));
            this.K = aVar.a();
        }
        this.K.show();
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        overridePendingTransition(0, 0);
        setContentView(R.layout.activity_capability_test_runner);
        this.P = getIntent().getBooleanExtra("ignore_complete_popup", false);
        if (getIntent().getStringExtra("device_id") != null) {
            findViewById(R.id.logView).setVisibility(0);
        }
        findViewById(R.id.devCapsIcon).setOnLongClickListener(new c(this));
        ((TextView) findViewById(R.id.logView)).setMovementMethod(new ScrollingMovementMethod());
        super.onCreate(bundle);
        this.M = (ProgressBar) findViewById(R.id.progressBar);
        HandlerThread handlerThread = new HandlerThread("capability-test-runner", 10);
        handlerThread.setDaemon(true);
        handlerThread.start();
        this.N = new Handler(handlerThread.getLooper(), this);
        this.N.post(new d(this));
        this.O = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("from", this.P ? "Settings" : "PG");
        KMEvents.DCI_ANALYSIS_START.logEvent(hashMap);
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Handler handler = this.N;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.N.getLooper().quit();
        }
        super.onDestroy();
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.H == null) {
            this.H = new CapabilityChecker(C1719g.a());
            g gVar = new g(this);
            this.H.a(gVar);
            this.H.a(this).onResultAvailable(new l(this, gVar)).onProgress((Task.OnProgressListener) new i(this)).onFailure((Task.OnFailListener) new h(this));
        }
    }

    public static Intent a(Context context, String str, boolean z) {
        Intent intent = new Intent(context, (Class<?>) CapabilityTestRunnerActivity.class);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("device_id", str);
        }
        intent.putExtra("ignore_complete_popup", z);
        return intent;
    }
}
