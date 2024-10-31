package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class PendingResult<R extends Result> {

    /* loaded from: classes.dex */
    public interface zza {
        void a(Status status);
    }

    public abstract R await();

    public abstract R await(long j, TimeUnit timeUnit);

    public abstract void cancel();

    public abstract boolean isCanceled();

    public abstract void setResultCallback(ResultCallback<? super R> resultCallback);

    public abstract void setResultCallback(ResultCallback<? super R> resultCallback, long j, TimeUnit timeUnit);

    public void zza(zza zzaVar) {
        throw new UnsupportedOperationException();
    }

    public Integer zznF() {
        throw new UnsupportedOperationException();
    }
}
