package com.google.firebase.components;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-common@@16.0.4 */
/* loaded from: classes2.dex */
class g implements Subscriber, Publisher {

    /* renamed from: a */
    private final Map<Class<?>, ConcurrentHashMap<EventHandler<Object>, Executor>> f16587a = new HashMap();

    /* renamed from: b */
    private Queue<Event<?>> f16588b = new ArrayDeque();

    /* renamed from: c */
    private final Executor f16589c;

    public g(Executor executor) {
        this.f16589c = executor;
    }

    private synchronized Set<Map.Entry<EventHandler<Object>, Executor>> b(Event<?> event) {
        ConcurrentHashMap<EventHandler<Object>, Executor> concurrentHashMap;
        concurrentHashMap = this.f16587a.get(event.b());
        return concurrentHashMap == null ? Collections.emptySet() : concurrentHashMap.entrySet();
    }

    public void a(Event<?> event) {
        Preconditions.a(event);
        synchronized (this) {
            if (this.f16588b != null) {
                this.f16588b.add(event);
                return;
            }
            for (Map.Entry<EventHandler<Object>, Executor> entry : b(event)) {
                entry.getValue().execute(f.a(entry, event));
            }
        }
    }

    @Override // com.google.firebase.events.Subscriber
    public synchronized <T> void b(Class<T> cls, EventHandler<? super T> eventHandler) {
        Preconditions.a(cls);
        Preconditions.a(eventHandler);
        if (this.f16587a.containsKey(cls)) {
            ConcurrentHashMap<EventHandler<Object>, Executor> concurrentHashMap = this.f16587a.get(cls);
            concurrentHashMap.remove(eventHandler);
            if (concurrentHashMap.isEmpty()) {
                this.f16587a.remove(cls);
            }
        }
    }

    @Override // com.google.firebase.events.Subscriber
    public synchronized <T> void a(Class<T> cls, Executor executor, EventHandler<? super T> eventHandler) {
        Preconditions.a(cls);
        Preconditions.a(eventHandler);
        Preconditions.a(executor);
        if (!this.f16587a.containsKey(cls)) {
            this.f16587a.put(cls, new ConcurrentHashMap<>());
        }
        this.f16587a.get(cls).put(eventHandler, executor);
    }

    @Override // com.google.firebase.events.Subscriber
    public <T> void a(Class<T> cls, EventHandler<? super T> eventHandler) {
        a(cls, this.f16589c, eventHandler);
    }

    public void a() {
        Queue<Event<?>> queue;
        synchronized (this) {
            if (this.f16588b != null) {
                queue = this.f16588b;
                this.f16588b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            Iterator<Event<?>> it = queue.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        }
    }
}
