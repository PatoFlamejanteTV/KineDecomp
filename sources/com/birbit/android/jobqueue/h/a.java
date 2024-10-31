package com.birbit.android.jobqueue.h;

import android.content.Context;

/* compiled from: Scheduler.java */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a */
    private InterfaceC0043a f8166a;

    /* renamed from: b */
    private Context f8167b;

    /* compiled from: Scheduler.java */
    /* renamed from: com.birbit.android.jobqueue.h.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0043a {
    }

    public abstract void a();

    public void a(Context context, InterfaceC0043a interfaceC0043a) {
        this.f8167b = context.getApplicationContext();
        this.f8166a = interfaceC0043a;
    }

    public abstract void a(b bVar);

    public abstract void a(b bVar, boolean z);
}
