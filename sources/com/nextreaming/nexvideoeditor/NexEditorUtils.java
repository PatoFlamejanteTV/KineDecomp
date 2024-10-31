package com.nextreaming.nexvideoeditor;

import android.os.StrictMode;
import android.util.Log;

/* loaded from: classes3.dex */
public class NexEditorUtils {
    static {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                System.loadLibrary("nexeditorsdk");
            } catch (UnsatisfiedLinkError e2) {
                Log.e("NexEditorUtils", "[nexUtils.java] nexeditor load failed : " + e2);
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public static int a(int i, int i2, NexRectangle[] nexRectangleArr, int i3, int i4, int i5, NexRectangle[] nexRectangleArr2) {
        return getKenBurnsRectsN(i, i2, nexRectangleArr instanceof Object[] ? nexRectangleArr.length : 0, nexRectangleArr, i3, i4, i5, nexRectangleArr2);
    }

    private static native int getKenBurnsRectsN(int i, int i2, int i3, NexRectangle[] nexRectangleArr, int i4, int i5, int i6, NexRectangle[] nexRectangleArr2);
}
