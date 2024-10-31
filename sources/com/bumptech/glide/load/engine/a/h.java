package com.bumptech.glide.load.engine.a;

import com.bumptech.glide.load.engine.a.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GroupedLinkedMap.java */
/* loaded from: classes.dex */
class h<K extends m, V> {

    /* renamed from: a */
    private final a<K, V> f8800a = new a<>();

    /* renamed from: b */
    private final Map<K, a<K, V>> f8801b = new HashMap();

    /* compiled from: GroupedLinkedMap.java */
    /* loaded from: classes.dex */
    public static class a<K, V> {

        /* renamed from: a */
        final K f8802a;

        /* renamed from: b */
        private List<V> f8803b;

        /* renamed from: c */
        a<K, V> f8804c;

        /* renamed from: d */
        a<K, V> f8805d;

        a() {
            this(null);
        }

        public V a() {
            int b2 = b();
            if (b2 > 0) {
                return this.f8803b.remove(b2 - 1);
            }
            return null;
        }

        public int b() {
            List<V> list = this.f8803b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        a(K k) {
            this.f8805d = this;
            this.f8804c = this;
            this.f8802a = k;
        }

        public void a(V v) {
            if (this.f8803b == null) {
                this.f8803b = new ArrayList();
            }
            this.f8803b.add(v);
        }
    }

    private void b(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.f8800a;
        aVar.f8805d = aVar2.f8805d;
        aVar.f8804c = aVar2;
        d(aVar);
    }

    private static <K, V> void c(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f8805d;
        aVar2.f8804c = aVar.f8804c;
        aVar.f8804c.f8805d = aVar2;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.f8804c.f8805d = aVar;
        aVar.f8805d.f8804c = aVar;
    }

    public void a(K k, V v) {
        a<K, V> aVar = this.f8801b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            b(aVar);
            this.f8801b.put(k, aVar);
        } else {
            k.a();
        }
        aVar.a(v);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.f8800a.f8804c; !aVar.equals(this.f8800a); aVar = aVar.f8804c) {
            z = true;
            sb.append('{');
            sb.append(aVar.f8802a);
            sb.append(':');
            sb.append(aVar.b());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    public V a(K k) {
        a<K, V> aVar = this.f8801b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.f8801b.put(k, aVar);
        } else {
            k.a();
        }
        a(aVar);
        return aVar.a();
    }

    public V a() {
        for (a aVar = this.f8800a.f8805d; !aVar.equals(this.f8800a); aVar = aVar.f8805d) {
            V v = (V) aVar.a();
            if (v != null) {
                return v;
            }
            c(aVar);
            this.f8801b.remove(aVar.f8802a);
            ((m) aVar.f8802a).a();
        }
        return null;
    }

    private void a(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.f8800a;
        aVar.f8805d = aVar2;
        aVar.f8804c = aVar2.f8804c;
        d(aVar);
    }
}
