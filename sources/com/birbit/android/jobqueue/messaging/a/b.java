package com.birbit.android.jobqueue.messaging.a;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.messaging.Type;

/* compiled from: CallbackMessage.java */
/* loaded from: classes.dex */
public class b extends com.birbit.android.jobqueue.messaging.b {

    /* renamed from: d */
    private int f8197d;

    /* renamed from: e */
    private int f8198e;

    /* renamed from: f */
    private boolean f8199f;

    /* renamed from: g */
    private Job f8200g;

    /* renamed from: h */
    private Throwable f8201h;

    public b() {
        super(Type.CALLBACK);
    }

    @Override // com.birbit.android.jobqueue.messaging.b
    protected void a() {
        this.f8200g = null;
        this.f8201h = null;
    }

    public Job c() {
        return this.f8200g;
    }

    public int d() {
        return this.f8198e;
    }

    public Throwable e() {
        return this.f8201h;
    }

    public int f() {
        return this.f8197d;
    }

    public boolean g() {
        return this.f8199f;
    }

    public void a(Job job, int i) {
        this.f8197d = i;
        this.f8200g = job;
    }

    public void a(Job job, int i, int i2) {
        this.f8197d = i;
        this.f8198e = i2;
        this.f8200g = job;
    }

    public void a(Job job, int i, boolean z, Throwable th) {
        this.f8197d = i;
        this.f8199f = z;
        this.f8200g = job;
        this.f8201h = th;
    }
}
