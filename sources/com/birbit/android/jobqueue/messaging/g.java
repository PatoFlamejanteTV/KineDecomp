package com.birbit.android.jobqueue.messaging;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: PriorityMessageQueue.java */
/* loaded from: classes.dex */
public class g implements e {

    /* renamed from: c, reason: collision with root package name */
    private final a f8228c;

    /* renamed from: d, reason: collision with root package name */
    private final com.birbit.android.jobqueue.i.b f8229d;

    /* renamed from: g, reason: collision with root package name */
    private final c f8232g;

    /* renamed from: a, reason: collision with root package name */
    private final Object f8226a = new Object();

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f8230e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    private boolean f8231f = false;

    /* renamed from: b, reason: collision with root package name */
    private final i[] f8227b = new i[Type.MAX_PRIORITY + 1];

    public g(com.birbit.android.jobqueue.i.b bVar, c cVar) {
        this.f8228c = new a(cVar);
        this.f8232g = cVar;
        this.f8229d = bVar;
    }

    public void a(f fVar) {
        if (!this.f8230e.getAndSet(true)) {
            while (this.f8230e.get()) {
                b b2 = b(fVar);
                if (b2 != null) {
                    com.birbit.android.jobqueue.f.c.a("[%s] consuming message of type %s", "priority_mq", b2.f8221a);
                    fVar.a(b2);
                    this.f8232g.a(b2);
                }
            }
            return;
        }
        throw new IllegalStateException("only 1 consumer per MQ");
    }

    public void b() {
        this.f8230e.set(false);
        synchronized (this.f8226a) {
            this.f8229d.a(this.f8226a);
        }
    }

    public b b(f fVar) {
        long b2;
        Long a2;
        b b3;
        boolean z = false;
        while (this.f8230e.get()) {
            synchronized (this.f8226a) {
                b2 = this.f8229d.b();
                com.birbit.android.jobqueue.f.c.a("[%s] looking for next message at time %s", "priority_mq", Long.valueOf(b2));
                a2 = this.f8228c.a(b2, this);
                com.birbit.android.jobqueue.f.c.a("[%s] next delayed job %s", "priority_mq", a2);
                for (int i = Type.MAX_PRIORITY; i >= 0; i--) {
                    i iVar = this.f8227b[i];
                    if (iVar != null && (b3 = iVar.b()) != null) {
                        return b3;
                    }
                }
                this.f8231f = false;
            }
            if (!z) {
                fVar.a();
                z = true;
            }
            synchronized (this.f8226a) {
                com.birbit.android.jobqueue.f.c.a("[%s] did on idle post a message? %s", "priority_mq", Boolean.valueOf(this.f8231f));
                if (!this.f8231f) {
                    if (a2 == null || a2.longValue() > b2) {
                        if (this.f8230e.get()) {
                            if (a2 == null) {
                                try {
                                    this.f8229d.b(this.f8226a);
                                } catch (InterruptedException unused) {
                                }
                            } else {
                                this.f8229d.a(this.f8226a, a2.longValue());
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public void a() {
        synchronized (this.f8226a) {
            for (int i = Type.MAX_PRIORITY; i >= 0; i--) {
                i iVar = this.f8227b[i];
                if (iVar != null) {
                    iVar.a();
                }
            }
        }
    }

    @Override // com.birbit.android.jobqueue.messaging.e
    public void a(b bVar) {
        synchronized (this.f8226a) {
            this.f8231f = true;
            int i = bVar.f8221a.priority;
            if (this.f8227b[i] == null) {
                this.f8227b[i] = new i(this.f8232g, "queue_" + bVar.f8221a.name());
            }
            this.f8227b[i].a(bVar);
            this.f8229d.a(this.f8226a);
        }
    }

    public void a(b bVar, long j) {
        synchronized (this.f8226a) {
            this.f8231f = true;
            this.f8228c.a(bVar, j);
            this.f8229d.a(this.f8226a);
        }
    }
}
