package com.birbit.android.jobqueue.messaging;

/* compiled from: Message.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a */
    public final Type f8221a;

    /* renamed from: b */
    b f8222b;

    /* renamed from: c */
    public long f8223c = Long.MIN_VALUE;

    public b(Type type) {
        this.f8221a = type;
    }

    protected abstract void a();

    public final void b() {
        this.f8222b = null;
        this.f8223c = Long.MIN_VALUE;
        a();
    }
}
