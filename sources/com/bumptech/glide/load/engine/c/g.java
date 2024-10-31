package com.bumptech.glide.load.engine.c;

import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.util.regex.Pattern;

/* compiled from: RuntimeCompat.java */
/* loaded from: classes.dex */
final class g {
    public static int a() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        return Build.VERSION.SDK_INT < 17 ? Math.max(b(), availableProcessors) : availableProcessors;
    }

    private static int b() {
        File[] fileArr;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                fileArr = new File("/sys/devices/system/cpu/").listFiles(new f(Pattern.compile("cpu[0-9]+")));
            } catch (Throwable th) {
                if (Log.isLoggable("GlideRuntimeCompat", 6)) {
                    Log.e("GlideRuntimeCompat", "Failed to calculate accurate cpu count", th);
                }
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                fileArr = null;
            }
            return Math.max(1, fileArr != null ? fileArr.length : 0);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
