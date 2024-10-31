package com.google.common.reflect;

import com.google.common.annotations.Beta;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import javax.annotation.Nullable;

@Beta
/* loaded from: classes2.dex */
public abstract class AbstractInvocationHandler implements InvocationHandler {

    /* renamed from: a */
    private static final Object[] f16045a = new Object[0];

    private static boolean a(Object obj, Class<?> cls) {
        return cls.isInstance(obj) || (Proxy.isProxyClass(obj.getClass()) && Arrays.equals(obj.getClass().getInterfaces(), cls.getInterfaces()));
    }

    protected abstract Object a(Object obj, Method method, Object[] objArr) throws Throwable;

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, @Nullable Object[] objArr) throws Throwable {
        if (objArr == null) {
            objArr = f16045a;
        }
        if (objArr.length == 0 && method.getName().equals("hashCode")) {
            return Integer.valueOf(hashCode());
        }
        if (objArr.length == 1 && method.getName().equals("equals") && method.getParameterTypes()[0] == Object.class) {
            Object obj2 = objArr[0];
            if (obj2 == null) {
                return false;
            }
            if (obj == obj2) {
                return true;
            }
            return Boolean.valueOf(a(obj2, obj.getClass()) && equals(Proxy.getInvocationHandler(obj2)));
        }
        if (objArr.length == 0 && method.getName().equals("toString")) {
            return toString();
        }
        return a(obj, method, objArr);
    }

    public String toString() {
        return super.toString();
    }
}
