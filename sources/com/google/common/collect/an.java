package com.google.common.collect;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Iterators.java */
/* loaded from: classes2.dex */
final class an<T> extends c<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object[] f2798a;
    final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(int i, int i2, Object[] objArr, int i3) {
        super(i, i2);
        this.f2798a = objArr;
        this.b = i3;
    }

    @Override // com.google.common.collect.c
    protected T a(int i) {
        return (T) this.f2798a[this.b + i];
    }
}
