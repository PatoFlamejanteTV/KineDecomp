package com.google.common.collect;

import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: ConcurrentHashMultiset.java */
/* loaded from: classes2.dex */
class A<E> extends ForwardingSet<E> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Set f15269a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ConcurrentHashMultiset f15270b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(ConcurrentHashMultiset concurrentHashMultiset, Set set) {
        this.f15270b = concurrentHashMultiset;
        this.f15269a = set;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public boolean contains(@Nullable Object obj) {
        return obj != null && Collections2.a(this.f15269a, obj);
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        return standardContainsAll(collection);
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return obj != null && Collections2.b(this.f15269a, obj);
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        return standardRemoveAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public Set<E> delegate() {
        return this.f15269a;
    }
}
