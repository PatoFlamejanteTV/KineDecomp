package com.google.common.collect;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImmutableList.java */
/* loaded from: classes2.dex */
public class V<E> extends AbstractC1492b<E> {

    /* renamed from: c */
    final /* synthetic */ ImmutableList f15745c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V(ImmutableList immutableList, int i, int i2) {
        super(i, i2);
        this.f15745c = immutableList;
    }

    @Override // com.google.common.collect.AbstractC1492b
    protected E a(int i) {
        return this.f15745c.get(i);
    }
}
