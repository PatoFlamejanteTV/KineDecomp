package a;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: BoltsExecutors.java */
/* loaded from: classes.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final d f3a = new d();
    private final ExecutorService b;
    private final ScheduledExecutorService c;
    private final Executor d;

    private static boolean c() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }

    private d() {
        this.b = !c() ? Executors.newCachedThreadPool() : a.a.a();
        this.c = Executors.newSingleThreadScheduledExecutor();
        this.d = new a();
    }

    public static ExecutorService a() {
        return f3a.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor b() {
        return f3a.d;
    }

    /* compiled from: BoltsExecutors.java */
    /* loaded from: classes.dex */
    private static class a implements Executor {

        /* renamed from: a, reason: collision with root package name */
        private ThreadLocal<Integer> f4a;

        private a() {
            this.f4a = new ThreadLocal<>();
        }

        private int a() {
            Integer num = this.f4a.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.f4a.set(Integer.valueOf(intValue));
            return intValue;
        }

        private int b() {
            Integer num = this.f4a.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f4a.remove();
            } else {
                this.f4a.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                if (a() <= 15) {
                    runnable.run();
                } else {
                    d.a().execute(runnable);
                }
            } finally {
                b();
            }
        }
    }
}
