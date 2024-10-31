package com.birbit.android.jobqueue.messaging.a;

import com.birbit.android.jobqueue.messaging.Type;

/* compiled from: CommandMessage.java */
/* loaded from: classes.dex */
public class e extends com.birbit.android.jobqueue.messaging.b {

    /* renamed from: d */
    private int f8207d;

    /* renamed from: e */
    private Runnable f8208e;

    public e() {
        super(Type.COMMAND);
    }

    @Override // com.birbit.android.jobqueue.messaging.b
    protected void a() {
        this.f8207d = -1;
        this.f8208e = null;
    }

    public Runnable c() {
        return this.f8208e;
    }

    public int d() {
        return this.f8207d;
    }

    public String toString() {
        return "Command[" + this.f8207d + "]";
    }

    public void a(int i) {
        this.f8207d = i;
    }
}
