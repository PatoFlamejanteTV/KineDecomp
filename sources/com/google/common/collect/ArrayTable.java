package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
/* loaded from: classes.dex */
public final class ArrayTable<R, C, V> implements Table<R, C, V>, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    private transient ArrayTable<R, C, V>.b f2653a;
    private final V[][] array;
    private transient ArrayTable<R, C, V>.d b;
    private transient ArrayTable<R, C, V>.f c;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableList<C> columnList;
    private transient Collection<V> d;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableList<R> rowList;

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<>(iterable, iterable2);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Table<R, C, V> table) {
        return new ArrayTable<>(table);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(ArrayTable<R, C, V> arrayTable) {
        return new ArrayTable<>((ArrayTable) arrayTable);
    }

    private ArrayTable(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        this.rowList = ImmutableList.copyOf(iterable);
        this.columnList = ImmutableList.copyOf(iterable2);
        Preconditions.a(!this.rowList.isEmpty());
        Preconditions.a(this.columnList.isEmpty() ? false : true);
        this.rowKeyToIndex = a(this.rowList);
        this.columnKeyToIndex = a(this.columnList);
        this.array = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, this.rowList.size(), this.columnList.size()));
    }

    private static <E> ImmutableMap<E, Integer> a(List<E> list) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (int i = 0; i < list.size(); i++) {
            builder.b(list.get(i), Integer.valueOf(i));
        }
        return builder.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ArrayTable(Table<R, C, V> table) {
        this(table.rowKeySet(), table.columnKeySet());
        putAll(table);
    }

    private ArrayTable(ArrayTable<R, C, V> arrayTable) {
        this.rowList = arrayTable.rowList;
        this.columnList = arrayTable.columnList;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, this.rowList.size(), this.columnList.size()));
        this.array = vArr;
        for (int i = 0; i < this.rowList.size(); i++) {
            System.arraycopy(arrayTable.array[i], 0, vArr[i], 0, arrayTable.array[i].length);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class a<K, V> extends Maps.b<K, V> {

        /* renamed from: a, reason: collision with root package name */
        private final ImmutableMap<K, Integer> f2654a;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Nullable
        public abstract V a(int i, V v);

        abstract String a();

        /* JADX INFO: Access modifiers changed from: package-private */
        @Nullable
        public abstract V b(int i);

        private a(ImmutableMap<K, Integer> immutableMap) {
            this.f2654a = immutableMap;
        }

        @Override // com.google.common.collect.Maps.b, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f2654a.keySet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public K a(int i) {
            return this.f2654a.keySet().asList().get(i);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f2654a.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f2654a.isEmpty();
        }

        @Override // com.google.common.collect.Maps.b
        protected Set<Map.Entry<K, V>> b() {
            return new p(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@Nullable Object obj) {
            return this.f2654a.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(@Nullable Object obj) {
            Integer num = this.f2654a.get(obj);
            if (num == null) {
                return null;
            }
            return b(num.intValue());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            Integer num = this.f2654a.get(k);
            if (num == null) {
                throw new IllegalArgumentException(a() + " " + k + " not in " + this.f2654a.keySet());
            }
            return a(num.intValue(), v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    public V at(int i, int i2) {
        return this.array[i][i2];
    }

    public V set(int i, int i2, @Nullable V v) {
        V v2 = this.array[i][i2];
        this.array[i][i2] = v;
        return v2;
    }

    public V[][] toArray(Class<V> cls) {
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) cls, this.rowList.size(), this.columnList.size()));
        for (int i = 0; i < this.rowList.size(); i++) {
            System.arraycopy(this.array[i], 0, vArr[i], 0, this.array[i].length);
        }
        return vArr;
    }

    @Override // com.google.common.collect.Table
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public void eraseAll() {
        for (V[] vArr : this.array) {
            Arrays.fill(vArr, (Object) null);
        }
    }

    @Override // com.google.common.collect.Table
    public boolean contains(@Nullable Object obj, @Nullable Object obj2) {
        return containsRow(obj) && containsColumn(obj2);
    }

    @Override // com.google.common.collect.Table
    public boolean containsColumn(@Nullable Object obj) {
        return this.columnKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.Table
    public boolean containsRow(@Nullable Object obj) {
        return this.rowKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.Table
    public boolean containsValue(@Nullable Object obj) {
        for (V[] vArr : this.array) {
            for (V v : vArr) {
                if (Objects.a(obj, v)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.common.collect.Table
    public V get(@Nullable Object obj, @Nullable Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return this.array[num.intValue()][num2.intValue()];
    }

    @Override // com.google.common.collect.Table
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.Table
    public V put(R r, C c2, @Nullable V v) {
        Preconditions.a(r);
        Preconditions.a(c2);
        Integer num = this.rowKeyToIndex.get(r);
        Preconditions.a(num != null, "Row %s not in %s", r, this.rowList);
        Integer num2 = this.columnKeyToIndex.get(c2);
        Preconditions.a(num2 != null, "Column %s not in %s", c2, this.columnList);
        return set(num.intValue(), num2.intValue(), v);
    }

    @Override // com.google.common.collect.Table
    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        for (Table.Cell<? extends R, ? extends C, ? extends V> cell : table.cellSet()) {
            put(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
        }
    }

    @Override // com.google.common.collect.Table
    @Deprecated
    public V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public V erase(@Nullable Object obj, @Nullable Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return set(num.intValue(), num2.intValue(), null);
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    public boolean equals(@Nullable Object obj) {
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
    public Set<Table.Cell<R, C, V>> cellSet() {
        ArrayTable<R, C, V>.b bVar = this.f2653a;
        if (bVar != null) {
            return bVar;
        }
        ArrayTable<R, C, V>.b bVar2 = new b();
        this.f2653a = bVar2;
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends AbstractSet<Table.Cell<R, C, V>> {
        private b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Table.Cell<R, C, V>> iterator() {
            return new s(this, size());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ArrayTable.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            Integer num = (Integer) ArrayTable.this.rowKeyToIndex.get(cell.getRowKey());
            Integer num2 = (Integer) ArrayTable.this.columnKeyToIndex.get(cell.getColumnKey());
            return (num == null || num2 == null || !Objects.a(ArrayTable.this.array[num.intValue()][num2.intValue()], cell.getValue())) ? false : true;
        }
    }

    @Override // com.google.common.collect.Table
    public Map<R, V> column(C c2) {
        Preconditions.a(c2);
        Integer num = this.columnKeyToIndex.get(c2);
        return num == null ? ImmutableMap.of() : new c(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends a<R, V> {

        /* renamed from: a, reason: collision with root package name */
        final int f2656a;

        c(int i) {
            super(ArrayTable.this.rowKeyToIndex);
            this.f2656a = i;
        }

        @Override // com.google.common.collect.ArrayTable.a
        String a() {
            return "Row";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.a
        public V b(int i) {
            return (V) ArrayTable.this.at(i, this.f2656a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.a
        public V a(int i, V v) {
            return (V) ArrayTable.this.set(i, this.f2656a, v);
        }
    }

    @Override // com.google.common.collect.Table
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.d dVar = this.b;
        if (dVar != null) {
            return dVar;
        }
        ArrayTable<R, C, V>.d dVar2 = new d();
        this.b = dVar2;
        return dVar2;
    }

    /* loaded from: classes2.dex */
    private class d extends a<C, Map<R, V>> {
        @Override // com.google.common.collect.ArrayTable.a, java.util.AbstractMap, java.util.Map
        public /* synthetic */ Object put(Object obj, Object obj2) {
            return a((d) obj, (Map) obj2);
        }

        private d() {
            super(ArrayTable.this.columnKeyToIndex);
        }

        @Override // com.google.common.collect.ArrayTable.a
        String a() {
            return "Column";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map<R, V> b(int i) {
            return new c(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.a
        public Map<R, V> a(int i, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        public Map<R, V> a(C c, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.common.collect.Table
    public Map<C, V> row(R r) {
        Preconditions.a(r);
        Integer num = this.rowKeyToIndex.get(r);
        return num == null ? ImmutableMap.of() : new e(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e extends a<C, V> {

        /* renamed from: a, reason: collision with root package name */
        final int f2658a;

        e(int i) {
            super(ArrayTable.this.columnKeyToIndex);
            this.f2658a = i;
        }

        @Override // com.google.common.collect.ArrayTable.a
        String a() {
            return "Column";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.a
        public V b(int i) {
            return (V) ArrayTable.this.at(this.f2658a, i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.a
        public V a(int i, V v) {
            return (V) ArrayTable.this.set(this.f2658a, i, v);
        }
    }

    @Override // com.google.common.collect.Table
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.Table
    public Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.f fVar = this.c;
        if (fVar != null) {
            return fVar;
        }
        ArrayTable<R, C, V>.f fVar2 = new f();
        this.c = fVar2;
        return fVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class f extends a<R, Map<C, V>> {
        @Override // com.google.common.collect.ArrayTable.a, java.util.AbstractMap, java.util.Map
        public /* synthetic */ Object put(Object obj, Object obj2) {
            return a((f) obj, (Map) obj2);
        }

        private f() {
            super(ArrayTable.this.rowKeyToIndex);
        }

        @Override // com.google.common.collect.ArrayTable.a
        String a() {
            return "Row";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map<C, V> b(int i) {
            return new e(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.a
        public Map<C, V> a(int i, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        public Map<C, V> a(R r, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.common.collect.Table
    public Collection<V> values() {
        Collection<V> collection = this.d;
        if (collection != null) {
            return collection;
        }
        g gVar = new g();
        this.d = gVar;
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class g extends AbstractCollection<V> {
        private g() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new u(this, ArrayTable.this.cellSet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return ArrayTable.this.size();
        }
    }
}
