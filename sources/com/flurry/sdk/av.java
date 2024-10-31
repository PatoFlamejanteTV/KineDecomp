package com.flurry.sdk;

import android.text.TextUtils;

/* loaded from: classes.dex */
public final class av {

    /* renamed from: a, reason: collision with root package name */
    private static final String f470a = av.class.getSimpleName();

    public static ax a(String str) {
        ax axVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            axVar = (ax) Class.forName(str).getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            as.a(5, f470a, "FlurryModule " + str + " is not available:", e);
            axVar = null;
        }
        return axVar;
    }
}
