package com.flurry.sdk;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class au extends aw {

    /* renamed from: a, reason: collision with root package name */
    private final int f469a;

    public au(String str, int i) {
        super(a(str, i));
        this.f469a = i;
    }

    private static ax a(String str, int i) {
        if (!b(str, i)) {
            return null;
        }
        return av.a(str);
    }

    private static boolean b(String str, int i) {
        return !TextUtils.isEmpty(str) && Build.VERSION.SDK_INT >= i;
    }
}
