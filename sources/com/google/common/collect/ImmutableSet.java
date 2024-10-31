package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    static final int MAX_TABLE_SIZE = 1073741824;

    /* renamed from: a, reason: collision with root package name */
    private static final int f2699a = (int) Math.floor(7.516192768E8d);

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public abstract UnmodifiableIterator<E> iterator();

    public static <E> ImmutableSet<E> of() {
        return EmptyImmutableSet.INSTANCE;
    }

    public static <E> ImmutableSet<E> of(E e) {
        return new SingletonImmutableSet(e);
    }

    public static <E> ImmutableSet<E> of(E e, E e2) {
        return a(2, e, e2);
    }

    public static <E> ImmutableSet<E> of(E e, E e2, E e3) {
        return a(3, e, e2, e3);
    }

    public static <E> ImmutableSet<E> of(E e, E e2, E e3, E e4) {
        return a(4, e, e2, e3, e4);
    }

    public static <E> ImmutableSet<E> of(E e, E e2, E e3, E e4, E e5) {
        return a(5, e, e2, e3, e4, e5);
    }

    public static <E> ImmutableSet<E> of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        Object[] objArr = new Object[eArr.length + 6];
        objArr[0] = e;
        objArr[1] = e2;
        objArr[2] = e3;
        objArr[3] = e4;
        objArr[4] = e5;
        objArr[5] = e6;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return a(objArr.length, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ImmutableSet<E> a(int i, Object... objArr) {
        int i2;
        int i3;
        switch (i) {
            case 0:
                return of();
            case 1:
                return of(objArr[0]);
            default:
                int chooseTableSize = chooseTableSize(i);
                Object[] objArr2 = new Object[chooseTableSize];
                int i4 = chooseTableSize - 1;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i5 < i) {
                    Object a2 = ObjectArrays.a(objArr[i5], i5);
                    int hashCode = a2.hashCode();
                    int a3 = ab.a(hashCode);
                    while (true) {
                        int i8 = a3 & i4;
                        Object obj = objArr2[i8];
                        if (obj == null) {
                            i2 = i6 + 1;
                            objArr[i6] = a2;
                            objArr2[i8] = a2;
                            i3 = i7 + hashCode;
                        } else if (obj.equals(a2)) {
                            i2 = i6;
                            i3 = i7;
                        } else {
                            a3++;
                        }
                    }
                    i5++;
                    i7 = i3;
                    i6 = i2;
                }
                Arrays.fill(objArr, i6, i, (Object) null);
                if (i6 == 1) {
                    return new SingletonImmutableSet(objArr[0], i7);
                }
                if (chooseTableSize != chooseTableSize(i6)) {
                    return a(i6, objArr);
                }
                if (i6 < objArr.length) {
                    objArr = ObjectArrays.b(objArr, i6);
                }
                return new RegularImmutableSet(objArr, i7, objArr2, i4);
        }
    }

    @VisibleForTesting
    static int chooseTableSize(int i) {
        if (i < f2699a) {
            int highestOneBit = Integer.highestOneBit(i - 1);
            do {
                highestOneBit <<= 1;
            } while (highestOneBit * 0.7d < i);
            return highestOneBit;
        }
        Preconditions.a(i < MAX_TABLE_SIZE, "collection too large");
        return MAX_TABLE_SIZE;
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        switch (eArr.length) {
            case 0:
                return of();
            case 1:
                return of((Object) eArr[0]);
            default:
                return a(eArr.length, (Object[]) eArr.clone());
        }
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        return iterable instanceof Collection ? copyOf(Collections2.a(iterable)) : copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        return new Builder().b((Builder) next).a((Iterator) it).a();
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof ImmutableSortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        }
        return a(collection);
    }

    private static <E> ImmutableSet<E> a(Collection<? extends E> collection) {
        Object[] array = collection.toArray();
        switch (array.length) {
            case 0:
                return of();
            case 1:
                return of(array[0]);
            default:
                return a(array.length, array);
        }
    }

    boolean isHashCodeFast() {
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Sets.a(this, obj);
    }

    public int hashCode() {
        return Sets.a(this);
    }

    /* loaded from: classes2.dex */
    static abstract class ArrayImmutableSet<E> extends ImmutableSet<E> {
        final transient Object[] elements;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ArrayImmutableSet(Object[] objArr) {
            this.elements = objArr;
        }

        @Override // java.util.Collection, java.util.Set
        public int size() {
            return this.elements.length;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<E> iterator() {
            return asList().iterator();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            return asList().toArray();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
        public <T> T[] toArray(T[] tArr) {
            return (T[]) asList().toArray(tArr);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
        public boolean containsAll(Collection<?> collection) {
            if (collection == this) {
                return true;
            }
            if (!(collection instanceof ArrayImmutableSet)) {
                return super.containsAll(collection);
            }
            if (collection.size() > size()) {
                return false;
            }
            for (Object obj : ((ArrayImmutableSet) collection).elements) {
                if (!contains(obj)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        ImmutableList<E> createAsList() {
            return new RegularImmutableAsList(this, this.elements);
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

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    /* loaded from: classes2.dex */
    public static class Builder<E> extends ImmutableCollection.Builder<E> {

        /* renamed from: a, reason: collision with root package name */
        Object[] f2700a;
        int b;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* synthetic */ ImmutableCollection.Builder a(Object obj) {
            return b((Builder<E>) obj);
        }

        public Builder() {
            this(4);
        }

        Builder(int i) {
            Preconditions.a(i >= 0, "capacity must be >= 0 but was %s", Integer.valueOf(i));
            this.f2700a = new Object[i];
            this.b = 0;
        }

        Builder<E> a(int i) {
            int i2 = this.b + i;
            if (this.f2700a.length < i2) {
                this.f2700a = ObjectArrays.b(this.f2700a, a(this.f2700a.length, i2));
            }
            return this;
        }

        public Builder<E> b(E e) {
            a(1);
            Object[] objArr = this.f2700a;
            int i = this.b;
            this.b = i + 1;
            objArr[i] = Preconditions.a(e);
            return this;
        }

        public Builder<E> a(E... eArr) {
            for (int i = 0; i < eArr.length; i++) {
                ObjectArrays.a(eArr[i], i);
            }
            a(eArr.length);
            System.arraycopy(eArr, 0, this.f2700a, this.b, eArr.length);
            this.b += eArr.length;
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Builder<E> a(Iterable<? extends E> iterable) {
            if (iterable instanceof Collection) {
                a(((Collection) iterable).size());
            }
            super.a((Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Builder<E> a(Iterator<? extends E> it) {
            super.a((Iterator) it);
            return this;
        }

        public ImmutableSet<E> a() {
            ImmutableSet<E> a2 = ImmutableSet.a(this.b, this.f2700a);
            this.b = a2.size();
            return a2;
        }
    }
}
