package org.keyczar.util;

/* loaded from: classes3.dex */
public class SystemClock implements Clock {
    @Override // org.keyczar.util.Clock
    public long now() {
        return System.currentTimeMillis();
    }
}
