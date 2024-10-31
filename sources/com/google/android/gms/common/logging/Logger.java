package com.google.android.gms.common.logging;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

@KeepForSdk
/* loaded from: classes.dex */
public class Logger {

    /* renamed from: a */
    private final String f11185a;

    /* renamed from: b */
    private final String f11186b;

    /* renamed from: c */
    private final GmsLogger f11187c;

    /* renamed from: d */
    private final int f11188d;

    /* JADX WARN: Illegal instructions before constructor call */
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Logger(java.lang.String r7, java.lang.String... r8) {
        /*
            r6 = this;
            int r0 = r8.length
            if (r0 != 0) goto L6
            java.lang.String r8 = ""
            goto L36
        L6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 91
            r0.append(r1)
            int r1 = r8.length
            r2 = 0
        L12:
            if (r2 >= r1) goto L28
            r3 = r8[r2]
            int r4 = r0.length()
            r5 = 1
            if (r4 <= r5) goto L22
            java.lang.String r4 = ","
            r0.append(r4)
        L22:
            r0.append(r3)
            int r2 = r2 + 1
            goto L12
        L28:
            r8 = 93
            r0.append(r8)
            r8 = 32
            r0.append(r8)
            java.lang.String r8 = r0.toString()
        L36:
            r6.<init>(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.logging.Logger.<init>(java.lang.String, java.lang.String[]):void");
    }

    private final String f(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f11186b.concat(str);
    }

    @KeepForSdk
    public boolean a(int i) {
        return this.f11188d <= i;
    }

    @KeepForSdk
    public void b(String str, Object... objArr) {
        Log.e(this.f11185a, f(str, objArr));
    }

    @KeepForSdk
    public void c(String str, Object... objArr) {
        Log.i(this.f11185a, f(str, objArr));
    }

    @KeepForSdk
    public void d(String str, Object... objArr) {
        if (a(2)) {
            Log.v(this.f11185a, f(str, objArr));
        }
    }

    @KeepForSdk
    public void e(String str, Object... objArr) {
        Log.w(this.f11185a, f(str, objArr));
    }

    @KeepForSdk
    public void a(String str, Object... objArr) {
        if (a(3)) {
            Log.d(this.f11185a, f(str, objArr));
        }
    }

    @KeepForSdk
    public void b(String str, Throwable th, Object... objArr) {
        Log.wtf(this.f11185a, f(str, objArr), th);
    }

    @KeepForSdk
    public void a(String str, Throwable th, Object... objArr) {
        Log.e(this.f11185a, f(str, objArr), th);
    }

    @KeepForSdk
    public void a(Throwable th) {
        Log.wtf(this.f11185a, th);
    }

    private Logger(String str, String str2) {
        this.f11186b = str2;
        this.f11185a = str;
        this.f11187c = new GmsLogger(str);
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.f11185a, i)) {
            i++;
        }
        this.f11188d = i;
    }
}
