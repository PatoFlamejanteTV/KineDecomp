package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes2.dex */
public class RegularImmutableList<E> extends ImmutableList<E> {

    /* renamed from: a */
    private final transient int f2752a;
    private final transient int b;
    private final transient Object[] c;

    RegularImmutableList(Object[] objArr, int i, int i2) {
        this.f2752a = i;
        this.b = i2;
        this.c = objArr;
    }

    public RegularImmutableList(Object[] objArr) {
        this(objArr, 0, objArr.length);
    }

    @Override // java.util.Collection, java.util.List
    public int size() {
        return this.b;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return (this.f2752a == 0 && this.b == this.c.length) ? false : true;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        System.arraycopy(this.c, this.f2752a, objArr, 0, this.b);
        return objArr;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.b) {
            tArr = (T[]) ObjectArrays.a((Object[]) tArr, this.b);
        } else if (tArr.length > this.b) {
            tArr[this.b] = null;
        }
        System.arraycopy(this.c, this.f2752a, tArr, 0, this.b);
        return tArr;
    }

    @Override // java.util.List
    public E get(int i) {
        Preconditions.a(i, this.b);
        return (E) this.c[this.f2752a + i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableList
    public ImmutableList<E> subListUnchecked(int i, int i2) {
        return new RegularImmutableList(this.c, this.f2752a + i, i2 - i);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public UnmodifiableListIterator<E> listIterator(int i) {
        return Iterators.a(this.c, this.f2752a, this.b, i);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.Collection, java.util.List
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        if (size() != list.size()) {
            return false;
        }
        int i = this.f2752a;
        if (obj instanceof RegularImmutableList) {
            RegularImmutableList regularImmutableList = (RegularImmutableList) obj;
            int i2 = regularImmutableList.f2752a;
            while (i2 < regularImmutableList.f2752a + regularImmutableList.b) {
                int i3 = i + 1;
                if (!this.c[i].equals(regularImmutableList.c[i2])) {
                    return false;
                }
                i2++;
                i = i3;
            }
        } else {
            Iterator<E> it = list.iterator();
            while (it.hasNext()) {
                int i4 = i + 1;
                if (!this.c[i].equals(it.next())) {
                    return false;
                }
                i = i4;
            }
        }
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public String toString() {
        StringBuilder append = Collections2.a(size()).append('[').append(this.c[this.f2752a]);
        int i = this.f2752a;
        while (true) {
            i++;
            if (i < this.f2752a + this.b) {
                append.append(", ").append(this.c[i]);
            } else {
                return append.append(']').toString();
            }
        }
    }
}
