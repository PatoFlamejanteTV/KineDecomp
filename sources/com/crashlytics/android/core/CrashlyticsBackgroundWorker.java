package com.crashlytics.android.core;

import android.os.Looper;
import io.fabric.sdk.android.f;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class CrashlyticsBackgroundWorker {
    private final ExecutorService executorService;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.crashlytics.android.core.CrashlyticsBackgroundWorker$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ Runnable val$runnable;

        AnonymousClass1(Runnable runnable) {
            runnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                runnable.run();
            } catch (Exception e2) {
                f.f().c(CrashlyticsCore.TAG, "Failed to execute task.", e2);
            }
        }
    }

    /* renamed from: com.crashlytics.android.core.CrashlyticsBackgroundWorker$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2<T> implements Callable<T> {
        final /* synthetic */ Callable val$callable;

        AnonymousClass2(Callable callable) {
            callable = callable;
        }

        @Override // java.util.concurrent.Callable
        public T call() throws Exception {
            try {
                return (T) callable.call();
            } catch (Exception e2) {
                f.f().c(CrashlyticsCore.TAG, "Failed to execute task.", e2);
                return null;
            }
        }
    }

    public CrashlyticsBackgroundWorker(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public Future<?> submit(Runnable runnable) {
        try {
            return this.executorService.submit(new Runnable() { // from class: com.crashlytics.android.core.CrashlyticsBackgroundWorker.1
                final /* synthetic */ Runnable val$runnable;

                AnonymousClass1(Runnable runnable2) {
                    runnable = runnable2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } catch (Exception e2) {
                        f.f().c(CrashlyticsCore.TAG, "Failed to execute task.", e2);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            f.f().d(CrashlyticsCore.TAG, "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

    public <T> T submitAndWait(Callable<T> callable) {
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return this.executorService.submit(callable).get(4L, TimeUnit.SECONDS);
            }
            return this.executorService.submit(callable).get();
        } catch (RejectedExecutionException unused) {
            f.f().d(CrashlyticsCore.TAG, "Executor is shut down because we're handling a fatal crash.");
            return null;
        } catch (Exception e2) {
            f.f().c(CrashlyticsCore.TAG, "Failed to execute task.", e2);
            return null;
        }
    }

    public <T> Future<T> submit(Callable<T> callable) {
        try {
            return this.executorService.submit(new Callable<T>() { // from class: com.crashlytics.android.core.CrashlyticsBackgroundWorker.2
                final /* synthetic */ Callable val$callable;

                AnonymousClass2(Callable callable2) {
                    callable = callable2;
                }

                @Override // java.util.concurrent.Callable
                public T call() throws Exception {
                    try {
                        return (T) callable.call();
                    } catch (Exception e2) {
                        f.f().c(CrashlyticsCore.TAG, "Failed to execute task.", e2);
                        return null;
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            f.f().d(CrashlyticsCore.TAG, "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }
}
