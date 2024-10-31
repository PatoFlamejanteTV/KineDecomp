package com.flurry.sdk;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public class ba implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final ThreadGroup f474a;
    private final int b;

    public ba(String str, int i) {
        this.f474a = new ThreadGroup(str);
        this.b = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f474a, runnable);
        thread.setName(this.f474a.getName() + ":" + thread.getId());
        thread.setPriority(this.b);
        return thread;
    }
}
