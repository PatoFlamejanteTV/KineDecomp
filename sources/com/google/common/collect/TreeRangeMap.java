package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.lang.Comparable;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class TreeRangeMap<K extends Comparable, V> implements RangeMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private static final RangeMap f15720a = new Jb();

    /* renamed from: b, reason: collision with root package name */
    private final NavigableMap<Cut<K>, b<K, V>> f15721b = Maps.e();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class a extends Maps.d<Range<K>, V> {

        /* renamed from: a, reason: collision with root package name */
        final Iterable<Map.Entry<Range<K>, V>> f15722a;

        a(Iterable<b<K, V>> iterable) {
            this.f15722a = iterable;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@Nullable Object obj) {
            return get(obj) != null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.d
        public Iterator<Map.Entry<Range<K>, V>> entryIterator() {
            return this.f15722a.iterator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(@Nullable Object obj) {
            if (!(obj instanceof Range)) {
                return null;
            }
            Range range = (Range) obj;
            b bVar = (b) TreeRangeMap.this.f15721b.get(range.lowerBound);
            if (bVar == null || !bVar.getKey().equals(range)) {
                return null;
            }
            return (V) bVar.getValue();
        }

        @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
        public int size() {
            return TreeRangeMap.this.f15721b.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b<K extends Comparable, V> extends AbstractC1513i<Range<K>, V> {

        /* renamed from: a, reason: collision with root package name */
        private final Range<K> f15724a;

        /* renamed from: b, reason: collision with root package name */
        private final V f15725b;

        b(Cut<K> cut, Cut<K> cut2, V v) {
            this(Range.create(cut, cut2), v);
        }

        Cut<K> a() {
            return this.f15724a.lowerBound;
        }

        Cut<K> b() {
            return this.f15724a.upperBound;
        }

        @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
        public V getValue() {
            return this.f15725b;
        }

        b(Range<K> range, V v) {
            this.f15724a = range;
            this.f15725b = v;
        }

        @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
        public Range<K> getKey() {
            return this.f15724a;
        }
    }

    private TreeRangeMap() {
    }

    @Override // com.google.common.collect.RangeMap
    public Map<Range<K>, V> asMapOfRanges() {
        return new a(this.f15721b.values());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof RangeMap) {
            return asMapOfRanges().equals(((RangeMap) obj).asMapOfRanges());
        }
        return false;
    }

    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Override // com.google.common.collect.RangeMap
    public void put(Range<K> range, V v) {
        if (range.isEmpty()) {
            return;
        }
        Preconditions.a(v);
        a(range);
        this.f15721b.put(range.lowerBound, new b(range, v));
    }

    public String toString() {
        return this.f15721b.values().toString();
    }

    public static <K extends Comparable, V> TreeRangeMap<K, V> a() {
        return new TreeRangeMap<>();
    }

    private void a(Cut<K> cut, Cut<K> cut2, V v) {
        this.f15721b.put(cut, new b(cut, cut2, v));
    }

    public void a(Range<K> range) {
        if (range.isEmpty()) {
            return;
        }
        Map.Entry<Cut<K>, b<K, V>> lowerEntry = this.f15721b.lowerEntry(range.lowerBound);
        if (lowerEntry != null) {
            b<K, V> value = lowerEntry.getValue();
            if (value.b().compareTo(range.lowerBound) > 0) {
                if (value.b().compareTo(range.upperBound) > 0) {
                    a(range.upperBound, value.b(), lowerEntry.getValue().getValue());
                }
                a(value.a(), range.lowerBound, lowerEntry.getValue().getValue());
            }
        }
        Map.Entry<Cut<K>, b<K, V>> lowerEntry2 = this.f15721b.lowerEntry(range.upperBound);
        if (lowerEntry2 != null) {
            b<K, V> value2 = lowerEntry2.getValue();
            if (value2.b().compareTo(range.upperBound) > 0) {
                a(range.upperBound, value2.b(), lowerEntry2.getValue().getValue());
                this.f15721b.remove(range.lowerBound);
            }
        }
        this.f15721b.subMap(range.lowerBound, range.upperBound).clear();
    }
}
