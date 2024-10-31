package io.fabric.sdk.android;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import io.fabric.sdk.android.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActivityLifecycleManager.java */
/* loaded from: classes3.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    final /* synthetic */ b.AbstractC0152b f26812a;

    /* renamed from: b */
    final /* synthetic */ b.a f26813b;

    public a(b.a aVar, b.AbstractC0152b abstractC0152b) {
        this.f26813b = aVar;
        this.f26812a = abstractC0152b;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.f26812a.onActivityCreated(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        this.f26812a.onActivityDestroyed(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f26812a.onActivityPaused(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f26812a.onActivityResumed(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f26812a.onActivitySaveInstanceState(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.f26812a.onActivityStarted(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        this.f26812a.onActivityStopped(activity);
    }
}
