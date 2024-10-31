package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;

@Beta
/* loaded from: classes2.dex */
public abstract class AbstractValueGraph<N, V> extends AbstractGraph<N> implements ValueGraph<N, V> {
    private Map<EndpointPair<N>, V> f() {
        return Maps.a((Set) a(), (Function) new d(this));
    }

    public V a(Object obj, Object obj2) {
        V a2 = a(obj, obj2, null);
        if (a2 != null) {
            return a2;
        }
        Preconditions.a(d().contains(obj), "Node %s is not an element of this graph.", obj);
        Preconditions.a(d().contains(obj2), "Node %s is not an element of this graph.", obj2);
        throw new IllegalArgumentException(String.format("Edge connecting %s to %s is not present in this graph.", obj, obj2));
    }

    @Override // com.google.common.graph.AbstractGraph
    public String toString() {
        return String.format("%s, nodes: %s, edges: %s", String.format("isDirected: %s, allowsSelfLoops: %s", Boolean.valueOf(b()), Boolean.valueOf(c())), d(), f());
    }
}
