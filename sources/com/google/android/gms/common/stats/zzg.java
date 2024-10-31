package com.google.android.gms.common.stats;

import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class zzg {
    public static String a(PowerManager.WakeLock wakeLock, String str) {
        StringBuilder append = new StringBuilder().append(String.valueOf((Process.myPid() << 32) | System.identityHashCode(wakeLock)));
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return append.append(str).toString();
    }
}
