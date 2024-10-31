package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ImmutableMap<K, V> implements Serializable, Map<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private transient ImmutableSet<Map.Entry<K, V>> f2692a;
    private transient ImmutableSet<K> b;
    private transient ImmutableCollection<V> c;

    abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    public abstract V get(@Nullable Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isPartialView();

    public static <K, V> ImmutableMap<K, V> of() {
        return EmptyImmutableMap.INSTANCE;
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v) {
        return new SingletonImmutableMap(Preconditions.a(k), Preconditions.a(v));
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2) {
        return new RegularImmutableMap(entryOf(k, v), entryOf(k2, v2));
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        return new RegularImmutableMap(entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3));
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return new RegularImmutableMap(entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3), entryOf(k4, v4));
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return new RegularImmutableMap(entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3), entryOf(k4, v4), entryOf(k5, v5));
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Map.Entry<K, V> entryOf(K k, V v) {
        Preconditions.a(k, "null key in entry: null=%s", v);
        Preconditions.a(v, "null value in entry: %s=null", k);
        return Maps.a(k, v);
    }

    /* loaded from: classes2.dex */
    public static class Builder<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final ArrayList<Map.Entry<K, V>> f2693a = Lists.a();

        public Builder<K, V> b(K k, V v) {
            this.f2693a.add(ImmutableMap.entryOf(k, v));
            return this;
        }

        public Builder<K, V> b(Map<? extends K, ? extends V> map) {
            this.f2693a.ensureCapacity(this.f2693a.size() + map.size());
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                b(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public ImmutableMap<K, V> b() {
            return a(this.f2693a);
        }

        private static <K, V> ImmutableMap<K, V> a(List<Map.Entry<K, V>> list) {
            switch (list.size()) {
                case 0:
                    return ImmutableMap.of();
                case 1:
                    return new SingletonImmutableMap((Map.Entry) Iterables.b(list));
                default:
                    return new RegularImmutableMap((Map.Entry[]) list.toArray(new Map.Entry[list.size()]));
            }
        }
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof ImmutableSortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.isPartialView()) {
                return immutableMap;
            }
        }
        Map.Entry[] entryArr = (Map.Entry[]) map.entrySet().toArray(new Map.Entry[0]);
        switch (entryArr.length) {
            case 0:
                return of();
            case 1:
                return new SingletonImmutableMap(entryOf(entryArr[0].getKey(), entryArr[0].getValue()));
        }
        for (int i = 0; i < entryArr.length; i++) {
            entryArr[i] = entryOf(entryArr[i].getKey(), entryArr[i].getValue());
        }
        return new RegularImmutableMap(entryArr);
    }

    @Override // java.util.Map
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(@Nullable Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@Nullable Object obj) {
        return obj != null && Maps.e(this, obj);
    }

    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.f2692a;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.f2692a = createEntrySet;
        return createEntrySet;
    }

    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.b;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<K> createKeySet = createKeySet();
        this.b = createKeySet;
        return createKeySet;
    }

    ImmutableSet<K> createKeySet() {
        return new ImmutableMapKeySet<K, V>(entrySet()) { // from class: com.google.common.collect.ImmutableMap.1
            @Override // com.google.common.collect.ImmutableMapKeySet
            ImmutableMap<K, V> map() {
                return ImmutableMap.this;
            }
        };
    }

    @Override // java.util.Map
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.c;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        ImmutableCollection<V> createValues = createValues();
        this.c = createValues;
        return createValues;
    }

    ImmutableCollection<V> createValues() {
        return new ImmutableMapValues<K, V>() { // from class: com.google.common.collect.ImmutableMap.2
            @Override // com.google.common.collect.ImmutableMapValues
            ImmutableMap<K, V> map() {
                return ImmutableMap.this;
            }
        };
    }

    public boolean equals(@Nullable Object obj) {
        return Maps.c(this, obj);
    }

    public int hashCode() {
        return entrySet().hashCode();
    }

    public String toString() {
        return Maps.a(this);
    }

    /* loaded from: classes2.dex */
    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object[] keys;
        private final Object[] values;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SerializedForm(ImmutableMap<?, ?> immutableMap) {
            this.keys = new Object[immutableMap.size()];
            this.values = new Object[immutableMap.size()];
            int i = 0;
            Iterator it = immutableMap.entrySet().iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    this.keys[i2] = entry.getKey();
                    this.values[i2] = entry.getValue();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        Object readResolve() {
            return createMap(new Builder<>());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Object createMap(Builder<Object, Object> builder) {
            for (int i = 0; i < this.keys.length; i++) {
                builder.b(this.keys[i], this.values[i]);
            }
            return builder.b();
        }
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }
}
