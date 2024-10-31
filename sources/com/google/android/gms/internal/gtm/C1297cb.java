package com.google.android.gms.internal.gtm;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* renamed from: com.google.android.gms.internal.gtm.cb */
/* loaded from: classes2.dex */
public class C1297cb<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a */
    private final int f13216a;

    /* renamed from: b */
    private List<jb> f13217b;

    /* renamed from: c */
    private Map<K, V> f13218c;

    /* renamed from: d */
    private boolean f13219d;

    /* renamed from: e */
    private volatile lb f13220e;

    /* renamed from: f */
    private Map<K, V> f13221f;

    /* renamed from: g */
    private volatile fb f13222g;

    private C1297cb(int i) {
        this.f13216a = i;
        this.f13217b = Collections.emptyList();
        this.f13218c = Collections.emptyMap();
        this.f13221f = Collections.emptyMap();
    }

    public static <FieldDescriptorType extends zzqv<FieldDescriptorType>> C1297cb<FieldDescriptorType, Object> a(int i) {
        return new C1300db(i);
    }

    public final void f() {
        if (this.f13219d) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> g() {
        f();
        if (this.f13218c.isEmpty() && !(this.f13218c instanceof TreeMap)) {
            this.f13218c = new TreeMap();
            this.f13221f = ((TreeMap) this.f13218c).descendingMap();
        }
        return (SortedMap) this.f13218c;
    }

    public void b() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (this.f13219d) {
            return;
        }
        if (this.f13218c.isEmpty()) {
            unmodifiableMap = Collections.emptyMap();
        } else {
            unmodifiableMap = Collections.unmodifiableMap(this.f13218c);
        }
        this.f13218c = unmodifiableMap;
        if (this.f13221f.isEmpty()) {
            unmodifiableMap2 = Collections.emptyMap();
        } else {
            unmodifiableMap2 = Collections.unmodifiableMap(this.f13221f);
        }
        this.f13221f = unmodifiableMap2;
        this.f13219d = true;
    }

    public final int c() {
        return this.f13217b.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        f();
        if (!this.f13217b.isEmpty()) {
            this.f13217b.clear();
        }
        if (this.f13218c.isEmpty()) {
            return;
        }
        this.f13218c.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a((C1297cb<K, V>) comparable) >= 0 || this.f13218c.containsKey(comparable);
    }

    public final Iterable<Map.Entry<K, V>> d() {
        if (this.f13218c.isEmpty()) {
            return gb.a();
        }
        return this.f13218c.entrySet();
    }

    public final Set<Map.Entry<K, V>> e() {
        if (this.f13222g == null) {
            this.f13222g = new fb(this, null);
        }
        return this.f13222g;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f13220e == null) {
            this.f13220e = new lb(this, null);
        }
        return this.f13220e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1297cb)) {
            return super.equals(obj);
        }
        C1297cb c1297cb = (C1297cb) obj;
        int size = size();
        if (size != c1297cb.size()) {
            return false;
        }
        int c2 = c();
        if (c2 != c1297cb.c()) {
            return entrySet().equals(c1297cb.entrySet());
        }
        for (int i = 0; i < c2; i++) {
            if (!b(i).equals(c1297cb.b(i))) {
                return false;
            }
        }
        if (c2 != size) {
            return this.f13218c.equals(c1297cb.f13218c);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a((C1297cb<K, V>) comparable);
        if (a2 >= 0) {
            return (V) this.f13217b.get(a2).getValue();
        }
        return this.f13218c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int c2 = c();
        int i = 0;
        for (int i2 = 0; i2 < c2; i2++) {
            i += this.f13217b.get(i2).hashCode();
        }
        return this.f13218c.size() > 0 ? i + this.f13218c.hashCode() : i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return a((C1297cb<K, V>) obj, (Comparable) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int a2 = a((C1297cb<K, V>) comparable);
        if (a2 >= 0) {
            return (V) c(a2);
        }
        if (this.f13218c.isEmpty()) {
            return null;
        }
        return this.f13218c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f13217b.size() + this.f13218c.size();
    }

    public final V c(int i) {
        f();
        V v = (V) this.f13217b.remove(i).getValue();
        if (!this.f13218c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = g().entrySet().iterator();
            this.f13217b.add(new jb(this, it.next()));
            it.remove();
        }
        return v;
    }

    public final boolean a() {
        return this.f13219d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V a(K k, V v) {
        f();
        int a2 = a((C1297cb<K, V>) k);
        if (a2 >= 0) {
            return (V) this.f13217b.get(a2).setValue(v);
        }
        f();
        if (this.f13217b.isEmpty() && !(this.f13217b instanceof ArrayList)) {
            this.f13217b = new ArrayList(this.f13216a);
        }
        int i = -(a2 + 1);
        if (i >= this.f13216a) {
            return g().put(k, v);
        }
        int size = this.f13217b.size();
        int i2 = this.f13216a;
        if (size == i2) {
            jb remove = this.f13217b.remove(i2 - 1);
            g().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.f13217b.add(i, new jb(this, k, v));
        return null;
    }

    public /* synthetic */ C1297cb(int i, C1300db c1300db) {
        this(i);
    }

    public final Map.Entry<K, V> b(int i) {
        return this.f13217b.get(i);
    }

    private final int a(K k) {
        int size = this.f13217b.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.f13217b.get(size).getKey());
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
            int compareTo2 = k.compareTo((Comparable) this.f13217b.get(i2).getKey());
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
