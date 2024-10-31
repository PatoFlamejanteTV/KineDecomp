package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class AbstractMapBasedMultiset<E> extends l<E> implements Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = -2250766705698539974L;

    /* renamed from: a, reason: collision with root package name */
    private transient Map<E, Count> f2639a;
    private transient long b = super.size();

    static /* synthetic */ long access$110(AbstractMapBasedMultiset abstractMapBasedMultiset) {
        long j = abstractMapBasedMultiset.b;
        abstractMapBasedMultiset.b = j - 1;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long access$122(AbstractMapBasedMultiset abstractMapBasedMultiset, long j) {
        long j2 = abstractMapBasedMultiset.b - j;
        abstractMapBasedMultiset.b = j2;
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractMapBasedMultiset(Map<E, Count> map) {
        this.f2639a = (Map) Preconditions.a(map);
    }

    Map<E, Count> backingMap() {
        return this.f2639a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBackingMap(Map<E, Count> map) {
        this.f2639a = map;
    }

    @Override // com.google.common.collect.l, com.google.common.collect.Multiset
    public Set<Multiset.Entry<E>> entrySet() {
        return super.entrySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.l
    public Iterator<Multiset.Entry<E>> entryIterator() {
        return new d(this, this.f2639a.entrySet().iterator());
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Iterator<Count> it = this.f2639a.values().iterator();
        while (it.hasNext()) {
            it.next().set(0);
        }
        this.f2639a.clear();
        this.b = 0L;
    }

    @Override // com.google.common.collect.l
    int distinctElements() {
        return this.f2639a.size();
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection
    public int size() {
        return Ints.a(this.b);
    }

    @Override // com.google.common.collect.l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Iterator<E> {

        /* renamed from: a, reason: collision with root package name */
        final Iterator<Map.Entry<E, Count>> f2641a;
        Map.Entry<E, Count> b;
        int c;
        boolean d;

        b() {
            this.f2641a = AbstractMapBasedMultiset.this.f2639a.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c > 0 || this.f2641a.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.c == 0) {
                this.b = this.f2641a.next();
                this.c = this.b.getValue().get();
            }
            this.c--;
            this.d = true;
            return this.b.getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.b(this.d, "no calls to next() since the last call to remove()");
            if (this.b.getValue().get() <= 0) {
                throw new ConcurrentModificationException();
            }
            if (this.b.getValue().addAndGet(-1) == 0) {
                this.f2641a.remove();
            }
            AbstractMapBasedMultiset.access$110(AbstractMapBasedMultiset.this);
            this.d = false;
        }
    }

    @Override // com.google.common.collect.l, com.google.common.collect.Multiset
    public int count(@Nullable Object obj) {
        try {
            Count count = this.f2639a.get(obj);
            return count == null ? 0 : count.get();
        } catch (ClassCastException e) {
            return 0;
        } catch (NullPointerException e2) {
            return 0;
        }
    }

    @Override // com.google.common.collect.l, com.google.common.collect.Multiset
    public int add(@Nullable E e, int i) {
        int i2 = 0;
        if (i == 0) {
            return count(e);
        }
        Preconditions.a(i > 0, "occurrences cannot be negative: %s", Integer.valueOf(i));
        Count count = this.f2639a.get(e);
        if (count == null) {
            this.f2639a.put(e, new Count(i));
        } else {
            int i3 = count.get();
            long j = i3 + i;
            Preconditions.a(j <= 2147483647L, "too many occurrences: %s", Long.valueOf(j));
            count.getAndAdd(i);
            i2 = i3;
        }
        this.b += i;
        return i2;
    }

    @Override // com.google.common.collect.l, com.google.common.collect.Multiset
    public int remove(@Nullable Object obj, int i) {
        if (i == 0) {
            return count(obj);
        }
        Preconditions.a(i > 0, "occurrences cannot be negative: %s", Integer.valueOf(i));
        Count count = this.f2639a.get(obj);
        if (count == null) {
            return 0;
        }
        int i2 = count.get();
        if (i2 <= i) {
            this.f2639a.remove(obj);
            i = i2;
        }
        count.addAndGet(-i);
        this.b -= i;
        return i2;
    }

    @Override // com.google.common.collect.l, com.google.common.collect.Multiset
    public int setCount(@Nullable E e, int i) {
        int i2;
        Multisets.a(i, "count");
        if (i == 0) {
            i2 = a(this.f2639a.remove(e), i);
        } else {
            Count count = this.f2639a.get(e);
            int a2 = a(count, i);
            if (count == null) {
                this.f2639a.put(e, new Count(i));
            }
            i2 = a2;
        }
        this.b += i - i2;
        return i2;
    }

    private static int a(Count count, int i) {
        if (count == null) {
            return 0;
        }
        return count.getAndSet(i);
    }

    @Override // com.google.common.collect.l
    Set<E> createElementSet() {
        return new a();
    }

    /* loaded from: classes2.dex */
    class a extends Multisets.b<E> {
        a() {
        }

        @Override // com.google.common.collect.Multisets.b
        Multiset<E> a() {
            return AbstractMapBasedMultiset.this;
        }
    }
}
