package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

@KeepForSdk
/* loaded from: classes.dex */
public class InstantApps {

    /* renamed from: a */
    private static Context f11305a;

    /* renamed from: b */
    private static Boolean f11306b;

    @KeepForSdk
    public static synchronized boolean a(Context context) {
        synchronized (InstantApps.class) {
            Context applicationContext = context.getApplicationContext();
            if (f11305a != null && f11306b != null && f11305a == applicationContext) {
                return f11306b.booleanValue();
            }
            f11306b = null;
            if (PlatformVersion.k()) {
                f11306b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
            } else {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    f11306b = true;
                } catch (ClassNotFoundException unused) {
                    f11306b = false;
                }
            }
            f11305a = applicationContext;
            return f11306b.booleanValue();
        }
    }
}
