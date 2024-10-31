package com.bumptech.glide.load.engine;

import android.support.v4.util.Pools;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DecodePath.java */
/* loaded from: classes.dex */
public class k<DataType, ResourceType, Transcode> {

    /* renamed from: a */
    private final Class<DataType> f8920a;

    /* renamed from: b */
    private final List<? extends com.bumptech.glide.load.h<DataType, ResourceType>> f8921b;

    /* renamed from: c */
    private final com.bumptech.glide.load.c.e.e<ResourceType, Transcode> f8922c;

    /* renamed from: d */
    private final Pools.Pool<List<Throwable>> f8923d;

    /* renamed from: e */
    private final String f8924e;

    /* compiled from: DecodePath.java */
    /* loaded from: classes.dex */
    public interface a<ResourceType> {
        E<ResourceType> a(E<ResourceType> e2);
    }

    public k(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends com.bumptech.glide.load.h<DataType, ResourceType>> list, com.bumptech.glide.load.c.e.e<ResourceType, Transcode> eVar, Pools.Pool<List<Throwable>> pool) {
        this.f8920a = cls;
        this.f8921b = list;
        this.f8922c = eVar;
        this.f8923d = pool;
        this.f8924e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public E<Transcode> a(com.bumptech.glide.load.a.e<DataType> eVar, int i, int i2, com.bumptech.glide.load.g gVar, a<ResourceType> aVar) throws GlideException {
        return this.f8922c.a(aVar.a(a(eVar, i, i2, gVar)), gVar);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f8920a + ", decoders=" + this.f8921b + ", transcoder=" + this.f8922c + '}';
    }

    private E<ResourceType> a(com.bumptech.glide.load.a.e<DataType> eVar, int i, int i2, com.bumptech.glide.load.g gVar) throws GlideException {
        List<Throwable> acquire = this.f8923d.acquire();
        com.bumptech.glide.g.l.a(acquire);
        List<Throwable> list = acquire;
        try {
            return a(eVar, i, i2, gVar, list);
        } finally {
            this.f8923d.release(list);
        }
    }

    private E<ResourceType> a(com.bumptech.glide.load.a.e<DataType> eVar, int i, int i2, com.bumptech.glide.load.g gVar, List<Throwable> list) throws GlideException {
        int size = this.f8921b.size();
        E<ResourceType> e2 = null;
        for (int i3 = 0; i3 < size; i3++) {
            com.bumptech.glide.load.h<DataType, ResourceType> hVar = this.f8921b.get(i3);
            try {
                if (hVar.a(eVar.a(), gVar)) {
                    e2 = hVar.a(eVar.a(), i, i2, gVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e3) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + hVar, e3);
                }
                list.add(e3);
            }
            if (e2 != null) {
                break;
            }
        }
        if (e2 != null) {
            return e2;
        }
        throw new GlideException(this.f8924e, new ArrayList(list));
    }
}
