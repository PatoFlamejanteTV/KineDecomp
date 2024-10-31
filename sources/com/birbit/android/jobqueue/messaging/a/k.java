package com.birbit.android.jobqueue.messaging.a;

import com.birbit.android.jobqueue.messaging.Type;

/* compiled from: SchedulerMessage.java */
/* loaded from: classes.dex */
public class k extends com.birbit.android.jobqueue.messaging.b {

    /* renamed from: d */
    private int f8219d;

    /* renamed from: e */
    private com.birbit.android.jobqueue.h.b f8220e;

    public k() {
        super(Type.SCHEDULER);
    }

    @Override // com.birbit.android.jobqueue.messaging.b
    protected void a() {
        this.f8220e = null;
    }

    public com.birbit.android.jobqueue.h.b c() {
        return this.f8220e;
    }

    public int d() {
        return this.f8219d;
    }
}
