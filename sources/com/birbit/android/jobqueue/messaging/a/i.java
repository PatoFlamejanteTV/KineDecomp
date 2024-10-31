package com.birbit.android.jobqueue.messaging.a;

import com.birbit.android.jobqueue.messaging.Type;
import com.birbit.android.jobqueue.p;

/* compiled from: RunJobMessage.java */
/* loaded from: classes.dex */
public class i extends com.birbit.android.jobqueue.messaging.b {

    /* renamed from: d */
    private p f8215d;

    public i() {
        super(Type.RUN_JOB);
    }

    public void a(p pVar) {
        this.f8215d = pVar;
    }

    public p c() {
        return this.f8215d;
    }

    @Override // com.birbit.android.jobqueue.messaging.b
    protected void a() {
        this.f8215d = null;
    }
}
