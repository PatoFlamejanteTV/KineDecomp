package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;

/* compiled from: FlowableCreate.java */
/* loaded from: classes3.dex */
/* synthetic */ class c {

    /* renamed from: a */
    static final /* synthetic */ int[] f28213a = new int[BackpressureStrategy.values().length];

    static {
        try {
            f28213a[BackpressureStrategy.MISSING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f28213a[BackpressureStrategy.ERROR.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f28213a[BackpressureStrategy.DROP.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f28213a[BackpressureStrategy.LATEST.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
