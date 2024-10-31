package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.util.Locale;
import javax.annotation.concurrent.ThreadSafe;

@Beta
@ThreadSafe
@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class RateLimiter {

    /* renamed from: a */
    private volatile Object f16186a;

    private Object c() {
        Object obj = this.f16186a;
        if (obj == null) {
            synchronized (this) {
                obj = this.f16186a;
                if (obj == null) {
                    obj = new Object();
                    this.f16186a = obj;
                }
            }
        }
        return obj;
    }

    abstract double a();

    public final double b() {
        double a2;
        synchronized (c()) {
            a2 = a();
        }
        return a2;
    }

    public String toString() {
        return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", Double.valueOf(b()));
    }
}
