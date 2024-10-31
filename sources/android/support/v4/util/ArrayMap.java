package android.support.v4.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {

    /* renamed from: h */
    MapCollections<K, V> f1695h;

    /* renamed from: android.support.v4.util.ArrayMap$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends MapCollections<K, V> {
        AnonymousClass1() {
        }

        @Override // android.support.v4.util.MapCollections
        protected Object a(int i, int i2) {
            return ArrayMap.this.f1753f[(i << 1) + i2];
        }

        @Override // android.support.v4.util.MapCollections
        protected int b(Object obj) {
            return ArrayMap.this.a(obj);
        }

        @Override // android.support.v4.util.MapCollections
        protected int c() {
            return ArrayMap.this.f1754g;
        }

        @Override // android.support.v4.util.MapCollections
        protected int a(Object obj) {
            return ArrayMap.this.indexOfKey(obj);
        }

        @Override // android.support.v4.util.MapCollections
        protected Map<K, V> b() {
            return ArrayMap.this;
        }

        @Override // android.support.v4.util.MapCollections
        protected void a(K k, V v) {
            ArrayMap.this.put(k, v);
        }

        @Override // android.support.v4.util.MapCollections
        protected V a(int i, V v) {
            return ArrayMap.this.setValueAt(i, v);
        }

        @Override // android.support.v4.util.MapCollections
        protected void a(int i) {
            ArrayMap.this.removeAt(i);
        }

        @Override // android.support.v4.util.MapCollections
        protected void a() {
            ArrayMap.this.clear();
        }
    }

    public ArrayMap() {
    }

    private MapCollections<K, V> b() {
        if (this.f1695h == null) {
            this.f1695h = new MapCollections<K, V>() { // from class: android.support.v4.util.ArrayMap.1
                AnonymousClass1() {
                }

                @Override // android.support.v4.util.MapCollections
                protected Object a(int i, int i2) {
                    return ArrayMap.this.f1753f[(i << 1) + i2];
                }

                @Override // android.support.v4.util.MapCollections
                protected int b(Object obj) {
                    return ArrayMap.this.a(obj);
                }

                @Override // android.support.v4.util.MapCollections
                protected int c() {
                    return ArrayMap.this.f1754g;
                }

                @Override // android.support.v4.util.MapCollections
                protected int a(Object obj) {
                    return ArrayMap.this.indexOfKey(obj);
                }

                @Override // android.support.v4.util.MapCollections
                protected Map<K, V> b() {
                    return ArrayMap.this;
                }

                @Override // android.support.v4.util.MapCollections
                protected void a(K k, V v) {
                    ArrayMap.this.put(k, v);
                }

                @Override // android.support.v4.util.MapCollections
                protected V a(int i, V v) {
                    return ArrayMap.this.setValueAt(i, v);
                }

                @Override // android.support.v4.util.MapCollections
                protected void a(int i) {
                    ArrayMap.this.removeAt(i);
                }

                @Override // android.support.v4.util.MapCollections
                protected void a() {
                    ArrayMap.this.clear();
                }
            };
        }
        return this.f1695h;
    }

    public boolean containsAll(Collection<?> collection) {
        return MapCollections.containsAllHelper(this, collection);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return b().getEntrySet();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return b().getKeySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.f1754g + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean removeAll(Collection<?> collection) {
        return MapCollections.removeAllHelper(this, collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return MapCollections.retainAllHelper(this, collection);
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return b().getValues();
    }

    public ArrayMap(int i) {
        super(i);
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }
}
