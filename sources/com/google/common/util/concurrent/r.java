package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InterruptibleTask.java */
/* loaded from: classes2.dex */
public abstract class r implements Runnable {

    /* renamed from: a */
    private static final a f16209a;

    /* renamed from: b */
    private static final Logger f16210b = Logger.getLogger(r.class.getName());

    /* renamed from: c */
    private volatile Thread f16211c;

    /* renamed from: d */
    private volatile boolean f16212d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: InterruptibleTask.java */
    /* loaded from: classes2.dex */
    public static abstract class a {
        private a() {
        }

        abstract boolean a(r rVar, Thread thread, Thread thread2);

        /* synthetic */ a(q qVar) {
            this();
        }
    }

    /* compiled from: InterruptibleTask.java */
    /* loaded from: classes2.dex */
    private static final class b extends a {

        /* renamed from: a */
        final AtomicReferenceFieldUpdater<r, Thread> f16213a;

        b(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater) {
            super();
            this.f16213a = atomicReferenceFieldUpdater;
        }

        @Override // com.google.common.util.concurrent.r.a
        boolean a(r rVar, Thread thread, Thread thread2) {
            return this.f16213a.compareAndSet(rVar, thread, thread2);
        }
    }

    /* compiled from: InterruptibleTask.java */
    /* loaded from: classes2.dex */
    private static final class c extends a {
        private c() {
            super();
        }

        @Override // com.google.common.util.concurrent.r.a
        boolean a(r rVar, Thread thread, Thread thread2) {
            synchronized (rVar) {
                if (rVar.f16211c == thread) {
                    rVar.f16211c = thread2;
                }
            }
            return true;
        }

        /* synthetic */ c(q qVar) {
            this();
        }
    }

    static {
        a cVar;
        try {
            cVar = new b(AtomicReferenceFieldUpdater.newUpdater(r.class, Thread.class, "c"));
        } catch (Throwable th) {
            f16210b.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
            cVar = new c();
        }
        f16209a = cVar;
    }

    public final void b() {
        Thread thread = this.f16211c;
        if (thread != null) {
            thread.interrupt();
        }
        this.f16212d = true;
    }

    abstract void c();

    abstract boolean d();

    @Override // java.lang.Runnable
    public final void run() {
        if (f16209a.a(this, null, Thread.currentThread())) {
            try {
                c();
            } finally {
                if (d()) {
                    while (!this.f16212d) {
                        Thread.yield();
                    }
                }
            }
        }
    }
}
