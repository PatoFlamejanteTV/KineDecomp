package com.bumptech.glide.load.c.e;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: TranscoderRegistry.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a */
    private final List<a<?, ?>> f8730a = new ArrayList();

    /* compiled from: TranscoderRegistry.java */
    /* loaded from: classes.dex */
    public static final class a<Z, R> {

        /* renamed from: a */
        private final Class<Z> f8731a;

        /* renamed from: b */
        private final Class<R> f8732b;

        /* renamed from: c */
        final e<Z, R> f8733c;

        a(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
            this.f8731a = cls;
            this.f8732b = cls2;
            this.f8733c = eVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f8731a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f8732b);
        }
    }

    public synchronized <Z, R> void a(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
        this.f8730a.add(new a<>(cls, cls2, eVar));
    }

    public synchronized <Z, R> List<Class<R>> b(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        Iterator<a<?, ?>> it = this.f8730a.iterator();
        while (it.hasNext()) {
            if (it.next().a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> e<Z, R> a(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.a();
        }
        for (a<?, ?> aVar : this.f8730a) {
            if (aVar.a(cls, cls2)) {
                return (e<Z, R>) aVar.f8733c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }
}
