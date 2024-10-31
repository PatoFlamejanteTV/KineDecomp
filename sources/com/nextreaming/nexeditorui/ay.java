package com.nextreaming.nexeditorui;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.util.WeakHashMap;

/* compiled from: KineMasterApplication.java */
/* loaded from: classes.dex */
class ay implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ KineMasterApplication f4534a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(KineMasterApplication kineMasterApplication) {
        this.f4534a = kineMasterApplication;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        WeakHashMap weakHashMap;
        weakHashMap = this.f4534a.c;
        weakHashMap.put(activity, KineMasterApplication.Dummy.DUMMY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (this.f4534a.c() != null) {
            this.f4534a.c().c();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        WeakHashMap weakHashMap;
        weakHashMap = this.f4534a.c;
        weakHashMap.remove(activity);
    }
}
