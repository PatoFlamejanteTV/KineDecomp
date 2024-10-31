package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;

@GwtCompatible
/* loaded from: classes2.dex */
public interface BiMap<K, V> extends Map<K, V> {
    BiMap<V, K> inverse();
}
