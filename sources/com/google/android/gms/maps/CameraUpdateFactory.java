package com.google.android.gms.maps;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;

/* loaded from: classes.dex */
public final class CameraUpdateFactory {

    /* renamed from: a, reason: collision with root package name */
    private static ICameraUpdateFactoryDelegate f1908a;

    private CameraUpdateFactory() {
    }

    public static void a(ICameraUpdateFactoryDelegate iCameraUpdateFactoryDelegate) {
        f1908a = (ICameraUpdateFactoryDelegate) zzx.a(iCameraUpdateFactoryDelegate);
    }
}
