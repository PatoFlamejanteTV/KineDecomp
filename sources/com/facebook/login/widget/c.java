package com.facebook.login.widget;

import android.app.Activity;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginButton.java */
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9409a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ LoginButton f9410b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LoginButton loginButton, String str) {
        this.f9410b = loginButton;
        this.f9409a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Activity activity;
        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(this.f9409a, false);
        activity = this.f9410b.getActivity();
        activity.runOnUiThread(new b(this, queryAppSettings));
    }
}
