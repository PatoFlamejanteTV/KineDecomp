package com.nextreaming.nexeditorui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/* loaded from: classes.dex */
public class RelaunchActivity extends AppCompatActivity {

    /* renamed from: a */
    private int f24166a = 0;

    /* renamed from: b */
    private Handler f24167b = new Handler();

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        int i = getIntent().getExtras().getInt("msg_rsrc");
        this.f24166a = getIntent().getExtras().getInt("proc");
        TextView textView = new TextView(this);
        textView.setGravity(17);
        textView.setTextSize(20.0f);
        textView.setText(getResources().getText(i));
        setContentView(textView);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f24167b.postDelayed(new nb(this), 2000L);
        super.onDestroy();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        this.f24167b.postDelayed(new mb(this), 500L);
        super.onStart();
    }
}
