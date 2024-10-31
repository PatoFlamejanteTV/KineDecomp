package com.nexstreaming.kinemaster.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.Group;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ad.providers.tencent.TencentAdListener;
import com.nexstreaming.kinemaster.ad.providers.tencent.TencentSplashAdProvider;
import kotlin.TypeCastException;

/* compiled from: TencentSplashAdActivity.kt */
/* loaded from: classes.dex */
public final class TencentSplashAdActivity extends AppCompatActivity {

    /* renamed from: a */
    public TencentSplashAdProvider f21297a;

    /* renamed from: b */
    public Group f21298b;

    /* renamed from: c */
    public TextView f21299c;

    /* renamed from: d */
    public ViewGroup f21300d;

    /* renamed from: g */
    private boolean f21303g;

    /* renamed from: h */
    private boolean f21304h;

    /* renamed from: e */
    private final String f21301e = "点击跳过 %d";

    /* renamed from: f */
    private final int f21302f = io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT;
    private final TencentAdListener.SplashAdListener i = new s(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f21303g) {
            super.onBackPressed();
        }
        if (this.f21304h) {
            startActivity(new Intent(this, (Class<?>) SplashActivity.class));
            finish();
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String localClassName = getLocalClassName();
        kotlin.jvm.internal.h.a((Object) localClassName, "this.localClassName");
        com.nexstreaming.kinemaster.usage.analytics.b.a(localClassName);
        super.onCreate(bundle);
        setContentView(R.layout.activity_tencent_splash_ad);
        View findViewById = findViewById(R.id.splash_container);
        if (findViewById != null) {
            this.f21300d = (ViewGroup) findViewById;
            View findViewById2 = findViewById(R.id.skip_view);
            if (findViewById2 != null) {
                this.f21299c = (TextView) findViewById2;
                View findViewById3 = findViewById(R.id.splash_holder);
                if (findViewById3 != null) {
                    this.f21298b = (Group) findViewById3;
                    this.f21297a = new TencentSplashAdProvider(this, this.i);
                    TencentSplashAdProvider tencentSplashAdProvider = this.f21297a;
                    if (tencentSplashAdProvider == null) {
                        kotlin.jvm.internal.h.b("tencentSplashAdProvider");
                        throw null;
                    }
                    if (tencentSplashAdProvider.isSubscriptionOrPromotion()) {
                        a(0L);
                        return;
                    }
                    TencentSplashAdProvider tencentSplashAdProvider2 = this.f21297a;
                    if (tencentSplashAdProvider2 == null) {
                        kotlin.jvm.internal.h.b("tencentSplashAdProvider");
                        throw null;
                    }
                    ViewGroup viewGroup = this.f21300d;
                    if (viewGroup == null) {
                        kotlin.jvm.internal.h.b("container");
                        throw null;
                    }
                    TextView textView = this.f21299c;
                    if (textView != null) {
                        tencentSplashAdProvider2.fetchSplashAD(this, viewGroup, textView, this.f21302f);
                        Handler handler = new Handler();
                        r rVar = r.f23016a;
                        TencentSplashAdProvider tencentSplashAdProvider3 = this.f21297a;
                        if (tencentSplashAdProvider3 != null) {
                            handler.postDelayed(rVar, tencentSplashAdProvider3.getMinSplashTimeNoAd());
                            return;
                        } else {
                            kotlin.jvm.internal.h.b("tencentSplashAdProvider");
                            throw null;
                        }
                    }
                    kotlin.jvm.internal.h.b("skipView");
                    throw null;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.support.constraint.Group");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f21304h) {
            startActivity(new Intent(this, (Class<?>) SplashActivity.class));
            finish();
        }
    }

    public final TextView s() {
        TextView textView = this.f21299c;
        if (textView != null) {
            return textView;
        }
        kotlin.jvm.internal.h.b("skipView");
        throw null;
    }

    public final Group t() {
        Group group = this.f21298b;
        if (group != null) {
            return group;
        }
        kotlin.jvm.internal.h.b("splashHolder");
        throw null;
    }

    public final void a(long j) {
        this.f21303g = true;
        runOnUiThread(new q(this, j));
    }
}
