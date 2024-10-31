package com.google.common.collect;

import java.util.Collection;
import java.util.Set;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: ConcurrentHashMultiset.java */
/* loaded from: classes2.dex */
class x<E> extends ForwardingSet<E> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Set f2893a;
    final /* synthetic */ ConcurrentHashMultiset b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(ConcurrentHashMultiset concurrentHashMultiset, Set set) {
        this.b = concurrentHashMultiset;
        this.f2893a = set;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public Set<E> delegate() {
        return this.f2893a;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        try {
            return this.f2893a.remove(obj);
        } catch (ClassCastException e) {
            return false;
        } catch (NullPointerException e2) {
            return false;
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        return standardRemoveAll(collection);
    }
}
