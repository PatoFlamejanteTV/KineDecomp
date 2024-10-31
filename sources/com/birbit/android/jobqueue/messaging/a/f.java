package com.birbit.android.jobqueue.messaging.a;

import com.birbit.android.jobqueue.messaging.Type;

/* compiled from: ConstraintChangeMessage.java */
/* loaded from: classes.dex */
public class f extends com.birbit.android.jobqueue.messaging.b {

    /* renamed from: d */
    private boolean f8209d;

    public f() {
        super(Type.CONSTRAINT_CHANGE);
    }

    @Override // com.birbit.android.jobqueue.messaging.b
    protected void a() {
        this.f8209d = false;
    }

    public boolean c() {
        return this.f8209d;
    }

    public void a(boolean z) {
        this.f8209d = z;
    }
}
