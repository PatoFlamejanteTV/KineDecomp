package b.a.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: SafeIterableMap.java */
/* loaded from: classes.dex */
public class c<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a */
    private C0007c<K, V> f3224a;

    /* renamed from: b */
    private C0007c<K, V> f3225b;

    /* renamed from: c */
    private WeakHashMap<f<K, V>, Boolean> f3226c = new WeakHashMap<>();

    /* renamed from: d */
    private int f3227d = 0;

    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        a(C0007c<K, V> c0007c, C0007c<K, V> c0007c2) {
            super(c0007c, c0007c2);
        }

        @Override // b.a.a.b.c.e
        C0007c<K, V> b(C0007c<K, V> c0007c) {
            return c0007c.f3231d;
        }

        @Override // b.a.a.b.c.e
        C0007c<K, V> c(C0007c<K, V> c0007c) {
            return c0007c.f3230c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public static class b<K, V> extends e<K, V> {
        b(C0007c<K, V> c0007c, C0007c<K, V> c0007c2) {
            super(c0007c, c0007c2);
        }

        @Override // b.a.a.b.c.e
        C0007c<K, V> b(C0007c<K, V> c0007c) {
            return c0007c.f3230c;
        }

        @Override // b.a.a.b.c.e
        C0007c<K, V> c(C0007c<K, V> c0007c) {
            return c0007c.f3231d;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: b.a.a.b.c$c */
    /* loaded from: classes.dex */
    public static class C0007c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a */
        final K f3228a;

        /* renamed from: b */
        final V f3229b;

        /* renamed from: c */
        C0007c<K, V> f3230c;

        /* renamed from: d */
        C0007c<K, V> f3231d;

        C0007c(K k, V v) {
            this.f3228a = k;
            this.f3229b = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0007c)) {
                return false;
            }
            C0007c c0007c = (C0007c) obj;
            return this.f3228a.equals(c0007c.f3228a) && this.f3229b.equals(c0007c.f3229b);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f3228a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f3229b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f3228a + "=" + this.f3229b;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: a */
        private C0007c<K, V> f3232a;

        /* renamed from: b */
        private boolean f3233b;

        private d() {
            this.f3233b = true;
        }

        @Override // b.a.a.b.c.f
        public void a(C0007c<K, V> c0007c) {
            C0007c<K, V> c0007c2 = this.f3232a;
            if (c0007c == c0007c2) {
                this.f3232a = c0007c2.f3231d;
                this.f3233b = this.f3232a == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f3233b) {
                return c.this.f3224a != null;
            }
            C0007c<K, V> c0007c = this.f3232a;
            return (c0007c == null || c0007c.f3230c == null) ? false : true;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.f3233b) {
                this.f3233b = false;
                this.f3232a = c.this.f3224a;
            } else {
                C0007c<K, V> c0007c = this.f3232a;
                this.f3232a = c0007c != null ? c0007c.f3230c : null;
            }
            return this.f3232a;
        }

        /* synthetic */ d(c cVar, b.a.a.b.b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: a */
        C0007c<K, V> f3235a;

        /* renamed from: b */
        C0007c<K, V> f3236b;

        e(C0007c<K, V> c0007c, C0007c<K, V> c0007c2) {
            this.f3235a = c0007c2;
            this.f3236b = c0007c;
        }

        private C0007c<K, V> b() {
            C0007c<K, V> c0007c = this.f3236b;
            C0007c<K, V> c0007c2 = this.f3235a;
            if (c0007c == c0007c2 || c0007c2 == null) {
                return null;
            }
            return c(c0007c);
        }

        @Override // b.a.a.b.c.f
        public void a(C0007c<K, V> c0007c) {
            if (this.f3235a == c0007c && c0007c == this.f3236b) {
                this.f3236b = null;
                this.f3235a = null;
            }
            C0007c<K, V> c0007c2 = this.f3235a;
            if (c0007c2 == c0007c) {
                this.f3235a = b(c0007c2);
            }
            if (this.f3236b == c0007c) {
                this.f3236b = b();
            }
        }

        abstract C0007c<K, V> b(C0007c<K, V> c0007c);

        abstract C0007c<K, V> c(C0007c<K, V> c0007c);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3236b != null;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            C0007c<K, V> c0007c = this.f3236b;
            this.f3236b = b();
            return c0007c;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* loaded from: classes.dex */
    public interface f<K, V> {
        void a(C0007c<K, V> c0007c);
    }

    public V b(K k, V v) {
        C0007c<K, V> a2 = a((c<K, V>) k);
        if (a2 != null) {
            return a2.f3229b;
        }
        a(k, v);
        return null;
    }

    public c<K, V>.d d() {
        c<K, V>.d dVar = new d();
        this.f3226c.put(dVar, false);
        return dVar;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        b bVar = new b(this.f3225b, this.f3224a);
        this.f3226c.put(bVar, false);
        return bVar;
    }

    public Map.Entry<K, V> e() {
        return this.f3225b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (size() != cVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = cVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f3224a, this.f3225b);
        this.f3226c.put(aVar, false);
        return aVar;
    }

    public V remove(K k) {
        C0007c<K, V> a2 = a((c<K, V>) k);
        if (a2 == null) {
            return null;
        }
        this.f3227d--;
        if (!this.f3226c.isEmpty()) {
            Iterator<f<K, V>> it = this.f3226c.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(a2);
            }
        }
        C0007c<K, V> c0007c = a2.f3231d;
        if (c0007c != null) {
            c0007c.f3230c = a2.f3230c;
        } else {
            this.f3224a = a2.f3230c;
        }
        C0007c<K, V> c0007c2 = a2.f3230c;
        if (c0007c2 != null) {
            c0007c2.f3231d = a2.f3231d;
        } else {
            this.f3225b = a2.f3231d;
        }
        a2.f3230c = null;
        a2.f3231d = null;
        return a2.f3229b;
    }

    public int size() {
        return this.f3227d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    protected C0007c<K, V> a(K k) {
        C0007c<K, V> c0007c = this.f3224a;
        while (c0007c != null && !c0007c.f3228a.equals(k)) {
            c0007c = c0007c.f3230c;
        }
        return c0007c;
    }

    public C0007c<K, V> a(K k, V v) {
        C0007c<K, V> c0007c = new C0007c<>(k, v);
        this.f3227d++;
        C0007c<K, V> c0007c2 = this.f3225b;
        if (c0007c2 == null) {
            this.f3224a = c0007c;
            this.f3225b = this.f3224a;
            return c0007c;
        }
        c0007c2.f3230c = c0007c;
        c0007c.f3231d = c0007c2;
        this.f3225b = c0007c;
        return c0007c;
    }

    public Map.Entry<K, V> a() {
        return this.f3224a;
    }
}
