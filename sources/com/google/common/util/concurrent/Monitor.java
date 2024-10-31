package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.j2objc.annotations.Weak;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class Monitor {

    /* renamed from: a */
    private final boolean f16179a;

    /* renamed from: b */
    private final ReentrantLock f16180b;

    /* renamed from: c */
    private Guard f16181c;

    @Beta
    /* loaded from: classes2.dex */
    public static abstract class Guard {

        /* renamed from: a */
        @Weak
        final Monitor f16182a;

        /* renamed from: b */
        final Condition f16183b;

        /* renamed from: c */
        int f16184c = 0;

        /* renamed from: d */
        Guard f16185d;

        public Guard(Monitor monitor) {
            Preconditions.a(monitor, "monitor");
            this.f16182a = monitor;
            this.f16183b = monitor.f16180b.newCondition();
        }

        public abstract boolean a();
    }

    public Monitor() {
        this(false);
    }

    private void d() {
        for (Guard guard = this.f16181c; guard != null; guard = guard.f16185d) {
            guard.f16183b.signalAll();
        }
    }

    private void e() {
        for (Guard guard = this.f16181c; guard != null; guard = guard.f16185d) {
            if (a(guard)) {
                guard.f16183b.signal();
                return;
            }
        }
    }

    public boolean b() {
        return this.f16180b.isHeldByCurrentThread();
    }

    public void c() {
        ReentrantLock reentrantLock = this.f16180b;
        try {
            if (reentrantLock.getHoldCount() == 1) {
                e();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public Monitor(boolean z) {
        this.f16181c = null;
        this.f16179a = z;
        this.f16180b = new ReentrantLock(z);
    }

    public void a() {
        this.f16180b.lock();
    }

    private boolean a(Guard guard) {
        try {
            return guard.a();
        } catch (Throwable th) {
            d();
            Throwables.b(th);
            throw null;
        }
    }
}
