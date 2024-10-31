package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public enum zzbml implements zzbrg {
    UNKNOWN_CURVE(0),
    NIST_P256(2),
    NIST_P384(3),
    NIST_P521(4),
    UNRECOGNIZED(-1);

    private static final zzbrh<zzbml> zzcbx = new zzbrh<zzbml>() { // from class: com.google.android.gms.internal.ads.Og
    };
    private final int value;

    zzbml(int i) {
        this.value = i;
    }

    public static zzbml zzds(int i) {
        if (i == 0) {
            return UNKNOWN_CURVE;
        }
        if (i == 2) {
            return NIST_P256;
        }
        if (i == 3) {
            return NIST_P384;
        }
        if (i != 4) {
            return null;
        }
        return NIST_P521;
    }

    @Override // com.google.android.gms.internal.ads.zzbrg
    public final int zzom() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
