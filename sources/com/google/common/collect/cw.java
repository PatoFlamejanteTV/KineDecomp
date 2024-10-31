package com.google.common.collect;

import com.google.common.collect.cv;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: SortedMultisets.java */
/* loaded from: classes2.dex */
class cw<E> extends cv.b<E> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cv.a f2851a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(cv.a aVar) {
        this.f2851a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.cv.b, com.google.common.collect.Multisets.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SortedMultiset<E> a() {
        return this.f2851a;
    }
}
