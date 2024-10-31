package com.facebook.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileLruCache.java */
/* loaded from: classes.dex */
public class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FileLruCache f297a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FileLruCache fileLruCache) {
        this.f297a = fileLruCache;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f297a.trim();
    }
}
