package android.support.v7.recyclerview.extensions;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.util.DiffUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class AsyncDifferConfig<T> {

    /* renamed from: a */
    private final Executor f2262a;

    /* renamed from: b */
    private final Executor f2263b;

    /* renamed from: c */
    private final DiffUtil.ItemCallback<T> f2264c;

    /* loaded from: classes.dex */
    public static final class Builder<T> {

        /* renamed from: a */
        private static final Object f2265a = new Object();

        /* renamed from: b */
        private static Executor f2266b = null;

        /* renamed from: c */
        private static final Executor f2267c = new MainThreadExecutor();

        /* renamed from: d */
        private Executor f2268d;

        /* renamed from: e */
        private Executor f2269e;

        /* renamed from: f */
        private final DiffUtil.ItemCallback<T> f2270f;

        public Builder(DiffUtil.ItemCallback<T> itemCallback) {
            this.f2270f = itemCallback;
        }

        public AsyncDifferConfig<T> build() {
            if (this.f2268d == null) {
                this.f2268d = f2267c;
            }
            if (this.f2269e == null) {
                synchronized (f2265a) {
                    if (f2266b == null) {
                        f2266b = Executors.newFixedThreadPool(2);
                    }
                }
                this.f2269e = f2266b;
            }
            return new AsyncDifferConfig<>(this.f2268d, this.f2269e, this.f2270f);
        }

        public Builder<T> setBackgroundThreadExecutor(Executor executor) {
            this.f2269e = executor;
            return this;
        }

        public Builder<T> setMainThreadExecutor(Executor executor) {
            this.f2268d = executor;
            return this;
        }

        /* loaded from: classes.dex */
        private static class MainThreadExecutor implements Executor {

            /* renamed from: a */
            final Handler f2271a;

            private MainThreadExecutor() {
                this.f2271a = new Handler(Looper.getMainLooper());
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f2271a.post(runnable);
            }

            /* synthetic */ MainThreadExecutor(AnonymousClass1 anonymousClass1) {
                this();
            }
        }
    }

    /* synthetic */ AsyncDifferConfig(Executor executor, Executor executor2, DiffUtil.ItemCallback itemCallback, AnonymousClass1 anonymousClass1) {
        this(executor, executor2, itemCallback);
    }

    public Executor getBackgroundThreadExecutor() {
        return this.f2263b;
    }

    public DiffUtil.ItemCallback<T> getDiffCallback() {
        return this.f2264c;
    }

    public Executor getMainThreadExecutor() {
        return this.f2262a;
    }

    private AsyncDifferConfig(Executor executor, Executor executor2, DiffUtil.ItemCallback<T> itemCallback) {
        this.f2262a = executor;
        this.f2263b = executor2;
        this.f2264c = itemCallback;
    }
}
