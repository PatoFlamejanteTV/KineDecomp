package com.adobe.creativesdk.foundation.adobeinternal.net;

/* compiled from: AdobeNetworkReachabilityUtil.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private static volatile AdobeNetworkReachability f4073a;

    /* renamed from: b */
    private static volatile int f4074b;

    public static synchronized void a() {
        synchronized (a.class) {
            if (f4073a == null) {
                f4074b = 0;
                return;
            }
            f4074b--;
            if (f4074b == 0) {
                f4073a.d();
                f4073a = null;
            }
        }
    }

    public static synchronized AdobeNetworkReachability b() {
        AdobeNetworkReachability adobeNetworkReachability;
        synchronized (a.class) {
            if (f4073a == null) {
                f4073a = new AdobeNetworkReachability();
                f4073a.a(c.a.a.a.c.a.a.b().a());
            }
            f4074b++;
            adobeNetworkReachability = f4073a;
        }
        return adobeNetworkReachability;
    }

    public static boolean c() {
        if (c.a.a.a.c.a.a.b().a() == null) {
            return false;
        }
        boolean b2 = b().b();
        a();
        return b2;
    }
}
