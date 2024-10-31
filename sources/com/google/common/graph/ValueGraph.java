package com.google.common.graph;

import com.google.common.annotations.Beta;
import javax.annotation.Nullable;

@Beta
/* loaded from: classes2.dex */
public interface ValueGraph<N, V> extends Graph<N> {
    V a(Object obj, Object obj2, @Nullable V v);
}
