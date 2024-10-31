package com.birbit.android.jobqueue.messaging;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DelayedMessageBag.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    b f8194a = null;

    /* renamed from: b */
    final c f8195b;

    public a(c cVar) {
        this.f8195b = cVar;
    }

    public Long a(long j, e eVar) {
        com.birbit.android.jobqueue.f.c.a("flushing messages at time %s", Long.valueOf(j));
        while (true) {
            b bVar = this.f8194a;
            if (bVar == null || bVar.f8223c > j) {
                break;
            }
            this.f8194a = bVar.f8222b;
            bVar.f8222b = null;
            eVar.a(bVar);
        }
        b bVar2 = this.f8194a;
        if (bVar2 == null) {
            return null;
        }
        com.birbit.android.jobqueue.f.c.a("returning next ready at %d ns", Long.valueOf(bVar2.f8223c - j));
        return Long.valueOf(this.f8194a.f8223c);
    }

    public void a(b bVar, long j) {
        b bVar2;
        com.birbit.android.jobqueue.f.c.a("add delayed message %s at time %s", bVar, Long.valueOf(j));
        bVar.f8223c = j;
        b bVar3 = this.f8194a;
        if (bVar3 == null) {
            this.f8194a = bVar;
            return;
        }
        b bVar4 = null;
        while (true) {
            bVar2 = bVar4;
            bVar4 = bVar3;
            if (bVar4 == null || bVar4.f8223c > j) {
                break;
            } else {
                bVar3 = bVar4.f8222b;
            }
        }
        if (bVar2 == null) {
            bVar.f8222b = this.f8194a;
            this.f8194a = bVar;
        } else {
            bVar2.f8222b = bVar;
            bVar.f8222b = bVar4;
        }
    }

    public void a(d dVar) {
        b bVar = this.f8194a;
        b bVar2 = null;
        while (bVar != null) {
            boolean a2 = dVar.a(bVar);
            b bVar3 = bVar.f8222b;
            if (a2) {
                if (bVar2 == null) {
                    this.f8194a = bVar3;
                } else {
                    bVar2.f8222b = bVar3;
                }
                this.f8195b.a(bVar);
            } else {
                bVar2 = bVar;
            }
            bVar = bVar3;
        }
    }
}
