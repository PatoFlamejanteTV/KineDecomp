package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.zzqc;

/* loaded from: classes.dex */
public final class zzo {

    /* renamed from: a, reason: collision with root package name */
    public static final int f1021a = 23 - " PII_LOG".length();
    private static final String b = null;
    private final String c;
    private final String d;

    public zzo(String str) {
        this(str, b);
    }

    public zzo(String str, String str2) {
        zzx.a(str, (Object) "log tag cannot be null");
        zzx.b(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.c = str;
        if (str2 == null || str2.length() <= 0) {
            this.d = b;
        } else {
            this.d = str2;
        }
    }

    private String a(String str) {
        return this.d == null ? str : this.d.concat(str);
    }

    public void a(Context context, String str, String str2, Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stackTrace.length && i < 2; i++) {
            sb.append(stackTrace[i].toString());
            sb.append("\n");
        }
        zzqc zzqcVar = new zzqc(context, 10);
        zzqcVar.zza("GMS_WTF", null, "GMS_WTF", sb.toString());
        zzqcVar.send();
        if (a(7)) {
            Log.e(str, a(str2), th);
            Log.wtf(str, a(str2), th);
        }
    }

    public void a(String str, String str2) {
        if (a(5)) {
            Log.w(str, a(str2));
        }
    }

    public void a(String str, String str2, Throwable th) {
        if (a(5)) {
            Log.w(str, a(str2), th);
        }
    }

    public boolean a(int i) {
        return Log.isLoggable(this.c, i);
    }

    public void b(String str, String str2) {
        if (a(6)) {
            Log.e(str, a(str2));
        }
    }

    public void b(String str, String str2, Throwable th) {
        if (a(6)) {
            Log.e(str, a(str2), th);
        }
    }
}
