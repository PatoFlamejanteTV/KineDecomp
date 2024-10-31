package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public interface Predicate<T> {
    boolean apply(@Nullable T t);
}
