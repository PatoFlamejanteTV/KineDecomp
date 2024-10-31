package com.google.android.gms.games.internal.events;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class EventIncrementManager {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<EventIncrementCache> f1373a = new AtomicReference<>();

    public void a() {
        EventIncrementCache eventIncrementCache = this.f1373a.get();
        if (eventIncrementCache != null) {
            eventIncrementCache.a();
        }
    }
}
