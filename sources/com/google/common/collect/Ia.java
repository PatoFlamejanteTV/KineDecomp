package com.google.common.collect;

import java.util.Collection;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Maps.java */
/* loaded from: classes2.dex */
public class Ia<E> extends ForwardingSet<E> {

    /* renamed from: a */
    final /* synthetic */ Set f15414a;

    public Ia(Set set) {
        this.f15414a = set;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
    public boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public Set<E> delegate() {
        return this.f15414a;
    }
}
