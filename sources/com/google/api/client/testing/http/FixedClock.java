package com.google.api.client.testing.http;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import java.util.concurrent.atomic.AtomicLong;

@Beta
/* loaded from: classes.dex */
public class FixedClock implements Clock {
    private AtomicLong b;

    public FixedClock() {
        this(0L);
    }

    public FixedClock(long j) {
        this.b = new AtomicLong(j);
    }

    @Override // com.google.api.client.util.Clock
    public long a() {
        return this.b.get();
    }
}
