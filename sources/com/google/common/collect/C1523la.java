package com.google.common.collect;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Iterators.java */
/* renamed from: com.google.common.collect.la */
/* loaded from: classes2.dex */
public class C1523la<T> extends AbstractC1492b<T> {

    /* renamed from: c */
    final /* synthetic */ Object[] f15822c;

    /* renamed from: d */
    final /* synthetic */ int f15823d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1523la(int i, int i2, Object[] objArr, int i3) {
        super(i, i2);
        this.f15822c = objArr;
        this.f15823d = i3;
    }

    @Override // com.google.common.collect.AbstractC1492b
    protected T a(int i) {
        return (T) this.f15822c[this.f15823d + i];
    }
}
