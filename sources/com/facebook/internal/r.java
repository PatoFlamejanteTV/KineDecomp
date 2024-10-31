package com.facebook.internal;

/* compiled from: FileLruCache.java */
/* loaded from: classes.dex */
public class r implements Runnable {

    /* renamed from: a */
    final /* synthetic */ FileLruCache f9333a;

    public r(FileLruCache fileLruCache) {
        this.f9333a = fileLruCache;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9333a.trim();
    }
}
