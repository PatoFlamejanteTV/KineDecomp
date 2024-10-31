package com.birbit.android.jobqueue;

import com.birbit.android.jobqueue.messaging.Type;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: CallbackManager.java */
/* loaded from: classes.dex */
class c extends com.birbit.android.jobqueue.messaging.f {

    /* renamed from: a, reason: collision with root package name */
    long f8119a = Long.MIN_VALUE;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f8120b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar) {
        this.f8120b = dVar;
    }

    @Override // com.birbit.android.jobqueue.messaging.f
    public void a() {
    }

    @Override // com.birbit.android.jobqueue.messaging.f
    public void a(com.birbit.android.jobqueue.messaging.b bVar) {
        AtomicBoolean atomicBoolean;
        com.birbit.android.jobqueue.i.b bVar2;
        com.birbit.android.jobqueue.i.b bVar3;
        Type type = bVar.f8221a;
        if (type == Type.CALLBACK) {
            this.f8120b.f8131a.a((com.birbit.android.jobqueue.messaging.a.b) bVar);
            bVar3 = this.f8120b.f8131a.f8136e;
            this.f8119a = bVar3.b();
            return;
        }
        if (type == Type.CANCEL_RESULT_CALLBACK) {
            this.f8120b.f8131a.a((com.birbit.android.jobqueue.messaging.a.d) bVar);
            bVar2 = this.f8120b.f8131a.f8136e;
            this.f8119a = bVar2.b();
            return;
        }
        if (type == Type.COMMAND) {
            com.birbit.android.jobqueue.messaging.a.e eVar = (com.birbit.android.jobqueue.messaging.a.e) bVar;
            int d2 = eVar.d();
            if (d2 == 1) {
                this.f8120b.f8131a.f8132a.c();
                atomicBoolean = this.f8120b.f8131a.f8137f;
                atomicBoolean.set(false);
                return;
            } else {
                if (d2 == 3) {
                    eVar.c().run();
                    return;
                }
                return;
            }
        }
        if (type == Type.PUBLIC_QUERY) {
            ((com.birbit.android.jobqueue.messaging.a.h) bVar).c().a(0);
        }
    }

    @Override // com.birbit.android.jobqueue.messaging.f
    public void b() {
    }
}
