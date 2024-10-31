package com.google.api.client.util;

/* compiled from: NanoClock.java */
/* loaded from: classes.dex */
final class g implements NanoClock {
    @Override // com.google.api.client.util.NanoClock
    public long a() {
        return System.nanoTime();
    }
}
