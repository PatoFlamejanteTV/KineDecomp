package com.google.api.client.extensions.android;

import android.os.Build;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;

@Beta
/* loaded from: classes2.dex */
public class AndroidUtils {
    private AndroidUtils() {
    }

    public static void a(int i) {
        Preconditions.a(b(i), "running on Android SDK level %s but requires minimum %s", Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i));
    }

    public static boolean b(int i) {
        return Build.VERSION.SDK_INT >= i;
    }
}
