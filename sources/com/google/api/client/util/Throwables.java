package com.google.api.client.util;

/* loaded from: classes2.dex */
public final class Throwables {
    private Throwables() {
    }

    public static RuntimeException a(Throwable th) {
        com.google.common.base.Throwables.b(th);
        throw null;
    }

    public static <X extends Throwable> void a(Throwable th, Class<X> cls) throws Throwable {
        com.google.common.base.Throwables.b(th, cls);
    }
}
