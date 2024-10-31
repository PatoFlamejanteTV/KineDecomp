package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@GwtCompatible
/* loaded from: classes2.dex */
public final class AtomicLongMap<K> {

    /* renamed from: a */
    private final ConcurrentHashMap<K, AtomicLong> f16163a;

    public String toString() {
        return this.f16163a.toString();
    }
}
