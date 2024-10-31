package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
/* loaded from: classes.dex */
public final class CrashUtils {

    /* renamed from: a */
    private static final String[] f11262a = {"android.", "com.android.", "dalvik.", "java.", "javax."};

    /* renamed from: b */
    private static DropBoxManager f11263b = null;

    /* renamed from: c */
    private static boolean f11264c = false;

    /* renamed from: d */
    private static int f11265d = -1;

    /* renamed from: e */
    private static int f11266e = 0;

    /* renamed from: f */
    private static int f11267f = 0;

    @KeepForSdk
    public static boolean a(Context context, Throwable th) {
        return a(context, th, 536870912);
    }

    private static boolean a(Context context, Throwable th, int i) {
        try {
            Preconditions.a(context);
            Preconditions.a(th);
            return false;
        } catch (Exception e2) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e2);
            return false;
        }
    }
}
