package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class AbstractMultimap<K, V> implements Multimap<K, V>, Serializable {
    private static final long serialVersionUID = 2447537837011683357L;

    /* renamed from: a, reason: collision with root package name */
    private transient Map<K, Collection<V>> f2642a;
    private transient int b;
    private transient Set<K> c;
    private transient Multiset<K> d;
    private transient Collection<V> e;
    private transient Collection<Map.Entry<K, V>> f;
    private transient Map<K, Collection<V>> g;

    abstract Collection<V> createCollection();

    static /* synthetic */ int access$208(AbstractMultimap abstractMultimap) {
        int i2 = abstractMultimap.b;
        abstractMultimap.b = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$210(AbstractMultimap abstractMultimap) {
        int i2 = abstractMultimap.b;
        abstractMultimap.b = i2 - 1;
        return i2;
    }

    static /* synthetic */ int access$212(AbstractMultimap abstractMultimap, int i2) {
        int i3 = abstractMultimap.b + i2;
        abstractMultimap.b = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int access$220(AbstractMultimap abstractMultimap, int i2) {
        int i3 = abstractMultimap.b - i2;
        abstractMultimap.b = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractMultimap(Map<K, Collection<V>> map) {
        Preconditions.a(map.isEmpty());
        this.f2642a = map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setMap(Map<K, Collection<V>> map) {
        this.f2642a = map;
        this.b = 0;
        for (Collection<V> collection : map.values()) {
            Preconditions.a(!collection.isEmpty());
            this.b = collection.size() + this.b;
        }
    }

    Collection<V> createCollection(@Nullable K k) {
        return createCollection();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<K, Collection<V>> backingMap() {
        return this.f2642a;
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.b;
    }

    @Override // com.google.common.collect.Multimap
    public boolean isEmpty() {
        return this.b == 0;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@Nullable Object obj) {
        return this.f2642a.containsKey(obj);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsValue(@Nullable Object obj) {
        Iterator<Collection<V>> it = this.f2642a.values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsEntry(@Nullable Object obj, @Nullable Object obj2) {
        Collection<V> collection = this.f2642a.get(obj);
        return collection != null && collection.contains(obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean put(@Nullable K k, @Nullable V v) {
        Collection<V> collection = this.f2642a.get(k);
        if (collection == null) {
            Collection<V> createCollection = createCollection(k);
            if (createCollection.add(v)) {
                this.b++;
                this.f2642a.put(k, createCollection);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        }
        if (collection.add(v)) {
            this.b++;
            return true;
        }
        return false;
    }

    private Collection<V> a(@Nullable K k) {
        Collection<V> collection = this.f2642a.get(k);
        if (collection == null) {
            Collection<V> createCollection = createCollection(k);
            this.f2642a.put(k, createCollection);
            return createCollection;
        }
        return collection;
    }

    @Override // com.google.common.collect.Multimap
    public boolean remove(@Nullable Object obj, @Nullable Object obj2) {
        Collection<V> collection = this.f2642a.get(obj);
        if (collection == null) {
            return false;
        }
        boolean remove = collection.remove(obj2);
        if (remove) {
            this.b--;
            if (collection.isEmpty()) {
                this.f2642a.remove(obj);
            }
        }
        return remove;
    }

    @Override // com.google.common.collect.Multimap
    public boolean putAll(@Nullable K k, Iterable<? extends V> iterable) {
        boolean z = false;
        if (iterable.iterator().hasNext()) {
            Collection<V> a2 = a((AbstractMultimap<K, V>) k);
            int size = a2.size();
            if (iterable instanceof Collection) {
                z = a2.addAll(Collections2.a(iterable));
            } else {
                Iterator<? extends V> it = iterable.iterator();
                while (it.hasNext()) {
                    z |= a2.add(it.next());
                }
            }
            this.b = (a2.size() - size) + this.b;
        }
        return z;
    }

    @Override // com.google.common.collect.Multimap
    public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
        boolean z = false;
        Iterator<Map.Entry<? extends K, ? extends V>> it = multimap.entries().iterator();
        while (true) {
            boolean z2 = z;
            if (it.hasNext()) {
                Map.Entry<? extends K, ? extends V> next = it.next();
                z = put(next.getKey(), next.getValue()) | z2;
            } else {
                return z2;
            }
        }
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> replaceValues(@Nullable K k, Iterable<? extends V> iterable) {
        Iterator<? extends V> it = iterable.iterator();
        if (!it.hasNext()) {
            return removeAll(k);
        }
        Collection<V> a2 = a((AbstractMultimap<K, V>) k);
        Collection<V> createCollection = createCollection();
        createCollection.addAll(a2);
        this.b -= a2.size();
        a2.clear();
        while (it.hasNext()) {
            if (a2.add(it.next())) {
                this.b++;
            }
        }
        return a((Collection) createCollection);
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> removeAll(@Nullable Object obj) {
        Collection<V> remove = this.f2642a.remove(obj);
        Collection<V> createCollection = createCollection();
        if (remove != null) {
            createCollection.addAll(remove);
            this.b -= remove.size();
            remove.clear();
        }
        return a((Collection) createCollection);
    }

    private Collection<V> a(Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet) collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set) collection);
        }
        if (collection instanceof List) {
            return Collections.unmodifiableList((List) collection);
        }
        return Collections.unmodifiableCollection(collection);
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        Iterator<Collection<V>> it = this.f2642a.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.f2642a.clear();
        this.b = 0;
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> get(@Nullable K k) {
        Collection<V> collection = this.f2642a.get(k);
        if (collection == null) {
            collection = createCollection(k);
        }
        return a(k, collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Collection<V> a(@Nullable K k, Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return new j(k, (SortedSet) collection, null);
        }
        if (collection instanceof Set) {
            return new i(k, (Set) collection);
        }
        if (collection instanceof List) {
            return a(k, (List) collection, null);
        }
        return new g(k, collection, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<V> a(@Nullable K k, List<V> list, @Nullable AbstractMultimap<K, V>.g gVar) {
        return list instanceof RandomAccess ? new d(k, list, gVar) : new h(k, list, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class g extends AbstractCollection<V> {
        final K b;
        Collection<V> c;
        final AbstractMultimap<K, V>.g d;
        final Collection<V> e;

        g(K k, @Nullable Collection<V> collection, AbstractMultimap<K, V>.g gVar) {
            this.b = k;
            this.c = collection;
            this.d = gVar;
            this.e = gVar == null ? null : gVar.e();
        }

        void a() {
            Collection<V> collection;
            if (this.d != null) {
                this.d.a();
                if (this.d.e() != this.e) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.c.isEmpty() && (collection = (Collection) AbstractMultimap.this.f2642a.get(this.b)) != null) {
                this.c = collection;
            }
        }

        void b() {
            if (this.d != null) {
                this.d.b();
            } else if (this.c.isEmpty()) {
                AbstractMultimap.this.f2642a.remove(this.b);
            }
        }

        K c() {
            return this.b;
        }

        void d() {
            if (this.d == null) {
                AbstractMultimap.this.f2642a.put(this.b, this.c);
            } else {
                this.d.d();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            a();
            return this.c.size();
        }

        @Override // java.util.Collection
        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            a();
            return this.c.equals(obj);
        }

        @Override // java.util.Collection
        public int hashCode() {
            a();
            return this.c.hashCode();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            a();
            return this.c.toString();
        }

        Collection<V> e() {
            return this.c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            a();
            return new a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a implements Iterator<V> {

            /* renamed from: a, reason: collision with root package name */
            final Iterator<V> f2649a;
            final Collection<V> b;

            a() {
                this.b = g.this.c;
                this.f2649a = AbstractMultimap.this.b((Collection) g.this.c);
            }

            a(Iterator<V> it) {
                this.b = g.this.c;
                this.f2649a = it;
            }

            void a() {
                g.this.a();
                if (g.this.c != this.b) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.f2649a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                a();
                return this.f2649a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f2649a.remove();
                AbstractMultimap.access$210(AbstractMultimap.this);
                g.this.b();
            }

            Iterator<V> b() {
                a();
                return this.f2649a;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V v) {
            a();
            boolean isEmpty = this.c.isEmpty();
            boolean add = this.c.add(v);
            if (add) {
                AbstractMultimap.access$208(AbstractMultimap.this);
                if (isEmpty) {
                    d();
                }
            }
            return add;
        }

        AbstractMultimap<K, V>.g f() {
            return this.d;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.c.addAll(collection);
            if (addAll) {
                AbstractMultimap.access$212(AbstractMultimap.this, this.c.size() - size);
                if (size == 0) {
                    d();
                    return addAll;
                }
                return addAll;
            }
            return addAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            a();
            return this.c.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            a();
            return this.c.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size != 0) {
                this.c.clear();
                AbstractMultimap.access$220(AbstractMultimap.this, size);
                b();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            a();
            boolean remove = this.c.remove(obj);
            if (remove) {
                AbstractMultimap.access$210(AbstractMultimap.this);
                b();
            }
            return remove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.c.removeAll(collection);
            if (removeAll) {
                AbstractMultimap.access$212(AbstractMultimap.this, this.c.size() - size);
                b();
                return removeAll;
            }
            return removeAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Preconditions.a(collection);
            int size = size();
            boolean retainAll = this.c.retainAll(collection);
            if (retainAll) {
                AbstractMultimap.access$212(AbstractMultimap.this, this.c.size() - size);
                b();
            }
            return retainAll;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Iterator<V> b(Collection<V> collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class i extends AbstractMultimap<K, V>.g implements Set<V> {
        i(K k, @Nullable Set<V> set) {
            super(k, set, null);
        }

        @Override // com.google.common.collect.AbstractMultimap.g, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean a2 = Sets.a((Set<?>) this.c, collection);
            if (a2) {
                AbstractMultimap.access$212(AbstractMultimap.this, this.c.size() - size);
                b();
                return a2;
            }
            return a2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class j extends AbstractMultimap<K, V>.g implements SortedSet<V> {
        j(K k, @Nullable SortedSet<V> sortedSet, AbstractMultimap<K, V>.g gVar) {
            super(k, sortedSet, gVar);
        }

        SortedSet<V> g() {
            return (SortedSet) e();
        }

        @Override // java.util.SortedSet
        public Comparator<? super V> comparator() {
            return g().comparator();
        }

        @Override // java.util.SortedSet
        public V first() {
            a();
            return g().first();
        }

        @Override // java.util.SortedSet
        public V last() {
            a();
            return g().last();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v2, types: [com.google.common.collect.AbstractMultimap$g] */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v4 */
        @Override // java.util.SortedSet
        public SortedSet<V> headSet(V v) {
            a();
            AbstractMultimap abstractMultimap = AbstractMultimap.this;
            Object c = c();
            SortedSet<V> headSet = g().headSet(v);
            AbstractMultimap<K, V>.g f = f();
            ?? r5 = this;
            if (f != null) {
                r5 = f();
            }
            return new j(c, headSet, r5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v2, types: [com.google.common.collect.AbstractMultimap$g] */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v4 */
        @Override // java.util.SortedSet
        public SortedSet<V> subSet(V v, V v2) {
            a();
            AbstractMultimap abstractMultimap = AbstractMultimap.this;
            Object c = c();
            SortedSet<V> subSet = g().subSet(v, v2);
            AbstractMultimap<K, V>.g f = f();
            ?? r5 = this;
            if (f != null) {
                r5 = f();
            }
            return new j(c, subSet, r5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v2, types: [com.google.common.collect.AbstractMultimap$g] */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v4 */
        @Override // java.util.SortedSet
        public SortedSet<V> tailSet(V v) {
            a();
            AbstractMultimap abstractMultimap = AbstractMultimap.this;
            Object c = c();
            SortedSet<V> tailSet = g().tailSet(v);
            AbstractMultimap<K, V>.g f = f();
            ?? r5 = this;
            if (f != null) {
                r5 = f();
            }
            return new j(c, tailSet, r5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class h extends AbstractMultimap<K, V>.g implements List<V> {
        h(K k, @Nullable List<V> list, AbstractMultimap<K, V>.g gVar) {
            super(k, list, gVar);
        }

        List<V> g() {
            return (List) e();
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = g().addAll(i, collection);
            if (addAll) {
                AbstractMultimap.access$212(AbstractMultimap.this, e().size() - size);
                if (size == 0) {
                    d();
                    return addAll;
                }
                return addAll;
            }
            return addAll;
        }

        @Override // java.util.List
        public V get(int i) {
            a();
            return g().get(i);
        }

        @Override // java.util.List
        public V set(int i, V v) {
            a();
            return g().set(i, v);
        }

        @Override // java.util.List
        public void add(int i, V v) {
            a();
            boolean isEmpty = e().isEmpty();
            g().add(i, v);
            AbstractMultimap.access$208(AbstractMultimap.this);
            if (isEmpty) {
                d();
            }
        }

        @Override // java.util.List
        public V remove(int i) {
            a();
            V remove = g().remove(i);
            AbstractMultimap.access$210(AbstractMultimap.this);
            b();
            return remove;
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            a();
            return g().indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            a();
            return g().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            a();
            return new a();
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i) {
            a();
            return new a(i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v2, types: [com.google.common.collect.AbstractMultimap$g] */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        @Override // java.util.List
        public List<V> subList(int i, int i2) {
            a();
            AbstractMultimap abstractMultimap = AbstractMultimap.this;
            Object c = c();
            List<V> subList = g().subList(i, i2);
            AbstractMultimap<K, V>.g f = f();
            ?? r4 = this;
            if (f != null) {
                r4 = f();
            }
            return abstractMultimap.a(c, subList, r4);
        }

        /* loaded from: classes2.dex */
        private class a extends AbstractMultimap<K, V>.g.a implements ListIterator<V> {
            a() {
                super();
            }

            public a(int i) {
                super(h.this.g().listIterator(i));
            }

            private ListIterator<V> c() {
                return (ListIterator) b();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            @Override // java.util.ListIterator
            public V previous() {
                return c().previous();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return c().nextIndex();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(V v) {
                c().set(v);
            }

            @Override // java.util.ListIterator
            public void add(V v) {
                boolean isEmpty = h.this.isEmpty();
                c().add(v);
                AbstractMultimap.access$208(AbstractMultimap.this);
                if (isEmpty) {
                    h.this.d();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d extends h implements RandomAccess {
        d(K k, @Nullable List<V> list, AbstractMultimap<K, V>.g gVar) {
            super(k, list, gVar);
        }
    }

    @Override // com.google.common.collect.Multimap
    public Set<K> keySet() {
        Set<K> set = this.c;
        if (set != null) {
            return set;
        }
        Set<K> a2 = a();
        this.c = a2;
        return a2;
    }

    private Set<K> a() {
        return this.f2642a instanceof SortedMap ? new f((SortedMap) this.f2642a) : new c(this.f2642a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends Maps.c<K, Collection<V>> {

        /* renamed from: a, reason: collision with root package name */
        final Map<K, Collection<V>> f2647a;

        c(Map<K, Collection<V>> map) {
            this.f2647a = map;
        }

        @Override // com.google.common.collect.Maps.c
        Map<K, Collection<V>> a() {
            return this.f2647a;
        }

        @Override // com.google.common.collect.Maps.c, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new k(this);
        }

        @Override // com.google.common.collect.Maps.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int i;
            Collection<V> remove = this.f2647a.remove(obj);
            if (remove != null) {
                int size = remove.size();
                remove.clear();
                AbstractMultimap.access$220(AbstractMultimap.this, size);
                i = size;
            } else {
                i = 0;
            }
            return i > 0;
        }

        @Override // com.google.common.collect.Maps.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Iterators.d(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.f2647a.keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(@Nullable Object obj) {
            return this == obj || this.f2647a.keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.f2647a.keySet().hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class f extends AbstractMultimap<K, V>.c implements SortedSet<K> {
        f(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        SortedMap<K, Collection<V>> b() {
            return (SortedMap) this.f2647a;
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return b().firstKey();
        }

        @Override // java.util.SortedSet
        public SortedSet<K> headSet(K k) {
            return new f(b().headMap(k));
        }

        @Override // java.util.SortedSet
        public K last() {
            return b().lastKey();
        }

        @Override // java.util.SortedSet
        public SortedSet<K> subSet(K k, K k2) {
            return new f(b().subMap(k, k2));
        }

        @Override // java.util.SortedSet
        public SortedSet<K> tailSet(K k) {
            return new f(b().tailMap(k));
        }
    }

    @Override // com.google.common.collect.Multimap
    public Multiset<K> keys() {
        Multiset<K> multiset = this.d;
        if (multiset == null) {
            com.google.common.collect.g gVar = new com.google.common.collect.g(this);
            this.d = gVar;
            return gVar;
        }
        return multiset;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(Object obj) {
        int i2 = 0;
        try {
            Collection<V> remove = this.f2642a.remove(obj);
            if (remove != null) {
                i2 = remove.size();
                remove.clear();
                this.b -= i2;
            }
            return i2;
        } catch (ClassCastException e2) {
            return 0;
        } catch (NullPointerException e3) {
            return 0;
        }
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> values() {
        Collection<V> collection = this.e;
        if (collection == null) {
            com.google.common.collect.h hVar = new com.google.common.collect.h(this);
            this.e = hVar;
            return hVar;
        }
        return collection;
    }

    @Override // com.google.common.collect.Multimap
    public Collection<Map.Entry<K, V>> entries() {
        Collection<Map.Entry<K, V>> collection = this.f;
        if (collection != null) {
            return collection;
        }
        Collection<Map.Entry<K, V>> createEntries = createEntries();
        this.f = createEntries;
        return createEntries;
    }

    Collection<Map.Entry<K, V>> createEntries() {
        return this instanceof SetMultimap ? new com.google.common.collect.i(this) : new com.google.common.collect.j(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> createEntryIterator() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        final Iterator<Map.Entry<K, Collection<V>>> f2646a;
        K b;
        Collection<V> c;
        Iterator<V> d;

        b() {
            this.f2646a = AbstractMultimap.this.f2642a.entrySet().iterator();
            if (this.f2646a.hasNext()) {
                a();
            } else {
                this.d = Iterators.c();
            }
        }

        void a() {
            Map.Entry<K, Collection<V>> next = this.f2646a.next();
            this.b = next.getKey();
            this.c = next.getValue();
            this.d = this.c.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2646a.hasNext() || this.d.hasNext();
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!this.d.hasNext()) {
                a();
            }
            return Maps.a(this.b, this.d.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.d.remove();
            if (this.c.isEmpty()) {
                this.f2646a.remove();
            }
            AbstractMultimap.access$210(AbstractMultimap.this);
        }
    }

    @Override // com.google.common.collect.Multimap
    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> map = this.g;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> b2 = b();
        this.g = b2;
        return b2;
    }

    private Map<K, Collection<V>> b() {
        return this.f2642a instanceof SortedMap ? new e((SortedMap) this.f2642a) : new a(this.f2642a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends AbstractMap<K, Collection<V>> {

        /* renamed from: a, reason: collision with root package name */
        final transient Map<K, Collection<V>> f2643a;
        transient Set<Map.Entry<K, Collection<V>>> b;

        a(Map<K, Collection<V>> map) {
            this.f2643a = map;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, Collection<V>>> entrySet() {
            Set<Map.Entry<K, Collection<V>>> set = this.b;
            if (set != null) {
                return set;
            }
            C0048a c0048a = new C0048a();
            this.b = c0048a;
            return c0048a;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return Maps.b((Map<?, ?>) this.f2643a, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection<V> get(Object obj) {
            Collection collection = (Collection) Maps.a((Map) this.f2643a, obj);
            if (collection != null) {
                return AbstractMultimap.this.a(obj, collection);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return AbstractMultimap.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f2643a.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Collection<V> remove(Object obj) {
            Collection<V> remove = this.f2643a.remove(obj);
            if (remove == null) {
                return null;
            }
            Collection<V> createCollection = AbstractMultimap.this.createCollection();
            createCollection.addAll(remove);
            AbstractMultimap.access$220(AbstractMultimap.this, remove.size());
            remove.clear();
            return createCollection;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(@Nullable Object obj) {
            return this == obj || this.f2643a.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f2643a.hashCode();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f2643a.toString();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f2643a == AbstractMultimap.this.f2642a) {
                AbstractMultimap.this.clear();
            } else {
                Iterators.d(new b());
            }
        }

        /* renamed from: com.google.common.collect.AbstractMultimap$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0048a extends Maps.a<K, Collection<V>> {
            C0048a() {
            }

            @Override // com.google.common.collect.Maps.a
            Map<K, Collection<V>> a() {
                return a.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new b();
            }

            @Override // com.google.common.collect.Maps.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return Collections2.a(a.this.f2643a.entrySet(), obj);
            }

            @Override // com.google.common.collect.Maps.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (contains(obj)) {
                    AbstractMultimap.this.b(((Map.Entry) obj).getKey());
                    return true;
                }
                return false;
            }
        }

        /* loaded from: classes2.dex */
        class b implements Iterator<Map.Entry<K, Collection<V>>> {

            /* renamed from: a, reason: collision with root package name */
            final Iterator<Map.Entry<K, Collection<V>>> f2645a;
            Collection<V> b;

            b() {
                this.f2645a = a.this.f2643a.entrySet().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f2645a.hasNext();
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry<K, Collection<V>> next = this.f2645a.next();
                K key = next.getKey();
                this.b = next.getValue();
                return Maps.a(key, AbstractMultimap.this.a(key, this.b));
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f2645a.remove();
                AbstractMultimap.access$220(AbstractMultimap.this, this.b.size());
                this.b.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e extends AbstractMultimap<K, V>.a implements SortedMap<K, Collection<V>> {
        SortedSet<K> d;

        e(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        SortedMap<K, Collection<V>> a() {
            return (SortedMap) this.f2643a;
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return a().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return a().firstKey();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return a().lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, Collection<V>> headMap(K k) {
            return new e(a().headMap(k));
        }

        @Override // java.util.SortedMap
        public SortedMap<K, Collection<V>> subMap(K k, K k2) {
            return new e(a().subMap(k, k2));
        }

        @Override // java.util.SortedMap
        public SortedMap<K, Collection<V>> tailMap(K k) {
            return new e(a().tailMap(k));
        }

        @Override // com.google.common.collect.AbstractMultimap.a, java.util.AbstractMap, java.util.Map
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.d;
            if (sortedSet != null) {
                return sortedSet;
            }
            f fVar = new f(a());
            this.d = fVar;
            return fVar;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Multimap) {
            return this.f2642a.equals(((Multimap) obj).asMap());
        }
        return false;
    }

    public int hashCode() {
        return this.f2642a.hashCode();
    }

    public String toString() {
        return this.f2642a.toString();
    }
}
