package com.nexstreaming.kinemaster.usage;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppForegroundTracker.java */
/* loaded from: classes.dex */
public class b implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f4405a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f4405a = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        a.a(this.f4405a);
        this.f4405a.a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        a.b(this.f4405a);
        this.f4405a.a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        a.c(this.f4405a);
        this.f4405a.a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        a.d(this.f4405a);
        this.f4405a.a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        a.e(this.f4405a);
        this.f4405a.a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        a.f(this.f4405a);
        this.f4405a.a(activity);
    }
}
