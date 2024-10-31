package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.s;
import java.util.List;
import java.util.Map;

/* compiled from: GlideContext.java */
/* loaded from: classes.dex */
public class e extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    static final k<?, ?> f8460a = new b();

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.b f8461b;

    /* renamed from: c, reason: collision with root package name */
    private final Registry f8462c;

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.request.a.f f8463d;

    /* renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.request.f f8464e;

    /* renamed from: f, reason: collision with root package name */
    private final List<com.bumptech.glide.request.e<Object>> f8465f;

    /* renamed from: g, reason: collision with root package name */
    private final Map<Class<?>, k<?, ?>> f8466g;

    /* renamed from: h, reason: collision with root package name */
    private final s f8467h;
    private final boolean i;
    private final int j;

    public e(Context context, com.bumptech.glide.load.engine.a.b bVar, Registry registry, com.bumptech.glide.request.a.f fVar, com.bumptech.glide.request.f fVar2, Map<Class<?>, k<?, ?>> map, List<com.bumptech.glide.request.e<Object>> list, s sVar, boolean z, int i) {
        super(context.getApplicationContext());
        this.f8461b = bVar;
        this.f8462c = registry;
        this.f8463d = fVar;
        this.f8464e = fVar2;
        this.f8465f = list;
        this.f8466g = map;
        this.f8467h = sVar;
        this.i = z;
        this.j = i;
    }

    public <T> k<?, T> a(Class<T> cls) {
        k<?, T> kVar = (k) this.f8466g.get(cls);
        if (kVar == null) {
            for (Map.Entry<Class<?>, k<?, ?>> entry : this.f8466g.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    kVar = (k) entry.getValue();
                }
            }
        }
        return kVar == null ? (k<?, T>) f8460a : kVar;
    }

    public List<com.bumptech.glide.request.e<Object>> b() {
        return this.f8465f;
    }

    public com.bumptech.glide.request.f c() {
        return this.f8464e;
    }

    public s d() {
        return this.f8467h;
    }

    public int e() {
        return this.j;
    }

    public Registry f() {
        return this.f8462c;
    }

    public boolean g() {
        return this.i;
    }

    public <X> com.bumptech.glide.request.a.j<ImageView, X> a(ImageView imageView, Class<X> cls) {
        return this.f8463d.a(imageView, cls);
    }

    public com.bumptech.glide.load.engine.a.b a() {
        return this.f8461b;
    }
}
