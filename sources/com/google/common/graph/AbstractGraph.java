package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.util.Set;

@Beta
/* loaded from: classes2.dex */
public abstract class AbstractGraph<N> implements Graph<N> {
    @Override // com.google.common.graph.Graph
    public Set<EndpointPair<N>> a() {
        return new a(this);
    }

    @Override // com.google.common.graph.Graph
    public int b(Object obj) {
        if (b()) {
            return IntMath.d(a(obj).size(), c(obj).size());
        }
        Set<N> d2 = d(obj);
        return IntMath.d(d2.size(), (c() && d2.contains(obj)) ? 1 : 0);
    }

    public long e() {
        long j = 0;
        while (d().iterator().hasNext()) {
            j += b(r0.next());
        }
        Preconditions.b((1 & j) == 0);
        return j >>> 1;
    }

    public String toString() {
        return String.format("%s, nodes: %s, edges: %s", String.format("isDirected: %s, allowsSelfLoops: %s", Boolean.valueOf(b()), Boolean.valueOf(c())), d(), a());
    }
}
