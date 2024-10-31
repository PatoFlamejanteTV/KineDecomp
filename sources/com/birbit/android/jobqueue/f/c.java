package com.birbit.android.jobqueue.f;

import android.util.Log;

/* compiled from: JqLog.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    private static com.birbit.android.jobqueue.f.a f8150a;

    /* compiled from: JqLog.java */
    /* loaded from: classes.dex */
    public static class a implements com.birbit.android.jobqueue.f.a {
        @Override // com.birbit.android.jobqueue.f.a
        public void a(String str, Object... objArr) {
        }

        @Override // com.birbit.android.jobqueue.f.a
        public void a(Throwable th, String str, Object... objArr) {
            Log.e("JobManager", String.format(str, objArr), th);
        }

        @Override // com.birbit.android.jobqueue.f.a
        public void b(String str, Object... objArr) {
        }

        @Override // com.birbit.android.jobqueue.f.a
        public void c(String str, Object... objArr) {
            Log.e("JobManager", String.format(str, objArr));
        }

        @Override // com.birbit.android.jobqueue.f.a
        public boolean isDebugEnabled() {
            return false;
        }
    }

    static {
        a();
    }

    public static void a() {
        a(new b());
    }

    public static boolean b() {
        return f8150a.isDebugEnabled();
    }

    public static void c(String str, Object... objArr) {
        f8150a.b(str, objArr);
    }

    public static void a(com.birbit.android.jobqueue.f.a aVar) {
        f8150a = aVar;
    }

    public static void b(String str, Object... objArr) {
        f8150a.c(str, objArr);
    }

    public static void a(String str, Object... objArr) {
        f8150a.a(str, objArr);
    }

    public static void a(Throwable th, String str, Object... objArr) {
        f8150a.a(th, str, objArr);
    }
}
