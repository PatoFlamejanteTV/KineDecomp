package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: BoltsExecutors.java */
/* loaded from: classes.dex */
final class g {

    /* renamed from: a */
    private static final g f3379a = new g();

    /* renamed from: b */
    private final ExecutorService f3380b;

    /* renamed from: c */
    private final ScheduledExecutorService f3381c;

    /* renamed from: d */
    private final Executor f3382d;

    private g() {
        this.f3380b = !c() ? Executors.newCachedThreadPool() : b.a();
        this.f3381c = Executors.newSingleThreadScheduledExecutor();
        this.f3382d = new a();
    }

    public static ExecutorService a() {
        return f3379a.f3380b;
    }

    public static Executor b() {
        return f3379a.f3382d;
    }

    private static boolean c() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BoltsExecutors.java */
    /* loaded from: classes.dex */
    public static class a implements Executor {

        /* renamed from: a */
        private ThreadLocal<Integer> f3383a;

        private a() {
            this.f3383a = new ThreadLocal<>();
        }

        private int a() {
            Integer num = this.f3383a.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f3383a.remove();
            } else {
                this.f3383a.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        private int b() {
            Integer num = this.f3383a.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.f3383a.set(Integer.valueOf(intValue));
            return intValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                if (b() <= 15) {
                    runnable.run();
                } else {
                    g.a().execute(runnable);
                }
            } finally {
                a();
            }
        }

        /* synthetic */ a(f fVar) {
            this();
        }
    }
}
