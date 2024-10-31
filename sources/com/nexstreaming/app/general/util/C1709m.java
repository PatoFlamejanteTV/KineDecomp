package com.nexstreaming.app.general.util;

import android.os.StatFs;
import android.util.Log;
import java.io.File;

/* compiled from: FreeSpaceChecker.java */
/* renamed from: com.nexstreaming.app.general.util.m */
/* loaded from: classes2.dex */
public final class C1709m {
    public static boolean a(File file, long j) {
        long a2 = a(file);
        Log.i("FreeSpaceChecker", "device free volume : " + a2);
        Log.i("FreeSpaceChecker", "extraSpaceSize : " + j);
        return a2 > j;
    }

    public static boolean a(File file, long j, long j2) {
        return a(file, j + j2);
    }

    public static long a(File file) {
        while (file != null && !file.exists()) {
            file = file.getParentFile();
        }
        if (file == null) {
            return Long.MAX_VALUE;
        }
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            return (statFs.getAvailableBlocks() - 1) * statFs.getBlockSize();
        } catch (IllegalArgumentException e2) {
            Log.e("FreeSpaceChecker", "KM-1618 : ", e2);
            return Long.MAX_VALUE;
        }
    }
}