package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes2.dex */
public class StandardTable<R, C, V> implements Table<R, C, V>, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    private transient StandardTable<R, C, V>.b f2763a;
    private transient StandardTable<R, C, V>.h b;
    final Map<R, Map<C, V>> backingMap;
    private transient Set<C> c;
    private transient StandardTable<R, C, V>.l d;
    private transient StandardTable<R, C, V>.i e;
    private transient StandardTable<R, C, V>.f f;
    final Supplier<? extends Map<C, V>> factory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StandardTable(Map<R, Map<C, V>> map, Supplier<? extends Map<C, V>> supplier) {
        this.backingMap = map;
        this.factory = supplier;
    }

    @Override // com.google.common.collect.Table
    public boolean contains(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        Map map = (Map) Maps.a((Map) this.backingMap, obj);
        return map != null && Maps.b((Map<?, ?>) map, obj2);
    }

    @Override // com.google.common.collect.Table
    public boolean containsColumn(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        Iterator<Map<C, V>> it = this.backingMap.values().iterator();
        while (it.hasNext()) {
            if (Maps.b((Map<?, ?>) it.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.Table
    public boolean containsRow(@Nullable Object obj) {
        return obj != null && Maps.b((Map<?, ?>) this.backingMap, obj);
    }

    @Override // com.google.common.collect.Table
    public boolean containsValue(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        Iterator<Map<C, V>> it = this.backingMap.values().iterator();
        while (it.hasNext()) {
            if (it.next().containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.Table
    public V get(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        Map map = (Map) Maps.a((Map) this.backingMap, obj);
        if (map == null) {
            return null;
        }
        return (V) Maps.a(map, obj2);
    }

    @Override // com.google.common.collect.Table
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override // com.google.common.collect.Table
    public int size() {
        int i2 = 0;
        Iterator<Map<C, V>> it = this.backingMap.values().iterator();
        while (true) {
            int i3 = i2;
            if (it.hasNext()) {
                i2 = it.next().size() + i3;
            } else {
                return i3;
            }
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Table) {
            return cellSet().equals(((Table) obj).cellSet());
        }
        return false;
    }

    public int hashCode() {
        return cellSet().hashCode();
    }

    public String toString() {
        return rowMap().toString();
    }

    @Override // com.google.common.collect.Table
    public void clear() {
        this.backingMap.clear();
    }

    private Map<C, V> a(R r) {
        Map<C, V> map = this.backingMap.get(r);
        if (map == null) {
            Map<C, V> map2 = this.factory.get();
            this.backingMap.put(r, map2);
            return map2;
        }
        return map;
    }

    @Override // com.google.common.collect.Table
    public V put(R r, C c2, V v) {
        Preconditions.a(r);
        Preconditions.a(c2);
        Preconditions.a(v);
        return a(r).put(c2, v);
    }

    @Override // com.google.common.collect.Table
    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        for (Table.Cell<? extends R, ? extends C, ? extends V> cell : table.cellSet()) {
            put(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
        }
    }

    @Override // com.google.common.collect.Table
    public V remove(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        Map map = (Map) Maps.a((Map) this.backingMap, obj);
        if (map == null) {
            return null;
        }
        V v = (V) map.remove(obj2);
        if (map.isEmpty()) {
            this.backingMap.remove(obj);
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<R, V> b(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<R, Map<C, V>>> it = this.backingMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<R, Map<C, V>> next = it.next();
            V remove = next.getValue().remove(obj);
            if (remove != null) {
                linkedHashMap.put(next.getKey(), remove);
                if (next.getValue().isEmpty()) {
                    it.remove();
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Object obj, Object obj2, Object obj3) {
        return obj3 != null && obj3.equals(get(obj, obj2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(Object obj, Object obj2, Object obj3) {
        if (!a(obj, obj2, obj3)) {
            return false;
        }
        remove(obj, obj2);
        return true;
    }

    /* loaded from: classes2.dex */
    private abstract class j<T> extends AbstractCollection<T> {
        private j() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return StandardTable.this.backingMap.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            StandardTable.this.backingMap.clear();
        }
    }

    /* loaded from: classes2.dex */
    private abstract class k<T> extends AbstractSet<T> {
        private k() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return StandardTable.this.backingMap.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StandardTable.this.backingMap.clear();
        }
    }

    @Override // com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        StandardTable<R, C, V>.b bVar = this.f2763a;
        if (bVar != null) {
            return bVar;
        }
        StandardTable<R, C, V>.b bVar2 = new b();
        this.f2763a = bVar2;
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends StandardTable<R, C, V>.k<Table.Cell<R, C, V>> {
        private b() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Table.Cell<R, C, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return StandardTable.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            return StandardTable.this.a(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            return StandardTable.this.b(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
        }
    }

    /* loaded from: classes2.dex */
    private class a implements Iterator<Table.Cell<R, C, V>> {

        /* renamed from: a, reason: collision with root package name */
        final Iterator<Map.Entry<R, Map<C, V>>> f2764a;
        Map.Entry<R, Map<C, V>> b;
        Iterator<Map.Entry<C, V>> c;

        private a() {
            this.f2764a = StandardTable.this.backingMap.entrySet().iterator();
            this.c = Iterators.c();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2764a.hasNext() || this.c.hasNext();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Table.Cell<R, C, V> next() {
            if (!this.c.hasNext()) {
                this.b = this.f2764a.next();
                this.c = this.b.getValue().entrySet().iterator();
            }
            Map.Entry<C, V> next = this.c.next();
            return Tables.a(this.b.getKey(), next.getKey(), next.getValue());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.c.remove();
            if (this.b.getValue().isEmpty()) {
                this.f2764a.remove();
            }
        }
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(R r) {
        return new g(r);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g extends AbstractMap<C, V> {

        /* renamed from: a, reason: collision with root package name */
        final R f2776a;
        Map<C, V> b;
        Set<C> c;
        Set<Map.Entry<C, V>> d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(R r) {
            this.f2776a = (R) Preconditions.a(r);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Map<C, V> a() {
            if (this.b != null && (!this.b.isEmpty() || !StandardTable.this.backingMap.containsKey(this.f2776a))) {
                return this.b;
            }
            Map<C, V> b = b();
            this.b = b;
            return b;
        }

        Map<C, V> b() {
            return StandardTable.this.backingMap.get(this.f2776a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c() {
            if (a() != null && this.b.isEmpty()) {
                StandardTable.this.backingMap.remove(this.f2776a);
                this.b = null;
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            Map<C, V> a2 = a();
            return (obj == null || a2 == null || !Maps.b((Map<?, ?>) a2, obj)) ? false : true;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            Map<C, V> a2 = a();
            if (obj == null || a2 == null) {
                return null;
            }
            return (V) Maps.a((Map) a2, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(C c, V v) {
            Preconditions.a(c);
            Preconditions.a(v);
            return (this.b == null || this.b.isEmpty()) ? (V) StandardTable.this.put(this.f2776a, c, v) : this.b.put(c, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            try {
                Map<C, V> a2 = a();
                if (a2 == null) {
                    return null;
                }
                V remove = a2.remove(obj);
                c();
                return remove;
            } catch (ClassCastException e) {
                return null;
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Map<C, V> a2 = a();
            if (a2 != null) {
                a2.clear();
            }
            c();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<C> keySet() {
            Set<C> set = this.c;
            if (set == null) {
                dd ddVar = new dd(this);
                this.c = ddVar;
                return ddVar;
            }
            return set;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<C, V>> entrySet() {
            Set<Map.Entry<C, V>> set = this.d;
            if (set == null) {
                a aVar = new a();
                this.d = aVar;
                return aVar;
            }
            return set;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public class a extends Maps.a<C, V> {
            private a() {
            }

            @Override // com.google.common.collect.Maps.a
            Map<C, V> a() {
                return g.this;
            }

            @Override // com.google.common.collect.Maps.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                Map<C, V> a2 = g.this.a();
                if (a2 == null) {
                    return 0;
                }
                return a2.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<C, V>> iterator() {
                Map<C, V> a2 = g.this.a();
                if (a2 == null) {
                    return Iterators.c();
                }
                return new de(this, a2.entrySet().iterator());
            }
        }
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(C c2) {
        return new c(c2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends Maps.b<R, V> {

        /* renamed from: a, reason: collision with root package name */
        final C f2766a;
        StandardTable<R, C, V>.c.d b;
        StandardTable<R, C, V>.c.C0050c c;

        c(C c) {
            this.f2766a = (C) Preconditions.a(c);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(R r, V v) {
            return (V) StandardTable.this.put(r, this.f2766a, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            return (V) StandardTable.this.get(obj, this.f2766a);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.contains(obj, this.f2766a);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            return (V) StandardTable.this.remove(obj, this.f2766a);
        }

        @Override // com.google.common.collect.Maps.b
        public Set<Map.Entry<R, V>> b() {
            return new a();
        }

        @Override // com.google.common.collect.Maps.b, java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            StandardTable<R, C, V>.c.d dVar = this.b;
            if (dVar != null) {
                return dVar;
            }
            StandardTable<R, C, V>.c.d dVar2 = new d();
            this.b = dVar2;
            return dVar2;
        }

        boolean a(Predicate<? super Map.Entry<R, V>> predicate) {
            boolean z = false;
            Iterator<Map.Entry<R, Map<C, V>>> it = StandardTable.this.backingMap.entrySet().iterator();
            while (true) {
                boolean z2 = z;
                if (it.hasNext()) {
                    Map.Entry<R, Map<C, V>> next = it.next();
                    Map<C, V> value = next.getValue();
                    V v = value.get(this.f2766a);
                    if (v != null && predicate.apply(new ImmutableEntry(next.getKey(), v))) {
                        value.remove(this.f2766a);
                        z2 = true;
                        if (value.isEmpty()) {
                            it.remove();
                        }
                    }
                    z = z2;
                } else {
                    return z2;
                }
            }
        }

        /* loaded from: classes2.dex */
        class a extends Sets.a<Map.Entry<R, V>> {
            a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, V>> iterator() {
                return new b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                int i = 0;
                Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
                while (true) {
                    int i2 = i;
                    if (it.hasNext()) {
                        i = it.next().containsKey(c.this.f2766a) ? i2 + 1 : i2;
                    } else {
                        return i2;
                    }
                }
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return !StandardTable.this.containsColumn(c.this.f2766a);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                c.this.a(Predicates.a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return StandardTable.this.a(entry.getKey(), c.this.f2766a, entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return StandardTable.this.b(entry.getKey(), c.this.f2766a, entry.getValue());
            }

            @Override // com.google.common.collect.Sets.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.a(Predicates.a(Predicates.a((Collection) collection)));
            }
        }

        /* loaded from: classes2.dex */
        class b extends AbstractIterator<Map.Entry<R, V>> {

            /* renamed from: a, reason: collision with root package name */
            final Iterator<Map.Entry<R, Map<C, V>>> f2768a;

            b() {
                this.f2768a = StandardTable.this.backingMap.entrySet().iterator();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public Map.Entry<R, V> a() {
                while (this.f2768a.hasNext()) {
                    Map.Entry<R, Map<C, V>> next = this.f2768a.next();
                    if (next.getValue().containsKey(c.this.f2766a)) {
                        return new cy(this, next);
                    }
                }
                return b();
            }
        }

        @Override // com.google.common.collect.Maps.b, java.util.AbstractMap, java.util.Map
        public Set<R> keySet() {
            StandardTable<R, C, V>.c.C0050c c0050c = this.c;
            if (c0050c != null) {
                return c0050c;
            }
            StandardTable<R, C, V>.c.C0050c c0050c2 = new C0050c();
            this.c = c0050c2;
            return c0050c2;
        }

        /* renamed from: com.google.common.collect.StandardTable$c$c, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0050c extends Sets.a<R> {
            C0050c() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<R> iterator() {
                return Maps.a(c.this.entrySet().iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return c.this.entrySet().size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return !StandardTable.this.containsColumn(c.this.f2766a);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return StandardTable.this.contains(obj, c.this.f2766a);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                return StandardTable.this.remove(obj, c.this.f2766a) != null;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                c.this.entrySet().clear();
            }

            @Override // com.google.common.collect.Sets.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                Preconditions.a(collection);
                return c.this.a(new cz(this, collection));
            }
        }

        /* loaded from: classes2.dex */
        class d extends AbstractCollection<V> {
            d() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<V> iterator() {
                return Maps.b(c.this.entrySet().iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return c.this.entrySet().size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public boolean isEmpty() {
                return !StandardTable.this.containsColumn(c.this.f2766a);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                c.this.entrySet().clear();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                if (obj == null) {
                    return false;
                }
                Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
                while (it.hasNext()) {
                    Map<C, V> next = it.next();
                    if (next.entrySet().remove(new ImmutableEntry(c.this.f2766a, obj))) {
                        if (next.isEmpty()) {
                            it.remove();
                        }
                        return true;
                    }
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                Preconditions.a(collection);
                return c.this.a(new da(this, collection));
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                Preconditions.a(collection);
                return c.this.a(new db(this, collection));
            }
        }
    }

    @Override // com.google.common.collect.Table
    public Set<R> rowKeySet() {
        StandardTable<R, C, V>.h hVar = this.b;
        if (hVar != null) {
            return hVar;
        }
        StandardTable<R, C, V>.h hVar2 = new h();
        this.b = hVar2;
        return hVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h extends StandardTable<R, C, V>.k<R> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public h() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<R> iterator() {
            return Maps.a(StandardTable.this.rowMap().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return StandardTable.this.backingMap.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return StandardTable.this.containsRow(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return (obj == null || StandardTable.this.backingMap.remove(obj) == null) ? false : true;
        }
    }

    @Override // com.google.common.collect.Table
    public Set<C> columnKeySet() {
        Set<C> set = this.c;
        if (set != null) {
            return set;
        }
        e eVar = new e();
        this.c = eVar;
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e extends StandardTable<R, C, V>.k<C> {
        private e() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<C> iterator() {
            return StandardTable.this.createColumnKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Iterators.a((Iterator<?>) iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean z = false;
            if (obj == null) {
                return false;
            }
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            while (true) {
                boolean z2 = z;
                if (!it.hasNext()) {
                    return z2;
                }
                Map<C, V> next = it.next();
                if (next.keySet().remove(obj)) {
                    z2 = true;
                    if (next.isEmpty()) {
                        it.remove();
                    }
                }
                z = z2;
            }
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            Preconditions.a(collection);
            boolean z = false;
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            while (true) {
                boolean z2 = z;
                if (it.hasNext()) {
                    Map<C, V> next = it.next();
                    if (Iterators.a((Iterator<?>) next.keySet().iterator(), collection)) {
                        z2 = true;
                        if (next.isEmpty()) {
                            it.remove();
                        }
                    }
                    z = z2;
                } else {
                    return z2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            Preconditions.a(collection);
            boolean z = false;
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            while (true) {
                boolean z2 = z;
                if (it.hasNext()) {
                    Map<C, V> next = it.next();
                    if (next.keySet().retainAll(collection)) {
                        z2 = true;
                        if (next.isEmpty()) {
                            it.remove();
                        }
                    }
                    z = z2;
                } else {
                    return z2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj == null) {
                return false;
            }
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            while (it.hasNext()) {
                if (it.next().containsKey(obj)) {
                    return true;
                }
            }
            return false;
        }
    }

    Iterator<C> createColumnKeyIterator() {
        return new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d extends AbstractIterator<C> {

        /* renamed from: a, reason: collision with root package name */
        final Map<C, V> f2771a;
        final Iterator<Map<C, V>> b;
        Iterator<Map.Entry<C, V>> c;

        private d() {
            this.f2771a = StandardTable.this.factory.get();
            this.b = StandardTable.this.backingMap.values().iterator();
            this.c = Iterators.a();
        }

        @Override // com.google.common.collect.AbstractIterator
        protected C a() {
            while (true) {
                if (this.c.hasNext()) {
                    Map.Entry<C, V> next = this.c.next();
                    if (!this.f2771a.containsKey(next.getKey())) {
                        this.f2771a.put(next.getKey(), next.getValue());
                        return next.getKey();
                    }
                } else if (this.b.hasNext()) {
                    this.c = this.b.next().entrySet().iterator();
                } else {
                    return b();
                }
            }
        }
    }

    @Override // com.google.common.collect.Table
    public Collection<V> values() {
        StandardTable<R, C, V>.l lVar = this.d;
        if (lVar != null) {
            return lVar;
        }
        StandardTable<R, C, V>.l lVar2 = new l();
        this.d = lVar2;
        return lVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class l extends StandardTable<R, C, V>.j<V> {
        private l() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new dh(this, StandardTable.this.cellSet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return StandardTable.this.size();
        }
    }

    @Override // com.google.common.collect.Table
    public Map<R, Map<C, V>> rowMap() {
        StandardTable<R, C, V>.i iVar = this.e;
        if (iVar != null) {
            return iVar;
        }
        StandardTable<R, C, V>.i iVar2 = new i();
        this.e = iVar2;
        return iVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i extends Maps.b<R, Map<C, V>> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public i() {
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.containsRow(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<C, V> get(Object obj) {
            if (StandardTable.this.containsRow(obj)) {
                return StandardTable.this.row(obj);
            }
            return null;
        }

        @Override // com.google.common.collect.Maps.b, java.util.AbstractMap, java.util.Map
        public Set<R> keySet() {
            return StandardTable.this.rowKeySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map<C, V> remove(Object obj) {
            if (obj == null) {
                return null;
            }
            return StandardTable.this.backingMap.remove(obj);
        }

        @Override // com.google.common.collect.Maps.b
        protected Set<Map.Entry<R, Map<C, V>>> b() {
            return new a();
        }

        /* loaded from: classes2.dex */
        class a extends StandardTable<R, C, V>.k<Map.Entry<R, Map<C, V>>> {
            a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return new dg(this, StandardTable.this.backingMap.keySet().iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return StandardTable.this.backingMap.size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && Collections2.a(StandardTable.this.backingMap.entrySet(), entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && StandardTable.this.backingMap.entrySet().remove(entry);
            }
        }
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        StandardTable<R, C, V>.f fVar = this.f;
        if (fVar != null) {
            return fVar;
        }
        StandardTable<R, C, V>.f fVar2 = new f();
        this.f = fVar2;
        return fVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class f extends Maps.b<C, Map<R, V>> {

        /* renamed from: a, reason: collision with root package name */
        StandardTable<R, C, V>.f.b f2773a;

        private f() {
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<R, V> get(Object obj) {
            if (StandardTable.this.containsColumn(obj)) {
                return StandardTable.this.column(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.containsColumn(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map<R, V> remove(Object obj) {
            if (StandardTable.this.containsColumn(obj)) {
                return StandardTable.this.b(obj);
            }
            return null;
        }

        @Override // com.google.common.collect.Maps.b
        public Set<Map.Entry<C, Map<R, V>>> b() {
            return new a();
        }

        @Override // com.google.common.collect.Maps.b, java.util.AbstractMap, java.util.Map
        public Set<C> keySet() {
            return StandardTable.this.columnKeySet();
        }

        @Override // com.google.common.collect.Maps.b, java.util.AbstractMap, java.util.Map
        public Collection<Map<R, V>> values() {
            StandardTable<R, C, V>.f.b bVar = this.f2773a;
            if (bVar != null) {
                return bVar;
            }
            StandardTable<R, C, V>.f.b bVar2 = new b();
            this.f2773a = bVar2;
            return bVar2;
        }

        /* loaded from: classes2.dex */
        class a extends StandardTable<R, C, V>.k<Map.Entry<C, Map<R, V>>> {
            a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return new dc(this, StandardTable.this.columnKeySet().iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return StandardTable.this.columnKeySet().size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    if (StandardTable.this.containsColumn(entry.getKey())) {
                        return f.this.get(entry.getKey()).equals(entry.getValue());
                    }
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                StandardTable.this.b(((Map.Entry) obj).getKey());
                return true;
            }

            @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                boolean z = false;
                Iterator<?> it = collection.iterator();
                while (it.hasNext()) {
                    z |= remove(it.next());
                }
                return z;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                boolean z = false;
                Iterator it = Lists.a(StandardTable.this.columnKeySet().iterator()).iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!collection.contains(new ImmutableEntry(next, StandardTable.this.column(next)))) {
                        StandardTable.this.b(next);
                        z = true;
                    }
                }
                return z;
            }
        }

        /* loaded from: classes2.dex */
        private class b extends StandardTable<R, C, V>.j<Map<R, V>> {
            private b() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<Map<R, V>> iterator() {
                return Maps.b(f.this.entrySet().iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                for (Map.Entry<C, Map<R, V>> entry : f.this.entrySet()) {
                    if (entry.getValue().equals(obj)) {
                        StandardTable.this.b(entry.getKey());
                        return true;
                    }
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                Preconditions.a(collection);
                boolean z = false;
                Iterator it = Lists.a(StandardTable.this.columnKeySet().iterator()).iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (collection.contains(StandardTable.this.column(next))) {
                        StandardTable.this.b(next);
                        z = true;
                    }
                }
                return z;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                Preconditions.a(collection);
                boolean z = false;
                Iterator it = Lists.a(StandardTable.this.columnKeySet().iterator()).iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!collection.contains(StandardTable.this.column(next))) {
                        StandardTable.this.b(next);
                        z = true;
                    }
                }
                return z;
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return StandardTable.this.columnKeySet().size();
            }
        }
    }
}
