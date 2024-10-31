package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public enum zzbmn implements zzbrg {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA256(3),
    SHA512(4),
    UNRECOGNIZED(-1);

    private static final zzbrh<zzbmn> zzcbx = new zzbrh<zzbmn>() { // from class: com.google.android.gms.internal.ads.Pg
    };
    private final int value;

    zzbmn(int i) {
        this.value = i;
    }

    public static zzbmn zzdt(int i) {
        if (i == 0) {
            return UNKNOWN_HASH;
        }
        if (i == 1) {
            return SHA1;
        }
        if (i == 3) {
            return SHA256;
        }
        if (i != 4) {
            return null;
        }
        return SHA512;
    }

    @Override // com.google.android.gms.internal.ads.zzbrg
    public final int zzom() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
