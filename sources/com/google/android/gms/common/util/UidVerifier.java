package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.Wrappers;

@KeepForSdk
/* loaded from: classes.dex */
public final class UidVerifier {
    private UidVerifier() {
    }

    @KeepForSdk
    public static boolean a(Context context, int i) {
        if (!a(context, i, "com.google.android.gms")) {
            return false;
        }
        try {
            return GoogleSignatureVerifier.a(context).a(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (PackageManager.NameNotFoundException unused) {
            if (Log.isLoggable("UidVerifier", 3)) {
                Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            }
            return false;
        }
    }

    @KeepForSdk
    @TargetApi(19)
    public static boolean a(Context context, int i, String str) {
        return Wrappers.a(context).a(i, str);
    }
}
