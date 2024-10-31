package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public enum zzvc implements zzbrg {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_UNKNOWN(1000);

    private static final zzbrh<zzvc> zzcbx = new zzbrh<zzvc>() { // from class: com.google.android.gms.internal.ads.dn
    };
    private final int value;

    zzvc(int i) {
        this.value = i;
    }

    public static zzvc zzcd(int i) {
        if (i == 0) {
            return ENUM_FALSE;
        }
        if (i == 1) {
            return ENUM_TRUE;
        }
        if (i != 1000) {
            return null;
        }
        return ENUM_UNKNOWN;
    }

    public static zzbri zzop() {
        return en.f12152a;
    }

    @Override // com.google.android.gms.internal.ads.zzbrg
    public final int zzom() {
        return this.value;
    }
}
