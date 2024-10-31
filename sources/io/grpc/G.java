package io.grpc;

import io.grpc.ca;

/* compiled from: InternalServiceProviders.java */
/* loaded from: classes3.dex */
public final class G {

    /* compiled from: InternalServiceProviders.java */
    /* loaded from: classes3.dex */
    public interface a<T> extends ca.a<T> {
    }

    public static <T> T a(Class<T> cls, Iterable<Class<?>> iterable, ClassLoader classLoader, a<T> aVar) {
        return (T) ca.a(cls, iterable, classLoader, aVar);
    }

    public static boolean a(ClassLoader classLoader) {
        return ca.a(classLoader);
    }
}
