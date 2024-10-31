package com.nexstreaming.app.general.tracelog;

/* compiled from: CpOrderList.java */
/* loaded from: classes2.dex */
/* synthetic */ class i {

    /* renamed from: a */
    static final /* synthetic */ int[] f19785a = new int[ResponseCode.values().length];

    static {
        try {
            f19785a[ResponseCode.SUCCESS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f19785a[ResponseCode.APPAUTH_FAILED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f19785a[ResponseCode.INVALID_APIVERSION.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f19785a[ResponseCode.ERR_NORMAL.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f19785a[ResponseCode.AUTH_FAILED_XIAOMI_UID.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f19785a[ResponseCode.NOT_FOUND_LIST.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f19785a[ResponseCode.SOMETHING_WRONG.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
