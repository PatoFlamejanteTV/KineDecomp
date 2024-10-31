package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class zzs {
    public static String TAG = "Volley";
    public static boolean DEBUG = Log.isLoggable(TAG, 2);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final boolean f1832a = zzs.DEBUG;
        private final List<C0040a> b = new ArrayList();
        private boolean c = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.android.gms.internal.zzs$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0040a {

            /* renamed from: a, reason: collision with root package name */
            public final String f1833a;
            public final long b;
            public final long c;

            public C0040a(String str, long j, long j2) {
                this.f1833a = str;
                this.b = j;
                this.c = j2;
            }
        }

        private long a() {
            if (this.b.size() == 0) {
                return 0L;
            }
            return this.b.get(this.b.size() - 1).c - this.b.get(0).c;
        }

        public synchronized void a(String str) {
            this.c = true;
            long a2 = a();
            if (a2 > 0) {
                long j = this.b.get(0).c;
                zzs.zzb("(%-4d ms) %s", Long.valueOf(a2), str);
                long j2 = j;
                for (C0040a c0040a : this.b) {
                    long j3 = c0040a.c;
                    zzs.zzb("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(c0040a.b), c0040a.f1833a);
                    j2 = j3;
                }
            }
        }

        public synchronized void a(String str, long j) {
            if (this.c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.b.add(new C0040a(str, j, SystemClock.elapsedRealtime()));
        }

        protected void finalize() throws Throwable {
            if (this.c) {
                return;
            }
            a("Request on the loose");
            zzs.zzc("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    public static void zza(String str, Object... objArr) {
        if (DEBUG) {
            Log.v(TAG, zzd(str, objArr));
        }
    }

    public static void zza(Throwable th, String str, Object... objArr) {
        Log.e(TAG, zzd(str, objArr), th);
    }

    public static void zzb(String str, Object... objArr) {
        Log.d(TAG, zzd(str, objArr));
    }

    public static void zzc(String str, Object... objArr) {
        Log.e(TAG, zzd(str, objArr));
    }

    private static String zzd(String str, Object... objArr) {
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
            if (!stackTrace[i].getClass().equals(zzs.class)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            }
            i++;
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }
}
