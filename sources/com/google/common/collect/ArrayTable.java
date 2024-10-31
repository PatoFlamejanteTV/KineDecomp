package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
/* loaded from: classes2.dex */
public final class ArrayTable<R, C, V> extends AbstractC1542s<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;

    /* renamed from: c */
    private transient ArrayTable<R, C, V>.c f15331c;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableList<C> columnList;

    /* renamed from: d */
    private transient ArrayTable<R, C, V>.e f15332d;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableList<R> rowList;

    /* loaded from: classes2.dex */
    public static abstract class a<K, V> extends Maps.d<K, V> {

        /* renamed from: a */
        private final ImmutableMap<K, Integer> f15333a;

        /* synthetic */ a(ImmutableMap immutableMap, C1548u c1548u) {
            this(immutableMap);
        }

        public K a(int i) {
            return this.f15333a.keySet().asList().get(i);
        }

        @Nullable
        public abstract V a(int i, V v);

        abstract String a();

        @Nullable
        public abstract V b(int i);

        @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@Nullable Object obj) {
            return this.f15333a.containsKey(obj);
        }

        @Override // com.google.common.collect.Maps.d
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return new C1553w(this, size());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(@Nullable Object obj) {
            Integer num = this.f15333a.get(obj);
            if (num == null) {
                return null;
            }
            return b(num.intValue());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f15333a.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f15333a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            Integer num = this.f15333a.get(k);
            if (num != null) {
                return a(num.intValue(), v);
            }
            throw new IllegalArgumentException(a() + " " + k + " not in " + this.f15333a.keySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f15333a.size();
        }

        private a(ImmutableMap<K, Integer> immutableMap) {
            this.f15333a = immutableMap;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends a<R, V> {

        /* renamed from: b */
        final int f15334b;

        b(int i) {
            super(ArrayTable.this.rowKeyToIndex, null);
            this.f15334b = i;
        }

        @Override // com.google.common.collect.ArrayTable.a
        public V a(int i, V v) {
            return (V) ArrayTable.this.set(i, this.f15334b, v);
        }

        @Override // com.google.common.collect.ArrayTable.a
        String a() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.a
        public V b(int i) {
            return (V) ArrayTable.this.at(i, this.f15334b);
        }
    }

    /* loaded from: classes2.dex */
    private class c extends a<C, Map<R, V>> {
        /* synthetic */ c(ArrayTable arrayTable, C1548u c1548u) {
            this();
        }

        @Override // com.google.common.collect.ArrayTable.a
        public /* bridge */ /* synthetic */ Object a(int i, Object obj) {
            a(i, (Map) obj);
            throw null;
        }

        @Override // com.google.common.collect.ArrayTable.a
        String a() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.a, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            a((c) obj, (Map) obj2);
            throw null;
        }

        private c() {
            super(ArrayTable.this.columnKeyToIndex, null);
        }

        Map<R, V> a(int i, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.a
        public Map<R, V> b(int i) {
            return new b(i);
        }

        public Map<R, V> a(C c2, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes2.dex */
    public class d extends a<C, V> {

        /* renamed from: b */
        final int f15337b;

        d(int i) {
            super(ArrayTable.this.columnKeyToIndex, null);
            this.f15337b = i;
        }

        @Override // com.google.common.collect.ArrayTable.a
        public V a(int i, V v) {
            return (V) ArrayTable.this.set(this.f15337b, i, v);
        }

        @Override // com.google.common.collect.ArrayTable.a
        String a() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.a
        public V b(int i) {
            return (V) ArrayTable.this.at(this.f15337b, i);
        }
    }

    /* loaded from: classes2.dex */
    private class e extends a<R, Map<C, V>> {
        /* synthetic */ e(ArrayTable arrayTable, C1548u c1548u) {
            this();
        }

        @Override // com.google.common.collect.ArrayTable.a
        public /* bridge */ /* synthetic */ Object a(int i, Object obj) {
            a(i, (Map) obj);
            throw null;
        }

        @Override // com.google.common.collect.ArrayTable.a
        String a() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.a, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            a((e) obj, (Map) obj2);
            throw null;
        }

        private e() {
            super(ArrayTable.this.rowKeyToIndex, null);
        }

        Map<C, V> a(int i, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.a
        public Map<C, V> b(int i) {
            return new d(i);
        }

        public Map<C, V> a(R r, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }
    }

    private ArrayTable(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        this.rowList = ImmutableList.copyOf(iterable);
        this.columnList = ImmutableList.copyOf(iterable2);
        Preconditions.a(!this.rowList.isEmpty());
        Preconditions.a(this.columnList.isEmpty() ? false : true);
        this.rowKeyToIndex = Maps.a(this.rowList);
        this.columnKeyToIndex = Maps.a(this.columnList);
        this.array = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, this.rowList.size(), this.columnList.size()));
        eraseAll();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<>(iterable, iterable2);
    }

    public V at(int i, int i2) {
        Preconditions.a(i, this.rowList.size());
        Preconditions.a(i2, this.columnList.size());
        return this.array[i][i2];
    }

    @Override // com.google.common.collect.AbstractC1542s
    Iterator<Table.Cell<R, C, V>> cellIterator() {
        return new C1548u(this, size());
    }

    @Override // com.google.common.collect.AbstractC1542s, com.google.common.collect.Table
    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.AbstractC1542s
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public Map<R, V> column(C c2) {
        Preconditions.a(c2);
        Integer num = this.columnKeyToIndex.get(c2);
        return num == null ? ImmutableMap.of() : new b(num.intValue());
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    @Override // com.google.common.collect.Table
    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.c cVar = this.f15331c;
        if (cVar != null) {
            return cVar;
        }
        ArrayTable<R, C, V>.c cVar2 = new c(this, null);
        this.f15331c = cVar2;
        return cVar2;
    }

    @Override // com.google.common.collect.AbstractC1542s
    public boolean contains(@Nullable Object obj, @Nullable Object obj2) {
        return containsRow(obj) && containsColumn(obj2);
    }

    @Override // com.google.common.collect.AbstractC1542s
    public boolean containsColumn(@Nullable Object obj) {
        return this.columnKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractC1542s
    public boolean containsRow(@Nullable Object obj) {
        return this.rowKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractC1542s
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

    @Override // com.google.common.collect.AbstractC1542s, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @CanIgnoreReturnValue
    public V erase(@Nullable Object obj, @Nullable Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return set(num.intValue(), num2.intValue(), null);
    }

    public void eraseAll() {
        for (V[] vArr : this.array) {
            Arrays.fill(vArr, (Object) null);
        }
    }

    @Override // com.google.common.collect.AbstractC1542s
    public V get(@Nullable Object obj, @Nullable Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return at(num.intValue(), num2.intValue());
    }

    @Override // com.google.common.collect.AbstractC1542s, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractC1542s
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.AbstractC1542s
    @CanIgnoreReturnValue
    public V put(R r, C c2, @Nullable V v) {
        Preconditions.a(r);
        Preconditions.a(c2);
        Integer num = this.rowKeyToIndex.get(r);
        Preconditions.a(num != null, "Row %s not in %s", r, this.rowList);
        Integer num2 = this.columnKeyToIndex.get(c2);
        Preconditions.a(num2 != null, "Column %s not in %s", c2, this.columnList);
        return set(num.intValue(), num2.intValue(), v);
    }

    @Override // com.google.common.collect.AbstractC1542s
    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        super.putAll(table);
    }

    @Override // com.google.common.collect.AbstractC1542s
    @CanIgnoreReturnValue
    @Deprecated
    public V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public Map<C, V> row(R r) {
        Preconditions.a(r);
        Integer num = this.rowKeyToIndex.get(r);
        return num == null ? ImmutableMap.of() : new d(num.intValue());
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    @Override // com.google.common.collect.Table
    public Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.e eVar = this.f15332d;
        if (eVar != null) {
            return eVar;
        }
        ArrayTable<R, C, V>.e eVar2 = new e(this, null);
        this.f15332d = eVar2;
        return eVar2;
    }

    @CanIgnoreReturnValue
    public V set(int i, int i2, @Nullable V v) {
        Preconditions.a(i, this.rowList.size());
        Preconditions.a(i2, this.columnList.size());
        V[][] vArr = this.array;
        V v2 = vArr[i][i2];
        vArr[i][i2] = v;
        return v2;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    @GwtIncompatible
    public V[][] toArray(Class<V> cls) {
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) cls, this.rowList.size(), this.columnList.size()));
        for (int i = 0; i < this.rowList.size(); i++) {
            V[][] vArr2 = this.array;
            System.arraycopy(vArr2[i], 0, vArr[i], 0, vArr2[i].length);
        }
        return vArr;
    }

    @Override // com.google.common.collect.AbstractC1542s
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractC1542s
    public Collection<V> values() {
        return super.values();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Table<R, C, V> table) {
        return table instanceof ArrayTable ? new ArrayTable<>((ArrayTable) table) : new ArrayTable<>(table);
    }

    @Override // com.google.common.collect.AbstractC1542s, com.google.common.collect.Table
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.AbstractC1542s, com.google.common.collect.Table
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
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
        eraseAll();
        for (int i = 0; i < this.rowList.size(); i++) {
            V[][] vArr2 = arrayTable.array;
            System.arraycopy(vArr2[i], 0, vArr[i], 0, vArr2[i].length);
        }
    }
}
