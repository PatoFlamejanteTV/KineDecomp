package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import java.lang.Thread;
import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class zzu extends ac {

    /* renamed from: a */
    private final c f2069a;
    private final c b;
    private final u c;
    private volatile boolean d;
    private volatile boolean e;

    /* loaded from: classes.dex */
    public final class a<V> extends FutureTask<V> {
        private final String b;

        a(Runnable runnable, String str) {
            super(runnable, null);
            zzx.a(str);
            this.b = str;
        }

        @Override // java.util.concurrent.FutureTask
        protected void setException(Throwable th) {
            zzu.this.l().b().a(this.b, th);
            super.setException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b implements Thread.UncaughtExceptionHandler {
        private final String b;

        public b(String str) {
            zzx.a(str);
            this.b = str;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public synchronized void uncaughtException(Thread thread, Throwable th) {
            zzu.this.l().b().a(this.b, th);
        }
    }

    /* loaded from: classes.dex */
    public final class c extends Thread {
        private final BlockingQueue<FutureTask<?>> b;

        public c(String str) {
            zzx.a(str);
            this.b = new LinkedBlockingQueue();
            setName(str);
        }

        private void a(InterruptedException interruptedException) {
            zzu.this.l().o().a(getName() + " was interrupted", interruptedException);
        }

        public void a(FutureTask<?> futureTask) throws IllegalStateException {
            zzx.a(futureTask);
            if (zzu.this.e) {
                throw new IllegalStateException("Cannot schedule task; thread was already shut down.");
            }
            try {
                this.b.put(futureTask);
                zzu.this.c.a(this);
            } catch (InterruptedException e) {
                a(e);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            boolean z = false;
            while (true) {
                if (zzu.this.d && z) {
                    zzu.this.l().s().a("Scheduler thread exiting");
                    return;
                }
                while (true) {
                    try {
                        FutureTask<?> poll = this.b.poll(0L, TimeUnit.MICROSECONDS);
                        if (poll != null) {
                            poll.run();
                        }
                    } catch (InterruptedException e) {
                        a(e);
                    }
                    try {
                        break;
                    } catch (InterruptedException e2) {
                        a(e2);
                    }
                }
                z = zzu.this.c.a();
            }
        }
    }

    public zzu(zzv zzvVar) {
        super(zzvVar);
        this.f2069a = new c("Measurement Worker");
        this.b = new c("Measurement Network");
        this.f2069a.setUncaughtExceptionHandler(new b("Thread death: Uncaught exception on worker thread"));
        this.b.setUncaughtExceptionHandler(new b("Thread death: Uncaught exception on network thread"));
        HashSet hashSet = new HashSet();
        hashSet.add(Long.valueOf(this.f2069a.getId()));
        hashSet.add(Long.valueOf(this.b.getId()));
        this.c = new u(hashSet);
    }

    private void a(Runnable runnable, c cVar, String str) throws IllegalStateException {
        x();
        zzx.a(runnable);
        cVar.a(new a(runnable, str));
    }

    @Override // com.google.android.gms.measurement.internal.ac
    protected void a() {
        this.f2069a.start();
        this.b.start();
    }

    public void a(Runnable runnable) throws IllegalStateException {
        a(runnable, this.f2069a, "Task exception on worker thread");
    }

    public void b(Runnable runnable) throws IllegalStateException {
        a(runnable, this.b, "Task exception on network thread");
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public void d() {
        if (Thread.currentThread() != this.b) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public void e() {
        if (Thread.currentThread() != this.f2069a) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzn f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzab g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzmn h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ Context i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzag j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzu k() {
        return super.k();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzp l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzs m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzc n() {
        return super.n();
    }
}
