package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: AbstractTable.java */
@GwtCompatible
/* renamed from: com.google.common.collect.s */
/* loaded from: classes2.dex */
public abstract class AbstractC1542s<R, C, V> implements Table<R, C, V> {

    /* renamed from: a */
    private transient Set<Table.Cell<R, C, V>> f15836a;

    /* renamed from: b */
    private transient Collection<V> f15837b;

    /* compiled from: AbstractTable.java */
    /* renamed from: com.google.common.collect.s$a */
    /* loaded from: classes2.dex */
    public class a extends AbstractSet<Table.Cell<R, C, V>> {
        a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractC1542s.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            Map map = (Map) Maps.e(AbstractC1542s.this.rowMap(), cell.getRowKey());
            return map != null && Collections2.a(map.entrySet(), Maps.a(cell.getColumnKey(), cell.getValue()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Table.Cell<R, C, V>> iterator() {
            return AbstractC1542s.this.cellIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@Nullable Object obj) {
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            Map map = (Map) Maps.e(AbstractC1542s.this.rowMap(), cell.getRowKey());
            return map != null && Collections2.b(map.entrySet(), Maps.a(cell.getColumnKey(), cell.getValue()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractC1542s.this.size();
        }
    }

    /* compiled from: AbstractTable.java */
    /* renamed from: com.google.common.collect.s$b */
    /* loaded from: classes2.dex */
    public class b extends AbstractCollection<V> {
        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractC1542s.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC1542s.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return AbstractC1542s.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractC1542s.this.size();
        }
    }

    abstract Iterator<Table.Cell<R, C, V>> cellIterator();

    @Override // com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        Set<Table.Cell<R, C, V>> set = this.f15836a;
        if (set != null) {
            return set;
        }
        Set<Table.Cell<R, C, V>> createCellSet = createCellSet();
        this.f15836a = createCellSet;
        return createCellSet;
    }

    public abstract void clear();

    @Override // com.google.common.collect.Table
    public abstract Set<C> columnKeySet();

    public boolean contains(@Nullable Object obj, @Nullable Object obj2) {
        Map map = (Map) Maps.e(rowMap(), obj);
        return map != null && Maps.d(map, obj2);
    }

    public boolean containsColumn(@Nullable Object obj) {
        return Maps.d(columnMap(), obj);
    }

    public boolean containsRow(@Nullable Object obj) {
        return Maps.d(rowMap(), obj);
    }

    public boolean containsValue(@Nullable Object obj) {
        Iterator<Map<C, V>> it = rowMap().values().iterator();
        while (it.hasNext()) {
            if (it.next().containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    Set<Table.Cell<R, C, V>> createCellSet() {
        return new a();
    }

    Collection<V> createValues() {
        return new b();
    }

    @Override // com.google.common.collect.Table
    public boolean equals(@Nullable Object obj) {
        return Tables.a(this, obj);
    }

    public V get(@Nullable Object obj, @Nullable Object obj2) {
        Map map = (Map) Maps.e(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return (V) Maps.e(map, obj2);
    }

    @Override // com.google.common.collect.Table
    public int hashCode() {
        return cellSet().hashCode();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @CanIgnoreReturnValue
    public abstract V put(R r, C c2, V v);

    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        for (Table.Cell<? extends R, ? extends C, ? extends V> cell : table.cellSet()) {
            put(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
        }
    }

    @CanIgnoreReturnValue
    public abstract V remove(@Nullable Object obj, @Nullable Object obj2);

    @Override // com.google.common.collect.Table
    public abstract Set<R> rowKeySet();

    public String toString() {
        return rowMap().toString();
    }

    public Collection<V> values() {
        Collection<V> collection = this.f15837b;
        if (collection != null) {
            return collection;
        }
        Collection<V> createValues = createValues();
        this.f15837b = createValues;
        return createValues;
    }

    Iterator<V> valuesIterator() {
        return new r(this, cellSet().iterator());
    }
}
