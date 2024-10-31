package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.Wrappers;

@KeepForSdk
/* loaded from: classes.dex */
public class ClientLibraryUtils {
    private ClientLibraryUtils() {
    }

    @KeepForSdk
    public static int a(Context context, String str) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        PackageInfo c2 = c(context, str);
        if (c2 == null || (applicationInfo = c2.applicationInfo) == null || (bundle = applicationInfo.metaData) == null) {
            return -1;
        }
        return bundle.getInt("com.google.android.gms.version", -1);
    }

    @KeepForSdk
    public static boolean a() {
        return false;
    }

    public static boolean b(Context context, String str) {
        "com.google.android.gms".equals(str);
        return (Wrappers.a(context).a(str, 0).flags & 2097152) != 0;
    }

    private static PackageInfo c(Context context, String str) {
        try {
            return Wrappers.a(context).b(str, 128);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
