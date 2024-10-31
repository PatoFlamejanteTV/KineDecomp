package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;
import java.util.concurrent.TimeUnit;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class PendingResult<R extends Result> {

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface StatusListener {
        @KeepForSdk
        void a(Status status);
    }

    public abstract R a(long j, TimeUnit timeUnit);

    public abstract void a();

    @KeepForSdk
    public void a(StatusListener statusListener) {
        throw new UnsupportedOperationException();
    }

    public abstract void a(ResultCallback<? super R> resultCallback);
}
