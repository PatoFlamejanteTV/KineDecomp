package com.google.api.client.util;

/* loaded from: classes.dex */
public final class Throwables {
    public static RuntimeException a(Throwable th) {
        return com.google.api.client.repackaged.com.google.common.base.Throwables.b(th);
    }

    public static <X extends Throwable> void a(Throwable th, Class<X> cls) throws Throwable {
        com.google.api.client.repackaged.com.google.common.base.Throwables.b(th, cls);
    }

    private Throwables() {
    }
}
