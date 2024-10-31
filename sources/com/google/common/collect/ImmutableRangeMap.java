package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.SortedLists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public class ImmutableRangeMap<K extends Comparable<?>, V> implements RangeMap<K, V>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    private static final ImmutableRangeMap<Comparable<?>, Object> f15451a = new ImmutableRangeMap<>(ImmutableList.of(), ImmutableList.of());
    private static final long serialVersionUID = 0;

    /* renamed from: b, reason: collision with root package name */
    private final transient ImmutableList<Range<K>> f15452b;

    /* renamed from: c, reason: collision with root package name */
    private final transient ImmutableList<V> f15453c;

    /* loaded from: classes2.dex */
    private static class SerializedForm<K extends Comparable<?>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableMap<Range<K>, V> mapOfRanges;

        SerializedForm(ImmutableMap<Range<K>, V> immutableMap) {
            this.mapOfRanges = immutableMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        Object createRangeMap() {
            Builder builder = new Builder();
            Iterator it = this.mapOfRanges.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                builder.a((Range) entry.getKey(), entry.getValue());
            }
            return builder.a();
        }

        Object readResolve() {
            if (this.mapOfRanges.isEmpty()) {
                return ImmutableRangeMap.of();
            }
            return createRangeMap();
        }
    }

    ImmutableRangeMap(ImmutableList<Range<K>> immutableList, ImmutableList<V> immutableList2) {
        this.f15452b = immutableList;
        this.f15453c = immutableList2;
    }

    public static <K extends Comparable<?>, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(RangeMap<K, ? extends V> rangeMap) {
        if (rangeMap instanceof ImmutableRangeMap) {
            return (ImmutableRangeMap) rangeMap;
        }
        Map<Range<K>, ? extends V> asMapOfRanges = rangeMap.asMapOfRanges();
        ImmutableList.Builder builder = new ImmutableList.Builder(asMapOfRanges.size());
        ImmutableList.Builder builder2 = new ImmutableList.Builder(asMapOfRanges.size());
        for (Map.Entry<Range<K>, ? extends V> entry : asMapOfRanges.entrySet()) {
            builder.a((ImmutableList.Builder) entry.getKey());
            builder2.a((ImmutableList.Builder) entry.getValue());
        }
        return new ImmutableRangeMap<>(builder.a(), builder2.a());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of() {
        return (ImmutableRangeMap<K, V>) f15451a;
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof RangeMap) {
            return asMapOfRanges().equals(((RangeMap) obj).asMapOfRanges());
        }
        return false;
    }

    @Nullable
    public V get(K k) {
        int a2 = SortedLists.a(this.f15452b, (Function<? super E, Cut>) Range.lowerBoundFn(), Cut.belowValue(k), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (a2 != -1 && this.f15452b.get(a2).contains(k)) {
            return this.f15453c.get(a2);
        }
        return null;
    }

    @Nullable
    public Map.Entry<Range<K>, V> getEntry(K k) {
        int a2 = SortedLists.a(this.f15452b, (Function<? super E, Cut>) Range.lowerBoundFn(), Cut.belowValue(k), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (a2 == -1) {
            return null;
        }
        Range<K> range = this.f15452b.get(a2);
        if (range.contains(k)) {
            return Maps.a(range, this.f15453c.get(a2));
        }
        return null;
    }

    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Override // com.google.common.collect.RangeMap
    @Deprecated
    public void put(Range<K> range, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void putAll(RangeMap<K, V> rangeMap) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void remove(Range<K> range) {
        throw new UnsupportedOperationException();
    }

    public Range<K> span() {
        if (!this.f15452b.isEmpty()) {
            return Range.create(this.f15452b.get(0).lowerBound, this.f15452b.get(r1.size() - 1).upperBound);
        }
        throw new NoSuchElementException();
    }

    public String toString() {
        return asMapOfRanges().toString();
    }

    Object writeReplace() {
        return new SerializedForm(asMapOfRanges());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> range, V v) {
        return new ImmutableRangeMap<>(ImmutableList.of(range), ImmutableList.of(v));
    }

    @Override // 
    /* renamed from: asDescendingMapOfRanges, reason: merged with bridge method [inline-methods] */
    public ImmutableMap<Range<K>, V> mo10asDescendingMapOfRanges() {
        if (this.f15452b.isEmpty()) {
            return ImmutableMap.of();
        }
        return new ImmutableSortedMap(new RegularImmutableSortedSet(this.f15452b.reverse(), Range.RANGE_LEX_ORDERING.reverse()), this.f15453c.reverse());
    }

    @Override // com.google.common.collect.RangeMap
    public ImmutableMap<Range<K>, V> asMapOfRanges() {
        if (this.f15452b.isEmpty()) {
            return ImmutableMap.of();
        }
        return new ImmutableSortedMap(new RegularImmutableSortedSet(this.f15452b, Range.RANGE_LEX_ORDERING), this.f15453c);
    }

    @Override // 
    /* renamed from: subRangeMap */
    public ImmutableRangeMap<K, V> mo11subRangeMap(final Range<K> range) {
        Preconditions.a(range);
        if (range.isEmpty()) {
            return of();
        }
        if (this.f15452b.isEmpty() || range.encloses(span())) {
            return this;
        }
        final int a2 = SortedLists.a(this.f15452b, (Function<? super E, Cut<K>>) Range.upperBoundFn(), range.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        int a3 = SortedLists.a(this.f15452b, (Function<? super E, Cut<K>>) Range.lowerBoundFn(), range.upperBound, SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        if (a2 >= a3) {
            return of();
        }
        final int i = a3 - a2;
        return (ImmutableRangeMap<K, V>) new ImmutableRangeMap<K, V>(new ImmutableList<Range<K>>() { // from class: com.google.common.collect.ImmutableRangeMap.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return i;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.List
            public Range<K> get(int i2) {
                Preconditions.a(i2, i);
                return (i2 == 0 || i2 == i + (-1)) ? ((Range) ImmutableRangeMap.this.f15452b.get(i2 + a2)).intersection(range) : (Range) ImmutableRangeMap.this.f15452b.get(i2 + a2);
            }
        }, this.f15453c.subList(a2, a3)) { // from class: com.google.common.collect.ImmutableRangeMap.2
            @Override // com.google.common.collect.ImmutableRangeMap
            /* renamed from: asDescendingMapOfRanges */
            public /* bridge */ /* synthetic */ Map mo10asDescendingMapOfRanges() {
                return super.mo10asDescendingMapOfRanges();
            }

            @Override // com.google.common.collect.ImmutableRangeMap, com.google.common.collect.RangeMap
            public /* bridge */ /* synthetic */ Map asMapOfRanges() {
                return super.asMapOfRanges();
            }

            @Override // com.google.common.collect.ImmutableRangeMap
            /* renamed from: subRangeMap, reason: merged with bridge method [inline-methods] */
            public ImmutableRangeMap<K, V> mo11subRangeMap(Range<K> range2) {
                if (range.isConnected(range2)) {
                    return this.mo11subRangeMap((Range) range2.intersection(range));
                }
                return ImmutableRangeMap.of();
            }
        };
    }

    /* loaded from: classes2.dex */
    public static final class Builder<K extends Comparable<?>, V> {

        /* renamed from: a, reason: collision with root package name */
        private final RangeSet<K> f15454a = TreeRangeSet.create();

        /* renamed from: b, reason: collision with root package name */
        private final RangeMap<K, V> f15455b = TreeRangeMap.a();

        @CanIgnoreReturnValue
        public Builder<K, V> a(Range<K> range, V v) {
            Preconditions.a(range);
            Preconditions.a(v);
            Preconditions.a(!range.isEmpty(), "Range must not be empty, but was %s", range);
            if (!this.f15454a.complement().encloses(range)) {
                for (Map.Entry<Range<K>, V> entry : this.f15455b.asMapOfRanges().entrySet()) {
                    Range<K> key = entry.getKey();
                    if (key.isConnected(range) && !key.intersection(range).isEmpty()) {
                        throw new IllegalArgumentException("Overlapping ranges: range " + range + " overlaps with entry " + entry);
                    }
                }
            }
            this.f15454a.add(range);
            this.f15455b.put(range, v);
            return this;
        }

        public ImmutableRangeMap<K, V> a() {
            Map<Range<K>, V> asMapOfRanges = this.f15455b.asMapOfRanges();
            ImmutableList.Builder builder = new ImmutableList.Builder(asMapOfRanges.size());
            ImmutableList.Builder builder2 = new ImmutableList.Builder(asMapOfRanges.size());
            for (Map.Entry<Range<K>, V> entry : asMapOfRanges.entrySet()) {
                builder.a((ImmutableList.Builder) entry.getKey());
                builder2.a((ImmutableList.Builder) entry.getValue());
            }
            return new ImmutableRangeMap<>(builder.a(), builder2.a());
        }
    }
}
