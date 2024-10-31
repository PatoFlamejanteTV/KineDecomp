package com.google.common.hash;

import com.google.common.annotations.Beta;

@Beta
/* loaded from: classes2.dex */
public interface HashFunction {
    <T> HashCode hashObject(T t, Funnel<? super T> funnel);

    Hasher newHasher();
}
