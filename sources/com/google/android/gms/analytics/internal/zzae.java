package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

@Deprecated
/* loaded from: classes.dex */
public class zzae {

    /* renamed from: a, reason: collision with root package name */
    private static volatile Logger f730a;

    static {
        a(new x());
    }

    public static Logger a() {
        return f730a;
    }

    public static void a(Logger logger) {
        f730a = logger;
    }

    public static void a(String str) {
        zzaf b = zzaf.b();
        if (b != null) {
            b.b(str);
        } else if (a(0)) {
            Log.v(zzy.c.a(), str);
        }
        Logger logger = f730a;
        if (logger != null) {
            logger.a(str);
        }
    }

    public static void a(String str, Object obj) {
        zzaf b = zzaf.b();
        if (b != null) {
            b.e(str, obj);
        } else if (a(3)) {
            Log.e(zzy.c.a(), obj != null ? str + ":" + obj : str);
        }
        Logger logger = f730a;
        if (logger != null) {
            logger.c(str);
        }
    }

    public static boolean a(int i) {
        return a() != null && a().a() <= i;
    }

    public static void b(String str) {
        zzaf b = zzaf.b();
        if (b != null) {
            b.e(str);
        } else if (a(2)) {
            Log.w(zzy.c.a(), str);
        }
        Logger logger = f730a;
        if (logger != null) {
            logger.b(str);
        }
    }
}
