package com.facebook.marketing.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

/* loaded from: classes.dex */
public final class MarketingLogger {
    static final String ACTIVITY_NAME = "_activity_name";
    static final String CODELESS_ACTION_GESTURE_TRIGGERED = "gesture_triggered";
    static final String CODELESS_ACTION_INDEXING_CANCELLED = "indexing_cancelled";
    static final String CODELESS_ACTION_INDEXING_COMPLETE = "indexing_complete";
    static final String CODELESS_ACTION_INDEXING_START = "indexing_start";
    static final String CODELESS_ACTION_KEY = "_codeless_action";
    static final String CODELESS_ACTION_SDK_INITIALIZED = "sdk_initialized";
    static final String CODELESS_ACTION_SESSION_READY = "session_ready";
    static final String EVENT_NAME_CODELESS_DEBUG = "fb_codeless_debug";
    private final AppEventsLogger appEventsLogger;

    public MarketingLogger(Context context, String str) {
        this.appEventsLogger = AppEventsLogger.newLogger(context, str);
    }

    public void logCodelessInitialized() {
        if (FacebookSdk.getAutoLogAppEventsEnabled() && FacebookSdk.getCodelessDebugLogEnabled()) {
            Bundle bundle = new Bundle();
            bundle.putString(CODELESS_ACTION_KEY, CODELESS_ACTION_SDK_INITIALIZED);
            this.appEventsLogger.logSdkEvent(EVENT_NAME_CODELESS_DEBUG, null, bundle);
        }
    }

    public void logGestureTriggered() {
        if (FacebookSdk.getAutoLogAppEventsEnabled() && FacebookSdk.getCodelessDebugLogEnabled()) {
            Bundle bundle = new Bundle();
            bundle.putString(CODELESS_ACTION_KEY, CODELESS_ACTION_GESTURE_TRIGGERED);
            this.appEventsLogger.logSdkEvent(EVENT_NAME_CODELESS_DEBUG, null, bundle);
        }
    }

    public void logIndexingCancelled(String str) {
        if (FacebookSdk.getAutoLogAppEventsEnabled() && FacebookSdk.getCodelessDebugLogEnabled()) {
            Bundle bundle = new Bundle();
            bundle.putString(CODELESS_ACTION_KEY, CODELESS_ACTION_INDEXING_CANCELLED);
            bundle.putString(ACTIVITY_NAME, str);
            this.appEventsLogger.logSdkEvent(EVENT_NAME_CODELESS_DEBUG, null, bundle);
        }
    }

    public void logIndexingComplete(String str) {
        if (FacebookSdk.getAutoLogAppEventsEnabled() && FacebookSdk.getCodelessDebugLogEnabled()) {
            Bundle bundle = new Bundle();
            bundle.putString(CODELESS_ACTION_KEY, CODELESS_ACTION_INDEXING_COMPLETE);
            bundle.putString(ACTIVITY_NAME, str);
            this.appEventsLogger.logSdkEvent(EVENT_NAME_CODELESS_DEBUG, null, bundle);
        }
    }

    public void logIndexingStart(String str) {
        if (FacebookSdk.getAutoLogAppEventsEnabled() && FacebookSdk.getCodelessDebugLogEnabled()) {
            Bundle bundle = new Bundle();
            bundle.putString(CODELESS_ACTION_KEY, CODELESS_ACTION_INDEXING_START);
            bundle.putString(ACTIVITY_NAME, str);
            this.appEventsLogger.logSdkEvent(EVENT_NAME_CODELESS_DEBUG, null, bundle);
        }
    }

    public void logSessionReady() {
        if (FacebookSdk.getAutoLogAppEventsEnabled() && FacebookSdk.getCodelessDebugLogEnabled()) {
            Bundle bundle = new Bundle();
            bundle.putString(CODELESS_ACTION_KEY, CODELESS_ACTION_SESSION_READY);
            this.appEventsLogger.logSdkEvent(EVENT_NAME_CODELESS_DEBUG, null, bundle);
        }
    }
}
