package com.squareup.okhttp.a;

import java.util.concurrent.ThreadFactory;

/* compiled from: Util.java */
/* loaded from: classes3.dex */
class n implements ThreadFactory {

    /* renamed from: a */
    final /* synthetic */ String f25215a;

    /* renamed from: b */
    final /* synthetic */ boolean f25216b;

    public n(String str, boolean z) {
        this.f25215a = str;
        this.f25216b = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f25215a);
        thread.setDaemon(this.f25216b);
        return thread;
    }
}
