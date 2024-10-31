package com.birbit.android.jobqueue.messaging;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UnsafeMessageQueue.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a */
    private static final AtomicInteger f8236a = new AtomicInteger(0);

    /* renamed from: b */
    private b f8237b = null;

    /* renamed from: c */
    private b f8238c = null;

    /* renamed from: d */
    public final String f8239d;

    /* renamed from: e */
    private final c f8240e;

    public i(c cVar, String str) {
        this.f8240e = cVar;
        this.f8239d = str + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + f8236a.incrementAndGet();
    }

    public void a(b bVar) {
        com.birbit.android.jobqueue.f.c.a("[%s] post message %s", this.f8239d, bVar);
        b bVar2 = this.f8238c;
        if (bVar2 == null) {
            this.f8237b = bVar;
            this.f8238c = bVar;
        } else {
            bVar2.f8222b = bVar;
            this.f8238c = bVar;
        }
    }

    public b b() {
        b bVar = this.f8237b;
        com.birbit.android.jobqueue.f.c.a("[%s] remove message %s", this.f8239d, bVar);
        if (bVar != null) {
            this.f8237b = bVar.f8222b;
            if (this.f8238c == bVar) {
                this.f8238c = null;
            }
        }
        return bVar;
    }

    public void a(d dVar) {
        b bVar = this.f8237b;
        b bVar2 = null;
        while (bVar != null) {
            if (dVar.a(bVar)) {
                b bVar3 = bVar.f8222b;
                a(bVar2, bVar);
                bVar = bVar3;
            } else {
                bVar2 = bVar;
                bVar = bVar.f8222b;
            }
        }
    }

    private void a(b bVar, b bVar2) {
        if (this.f8238c == bVar2) {
            this.f8238c = bVar;
        }
        if (bVar == null) {
            this.f8237b = bVar2.f8222b;
        } else {
            bVar.f8222b = bVar2.f8222b;
        }
        this.f8240e.a(bVar2);
    }

    public void a() {
        while (true) {
            b bVar = this.f8237b;
            if (bVar != null) {
                this.f8237b = bVar.f8222b;
                this.f8240e.a(bVar);
            } else {
                this.f8238c = null;
                return;
            }
        }
    }
}
