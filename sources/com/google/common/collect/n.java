package com.google.common.collect;

import com.google.common.collect.cv;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: AbstractSortedMultiset.java */
/* loaded from: classes2.dex */
public class n<E> extends cv.b<E> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f2884a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.f2884a = mVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.cv.b, com.google.common.collect.Multisets.b
    /* renamed from: b */
    public SortedMultiset<E> a() {
        return this.f2884a;
    }
}
