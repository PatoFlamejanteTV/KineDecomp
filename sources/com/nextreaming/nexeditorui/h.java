package com.nextreaming.nexeditorui;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.crashlytics.android.Crashlytics;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* compiled from: KineMasterApplication.kt */
/* loaded from: classes.dex */
public final class H implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ KineMasterApplication f24035a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H(KineMasterApplication kineMasterApplication) {
        this.f24035a = kineMasterApplication;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        WeakHashMap weakHashMap;
        kotlin.jvm.internal.h.b(activity, "activity");
        weakHashMap = this.f24035a.r;
        weakHashMap.put(activity, KineMasterApplication.Dummy.DUMMY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        WeakHashMap weakHashMap;
        kotlin.jvm.internal.h.b(activity, "activity");
        weakHashMap = this.f24035a.r;
        weakHashMap.remove(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        kotlin.jvm.internal.h.b(activity, "activity");
        KMUsage.onPause(this.f24035a.getApplicationContext());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        kotlin.jvm.internal.h.b(activity, "activity");
        KMUsage.onResume(this.f24035a.getApplicationContext());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        kotlin.jvm.internal.h.b(activity, "activity");
        kotlin.jvm.internal.h.b(bundle, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        ArrayList a2;
        com.nexstreaming.kinemaster.mediastore.scanner.e h2;
        kotlin.jvm.internal.h.b(activity, "activity");
        String simpleName = ProjectEditActivity.class.getSimpleName();
        kotlin.jvm.internal.h.a((Object) simpleName, "ProjectEditActivity::class.java.simpleName");
        a2 = kotlin.collections.k.a((Object[]) new String[]{simpleName});
        if (a2.contains(activity.getClass().getSimpleName()) && (h2 = this.f24035a.h()) != null && h2.c()) {
            if (EditorGlobal.p) {
                Crashlytics.log("KineMasterApplication#scanDevice() Called by: " + activity.getClass().getSimpleName());
            }
            h2.d();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        kotlin.jvm.internal.h.b(activity, "activity");
    }
}
