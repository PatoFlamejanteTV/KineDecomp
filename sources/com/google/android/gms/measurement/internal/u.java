package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private final int f2046a;
    private final int b;
    private final List<Long> c;
    private final ReentrantLock d;
    private final Condition e;
    private int f;
    private int g;
    private boolean h;

    public u(Set<Long> set) {
        zzx.a(set);
        zzx.a(!set.isEmpty());
        this.d = new ReentrantLock();
        this.e = this.d.newCondition();
        this.b = set.size();
        if (this.b > 10) {
            throw new IllegalArgumentException("PrimingBarrier does not support more than 10 specified threads");
        }
        this.f2046a = (1 << (this.b + 1)) - 1;
        this.c = new ArrayList(set);
    }

    private int a(long j) {
        int indexOf = this.c.indexOf(Long.valueOf(j));
        if (indexOf < 0) {
            indexOf = this.b;
        }
        return 1 << indexOf;
    }

    private boolean b() {
        return this.g == this.f2046a;
    }

    private boolean b(Thread thread) {
        if (c(thread)) {
            return true;
        }
        this.f |= a(thread.getId());
        return false;
    }

    private boolean c(Thread thread) {
        return (this.f & a(thread.getId())) != 0;
    }

    private boolean d(Thread thread) {
        if ((this.g & a(thread.getId())) != 0) {
            return true;
        }
        this.g |= a(thread.getId());
        return false;
    }

    public void a(Thread thread) {
        zzx.a(thread);
        this.d.lock();
        try {
            int a2 = a(thread.getId());
            this.f &= a2 ^ (-1);
            this.g = (a2 ^ (-1)) & this.g;
            this.e.signalAll();
        } finally {
            this.d.unlock();
        }
    }

    public boolean a() throws InterruptedException {
        this.d.lock();
        try {
            if (this.h) {
                throw new IllegalStateException("Tried to await a barrier that has already passed.");
            }
            if (Thread.interrupted()) {
                a(Thread.currentThread());
                throw new InterruptedException();
            }
            if (!b(Thread.currentThread())) {
                return false;
            }
            if (d(Thread.currentThread())) {
                if (this.c.indexOf(Long.valueOf(Thread.currentThread().getId())) >= 0) {
                    throw new IllegalStateException("PrimingBarrier thinks current thread is already awaiting.");
                }
                throw new IllegalStateException("Multiple threads called shutdown on the Scheduler.");
            }
            while (!b()) {
                if (!c(Thread.currentThread())) {
                    return false;
                }
                try {
                    this.e.await();
                    if (Thread.interrupted()) {
                        a(Thread.currentThread());
                        throw new InterruptedException();
                    }
                } catch (InterruptedException e) {
                    a(Thread.currentThread());
                    throw e;
                }
            }
            if (!this.h) {
                this.h = true;
                this.e.signalAll();
            }
            return true;
        } finally {
            this.d.unlock();
        }
    }
}
