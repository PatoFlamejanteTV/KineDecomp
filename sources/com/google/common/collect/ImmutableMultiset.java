package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ImmutableMultiset<E> extends ImmutableCollection<E> implements Multiset<E> {

    /* renamed from: a, reason: collision with root package name */
    private transient ImmutableSet<Multiset.Entry<E>> f2697a;

    abstract ImmutableSet<Multiset.Entry<E>> createEntrySet();

    public static <E> ImmutableMultiset<E> of() {
        return EmptyImmutableMultiset.INSTANCE;
    }

    public static <E> ImmutableMultiset<E> of(E e) {
        return a(e);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2) {
        return a(e, e2);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3) {
        return a(e, e2, e3);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4) {
        return a(e, e2, e3, e4);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4, E e5) {
        return a(e, e2, e3, e4, e5);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        ArrayList arrayList = new ArrayList(eArr.length + 6);
        Collections.addAll(arrayList, e, e2, e3, e4, e5, e6);
        Collections.addAll(arrayList, eArr);
        return copyOf(arrayList);
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] eArr) {
        return copyOf(Arrays.asList(eArr));
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.isPartialView()) {
                return immutableMultiset;
            }
        }
        return a(iterable instanceof Multiset ? Multisets.b(iterable) : LinkedHashMultiset.create(iterable));
    }

    private static <E> ImmutableMultiset<E> a(E... eArr) {
        return copyOf(Arrays.asList(eArr));
    }

    private static <E> ImmutableMultiset<E> a(Multiset<? extends E> multiset) {
        return copyFromEntries(multiset.entrySet());
    }

    static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends Multiset.Entry<? extends E>> collection) {
        long j;
        ImmutableMap.Builder builder = ImmutableMap.builder();
        long j2 = 0;
        for (Multiset.Entry<? extends E> entry : collection) {
            int count = entry.getCount();
            if (count > 0) {
                builder.b(entry.getElement(), Integer.valueOf(count));
                j = count + j2;
            } else {
                j = j2;
            }
            j2 = j;
        }
        return j2 == 0 ? of() : new RegularImmutableMultiset(builder.b(), Ints.a(j2));
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> it) {
        LinkedHashMultiset create = LinkedHashMultiset.create();
        Iterators.a(create, it);
        return a(create);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<E> iterator() {
        return new ag(this, entrySet().iterator());
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public boolean contains(@Nullable Object obj) {
        return count(obj) > 0;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection<?> collection) {
        return elementSet().containsAll(collection);
    }

    @Override // com.google.common.collect.Multiset
    public final int add(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    public final int remove(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    public final int setCount(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    public final boolean setCount(E e, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Multiset)) {
            return false;
        }
        Multiset multiset = (Multiset) obj;
        if (size() != multiset.size()) {
            return false;
        }
        for (Multiset.Entry<E> entry : multiset.entrySet()) {
            if (count(entry.getElement()) != entry.getCount()) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return Sets.a(entrySet());
    }

    @Override // com.google.common.collect.ImmutableCollection
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.Multiset
    public ImmutableSet<Multiset.Entry<E>> entrySet() {
        ImmutableSet<Multiset.Entry<E>> immutableSet = this.f2697a;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Multiset.Entry<E>> createEntrySet = createEntrySet();
        this.f2697a = createEntrySet;
        return createEntrySet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public abstract class EntrySet extends ImmutableSet<Multiset.Entry<E>> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        public EntrySet() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableMultiset.this.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            return entry.getCount() > 0 && ImmutableMultiset.this.count(entry.getElement()) == entry.getCount();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            return toArray(new Object[size()]);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
        public <T> T[] toArray(T[] tArr) {
            int size = size();
            if (tArr.length < size) {
                tArr = (T[]) ObjectArrays.a((Object[]) tArr, size);
            } else if (tArr.length > size) {
                tArr[size] = null;
            }
            UnmodifiableIterator<Multiset.Entry<E>> it = iterator();
            int i = 0;
            while (it.hasNext()) {
                tArr[i] = it.next();
                i++;
            }
            return tArr;
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }
    }

    /* loaded from: classes2.dex */
    static class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> multiset;

        EntrySetSerializedForm(ImmutableMultiset<E> immutableMultiset) {
            this.multiset = immutableMultiset;
        }

        Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    /* loaded from: classes2.dex */
    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final int[] counts;
        final Object[] elements;

        SerializedForm(Multiset<?> multiset) {
            int size = multiset.entrySet().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            int i = 0;
            Iterator<Multiset.Entry<?>> it = multiset.entrySet().iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    Multiset.Entry<?> next = it.next();
                    this.elements[i2] = next.getElement();
                    this.counts[i2] = next.getCount();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        Object readResolve() {
            LinkedHashMultiset create = LinkedHashMultiset.create(this.elements.length);
            for (int i = 0; i < this.elements.length; i++) {
                create.add(this.elements[i], this.counts[i]);
            }
            return ImmutableMultiset.copyOf(create);
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    /* loaded from: classes2.dex */
    public static class Builder<E> extends ImmutableCollection.Builder<E> {

        /* renamed from: a, reason: collision with root package name */
        final Multiset<E> f2698a;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* synthetic */ ImmutableCollection.Builder a(Object obj) {
            return b((Builder<E>) obj);
        }

        public Builder() {
            this(LinkedHashMultiset.create());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(Multiset<E> multiset) {
            this.f2698a = multiset;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder<E> b(E e) {
            this.f2698a.add(Preconditions.a(e));
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder<E> a(E e, int i) {
            this.f2698a.add(Preconditions.a(e), i);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Builder<E> a(Iterable<? extends E> iterable) {
            if (iterable instanceof Multiset) {
                for (Multiset.Entry<E> entry : Multisets.b(iterable).entrySet()) {
                    a((Builder<E>) entry.getElement(), entry.getCount());
                }
            } else {
                super.a((Iterable) iterable);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Builder<E> a(Iterator<? extends E> it) {
            super.a((Iterator) it);
            return this;
        }
    }
}
