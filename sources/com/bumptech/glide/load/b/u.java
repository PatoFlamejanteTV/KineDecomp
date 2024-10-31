package com.bumptech.glide.load.b;

import java.util.Collections;
import java.util.List;

/* compiled from: ModelLoader.java */
/* loaded from: classes.dex */
public interface u<Model, Data> {

    /* compiled from: ModelLoader.java */
    /* loaded from: classes.dex */
    public static class a<Data> {

        /* renamed from: a */
        public final com.bumptech.glide.load.c f8646a;

        /* renamed from: b */
        public final List<com.bumptech.glide.load.c> f8647b;

        /* renamed from: c */
        public final com.bumptech.glide.load.a.d<Data> f8648c;

        public a(com.bumptech.glide.load.c cVar, com.bumptech.glide.load.a.d<Data> dVar) {
            this(cVar, Collections.emptyList(), dVar);
        }

        public a(com.bumptech.glide.load.c cVar, List<com.bumptech.glide.load.c> list, com.bumptech.glide.load.a.d<Data> dVar) {
            com.bumptech.glide.g.l.a(cVar);
            this.f8646a = cVar;
            com.bumptech.glide.g.l.a(list);
            this.f8647b = list;
            com.bumptech.glide.g.l.a(dVar);
            this.f8648c = dVar;
        }
    }

    a<Data> a(Model model, int i, int i2, com.bumptech.glide.load.g gVar);

    boolean a(Model model);
}
