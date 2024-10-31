package com.facebook.appevents;

import android.os.Bundle;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Logger;
import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FacebookTimeSpentData implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9161a = "com.facebook.appevents.FacebookTimeSpentData";

    /* renamed from: b, reason: collision with root package name */
    private static final long[] f9162b = {300000, 900000, 1800000, 3600000, 21600000, 43200000, 86400000, 172800000, 259200000, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};
    private static final long serialVersionUID = 1;
    private String firstOpenSourceApplication;
    private int interruptionCount;
    private boolean isAppActive;
    private boolean isWarmLaunch;
    private long lastActivateEventLoggedTime;
    private long lastResumeTime;
    private long lastSuspendTime;
    private long millisecondsSpentInSession;

    /* loaded from: classes.dex */
    private static class SerializationProxyV2 implements Serializable {
        private static final long serialVersionUID = 6;
        private final String firstOpenSourceApplication;
        private final int interruptionCount;
        private final long lastResumeTime;
        private final long lastSuspendTime;
        private final long millisecondsSpentInSession;

        SerializationProxyV2(long j, long j2, long j3, int i, String str) {
            this.lastResumeTime = j;
            this.lastSuspendTime = j2;
            this.millisecondsSpentInSession = j3;
            this.interruptionCount = i;
            this.firstOpenSourceApplication = str;
        }

        private Object readResolve() {
            return new FacebookTimeSpentData(this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount, this.firstOpenSourceApplication);
        }
    }

    private void a(AppEventsLogger appEventsLogger, long j) {
        Bundle bundle = new Bundle();
        bundle.putInt(AppEventsConstants.EVENT_NAME_SESSION_INTERRUPTIONS, this.interruptionCount);
        bundle.putString(AppEventsConstants.EVENT_NAME_TIME_BETWEEN_SESSIONS, String.format(Locale.ROOT, "session_quanta_%d", Integer.valueOf(a(j))));
        bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, this.firstOpenSourceApplication);
        appEventsLogger.logEvent(AppEventsConstants.EVENT_NAME_DEACTIVATED_APP, this.millisecondsSpentInSession / 1000, bundle);
        b();
    }

    private void b() {
        this.isAppActive = false;
        this.lastResumeTime = -1L;
        this.lastSuspendTime = -1L;
        this.interruptionCount = 0;
        this.millisecondsSpentInSession = 0L;
    }

    private boolean c() {
        return this.lastSuspendTime != -1;
    }

    private Object writeReplace() {
        return new SerializationProxyV2(this.lastResumeTime, this.lastSuspendTime, this.millisecondsSpentInSession, this.interruptionCount, this.firstOpenSourceApplication);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onResume(AppEventsLogger appEventsLogger, long j, String str) {
        if (a() || j - this.lastActivateEventLoggedTime > 300000) {
            Bundle bundle = new Bundle();
            bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, str);
            appEventsLogger.logEvent(AppEventsConstants.EVENT_NAME_ACTIVATED_APP, bundle);
            this.lastActivateEventLoggedTime = j;
            if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
                appEventsLogger.flush();
            }
        }
        if (this.isAppActive) {
            Logger.log(LoggingBehavior.APP_EVENTS, f9161a, "Resume for active app");
            return;
        }
        long j2 = 0;
        long j3 = c() ? j - this.lastSuspendTime : 0L;
        if (j3 < 0) {
            Logger.log(LoggingBehavior.APP_EVENTS, f9161a, "Clock skew detected");
        } else {
            j2 = j3;
        }
        if (j2 > 60000) {
            a(appEventsLogger, j2);
        } else if (j2 > 1000) {
            this.interruptionCount++;
        }
        if (this.interruptionCount == 0) {
            this.firstOpenSourceApplication = str;
        }
        this.lastResumeTime = j;
        this.isAppActive = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSuspend(AppEventsLogger appEventsLogger, long j) {
        if (!this.isAppActive) {
            Logger.log(LoggingBehavior.APP_EVENTS, f9161a, "Suspend for inactive app");
            return;
        }
        long j2 = j - this.lastResumeTime;
        if (j2 < 0) {
            Logger.log(LoggingBehavior.APP_EVENTS, f9161a, "Clock skew detected");
            j2 = 0;
        }
        this.millisecondsSpentInSession += j2;
        this.lastSuspendTime = j;
        this.isAppActive = false;
    }

    private FacebookTimeSpentData(long j, long j2, long j3, int i) {
        b();
        this.lastResumeTime = j;
        this.lastSuspendTime = j2;
        this.millisecondsSpentInSession = j3;
        this.interruptionCount = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FacebookTimeSpentData() {
        b();
    }

    private static int a(long j) {
        int i = 0;
        while (true) {
            long[] jArr = f9162b;
            if (i >= jArr.length || jArr[i] >= j) {
                break;
            }
            i++;
        }
        return i;
    }

    private FacebookTimeSpentData(long j, long j2, long j3, int i, String str) {
        b();
        this.lastResumeTime = j;
        this.lastSuspendTime = j2;
        this.millisecondsSpentInSession = j3;
        this.interruptionCount = i;
        this.firstOpenSourceApplication = str;
    }

    private boolean a() {
        boolean z = !this.isWarmLaunch;
        this.isWarmLaunch = true;
        return z;
    }
}
