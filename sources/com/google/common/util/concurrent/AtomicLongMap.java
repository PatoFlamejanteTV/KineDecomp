package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class AtomicLongMap<K> {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<K, AtomicLong> f2960a;

    public String toString() {
        return this.f2960a.toString();
    }
}
