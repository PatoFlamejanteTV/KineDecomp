package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* renamed from: com.google.android.gms.common.api.internal.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractRunnableC0812p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zaak f10849a;

    private AbstractRunnableC0812p(zaak zaakVar) {
        this.f10849a = zaakVar;
    }

    protected abstract void b();

    @Override // java.lang.Runnable
    public void run() {
        Lock lock;
        Lock lock2;
        zabe zabeVar;
        lock = this.f10849a.f10873b;
        lock.lock();
        try {
            if (Thread.interrupted()) {
                return;
            }
            b();
        } catch (RuntimeException e2) {
            zabeVar = this.f10849a.f10872a;
            zabeVar.a(e2);
        } finally {
            lock2 = this.f10849a.f10873b;
            lock2.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ AbstractRunnableC0812p(zaak zaakVar, RunnableC0803g runnableC0803g) {
        this(zaakVar);
    }
}
