package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public final class zzbr extends P {

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicLong f13972c = new AtomicLong(Long.MIN_VALUE);

    /* renamed from: d, reason: collision with root package name */
    private C1441t f13973d;

    /* renamed from: e, reason: collision with root package name */
    private C1441t f13974e;

    /* renamed from: f, reason: collision with root package name */
    private final PriorityBlockingQueue<C1439s<?>> f13975f;

    /* renamed from: g, reason: collision with root package name */
    private final BlockingQueue<C1439s<?>> f13976g;

    /* renamed from: h, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f13977h;
    private final Thread.UncaughtExceptionHandler i;
    private final Object j;
    private final Semaphore k;
    private volatile boolean l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbr(zzbw zzbwVar) {
        super(zzbwVar);
        this.j = new Object();
        this.k = new Semaphore(2);
        this.f13975f = new PriorityBlockingQueue<>();
        this.f13976g = new LinkedBlockingQueue();
        this.f13977h = new r(this, "Thread death: Uncaught exception on worker thread");
        this.i = new r(this, "Thread death: Uncaught exception on network thread");
    }

    public final <V> Future<V> a(Callable<V> callable) throws IllegalStateException {
        l();
        Preconditions.a(callable);
        C1439s<?> c1439s = new C1439s<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f13973d) {
            if (!this.f13975f.isEmpty()) {
                b().t().a("Callable skipped the worker queue.");
            }
            c1439s.run();
        } else {
            a(c1439s);
        }
        return c1439s;
    }

    public final <V> Future<V> b(Callable<V> callable) throws IllegalStateException {
        l();
        Preconditions.a(callable);
        C1439s<?> c1439s = new C1439s<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f13973d) {
            c1439s.run();
        } else {
            a(c1439s);
        }
        return c1439s;
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final void c() {
        if (Thread.currentThread() != this.f13973d) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final void e() {
        if (Thread.currentThread() != this.f13974e) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzaa f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzaq g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzfy h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ C1428m i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzq j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.P
    protected final boolean n() {
        return false;
    }

    public final boolean q() {
        return Thread.currentThread() == this.f13973d;
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }

    public final void b(Runnable runnable) throws IllegalStateException {
        l();
        Preconditions.a(runnable);
        C1439s<?> c1439s = new C1439s<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.j) {
            this.f13976g.add(c1439s);
            if (this.f13974e == null) {
                this.f13974e = new C1441t(this, "Measurement Network", this.f13976g);
                this.f13974e.setUncaughtExceptionHandler(this.i);
                this.f13974e.start();
            } else {
                this.f13974e.b();
            }
        }
    }

    public final void a(Runnable runnable) throws IllegalStateException {
        l();
        Preconditions.a(runnable);
        a(new C1439s<>(this, runnable, false, "Task exception on worker thread"));
    }

    private final void a(C1439s<?> c1439s) {
        synchronized (this.j) {
            this.f13975f.add(c1439s);
            if (this.f13973d == null) {
                this.f13973d = new C1441t(this, "Measurement Worker", this.f13975f);
                this.f13973d.setUncaughtExceptionHandler(this.f13977h);
                this.f13973d.start();
            } else {
                this.f13973d.b();
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzas b() {
        return super.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ C1441t b(zzbr zzbrVar, C1441t c1441t) {
        zzbrVar.f13974e = null;
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ Clock a() {
        return super.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ C1441t a(zzbr zzbrVar, C1441t c1441t) {
        zzbrVar.f13973d = null;
        return null;
    }
}
