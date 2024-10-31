package com.birbit.android.jobqueue;

import com.birbit.android.jobqueue.messaging.Type;

/* compiled from: JobManagerThread.java */
/* loaded from: classes.dex */
/* synthetic */ class t {

    /* renamed from: a */
    static final /* synthetic */ int[] f8310a = new int[Type.values().length];

    static {
        try {
            f8310a[Type.ADD_JOB.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f8310a[Type.JOB_CONSUMER_IDLE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f8310a[Type.RUN_JOB_RESULT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f8310a[Type.CONSTRAINT_CHANGE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f8310a[Type.CANCEL.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f8310a[Type.PUBLIC_QUERY.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f8310a[Type.COMMAND.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f8310a[Type.SCHEDULER.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
    }
}
