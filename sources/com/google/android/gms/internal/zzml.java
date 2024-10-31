package com.google.android.gms.internal;

import android.content.Context;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class zzml {
    private static Pattern zzaij = null;

    public static boolean zzan(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static int zzca(int i) {
        return i / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
    }

    @Deprecated
    public static boolean zzcb(int i) {
        return false;
    }
}
