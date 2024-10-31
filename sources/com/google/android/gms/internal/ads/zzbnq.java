package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public enum zzbnq implements zzbrg {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);

    private static final zzbrh<zzbnq> zzcbx = new zzbrh<zzbnq>() { // from class: com.google.android.gms.internal.ads.dh
    };
    private final int value;

    zzbnq(int i) {
        this.value = i;
    }

    public static zzbnq zzef(int i) {
        if (i == 0) {
            return UNKNOWN_PREFIX;
        }
        if (i == 1) {
            return TINK;
        }
        if (i == 2) {
            return LEGACY;
        }
        if (i == 3) {
            return RAW;
        }
        if (i != 4) {
            return null;
        }
        return CRUNCHY;
    }

    @Override // com.google.android.gms.internal.ads.zzbrg
    public final int zzom() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
