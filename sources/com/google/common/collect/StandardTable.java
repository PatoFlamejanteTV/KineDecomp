package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes2.dex */
public class StandardTable<R, C, V> extends AbstractC1542s<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final Map<R, Map<C, V>> backingMap;

    /* renamed from: c, reason: collision with root package name */
    private transient Set<C> f15672c;

    /* renamed from: d, reason: collision with root package name */
    private transient Map<R, Map<C, V>> f15673d;

    /* renamed from: e, reason: collision with root package name */
    private transient StandardTable<R, C, V>.e f15674e;
    final Supplier<? extends Map<C, V>> factory;

    /* loaded from: classes2.dex */
    private class a implements Iterator<Table.Cell<R, C, V>> {

        /* renamed from: a, reason: collision with root package name */
        final Iterator<Map.Entry<R, Map<C, V>>> f15675a;

        /* renamed from: b, reason: collision with root package name */
        Map.Entry<R, Map<C, V>> f15676b;

        /* renamed from: c, reason: collision with root package name */
        Iterator<Map.Entry<C, V>> f15677c;

        private a() {
            this.f15675a = StandardTable.this.backingMap.entrySet().iterator();
            this.f15677c = Iterators.c();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f15675a.hasNext() || this.f15677c.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f15677c.remove();
            if (this.f15676b.getValue().isEmpty()) {
                this.f15675a.remove();
            }
        }

        @Override // java.util.Iterator
        public Table.Cell<R, C, V> next() {
            if (!this.f15677c.hasNext()) {
                this.f15676b = this.f15675a.next();
                this.f15677c = this.f15676b.getValue().entrySet().iterator();
            }
            Map.Entry<C, V> next = this.f15677c.next();
            return Tables.a(this.f15676b.getKey(), next.getKey(), next.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends AbstractIterator<C> {

        /* renamed from: c, reason: collision with root package name */
        final Map<C, V> f15686c;

        /* renamed from: d, reason: collision with root package name */
        final Iterator<Map<C, V>> f15687d;

        /* renamed from: e, reason: collision with root package name */
        Iterator<Map.Entry<C, V>> f15688e;

        private c() {
            this.f15686c = StandardTable.this.factory.get();
            this.f15687d = StandardTable.this.backingMap.values().iterator();
            this.f15688e = Iterators.a();
        }

        @Override // com.google.common.collect.AbstractIterator
        protected C b() {
            while (true) {
                if (this.f15688e.hasNext()) {
                    Map.Entry<C, V> next = this.f15688e.next();
                    if (!this.f15686c.containsKey(next.getKey())) {
                        this.f15686c.put(next.getKey(), next.getValue());
                        return next.getKey();
                    }
                } else if (this.f15687d.hasNext()) {
                    this.f15688e = this.f15687d.next().entrySet().iterator();
                } else {
                    return c();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d extends StandardTable<R, C, V>.h<C> {
        private d() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return StandardTable.this.containsColumn(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<C> iterator() {
            return StandardTable.this.createColumnKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean z = false;
            if (obj == null) {
                return false;
            }
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().remove(obj)) {
                    z = true;
                    if (next.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Sets.b, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            Preconditions.a(collection);
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (Iterators.a((Iterator<?>) next.keySet().iterator(), collection)) {
                    z = true;
                    if (next.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Sets.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            Preconditions.a(collection);
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().retainAll(collection)) {
                    z = true;
                    if (next.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Iterators.g(iterator());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e extends Maps.j<C, Map<R, V>> {

        /* loaded from: classes2.dex */
        class a extends StandardTable<R, C, V>.h<Map.Entry<C, Map<R, V>>> {
            a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (!StandardTable.this.containsColumn(entry.getKey())) {
                    return false;
                }
                return e.this.get(entry.getKey()).equals(entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return Maps.b((Set) StandardTable.this.columnKeySet(), (Function) new vb(this));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                StandardTable.this.b(((Map.Entry) obj).getKey());
                return true;
            }

            @Override // com.google.common.collect.Sets.b, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                Preconditions.a(collection);
                return Sets.a((Set<?>) this, collection.iterator());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Sets.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                Preconditions.a(collection);
                Iterator it = Lists.a(StandardTable.this.columnKeySet().iterator()).iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!collection.contains(Maps.a(next, StandardTable.this.column(next)))) {
                        StandardTable.this.b(next);
                        z = true;
                    }
                }
                return z;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return StandardTable.this.columnKeySet().size();
            }
        }

        /* loaded from: classes2.dex */
        private class b extends Maps.i<C, Map<R, V>> {
            b() {
                super(e.this);
            }

            @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                for (Map.Entry<C, Map<R, V>> entry : e.this.entrySet()) {
                    if (entry.getValue().equals(obj)) {
                        StandardTable.this.b(entry.getKey());
                        return true;
                    }
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                Preconditions.a(collection);
                Iterator it = Lists.a(StandardTable.this.columnKeySet().iterator()).iterator();
                boolean z = false;
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
            @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                Preconditions.a(collection);
                Iterator it = Lists.a(StandardTable.this.columnKeySet().iterator()).iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!collection.contains(StandardTable.this.column(next))) {
                        StandardTable.this.b(next);
                        z = true;
                    }
                }
                return z;
            }
        }

        private e() {
        }

        @Override // com.google.common.collect.Maps.j
        public Set<Map.Entry<C, Map<R, V>>> a() {
            return new a();
        }

        @Override // com.google.common.collect.Maps.j
        Collection<Map<R, V>> c() {
            return new b();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.containsColumn(obj);
        }

        @Override // com.google.common.collect.Maps.j, java.util.AbstractMap, java.util.Map
        public Set<C> keySet() {
            return StandardTable.this.columnKeySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Map<R, V> get(Object obj) {
            if (StandardTable.this.containsColumn(obj)) {
                return StandardTable.this.column(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Map<R, V> remove(Object obj) {
            if (StandardTable.this.containsColumn(obj)) {
                return StandardTable.this.b(obj);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f extends Maps.d<C, V> {

        /* renamed from: a, reason: collision with root package name */
        final R f15694a;

        /* renamed from: b, reason: collision with root package name */
        Map<C, V> f15695b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(R r) {
            Preconditions.a(r);
            this.f15694a = r;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Map<C, V> a() {
            Map<C, V> map = this.f15695b;
            if (map != null && (!map.isEmpty() || !StandardTable.this.backingMap.containsKey(this.f15694a))) {
                return this.f15695b;
            }
            Map<C, V> b2 = b();
            this.f15695b = b2;
            return b2;
        }

        Map<C, V> b() {
            return StandardTable.this.backingMap.get(this.f15694a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c() {
            if (a() == null || !this.f15695b.isEmpty()) {
                return;
            }
            StandardTable.this.backingMap.remove(this.f15694a);
            this.f15695b = null;
        }

        @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
        public void clear() {
            Map<C, V> a2 = a();
            if (a2 != null) {
                a2.clear();
            }
            c();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            Map<C, V> a2 = a();
            return (obj == null || a2 == null || !Maps.d(a2, obj)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.d
        public Iterator<Map.Entry<C, V>> entryIterator() {
            Map<C, V> a2 = a();
            if (a2 == null) {
                return Iterators.c();
            }
            return new xb(this, a2.entrySet().iterator());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            Map<C, V> a2 = a();
            if (obj == null || a2 == null) {
                return null;
            }
            return (V) Maps.e(a2, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(C c2, V v) {
            Preconditions.a(c2);
            Preconditions.a(v);
            Map<C, V> map = this.f15695b;
            if (map != null && !map.isEmpty()) {
                return this.f15695b.put(c2, v);
            }
            return (V) StandardTable.this.put(this.f15694a, c2, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            Map<C, V> a2 = a();
            if (a2 == null) {
                return null;
            }
            V v = (V) Maps.f(a2, obj);
            c();
            return v;
        }

        @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
        public int size() {
            Map<C, V> a2 = a();
            if (a2 == null) {
                return 0;
            }
            return a2.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g extends Maps.j<R, Map<C, V>> {

        /* loaded from: classes2.dex */
        class a extends StandardTable<R, C, V>.h<Map.Entry<R, Map<C, V>>> {
            a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && Collections2.a(StandardTable.this.backingMap.entrySet(), entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return Maps.b((Set) StandardTable.this.backingMap.keySet(), (Function) new yb(this));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && StandardTable.this.backingMap.entrySet().remove(entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return StandardTable.this.backingMap.size();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public g() {
        }

        @Override // com.google.common.collect.Maps.j
        protected Set<Map.Entry<R, Map<C, V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.containsRow(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Map<C, V> get(Object obj) {
            if (StandardTable.this.containsRow(obj)) {
                return StandardTable.this.row(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Map<C, V> remove(Object obj) {
            if (obj == null) {
                return null;
            }
            return StandardTable.this.backingMap.remove(obj);
        }
    }

    /* loaded from: classes2.dex */
    private abstract class h<T> extends Sets.b<T> {
        private h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StandardTable.this.backingMap.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return StandardTable.this.backingMap.isEmpty();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StandardTable(Map<R, Map<C, V>> map, Supplier<? extends Map<C, V>> supplier) {
        this.backingMap = map;
        this.factory = supplier;
    }

    private Map<C, V> a(R r) {
        Map<C, V> map = this.backingMap.get(r);
        if (map != null) {
            return map;
        }
        Map<C, V> map2 = this.factory.get();
        this.backingMap.put(r, map2);
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
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

    @Override // com.google.common.collect.AbstractC1542s
    Iterator<Table.Cell<R, C, V>> cellIterator() {
        return new a();
    }

    @Override // com.google.common.collect.AbstractC1542s, com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.AbstractC1542s
    public void clear() {
        this.backingMap.clear();
    }

    public Map<R, V> column(C c2) {
        return new b(c2);
    }

    @Override // com.google.common.collect.AbstractC1542s, com.google.common.collect.Table
    public Set<C> columnKeySet() {
        Set<C> set = this.f15672c;
        if (set != null) {
            return set;
        }
        d dVar = new d();
        this.f15672c = dVar;
        return dVar;
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        StandardTable<R, C, V>.e eVar = this.f15674e;
        if (eVar != null) {
            return eVar;
        }
        StandardTable<R, C, V>.e eVar2 = new e();
        this.f15674e = eVar2;
        return eVar2;
    }

    @Override // com.google.common.collect.AbstractC1542s
    public boolean contains(@Nullable Object obj, @Nullable Object obj2) {
        return (obj == null || obj2 == null || !super.contains(obj, obj2)) ? false : true;
    }

    @Override // com.google.common.collect.AbstractC1542s
    public boolean containsColumn(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        Iterator<Map<C, V>> it = this.backingMap.values().iterator();
        while (it.hasNext()) {
            if (Maps.d(it.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractC1542s
    public boolean containsRow(@Nullable Object obj) {
        return obj != null && Maps.d(this.backingMap, obj);
    }

    @Override // com.google.common.collect.AbstractC1542s
    public boolean containsValue(@Nullable Object obj) {
        return obj != null && super.containsValue(obj);
    }

    Iterator<C> createColumnKeyIterator() {
        return new c();
    }

    Map<R, Map<C, V>> createRowMap() {
        return new g();
    }

    @Override // com.google.common.collect.AbstractC1542s
    public V get(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        return (V) super.get(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractC1542s
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override // com.google.common.collect.AbstractC1542s
    @CanIgnoreReturnValue
    public V put(R r, C c2, V v) {
        Preconditions.a(r);
        Preconditions.a(c2);
        Preconditions.a(v);
        return a(r).put(c2, v);
    }

    @Override // com.google.common.collect.AbstractC1542s
    @CanIgnoreReturnValue
    public V remove(@Nullable Object obj, @Nullable Object obj2) {
        Map map;
        if (obj == null || obj2 == null || (map = (Map) Maps.e(this.backingMap, obj)) == null) {
            return null;
        }
        V v = (V) map.remove(obj2);
        if (map.isEmpty()) {
            this.backingMap.remove(obj);
        }
        return v;
    }

    public Map<C, V> row(R r) {
        return new f(r);
    }

    @Override // com.google.common.collect.AbstractC1542s, com.google.common.collect.Table
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.Table
    public Map<R, Map<C, V>> rowMap() {
        Map<R, Map<C, V>> map = this.f15673d;
        if (map != null) {
            return map;
        }
        Map<R, Map<C, V>> createRowMap = createRowMap();
        this.f15673d = createRowMap;
        return createRowMap;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        Iterator<Map<C, V>> it = this.backingMap.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().size();
        }
        return i;
    }

    @Override // com.google.common.collect.AbstractC1542s
    public Collection<V> values() {
        return super.values();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Object obj, Object obj2, Object obj3) {
        return obj3 != null && obj3.equals(get(obj, obj2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends Maps.j<R, V> {

        /* renamed from: d, reason: collision with root package name */
        final C f15679d;

        /* loaded from: classes2.dex */
        private class a extends Sets.b<Map.Entry<R, V>> {
            private a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                b.this.a(Predicates.b());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return StandardTable.this.a(entry.getKey(), b.this.f15679d, entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                b bVar = b.this;
                return !StandardTable.this.containsColumn(bVar.f15679d);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, V>> iterator() {
                return new C0091b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return StandardTable.this.b(entry.getKey(), b.this.f15679d, entry.getValue());
            }

            @Override // com.google.common.collect.Sets.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return b.this.a(Predicates.a(Predicates.a((Collection) collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
                int i = 0;
                while (it.hasNext()) {
                    if (it.next().containsKey(b.this.f15679d)) {
                        i++;
                    }
                }
                return i;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.common.collect.StandardTable$b$b, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0091b extends AbstractIterator<Map.Entry<R, V>> {

            /* renamed from: c, reason: collision with root package name */
            final Iterator<Map.Entry<R, Map<C, V>>> f15682c;

            private C0091b() {
                this.f15682c = StandardTable.this.backingMap.entrySet().iterator();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            public Map.Entry<R, V> b() {
                while (this.f15682c.hasNext()) {
                    Map.Entry<R, Map<C, V>> next = this.f15682c.next();
                    if (next.getValue().containsKey(b.this.f15679d)) {
                        return new C1550ub(this, next);
                    }
                }
                return c();
            }
        }

        /* loaded from: classes2.dex */
        private class c extends Maps.e<R, V> {
            c() {
                super(b.this);
            }

            @Override // com.google.common.collect.Maps.e, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                b bVar = b.this;
                return StandardTable.this.contains(obj, bVar.f15679d);
            }

            @Override // com.google.common.collect.Maps.e, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                b bVar = b.this;
                return StandardTable.this.remove(obj, bVar.f15679d) != null;
            }

            @Override // com.google.common.collect.Sets.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return b.this.a(Maps.a(Predicates.a(Predicates.a((Collection) collection))));
            }
        }

        /* loaded from: classes2.dex */
        private class d extends Maps.i<R, V> {
            d() {
                super(b.this);
            }

            @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                return obj != null && b.this.a(Maps.b(Predicates.a(obj)));
            }

            @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                return b.this.a(Maps.b(Predicates.a((Collection) collection)));
            }

            @Override // com.google.common.collect.Maps.i, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                return b.this.a(Maps.b(Predicates.a(Predicates.a((Collection) collection))));
            }
        }

        b(C c2) {
            Preconditions.a(c2);
            this.f15679d = c2;
        }

        @CanIgnoreReturnValue
        boolean a(Predicate<? super Map.Entry<R, V>> predicate) {
            Iterator<Map.Entry<R, Map<C, V>>> it = StandardTable.this.backingMap.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry<R, Map<C, V>> next = it.next();
                Map<C, V> value = next.getValue();
                V v = value.get(this.f15679d);
                if (v != null && predicate.apply(Maps.a(next.getKey(), v))) {
                    value.remove(this.f15679d);
                    z = true;
                    if (value.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Maps.j
        Set<R> b() {
            return new c();
        }

        @Override // com.google.common.collect.Maps.j
        Collection<V> c() {
            return new d();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.contains(obj, this.f15679d);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            return (V) StandardTable.this.get(obj, this.f15679d);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(R r, V v) {
            return (V) StandardTable.this.put(r, this.f15679d, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            return (V) StandardTable.this.remove(obj, this.f15679d);
        }

        @Override // com.google.common.collect.Maps.j
        Set<Map.Entry<R, V>> a() {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(Object obj, Object obj2, Object obj3) {
        if (!a(obj, obj2, obj3)) {
            return false;
        }
        remove(obj, obj2);
        return true;
    }
}
