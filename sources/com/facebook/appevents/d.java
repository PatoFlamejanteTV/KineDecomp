package com.facebook.appevents;

import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AppEventUtility;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: AnalyticsUserIDStore.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    private static final String f9169a = "d";

    /* renamed from: c */
    private static String f9171c;

    /* renamed from: b */
    private static ReentrantReadWriteLock f9170b = new ReentrantReadWriteLock();

    /* renamed from: d */
    private static volatile boolean f9172d = false;

    public static String d() {
        if (!f9172d) {
            Log.w(f9169a, "initStore should have been called before calling setUserID");
            f();
        }
        f9170b.readLock().lock();
        try {
            return f9171c;
        } finally {
            f9170b.readLock().unlock();
        }
    }

    public static void e() {
        if (f9172d) {
            return;
        }
        AppEventsLogger.getAnalyticsExecutor().execute(new b());
    }

    public static void f() {
        if (f9172d) {
            return;
        }
        f9170b.writeLock().lock();
        try {
            if (f9172d) {
                return;
            }
            f9171c = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).getString("com.facebook.appevents.AnalyticsUserIDStore.userID", null);
            f9172d = true;
        } finally {
            f9170b.writeLock().unlock();
        }
    }

    public static void b(String str) {
        AppEventUtility.assertIsNotMainThread();
        if (!f9172d) {
            Log.w(f9169a, "initStore should have been called before calling setUserID");
            f();
        }
        AppEventsLogger.getAnalyticsExecutor().execute(new c(str));
    }
}
