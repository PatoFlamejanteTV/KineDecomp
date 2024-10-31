package com.fasterxml.jackson.core.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ThreadLocalBufferManager.java */
/* loaded from: classes.dex */
class f {

    /* renamed from: a */
    private final Object f9819a = new Object();

    /* renamed from: b */
    private final Map<SoftReference<com.fasterxml.jackson.core.util.a>, Boolean> f9820b = new ConcurrentHashMap();

    /* renamed from: c */
    private final ReferenceQueue<com.fasterxml.jackson.core.util.a> f9821c = new ReferenceQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ThreadLocalBufferManager.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        static final f f9822a = new f();
    }

    f() {
    }

    public static f a() {
        return a.f9822a;
    }

    private void b() {
        while (true) {
            SoftReference softReference = (SoftReference) this.f9821c.poll();
            if (softReference == null) {
                return;
            } else {
                this.f9820b.remove(softReference);
            }
        }
    }

    public SoftReference<com.fasterxml.jackson.core.util.a> a(com.fasterxml.jackson.core.util.a aVar) {
        SoftReference<com.fasterxml.jackson.core.util.a> softReference = new SoftReference<>(aVar, this.f9821c);
        this.f9820b.put(softReference, true);
        b();
        return softReference;
    }
}
