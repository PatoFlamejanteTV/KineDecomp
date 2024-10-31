package b.a.a.b;

import b.a.a.b.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FastSafeIterableMap.java */
/* loaded from: classes.dex */
public class a<K, V> extends c<K, V> {

    /* renamed from: e */
    private HashMap<K, c.C0007c<K, V>> f3223e = new HashMap<>();

    @Override // b.a.a.b.c
    protected c.C0007c<K, V> a(K k) {
        return this.f3223e.get(k);
    }

    @Override // b.a.a.b.c
    public V b(K k, V v) {
        c.C0007c<K, V> a2 = a((a<K, V>) k);
        if (a2 != null) {
            return a2.f3229b;
        }
        this.f3223e.put(k, a(k, v));
        return null;
    }

    public boolean contains(K k) {
        return this.f3223e.containsKey(k);
    }

    @Override // b.a.a.b.c
    public V remove(K k) {
        V v = (V) super.remove(k);
        this.f3223e.remove(k);
        return v;
    }

    public Map.Entry<K, V> b(K k) {
        if (contains(k)) {
            return this.f3223e.get(k).f3231d;
        }
        return null;
    }
}
