package bolts;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: AndroidExecutors.java */
/* loaded from: classes.dex */
final class b {

    /* renamed from: a */
    private static final b f3367a = new b();

    /* renamed from: b */
    private static final int f3368b = Runtime.getRuntime().availableProcessors();

    /* renamed from: c */
    static final int f3369c;

    /* renamed from: d */
    static final int f3370d;

    /* renamed from: e */
    private final Executor f3371e = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidExecutors.java */
    /* loaded from: classes.dex */
    public static class a implements Executor {
        private a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }

        /* synthetic */ a(bolts.a aVar) {
            this();
        }
    }

    static {
        int i = f3368b;
        f3369c = i + 1;
        f3370d = (i * 2) + 1;
    }

    private b() {
    }

    public static ExecutorService a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f3369c, f3370d, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        a(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    public static Executor b() {
        return f3367a.f3371e;
    }

    @SuppressLint({"NewApi"})
    public static void a(ThreadPoolExecutor threadPoolExecutor, boolean z) {
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(z);
        }
    }
}
