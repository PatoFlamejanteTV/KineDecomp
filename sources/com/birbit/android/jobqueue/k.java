package com.birbit.android.jobqueue;

import com.birbit.android.jobqueue.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConsumerManager.java */
/* loaded from: classes.dex */
public class k extends com.birbit.android.jobqueue.messaging.f {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l.a f8176a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(l.a aVar) {
        this.f8176a = aVar;
    }

    @Override // com.birbit.android.jobqueue.messaging.f
    public void a(com.birbit.android.jobqueue.messaging.b bVar) {
        int i = i.f8173a[bVar.f8221a.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            this.f8176a.a((com.birbit.android.jobqueue.messaging.a.e) bVar);
        } else {
            this.f8176a.a((com.birbit.android.jobqueue.messaging.a.i) bVar);
            l.a aVar = this.f8176a;
            aVar.f8191g = aVar.f8189e.b();
            this.f8176a.b();
        }
    }

    @Override // com.birbit.android.jobqueue.messaging.f
    public void a() {
        com.birbit.android.jobqueue.f.c.a("consumer manager on idle", new Object[0]);
        com.birbit.android.jobqueue.messaging.a.g gVar = (com.birbit.android.jobqueue.messaging.a.g) this.f8176a.f8188d.a(com.birbit.android.jobqueue.messaging.a.g.class);
        gVar.a(this.f8176a);
        gVar.a(this.f8176a.f8191g);
        this.f8176a.f8187c.a(gVar);
    }
}
