package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public class TreeBasedTable<R, C, V> extends StandardRowSortedTable<R, C, V> {
    private static final long serialVersionUID = 0;
    private final Comparator<? super C> columnComparator;

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return super.column(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.common.collect.StandardTable
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2, Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ void putAll(Table table) {
        super.putAll(table);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map row(Object obj) {
        return row((TreeBasedTable<R, C, V>) obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.StandardTable
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    /* loaded from: classes2.dex */
    private static class Factory<C, V> implements Supplier<TreeMap<C, V>>, Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super C> comparator;

        Factory(Comparator<? super C> comparator) {
            this.comparator = comparator;
        }

        @Override // com.google.common.base.Supplier
        public TreeMap<C, V> get() {
            return new TreeMap<>(this.comparator);
        }
    }

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        return new TreeBasedTable<>(Ordering.natural(), Ordering.natural());
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        Preconditions.a(comparator);
        Preconditions.a(comparator2);
        return new TreeBasedTable<>(comparator, comparator2);
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> treeBasedTable) {
        TreeBasedTable<R, C, V> treeBasedTable2 = new TreeBasedTable<>(treeBasedTable.rowComparator(), treeBasedTable.columnComparator());
        treeBasedTable2.putAll(treeBasedTable);
        return treeBasedTable2;
    }

    TreeBasedTable(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        super(new TreeMap(comparator), new Factory(comparator2));
        this.columnComparator = comparator2;
    }

    public Comparator<? super R> rowComparator() {
        return rowKeySet().comparator();
    }

    public Comparator<? super C> columnComparator() {
        return this.columnComparator;
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public SortedMap<C, V> row(R r) {
        return new a(this, r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends StandardTable<R, C, V>.g implements SortedMap<C, V> {

        @Nullable
        final C f;

        @Nullable
        final C g;
        transient SortedMap<C, V> h;

        a(TreeBasedTable treeBasedTable, R r) {
            this(r, null, null);
        }

        a(R r, C c, @Nullable C c2) {
            super(r);
            this.f = c;
            this.g = c2;
            Preconditions.a(c == null || c2 == null || a(c, c2) <= 0);
        }

        @Override // java.util.SortedMap
        public Comparator<? super C> comparator() {
            return TreeBasedTable.this.columnComparator();
        }

        int a(Object obj, Object obj2) {
            return comparator().compare(obj, obj2);
        }

        boolean a(@Nullable Object obj) {
            return obj != null && (this.f == null || a(this.f, obj) <= 0) && (this.g == null || a(this.g, obj) > 0);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> subMap(C c, C c2) {
            Preconditions.a(a(Preconditions.a(c)) && a(Preconditions.a(c2)));
            return new a(this.f2776a, c, c2);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> headMap(C c) {
            Preconditions.a(a(Preconditions.a(c)));
            return new a(this.f2776a, this.f, c);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> tailMap(C c) {
            Preconditions.a(a(Preconditions.a(c)));
            return new a(this.f2776a, c, this.g);
        }

        @Override // java.util.SortedMap
        public C firstKey() {
            if (a() == null) {
                throw new NoSuchElementException();
            }
            return a().firstKey();
        }

        @Override // java.util.SortedMap
        public C lastKey() {
            if (a() == null) {
                throw new NoSuchElementException();
            }
            return a().lastKey();
        }

        SortedMap<C, V> d() {
            if (this.h == null || (this.h.isEmpty() && TreeBasedTable.this.backingMap.containsKey(this.f2776a))) {
                this.h = (SortedMap) TreeBasedTable.this.backingMap.get(this.f2776a);
            }
            return this.h;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.StandardTable.g
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public SortedMap<C, V> a() {
            return (SortedMap) super.a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.StandardTable.g
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public SortedMap<C, V> b() {
            SortedMap<C, V> d = d();
            if (d == null) {
                return null;
            }
            if (this.f != null) {
                d = d.tailMap(this.f);
            }
            if (this.g != null) {
                return d.headMap(this.g);
            }
            return d;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.StandardTable.g
        public void c() {
            if (d() != null && this.h.isEmpty()) {
                TreeBasedTable.this.backingMap.remove(this.f2776a);
                this.h = null;
                this.b = null;
            }
        }

        @Override // com.google.common.collect.StandardTable.g, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return a(obj) && super.containsKey(obj);
        }

        @Override // com.google.common.collect.StandardTable.g, java.util.AbstractMap, java.util.Map
        public V put(C c, V v) {
            Preconditions.a(a(Preconditions.a(c)));
            return (V) super.put(c, v);
        }
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.Table
    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.Table
    public SortedMap<R, Map<C, V>> rowMap() {
        return super.rowMap();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public boolean contains(@Nullable Object obj, @Nullable Object obj2) {
        return super.contains(obj, obj2);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public boolean containsColumn(@Nullable Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public boolean containsRow(@Nullable Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public boolean containsValue(@Nullable Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public V get(@Nullable Object obj, @Nullable Object obj2) {
        return (V) super.get(obj, obj2);
    }

    @Override // com.google.common.collect.StandardTable
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public V remove(@Nullable Object obj, @Nullable Object obj2) {
        return (V) super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.StandardTable
    Iterator<C> createColumnKeyIterator() {
        Comparator<? super C> columnComparator = columnComparator();
        return new dn(this, Iterators.a(Iterables.a((Iterable) this.backingMap.values(), (Function) new dm(this)), columnComparator), columnComparator);
    }
}
