package io.fabric.sdk.android.services.concurrency;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: PriorityFutureTask.java */
/* loaded from: classes3.dex */
public class l<V> extends FutureTask<V> implements g<p>, m, p, f {

    /* renamed from: a */
    final Object f26958a;

    public l(Callable<V> callable) {
        super(callable);
        this.f26958a = a(callable);
    }

    @Override // io.fabric.sdk.android.services.concurrency.g
    /* renamed from: a */
    public void addDependency(p pVar) {
        ((g) ((m) a())).addDependency(pVar);
    }

    @Override // io.fabric.sdk.android.services.concurrency.g
    public boolean areDependenciesMet() {
        return ((g) ((m) a())).areDependenciesMet();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return ((m) a()).compareTo(obj);
    }

    @Override // io.fabric.sdk.android.services.concurrency.g
    public Collection<p> getDependencies() {
        return ((g) ((m) a())).getDependencies();
    }

    @Override // io.fabric.sdk.android.services.concurrency.m
    public Priority getPriority() {
        return ((m) a()).getPriority();
    }

    @Override // io.fabric.sdk.android.services.concurrency.p
    public boolean isFinished() {
        return ((p) ((m) a())).isFinished();
    }

    @Override // io.fabric.sdk.android.services.concurrency.p
    public void setError(Throwable th) {
        ((p) ((m) a())).setError(th);
    }

    @Override // io.fabric.sdk.android.services.concurrency.p
    public void setFinished(boolean z) {
        ((p) ((m) a())).setFinished(z);
    }

    public g a() {
        return (g) this.f26958a;
    }

    public l(Runnable runnable, V v) {
        super(runnable, v);
        this.f26958a = a(runnable);
    }

    protected g a(Object obj) {
        if (n.isProperDelegate(obj)) {
            return (g) obj;
        }
        return new n();
    }
}
