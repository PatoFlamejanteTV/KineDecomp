package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {
    public static <E> ImmutableList<E> of() {
        return EmptyImmutableList.INSTANCE;
    }

    public static <E> ImmutableList<E> of(E e) {
        return new SingletonImmutableList(e);
    }

    public static <E> ImmutableList<E> of(E e, E e2) {
        return a(e, e2);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3) {
        return a(e, e2, e3);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4) {
        return a(e, e2, e3, e4);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5) {
        return a(e, e2, e3, e4, e5);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6) {
        return a(e, e2, e3, e4, e5, e6);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7) {
        return a(e, e2, e3, e4, e5, e6, e7);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        return a(e, e2, e3, e4, e5, e6, e7, e8);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
        return a(e, e2, e3, e4, e5, e6, e7, e8, e9);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
        return a(e, e2, e3, e4, e5, e6, e7, e8, e9, e10);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11) {
        return a(e, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11, E e12, E... eArr) {
        Object[] objArr = new Object[eArr.length + 12];
        objArr[0] = e;
        objArr[1] = e2;
        objArr[2] = e3;
        objArr[3] = e4;
        objArr[4] = e5;
        objArr[5] = e6;
        objArr[6] = e7;
        objArr[7] = e8;
        objArr[8] = e9;
        objArr[9] = e10;
        objArr[10] = e11;
        objArr[11] = e12;
        System.arraycopy(eArr, 0, objArr, 12, eArr.length);
        return a(objArr);
    }

    public static <E> ImmutableList<E> copyOf(Iterable<? extends E> iterable) {
        Preconditions.a(iterable);
        return iterable instanceof Collection ? copyOf(Collections2.a(iterable)) : copyOf(iterable.iterator());
    }

    public static <E> ImmutableList<E> copyOf(Collection<? extends E> collection) {
        if (!(collection instanceof ImmutableCollection)) {
            return a(collection);
        }
        ImmutableList<E> asList = ((ImmutableCollection) collection).asList();
        return asList.isPartialView() ? a(asList) : asList;
    }

    public static <E> ImmutableList<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        return new Builder().b((Builder) next).a((Iterator) it).a();
    }

    public static <E> ImmutableList<E> copyOf(E[] eArr) {
        switch (eArr.length) {
            case 0:
                return of();
            case 1:
                return new SingletonImmutableList(eArr[0]);
            default:
                return a((Object[]) eArr.clone());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableList<E> asImmutableList(Object[] objArr) {
        switch (objArr.length) {
            case 0:
                return of();
            case 1:
                return new SingletonImmutableList(objArr[0]);
            default:
                return a(objArr);
        }
    }

    private static <E> ImmutableList<E> a(Collection<? extends E> collection) {
        return asImmutableList(collection.toArray());
    }

    private static <E> ImmutableList<E> a(Object... objArr) {
        for (int i = 0; i < objArr.length; i++) {
            ObjectArrays.a(objArr[i], i);
        }
        return new RegularImmutableList(objArr);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public UnmodifiableListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public UnmodifiableListIterator<E> listIterator(int i) {
        return new ac(this, size(), i);
    }

    public int indexOf(@Nullable Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.b(this, obj);
    }

    public int lastIndexOf(@Nullable Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.c(this, obj);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public boolean contains(@Nullable Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.List
    public ImmutableList<E> subList(int i, int i2) {
        Preconditions.a(i, i2, size());
        switch (i2 - i) {
            case 0:
                return of();
            case 1:
                return of((Object) get(i));
            default:
                return subListUnchecked(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableList<E> subListUnchecked(int i, int i2) {
        return new SubList(i, i2 - i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class SubList extends ImmutableList<E> {
        final transient int length;
        final transient int offset;

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
            return super.listIterator(i);
        }

        SubList(int i, int i2) {
            this.offset = i;
            this.length = i2;
        }

        @Override // java.util.Collection, java.util.List
        public int size() {
            return this.length;
        }

        @Override // java.util.List
        public E get(int i) {
            Preconditions.a(i, this.length);
            return ImmutableList.this.get(this.offset + i);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i, int i2) {
            Preconditions.a(i, i2, this.length);
            return ImmutableList.this.subList(this.offset + i, this.offset + i2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        return this;
    }

    public ImmutableList<E> reverse() {
        return new ReverseImmutableList(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ReverseImmutableList<E> extends ImmutableList<E> {

        /* renamed from: a, reason: collision with root package name */
        private final transient ImmutableList<E> f2690a;
        private final transient int b;

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        ReverseImmutableList(ImmutableList<E> immutableList) {
            this.f2690a = immutableList;
            this.b = immutableList.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a(int i) {
            return (this.b - 1) - i;
        }

        private int b(int i) {
            return this.b - i;
        }

        @Override // com.google.common.collect.ImmutableList
        public ImmutableList<E> reverse() {
            return this.f2690a;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
        public boolean contains(@Nullable Object obj) {
            return this.f2690a.contains(obj);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
        public boolean containsAll(Collection<?> collection) {
            return this.f2690a.containsAll(collection);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(@Nullable Object obj) {
            int lastIndexOf = this.f2690a.lastIndexOf(obj);
            if (lastIndexOf >= 0) {
                return a(lastIndexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(@Nullable Object obj) {
            int indexOf = this.f2690a.indexOf(obj);
            if (indexOf >= 0) {
                return a(indexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i, int i2) {
            Preconditions.a(i, i2, this.b);
            return this.f2690a.subList(b(i2), b(i)).reverse();
        }

        @Override // java.util.List
        public E get(int i) {
            Preconditions.a(i, this.b);
            return this.f2690a.get(a(i));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public UnmodifiableListIterator<E> listIterator(int i) {
            Preconditions.b(i, this.b);
            return new ad(this, this.f2690a.listIterator(b(i)));
        }

        @Override // java.util.Collection, java.util.List
        public int size() {
            return this.b;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f2690a.isEmpty();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.f2690a.isPartialView();
        }
    }

    public boolean equals(Object obj) {
        return Lists.a(this, obj);
    }

    public int hashCode() {
        return Lists.a((List<?>) this);
    }

    /* loaded from: classes2.dex */
    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        Object readResolve() {
            return ImmutableList.copyOf(this.elements);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    /* loaded from: classes2.dex */
    public static final class Builder<E> extends ImmutableCollection.Builder<E> {

        /* renamed from: a, reason: collision with root package name */
        private Object[] f2689a;
        private int b;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* synthetic */ ImmutableCollection.Builder a(Object obj) {
            return b((Builder<E>) obj);
        }

        public Builder() {
            this(4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(int i) {
            this.f2689a = new Object[i];
            this.b = 0;
        }

        Builder<E> a(int i) {
            int i2 = this.b + i;
            if (this.f2689a.length < i2) {
                this.f2689a = ObjectArrays.b(this.f2689a, a(this.f2689a.length, i2));
            }
            return this;
        }

        public Builder<E> b(E e) {
            Preconditions.a(e);
            a(1);
            Object[] objArr = this.f2689a;
            int i = this.b;
            this.b = i + 1;
            objArr[i] = e;
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

        public ImmutableList<E> a() {
            switch (this.b) {
                case 0:
                    return ImmutableList.of();
                case 1:
                    return ImmutableList.of(this.f2689a[0]);
                default:
                    if (this.b == this.f2689a.length) {
                        return new RegularImmutableList(this.f2689a);
                    }
                    return new RegularImmutableList(ObjectArrays.b(this.f2689a, this.b));
            }
        }
    }
}
