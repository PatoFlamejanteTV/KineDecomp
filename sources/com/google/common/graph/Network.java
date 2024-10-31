package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Set;

@Beta
/* loaded from: classes2.dex */
public interface Network<N, E> {
    EndpointPair<N> a(Object obj);

    Set<E> a();

    boolean b();

    boolean c();

    Set<N> d();

    boolean e();
}
