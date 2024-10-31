package com.google.common.graph;

import com.google.common.base.Function;

/* compiled from: AbstractNetwork.java */
/* loaded from: classes2.dex */
public class c<E, N> implements Function<E, EndpointPair<N>> {

    /* renamed from: a */
    final /* synthetic */ AbstractNetwork f15922a;

    public c(AbstractNetwork abstractNetwork) {
        this.f15922a = abstractNetwork;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.base.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return apply((c<E, N>) obj);
    }

    @Override // com.google.common.base.Function
    public EndpointPair<N> apply(E e2) {
        return this.f15922a.a(e2);
    }
}
