package com.google.android.gms.internal.firebase_auth;

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

/* renamed from: com.google.android.gms.internal.firebase_auth.pa */
/* loaded from: classes2.dex */
public class C1269pa<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a */
    private final int f13066a;

    /* renamed from: b */
    private List<C1284xa> f13067b;

    /* renamed from: c */
    private Map<K, V> f13068c;

    /* renamed from: d */
    private boolean f13069d;

    /* renamed from: e */
    private volatile C1288za f13070e;

    /* renamed from: f */
    private Map<K, V> f13071f;

    /* renamed from: g */
    private volatile C1276ta f13072g;

    private C1269pa(int i) {
        this.f13066a = i;
        this.f13067b = Collections.emptyList();
        this.f13068c = Collections.emptyMap();
        this.f13071f = Collections.emptyMap();
    }

    public static <FieldDescriptorType extends zzfm<FieldDescriptorType>> C1269pa<FieldDescriptorType, Object> a(int i) {
        return new C1272ra(i);
    }

    public final void f() {
        if (this.f13069d) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> g() {
        f();
        if (this.f13068c.isEmpty() && !(this.f13068c instanceof TreeMap)) {
            this.f13068c = new TreeMap();
            this.f13071f = ((TreeMap) this.f13068c).descendingMap();
        }
        return (SortedMap) this.f13068c;
    }

    public void b() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (this.f13069d) {
            return;
        }
        if (this.f13068c.isEmpty()) {
            unmodifiableMap = Collections.emptyMap();
        } else {
            unmodifiableMap = Collections.unmodifiableMap(this.f13068c);
        }
        this.f13068c = unmodifiableMap;
        if (this.f13071f.isEmpty()) {
            unmodifiableMap2 = Collections.emptyMap();
        } else {
            unmodifiableMap2 = Collections.unmodifiableMap(this.f13071f);
        }
        this.f13071f = unmodifiableMap2;
        this.f13069d = true;
    }

    public final int c() {
        return this.f13067b.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        f();
        if (!this.f13067b.isEmpty()) {
            this.f13067b.clear();
        }
        if (this.f13068c.isEmpty()) {
            return;
        }
        this.f13068c.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a((C1269pa<K, V>) comparable) >= 0 || this.f13068c.containsKey(comparable);
    }

    public final Iterable<Map.Entry<K, V>> d() {
        if (this.f13068c.isEmpty()) {
            return C1278ua.a();
        }
        return this.f13068c.entrySet();
    }

    public final Set<Map.Entry<K, V>> e() {
        if (this.f13072g == null) {
            this.f13072g = new C1276ta(this, null);
        }
        return this.f13072g;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f13070e == null) {
            this.f13070e = new C1288za(this, null);
        }
        return this.f13070e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1269pa)) {
            return super.equals(obj);
        }
        C1269pa c1269pa = (C1269pa) obj;
        int size = size();
        if (size != c1269pa.size()) {
            return false;
        }
        int c2 = c();
        if (c2 != c1269pa.c()) {
            return entrySet().equals(c1269pa.entrySet());
        }
        for (int i = 0; i < c2; i++) {
            if (!b(i).equals(c1269pa.b(i))) {
                return false;
            }
        }
        if (c2 != size) {
            return this.f13068c.equals(c1269pa.f13068c);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a((C1269pa<K, V>) comparable);
        if (a2 >= 0) {
            return (V) this.f13067b.get(a2).getValue();
        }
        return this.f13068c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int c2 = c();
        int i = 0;
        for (int i2 = 0; i2 < c2; i2++) {
            i += this.f13067b.get(i2).hashCode();
        }
        return this.f13068c.size() > 0 ? i + this.f13068c.hashCode() : i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return a((C1269pa<K, V>) obj, (Comparable) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int a2 = a((C1269pa<K, V>) comparable);
        if (a2 >= 0) {
            return (V) c(a2);
        }
        if (this.f13068c.isEmpty()) {
            return null;
        }
        return this.f13068c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f13067b.size() + this.f13068c.size();
    }

    public final V c(int i) {
        f();
        V v = (V) this.f13067b.remove(i).getValue();
        if (!this.f13068c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = g().entrySet().iterator();
            this.f13067b.add(new C1284xa(this, it.next()));
            it.remove();
        }
        return v;
    }

    public final boolean a() {
        return this.f13069d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V a(K k, V v) {
        f();
        int a2 = a((C1269pa<K, V>) k);
        if (a2 >= 0) {
            return (V) this.f13067b.get(a2).setValue(v);
        }
        f();
        if (this.f13067b.isEmpty() && !(this.f13067b instanceof ArrayList)) {
            this.f13067b = new ArrayList(this.f13066a);
        }
        int i = -(a2 + 1);
        if (i >= this.f13066a) {
            return g().put(k, v);
        }
        int size = this.f13067b.size();
        int i2 = this.f13066a;
        if (size == i2) {
            C1284xa remove = this.f13067b.remove(i2 - 1);
            g().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.f13067b.add(i, new C1284xa(this, k, v));
        return null;
    }

    public /* synthetic */ C1269pa(int i, C1272ra c1272ra) {
        this(i);
    }

    public final Map.Entry<K, V> b(int i) {
        return this.f13067b.get(i);
    }

    private final int a(K k) {
        int size = this.f13067b.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.f13067b.get(size).getKey());
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
            int compareTo2 = k.compareTo((Comparable) this.f13067b.get(i2).getKey());
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
