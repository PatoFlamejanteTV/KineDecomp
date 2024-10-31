package com.birbit.android.jobqueue.messaging.a;

import com.birbit.android.jobqueue.g;
import com.birbit.android.jobqueue.messaging.Type;

/* compiled from: CancelResultMessage.java */
/* loaded from: classes.dex */
public class d extends com.birbit.android.jobqueue.messaging.b {

    /* renamed from: d */
    g.a f8205d;

    /* renamed from: e */
    com.birbit.android.jobqueue.g f8206e;

    public d() {
        super(Type.CANCEL_RESULT_CALLBACK);
    }

    @Override // com.birbit.android.jobqueue.messaging.b
    protected void a() {
        this.f8206e = null;
        this.f8205d = null;
    }

    public g.a c() {
        return this.f8205d;
    }

    public com.birbit.android.jobqueue.g d() {
        return this.f8206e;
    }

    public void a(g.a aVar, com.birbit.android.jobqueue.g gVar) {
        this.f8205d = aVar;
        this.f8206e = gVar;
    }
}
