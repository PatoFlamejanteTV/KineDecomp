package com.google.android.gms.internal.firebase_auth;

/* loaded from: classes2.dex */
public enum zzo implements zzfw {
    USER_ATTRIBUTE_NAME_UNSPECIFIED(0),
    EMAIL(1),
    DISPLAY_NAME(2),
    PROVIDER(3),
    PHOTO_URL(4),
    PASSWORD(5),
    RAW_USER_INFO(6);

    private static final zzfx<zzo> zzfb = new zzfx<zzo>() { // from class: com.google.android.gms.internal.firebase_auth.Ya
    };
    private final int value;

    zzo(int i) {
        this.value = i;
    }

    public static zzo zzb(int i) {
        switch (i) {
            case 0:
                return USER_ATTRIBUTE_NAME_UNSPECIFIED;
            case 1:
                return EMAIL;
            case 2:
                return DISPLAY_NAME;
            case 3:
                return PROVIDER;
            case 4:
                return PHOTO_URL;
            case 5:
                return PASSWORD;
            case 6:
                return RAW_USER_INFO;
            default:
                return null;
        }
    }

    public static zzfy zzbj() {
        return Za.f13008a;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzfw
    public final int zzbi() {
        return this.value;
    }
}