package com.facebook.login.widget;

import android.app.Activity;
import com.facebook.internal.Utility;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginButton.java */
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f322a;
    final /* synthetic */ LoginButton b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(LoginButton loginButton, String str) {
        this.b = loginButton;
        this.f322a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Activity activity;
        Utility.FetchedAppSettings queryAppSettings = Utility.queryAppSettings(this.f322a, false);
        activity = this.b.getActivity();
        activity.runOnUiThread(new b(this, queryAppSettings));
    }
}
