package com.bumptech.glide.load.a;

import com.bumptech.glide.load.a.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: DataRewinderRegistry.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a */
    private static final e.a<?> f8553a = new f();

    /* renamed from: b */
    private final Map<Class<?>, e.a<?>> f8554b = new HashMap();

    /* compiled from: DataRewinderRegistry.java */
    /* loaded from: classes.dex */
    public static final class a implements e<Object> {

        /* renamed from: a */
        private final Object f8555a;

        public a(Object obj) {
            this.f8555a = obj;
        }

        @Override // com.bumptech.glide.load.a.e
        public Object a() {
            return this.f8555a;
        }

        @Override // com.bumptech.glide.load.a.e
        public void b() {
        }
    }

    public synchronized void a(e.a<?> aVar) {
        this.f8554b.put(aVar.a(), aVar);
    }

    public synchronized <T> e<T> a(T t) {
        e.a<?> aVar;
        com.bumptech.glide.g.l.a(t);
        aVar = this.f8554b.get(t.getClass());
        if (aVar == null) {
            Iterator<e.a<?>> it = this.f8554b.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e.a<?> next = it.next();
                if (next.a().isAssignableFrom(t.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f8553a;
        }
        return (e<T>) aVar.a(t);
    }
}
