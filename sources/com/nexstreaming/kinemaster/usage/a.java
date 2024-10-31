package com.nexstreaming.kinemaster.usage;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: AppForegroundTracker.java */
/* loaded from: classes2.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    final /* synthetic */ c f23903a;

    public a(c cVar) {
        this.f23903a = cVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        c.a(this.f23903a);
        this.f23903a.a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        c.b(this.f23903a);
        this.f23903a.a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        c.f(this.f23903a);
        this.f23903a.a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        c.e(this.f23903a);
        this.f23903a.a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        c.c(this.f23903a);
        this.f23903a.a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        c.d(this.f23903a);
        this.f23903a.a(activity);
    }
}
