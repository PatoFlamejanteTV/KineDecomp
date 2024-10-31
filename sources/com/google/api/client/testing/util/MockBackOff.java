package com.google.api.client.testing.util;

import com.google.api.client.util.BackOff;
import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
/* loaded from: classes.dex */
public class MockBackOff implements BackOff {
    private long c;
    private int d = 10;
    private int e;

    @Override // com.google.api.client.util.BackOff
    public void a() throws IOException {
        this.e = 0;
    }

    @Override // com.google.api.client.util.BackOff
    public long b() throws IOException {
        if (this.e >= this.d || this.c == -1) {
            return -1L;
        }
        this.e++;
        return this.c;
    }
}
