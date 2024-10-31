package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: VolleyLog.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a */
    public static String f8091a = "Volley";

    /* renamed from: b */
    public static boolean f8092b = Log.isLoggable(f8091a, 2);

    public static void a(String str, Object... objArr) {
        Log.d(f8091a, d(str, objArr));
    }

    public static void b(String str, Object... objArr) {
        Log.e(f8091a, d(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        if (f8092b) {
            Log.v(f8091a, d(str, objArr));
        }
    }

    private static String d(String str, Object... objArr) {
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
            if (!stackTrace[i].getClass().equals(p.class)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            }
            i++;
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(f8091a, d(str, objArr), th);
    }

    /* compiled from: VolleyLog.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public static final boolean f8093a = p.f8092b;

        /* renamed from: b */
        private final List<C0041a> f8094b = new ArrayList();

        /* renamed from: c */
        private boolean f8095c = false;

        /* compiled from: VolleyLog.java */
        /* renamed from: com.android.volley.p$a$a */
        /* loaded from: classes.dex */
        public static class C0041a {

            /* renamed from: a */
            public final String f8096a;

            /* renamed from: b */
            public final long f8097b;

            /* renamed from: c */
            public final long f8098c;

            public C0041a(String str, long j, long j2) {
                this.f8096a = str;
                this.f8097b = j;
                this.f8098c = j2;
            }
        }

        public synchronized void a(String str, long j) {
            if (!this.f8095c) {
                this.f8094b.add(new C0041a(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        protected void finalize() throws Throwable {
            if (this.f8095c) {
                return;
            }
            a("Request on the loose");
            p.b("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        public synchronized void a(String str) {
            this.f8095c = true;
            long a2 = a();
            if (a2 <= 0) {
                return;
            }
            long j = this.f8094b.get(0).f8098c;
            p.a("(%-4d ms) %s", Long.valueOf(a2), str);
            for (C0041a c0041a : this.f8094b) {
                long j2 = c0041a.f8098c;
                p.a("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(c0041a.f8097b), c0041a.f8096a);
                j = j2;
            }
        }

        private long a() {
            if (this.f8094b.size() == 0) {
                return 0L;
            }
            return this.f8094b.get(r2.size() - 1).f8098c - this.f8094b.get(0).f8098c;
        }
    }
}
