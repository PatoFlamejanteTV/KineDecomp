package com.google.android.gms.internal.ads;

import com.google.ads.AdRequest;

/* renamed from: com.google.android.gms.internal.ads.zb */
/* loaded from: classes2.dex */
final /* synthetic */ class C1175zb {

    /* renamed from: a */
    private static final /* synthetic */ int[] f12696a;

    /* renamed from: b */
    static final /* synthetic */ int[] f12697b = new int[AdRequest.ErrorCode.values().length];

    static {
        try {
            f12697b[AdRequest.ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f12697b[AdRequest.ErrorCode.INVALID_REQUEST.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f12697b[AdRequest.ErrorCode.NETWORK_ERROR.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f12697b[AdRequest.ErrorCode.NO_FILL.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        f12696a = new int[AdRequest.Gender.values().length];
        try {
            f12696a[AdRequest.Gender.FEMALE.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f12696a[AdRequest.Gender.MALE.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f12696a[AdRequest.Gender.UNKNOWN.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
