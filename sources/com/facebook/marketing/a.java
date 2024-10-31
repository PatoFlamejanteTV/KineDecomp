package com.facebook.marketing;

import android.content.Context;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.marketing.ViewIndexingTrigger;
import com.facebook.marketing.internal.MarketingLogger;

/* compiled from: CodelessActivityLifecycleTracker.java */
/* loaded from: classes.dex */
class a implements ViewIndexingTrigger.OnShakeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f9427a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f9428b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ FetchedAppSettings f9429c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ b f9430d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, Context context, String str, FetchedAppSettings fetchedAppSettings) {
        this.f9430d = bVar;
        this.f9427a = context;
        this.f9428b = str;
        this.f9429c = fetchedAppSettings;
    }

    @Override // com.facebook.marketing.ViewIndexingTrigger.OnShakeListener
    public void onShake(int i) {
        ViewIndexingTrigger viewIndexingTrigger;
        if (i >= 3) {
            viewIndexingTrigger = CodelessActivityLifecycleTracker.viewIndexingTrigger;
            viewIndexingTrigger.resetCount();
            MarketingLogger marketingLogger = new MarketingLogger(this.f9427a, this.f9428b);
            marketingLogger.logGestureTriggered();
            FetchedAppSettings fetchedAppSettings = this.f9429c;
            if (fetchedAppSettings == null || !fetchedAppSettings.getCodelessEventsEnabled()) {
                return;
            }
            CodelessActivityLifecycleTracker.checkCodelessSession(this.f9428b, marketingLogger);
        }
    }
}
