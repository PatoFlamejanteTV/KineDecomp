package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import javax.annotation.concurrent.ThreadSafe;

@Beta
@ThreadSafe
/* loaded from: classes2.dex */
public abstract class RateLimiter {

    /* renamed from: a, reason: collision with root package name */
    double f2968a;

    public String toString() {
        return String.format("RateLimiter[stableRate=%3.1fqps]", Double.valueOf(1000000.0d / this.f2968a));
    }
}
