package com.google.api.client.util;

/* compiled from: Clock.java */
/* loaded from: classes.dex */
final class e implements Clock {
    @Override // com.google.api.client.util.Clock
    public long a() {
        return System.currentTimeMillis();
    }
}