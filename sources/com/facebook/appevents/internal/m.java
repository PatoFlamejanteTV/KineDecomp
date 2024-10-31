package com.facebook.appevents.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Logger;
import java.util.Locale;

/* compiled from: SessionLogger.java */
/* loaded from: classes.dex */
class m {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9200a = "com.facebook.appevents.internal.m";

    /* renamed from: b, reason: collision with root package name */
    private static final long[] f9201b = {300000, 900000, 1800000, 3600000, 21600000, 43200000, 86400000, 172800000, 259200000, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};

    public static void a(Context context, String str, SourceApplicationInfo sourceApplicationInfo, String str2) {
        String sourceApplicationInfo2 = sourceApplicationInfo != null ? sourceApplicationInfo.toString() : "Unclassified";
        Bundle bundle = new Bundle();
        bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, sourceApplicationInfo2);
        k kVar = new k(str, str2, null);
        kVar.logEvent(AppEventsConstants.EVENT_NAME_ACTIVATED_APP, bundle);
        if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
            kVar.flush();
        }
    }

    public static void a(Context context, String str, l lVar, String str2) {
        Long valueOf = Long.valueOf(lVar.b() - lVar.e().longValue());
        if (valueOf.longValue() < 0) {
            a();
            valueOf = 0L;
        }
        Long valueOf2 = Long.valueOf(lVar.f());
        if (valueOf2.longValue() < 0) {
            a();
            valueOf2 = 0L;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(AppEventsConstants.EVENT_NAME_SESSION_INTERRUPTIONS, lVar.c());
        bundle.putString(AppEventsConstants.EVENT_NAME_TIME_BETWEEN_SESSIONS, String.format(Locale.ROOT, "session_quanta_%d", Integer.valueOf(a(valueOf.longValue()))));
        SourceApplicationInfo g2 = lVar.g();
        bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, g2 != null ? g2.toString() : "Unclassified");
        bundle.putLong(Constants.LOG_TIME_APP_EVENT_KEY, lVar.e().longValue() / 1000);
        new k(str, str2, null).logEvent(AppEventsConstants.EVENT_NAME_DEACTIVATED_APP, valueOf2.longValue() / 1000, bundle);
    }

    private static void a() {
        Logger.log(LoggingBehavior.APP_EVENTS, f9200a, "Clock skew detected");
    }

    private static int a(long j) {
        int i = 0;
        while (true) {
            long[] jArr = f9201b;
            if (i >= jArr.length || jArr[i] >= j) {
                break;
            }
            i++;
        }
        return i;
    }
}
