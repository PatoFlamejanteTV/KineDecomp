package com.bumptech.glide.e;

import android.support.v4.util.ArrayMap;
import com.bumptech.glide.g.k;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ModelToResourceClassCache.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    private final AtomicReference<k> f8475a = new AtomicReference<>();

    /* renamed from: b */
    private final ArrayMap<k, List<Class<?>>> f8476b = new ArrayMap<>();

    public List<Class<?>> a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        List<Class<?>> list;
        k andSet = this.f8475a.getAndSet(null);
        if (andSet == null) {
            andSet = new k(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
        }
        synchronized (this.f8476b) {
            list = this.f8476b.get(andSet);
        }
        this.f8475a.set(andSet);
        return list;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, List<Class<?>> list) {
        synchronized (this.f8476b) {
            this.f8476b.put(new k(cls, cls2, cls3), list);
        }
    }
}
