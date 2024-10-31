package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import java.util.concurrent.TimeUnit;

@KeepForSdk
/* loaded from: classes.dex */
public final class OptionalPendingResultImpl<R extends Result> extends OptionalPendingResult<R> {

    /* renamed from: a */
    private final BasePendingResult<R> f10786a;

    @Override // com.google.android.gms.common.api.PendingResult
    public final R a(long j, TimeUnit timeUnit) {
        return this.f10786a.a(j, timeUnit);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void a() {
        this.f10786a.a();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void a(ResultCallback<? super R> resultCallback) {
        this.f10786a.a(resultCallback);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void a(PendingResult.StatusListener statusListener) {
        this.f10786a.a(statusListener);
    }
}
