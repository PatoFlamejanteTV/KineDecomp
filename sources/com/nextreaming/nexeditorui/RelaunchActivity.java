package com.nextreaming.nexeditorui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

/* loaded from: classes.dex */
public class RelaunchActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private int f4503a = 0;
    private Handler b = new Handler();

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i = getIntent().getExtras().getInt("msg_rsrc");
        this.f4503a = getIntent().getExtras().getInt("proc");
        TextView textView = new TextView(this);
        textView.setGravity(17);
        textView.setTextSize(20.0f);
        textView.setText(getResources().getText(i));
        setContentView(textView);
    }

    @Override // android.app.Activity
    protected void onStart() {
        this.b.postDelayed(new ec(this), 500L);
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.b.postDelayed(new ee(this), 2000L);
        super.onDestroy();
    }
}
