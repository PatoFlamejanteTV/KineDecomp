package com.birbit.android.jobqueue.messaging.a;

import com.birbit.android.jobqueue.messaging.Type;
import com.birbit.android.jobqueue.n;

/* compiled from: PublicQueryMessage.java */
/* loaded from: classes.dex */
public class h extends com.birbit.android.jobqueue.messaging.b implements n.a {

    /* renamed from: d */
    private n f8212d;

    /* renamed from: e */
    private int f8213e;

    /* renamed from: f */
    private String f8214f;

    public h() {
        super(Type.PUBLIC_QUERY);
        this.f8213e = -1;
    }

    @Override // com.birbit.android.jobqueue.messaging.b
    protected void a() {
        this.f8212d = null;
        this.f8213e = -1;
    }

    public n c() {
        return this.f8212d;
    }

    public String d() {
        return this.f8214f;
    }

    public int e() {
        return this.f8213e;
    }

    public String toString() {
        return "PublicQuery[" + this.f8213e + "]";
    }
}
