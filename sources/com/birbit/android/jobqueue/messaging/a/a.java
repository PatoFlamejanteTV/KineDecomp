package com.birbit.android.jobqueue.messaging.a;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.messaging.Type;

/* compiled from: AddJobMessage.java */
/* loaded from: classes.dex */
public class a extends com.birbit.android.jobqueue.messaging.b {

    /* renamed from: d */
    private Job f8196d;

    public a() {
        super(Type.ADD_JOB);
    }

    public void a(Job job) {
        this.f8196d = job;
    }

    public Job c() {
        return this.f8196d;
    }

    @Override // com.birbit.android.jobqueue.messaging.b
    protected void a() {
        this.f8196d = null;
    }
}
