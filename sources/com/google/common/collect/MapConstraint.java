package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public interface MapConstraint<K, V> {
    void a(@Nullable K k, @Nullable V v);
}
