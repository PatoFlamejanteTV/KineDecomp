package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public class TreeRangeSet<C extends Comparable<?>> extends AbstractC1531o<C> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private transient Set<Range<C>> f15726a;

    /* renamed from: b, reason: collision with root package name */
    private transient Set<Range<C>> f15727b;

    /* renamed from: c, reason: collision with root package name */
    private transient RangeSet<C> f15728c;

    @VisibleForTesting
    final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;

    /* loaded from: classes2.dex */
    private final class Complement extends TreeRangeSet<C> {
        Complement() {
            super(new b(TreeRangeSet.this.rangesByLowerBound));
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractC1531o, com.google.common.collect.RangeSet
        public void add(Range<C> range) {
            TreeRangeSet.this.remove(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
        public RangeSet<C> complement() {
            return TreeRangeSet.this;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractC1531o
        public boolean contains(C c2) {
            return !TreeRangeSet.this.contains(c2);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractC1531o
        public void remove(Range<C> range) {
            TreeRangeSet.this.add(range);
        }
    }

    /* loaded from: classes2.dex */
    private final class SubRangeSet extends TreeRangeSet<C> {
        private final Range<C> restriction;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        SubRangeSet(com.google.common.collect.Range<C> r5) {
            /*
                r3 = this;
                com.google.common.collect.TreeRangeSet.this = r4
                com.google.common.collect.TreeRangeSet$d r0 = new com.google.common.collect.TreeRangeSet$d
                com.google.common.collect.Range r1 = com.google.common.collect.Range.all()
                java.util.NavigableMap<com.google.common.collect.Cut<C extends java.lang.Comparable<?>>, com.google.common.collect.Range<C extends java.lang.Comparable<?>>> r4 = r4.rangesByLowerBound
                r2 = 0
                r0.<init>(r1, r5, r4)
                r3.<init>(r0)
                r3.restriction = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.TreeRangeSet.SubRangeSet.<init>(com.google.common.collect.TreeRangeSet, com.google.common.collect.Range):void");
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractC1531o, com.google.common.collect.RangeSet
        public void add(Range<C> range) {
            Preconditions.a(this.restriction.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.restriction);
            super.add(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractC1531o
        public void clear() {
            TreeRangeSet.this.remove(this.restriction);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractC1531o
        public boolean contains(C c2) {
            return this.restriction.contains(c2) && TreeRangeSet.this.contains(c2);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractC1531o, com.google.common.collect.RangeSet
        public boolean encloses(Range<C> range) {
            Range a2;
            return (this.restriction.isEmpty() || !this.restriction.encloses(range) || (a2 = TreeRangeSet.this.a(range)) == null || a2.intersection(this.restriction).isEmpty()) ? false : true;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractC1531o
        @Nullable
        public Range<C> rangeContaining(C c2) {
            Range<C> rangeContaining;
            if (this.restriction.contains(c2) && (rangeContaining = TreeRangeSet.this.rangeContaining(c2)) != null) {
                return rangeContaining.intersection(this.restriction);
            }
            return null;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractC1531o
        public void remove(Range<C> range) {
            if (range.isConnected(this.restriction)) {
                TreeRangeSet.this.remove(range.intersection(this.restriction));
            }
        }

        @Override // com.google.common.collect.TreeRangeSet
        public RangeSet<C> subRangeSet(Range<C> range) {
            if (range.encloses(this.restriction)) {
                return this;
            }
            if (range.isConnected(this.restriction)) {
                return new SubRangeSet(this, this.restriction.intersection(range));
            }
            return ImmutableRangeSet.of();
        }
    }

    /* loaded from: classes2.dex */
    final class a extends ForwardingCollection<Range<C>> implements Set<Range<C>> {

        /* renamed from: a, reason: collision with root package name */
        final Collection<Range<C>> f15729a;

        a(Collection<Range<C>> collection) {
            this.f15729a = collection;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@Nullable Object obj) {
            return Sets.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.a(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Collection<Range<C>> delegate() {
            return this.f15729a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b<C extends Comparable<?>> extends AbstractC1528n<Cut<C>, Range<C>> {

        /* renamed from: a, reason: collision with root package name */
        private final NavigableMap<Cut<C>, Range<C>> f15731a;

        /* renamed from: b, reason: collision with root package name */
        private final NavigableMap<Cut<C>, Range<C>> f15732b;

        /* renamed from: c, reason: collision with root package name */
        private final Range<Cut<C>> f15733c;

        b(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this(navigableMap, Range.all());
        }

        @Override // java.util.NavigableMap
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z) {
            return a(Range.downTo(cut, BoundType.forBoolean(z)));
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.d
        public Iterator<Map.Entry<Cut<C>, Range<C>>> entryIterator() {
            Collection<Range<C>> values;
            Cut cut;
            if (this.f15733c.hasLowerBound()) {
                values = this.f15732b.tailMap(this.f15733c.lowerEndpoint(), this.f15733c.lowerBoundType() == BoundType.CLOSED).values();
            } else {
                values = this.f15732b.values();
            }
            PeekingIterator e2 = Iterators.e(values.iterator());
            if (this.f15733c.contains(Cut.belowAll()) && (!e2.hasNext() || ((Range) e2.peek()).lowerBound != Cut.belowAll())) {
                cut = Cut.belowAll();
            } else if (e2.hasNext()) {
                cut = ((Range) e2.next()).upperBound;
            } else {
                return Iterators.a();
            }
            return new Lb(this, cut, e2);
        }

        @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.g(entryIterator());
        }

        private b(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.f15731a = navigableMap;
            this.f15732b = new c(navigableMap);
            this.f15733c = range;
        }

        private NavigableMap<Cut<C>, Range<C>> a(Range<Cut<C>> range) {
            if (!this.f15733c.isConnected(range)) {
                return ImmutableSortedMap.of();
            }
            return new b(this.f15731a, range.intersection(this.f15733c));
        }

        @Override // java.util.AbstractMap, java.util.Map
        @Nullable
        public Range<C> get(Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    Map.Entry<Cut<C>, Range<C>> firstEntry = tailMap(cut, true).firstEntry();
                    if (firstEntry != null && firstEntry.getKey().equals(cut)) {
                        return firstEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z, Cut<C> cut2, boolean z2) {
            return a(Range.range(cut, BoundType.forBoolean(z), cut2, BoundType.forBoolean(z2)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z) {
            return a(Range.upTo(cut, BoundType.forBoolean(z)));
        }

        @Override // com.google.common.collect.AbstractC1528n
        Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            Cut<C> higherKey;
            PeekingIterator e2 = Iterators.e(this.f15732b.headMap(this.f15733c.hasUpperBound() ? this.f15733c.upperEndpoint() : Cut.aboveAll(), this.f15733c.hasUpperBound() && this.f15733c.upperBoundType() == BoundType.CLOSED).descendingMap().values().iterator());
            if (e2.hasNext()) {
                higherKey = ((Range) e2.peek()).upperBound == Cut.aboveAll() ? ((Range) e2.next()).lowerBound : this.f15731a.higherKey(((Range) e2.peek()).upperBound);
            } else if (this.f15733c.contains(Cut.belowAll()) && !this.f15731a.containsKey(Cut.belowAll())) {
                higherKey = this.f15731a.higherKey(Cut.belowAll());
            } else {
                return Iterators.a();
            }
            return new Mb(this, (Cut) MoreObjects.a(higherKey, Cut.aboveAll()), e2);
        }
    }

    @VisibleForTesting
    /* loaded from: classes2.dex */
    static final class c<C extends Comparable<?>> extends AbstractC1528n<Cut<C>, Range<C>> {

        /* renamed from: a, reason: collision with root package name */
        private final NavigableMap<Cut<C>, Range<C>> f15734a;

        /* renamed from: b, reason: collision with root package name */
        private final Range<Cut<C>> f15735b;

        c(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this.f15734a = navigableMap;
            this.f15735b = Range.all();
        }

        @Override // java.util.NavigableMap
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z) {
            return a(Range.downTo(cut, BoundType.forBoolean(z)));
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@Nullable Object obj) {
            return get(obj) != null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.d
        public Iterator<Map.Entry<Cut<C>, Range<C>>> entryIterator() {
            Iterator<Range<C>> it;
            if (!this.f15735b.hasLowerBound()) {
                it = this.f15734a.values().iterator();
            } else {
                Map.Entry lowerEntry = this.f15734a.lowerEntry(this.f15735b.lowerEndpoint());
                if (lowerEntry == null) {
                    it = this.f15734a.values().iterator();
                } else if (this.f15735b.lowerBound.isLessThan(((Range) lowerEntry.getValue()).upperBound)) {
                    it = this.f15734a.tailMap(lowerEntry.getKey(), true).values().iterator();
                } else {
                    it = this.f15734a.tailMap(this.f15735b.lowerEndpoint(), true).values().iterator();
                }
            }
            return new Nb(this, it);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f15735b.equals(Range.all()) ? this.f15734a.isEmpty() : !entryIterator().hasNext();
        }

        @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
        public int size() {
            if (this.f15735b.equals(Range.all())) {
                return this.f15734a.size();
            }
            return Iterators.g(entryIterator());
        }

        private NavigableMap<Cut<C>, Range<C>> a(Range<Cut<C>> range) {
            if (range.isConnected(this.f15735b)) {
                return new c(this.f15734a, range.intersection(this.f15735b));
            }
            return ImmutableSortedMap.of();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Range<C> get(@Nullable Object obj) {
            Map.Entry<Cut<C>, Range<C>> lowerEntry;
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    if (this.f15735b.contains(cut) && (lowerEntry = this.f15734a.lowerEntry(cut)) != null && lowerEntry.getValue().upperBound.equals(cut)) {
                        return lowerEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        private c(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.f15734a = navigableMap;
            this.f15735b = range;
        }

        @Override // java.util.NavigableMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z, Cut<C> cut2, boolean z2) {
            return a(Range.range(cut, BoundType.forBoolean(z), cut2, BoundType.forBoolean(z2)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z) {
            return a(Range.upTo(cut, BoundType.forBoolean(z)));
        }

        @Override // com.google.common.collect.AbstractC1528n
        Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            Collection<Range<C>> values;
            if (this.f15735b.hasUpperBound()) {
                values = this.f15734a.headMap(this.f15735b.upperEndpoint(), false).descendingMap().values();
            } else {
                values = this.f15734a.descendingMap().values();
            }
            PeekingIterator e2 = Iterators.e(values.iterator());
            if (e2.hasNext() && this.f15735b.upperBound.isLessThan(((Range) e2.peek()).upperBound)) {
                e2.next();
            }
            return new Ob(this, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class d<C extends Comparable<?>> extends AbstractC1528n<Cut<C>, Range<C>> {

        /* renamed from: a, reason: collision with root package name */
        private final Range<Cut<C>> f15736a;

        /* renamed from: b, reason: collision with root package name */
        private final Range<C> f15737b;

        /* renamed from: c, reason: collision with root package name */
        private final NavigableMap<Cut<C>, Range<C>> f15738c;

        /* renamed from: d, reason: collision with root package name */
        private final NavigableMap<Cut<C>, Range<C>> f15739d;

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@Nullable Object obj) {
            return get(obj) != null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.d
        public Iterator<Map.Entry<Cut<C>, Range<C>>> entryIterator() {
            Iterator<Range<C>> it;
            if (this.f15737b.isEmpty()) {
                return Iterators.a();
            }
            if (this.f15736a.upperBound.isLessThan(this.f15737b.lowerBound)) {
                return Iterators.a();
            }
            if (this.f15736a.lowerBound.isLessThan(this.f15737b.lowerBound)) {
                it = this.f15739d.tailMap(this.f15737b.lowerBound, false).values().iterator();
            } else {
                it = this.f15738c.tailMap(this.f15736a.lowerBound.endpoint(), this.f15736a.lowerBoundType() == BoundType.CLOSED).values().iterator();
            }
            return new Pb(this, it, (Cut) Ordering.natural().min(this.f15736a.upperBound, Cut.belowValue(this.f15737b.upperBound)));
        }

        @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.g(entryIterator());
        }

        private d(Range<Cut<C>> range, Range<C> range2, NavigableMap<Cut<C>, Range<C>> navigableMap) {
            Preconditions.a(range);
            this.f15736a = range;
            Preconditions.a(range2);
            this.f15737b = range2;
            Preconditions.a(navigableMap);
            this.f15738c = navigableMap;
            this.f15739d = new c(navigableMap);
        }

        private NavigableMap<Cut<C>, Range<C>> a(Range<Cut<C>> range) {
            if (!range.isConnected(this.f15736a)) {
                return ImmutableSortedMap.of();
            }
            return new d(this.f15736a.intersection(range), this.f15737b, this.f15738c);
        }

        @Override // java.util.NavigableMap
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z) {
            return a(Range.downTo(cut, BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        @Nullable
        public Range<C> get(@Nullable Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    if (this.f15736a.contains(cut) && cut.compareTo(this.f15737b.lowerBound) >= 0 && cut.compareTo(this.f15737b.upperBound) < 0) {
                        if (cut.equals(this.f15737b.lowerBound)) {
                            Range range = (Range) Maps.c(this.f15738c.floorEntry(cut));
                            if (range != null && range.upperBound.compareTo((Cut) this.f15737b.lowerBound) > 0) {
                                return range.intersection(this.f15737b);
                            }
                        } else {
                            Range range2 = (Range) this.f15738c.get(cut);
                            if (range2 != null) {
                                return range2.intersection(this.f15737b);
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z, Cut<C> cut2, boolean z2) {
            return a(Range.range(cut, BoundType.forBoolean(z), cut2, BoundType.forBoolean(z2)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z) {
            return a(Range.upTo(cut, BoundType.forBoolean(z)));
        }

        @Override // com.google.common.collect.AbstractC1528n
        Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            if (this.f15737b.isEmpty()) {
                return Iterators.a();
            }
            Cut cut = (Cut) Ordering.natural().min(this.f15736a.upperBound, Cut.belowValue(this.f15737b.upperBound));
            return new Qb(this, this.f15738c.headMap(cut.endpoint(), cut.typeAsUpperBound() == BoundType.CLOSED).descendingMap().values().iterator());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Range<C> a(Range<C> range) {
        Preconditions.a(range);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        if (floorEntry == null || !floorEntry.getValue().encloses(range)) {
            return null;
        }
        return floorEntry.getValue();
    }

    private void b(Range<C> range) {
        if (range.isEmpty()) {
            this.rangesByLowerBound.remove(range.lowerBound);
        } else {
            this.rangesByLowerBound.put(range.lowerBound, range);
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        return new TreeRangeSet<>(new TreeMap());
    }

    @Override // com.google.common.collect.AbstractC1531o, com.google.common.collect.RangeSet
    public void add(Range<C> range) {
        Preconditions.a(range);
        if (range.isEmpty()) {
            return;
        }
        Cut<C> cut = range.lowerBound;
        Cut<C> cut2 = range.upperBound;
        Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(cut);
        if (lowerEntry != null) {
            Range<C> value = lowerEntry.getValue();
            if (value.upperBound.compareTo(cut) >= 0) {
                if (value.upperBound.compareTo(cut2) >= 0) {
                    cut2 = value.upperBound;
                }
                cut = value.lowerBound;
            }
        }
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(cut2);
        if (floorEntry != null) {
            Range<C> value2 = floorEntry.getValue();
            if (value2.upperBound.compareTo(cut2) >= 0) {
                cut2 = value2.upperBound;
            }
        }
        this.rangesByLowerBound.subMap(cut, cut2).clear();
        b(Range.create(cut, cut2));
    }

    @Override // com.google.common.collect.AbstractC1531o
    public /* bridge */ /* synthetic */ void addAll(RangeSet rangeSet) {
        super.addAll(rangeSet);
    }

    public Set<Range<C>> asDescendingSetOfRanges() {
        Set<Range<C>> set = this.f15727b;
        if (set != null) {
            return set;
        }
        a aVar = new a(this.rangesByLowerBound.descendingMap().values());
        this.f15727b = aVar;
        return aVar;
    }

    @Override // com.google.common.collect.RangeSet
    public Set<Range<C>> asRanges() {
        Set<Range<C>> set = this.f15726a;
        if (set != null) {
            return set;
        }
        a aVar = new a(this.rangesByLowerBound.values());
        this.f15726a = aVar;
        return aVar;
    }

    @Override // com.google.common.collect.AbstractC1531o
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.RangeSet
    public RangeSet<C> complement() {
        RangeSet<C> rangeSet = this.f15728c;
        if (rangeSet != null) {
            return rangeSet;
        }
        Complement complement = new Complement();
        this.f15728c = complement;
        return complement;
    }

    @Override // com.google.common.collect.AbstractC1531o
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    @Override // com.google.common.collect.AbstractC1531o, com.google.common.collect.RangeSet
    public boolean encloses(Range<C> range) {
        Preconditions.a(range);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        return floorEntry != null && floorEntry.getValue().encloses(range);
    }

    @Override // com.google.common.collect.AbstractC1531o
    public /* bridge */ /* synthetic */ boolean enclosesAll(RangeSet rangeSet) {
        return super.enclosesAll(rangeSet);
    }

    @Override // com.google.common.collect.AbstractC1531o
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractC1531o
    public boolean intersects(Range<C> range) {
        Preconditions.a(range);
        Map.Entry<Cut<C>, Range<C>> ceilingEntry = this.rangesByLowerBound.ceilingEntry(range.lowerBound);
        if (ceilingEntry != null && ceilingEntry.getValue().isConnected(range) && !ceilingEntry.getValue().intersection(range).isEmpty()) {
            return true;
        }
        Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        return (lowerEntry == null || !lowerEntry.getValue().isConnected(range) || lowerEntry.getValue().intersection(range).isEmpty()) ? false : true;
    }

    @Override // com.google.common.collect.AbstractC1531o, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractC1531o
    @Nullable
    public Range<C> rangeContaining(C c2) {
        Preconditions.a(c2);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(Cut.belowValue(c2));
        if (floorEntry == null || !floorEntry.getValue().contains(c2)) {
            return null;
        }
        return floorEntry.getValue();
    }

    @Override // com.google.common.collect.AbstractC1531o
    public void remove(Range<C> range) {
        Preconditions.a(range);
        if (range.isEmpty()) {
            return;
        }
        Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        if (lowerEntry != null) {
            Range<C> value = lowerEntry.getValue();
            if (value.upperBound.compareTo(range.lowerBound) >= 0) {
                if (range.hasUpperBound() && value.upperBound.compareTo(range.upperBound) >= 0) {
                    b(Range.create(range.upperBound, value.upperBound));
                }
                b(Range.create(value.lowerBound, range.lowerBound));
            }
        }
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.upperBound);
        if (floorEntry != null) {
            Range<C> value2 = floorEntry.getValue();
            if (range.hasUpperBound() && value2.upperBound.compareTo(range.upperBound) >= 0) {
                b(Range.create(range.upperBound, value2.upperBound));
            }
        }
        this.rangesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
    }

    @Override // com.google.common.collect.AbstractC1531o
    public /* bridge */ /* synthetic */ void removeAll(RangeSet rangeSet) {
        super.removeAll(rangeSet);
    }

    public Range<C> span() {
        Map.Entry<Cut<C>, Range<C>> firstEntry = this.rangesByLowerBound.firstEntry();
        Map.Entry<Cut<C>, Range<C>> lastEntry = this.rangesByLowerBound.lastEntry();
        if (firstEntry != null) {
            return Range.create(firstEntry.getValue().lowerBound, lastEntry.getValue().upperBound);
        }
        throw new NoSuchElementException();
    }

    public RangeSet<C> subRangeSet(Range<C> range) {
        return range.equals(Range.all()) ? this : new SubRangeSet(this, range);
    }

    private TreeRangeSet(NavigableMap<Cut<C>, Range<C>> navigableMap) {
        this.rangesByLowerBound = navigableMap;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(RangeSet<C> rangeSet) {
        TreeRangeSet<C> create = create();
        create.addAll(rangeSet);
        return create;
    }
}
