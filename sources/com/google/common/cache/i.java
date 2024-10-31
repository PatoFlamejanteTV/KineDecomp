package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.logging.Level;

/* compiled from: LocalCache.java */
/* loaded from: classes2.dex */
public class i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Object f2630a;
    final /* synthetic */ int b;
    final /* synthetic */ LocalCache.h c;
    final /* synthetic */ ListenableFuture d;
    final /* synthetic */ LocalCache.Segment e;

    public i(LocalCache.Segment segment, Object obj, int i, LocalCache.h hVar, ListenableFuture listenableFuture) {
        this.e = segment;
        this.f2630a = obj;
        this.b = i;
        this.c = hVar;
        this.d = listenableFuture;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.c.b((LocalCache.h) this.e.getAndRecordStats(this.f2630a, this.b, this.c, this.d));
        } catch (Throwable th) {
            LocalCache.f2603a.log(Level.WARNING, "Exception thrown during refresh", th);
            this.c.a(th);
        }
    }
}
