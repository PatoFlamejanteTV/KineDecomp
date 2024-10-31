package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Beta
/* loaded from: classes2.dex */
public final class SimpleTimeLimiter implements TimeLimiter {

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f2969a;

    public SimpleTimeLimiter(ExecutorService executorService) {
        this.f2969a = (ExecutorService) Preconditions.a(executorService);
    }

    public SimpleTimeLimiter() {
        this(Executors.newCachedThreadPool());
    }
}
