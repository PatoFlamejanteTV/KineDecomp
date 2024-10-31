package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public abstract class AbstractMapBasedMultiset<E> extends AbstractC1522l<E> implements Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = -2250766705698539974L;

    /* renamed from: c */
    private transient Map<E, Count> f15323c;

    /* renamed from: d */
    private transient long f15324d;

    /* loaded from: classes2.dex */
    public class a implements Iterator<E> {

        /* renamed from: a */
        final Iterator<Map.Entry<E, Count>> f15325a;

        /* renamed from: b */
        Map.Entry<E, Count> f15326b;

        /* renamed from: c */
        int f15327c;

        /* renamed from: d */
        boolean f15328d;

        a() {
            this.f15325a = AbstractMapBasedMultiset.this.f15323c.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f15327c > 0 || this.f15325a.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.f15327c == 0) {
                this.f15326b = this.f15325a.next();
                this.f15327c = this.f15326b.getValue().get();
            }
            this.f15327c--;
            this.f15328d = true;
            return this.f15326b.getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            C1555x.a(this.f15328d);
            if (this.f15326b.getValue().get() > 0) {
                if (this.f15326b.getValue().addAndGet(-1) == 0) {
                    this.f15325a.remove();
                }
                AbstractMapBasedMultiset.access$110(AbstractMapBasedMultiset.this);
                this.f15328d = false;
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    public AbstractMapBasedMultiset(Map<E, Count> map) {
        Preconditions.a(map);
        this.f15323c = map;
        this.f15324d = super.size();
    }

    private static int a(@Nullable Count count, int i) {
        if (count == null) {
            return 0;
        }
        return count.getAndSet(i);
    }

    static /* synthetic */ long access$110(AbstractMapBasedMultiset abstractMapBasedMultiset) {
        long j = abstractMapBasedMultiset.f15324d;
        abstractMapBasedMultiset.f15324d = j - 1;
        return j;
    }

    public static /* synthetic */ long access$122(AbstractMapBasedMultiset abstractMapBasedMultiset, long j) {
        long j2 = abstractMapBasedMultiset.f15324d - j;
        abstractMapBasedMultiset.f15324d = j2;
        return j2;
    }

    @Override // com.google.common.collect.AbstractC1522l, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(@Nullable E e2, int i) {
        int i2;
        if (i == 0) {
            return count(e2);
        }
        Preconditions.a(i > 0, "occurrences cannot be negative: %s", i);
        Count count = this.f15323c.get(e2);
        if (count == null) {
            this.f15323c.put(e2, new Count(i));
            i2 = 0;
        } else {
            i2 = count.get();
            long j = i2 + i;
            Preconditions.a(j <= 2147483647L, "too many occurrences: %s", j);
            count.add(i);
        }
        this.f15324d += i;
        return i2;
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Iterator<Count> it = this.f15323c.values().iterator();
        while (it.hasNext()) {
            it.next().set(0);
        }
        this.f15323c.clear();
        this.f15324d = 0L;
    }

    @Override // com.google.common.collect.AbstractC1522l, com.google.common.collect.Multiset
    public int count(@Nullable Object obj) {
        Count count = (Count) Maps.e(this.f15323c, obj);
        if (count == null) {
            return 0;
        }
        return count.get();
    }

    @Override // com.google.common.collect.AbstractC1522l
    int distinctElements() {
        return this.f15323c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractC1522l
    public Iterator<Multiset.Entry<E>> entryIterator() {
        return new C1510h(this, this.f15323c.entrySet().iterator());
    }

    @Override // com.google.common.collect.AbstractC1522l, com.google.common.collect.Multiset
    public Set<Multiset.Entry<E>> entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new a();
    }

    @Override // com.google.common.collect.AbstractC1522l, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@Nullable Object obj, int i) {
        if (i == 0) {
            return count(obj);
        }
        Preconditions.a(i > 0, "occurrences cannot be negative: %s", i);
        Count count = this.f15323c.get(obj);
        if (count == null) {
            return 0;
        }
        int i2 = count.get();
        if (i2 <= i) {
            this.f15323c.remove(obj);
            i = i2;
        }
        count.add(-i);
        this.f15324d -= i;
        return i2;
    }

    public void setBackingMap(Map<E, Count> map) {
        this.f15323c = map;
    }

    @Override // com.google.common.collect.AbstractC1522l, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(@Nullable E e2, int i) {
        int i2;
        C1555x.a(i, "count");
        if (i == 0) {
            i2 = a(this.f15323c.remove(e2), i);
        } else {
            Count count = this.f15323c.get(e2);
            int a2 = a(count, i);
            if (count == null) {
                this.f15323c.put(e2, new Count(i));
            }
            i2 = a2;
        }
        this.f15324d += i - i2;
        return i2;
    }

    @Override // com.google.common.collect.AbstractC1522l, java.util.AbstractCollection, java.util.Collection
    public int size() {
        return Ints.b(this.f15324d);
    }
}
