package com.facebook.marketing.internal;

import android.view.View;
import com.facebook.FacebookSdk;
import com.facebook.marketing.internal.ButtonIndexingEventListener;

/* compiled from: ButtonIndexingEventListener.java */
/* loaded from: classes.dex */
class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f9444a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f9445b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ButtonIndexingEventListener.ButtonIndexingAccessibilityDelegate f9446c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ButtonIndexingEventListener.ButtonIndexingAccessibilityDelegate buttonIndexingAccessibilityDelegate, View view, String str) {
        this.f9446c = buttonIndexingAccessibilityDelegate;
        this.f9444a = view;
        this.f9445b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        ButtonIndexingLogger.logIndexing(FacebookSdk.getApplicationId(), this.f9444a, this.f9445b, FacebookSdk.getApplicationContext());
    }
}
