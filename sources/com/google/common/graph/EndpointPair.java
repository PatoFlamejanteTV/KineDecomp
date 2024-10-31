package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import javax.annotation.Nullable;

@Beta
/* loaded from: classes2.dex */
public abstract class EndpointPair<N> implements Iterable<N> {

    /* renamed from: a */
    private final N f15918a;

    /* renamed from: b */
    private final N f15919b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a<N> extends EndpointPair<N> {
        /* synthetic */ a(Object obj, Object obj2, f fVar) {
            this(obj, obj2);
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean a() {
            return true;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            return a() == endpointPair.a() && f().equals(endpointPair.f()) && g().equals(endpointPair.g());
        }

        @Override // com.google.common.graph.EndpointPair
        public N f() {
            return d();
        }

        @Override // com.google.common.graph.EndpointPair
        public N g() {
            return e();
        }

        public int hashCode() {
            return Objects.a(f(), g());
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        public String toString() {
            return String.format("<%s -> %s>", f(), g());
        }

        private a(N n, N n2) {
            super(n, n2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b<N> extends EndpointPair<N> {
        /* synthetic */ b(Object obj, Object obj2, f fVar) {
            this(obj, obj2);
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean a() {
            return false;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (a() != endpointPair.a()) {
                return false;
            }
            if (d().equals(endpointPair.d())) {
                return e().equals(endpointPair.e());
            }
            return d().equals(endpointPair.e()) && e().equals(endpointPair.d());
        }

        @Override // com.google.common.graph.EndpointPair
        public N f() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        @Override // com.google.common.graph.EndpointPair
        public N g() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        public int hashCode() {
            return d().hashCode() + e().hashCode();
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        public String toString() {
            return String.format("[%s, %s]", d(), e());
        }

        private b(N n, N n2) {
            super(n, n2);
        }
    }

    /* synthetic */ EndpointPair(Object obj, Object obj2, f fVar) {
        this(obj, obj2);
    }

    public static <N> EndpointPair<N> a(N n, N n2) {
        return new a(n, n2);
    }

    public static <N> EndpointPair<N> b(N n, N n2) {
        return new b(n2, n);
    }

    public abstract boolean a();

    public final N d() {
        return this.f15918a;
    }

    public final N e() {
        return this.f15919b;
    }

    public abstract N f();

    public abstract N g();

    private EndpointPair(N n, N n2) {
        Preconditions.a(n);
        this.f15918a = n;
        Preconditions.a(n2);
        this.f15919b = n2;
    }

    @Override // java.lang.Iterable
    public final UnmodifiableIterator<N> iterator() {
        return Iterators.a(this.f15918a, this.f15919b);
    }
}
