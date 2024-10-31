package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class AbstractBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    private transient Map<K, V> f2633a;
    private transient Set<K> b;
    private transient Set<V> c;
    private transient Set<Map.Entry<K, V>> d;
    transient AbstractBiMap<V, K> inverse;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractBiMap(Map<K, V> map, Map<V, K> map2) {
        setDelegates(map, map2);
    }

    private AbstractBiMap(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
        this.f2633a = map;
        this.inverse = abstractBiMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<K, V> delegate() {
        return this.f2633a;
    }

    K checkKey(@Nullable K k) {
        return k;
    }

    V checkValue(@Nullable V v) {
        return v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDelegates(Map<K, V> map, Map<V, K> map2) {
        Preconditions.b(this.f2633a == null);
        Preconditions.b(this.inverse == null);
        Preconditions.a(map.isEmpty());
        Preconditions.a(map2.isEmpty());
        Preconditions.a(map != map2);
        this.f2633a = map;
        this.inverse = new Inverse(map2, this);
    }

    void setInverse(AbstractBiMap<V, K> abstractBiMap) {
        this.inverse = abstractBiMap;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public boolean containsValue(Object obj) {
        return this.inverse.containsKey(obj);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public V put(K k, V v) {
        return a(k, v, false);
    }

    public V forcePut(K k, V v) {
        return a(k, v, true);
    }

    private V a(@Nullable K k, @Nullable V v, boolean z) {
        checkKey(k);
        checkValue(v);
        boolean containsKey = containsKey(k);
        if (!containsKey || !Objects.a(v, get(k))) {
            if (z) {
                inverse().remove(v);
            } else {
                Preconditions.a(!containsValue(v), "value already present: %s", v);
            }
            V put = this.f2633a.put(k, v);
            a(k, containsKey, put, v);
            return put;
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(K k, boolean z, V v, V v2) {
        if (z) {
            b(v);
        }
        this.inverse.f2633a.put(v2, k);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public V remove(Object obj) {
        if (containsKey(obj)) {
            return a(obj);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V a(Object obj) {
        V remove = this.f2633a.remove(obj);
        b(remove);
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(V v) {
        this.inverse.f2633a.remove(v);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public void clear() {
        this.f2633a.clear();
        this.inverse.f2633a.clear();
    }

    @Override // com.google.common.collect.BiMap
    public BiMap<V, K> inverse() {
        return this.inverse;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.b;
        if (set != null) {
            return set;
        }
        b bVar = new b();
        this.b = bVar;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends ForwardingSet<K> {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<K> delegate() {
            return AbstractBiMap.this.f2633a.keySet();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj)) {
                AbstractBiMap.this.a(obj);
                return true;
            }
            return false;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return Maps.a(AbstractBiMap.this.entrySet().iterator());
        }
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<V> values() {
        Set<V> set = this.c;
        if (set != null) {
            return set;
        }
        c cVar = new c();
        this.c = cVar;
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends ForwardingSet<V> {

        /* renamed from: a, reason: collision with root package name */
        final Set<V> f2636a;

        private c() {
            this.f2636a = AbstractBiMap.this.inverse.keySet();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<V> delegate() {
            return this.f2636a;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return Maps.b(AbstractBiMap.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        @Override // com.google.common.collect.ForwardingObject
        public String toString() {
            return standardToString();
        }
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.d;
        if (set != null) {
            return set;
        }
        a aVar = new a();
        this.d = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends ForwardingSet<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        final Set<Map.Entry<K, V>> f2634a;

        private a() {
            this.f2634a = AbstractBiMap.this.f2633a.entrySet();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<Map.Entry<K, V>> delegate() {
            return this.f2634a;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!this.f2634a.contains(obj)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            ((AbstractBiMap) AbstractBiMap.this.inverse).f2633a.remove(entry.getValue());
            this.f2634a.remove(entry);
            return true;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new com.google.common.collect.a(this, this.f2634a.iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return Maps.a((Collection) delegate(), obj);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class Inverse<K, V> extends AbstractBiMap<K, V> {

        @GwtIncompatible
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return super.delegate();
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }

        private Inverse(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
            super(map, abstractBiMap);
        }

        @Override // com.google.common.collect.AbstractBiMap
        K checkKey(K k) {
            return this.inverse.checkValue(k);
        }

        @Override // com.google.common.collect.AbstractBiMap
        V checkValue(V v) {
            return this.inverse.checkKey(v);
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(inverse());
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            setInverse((AbstractBiMap) objectInputStream.readObject());
        }

        @GwtIncompatible
        Object readResolve() {
            return inverse().inverse();
        }
    }
}
