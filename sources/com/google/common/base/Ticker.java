package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class Ticker {

    /* renamed from: a, reason: collision with root package name */
    private static final Ticker f2588a = new z();

    public abstract long a();

    public static Ticker b() {
        return f2588a;
    }
}
