package com.birbit.android.jobqueue.messaging;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SafeMessageQueue.java */
/* loaded from: classes.dex */
public class h extends i implements e {

    /* renamed from: f, reason: collision with root package name */
    private final Object f8233f;

    /* renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f8234g;

    /* renamed from: h, reason: collision with root package name */
    private final com.birbit.android.jobqueue.i.b f8235h;
    private final a i;
    private boolean j;
    private final c k;

    public h(com.birbit.android.jobqueue.i.b bVar, c cVar, String str) {
        super(cVar, str);
        this.f8233f = new Object();
        this.f8234g = new AtomicBoolean(false);
        this.j = false;
        this.k = cVar;
        this.f8235h = bVar;
        this.i = new a(cVar);
    }

    public void a(f fVar) {
        if (!this.f8234g.getAndSet(true)) {
            fVar.b();
            while (this.f8234g.get()) {
                b b2 = b(fVar);
                if (b2 != null) {
                    fVar.a(b2);
                    this.k.a(b2);
                }
            }
            com.birbit.android.jobqueue.f.c.a("[%s] finished queue", this.f8239d);
            return;
        }
        throw new IllegalStateException("only 1 consumer per MQ");
    }

    b b(f fVar) {
        long b2;
        Long a2;
        boolean z = false;
        while (this.f8234g.get()) {
            synchronized (this.f8233f) {
                b2 = this.f8235h.b();
                a2 = this.i.a(b2, this);
                b b3 = super.b();
                if (b3 != null) {
                    return b3;
                }
                this.j = false;
            }
            if (!z) {
                fVar.a();
                z = true;
            }
            synchronized (this.f8233f) {
                if (!this.j) {
                    if (a2 != null && a2.longValue() <= b2) {
                        com.birbit.android.jobqueue.f.c.a("[%s] next message is ready, requery", this.f8239d);
                    } else if (this.f8234g.get()) {
                        if (a2 == null) {
                            try {
                                com.birbit.android.jobqueue.f.c.a("[%s] will wait on the lock forever", this.f8239d);
                                this.f8235h.b(this.f8233f);
                            } catch (InterruptedException unused) {
                            }
                        } else {
                            com.birbit.android.jobqueue.f.c.a("[%s] will wait on the lock until %d", this.f8239d, a2);
                            this.f8235h.a(this.f8233f, a2.longValue());
                        }
                    }
                }
            }
        }
        return null;
    }

    public void c() {
        this.f8234g.set(false);
        synchronized (this.f8233f) {
            this.f8235h.a(this.f8233f);
        }
    }

    @Override // com.birbit.android.jobqueue.messaging.i
    public void a() {
        synchronized (this.f8233f) {
            super.a();
        }
    }

    @Override // com.birbit.android.jobqueue.messaging.i, com.birbit.android.jobqueue.messaging.e
    public void a(b bVar) {
        synchronized (this.f8233f) {
            this.j = true;
            super.a(bVar);
            this.f8235h.a(this.f8233f);
        }
    }

    public void a(b bVar, long j) {
        synchronized (this.f8233f) {
            this.j = true;
            this.i.a(bVar, j);
            this.f8235h.a(this.f8233f);
        }
    }

    public void b(d dVar) {
        synchronized (this.f8233f) {
            super.a(dVar);
            this.i.a(dVar);
        }
    }
}
