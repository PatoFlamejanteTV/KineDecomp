package android.support.v4.f;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: ArrayMap.java */
/* loaded from: classes.dex */
public class a<K, V> extends i<K, V> implements Map<K, V> {

    /* renamed from: a, reason: collision with root package name */
    h<K, V> f75a;

    public a() {
    }

    public a(int i) {
        super(i);
    }

    private h<K, V> b() {
        if (this.f75a == null) {
            this.f75a = new b(this);
        }
        return this.f75a;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        a(this.h + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean a(Collection<?> collection) {
        return h.c(this, collection);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return b().d();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return b().e();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return b().f();
    }
}
