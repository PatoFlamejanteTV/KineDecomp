package com.nexstreaming.kinemaster.tracelog;

import com.nexstreaming.app.general.tracelog.ResponseCode;

/* compiled from: APCManager.java */
/* loaded from: classes.dex */
/* synthetic */ class e {

    /* renamed from: a */
    static final /* synthetic */ int[] f21286a = new int[ResponseCode.values().length];

    static {
        try {
            f21286a[ResponseCode.PROMOCODE_NONE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f21286a[ResponseCode.INVALID_PROMOCODE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f21286a[ResponseCode.PROMOCODE_ALREADY.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f21286a[ResponseCode.EXPIRED_PROMOCODE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f21286a[ResponseCode.ALREADYINUSE_PROMOCODE.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f21286a[ResponseCode.SUCCESS.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
