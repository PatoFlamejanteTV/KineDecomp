package io.grpc.internal;

import io.grpc.Status;

/* compiled from: CensusTracingModule.java */
/* loaded from: classes3.dex */
/* synthetic */ class I {

    /* renamed from: a */
    static final /* synthetic */ int[] f27359a = new int[Status.Code.values().length];

    static {
        try {
            f27359a[Status.Code.OK.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f27359a[Status.Code.CANCELLED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f27359a[Status.Code.UNKNOWN.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f27359a[Status.Code.INVALID_ARGUMENT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f27359a[Status.Code.DEADLINE_EXCEEDED.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f27359a[Status.Code.NOT_FOUND.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f27359a[Status.Code.ALREADY_EXISTS.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f27359a[Status.Code.PERMISSION_DENIED.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f27359a[Status.Code.RESOURCE_EXHAUSTED.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f27359a[Status.Code.FAILED_PRECONDITION.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f27359a[Status.Code.ABORTED.ordinal()] = 11;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f27359a[Status.Code.OUT_OF_RANGE.ordinal()] = 12;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f27359a[Status.Code.UNIMPLEMENTED.ordinal()] = 13;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            f27359a[Status.Code.INTERNAL.ordinal()] = 14;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            f27359a[Status.Code.UNAVAILABLE.ordinal()] = 15;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            f27359a[Status.Code.DATA_LOSS.ordinal()] = 16;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            f27359a[Status.Code.UNAUTHENTICATED.ordinal()] = 17;
        } catch (NoSuchFieldError unused17) {
        }
    }
}
