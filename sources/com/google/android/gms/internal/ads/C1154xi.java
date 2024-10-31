package com.google.android.gms.internal.ads;

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

/* renamed from: com.google.android.gms.internal.ads.xi */
/* loaded from: classes2.dex */
public class C1154xi<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a */
    private final int f12660a;

    /* renamed from: b */
    private List<Ei> f12661b;

    /* renamed from: c */
    private Map<K, V> f12662c;

    /* renamed from: d */
    private boolean f12663d;

    /* renamed from: e */
    private volatile Gi f12664e;

    /* renamed from: f */
    private Map<K, V> f12665f;

    /* renamed from: g */
    private volatile Ai f12666g;

    private C1154xi(int i) {
        this.f12660a = i;
        this.f12661b = Collections.emptyList();
        this.f12662c = Collections.emptyMap();
        this.f12665f = Collections.emptyMap();
    }

    public static <FieldDescriptorType extends zzbqw<FieldDescriptorType>> C1154xi<FieldDescriptorType, Object> a(int i) {
        return new C1168yi(i);
    }

    public final void f() {
        if (this.f12663d) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> g() {
        f();
        if (this.f12662c.isEmpty() && !(this.f12662c instanceof TreeMap)) {
            this.f12662c = new TreeMap();
            this.f12665f = ((TreeMap) this.f12662c).descendingMap();
        }
        return (SortedMap) this.f12662c;
    }

    public void b() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (this.f12663d) {
            return;
        }
        if (this.f12662c.isEmpty()) {
            unmodifiableMap = Collections.emptyMap();
        } else {
            unmodifiableMap = Collections.unmodifiableMap(this.f12662c);
        }
        this.f12662c = unmodifiableMap;
        if (this.f12665f.isEmpty()) {
            unmodifiableMap2 = Collections.emptyMap();
        } else {
            unmodifiableMap2 = Collections.unmodifiableMap(this.f12665f);
        }
        this.f12665f = unmodifiableMap2;
        this.f12663d = true;
    }

    public final int c() {
        return this.f12661b.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        f();
        if (!this.f12661b.isEmpty()) {
            this.f12661b.clear();
        }
        if (this.f12662c.isEmpty()) {
            return;
        }
        this.f12662c.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a((C1154xi<K, V>) comparable) >= 0 || this.f12662c.containsKey(comparable);
    }

    public final Iterable<Map.Entry<K, V>> d() {
        if (this.f12662c.isEmpty()) {
            return Bi.a();
        }
        return this.f12662c.entrySet();
    }

    public final Set<Map.Entry<K, V>> e() {
        if (this.f12666g == null) {
            this.f12666g = new Ai(this, null);
        }
        return this.f12666g;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f12664e == null) {
            this.f12664e = new Gi(this, null);
        }
        return this.f12664e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1154xi)) {
            return super.equals(obj);
        }
        C1154xi c1154xi = (C1154xi) obj;
        int size = size();
        if (size != c1154xi.size()) {
            return false;
        }
        int c2 = c();
        if (c2 != c1154xi.c()) {
            return entrySet().equals(c1154xi.entrySet());
        }
        for (int i = 0; i < c2; i++) {
            if (!b(i).equals(c1154xi.b(i))) {
                return false;
            }
        }
        if (c2 != size) {
            return this.f12662c.equals(c1154xi.f12662c);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a((C1154xi<K, V>) comparable);
        if (a2 >= 0) {
            return (V) this.f12661b.get(a2).getValue();
        }
        return this.f12662c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int c2 = c();
        int i = 0;
        for (int i2 = 0; i2 < c2; i2++) {
            i += this.f12661b.get(i2).hashCode();
        }
        return this.f12662c.size() > 0 ? i + this.f12662c.hashCode() : i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return a((C1154xi<K, V>) obj, (Comparable) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int a2 = a((C1154xi<K, V>) comparable);
        if (a2 >= 0) {
            return (V) c(a2);
        }
        if (this.f12662c.isEmpty()) {
            return null;
        }
        return this.f12662c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f12661b.size() + this.f12662c.size();
    }

    public final V c(int i) {
        f();
        V v = (V) this.f12661b.remove(i).getValue();
        if (!this.f12662c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = g().entrySet().iterator();
            this.f12661b.add(new Ei(this, it.next()));
            it.remove();
        }
        return v;
    }

    public final boolean a() {
        return this.f12663d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V a(K k, V v) {
        f();
        int a2 = a((C1154xi<K, V>) k);
        if (a2 >= 0) {
            return (V) this.f12661b.get(a2).setValue(v);
        }
        f();
        if (this.f12661b.isEmpty() && !(this.f12661b instanceof ArrayList)) {
            this.f12661b = new ArrayList(this.f12660a);
        }
        int i = -(a2 + 1);
        if (i >= this.f12660a) {
            return g().put(k, v);
        }
        int size = this.f12661b.size();
        int i2 = this.f12660a;
        if (size == i2) {
            Ei remove = this.f12661b.remove(i2 - 1);
            g().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.f12661b.add(i, new Ei(this, k, v));
        return null;
    }

    public /* synthetic */ C1154xi(int i, C1168yi c1168yi) {
        this(i);
    }

    public final Map.Entry<K, V> b(int i) {
        return this.f12661b.get(i);
    }

    private final int a(K k) {
        int size = this.f12661b.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.f12661b.get(size).getKey());
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
            int compareTo2 = k.compareTo((Comparable) this.f12661b.get(i2).getKey());
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
