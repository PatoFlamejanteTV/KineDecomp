package com.facebook.appevents.codeless;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.CodelessLoggingEventListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CodelessLoggingEventListener.java */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f9165a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Bundle f9166b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ CodelessLoggingEventListener.AutoLoggingAccessibilityDelegate f9167c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(CodelessLoggingEventListener.AutoLoggingAccessibilityDelegate autoLoggingAccessibilityDelegate, String str, Bundle bundle) {
        this.f9167c = autoLoggingAccessibilityDelegate;
        this.f9165a = str;
        this.f9166b = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppEventsLogger.newLogger(FacebookSdk.getApplicationContext()).logEvent(this.f9165a, this.f9166b);
    }
}
