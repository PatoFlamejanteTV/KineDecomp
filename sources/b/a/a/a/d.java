package b.a.a.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: DefaultTaskExecutor.java */
/* loaded from: classes.dex */
public class d extends e {

    /* renamed from: a */
    private final Object f3220a = new Object();

    /* renamed from: b */
    private ExecutorService f3221b = Executors.newFixedThreadPool(2);

    /* renamed from: c */
    private volatile Handler f3222c;

    @Override // b.a.a.a.e
    public void a(Runnable runnable) {
        this.f3221b.execute(runnable);
    }

    @Override // b.a.a.a.e
    public void b(Runnable runnable) {
        if (this.f3222c == null) {
            synchronized (this.f3220a) {
                if (this.f3222c == null) {
                    this.f3222c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.f3222c.post(runnable);
    }

    @Override // b.a.a.a.e
    public boolean a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
