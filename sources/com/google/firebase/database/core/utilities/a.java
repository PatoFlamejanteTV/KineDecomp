package com.google.firebase.database.core.utilities;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class a extends ScheduledThreadPoolExecutor {

    /* renamed from: a */
    final /* synthetic */ DefaultRunLoop f17075a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(DefaultRunLoop defaultRunLoop, int i, ThreadFactory threadFactory) {
        super(i, threadFactory);
        this.f17075a = defaultRunLoop;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            Future future = (Future) runnable;
            try {
                if (future.isDone()) {
                    future.get();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (CancellationException unused2) {
            } catch (ExecutionException e2) {
                th = e2.getCause();
            }
        }
        if (th != null) {
            this.f17075a.a(th);
        }
    }
}
