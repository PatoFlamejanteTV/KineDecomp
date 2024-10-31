package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public interface Predicate<T> {
    @CanIgnoreReturnValue
    boolean apply(@Nullable T t);

    boolean equals(@Nullable Object obj);
}
