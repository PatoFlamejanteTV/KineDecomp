package com.google.common.graph;

import com.google.common.base.Function;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractValueGraph.java */
/* loaded from: classes2.dex */
public class d<N, V> implements Function<EndpointPair<N>, V> {

    /* renamed from: a */
    final /* synthetic */ AbstractValueGraph f15923a;

    public d(AbstractValueGraph abstractValueGraph) {
        this.f15923a = abstractValueGraph;
    }

    @Override // com.google.common.base.Function
    /* renamed from: a */
    public V apply(EndpointPair<N> endpointPair) {
        return (V) this.f15923a.a(endpointPair.d(), endpointPair.e());
    }
}
