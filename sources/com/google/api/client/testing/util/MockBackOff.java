package com.google.api.client.testing.util;

import com.google.api.client.util.BackOff;
import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
/* loaded from: classes2.dex */
public class MockBackOff implements BackOff {

    /* renamed from: a */
    private long f14886a;

    /* renamed from: b */
    private int f14887b = 10;

    /* renamed from: c */
    private int f14888c;

    @Override // com.google.api.client.util.BackOff
    public long a() throws IOException {
        int i = this.f14888c;
        if (i < this.f14887b) {
            long j = this.f14886a;
            if (j != -1) {
                this.f14888c = i + 1;
                return j;
            }
        }
        return -1L;
    }

    @Override // com.google.api.client.util.BackOff
    public void reset() throws IOException {
        this.f14888c = 0;
    }
}
