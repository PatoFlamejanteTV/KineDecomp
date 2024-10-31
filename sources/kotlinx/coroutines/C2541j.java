package kotlinx.coroutines;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: CommonPool.kt */
/* renamed from: kotlinx.coroutines.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2541j extends J {

    /* renamed from: b, reason: collision with root package name */
    private static final int f28666b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f28667c;

    /* renamed from: d, reason: collision with root package name */
    public static final C2541j f28668d = new C2541j();
    private static volatile Executor pool;

    static {
        String str;
        int i;
        Integer a2;
        C2541j c2541j = f28668d;
        try {
            str = System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (Throwable unused) {
            str = null;
        }
        if (str != null) {
            a2 = kotlin.text.u.a(str);
            if (a2 != null && a2.intValue() >= 1) {
                i = a2.intValue();
            } else {
                throw new IllegalStateException(("Expected positive number in kotlinx.coroutines.default.parallelism, but has " + str).toString());
            }
        } else {
            i = -1;
        }
        f28666b = i;
    }

    private C2541j() {
    }

    private final ExecutorService u() {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(x(), new ThreadFactoryC2539h(new AtomicInteger()));
        kotlin.jvm.internal.h.a((Object) newFixedThreadPool, "Executors.newFixedThread…Daemon = true }\n        }");
        return newFixedThreadPool;
    }

    private final ExecutorService v() {
        Class<?> cls;
        ExecutorService executorService;
        ExecutorService executorService2;
        if (System.getSecurityManager() != null) {
            return u();
        }
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls != null) {
            if (!f28667c && f28666b < 0) {
                try {
                    Method method = cls.getMethod("commonPool", new Class[0]);
                    Object invoke = method != null ? method.invoke(null, new Object[0]) : null;
                    if (!(invoke instanceof ExecutorService)) {
                        invoke = null;
                    }
                    executorService2 = (ExecutorService) invoke;
                } catch (Throwable unused2) {
                    executorService2 = null;
                }
                if (executorService2 != null) {
                    if (!f28668d.a(cls, executorService2)) {
                        executorService2 = null;
                    }
                    if (executorService2 != null) {
                        return executorService2;
                    }
                }
            }
            try {
                Object newInstance = cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(f28668d.x()));
                if (!(newInstance instanceof ExecutorService)) {
                    newInstance = null;
                }
                executorService = (ExecutorService) newInstance;
            } catch (Throwable unused3) {
                executorService = null;
            }
            return executorService != null ? executorService : u();
        }
        return u();
    }

    private final synchronized Executor w() {
        Executor executor;
        executor = pool;
        if (executor == null) {
            executor = v();
            pool = executor;
        }
        return executor;
    }

    private final int x() {
        int a2;
        Integer valueOf = Integer.valueOf(f28666b);
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        a2 = kotlin.c.h.a(Runtime.getRuntime().availableProcessors() - 1, 1);
        return a2;
    }

    public final boolean a(Class<?> cls, ExecutorService executorService) {
        Integer num;
        kotlin.jvm.internal.h.b(cls, "fjpClass");
        kotlin.jvm.internal.h.b(executorService, "executor");
        executorService.submit(RunnableC2540i.f28624a);
        try {
            Object invoke = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
            if (!(invoke instanceof Integer)) {
                invoke = null;
            }
            num = (Integer) invoke;
        } catch (Throwable unused) {
            num = null;
        }
        return num != null && num.intValue() >= 1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool");
    }

    @Override // kotlinx.coroutines.AbstractC2546o
    public String toString() {
        return "CommonPool";
    }

    @Override // kotlinx.coroutines.AbstractC2546o
    public void a(kotlin.coroutines.e eVar, Runnable runnable) {
        kotlin.jvm.internal.h.b(eVar, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(runnable, "block");
        try {
            Executor executor = pool;
            if (executor == null) {
                executor = w();
            }
            ia.a().a(runnable);
            executor.execute(runnable);
        } catch (RejectedExecutionException unused) {
            ia.a().a();
            RunnableC2554x.f28729h.a(runnable);
        }
    }
}
