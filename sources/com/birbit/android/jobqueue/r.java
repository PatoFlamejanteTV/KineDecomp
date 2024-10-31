package com.birbit.android.jobqueue;

import com.birbit.android.jobqueue.h.a;
import java.util.concurrent.TimeUnit;

/* compiled from: JobManager.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a */
    public static final long f8303a = TimeUnit.MILLISECONDS.toNanos(10000);

    /* renamed from: b */
    final u f8304b;

    /* renamed from: c */
    private final com.birbit.android.jobqueue.messaging.g f8305c;

    /* renamed from: d */
    private final com.birbit.android.jobqueue.messaging.c f8306d = new com.birbit.android.jobqueue.messaging.c();

    /* renamed from: e */
    private Thread f8307e;

    /* renamed from: f */
    private com.birbit.android.jobqueue.h.a f8308f;

    public r(com.birbit.android.jobqueue.c.b bVar) {
        this.f8305c = new com.birbit.android.jobqueue.messaging.g(bVar.o(), this.f8306d);
        this.f8304b = new u(bVar, this.f8305c, this.f8306d);
        this.f8307e = new Thread(this.f8304b, "job-manager");
        if (bVar.l() != null) {
            this.f8308f = bVar.l();
            bVar.l().a(bVar.b(), a());
        }
        this.f8307e.start();
    }

    private a.InterfaceC0043a a() {
        return new q(this);
    }

    public void a(Job job) {
        com.birbit.android.jobqueue.messaging.a.a aVar = (com.birbit.android.jobqueue.messaging.a.a) this.f8306d.a(com.birbit.android.jobqueue.messaging.a.a.class);
        aVar.a(job);
        this.f8305c.a(aVar);
    }
}
