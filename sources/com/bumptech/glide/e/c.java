package com.bumptech.glide.e;

import android.support.v4.util.ArrayMap;
import com.bumptech.glide.load.c.e.g;
import com.bumptech.glide.load.engine.B;
import com.bumptech.glide.load.engine.k;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: LoadPathCache.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final B<?, ?, ?> f8472a = new B<>(Object.class, Object.class, Object.class, Collections.singletonList(new k(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), null)), null);

    /* renamed from: b, reason: collision with root package name */
    private final ArrayMap<com.bumptech.glide.g.k, B<?, ?, ?>> f8473b = new ArrayMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final AtomicReference<com.bumptech.glide.g.k> f8474c = new AtomicReference<>();

    private com.bumptech.glide.g.k b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        com.bumptech.glide.g.k andSet = this.f8474c.getAndSet(null);
        if (andSet == null) {
            andSet = new com.bumptech.glide.g.k();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    public boolean a(B<?, ?, ?> b2) {
        return f8472a.equals(b2);
    }

    public <Data, TResource, Transcode> B<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        B<Data, TResource, Transcode> b2;
        com.bumptech.glide.g.k b3 = b(cls, cls2, cls3);
        synchronized (this.f8473b) {
            b2 = (B) this.f8473b.get(b3);
        }
        this.f8474c.set(b3);
        return b2;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, B<?, ?, ?> b2) {
        synchronized (this.f8473b) {
            ArrayMap<com.bumptech.glide.g.k, B<?, ?, ?>> arrayMap = this.f8473b;
            com.bumptech.glide.g.k kVar = new com.bumptech.glide.g.k(cls, cls2, cls3);
            if (b2 == null) {
                b2 = f8472a;
            }
            arrayMap.put(kVar, b2);
        }
    }
}
