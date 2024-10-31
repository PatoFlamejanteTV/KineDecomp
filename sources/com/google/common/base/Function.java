package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes.dex */
public interface Function<F, T> {
    @Nullable
    T apply(@Nullable F f);
}
