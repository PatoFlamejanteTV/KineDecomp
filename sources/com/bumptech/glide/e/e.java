package com.bumptech.glide.e;

import com.bumptech.glide.load.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: ResourceDecoderRegistry.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a */
    private final List<String> f8477a = new ArrayList();

    /* renamed from: b */
    private final Map<String, List<a<?, ?>>> f8478b = new HashMap();

    /* compiled from: ResourceDecoderRegistry.java */
    /* loaded from: classes.dex */
    public static class a<T, R> {

        /* renamed from: a */
        private final Class<T> f8479a;

        /* renamed from: b */
        final Class<R> f8480b;

        /* renamed from: c */
        final h<T, R> f8481c;

        public a(Class<T> cls, Class<R> cls2, h<T, R> hVar) {
            this.f8479a = cls;
            this.f8480b = cls2;
            this.f8481c = hVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f8479a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f8480b);
        }
    }

    public synchronized void a(List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.f8477a);
        this.f8477a.clear();
        this.f8477a.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f8477a.add(str);
            }
        }
    }

    public synchronized <T, R> List<Class<R>> b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f8477a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f8478b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f8480b)) {
                        arrayList.add(aVar.f8480b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> List<h<T, R>> a(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f8477a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f8478b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f8481c);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void a(String str, h<T, R> hVar, Class<T> cls, Class<R> cls2) {
        a(str).add(new a<>(cls, cls2, hVar));
    }

    private synchronized List<a<?, ?>> a(String str) {
        List<a<?, ?>> list;
        if (!this.f8477a.contains(str)) {
            this.f8477a.add(str);
        }
        list = this.f8478b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f8478b.put(str, list);
        }
        return list;
    }
}
