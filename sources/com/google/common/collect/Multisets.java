package com.google.common.collect;

import android.support.v7.widget.ActivityChooserView;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Multisets {

    /* renamed from: a */
    private static final Ordering<Multiset.Entry<?>> f15611a = new _a();

    /* loaded from: classes2.dex */
    public static class ImmutableEntry<E> extends a<E> implements Serializable {
        private static final long serialVersionUID = 0;
        private final int count;

        @Nullable
        private final E element;

        public ImmutableEntry(@Nullable E e2, int i) {
            this.element = e2;
            this.count = i;
            C1555x.a(i, "count");
        }

        @Override // com.google.common.collect.Multiset.Entry
        public final int getCount() {
            return this.count;
        }

        @Override // com.google.common.collect.Multiset.Entry
        @Nullable
        public final E getElement() {
            return this.element;
        }

        public ImmutableEntry<E> nextInBucket() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class a<E> implements Multiset.Entry<E> {
        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            return getCount() == entry.getCount() && Objects.a(getElement(), entry.getElement());
        }

        public int hashCode() {
            E element = getElement();
            return (element == null ? 0 : element.hashCode()) ^ getCount();
        }

        @Override // com.google.common.collect.Multiset.Entry
        public String toString() {
            String valueOf = String.valueOf(getElement());
            int count = getCount();
            if (count == 1) {
                return valueOf;
            }
            return valueOf + " x " + count;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b<E> extends Sets.b<E> {
        abstract Multiset<E> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return a().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return a().containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return new C1491ab(this, a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return a().remove(obj, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().entrySet().size();
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class c<E> extends Sets.b<Multiset.Entry<E>> {
        abstract Multiset<E> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@Nullable Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            return entry.getCount() > 0 && a().count(entry.getElement()) == entry.getCount();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry) obj;
                Object element = entry.getElement();
                int count = entry.getCount();
                if (count != 0) {
                    return a().setCount(element, count, 0);
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class d<E> implements Iterator<E> {

        /* renamed from: a */
        private final Multiset<E> f15612a;

        /* renamed from: b */
        private final Iterator<Multiset.Entry<E>> f15613b;

        /* renamed from: c */
        private Multiset.Entry<E> f15614c;

        /* renamed from: d */
        private int f15615d;

        /* renamed from: e */
        private int f15616e;

        /* renamed from: f */
        private boolean f15617f;

        d(Multiset<E> multiset, Iterator<Multiset.Entry<E>> it) {
            this.f15612a = multiset;
            this.f15613b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f15615d > 0 || this.f15613b.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                if (this.f15615d == 0) {
                    this.f15614c = this.f15613b.next();
                    int count = this.f15614c.getCount();
                    this.f15615d = count;
                    this.f15616e = count;
                }
                this.f15615d--;
                this.f15617f = true;
                return this.f15614c.getElement();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            C1555x.a(this.f15617f);
            if (this.f15616e == 1) {
                this.f15613b.remove();
            } else {
                this.f15612a.remove(this.f15614c.getElement());
            }
            this.f15616e--;
            this.f15617f = false;
        }
    }

    private Multisets() {
    }

    public static <E> Multiset.Entry<E> a(@Nullable E e2, int i) {
        return new ImmutableEntry(e2, i);
    }

    public static int b(Iterable<?> iterable) {
        if (iterable instanceof Multiset) {
            return ((Multiset) iterable).elementSet().size();
        }
        return 11;
    }

    public static boolean c(Multiset<?> multiset, Collection<?> collection) {
        Preconditions.a(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        return multiset.elementSet().retainAll(collection);
    }

    public static boolean a(Multiset<?> multiset, @Nullable Object obj) {
        if (obj == multiset) {
            return true;
        }
        if (obj instanceof Multiset) {
            Multiset multiset2 = (Multiset) obj;
            if (multiset.size() == multiset2.size() && multiset.entrySet().size() == multiset2.entrySet().size()) {
                for (Multiset.Entry entry : multiset2.entrySet()) {
                    if (multiset.count(entry.getElement()) != entry.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean b(Multiset<?> multiset, Collection<?> collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        return multiset.elementSet().removeAll(collection);
    }

    public static int b(Multiset<?> multiset) {
        long j = 0;
        while (multiset.entrySet().iterator().hasNext()) {
            j += r4.next().getCount();
        }
        return Ints.b(j);
    }

    public static <E> boolean a(Multiset<E> multiset, Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        if (collection instanceof Multiset) {
            for (Multiset.Entry<E> entry : a(collection).entrySet()) {
                multiset.add(entry.getElement(), entry.getCount());
            }
            return true;
        }
        Iterators.a(multiset, collection.iterator());
        return true;
    }

    public static <E> int a(Multiset<E> multiset, E e2, int i) {
        C1555x.a(i, "count");
        int count = multiset.count(e2);
        int i2 = i - count;
        if (i2 > 0) {
            multiset.add(e2, i2);
        } else if (i2 < 0) {
            multiset.remove(e2, -i2);
        }
        return count;
    }

    public static <E> boolean a(Multiset<E> multiset, E e2, int i, int i2) {
        C1555x.a(i, "oldCount");
        C1555x.a(i2, "newCount");
        if (multiset.count(e2) != i) {
            return false;
        }
        multiset.setCount(e2, i2);
        return true;
    }

    public static <E> Iterator<E> a(Multiset<E> multiset) {
        return new d(multiset, multiset.entrySet().iterator());
    }

    public static <T> Multiset<T> a(Iterable<T> iterable) {
        return (Multiset) iterable;
    }
}
