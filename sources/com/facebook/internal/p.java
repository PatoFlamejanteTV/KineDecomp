package com.facebook.internal;

import com.facebook.internal.FileLruCache;
import java.io.File;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: FileLruCache.java */
/* loaded from: classes.dex */
public class p implements FileLruCache.e {

    /* renamed from: a */
    final /* synthetic */ long f9327a;

    /* renamed from: b */
    final /* synthetic */ File f9328b;

    /* renamed from: c */
    final /* synthetic */ String f9329c;

    /* renamed from: d */
    final /* synthetic */ FileLruCache f9330d;

    public p(FileLruCache fileLruCache, long j, File file, String str) {
        this.f9330d = fileLruCache;
        this.f9327a = j;
        this.f9328b = file;
        this.f9329c = str;
    }

    @Override // com.facebook.internal.FileLruCache.e
    public void onClose() {
        AtomicLong atomicLong;
        long j = this.f9327a;
        atomicLong = this.f9330d.lastClearCacheTime;
        if (j >= atomicLong.get()) {
            this.f9330d.renameToTargetAndTrim(this.f9329c, this.f9328b);
        } else {
            this.f9328b.delete();
        }
    }
}
