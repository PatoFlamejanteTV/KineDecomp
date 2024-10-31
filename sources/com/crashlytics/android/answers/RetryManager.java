package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.a.e;

/* loaded from: classes.dex */
class RetryManager {
    private static final long NANOSECONDS_IN_MS = 1000000;
    long lastRetry;
    private e retryState;

    public RetryManager(e eVar) {
        if (eVar != null) {
            this.retryState = eVar;
            return;
        }
        throw new NullPointerException("retryState must not be null");
    }

    public boolean canRetry(long j) {
        return j - this.lastRetry >= this.retryState.a() * NANOSECONDS_IN_MS;
    }

    public void recordRetry(long j) {
        this.lastRetry = j;
        this.retryState = this.retryState.c();
    }

    public void reset() {
        this.lastRetry = 0L;
        this.retryState = this.retryState.b();
    }
}
