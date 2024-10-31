package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public enum zzblx implements zzbrg {
    UNKNOWN_FORMAT(0),
    UNCOMPRESSED(1),
    COMPRESSED(2),
    DO_NOT_USE_CRUNCHY_UNCOMPRESSED(3),
    UNRECOGNIZED(-1);

    private static final zzbrh<zzblx> zzcbx = new zzbrh<zzblx>() { // from class: com.google.android.gms.internal.ads.Hg
    };
    private final int value;

    zzblx(int i) {
        this.value = i;
    }

    public static zzblx zzdp(int i) {
        if (i == 0) {
            return UNKNOWN_FORMAT;
        }
        if (i == 1) {
            return UNCOMPRESSED;
        }
        if (i == 2) {
            return COMPRESSED;
        }
        if (i != 3) {
            return null;
        }
        return DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
    }

    @Override // com.google.android.gms.internal.ads.zzbrg
    public final int zzom() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
