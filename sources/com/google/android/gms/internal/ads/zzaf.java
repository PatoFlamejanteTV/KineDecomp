package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class zzaf {
    private static String TAG = "Volley";
    public static boolean DEBUG = Log.isLoggable("Volley", 2);
    private static final String CLASS_NAME = zzaf.class.getName();

    public static void d(String str, Object... objArr) {
        Log.d(TAG, zza(str, objArr));
    }

    public static void e(String str, Object... objArr) {
        Log.e(TAG, zza(str, objArr));
    }

    public static void v(String str, Object... objArr) {
        if (DEBUG) {
            Log.v(TAG, zza(str, objArr));
        }
    }

    public static void zza(Throwable th, String str, Object... objArr) {
        Log.e(TAG, zza(str, objArr), th);
    }

    private static String zza(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            }
            if (!stackTrace[i].getClassName().equals(CLASS_NAME)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                String substring2 = substring.substring(substring.lastIndexOf(36) + 1);
                String methodName = stackTrace[i].getMethodName();
                StringBuilder sb = new StringBuilder(String.valueOf(substring2).length() + 1 + String.valueOf(methodName).length());
                sb.append(substring2);
                sb.append(".");
                sb.append(methodName);
                str2 = sb.toString();
                break;
            }
            i++;
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a */
        public static final boolean f12716a = zzaf.DEBUG;

        /* renamed from: b */
        private final List<H> f12717b = new ArrayList();

        /* renamed from: c */
        private boolean f12718c = false;

        public final synchronized void a(String str, long j) {
            if (!this.f12718c) {
                this.f12717b.add(new H(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        protected final void finalize() throws Throwable {
            if (this.f12718c) {
                return;
            }
            a("Request on the loose");
            zzaf.e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        public final synchronized void a(String str) {
            this.f12718c = true;
            long j = this.f12717b.size() == 0 ? 0L : this.f12717b.get(this.f12717b.size() - 1).f11557c - this.f12717b.get(0).f11557c;
            if (j <= 0) {
                return;
            }
            long j2 = this.f12717b.get(0).f11557c;
            zzaf.d("(%-4d ms) %s", Long.valueOf(j), str);
            for (H h2 : this.f12717b) {
                long j3 = h2.f11557c;
                zzaf.d("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(h2.f11556b), h2.f11555a);
                j2 = j3;
            }
        }
    }
}
