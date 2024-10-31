package com.birbit.android.jobqueue.messaging.a;

import com.birbit.android.jobqueue.TagConstraint;
import com.birbit.android.jobqueue.g;
import com.birbit.android.jobqueue.messaging.Type;

/* compiled from: CancelMessage.java */
/* loaded from: classes.dex */
public class c extends com.birbit.android.jobqueue.messaging.b {

    /* renamed from: d */
    private TagConstraint f8202d;

    /* renamed from: e */
    private String[] f8203e;

    /* renamed from: f */
    private g.a f8204f;

    public c() {
        super(Type.CANCEL);
    }

    @Override // com.birbit.android.jobqueue.messaging.b
    protected void a() {
    }

    public g.a c() {
        return this.f8204f;
    }

    public TagConstraint d() {
        return this.f8202d;
    }

    public String[] e() {
        return this.f8203e;
    }
}
