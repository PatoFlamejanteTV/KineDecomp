package com.google.common.collect;

import android.support.v7.widget.ActivityChooserView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        int size = size();
        if (size == 0) {
            return ImmutableList.of();
        }
        if (size != 1) {
            return new RegularImmutableAsList(this, toArray());
        }
        return ImmutableList.of((Object) iterator().next());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(@Nullable Object obj);

    @CanIgnoreReturnValue
    public int copyIntoArray(Object[] objArr, int i) {
        Iterator it = iterator();
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return i;
    }

    public abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract UnmodifiableIterator<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        int size = size();
        if (size == 0) {
            return ObjectArrays.f15629a;
        }
        Object[] objArr = new Object[size];
        copyIntoArray(objArr, 0);
        return objArr;
    }

    Object writeReplace() {
        return new ImmutableList.SerializedForm(toArray());
    }

    /* loaded from: classes2.dex */
    public static abstract class Builder<E> {
        public static int a(int i, int i2) {
            if (i2 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i3 = i + (i >> 1) + 1;
            if (i3 < i2) {
                i3 = Integer.highestOneBit(i2 - 1) << 1;
            }
            return i3 < 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : i3;
        }

        @CanIgnoreReturnValue
        public abstract Builder<E> a(E e2);

        @CanIgnoreReturnValue
        public Builder<E> a(E... eArr) {
            for (E e2 : eArr) {
                a((Builder<E>) e2);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> a(Iterator<? extends E> it) {
            while (it.hasNext()) {
                a((Builder<E>) it.next());
            }
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class a<E> extends Builder<E> {

        /* renamed from: a */
        Object[] f15418a;

        /* renamed from: b */
        int f15419b;

        public a(int i) {
            C1555x.a(i, "initialCapacity");
            this.f15418a = new Object[i];
            this.f15419b = 0;
        }

        private void a(int i) {
            Object[] objArr = this.f15418a;
            if (objArr.length < i) {
                this.f15418a = ObjectArrays.a(objArr, Builder.a(objArr.length, i));
            }
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public a<E> a(E e2) {
            Preconditions.a(e2);
            a(this.f15419b + 1);
            Object[] objArr = this.f15418a;
            int i = this.f15419b;
            this.f15419b = i + 1;
            objArr[i] = e2;
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> a(E... eArr) {
            ObjectArrays.a(eArr);
            a(this.f15419b + eArr.length);
            System.arraycopy(eArr, 0, this.f15418a, this.f15419b, eArr.length);
            this.f15419b += eArr.length;
            return this;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final <T> T[] toArray(T[] tArr) {
        Preconditions.a(tArr);
        int size = size();
        if (tArr.length < size) {
            tArr = (T[]) ObjectArrays.c(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        copyIntoArray(tArr, 0);
        return tArr;
    }
}
