package com.google.common.graph;

import java.util.Set;

/* compiled from: ConfigurableNetwork.java */
/* loaded from: classes2.dex */
class e<N, E> extends AbstractNetwork<N, E> {

    /* renamed from: a */
    private final boolean f15924a;

    /* renamed from: b */
    private final boolean f15925b;

    /* renamed from: c */
    private final boolean f15926c;

    /* renamed from: d */
    protected final j<N, Object<N, E>> f15927d;

    /* renamed from: e */
    protected final j<E, N> f15928e;

    @Override // com.google.common.graph.Network
    public Set<E> a() {
        this.f15928e.a();
        throw null;
    }

    @Override // com.google.common.graph.Network
    public boolean b() {
        return this.f15924a;
    }

    @Override // com.google.common.graph.Network
    public boolean c() {
        return this.f15926c;
    }

    @Override // com.google.common.graph.Network
    public Set<N> d() {
        this.f15927d.a();
        throw null;
    }

    @Override // com.google.common.graph.Network
    public boolean e() {
        return this.f15925b;
    }

    @Override // com.google.common.graph.Network
    public EndpointPair<N> a(Object obj) {
        this.f15927d.a(b(obj));
        throw null;
    }

    protected final N b(Object obj) {
        this.f15928e.a(obj);
        throw null;
    }
}
