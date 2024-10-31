package com.adobe.creativesdk.foundation.internal.utils.photoview.c;

import android.content.Context;
import android.os.Build;

/* compiled from: ScrollerProxy.java */
/* loaded from: classes.dex */
public abstract class d {
    public static d a(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i < 9) {
            return new c(context);
        }
        if (i < 14) {
            return new a(context);
        }
        return new b(context);
    }

    public abstract void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    public abstract void a(boolean z);

    public abstract boolean a();

    public abstract int b();

    public abstract int c();

    public abstract boolean d();
}
