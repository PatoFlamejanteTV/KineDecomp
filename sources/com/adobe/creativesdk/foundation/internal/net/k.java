package com.adobe.creativesdk.foundation.internal.net;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: AdobeNetworkHttpRequestExecutor.java */
/* loaded from: classes.dex */
public class k extends ThreadPoolExecutor {

    /* renamed from: a */
    private boolean f5115a;

    /* renamed from: b */
    private ReentrantLock f5116b;

    /* renamed from: c */
    private Condition f5117c;

    public k(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        super(i, i2, j, timeUnit, blockingQueue);
        this.f5115a = false;
        this.f5116b = new ReentrantLock();
        this.f5117c = this.f5116b.newCondition();
    }

    public void a() {
        this.f5116b.lock();
        try {
            this.f5115a = true;
        } finally {
            this.f5116b.unlock();
        }
    }

    public void b() {
        this.f5116b.lock();
        try {
            this.f5115a = false;
            this.f5117c.signalAll();
        } finally {
            this.f5116b.unlock();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        this.f5116b.lock();
        while (this.f5115a) {
            try {
                try {
                    this.f5117c.await();
                } catch (InterruptedException unused) {
                    thread.interrupt();
                }
            } finally {
                this.f5116b.unlock();
            }
        }
    }
}
