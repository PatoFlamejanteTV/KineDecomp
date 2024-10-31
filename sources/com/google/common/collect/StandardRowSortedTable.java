package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes2.dex */
public class StandardRowSortedTable<R, C, V> extends StandardTable<R, C, V> implements RowSortedTable<R, C, V> {
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    private transient SortedSet<R> f2760a;
    private transient StandardRowSortedTable<R, C, V>.b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StandardRowSortedTable(SortedMap<R, Map<C, V>> sortedMap, Supplier<? extends Map<C, V>> supplier) {
        super(sortedMap, supplier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SortedMap<R, Map<C, V>> a() {
        return (SortedMap) this.backingMap;
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public SortedSet<R> rowKeySet() {
        SortedSet<R> sortedSet = this.f2760a;
        if (sortedSet != null) {
            return sortedSet;
        }
        a aVar = new a();
        this.f2760a = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends StandardTable<R, C, V>.h implements SortedSet<R> {
        private a() {
            super();
        }

        @Override // java.util.SortedSet
        public Comparator<? super R> comparator() {
            return StandardRowSortedTable.this.a().comparator();
        }

        @Override // java.util.SortedSet
        public R first() {
            return (R) StandardRowSortedTable.this.a().firstKey();
        }

        @Override // java.util.SortedSet
        public R last() {
            return (R) StandardRowSortedTable.this.a().lastKey();
        }

        @Override // java.util.SortedSet
        public SortedSet<R> headSet(R r) {
            Preconditions.a(r);
            return new StandardRowSortedTable(StandardRowSortedTable.this.a().headMap(r), StandardRowSortedTable.this.factory).rowKeySet();
        }

        @Override // java.util.SortedSet
        public SortedSet<R> subSet(R r, R r2) {
            Preconditions.a(r);
            Preconditions.a(r2);
            return new StandardRowSortedTable(StandardRowSortedTable.this.a().subMap(r, r2), StandardRowSortedTable.this.factory).rowKeySet();
        }

        @Override // java.util.SortedSet
        public SortedSet<R> tailSet(R r) {
            Preconditions.a(r);
            return new StandardRowSortedTable(StandardRowSortedTable.this.a().tailMap(r), StandardRowSortedTable.this.factory).rowKeySet();
        }
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public SortedMap<R, Map<C, V>> rowMap() {
        StandardRowSortedTable<R, C, V>.b bVar = this.b;
        if (bVar != null) {
            return bVar;
        }
        StandardRowSortedTable<R, C, V>.b bVar2 = new b();
        this.b = bVar2;
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends StandardTable<R, C, V>.i implements SortedMap<R, Map<C, V>> {
        private b() {
            super();
        }

        @Override // java.util.SortedMap
        public Comparator<? super R> comparator() {
            return StandardRowSortedTable.this.a().comparator();
        }

        @Override // java.util.SortedMap
        public R firstKey() {
            return (R) StandardRowSortedTable.this.a().firstKey();
        }

        @Override // java.util.SortedMap
        public R lastKey() {
            return (R) StandardRowSortedTable.this.a().lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> headMap(R r) {
            Preconditions.a(r);
            return new StandardRowSortedTable(StandardRowSortedTable.this.a().headMap(r), StandardRowSortedTable.this.factory).rowMap();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> subMap(R r, R r2) {
            Preconditions.a(r);
            Preconditions.a(r2);
            return new StandardRowSortedTable(StandardRowSortedTable.this.a().subMap(r, r2), StandardRowSortedTable.this.factory).rowMap();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> tailMap(R r) {
            Preconditions.a(r);
            return new StandardRowSortedTable(StandardRowSortedTable.this.a().tailMap(r), StandardRowSortedTable.this.factory).rowMap();
        }
    }
}
