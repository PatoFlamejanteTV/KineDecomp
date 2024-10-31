package com.birbit.android.jobqueue.i;

import com.birbit.android.jobqueue.f.c;
import java.util.concurrent.TimeUnit;

/* compiled from: SystemTimer.java */
/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a */
    final long f8174a;

    /* renamed from: b */
    final long f8175b;

    public a() {
        c.a("creating system timer", new Object[0]);
        this.f8174a = TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
        this.f8175b = System.nanoTime();
    }

    @Override // com.birbit.android.jobqueue.i.b
    public void a(Object obj, long j) throws InterruptedException {
        long b2 = b();
        if (b2 > j) {
            obj.wait(1L);
        } else {
            TimeUnit.NANOSECONDS.timedWait(obj, j - b2);
        }
    }

    @Override // com.birbit.android.jobqueue.i.b
    public long b() {
        return (System.nanoTime() - this.f8175b) + this.f8174a;
    }

    @Override // com.birbit.android.jobqueue.i.b
    public void b(Object obj) throws InterruptedException {
        obj.wait();
    }

    @Override // com.birbit.android.jobqueue.i.b
    public void a(Object obj) {
        obj.notifyAll();
    }
}
