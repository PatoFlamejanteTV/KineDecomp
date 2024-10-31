package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

/* loaded from: classes.dex */
public abstract class zzb<R extends Result, S extends Result> {
    public abstract PendingResult<S> a(R r);

    public Status a(Status status) {
        return status;
    }
}
