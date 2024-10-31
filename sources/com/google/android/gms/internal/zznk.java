package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zznk {
    private static int zzarj = -1;

    public static boolean zzau(Context context) {
        return zzax(context) == 3;
    }

    private static int zzav(Context context) {
        return ((zzaw(context) % LicenseErrCode.LICENSE_STATUS_NOT_LICENSED) / 100) + 5;
    }

    private static int zzaw(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("Fitness", "Could not find package info for Google Play Services");
            return -1;
        }
    }

    public static int zzax(Context context) {
        if (zzarj == -1) {
            switch (zzav(context)) {
                case 8:
                case 13:
                    zzarj = 0;
                    break;
                case 9:
                case 11:
                case 12:
                default:
                    zzarj = zzay(context) ? 1 : 2;
                    break;
                case 10:
                    zzarj = 3;
                    break;
            }
        }
        return zzarj;
    }

    private static boolean zzay(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getPhoneType() != 0;
    }
}
