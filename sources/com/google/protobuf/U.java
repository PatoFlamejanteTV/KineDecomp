package com.google.protobuf;

import com.google.protobuf.FieldSet;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: SmallSortedMap.java */
/* loaded from: classes2.dex */
public class U<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a */
    private final int f18702a;

    /* renamed from: b */
    private List<U<K, V>.b> f18703b;

    /* renamed from: c */
    private Map<K, V> f18704c;

    /* renamed from: d */
    private boolean f18705d;

    /* renamed from: e */
    private volatile U<K, V>.d f18706e;

    /* compiled from: SmallSortedMap.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a */
        private static final Iterator<Object> f18707a = new S();

        /* renamed from: b */
        private static final Iterable<Object> f18708b = new T();

        static <T> Iterable<T> b() {
            return (Iterable<T>) f18708b;
        }
    }

    /* compiled from: SmallSortedMap.java */
    /* loaded from: classes2.dex */
    public class b implements Map.Entry<K, V>, Comparable<U<K, V>.b> {

        /* renamed from: a */
        private final K f18709a;

        /* renamed from: b */
        private V f18710b;

        b(U u, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(U<K, V>.b bVar) {
            return getKey().compareTo(bVar.getKey());
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a(this.f18709a, entry.getKey()) && a(this.f18710b, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f18710b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f18709a;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f18710b;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            U.this.f();
            V v2 = this.f18710b;
            this.f18710b = v;
            return v2;
        }

        public String toString() {
            return this.f18709a + "=" + this.f18710b;
        }

        b(K k, V v) {
            this.f18709a = k;
            this.f18710b = v;
        }

        private boolean a(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f18709a;
        }
    }

    /* compiled from: SmallSortedMap.java */
    /* loaded from: classes2.dex */
    private class c implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a */
        private int f18712a;

        /* renamed from: b */
        private boolean f18713b;

        /* renamed from: c */
        private Iterator<Map.Entry<K, V>> f18714c;

        private c() {
            this.f18712a = -1;
        }

        private Iterator<Map.Entry<K, V>> b() {
            if (this.f18714c == null) {
                this.f18714c = U.this.f18704c.entrySet().iterator();
            }
            return this.f18714c;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f18712a + 1 < U.this.f18703b.size() || b().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f18713b) {
                this.f18713b = false;
                U.this.f();
                if (this.f18712a < U.this.f18703b.size()) {
                    U u = U.this;
                    int i = this.f18712a;
                    this.f18712a = i - 1;
                    u.c(i);
                    return;
                }
                b().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            this.f18713b = true;
            int i = this.f18712a + 1;
            this.f18712a = i;
            if (i < U.this.f18703b.size()) {
                return (Map.Entry) U.this.f18703b.get(this.f18712a);
            }
            return b().next();
        }

        /* synthetic */ c(U u, Q q) {
            this();
        }
    }

    /* compiled from: SmallSortedMap.java */
    /* loaded from: classes2.dex */
    public class d extends AbstractSet<Map.Entry<K, V>> {
        private d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            U.this.a((U) entry.getKey(), (K) entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            U.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = U.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new c(U.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            U.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return U.this.size();
        }

        /* synthetic */ d(U u, Q q) {
            this();
        }
    }

    public /* synthetic */ U(int i, Q q) {
        this(i);
    }

    public void f() {
        if (this.f18705d) {
            throw new UnsupportedOperationException();
        }
    }

    private void g() {
        f();
        if (!this.f18703b.isEmpty() || (this.f18703b instanceof ArrayList)) {
            return;
        }
        this.f18703b = new ArrayList(this.f18702a);
    }

    private SortedMap<K, V> h() {
        f();
        if (this.f18704c.isEmpty() && !(this.f18704c instanceof TreeMap)) {
            this.f18704c = new TreeMap();
        }
        return (SortedMap) this.f18704c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        f();
        if (!this.f18703b.isEmpty()) {
            this.f18703b.clear();
        }
        if (this.f18704c.isEmpty()) {
            return;
        }
        this.f18704c.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a((U<K, V>) comparable) >= 0 || this.f18704c.containsKey(comparable);
    }

    public boolean d() {
        return this.f18705d;
    }

    public void e() {
        Map<K, V> unmodifiableMap;
        if (this.f18705d) {
            return;
        }
        if (this.f18704c.isEmpty()) {
            unmodifiableMap = Collections.emptyMap();
        } else {
            unmodifiableMap = Collections.unmodifiableMap(this.f18704c);
        }
        this.f18704c = unmodifiableMap;
        this.f18705d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f18706e == null) {
            this.f18706e = new d(this, null);
        }
        return this.f18706e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof U)) {
            return super.equals(obj);
        }
        U u = (U) obj;
        int size = size();
        if (size != u.size()) {
            return false;
        }
        int a2 = a();
        if (a2 != u.a()) {
            return entrySet().equals(u.entrySet());
        }
        for (int i = 0; i < a2; i++) {
            if (!a(i).equals(u.a(i))) {
                return false;
            }
        }
        if (a2 != size) {
            return this.f18704c.equals(u.f18704c);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a((U<K, V>) comparable);
        if (a2 >= 0) {
            return this.f18703b.get(a2).getValue();
        }
        return this.f18704c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int a2 = a();
        int i = 0;
        for (int i2 = 0; i2 < a2; i2++) {
            i += this.f18703b.get(i2).hashCode();
        }
        return b() > 0 ? i + this.f18704c.hashCode() : i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return a((U<K, V>) obj, (Comparable) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int a2 = a((U<K, V>) comparable);
        if (a2 >= 0) {
            return (V) c(a2);
        }
        if (this.f18704c.isEmpty()) {
            return null;
        }
        return this.f18704c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f18703b.size() + this.f18704c.size();
    }

    private U(int i) {
        this.f18702a = i;
        this.f18703b = Collections.emptyList();
        this.f18704c = Collections.emptyMap();
    }

    public static <FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>> U<FieldDescriptorType, Object> b(int i) {
        return new Q(i);
    }

    public Iterable<Map.Entry<K, V>> c() {
        if (this.f18704c.isEmpty()) {
            return a.b();
        }
        return this.f18704c.entrySet();
    }

    public int a() {
        return this.f18703b.size();
    }

    public int b() {
        return this.f18704c.size();
    }

    public Map.Entry<K, V> a(int i) {
        return this.f18703b.get(i);
    }

    public V c(int i) {
        f();
        V value = this.f18703b.remove(i).getValue();
        if (!this.f18704c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = h().entrySet().iterator();
            this.f18703b.add(new b(this, it.next()));
            it.remove();
        }
        return value;
    }

    public V a(K k, V v) {
        f();
        int a2 = a((U<K, V>) k);
        if (a2 >= 0) {
            return this.f18703b.get(a2).setValue(v);
        }
        g();
        int i = -(a2 + 1);
        if (i >= this.f18702a) {
            return h().put(k, v);
        }
        int size = this.f18703b.size();
        int i2 = this.f18702a;
        if (size == i2) {
            U<K, V>.b remove = this.f18703b.remove(i2 - 1);
            h().put(remove.getKey(), remove.getValue());
        }
        this.f18703b.add(i, new b(k, v));
        return null;
    }

    private int a(K k) {
        int size = this.f18703b.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo(this.f18703b.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo(this.f18703b.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i2;
                }
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }
}
