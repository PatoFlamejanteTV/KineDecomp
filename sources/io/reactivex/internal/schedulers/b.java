package io.reactivex.internal.schedulers;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: DisposeOnCancel.java */
/* loaded from: classes3.dex */
final class b implements Future<Object> {

    /* renamed from: a */
    final io.reactivex.disposables.b f28415a;

    public b(io.reactivex.disposables.b bVar) {
        this.f28415a = bVar;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        this.f28415a.dispose();
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get() throws InterruptedException, ExecutionException {
        return null;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return false;
    }
}
