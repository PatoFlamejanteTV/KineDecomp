package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class Ticker {

    /* renamed from: a */
    private static final Ticker f15125a = new t();

    public static Ticker b() {
        return f15125a;
    }

    @CanIgnoreReturnValue
    public abstract long a();
}
