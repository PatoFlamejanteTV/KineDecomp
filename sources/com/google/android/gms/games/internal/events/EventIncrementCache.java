package com.google.android.gms.games.internal.events;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class EventIncrementCache {

    /* renamed from: a, reason: collision with root package name */
    final Object f1372a;
    private HashMap<String, AtomicInteger> b;

    public void a() {
        synchronized (this.f1372a) {
            for (Map.Entry<String, AtomicInteger> entry : this.b.entrySet()) {
                a(entry.getKey(), entry.getValue().get());
            }
            this.b.clear();
        }
    }

    protected abstract void a(String str, int i);
}
