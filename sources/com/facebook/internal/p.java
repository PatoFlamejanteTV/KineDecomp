package com.facebook.internal;

import java.io.File;

/* compiled from: FileLruCache.java */
/* loaded from: classes.dex */
class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File[] f296a;
    final /* synthetic */ FileLruCache b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FileLruCache fileLruCache, File[] fileArr) {
        this.b = fileLruCache;
        this.f296a = fileArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (File file : this.f296a) {
            file.delete();
        }
    }
}
