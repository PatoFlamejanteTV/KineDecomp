package com.google.api.client.testing.util;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Sleeper;

@Beta
/* loaded from: classes2.dex */
public class MockSleeper implements Sleeper {

    /* renamed from: a */
    private int f14889a;

    /* renamed from: b */
    private long f14890b;

    @Override // com.google.api.client.util.Sleeper
    public void a(long j) throws InterruptedException {
        this.f14889a++;
        this.f14890b = j;
    }
}
