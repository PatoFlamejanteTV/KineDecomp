package com.google.android.gms.cast.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.Locale;

/* loaded from: classes.dex */
public class zzl {
    private static boolean b = false;

    /* renamed from: a, reason: collision with root package name */
    protected final String f857a;
    private final boolean c;
    private boolean d;
    private boolean e;
    private String f;

    public zzl(String str) {
        this(str, c());
    }

    public zzl(String str, boolean z) {
        zzx.a(str, (Object) "The log tag cannot be null or empty.");
        this.f857a = str;
        this.c = str.length() <= 23;
        this.d = z;
        this.e = false;
    }

    public static boolean c() {
        return b;
    }

    public void a(String str) {
        this.f = TextUtils.isEmpty(str) ? null : String.format("[%s] ", str);
    }

    public void a(String str, Object... objArr) {
        if (b()) {
            Log.v(this.f857a, f(str, objArr));
        }
    }

    public void a(Throwable th, String str, Object... objArr) {
        if (a() || b) {
            Log.d(this.f857a, f(str, objArr), th);
        }
    }

    public boolean a() {
        return this.d || (this.c && Log.isLoggable(this.f857a, 3));
    }

    public void b(String str, Object... objArr) {
        if (a() || b) {
            Log.d(this.f857a, f(str, objArr));
        }
    }

    public void b(Throwable th, String str, Object... objArr) {
        Log.w(this.f857a, f(str, objArr), th);
    }

    public boolean b() {
        return this.e;
    }

    public void c(String str, Object... objArr) {
        Log.i(this.f857a, f(str, objArr));
    }

    public void d(String str, Object... objArr) {
        Log.w(this.f857a, f(str, objArr));
    }

    public void e(String str, Object... objArr) {
        Log.e(this.f857a, f(str, objArr));
    }

    protected String f(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(Locale.ROOT, str, objArr);
        }
        return !TextUtils.isEmpty(this.f) ? this.f + str : str;
    }
}
