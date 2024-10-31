package io.fabric.sdk.android;

import android.util.Log;

/* compiled from: DefaultLogger.java */
/* loaded from: classes3.dex */
public class c implements o {

    /* renamed from: a */
    private int f26837a;

    public c(int i) {
        this.f26837a = i;
    }

    @Override // io.fabric.sdk.android.o
    public void a(String str, String str2, Throwable th) {
        if (isLoggable(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    @Override // io.fabric.sdk.android.o
    public void b(String str, String str2, Throwable th) {
        if (isLoggable(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    @Override // io.fabric.sdk.android.o
    public void c(String str, String str2, Throwable th) {
        if (isLoggable(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    public void d(String str, String str2, Throwable th) {
        if (isLoggable(str, 4)) {
            Log.i(str, str2, th);
        }
    }

    public void e(String str, String str2, Throwable th) {
        if (isLoggable(str, 2)) {
            Log.v(str, str2, th);
        }
    }

    @Override // io.fabric.sdk.android.o
    public boolean isLoggable(String str, int i) {
        return this.f26837a <= i;
    }

    @Override // io.fabric.sdk.android.o
    public void log(int i, String str, String str2) {
        a(i, str, str2, false);
    }

    public c() {
        this.f26837a = 4;
    }

    @Override // io.fabric.sdk.android.o
    public void a(String str, String str2) {
        d(str, str2, null);
    }

    @Override // io.fabric.sdk.android.o
    public void b(String str, String str2) {
        b(str, str2, null);
    }

    @Override // io.fabric.sdk.android.o
    public void c(String str, String str2) {
        e(str, str2, null);
    }

    @Override // io.fabric.sdk.android.o
    public void d(String str, String str2) {
        a(str, str2, null);
    }

    @Override // io.fabric.sdk.android.o
    public void e(String str, String str2) {
        c(str, str2, null);
    }

    @Override // io.fabric.sdk.android.o
    public void a(int i, String str, String str2, boolean z) {
        if (z || isLoggable(str, i)) {
            Log.println(i, str, str2);
        }
    }
}
