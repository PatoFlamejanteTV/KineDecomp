package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@Beta
/* loaded from: classes2.dex */
public final class Reflection {
    private Reflection() {
    }

    public static <T> T a(Class<T> cls, InvocationHandler invocationHandler) {
        Preconditions.a(invocationHandler);
        Preconditions.a(cls.isInterface(), "%s is not an interface", cls);
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }
}
