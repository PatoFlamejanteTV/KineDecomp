package com.google.common.graph;

import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import javax.annotation.Nullable;

/* JADX INFO: Add missing generic type declarations: [N] */
/* compiled from: AbstractGraph.java */
/* loaded from: classes2.dex */
class a<N> extends AbstractSet<EndpointPair<N>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AbstractGraph f15921a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbstractGraph abstractGraph) {
        this.f15921a = abstractGraph;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@Nullable Object obj) {
        if (!(obj instanceof EndpointPair)) {
            return false;
        }
        EndpointPair endpointPair = (EndpointPair) obj;
        return this.f15921a.b() == endpointPair.a() && this.f15921a.d().contains(endpointPair.d()) && this.f15921a.c(endpointPair.d()).contains(endpointPair.e());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return Ints.b(this.f15921a.e());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<EndpointPair<N>> iterator() {
        return h.a(this.f15921a);
    }
}
