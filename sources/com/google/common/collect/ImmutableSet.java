package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    static final int MAX_TABLE_SIZE = 1073741824;

    /* renamed from: a */
    @LazyInit
    private transient ImmutableList<E> f15462a;

    /* loaded from: classes2.dex */
    public static class Builder<E> extends ImmutableCollection.a<E> {
        public Builder() {
            this(4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder a(Object obj) {
            return a((Builder<E>) obj);
        }

        public Builder(int i) {
            super(i);
        }

        @Override // com.google.common.collect.ImmutableCollection.a, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> a(E e2) {
            super.a((Builder<E>) e2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.a, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> a(E... eArr) {
            super.a((Object[]) eArr);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> a(Iterator<? extends E> it) {
            super.a((Iterator) it);
            return this;
        }

        public ImmutableSet<E> a() {
            ImmutableSet<E> a2 = ImmutableSet.a(this.f15419b, this.f15418a);
            this.f15419b = a2.size();
            return a2;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Indexed<E> extends ImmutableSet<E> {

        /* renamed from: com.google.common.collect.ImmutableSet$Indexed$1 */
        /* loaded from: classes2.dex */
        class AnonymousClass1 extends ImmutableAsList<E> {
            AnonymousClass1() {
            }

            @Override // java.util.List
            public E get(int i) {
                return (E) Indexed.this.get(i);
            }

            @Override // com.google.common.collect.ImmutableAsList
            public Indexed<E> delegateCollection() {
                return Indexed.this;
            }
        }

        @Override // com.google.common.collect.ImmutableSet
        ImmutableList<E> createAsList() {
            return new ImmutableAsList<E>() { // from class: com.google.common.collect.ImmutableSet.Indexed.1
                AnonymousClass1() {
                }

                @Override // java.util.List
                public E get(int i) {
                    return (E) Indexed.this.get(i);
                }

                @Override // com.google.common.collect.ImmutableAsList
                public Indexed<E> delegateCollection() {
                    return Indexed.this;
                }
            };
        }

        abstract E get(int i);

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public UnmodifiableIterator<E> iterator() {
            return asList().iterator();
        }
    }

    /* loaded from: classes2.dex */
    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    public static <E> ImmutableSet<E> a(int i, Object... objArr) {
        if (i == 0) {
            return of();
        }
        if (i != 1) {
            int chooseTableSize = chooseTableSize(i);
            Object[] objArr2 = new Object[chooseTableSize];
            int i2 = chooseTableSize - 1;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                Object obj = objArr[i5];
                ObjectArrays.a(obj, i5);
                int hashCode = obj.hashCode();
                int a2 = Q.a(hashCode);
                while (true) {
                    int i6 = a2 & i2;
                    Object obj2 = objArr2[i6];
                    if (obj2 == null) {
                        objArr[i3] = obj;
                        objArr2[i6] = obj;
                        i4 += hashCode;
                        i3++;
                        break;
                    }
                    if (obj2.equals(obj)) {
                        break;
                    }
                    a2++;
                }
            }
            Arrays.fill(objArr, i3, i, (Object) null);
            if (i3 == 1) {
                return new SingletonImmutableSet(objArr[0], i4);
            }
            if (chooseTableSize != chooseTableSize(i3)) {
                return a(i3, objArr);
            }
            if (i3 < objArr.length) {
                objArr = ObjectArrays.a(objArr, i3);
            }
            return new RegularImmutableSet(objArr, i4, objArr2, i2);
        }
        return of(objArr[0]);
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    @VisibleForTesting
    static int chooseTableSize(int i) {
        if (i < 751619276) {
            int highestOneBit = Integer.highestOneBit(i - 1) << 1;
            while (true) {
                double d2 = highestOneBit;
                Double.isNaN(d2);
                if (d2 * 0.7d >= i) {
                    return highestOneBit;
                }
                highestOneBit <<= 1;
            }
        } else {
            Preconditions.a(i < MAX_TABLE_SIZE, "collection too large");
            return MAX_TABLE_SIZE;
        }
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof ImmutableSortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        } else if (collection instanceof EnumSet) {
            return a((EnumSet) collection);
        }
        Object[] array = collection.toArray();
        return a(array.length, array);
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.f15462a;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> createAsList = createAsList();
        this.f15462a = createAsList;
        return createAsList;
    }

    ImmutableList<E> createAsList() {
        return new RegularImmutableAsList(this, toArray());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Sets.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.a(this);
    }

    boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract UnmodifiableIterator<E> iterator();

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> ImmutableSet<E> of(E e2) {
        return new SingletonImmutableSet(e2);
    }

    public static <E> ImmutableSet<E> of(E e2, E e3) {
        return a(2, e2, e3);
    }

    public static <E> ImmutableSet<E> of(E e2, E e3, E e4) {
        return a(3, e2, e3, e4);
    }

    public static <E> ImmutableSet<E> of(E e2, E e3, E e4, E e5) {
        return a(4, e2, e3, e4, e5);
    }

    public static <E> ImmutableSet<E> of(E e2, E e3, E e4, E e5, E e6) {
        return a(5, e2, e3, e4, e5, e6);
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E... eArr) {
        Object[] objArr = new Object[eArr.length + 6];
        objArr[0] = e2;
        objArr[1] = e3;
        objArr[2] = e4;
        objArr[3] = e5;
        objArr[4] = e6;
        objArr[5] = e7;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return a(objArr.length, objArr);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        return iterable instanceof Collection ? copyOf((Collection) iterable) : copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        return new Builder().a((Builder) next).a((Iterator) it).a();
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return a(eArr.length, (Object[]) eArr.clone());
        }
        return of((Object) eArr[0]);
    }

    private static ImmutableSet a(EnumSet enumSet) {
        return ImmutableEnumSet.asImmutable(EnumSet.copyOf(enumSet));
    }
}
