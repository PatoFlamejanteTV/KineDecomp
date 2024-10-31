package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public enum zzbmy implements zzbrg {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);

    private static final zzbrh<zzbmy> zzcbx = new zzbrh<zzbmy>() { // from class: com.google.android.gms.internal.ads.Vg
    };
    private final int value;

    zzbmy(int i) {
        this.value = i;
    }

    public static zzbmy zzdw(int i) {
        if (i == 0) {
            return UNKNOWN_STATUS;
        }
        if (i == 1) {
            return ENABLED;
        }
        if (i == 2) {
            return DISABLED;
        }
        if (i != 3) {
            return null;
        }
        return DESTROYED;
    }

    @Override // com.google.android.gms.internal.ads.zzbrg
    public final int zzom() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
