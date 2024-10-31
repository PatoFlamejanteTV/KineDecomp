package com.adobe.creativesdk.foundation.internal.utils;

import android.content.Context;
import android.content.res.Resources;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;

/* compiled from: UiUtils.java */
/* loaded from: classes.dex */
public class v {
    public static int a(Context context) {
        int identifier;
        boolean hasPermanentMenuKey = ViewConfiguration.get(context).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey && deviceHasKey) {
            return 0;
        }
        Resources resources = context.getResources();
        int i = context.getResources().getConfiguration().orientation;
        if (b(context)) {
            identifier = resources.getIdentifier(i != 1 ? "navigation_bar_height_landscape" : "navigation_bar_height", "dimen", "android");
        } else {
            identifier = resources.getIdentifier(i != 1 ? "navigation_bar_width" : "navigation_bar_height", "dimen", "android");
        }
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private static boolean b(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }
}
