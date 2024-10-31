package com.google.common.collect;

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

    /* renamed from: a, reason: collision with root package name */
    private static final Ordering<Multiset.Entry<?>> f2746a = new cl();

    private Multisets() {
    }

    public static <E> Multiset.Entry<E> a(@Nullable E e, int i) {
        return new ImmutableEntry(e, i);
    }

    /* loaded from: classes.dex */
    static final class ImmutableEntry<E> extends a<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final int count;

        @Nullable
        final E element;

        ImmutableEntry(@Nullable E e, int i) {
            this.element = e;
            this.count = i;
            Preconditions.a(i >= 0);
        }

        @Override // com.google.common.collect.Multiset.Entry
        @Nullable
        public E getElement() {
            return this.element;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int getCount() {
            return this.count;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Iterable<?> iterable) {
        if (iterable instanceof Multiset) {
            return ((Multiset) iterable).elementSet().size();
        }
        return 11;
    }

    /* loaded from: classes2.dex */
    static abstract class a<E> implements Multiset.Entry<E> {
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

        public String toString() {
            String valueOf = String.valueOf(getElement());
            int count = getCount();
            return count == 1 ? valueOf : valueOf + " x " + count;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Multiset<?> multiset, @Nullable Object obj) {
        if (obj == multiset) {
            return true;
        }
        if (!(obj instanceof Multiset)) {
            return false;
        }
        Multiset multiset2 = (Multiset) obj;
        if (multiset.size() != multiset2.size() || multiset.entrySet().size() != multiset2.entrySet().size()) {
            return false;
        }
        for (Multiset.Entry entry : multiset2.entrySet()) {
            if (multiset.count(entry.getElement()) != entry.getCount()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> boolean a(Multiset<E> multiset, Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        if (collection instanceof Multiset) {
            for (Multiset.Entry<E> entry : b(collection).entrySet()) {
                multiset.add(entry.getElement(), entry.getCount());
            }
        } else {
            Iterators.a(multiset, collection.iterator());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Multiset<?> multiset, Collection<?> collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        return multiset.elementSet().removeAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Multiset<?> multiset, Collection<?> collection) {
        Preconditions.a(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        return multiset.elementSet().retainAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> int a(Multiset<E> multiset, E e, int i) {
        a(i, "count");
        int count = multiset.count(e);
        int i2 = i - count;
        if (i2 > 0) {
            multiset.add(e, i2);
        } else if (i2 < 0) {
            multiset.remove(e, -i2);
        }
        return count;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> boolean a(Multiset<E> multiset, E e, int i, int i2) {
        a(i, "oldCount");
        a(i2, "newCount");
        if (multiset.count(e) != i) {
            return false;
        }
        multiset.setCount(e, i2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class b<E> extends Sets.a<E> {
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
            return new cm(this, a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int count = a().count(obj);
            if (count <= 0) {
                return false;
            }
            a().remove(obj, count);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().entrySet().size();
        }
    }

    /* loaded from: classes2.dex */
    static abstract class c<E> extends Sets.a<Multiset.Entry<E>> {
        abstract Multiset<E> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@Nullable Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            return entry.getCount() > 0 && a().count(entry.getElement()) == entry.getCount();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return contains(obj) && a().elementSet().remove(((Multiset.Entry) obj).getElement());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Iterator<E> a(Multiset<E> multiset) {
        return new d(multiset, multiset.entrySet().iterator());
    }

    /* loaded from: classes2.dex */
    static final class d<E> implements Iterator<E> {

        /* renamed from: a, reason: collision with root package name */
        private final Multiset<E> f2747a;
        private final Iterator<Multiset.Entry<E>> b;
        private Multiset.Entry<E> c;
        private int d;
        private int e;
        private boolean f;

        d(Multiset<E> multiset, Iterator<Multiset.Entry<E>> it) {
            this.f2747a = multiset;
            this.b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.d > 0 || this.b.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (this.d == 0) {
                this.c = this.b.next();
                int count = this.c.getCount();
                this.d = count;
                this.e = count;
            }
            this.d--;
            this.f = true;
            return this.c.getElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            Iterators.a(this.f);
            if (this.e == 1) {
                this.b.remove();
            } else {
                this.f2747a.remove(this.c.getElement());
            }
            this.e--;
            this.f = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(Multiset<?> multiset) {
        long j = 0;
        while (true) {
            long j2 = j;
            if (multiset.entrySet().iterator().hasNext()) {
                j = r4.next().getCount() + j2;
            } else {
                return Ints.a(j2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i, String str) {
        Preconditions.a(i >= 0, "%s cannot be negative: %s", str, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Multiset<T> b(Iterable<T> iterable) {
        return (Multiset) iterable;
    }
}
