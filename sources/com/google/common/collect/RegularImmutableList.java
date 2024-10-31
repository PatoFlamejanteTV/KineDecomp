package com.google.common.collect;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class RegularImmutableList<E> extends ImmutableList<E> {
    static final ImmutableList<Object> EMPTY = new RegularImmutableList(ObjectArrays.f15629a);

    /* renamed from: a, reason: collision with root package name */
    private final transient Object[] f15648a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularImmutableList(Object[] objArr) {
        this.f15648a = objArr;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] objArr, int i) {
        Object[] objArr2 = this.f15648a;
        System.arraycopy(objArr2, 0, objArr, i, objArr2.length);
        return i + this.f15648a.length;
    }

    @Override // java.util.List
    public E get(int i) {
        return (E) this.f15648a[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f15648a.length;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public UnmodifiableListIterator<E> listIterator(int i) {
        Object[] objArr = this.f15648a;
        return Iterators.a(objArr, 0, objArr.length, i);
    }
}
