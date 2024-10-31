package android.support.v4.f;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MapCollections.java */
/* loaded from: classes.dex */
public abstract class h<K, V> {
    h<K, V>.b b;
    h<K, V>.c c;
    h<K, V>.e d;

    protected abstract int a();

    protected abstract int a(Object obj);

    protected abstract Object a(int i, int i2);

    protected abstract V a(int i, V v);

    protected abstract void a(int i);

    protected abstract void a(K k, V v);

    protected abstract int b(Object obj);

    protected abstract Map<K, V> b();

    protected abstract void c();

    /* compiled from: MapCollections.java */
    /* loaded from: classes.dex */
    final class a<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        final int f81a;
        int b;
        int c;
        boolean d = false;

        a(int i) {
            this.f81a = i;
            this.b = h.this.a();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c < this.b;
        }

        @Override // java.util.Iterator
        public T next() {
            T t = (T) h.this.a(this.c, this.f81a);
            this.c++;
            this.d = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.d) {
                throw new IllegalStateException();
            }
            this.c--;
            this.b--;
            this.d = false;
            h.this.a(this.c);
        }
    }

    /* compiled from: MapCollections.java */
    /* loaded from: classes.dex */
    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        int f84a;
        boolean c = false;
        int b = -1;

        d() {
            this.f84a = h.this.a() - 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b < this.f84a;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            this.b++;
            this.c = true;
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.c) {
                throw new IllegalStateException();
            }
            h.this.a(this.b);
            this.b--;
            this.f84a--;
            this.c = false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (K) h.this.a(this.b, 0);
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V) h.this.a(this.b, 1);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V) h.this.a(this.b, (int) v);
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return android.support.v4.f.c.a(entry.getKey(), h.this.a(this.b, 0)) && android.support.v4.f.c.a(entry.getValue(), h.this.a(this.b, 1));
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object a2 = h.this.a(this.b, 0);
            Object a3 = h.this.a(this.b, 1);
            return (a3 != null ? a3.hashCode() : 0) ^ (a2 == null ? 0 : a2.hashCode());
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* compiled from: MapCollections.java */
    /* loaded from: classes.dex */
    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        @Override // java.util.Set, java.util.Collection
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int a2 = h.this.a();
            for (Map.Entry<K, V> entry : collection) {
                h.this.a((h) entry.getKey(), (K) entry.getValue());
            }
            return a2 != h.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            h.this.c();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int a2 = h.this.a(entry.getKey());
            if (a2 >= 0) {
                return android.support.v4.f.c.a(h.this.a(a2, 1), entry.getValue());
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return h.this.a() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return h.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return h.a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int a2 = h.this.a() - 1;
            int i = 0;
            while (a2 >= 0) {
                Object a3 = h.this.a(a2, 0);
                Object a4 = h.this.a(a2, 1);
                a2--;
                i += (a4 == null ? 0 : a4.hashCode()) ^ (a3 == null ? 0 : a3.hashCode());
            }
            return i;
        }
    }

    /* compiled from: MapCollections.java */
    /* loaded from: classes.dex */
    final class c implements Set<K> {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            h.this.c();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return h.this.a(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return h.a((Map) h.this.b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return h.this.a() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int a2 = h.this.a(obj);
            if (a2 < 0) {
                return false;
            }
            h.this.a(a2);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return h.b(h.this.b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return h.c(h.this.b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return h.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return h.this.b(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) h.this.a(tArr, 0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return h.a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i = 0;
            for (int a2 = h.this.a() - 1; a2 >= 0; a2--) {
                Object a3 = h.this.a(a2, 0);
                i += a3 == null ? 0 : a3.hashCode();
            }
            return i;
        }
    }

    /* compiled from: MapCollections.java */
    /* loaded from: classes.dex */
    final class e implements Collection<V> {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            h.this.c();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return h.this.b(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return h.this.a() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int b = h.this.b(obj);
            if (b < 0) {
                return false;
            }
            h.this.a(b);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int i = 0;
            int a2 = h.this.a();
            boolean z = false;
            while (i < a2) {
                if (collection.contains(h.this.a(i, 1))) {
                    h.this.a(i);
                    i--;
                    a2--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int i = 0;
            int a2 = h.this.a();
            boolean z = false;
            while (i < a2) {
                if (!collection.contains(h.this.a(i, 1))) {
                    h.this.a(i);
                    i--;
                    a2--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return h.this.a();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return h.this.b(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) h.this.a(tArr, 1);
        }
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public Object[] b(int i) {
        int a2 = a();
        Object[] objArr = new Object[a2];
        for (int i2 = 0; i2 < a2; i2++) {
            objArr[i2] = a(i2, i);
        }
        return objArr;
    }

    public <T> T[] a(T[] tArr, int i) {
        int a2 = a();
        Object[] objArr = tArr.length < a2 ? (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), a2)) : tArr;
        for (int i2 = 0; i2 < a2; i2++) {
            objArr[i2] = a(i2, i);
        }
        if (objArr.length > a2) {
            objArr[a2] = null;
        }
        return (T[]) objArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001a, code lost:            if (r4.containsAll(r5) != false) goto L13;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> boolean a(java.util.Set<T> r4, java.lang.Object r5) {
        /*
            r0 = 1
            r1 = 0
            if (r4 != r5) goto L6
            r1 = r0
        L5:
            return r1
        L6:
            boolean r2 = r5 instanceof java.util.Set
            if (r2 == 0) goto L5
            java.util.Set r5 = (java.util.Set) r5
            int r2 = r4.size()     // Catch: java.lang.ClassCastException -> L20 java.lang.NullPointerException -> L22
            int r3 = r5.size()     // Catch: java.lang.ClassCastException -> L20 java.lang.NullPointerException -> L22
            if (r2 != r3) goto L1e
            boolean r2 = r4.containsAll(r5)     // Catch: java.lang.ClassCastException -> L20 java.lang.NullPointerException -> L22
            if (r2 == 0) goto L1e
        L1c:
            r1 = r0
            goto L5
        L1e:
            r0 = r1
            goto L1c
        L20:
            r0 = move-exception
            goto L5
        L22:
            r0 = move-exception
            goto L5
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.f.h.a(java.util.Set, java.lang.Object):boolean");
    }

    public Set<Map.Entry<K, V>> d() {
        if (this.b == null) {
            this.b = new b();
        }
        return this.b;
    }

    public Set<K> e() {
        if (this.c == null) {
            this.c = new c();
        }
        return this.c;
    }

    public Collection<V> f() {
        if (this.d == null) {
            this.d = new e();
        }
        return this.d;
    }
}
