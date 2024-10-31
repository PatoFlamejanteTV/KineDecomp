package com.bumptech.glide.load.engine;

import android.support.v4.util.Pools;
import com.bumptech.glide.load.engine.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: LoadPath.java */
/* loaded from: classes.dex */
public class B<Data, ResourceType, Transcode> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<Data> f8738a;

    /* renamed from: b, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f8739b;

    /* renamed from: c, reason: collision with root package name */
    private final List<? extends k<Data, ResourceType, Transcode>> f8740c;

    /* renamed from: d, reason: collision with root package name */
    private final String f8741d;

    public B(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<k<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.f8738a = cls;
        this.f8739b = pool;
        com.bumptech.glide.g.l.a(list);
        this.f8740c = list;
        this.f8741d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public E<Transcode> a(com.bumptech.glide.load.a.e<Data> eVar, com.bumptech.glide.load.g gVar, int i, int i2, k.a<ResourceType> aVar) throws GlideException {
        List<Throwable> acquire = this.f8739b.acquire();
        com.bumptech.glide.g.l.a(acquire);
        List<Throwable> list = acquire;
        try {
            return a(eVar, gVar, i, i2, aVar, list);
        } finally {
            this.f8739b.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f8740c.toArray()) + '}';
    }

    private E<Transcode> a(com.bumptech.glide.load.a.e<Data> eVar, com.bumptech.glide.load.g gVar, int i, int i2, k.a<ResourceType> aVar, List<Throwable> list) throws GlideException {
        int size = this.f8740c.size();
        E<Transcode> e2 = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                e2 = this.f8740c.get(i3).a(eVar, i, i2, gVar, aVar);
            } catch (GlideException e3) {
                list.add(e3);
            }
            if (e2 != null) {
                break;
            }
        }
        if (e2 != null) {
            return e2;
        }
        throw new GlideException(this.f8741d, new ArrayList(list));
    }
}
