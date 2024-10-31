package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.storage.C0582ma;

/* compiled from: AssetsAbsListView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.ob */
/* loaded from: classes.dex */
public abstract class AbstractC0452ob extends AbstractC0457pb implements InterfaceC0377dd {
    public static double a(float f2) {
        double d2 = f2;
        int i = c.a.a.a.c.a.a.b().a().getResources().getDisplayMetrics().densityDpi;
        if (i >= 320) {
            return f2 * 2.0f;
        }
        if (i <= 160) {
            return d2;
        }
        Double.isNaN(d2);
        return d2 * 1.5d;
    }

    public static C0582ma a(C0582ma c0582ma) {
        return new C0582ma((float) a(c0582ma.f7348a), (float) a(c0582ma.f7349b));
    }
}
