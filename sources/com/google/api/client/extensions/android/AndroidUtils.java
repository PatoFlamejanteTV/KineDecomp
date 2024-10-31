package com.google.api.client.extensions.android;

import android.os.Build;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;

@Beta
/* loaded from: classes.dex */
public class AndroidUtils {
    public static boolean a(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    public static void b(int i) {
        Preconditions.a(a(i), "running on Android SDK level %s but requires minimum %s", Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i));
    }

    private AndroidUtils() {
    }
}
