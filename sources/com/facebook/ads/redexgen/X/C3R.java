package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdSettings;

/* renamed from: com.facebook.ads.redexgen.X.3R, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public /* synthetic */ class C3R {
    public static final /* synthetic */ int[] A00 = new int[AdSettings.IntegrationErrorMode.values().length];

    static {
        try {
            A00[AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CRASH_DEBUG_MODE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            A00[AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CALLBACK_MODE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
