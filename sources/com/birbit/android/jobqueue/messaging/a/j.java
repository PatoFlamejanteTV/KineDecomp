package com.birbit.android.jobqueue.messaging.a;

import com.birbit.android.jobqueue.messaging.Type;
import com.birbit.android.jobqueue.p;

/* compiled from: RunJobResultMessage.java */
/* loaded from: classes.dex */
public class j extends com.birbit.android.jobqueue.messaging.b {

    /* renamed from: d */
    private p f8216d;

    /* renamed from: e */
    private Object f8217e;

    /* renamed from: f */
    private int f8218f;

    public j() {
        super(Type.RUN_JOB_RESULT);
    }

    public void a(p pVar) {
        this.f8216d = pVar;
    }

    public p c() {
        return this.f8216d;
    }

    public int d() {
        return this.f8218f;
    }

    public Object e() {
        return this.f8217e;
    }

    @Override // com.birbit.android.jobqueue.messaging.b
    protected void a() {
        this.f8216d = null;
    }

    public void a(int i) {
        this.f8218f = i;
    }

    public void a(Object obj) {
        this.f8217e = obj;
    }
}
