package com.facebook.internal;

import com.facebook.internal.FileLruCache;
import java.io.File;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileLruCache.java */
/* loaded from: classes.dex */
public class o implements FileLruCache.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f295a;
    final /* synthetic */ File b;
    final /* synthetic */ String c;
    final /* synthetic */ FileLruCache d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FileLruCache fileLruCache, long j, File file, String str) {
        this.d = fileLruCache;
        this.f295a = j;
        this.b = file;
        this.c = str;
    }

    @Override // com.facebook.internal.FileLruCache.e
    public void a() {
        AtomicLong atomicLong;
        long j = this.f295a;
        atomicLong = this.d.lastClearCacheTime;
        if (j >= atomicLong.get()) {
            this.d.renameToTargetAndTrim(this.c, this.b);
        } else {
            this.b.delete();
        }
    }
}
