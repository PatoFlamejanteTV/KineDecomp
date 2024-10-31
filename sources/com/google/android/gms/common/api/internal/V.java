package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public final class V implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ U f10814a;

    public V(U u) {
        this.f10814a = u;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Lock lock;
        Lock lock2;
        lock = this.f10814a.m;
        lock.lock();
        try {
            this.f10814a.f();
        } finally {
            lock2 = this.f10814a.m;
            lock2.unlock();
        }
    }
}
