package com.nexstreaming.kinemaster.ui.share;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.nexstreaming.kinemaster.ui.SplashActivity;

/* loaded from: classes2.dex */
public class ShareIntentActivity extends AppCompatActivity {
    private boolean c(Intent intent) {
        Uri data;
        if (intent == null || !"android.intent.action.VIEW".equals(intent.getAction()) || (data = intent.getData()) == null) {
            return false;
        }
        return ("http".equals(data.getScheme()) || "https".equals(data.getScheme())) && "kinemaster.com".equals(data.getHost());
    }

    public void d(Intent intent) {
        Intent intent2 = new Intent(intent);
        intent2.setClass(this, SplashActivity.class);
        startActivity(intent2);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        if (c.d.b.c.a.d(getApplicationContext()) && c(getIntent())) {
            FirebaseDynamicLinks.a().a(getIntent()).a(this, new sa(this)).a(this, new ra(this));
        } else {
            d(getIntent());
        }
    }
}
