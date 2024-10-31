package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdPlacementType;

/* renamed from: com.facebook.ads.redexgen.X.1J, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public /* synthetic */ class C1J {
    public static final /* synthetic */ int[] A00 = new int[AdPlacementType.values().length];

    static {
        try {
            A00[AdPlacementType.BANNER.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            A00[AdPlacementType.INTERSTITIAL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            A00[AdPlacementType.NATIVE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            A00[AdPlacementType.NATIVE_BANNER.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            A00[AdPlacementType.INSTREAM.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            A00[AdPlacementType.REWARDED_VIDEO.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
