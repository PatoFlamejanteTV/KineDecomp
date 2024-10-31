package io.grpc.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: ReflectionLongAdderCounter.java */
/* renamed from: io.grpc.internal.gc */
/* loaded from: classes3.dex */
public final class C2438gc implements InterfaceC2496vb {

    /* renamed from: a */
    private static final Logger f27618a = Logger.getLogger(C2438gc.class.getName());

    /* renamed from: b */
    private static final Constructor<?> f27619b;

    /* renamed from: c */
    private static final Method f27620c;

    /* renamed from: d */
    private static final Method f27621d;

    /* renamed from: e */
    private static final RuntimeException f27622e;

    /* renamed from: f */
    private final Object f27623f;

    static {
        Method method;
        Method method2;
        Constructor<?> constructor;
        Class<?> cls;
        int i;
        try {
            cls = Class.forName("java.util.concurrent.atomic.LongAdder");
            i = 0;
            method = cls.getMethod("add", Long.TYPE);
            try {
                method2 = cls.getMethod("sum", new Class[0]);
            } catch (Throwable th) {
                th = th;
                method2 = null;
            }
        } catch (Throwable th2) {
            th = th2;
            method = null;
            method2 = null;
        }
        try {
            Constructor<?>[] constructors = cls.getConstructors();
            int length = constructors.length;
            while (true) {
                if (i >= length) {
                    constructor = null;
                    break;
                }
                constructor = constructors[i];
                if (constructor.getParameterTypes().length == 0) {
                    break;
                } else {
                    i++;
                }
            }
            th = null;
        } catch (Throwable th3) {
            th = th3;
            f27618a.log(Level.FINE, "LongAdder can not be found via reflection, this is normal for JDK7 and below", th);
            constructor = null;
            if (th != null) {
            }
            f27619b = null;
            f27620c = null;
            f27621d = null;
            f27622e = new RuntimeException(th);
        }
        if (th != null && constructor != null) {
            f27619b = constructor;
            f27620c = method;
            f27621d = method2;
            f27622e = null;
            return;
        }
        f27619b = null;
        f27620c = null;
        f27621d = null;
        f27622e = new RuntimeException(th);
    }

    public C2438gc() {
        RuntimeException runtimeException = f27622e;
        if (runtimeException == null) {
            try {
                this.f27623f = f27619b.newInstance(new Object[0]);
                return;
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException(e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException(e4);
            }
        }
        throw runtimeException;
    }

    public static boolean a() {
        return f27622e == null;
    }

    @Override // io.grpc.internal.InterfaceC2496vb
    public void add(long j) {
        try {
            f27620c.invoke(this.f27623f, Long.valueOf(j));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }
}
