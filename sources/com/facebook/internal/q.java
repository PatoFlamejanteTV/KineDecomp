package com.facebook.internal;

import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileLruCache.java */
/* loaded from: classes.dex */
public class q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ File[] f9331a;

    /* renamed from: b */
    final /* synthetic */ FileLruCache f9332b;

    public q(FileLruCache fileLruCache, File[] fileArr) {
        this.f9332b = fileLruCache;
        this.f9331a = fileArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (File file : this.f9331a) {
            file.delete();
        }
    }
}
