package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

/* loaded from: classes.dex */
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    public abstract void a(R r);

    public abstract void a(Status status);
}
