package com.birbit.android.jobqueue.messaging.a;

import com.birbit.android.jobqueue.messaging.Type;

/* compiled from: JobConsumerIdleMessage.java */
/* loaded from: classes.dex */
public class g extends com.birbit.android.jobqueue.messaging.b {

    /* renamed from: d */
    private Object f8210d;

    /* renamed from: e */
    private long f8211e;

    public g() {
        super(Type.JOB_CONSUMER_IDLE);
    }

    @Override // com.birbit.android.jobqueue.messaging.b
    protected void a() {
        this.f8210d = null;
    }

    public long c() {
        return this.f8211e;
    }

    public Object d() {
        return this.f8210d;
    }

    public void a(Object obj) {
        this.f8210d = obj;
    }

    public void a(long j) {
        this.f8211e = j;
    }
}
