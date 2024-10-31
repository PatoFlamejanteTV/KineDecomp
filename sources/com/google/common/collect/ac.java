package com.google.common.collect;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: ImmutableList.java */
/* loaded from: classes2.dex */
class ac<E> extends c<E> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ImmutableList f2788a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(ImmutableList immutableList, int i, int i2) {
        super(i, i2);
        this.f2788a = immutableList;
    }

    @Override // com.google.common.collect.c
    protected E a(int i) {
        return this.f2788a.get(i);
    }
}
