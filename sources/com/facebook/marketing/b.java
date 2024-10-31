package com.facebook.marketing;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.marketing.internal.ButtonIndexer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CodelessActivityLifecycleTracker.java */
/* loaded from: classes.dex */
public class b implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        ButtonIndexer buttonIndexer;
        ViewIndexer viewIndexer;
        SensorManager sensorManager;
        SensorManager sensorManager2;
        ViewIndexingTrigger viewIndexingTrigger;
        ViewIndexer viewIndexer2;
        buttonIndexer = CodelessActivityLifecycleTracker.buttonIndexer;
        buttonIndexer.remove(activity);
        viewIndexer = CodelessActivityLifecycleTracker.viewIndexer;
        if (viewIndexer != null) {
            viewIndexer2 = CodelessActivityLifecycleTracker.viewIndexer;
            viewIndexer2.unschedule();
        }
        sensorManager = CodelessActivityLifecycleTracker.sensorManager;
        if (sensorManager != null) {
            sensorManager2 = CodelessActivityLifecycleTracker.sensorManager;
            viewIndexingTrigger = CodelessActivityLifecycleTracker.viewIndexingTrigger;
            sensorManager2.unregisterListener(viewIndexingTrigger);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        ButtonIndexer buttonIndexer;
        SensorManager sensorManager;
        ViewIndexingTrigger viewIndexingTrigger;
        SensorManager sensorManager2;
        ViewIndexingTrigger viewIndexingTrigger2;
        ViewIndexer viewIndexer;
        buttonIndexer = CodelessActivityLifecycleTracker.buttonIndexer;
        buttonIndexer.add(activity);
        Context applicationContext = activity.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(applicationId);
        SensorManager unused = CodelessActivityLifecycleTracker.sensorManager = (SensorManager) applicationContext.getSystemService(com.umeng.commonsdk.proguard.e.aa);
        sensorManager = CodelessActivityLifecycleTracker.sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        ViewIndexer unused2 = CodelessActivityLifecycleTracker.viewIndexer = new ViewIndexer(activity);
        viewIndexingTrigger = CodelessActivityLifecycleTracker.viewIndexingTrigger;
        viewIndexingTrigger.setOnShakeListener(new a(this, applicationContext, applicationId, appSettingsWithoutQuery));
        sensorManager2 = CodelessActivityLifecycleTracker.sensorManager;
        viewIndexingTrigger2 = CodelessActivityLifecycleTracker.viewIndexingTrigger;
        sensorManager2.registerListener(viewIndexingTrigger2, defaultSensor, 2);
        if (appSettingsWithoutQuery == null || !appSettingsWithoutQuery.getCodelessEventsEnabled()) {
            return;
        }
        viewIndexer = CodelessActivityLifecycleTracker.viewIndexer;
        viewIndexer.schedule();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
