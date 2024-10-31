package com.google.common.base;

import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class Throwables {
    private Throwables() {
    }

    public static <X extends Throwable> void a(@Nullable Throwable th, Class<X> cls) throws Throwable {
        if (th != null && cls.isInstance(th)) {
            throw cls.cast(th);
        }
    }

    public static void a(@Nullable Throwable th) {
        a(th, Error.class);
        a(th, RuntimeException.class);
    }

    public static RuntimeException b(Throwable th) {
        a((Throwable) Preconditions.a(th));
        throw new RuntimeException(th);
    }
}