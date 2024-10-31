package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class Throwables {

    /* renamed from: a */
    @GwtIncompatible
    @Nullable
    private static final Object f15122a = b();

    /* renamed from: b */
    @GwtIncompatible
    @Nullable
    private static final Method f15123b;

    /* renamed from: c */
    @GwtIncompatible
    @Nullable
    private static final Method f15124c;

    static {
        f15123b = f15122a == null ? null : a();
        f15124c = f15122a != null ? c() : null;
    }

    private Throwables() {
    }

    @GwtIncompatible
    @Deprecated
    public static <X extends Throwable> void a(@Nullable Throwable th, Class<X> cls) throws Throwable {
        if (th != null) {
            c(th, cls);
        }
    }

    @GwtIncompatible
    public static <X extends Throwable> void b(@Nullable Throwable th, Class<X> cls) throws Throwable {
        a(th, cls);
        c(th);
    }

    @GwtIncompatible
    public static <X extends Throwable> void c(Throwable th, Class<X> cls) throws Throwable {
        Preconditions.a(th);
        if (cls.isInstance(th)) {
            throw cls.cast(th);
        }
    }

    public static void d(Throwable th) {
        Preconditions.a(th);
        if (!(th instanceof RuntimeException)) {
            if (th instanceof Error) {
                throw ((Error) th);
            }
            return;
        }
        throw ((RuntimeException) th);
    }

    @GwtIncompatible
    public static String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    @Deprecated
    public static RuntimeException b(Throwable th) {
        d(th);
        throw new RuntimeException(th);
    }

    @GwtIncompatible
    @Deprecated
    public static void c(@Nullable Throwable th) {
        if (th != null) {
            d(th);
        }
    }

    @GwtIncompatible
    @Nullable
    private static Method a() {
        return a("getStackTraceElement", (Class<?>[]) new Class[]{Throwable.class, Integer.TYPE});
    }

    @GwtIncompatible
    @Nullable
    private static Object b() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }

    @GwtIncompatible
    @Nullable
    private static Method c() {
        return a("getStackTraceDepth", (Class<?>[]) new Class[]{Throwable.class});
    }

    @GwtIncompatible
    @Nullable
    private static Method a(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }
}
