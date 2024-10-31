package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActivityLifecycleTracker.java */
/* loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        String str;
        LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
        str = ActivityLifecycleTracker.TAG;
        Logger.log(loggingBehavior, str, "onActivityCreated");
        AppEventUtility.assertIsMainThread();
        ActivityLifecycleTracker.onActivityCreated(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        String str;
        LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
        str = ActivityLifecycleTracker.TAG;
        Logger.log(loggingBehavior, str, "onActivityDestroyed");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        String str;
        LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
        str = ActivityLifecycleTracker.TAG;
        Logger.log(loggingBehavior, str, "onActivityPaused");
        AppEventUtility.assertIsMainThread();
        ActivityLifecycleTracker.onActivityPaused(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        String str;
        LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
        str = ActivityLifecycleTracker.TAG;
        Logger.log(loggingBehavior, str, "onActivityResumed");
        AppEventUtility.assertIsMainThread();
        ActivityLifecycleTracker.onActivityResumed(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        String str;
        LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
        str = ActivityLifecycleTracker.TAG;
        Logger.log(loggingBehavior, str, "onActivitySaveInstanceState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        String str;
        LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
        str = ActivityLifecycleTracker.TAG;
        Logger.log(loggingBehavior, str, "onActivityStarted");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        String str;
        LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
        str = ActivityLifecycleTracker.TAG;
        Logger.log(loggingBehavior, str, "onActivityStopped");
        AppEventsLogger.onContextStop();
    }
}
