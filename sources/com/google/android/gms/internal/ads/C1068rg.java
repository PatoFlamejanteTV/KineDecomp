package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.rg */
/* loaded from: classes2.dex */
final /* synthetic */ class C1068rg {

    /* renamed from: a */
    static final /* synthetic */ int[] f12493a;

    /* renamed from: b */
    static final /* synthetic */ int[] f12494b;

    /* renamed from: c */
    static final /* synthetic */ int[] f12495c = new int[zzblx.values().length];

    static {
        try {
            f12495c[zzblx.UNCOMPRESSED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f12495c[zzblx.DO_NOT_USE_CRUNCHY_UNCOMPRESSED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f12495c[zzblx.COMPRESSED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        f12494b = new int[zzbml.values().length];
        try {
            f12494b[zzbml.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f12494b[zzbml.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f12494b[zzbml.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
        f12493a = new int[zzbmn.values().length];
        try {
            f12493a[zzbmn.SHA1.ordinal()] = 1;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f12493a[zzbmn.SHA256.ordinal()] = 2;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f12493a[zzbmn.SHA512.ordinal()] = 3;
        } catch (NoSuchFieldError unused9) {
        }
    }
}
