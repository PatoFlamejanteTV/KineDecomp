package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;

/* loaded from: classes.dex */
public class zzmm {
    public static boolean zzjA() {
        return com.google.android.gms.common.internal.zzd.f1003a && zzlr.isInitialized() && zzlr.zzoo() == Process.myUid();
    }

    public static boolean zzl(Context context, String str) {
        try {
            return (context.getPackageManager().getApplicationInfo(str, 0).flags & 2097152) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
