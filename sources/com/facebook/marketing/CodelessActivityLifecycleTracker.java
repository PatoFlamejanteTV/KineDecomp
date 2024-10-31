package com.facebook.marketing;

import android.app.Application;
import android.hardware.SensorManager;
import com.facebook.FacebookSdk;
import com.facebook.marketing.internal.ButtonIndexer;
import com.facebook.marketing.internal.MarketingLogger;
import java.util.UUID;

/* loaded from: classes.dex */
public class CodelessActivityLifecycleTracker {
    private static final String TAG = "com.facebook.marketing.CodelessActivityLifecycleTracker";
    private static SensorManager sensorManager;
    private static ViewIndexer viewIndexer;
    private static final ViewIndexingTrigger viewIndexingTrigger = new ViewIndexingTrigger();
    private static String deviceSessionID = null;
    private static Boolean isAppIndexingEnabled = false;
    private static volatile Boolean isCheckingSession = false;
    private static final ButtonIndexer buttonIndexer = new ButtonIndexer();

    public static void checkCodelessSession(String str, MarketingLogger marketingLogger) {
        if (isCheckingSession.booleanValue()) {
            return;
        }
        isCheckingSession = true;
        FacebookSdk.getExecutor().execute(new c(str, marketingLogger));
    }

    public static String getCurrentDeviceSessionID() {
        if (deviceSessionID == null) {
            deviceSessionID = UUID.randomUUID().toString();
        }
        return deviceSessionID;
    }

    public static boolean getIsAppIndexingEnabled() {
        return isAppIndexingEnabled.booleanValue();
    }

    public static void startTracking(Application application, String str) {
        application.registerActivityLifecycleCallbacks(new b());
    }

    public static void updateAppIndexing(Boolean bool) {
        isAppIndexingEnabled = bool;
    }
}
