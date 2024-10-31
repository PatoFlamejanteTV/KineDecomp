package com.birbit.android.jobqueue;

import com.birbit.android.jobqueue.messaging.Type;

/* compiled from: ConsumerManager.java */
/* loaded from: classes.dex */
class j implements com.birbit.android.jobqueue.messaging.d {
    @Override // com.birbit.android.jobqueue.messaging.d
    public boolean a(com.birbit.android.jobqueue.messaging.b bVar) {
        return bVar.f8221a == Type.COMMAND && ((com.birbit.android.jobqueue.messaging.a.e) bVar).d() == 2;
    }
}
