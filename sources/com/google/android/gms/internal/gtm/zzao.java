package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.GoogleApiAvailabilityLight;

/* loaded from: classes2.dex */
public final class zzao {
    public static final String VERSION = String.valueOf(GoogleApiAvailabilityLight.f10663a / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    public static final String zzwe;

    static {
        String valueOf = String.valueOf(VERSION);
        zzwe = valueOf.length() != 0 ? "ma".concat(valueOf) : new String("ma");
    }
}
