package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Set;

@Beta
/* loaded from: classes2.dex */
public abstract class ImmutableGraph<N> extends i<N> {

    /* loaded from: classes2.dex */
    static class a<N, V> extends ImmutableGraph<N> {

        /* renamed from: a */
        protected final ValueGraph<N, V> f15920a;

        @Override // com.google.common.graph.i
        protected Graph<N> f() {
            return this.f15920a;
        }
    }

    ImmutableGraph() {
    }

    @Override // com.google.common.graph.i, com.google.common.graph.AbstractGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set a() {
        return super.a();
    }

    @Override // com.google.common.graph.i, com.google.common.graph.AbstractGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ int b(Object obj) {
        return super.b(obj);
    }

    @Override // com.google.common.graph.i, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean c() {
        return super.c();
    }

    @Override // com.google.common.graph.i, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set d(Object obj) {
        return super.d(obj);
    }

    @Override // com.google.common.graph.i, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set a(Object obj) {
        return super.a(obj);
    }

    @Override // com.google.common.graph.i, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean b() {
        return super.b();
    }

    @Override // com.google.common.graph.i, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set c(Object obj) {
        return super.c(obj);
    }

    @Override // com.google.common.graph.i, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set d() {
        return super.d();
    }
}
