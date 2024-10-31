package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;

@Beta
/* loaded from: classes2.dex */
public abstract class AbstractNetwork<N, E> implements Network<N, E> {
    private Map<E, EndpointPair<N>> f() {
        return Maps.a((Set) a(), (Function) new c(this));
    }

    public String toString() {
        return String.format("%s, nodes: %s, edges: %s", String.format("isDirected: %s, allowsParallelEdges: %s, allowsSelfLoops: %s", Boolean.valueOf(b()), Boolean.valueOf(e()), Boolean.valueOf(c())), d(), f());
    }
}
