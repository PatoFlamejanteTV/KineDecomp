package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EndpointPairIterator.java */
/* loaded from: classes2.dex */
public abstract class h<N> extends AbstractIterator<EndpointPair<N>> {

    /* renamed from: c, reason: collision with root package name */
    private final Graph<N> f15929c;

    /* renamed from: d, reason: collision with root package name */
    private final Iterator<N> f15930d;

    /* renamed from: e, reason: collision with root package name */
    protected N f15931e;

    /* renamed from: f, reason: collision with root package name */
    protected Iterator<N> f15932f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EndpointPairIterator.java */
    /* loaded from: classes2.dex */
    public static final class a<N> extends h<N> {
        private a(Graph<N> graph) {
            super(graph);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        public EndpointPair<N> b() {
            while (!this.f15932f.hasNext()) {
                if (!d()) {
                    return c();
                }
            }
            return EndpointPair.a(this.f15931e, this.f15932f.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EndpointPairIterator.java */
    /* loaded from: classes2.dex */
    public static final class b<N> extends h<N> {

        /* renamed from: g, reason: collision with root package name */
        private Set<N> f15933g;

        private b(Graph<N> graph) {
            super(graph);
            this.f15933g = Sets.a(graph.d().size());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        public EndpointPair<N> b() {
            while (true) {
                if (this.f15932f.hasNext()) {
                    N next = this.f15932f.next();
                    if (!this.f15933g.contains(next)) {
                        return EndpointPair.b(this.f15931e, next);
                    }
                } else {
                    this.f15933g.add(this.f15931e);
                    if (!d()) {
                        this.f15933g = null;
                        return c();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <N> h<N> a(Graph<N> graph) {
        return graph.b() ? new a(graph) : new b(graph);
    }

    protected final boolean d() {
        Preconditions.b(!this.f15932f.hasNext());
        if (!this.f15930d.hasNext()) {
            return false;
        }
        this.f15931e = this.f15930d.next();
        this.f15932f = this.f15929c.c(this.f15931e).iterator();
        return true;
    }

    private h(Graph<N> graph) {
        this.f15931e = null;
        this.f15932f = ImmutableSet.of().iterator();
        this.f15929c = graph;
        this.f15930d = graph.d().iterator();
    }
}
