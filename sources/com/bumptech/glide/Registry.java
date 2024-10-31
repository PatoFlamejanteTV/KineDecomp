package com.bumptech.glide;

import android.support.v4.util.Pools;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a.e;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.b.w;
import com.bumptech.glide.load.engine.B;
import com.bumptech.glide.load.engine.E;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class Registry {

    /* renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.e.d f8345h = new com.bumptech.glide.e.d();
    private final com.bumptech.glide.e.c i = new com.bumptech.glide.e.c();
    private final Pools.Pool<List<Throwable>> j = com.bumptech.glide.g.a.d.a();

    /* renamed from: a, reason: collision with root package name */
    private final w f8338a = new w(this.j);

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.e.a f8339b = new com.bumptech.glide.e.a();

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.e.e f8340c = new com.bumptech.glide.e.e();

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.e.f f8341d = new com.bumptech.glide.e.f();

    /* renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.a.g f8342e = new com.bumptech.glide.load.a.g();

    /* renamed from: f, reason: collision with root package name */
    private final com.bumptech.glide.load.c.e.f f8343f = new com.bumptech.glide.load.c.e.f();

    /* renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.e.b f8344g = new com.bumptech.glide.e.b();

    /* loaded from: classes.dex */
    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    /* loaded from: classes.dex */
    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Object obj) {
            super("Failed to find any ModelLoaders for model: " + obj);
        }

        public NoModelLoaderAvailableException(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* loaded from: classes.dex */
    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* loaded from: classes.dex */
    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        a(Arrays.asList("Gif", "Bitmap", "BitmapDrawable"));
    }

    private <Data, TResource, Transcode> List<com.bumptech.glide.load.engine.k<Data, TResource, Transcode>> c(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f8340c.b(cls, cls2)) {
            for (Class cls5 : this.f8343f.b(cls4, cls3)) {
                arrayList.add(new com.bumptech.glide.load.engine.k(cls, cls4, cls5, this.f8340c.a(cls, cls4), this.f8343f.a(cls4, cls5), this.j));
            }
        }
        return arrayList;
    }

    public <Data> Registry a(Class<Data> cls, com.bumptech.glide.load.a<Data> aVar) {
        this.f8339b.a(cls, aVar);
        return this;
    }

    public <Model, TResource, Transcode> List<Class<?>> b(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> a2 = this.f8345h.a(cls, cls2, cls3);
        if (a2 == null) {
            a2 = new ArrayList<>();
            Iterator<Class<?>> it = this.f8338a.a((Class<?>) cls).iterator();
            while (it.hasNext()) {
                for (Class<?> cls4 : this.f8340c.b(it.next(), cls2)) {
                    if (!this.f8343f.b(cls4, cls3).isEmpty() && !a2.contains(cls4)) {
                        a2.add(cls4);
                    }
                }
            }
            this.f8345h.a(cls, cls2, cls3, Collections.unmodifiableList(a2));
        }
        return a2;
    }

    public <Data, TResource> Registry a(Class<Data> cls, Class<TResource> cls2, com.bumptech.glide.load.h<Data, TResource> hVar) {
        a("legacy_append", cls, cls2, hVar);
        return this;
    }

    public <Data, TResource> Registry a(String str, Class<Data> cls, Class<TResource> cls2, com.bumptech.glide.load.h<Data, TResource> hVar) {
        this.f8340c.a(str, hVar, cls, cls2);
        return this;
    }

    public final Registry a(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f8340c.a(arrayList);
        return this;
    }

    public <TResource> Registry a(Class<TResource> cls, com.bumptech.glide.load.i<TResource> iVar) {
        this.f8341d.a(cls, iVar);
        return this;
    }

    public Registry a(e.a<?> aVar) {
        this.f8342e.a(aVar);
        return this;
    }

    public <TResource, Transcode> Registry a(Class<TResource> cls, Class<Transcode> cls2, com.bumptech.glide.load.c.e.e<TResource, Transcode> eVar) {
        this.f8343f.a(cls, cls2, eVar);
        return this;
    }

    public Registry a(ImageHeaderParser imageHeaderParser) {
        this.f8344g.a(imageHeaderParser);
        return this;
    }

    public <Model, Data> Registry a(Class<Model> cls, Class<Data> cls2, v<Model, Data> vVar) {
        this.f8338a.a(cls, cls2, vVar);
        return this;
    }

    public <Data, TResource, Transcode> B<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        B<Data, TResource, Transcode> a2 = this.i.a(cls, cls2, cls3);
        if (this.i.a(a2)) {
            return null;
        }
        if (a2 == null) {
            List<com.bumptech.glide.load.engine.k<Data, TResource, Transcode>> c2 = c(cls, cls2, cls3);
            a2 = c2.isEmpty() ? null : new B<>(cls, cls2, cls3, c2, this.j);
            this.i.a(cls, cls2, cls3, a2);
        }
        return a2;
    }

    public <X> com.bumptech.glide.load.a<X> c(X x) throws NoSourceEncoderAvailableException {
        com.bumptech.glide.load.a<X> a2 = this.f8339b.a(x.getClass());
        if (a2 != null) {
            return a2;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    public boolean b(E<?> e2) {
        return this.f8341d.a(e2.c()) != null;
    }

    public <X> com.bumptech.glide.load.a.e<X> b(X x) {
        return this.f8342e.a((com.bumptech.glide.load.a.g) x);
    }

    public <X> com.bumptech.glide.load.i<X> a(E<X> e2) throws NoResultEncoderAvailableException {
        com.bumptech.glide.load.i<X> a2 = this.f8341d.a(e2.c());
        if (a2 != null) {
            return a2;
        }
        throw new NoResultEncoderAvailableException(e2.c());
    }

    public <Model> List<u<Model, ?>> a(Model model) {
        List<u<Model, ?>> a2 = this.f8338a.a((w) model);
        if (a2.isEmpty()) {
            throw new NoModelLoaderAvailableException(model);
        }
        return a2;
    }

    public List<ImageHeaderParser> a() {
        List<ImageHeaderParser> a2 = this.f8344g.a();
        if (a2.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return a2;
    }
}
