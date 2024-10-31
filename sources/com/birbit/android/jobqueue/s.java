package com.birbit.android.jobqueue;

/* compiled from: JobManagerThread.java */
/* loaded from: classes.dex */
class s extends com.birbit.android.jobqueue.messaging.f {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ u f8309a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(u uVar) {
        this.f8309a = uVar;
    }

    @Override // com.birbit.android.jobqueue.messaging.f
    public void a(com.birbit.android.jobqueue.messaging.b bVar) {
        boolean z = true;
        this.f8309a.p = true;
        switch (t.f8310a[bVar.f8221a.ordinal()]) {
            case 1:
                this.f8309a.a((com.birbit.android.jobqueue.messaging.a.a) bVar);
                return;
            case 2:
                if (this.f8309a.i.a((com.birbit.android.jobqueue.messaging.a.g) bVar)) {
                    return;
                }
                this.f8309a.h();
                return;
            case 3:
                this.f8309a.a((com.birbit.android.jobqueue.messaging.a.j) bVar);
                return;
            case 4:
                boolean c2 = this.f8309a.i.c();
                com.birbit.android.jobqueue.messaging.a.f fVar = (com.birbit.android.jobqueue.messaging.a.f) bVar;
                u uVar = this.f8309a;
                if (!c2 && fVar.c()) {
                    z = false;
                }
                uVar.p = z;
                return;
            case 5:
                this.f8309a.a((com.birbit.android.jobqueue.messaging.a.c) bVar);
                return;
            case 6:
                this.f8309a.a((com.birbit.android.jobqueue.messaging.a.h) bVar);
                return;
            case 7:
                this.f8309a.a((com.birbit.android.jobqueue.messaging.a.e) bVar);
                return;
            case 8:
                this.f8309a.a((com.birbit.android.jobqueue.messaging.a.k) bVar);
                return;
            default:
                return;
        }
    }

    @Override // com.birbit.android.jobqueue.messaging.f
    public void a() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        com.birbit.android.jobqueue.messaging.c cVar;
        z = this.f8309a.n;
        com.birbit.android.jobqueue.f.c.c("joq idle. running:? %s", Boolean.valueOf(z));
        z2 = this.f8309a.n;
        if (z2) {
            z3 = this.f8309a.p;
            if (!z3) {
                com.birbit.android.jobqueue.f.c.c("skipping scheduling a new idle callback because looks like last one did not do anything", new Object[0]);
                return;
            }
            Long a2 = this.f8309a.a(true);
            com.birbit.android.jobqueue.f.c.a("Job queue idle. next job at: %s", a2);
            if (a2 != null) {
                cVar = this.f8309a.f8318h;
                com.birbit.android.jobqueue.messaging.a.f fVar = (com.birbit.android.jobqueue.messaging.a.f) cVar.a(com.birbit.android.jobqueue.messaging.a.f.class);
                fVar.a(true);
                this.f8309a.q.a(fVar, a2.longValue());
                return;
            }
            u uVar = this.f8309a;
            if (uVar.r != null) {
                z4 = uVar.o;
                if (z4 && this.f8309a.f8314d.count() == 0) {
                    this.f8309a.o = false;
                    this.f8309a.r.a();
                }
            }
        }
    }
}
