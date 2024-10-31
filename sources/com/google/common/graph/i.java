package com.google.common.graph;

import java.util.Set;

/* compiled from: ForwardingGraph.java */
/* loaded from: classes2.dex */
abstract class i<N> extends AbstractGraph<N> {
    @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.Graph
    public Set<EndpointPair<N>> a() {
        return f().a();
    }

    @Override // com.google.common.graph.Graph
    public boolean b() {
        return f().b();
    }

    @Override // com.google.common.graph.Graph
    public boolean c() {
        return f().c();
    }

    @Override // com.google.common.graph.Graph
    public Set<N> d() {
        return f().d();
    }

    protected abstract Graph<N> f();

    @Override // com.google.common.graph.Graph
    public Set<N> a(Object obj) {
        return f().a(obj);
    }

    @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.Graph
    public int b(Object obj) {
        return f().b(obj);
    }

    @Override // com.google.common.graph.Graph
    public Set<N> c(Object obj) {
        return f().c(obj);
    }

    @Override // com.google.common.graph.Graph
    public Set<N> d(Object obj) {
        return f().d(obj);
    }
}
