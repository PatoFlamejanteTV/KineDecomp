package com.google.api.client.testing.http;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import java.util.concurrent.atomic.AtomicLong;

@Beta
/* loaded from: classes2.dex */
public class FixedClock implements Clock {

    /* renamed from: a */
    private AtomicLong f14847a;

    public FixedClock() {
        this(0L);
    }

    @Override // com.google.api.client.util.Clock
    public long a() {
        return this.f14847a.get();
    }

    public FixedClock(long j) {
        this.f14847a = new AtomicLong(j);
    }
}
