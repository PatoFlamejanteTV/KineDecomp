package com.adobe.creativesdk.foundation.internal.base;

import android.os.Bundle;
import com.adobe.creativesdk.foundation.auth.AdobeAuthSessionHelper;

/* loaded from: classes.dex */
public class AdobeTOUHandlerActivity extends a {

    /* renamed from: a, reason: collision with root package name */
    AdobeAuthSessionHelper f4937a = null;

    /* renamed from: b, reason: collision with root package name */
    AdobeAuthSessionHelper.a f4938b = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4937a = new AdobeAuthSessionHelper(this.f4938b);
        this.f4937a.a(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f4937a.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f4937a.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f4937a.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f4937a.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.f4937a.e();
    }
}
