package com.adobe.creativesdk.foundation.internal.utils;

import android.content.Context;
import android.graphics.Typeface;

/* compiled from: AdobeCSDKTypeFace.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    private static Typeface f6851a;

    public static Typeface a(Context context) {
        if (f6851a == null) {
            f6851a = Typeface.createFromAsset(context.getResources().getAssets(), "fonts/AdobeClean-SemiLight.otf");
        }
        return f6851a;
    }
}
