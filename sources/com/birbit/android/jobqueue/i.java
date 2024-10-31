package com.birbit.android.jobqueue;

import com.birbit.android.jobqueue.messaging.Type;

/* compiled from: ConsumerManager.java */
/* loaded from: classes.dex */
/* synthetic */ class i {

    /* renamed from: a */
    static final /* synthetic */ int[] f8173a = new int[Type.values().length];

    static {
        try {
            f8173a[Type.RUN_JOB.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f8173a[Type.COMMAND.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
