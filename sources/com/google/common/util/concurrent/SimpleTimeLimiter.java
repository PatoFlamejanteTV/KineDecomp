package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class SimpleTimeLimiter implements TimeLimiter {

    /* renamed from: a */
    private final ExecutorService f16192a;

    public SimpleTimeLimiter(ExecutorService executorService) {
        Preconditions.a(executorService);
        this.f16192a = executorService;
    }

    public SimpleTimeLimiter() {
        this(Executors.newCachedThreadPool());
    }
}
