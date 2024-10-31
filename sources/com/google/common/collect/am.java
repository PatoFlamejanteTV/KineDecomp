package com.google.common.collect;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Iterators.java */
/* loaded from: classes2.dex */
final class am<T> extends c<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object[] f2797a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(int i, Object[] objArr) {
        super(i);
        this.f2797a = objArr;
    }

    @Override // com.google.common.collect.c
    protected T a(int i) {
        return (T) this.f2797a[i];
    }
}
