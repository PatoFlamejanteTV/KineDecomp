package com.nexstreaming.app.general.util;

import android.os.Build;
import android.view.View;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: IdUtil.java */
/* renamed from: com.nexstreaming.app.general.util.n */
/* loaded from: classes2.dex */
public class C1710n {

    /* renamed from: a */
    private static final AtomicInteger f19872a = new AtomicInteger(10485760);

    public static int a() {
        if (Build.VERSION.SDK_INT > 17) {
            return View.generateViewId();
        }
        return b();
    }

    private static int b() {
        int i;
        int i2;
        do {
            i = f19872a.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!f19872a.compareAndSet(i, i2));
        return i;
    }
}
