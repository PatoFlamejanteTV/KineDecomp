package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public interface Function<F, T> {
    @CanIgnoreReturnValue
    @Nullable
    T apply(@Nullable F f2);

    boolean equals(@Nullable Object obj);
}
