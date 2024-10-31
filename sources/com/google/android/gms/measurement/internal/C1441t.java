package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.measurement.internal.t, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1441t extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private final Object f13850a;

    /* renamed from: b, reason: collision with root package name */
    private final BlockingQueue<C1439s<?>> f13851b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzbr f13852c;

    public C1441t(zzbr zzbrVar, String str, BlockingQueue<C1439s<?>> blockingQueue) {
        this.f13852c = zzbrVar;
        Preconditions.a(str);
        Preconditions.a(blockingQueue);
        this.f13850a = new Object();
        this.f13851b = blockingQueue;
        setName(str);
    }

    private final void a(InterruptedException interruptedException) {
        this.f13852c.b().t().a(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    public final void b() {
        synchronized (this.f13850a) {
            this.f13850a.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Object obj;
        Semaphore semaphore;
        Object obj2;
        C1441t c1441t;
        C1441t c1441t2;
        Object obj3;
        Object obj4;
        Semaphore semaphore2;
        Object obj5;
        C1441t c1441t3;
        C1441t c1441t4;
        boolean z;
        Semaphore semaphore3;
        boolean z2 = false;
        while (!z2) {
            try {
                semaphore3 = this.f13852c.k;
                semaphore3.acquire();
                z2 = true;
            } catch (InterruptedException e2) {
                a(e2);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                C1439s<?> poll = this.f13851b.poll();
                if (poll != null) {
                    Process.setThreadPriority(poll.f13840b ? threadPriority : 10);
                    poll.run();
                } else {
                    synchronized (this.f13850a) {
                        if (this.f13851b.peek() == null) {
                            z = this.f13852c.l;
                            if (!z) {
                                try {
                                    this.f13850a.wait(com.umeng.commonsdk.proguard.c.f26227d);
                                } catch (InterruptedException e3) {
                                    a(e3);
                                }
                            }
                        }
                    }
                    obj3 = this.f13852c.j;
                    synchronized (obj3) {
                        if (this.f13851b.peek() == null) {
                            break;
                        }
                    }
                }
            }
            obj4 = this.f13852c.j;
            synchronized (obj4) {
                semaphore2 = this.f13852c.k;
                semaphore2.release();
                obj5 = this.f13852c.j;
                obj5.notifyAll();
                c1441t3 = this.f13852c.f13973d;
                if (this != c1441t3) {
                    c1441t4 = this.f13852c.f13974e;
                    if (this == c1441t4) {
                        zzbr.b(this.f13852c, null);
                    } else {
                        this.f13852c.b().q().a("Current scheduler thread is neither worker nor network");
                    }
                } else {
                    zzbr.a(this.f13852c, null);
                }
            }
        } catch (Throwable th) {
            obj = this.f13852c.j;
            synchronized (obj) {
                semaphore = this.f13852c.k;
                semaphore.release();
                obj2 = this.f13852c.j;
                obj2.notifyAll();
                c1441t = this.f13852c.f13973d;
                if (this != c1441t) {
                    c1441t2 = this.f13852c.f13974e;
                    if (this == c1441t2) {
                        zzbr.b(this.f13852c, null);
                    } else {
                        this.f13852c.b().q().a("Current scheduler thread is neither worker nor network");
                    }
                } else {
                    zzbr.a(this.f13852c, null);
                }
                throw th;
            }
        }
    }
}
