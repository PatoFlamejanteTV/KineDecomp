package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.AsyncTask;

/* compiled from: AsyncTask.java */
/* loaded from: classes3.dex */
public /* synthetic */ class d {

    /* renamed from: a */
    static final /* synthetic */ int[] f26952a = new int[AsyncTask.Status.values().length];

    static {
        try {
            f26952a[AsyncTask.Status.RUNNING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f26952a[AsyncTask.Status.FINISHED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
