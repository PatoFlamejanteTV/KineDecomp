package com.bumptech.glide.load.engine;

import java.util.concurrent.ThreadFactory;

/* compiled from: ActiveResources.java */
/* renamed from: com.bumptech.glide.load.engine.b */
/* loaded from: classes.dex */
public class ThreadFactoryC0712b implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(new RunnableC0711a(this, runnable), "glide-active-resources");
    }
}
