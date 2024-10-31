package com.google.android.gms.common;

import android.util.Log;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
/* loaded from: classes.dex */
public class i {

    /* renamed from: a */
    private static final i f11024a = new i(true, null, null);

    /* renamed from: b */
    final boolean f11025b;

    /* renamed from: c */
    private final String f11026c;

    /* renamed from: d */
    private final Throwable f11027d;

    public i(boolean z, @Nullable String str, @Nullable Throwable th) {
        this.f11025b = z;
        this.f11026c = str;
        this.f11027d = th;
    }

    public static i a(Callable<String> callable) {
        return new k(callable);
    }

    public static i b() {
        return f11024a;
    }

    public final void c() {
        if (this.f11025b || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.f11027d != null) {
            Log.d("GoogleCertificatesRslt", a(), this.f11027d);
        } else {
            Log.d("GoogleCertificatesRslt", a());
        }
    }

    public static i a(String str) {
        return new i(false, str, null);
    }

    public static i a(String str, Throwable th) {
        return new i(false, str, th);
    }

    @Nullable
    String a() {
        return this.f11026c;
    }

    public static String a(String str, c cVar, boolean z, boolean z2) {
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", z2 ? "debug cert rejected" : "not whitelisted", str, Hex.a(AndroidUtilsLight.a("SHA-1").digest(cVar.v())), Boolean.valueOf(z), "12451009.false");
    }
}
