package com.google.android.gms.internal.measurement;

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

/* renamed from: com.google.android.gms.internal.measurement.fb */
/* loaded from: classes2.dex */
public class C1362fb<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a */
    private final int f13448a;

    /* renamed from: b */
    private List<mb> f13449b;

    /* renamed from: c */
    private Map<K, V> f13450c;

    /* renamed from: d */
    private boolean f13451d;

    /* renamed from: e */
    private volatile ob f13452e;

    /* renamed from: f */
    private Map<K, V> f13453f;

    /* renamed from: g */
    private volatile ib f13454g;

    private C1362fb(int i) {
        this.f13448a = i;
        this.f13449b = Collections.emptyList();
        this.f13450c = Collections.emptyMap();
        this.f13453f = Collections.emptyMap();
    }

    public static <FieldDescriptorType extends zzuh<FieldDescriptorType>> C1362fb<FieldDescriptorType, Object> a(int i) {
        return new C1365gb(i);
    }

    public final void f() {
        if (this.f13451d) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> g() {
        f();
        if (this.f13450c.isEmpty() && !(this.f13450c instanceof TreeMap)) {
            this.f13450c = new TreeMap();
            this.f13453f = ((TreeMap) this.f13450c).descendingMap();
        }
        return (SortedMap) this.f13450c;
    }

    public void b() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (this.f13451d) {
            return;
        }
        if (this.f13450c.isEmpty()) {
            unmodifiableMap = Collections.emptyMap();
        } else {
            unmodifiableMap = Collections.unmodifiableMap(this.f13450c);
        }
        this.f13450c = unmodifiableMap;
        if (this.f13453f.isEmpty()) {
            unmodifiableMap2 = Collections.emptyMap();
        } else {
            unmodifiableMap2 = Collections.unmodifiableMap(this.f13453f);
        }
        this.f13453f = unmodifiableMap2;
        this.f13451d = true;
    }

    public final int c() {
        return this.f13449b.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        f();
        if (!this.f13449b.isEmpty()) {
            this.f13449b.clear();
        }
        if (this.f13450c.isEmpty()) {
            return;
        }
        this.f13450c.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a((C1362fb<K, V>) comparable) >= 0 || this.f13450c.containsKey(comparable);
    }

    public final Iterable<Map.Entry<K, V>> d() {
        if (this.f13450c.isEmpty()) {
            return jb.a();
        }
        return this.f13450c.entrySet();
    }

    public final Set<Map.Entry<K, V>> e() {
        if (this.f13454g == null) {
            this.f13454g = new ib(this, null);
        }
        return this.f13454g;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f13452e == null) {
            this.f13452e = new ob(this, null);
        }
        return this.f13452e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1362fb)) {
            return super.equals(obj);
        }
        C1362fb c1362fb = (C1362fb) obj;
        int size = size();
        if (size != c1362fb.size()) {
            return false;
        }
        int c2 = c();
        if (c2 != c1362fb.c()) {
            return entrySet().equals(c1362fb.entrySet());
        }
        for (int i = 0; i < c2; i++) {
            if (!b(i).equals(c1362fb.b(i))) {
                return false;
            }
        }
        if (c2 != size) {
            return this.f13450c.equals(c1362fb.f13450c);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a((C1362fb<K, V>) comparable);
        if (a2 >= 0) {
            return (V) this.f13449b.get(a2).getValue();
        }
        return this.f13450c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int c2 = c();
        int i = 0;
        for (int i2 = 0; i2 < c2; i2++) {
            i += this.f13449b.get(i2).hashCode();
        }
        return this.f13450c.size() > 0 ? i + this.f13450c.hashCode() : i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return a((C1362fb<K, V>) obj, (Comparable) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int a2 = a((C1362fb<K, V>) comparable);
        if (a2 >= 0) {
            return (V) c(a2);
        }
        if (this.f13450c.isEmpty()) {
            return null;
        }
        return this.f13450c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f13449b.size() + this.f13450c.size();
    }

    public final V c(int i) {
        f();
        V v = (V) this.f13449b.remove(i).getValue();
        if (!this.f13450c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = g().entrySet().iterator();
            this.f13449b.add(new mb(this, it.next()));
            it.remove();
        }
        return v;
    }

    public final boolean a() {
        return this.f13451d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V a(K k, V v) {
        f();
        int a2 = a((C1362fb<K, V>) k);
        if (a2 >= 0) {
            return (V) this.f13449b.get(a2).setValue(v);
        }
        f();
        if (this.f13449b.isEmpty() && !(this.f13449b instanceof ArrayList)) {
            this.f13449b = new ArrayList(this.f13448a);
        }
        int i = -(a2 + 1);
        if (i >= this.f13448a) {
            return g().put(k, v);
        }
        int size = this.f13449b.size();
        int i2 = this.f13448a;
        if (size == i2) {
            mb remove = this.f13449b.remove(i2 - 1);
            g().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.f13449b.add(i, new mb(this, k, v));
        return null;
    }

    public /* synthetic */ C1362fb(int i, C1365gb c1365gb) {
        this(i);
    }

    public final Map.Entry<K, V> b(int i) {
        return this.f13449b.get(i);
    }

    private final int a(K k) {
        int size = this.f13449b.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.f13449b.get(size).getKey());
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
            int compareTo2 = k.compareTo((Comparable) this.f13449b.get(i2).getKey());
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
