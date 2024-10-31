package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;

/* loaded from: classes.dex */
public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {

    /* renamed from: a */
    private final Activity f10699a;

    /* renamed from: b */
    private final int f10700b;

    @Override // com.google.android.gms.common.api.ResultCallbacks
    @KeepForSdk
    public final void a(Status status) {
        if (status.P()) {
            try {
                status.a(this.f10699a, this.f10700b);
                return;
            } catch (IntentSender.SendIntentException e2) {
                Log.e("ResolvingResultCallback", "Failed to start resolution", e2);
                b(new Status(8));
                return;
            }
        }
        b(status);
    }

    public abstract void b(Status status);
}
