package com.flurry.a;

import android.content.Context;
import android.os.Build;
import com.flurry.sdk.ad;
import com.flurry.sdk.ae;
import com.flurry.sdk.as;
import com.flurry.sdk.at;
import java.util.Map;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f444a = a.class.getSimpleName();

    private a() {
    }

    public static int a() {
        return com.flurry.sdk.a.a().b();
    }

    public static void a(boolean z) {
        if (Build.VERSION.SDK_INT < 10) {
            as.b(f444a, "Device SDK Version older than 10");
        } else {
            ae.a().a("LogEvents", (Object) Boolean.valueOf(z));
        }
    }

    public static void b(boolean z) {
        if (Build.VERSION.SDK_INT < 10) {
            as.b(f444a, "Device SDK Version older than 10");
        } else {
            ae.a().a("UseHttps", (Object) Boolean.valueOf(z));
        }
    }

    public static void a(Context context, String str) {
        if (Build.VERSION.SDK_INT < 10) {
            as.b(f444a, "Device SDK Version older than 10");
            return;
        }
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Api key not specified");
        }
        ad.a(context);
        try {
            com.flurry.sdk.a.a().a(context, str);
        } catch (Throwable th) {
            as.a(f444a, "", th);
        }
        at.a().a(context);
    }

    public static void a(Context context) {
        if (Build.VERSION.SDK_INT < 10) {
            as.b(f444a, "Device SDK Version older than 10");
            return;
        }
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        at.a().b(context);
        try {
            com.flurry.sdk.a.a().a(context);
        } catch (Throwable th) {
            as.a(f444a, "", th);
        }
    }

    public static void a(String str) {
        if (Build.VERSION.SDK_INT < 10) {
            as.b(f444a, "Device SDK Version older than 10");
            return;
        }
        if (str == null) {
            as.b(f444a, "String eventId passed to logEvent was null.");
            return;
        }
        try {
            com.flurry.sdk.a.a().a(str);
        } catch (Throwable th) {
            as.a(f444a, "Failed to log event: " + str, th);
        }
    }

    public static void a(String str, Map<String, String> map) {
        if (Build.VERSION.SDK_INT < 10) {
            as.b(f444a, "Device SDK Version older than 10");
            return;
        }
        if (str == null) {
            as.b(f444a, "String eventId passed to logEvent was null.");
            return;
        }
        if (map == null) {
            as.b(f444a, "String parameters passed to logEvent was null.");
            return;
        }
        try {
            com.flurry.sdk.a.a().a(str, map);
        } catch (Throwable th) {
            as.a(f444a, "Failed to log event: " + str, th);
        }
    }

    public static void a(String str, boolean z) {
        if (Build.VERSION.SDK_INT < 10) {
            as.b(f444a, "Device SDK Version older than 10");
            return;
        }
        if (str == null) {
            as.b(f444a, "String eventId passed to logEvent was null.");
            return;
        }
        try {
            com.flurry.sdk.a.a().a(str, z);
        } catch (Throwable th) {
            as.a(f444a, "Failed to log event: " + str, th);
        }
    }

    public static void a(String str, Map<String, String> map, boolean z) {
        if (Build.VERSION.SDK_INT < 10) {
            as.b(f444a, "Device SDK Version older than 10");
            return;
        }
        if (str == null) {
            as.b(f444a, "String eventId passed to logEvent was null.");
            return;
        }
        if (map == null) {
            as.b(f444a, "String parameters passed to logEvent was null.");
            return;
        }
        try {
            com.flurry.sdk.a.a().a(str, map, z);
        } catch (Throwable th) {
            as.a(f444a, "Failed to log event: " + str, th);
        }
    }

    public static void b(String str) {
        if (Build.VERSION.SDK_INT < 10) {
            as.b(f444a, "Device SDK Version older than 10");
            return;
        }
        if (str == null) {
            as.b(f444a, "String eventId passed to endTimedEvent was null.");
            return;
        }
        try {
            com.flurry.sdk.a.a().b(str);
        } catch (Throwable th) {
            as.a(f444a, "Failed to signify the end of event: " + str, th);
        }
    }

    public static void b(String str, Map<String, String> map) {
        if (Build.VERSION.SDK_INT < 10) {
            as.b(f444a, "Device SDK Version older than 10");
            return;
        }
        if (str == null) {
            as.b(f444a, "String eventId passed to endTimedEvent was null.");
            return;
        }
        if (map == null) {
            as.b(f444a, "String eventId passed to endTimedEvent was null.");
            return;
        }
        try {
            com.flurry.sdk.a.a().b(str, map);
        } catch (Throwable th) {
            as.a(f444a, "Failed to signify the end of event: " + str, th);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (Build.VERSION.SDK_INT < 10) {
            as.b(f444a, "Device SDK Version older than 10");
            return;
        }
        if (str == null) {
            as.b(f444a, "String errorId passed to onError was null.");
            return;
        }
        if (str2 == null) {
            as.b(f444a, "String message passed to onError was null.");
            return;
        }
        if (th == null) {
            as.b(f444a, "Throwable passed to onError was null.");
            return;
        }
        try {
            com.flurry.sdk.a.a().a(str, str2, th);
        } catch (Throwable th2) {
            as.a(f444a, "", th2);
        }
    }
}
