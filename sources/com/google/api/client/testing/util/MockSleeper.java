package com.google.api.client.testing.util;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Sleeper;

@Beta
/* loaded from: classes.dex */
public class MockSleeper implements Sleeper {
    private int b;
    private long c;

    @Override // com.google.api.client.util.Sleeper
    public void a(long j) throws InterruptedException {
        this.b++;
        this.c = j;
    }
}
