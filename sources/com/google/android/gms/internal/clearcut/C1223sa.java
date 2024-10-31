package com.google.android.gms.internal.clearcut;

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

/* renamed from: com.google.android.gms.internal.clearcut.sa */
/* loaded from: classes2.dex */
public class C1223sa<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a */
    private final int f12886a;

    /* renamed from: b */
    private List<C1237za> f12887b;

    /* renamed from: c */
    private Map<K, V> f12888c;

    /* renamed from: d */
    private boolean f12889d;

    /* renamed from: e */
    private volatile Ba f12890e;

    /* renamed from: f */
    private Map<K, V> f12891f;

    /* renamed from: g */
    private volatile C1229va f12892g;

    private C1223sa(int i) {
        this.f12886a = i;
        this.f12887b = Collections.emptyList();
        this.f12888c = Collections.emptyMap();
        this.f12891f = Collections.emptyMap();
    }

    public /* synthetic */ C1223sa(int i, C1225ta c1225ta) {
        this(i);
    }

    private final int a(K k) {
        int size = this.f12887b.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.f12887b.get(size).getKey());
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
            int compareTo2 = k.compareTo((Comparable) this.f12887b.get(i2).getKey());
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

    public static <FieldDescriptorType extends zzca<FieldDescriptorType>> C1223sa<FieldDescriptorType, Object> a(int i) {
        return new C1225ta(i);
    }

    public final V c(int i) {
        f();
        V v = (V) this.f12887b.remove(i).getValue();
        if (!this.f12888c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = g().entrySet().iterator();
            this.f12887b.add(new C1237za(this, it.next()));
            it.remove();
        }
        return v;
    }

    public final void f() {
        if (this.f12889d) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> g() {
        f();
        if (this.f12888c.isEmpty() && !(this.f12888c instanceof TreeMap)) {
            this.f12888c = new TreeMap();
            this.f12891f = ((TreeMap) this.f12888c).descendingMap();
        }
        return (SortedMap) this.f12888c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V a(K k, V v) {
        f();
        int a2 = a((C1223sa<K, V>) k);
        if (a2 >= 0) {
            return (V) this.f12887b.get(a2).setValue(v);
        }
        f();
        if (this.f12887b.isEmpty() && !(this.f12887b instanceof ArrayList)) {
            this.f12887b = new ArrayList(this.f12886a);
        }
        int i = -(a2 + 1);
        if (i >= this.f12886a) {
            return g().put(k, v);
        }
        int size = this.f12887b.size();
        int i2 = this.f12886a;
        if (size == i2) {
            C1237za remove = this.f12887b.remove(i2 - 1);
            g().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.f12887b.add(i, new C1237za(this, k, v));
        return null;
    }

    public final boolean a() {
        return this.f12889d;
    }

    public final int b() {
        return this.f12887b.size();
    }

    public final Map.Entry<K, V> b(int i) {
        return this.f12887b.get(i);
    }

    public final Iterable<Map.Entry<K, V>> c() {
        return this.f12888c.isEmpty() ? C1231wa.a() : this.f12888c.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        f();
        if (!this.f12887b.isEmpty()) {
            this.f12887b.clear();
        }
        if (this.f12888c.isEmpty()) {
            return;
        }
        this.f12888c.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a((C1223sa<K, V>) comparable) >= 0 || this.f12888c.containsKey(comparable);
    }

    public final Set<Map.Entry<K, V>> d() {
        if (this.f12892g == null) {
            this.f12892g = new C1229va(this, null);
        }
        return this.f12892g;
    }

    public void e() {
        if (this.f12889d) {
            return;
        }
        this.f12888c = this.f12888c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f12888c);
        this.f12891f = this.f12891f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f12891f);
        this.f12889d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f12890e == null) {
            this.f12890e = new Ba(this, null);
        }
        return this.f12890e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1223sa)) {
            return super.equals(obj);
        }
        C1223sa c1223sa = (C1223sa) obj;
        int size = size();
        if (size != c1223sa.size()) {
            return false;
        }
        int b2 = b();
        if (b2 != c1223sa.b()) {
            return entrySet().equals(c1223sa.entrySet());
        }
        for (int i = 0; i < b2; i++) {
            if (!b(i).equals(c1223sa.b(i))) {
                return false;
            }
        }
        if (b2 != size) {
            return this.f12888c.equals(c1223sa.f12888c);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a((C1223sa<K, V>) comparable);
        return a2 >= 0 ? (V) this.f12887b.get(a2).getValue() : this.f12888c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int b2 = b();
        int i = 0;
        for (int i2 = 0; i2 < b2; i2++) {
            i += this.f12887b.get(i2).hashCode();
        }
        return this.f12888c.size() > 0 ? i + this.f12888c.hashCode() : i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return a((C1223sa<K, V>) obj, (Comparable) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int a2 = a((C1223sa<K, V>) comparable);
        if (a2 >= 0) {
            return (V) c(a2);
        }
        if (this.f12888c.isEmpty()) {
            return null;
        }
        return this.f12888c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f12887b.size() + this.f12888c.size();
    }
}
