package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class RegularImmutableSet<E> extends ImmutableSet.Indexed<E> {
    static final RegularImmutableSet<Object> EMPTY = new RegularImmutableSet<>(ObjectArrays.f15629a, 0, null, 0);

    /* renamed from: b, reason: collision with root package name */
    private final transient Object[] f15657b;

    /* renamed from: c, reason: collision with root package name */
    private final transient int f15658c;

    /* renamed from: d, reason: collision with root package name */
    private final transient int f15659d;

    @VisibleForTesting
    final transient Object[] table;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularImmutableSet(Object[] objArr, int i, Object[] objArr2, int i2) {
        this.f15657b = objArr;
        this.table = objArr2;
        this.f15658c = i2;
        this.f15659d = i;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@Nullable Object obj) {
        Object[] objArr = this.table;
        if (obj == null || objArr == null) {
            return false;
        }
        int a2 = Q.a(obj);
        while (true) {
            int i = a2 & this.f15658c;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            a2 = i + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i) {
        Object[] objArr2 = this.f15657b;
        System.arraycopy(objArr2, 0, objArr, i, objArr2.length);
        return i + this.f15657b.length;
    }

    @Override // com.google.common.collect.ImmutableSet.Indexed, com.google.common.collect.ImmutableSet
    ImmutableList<E> createAsList() {
        return this.table == null ? ImmutableList.of() : new RegularImmutableAsList(this, this.f15657b);
    }

    @Override // com.google.common.collect.ImmutableSet.Indexed
    E get(int i) {
        return (E) this.f15657b[i];
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f15659d;
    }

    @Override // com.google.common.collect.ImmutableSet
    boolean isHashCodeFast() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f15657b.length;
    }
}
