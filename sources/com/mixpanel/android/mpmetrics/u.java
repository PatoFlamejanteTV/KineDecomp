package com.mixpanel.android.mpmetrics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MixpanelActivityLifecycleCallbacks.java */
@TargetApi(16)
/* loaded from: classes.dex */
public class u implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private final n f3048a;

    public u(n nVar) {
        this.f3048a = nVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (activity.isTaskRoot()) {
            this.f3048a.c().b(activity);
            this.f3048a.c().a(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f3048a.c().a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
