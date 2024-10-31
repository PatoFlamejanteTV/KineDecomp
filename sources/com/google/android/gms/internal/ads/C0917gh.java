package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.gh */
/* loaded from: classes2.dex */
final /* synthetic */ class C0917gh {

    /* renamed from: a */
    static final /* synthetic */ int[] f12179a;

    /* renamed from: b */
    static final /* synthetic */ int[] f12180b = new int[zzboi.values().length];

    static {
        try {
            f12180b[zzboi.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f12180b[zzboi.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f12180b[zzboi.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        f12179a = new int[zzboj.values().length];
        try {
            f12179a[zzboj.UNCOMPRESSED.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f12179a[zzboj.DO_NOT_USE_CRUNCHY_UNCOMPRESSED.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f12179a[zzboj.COMPRESSED.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
