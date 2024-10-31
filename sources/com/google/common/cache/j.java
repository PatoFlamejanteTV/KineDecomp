package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalCache.java */
/* loaded from: classes2.dex */
public class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f15260a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f15261b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ LocalCache.i f15262c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ListenableFuture f15263d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ LocalCache.Segment f15264e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LocalCache.Segment segment, Object obj, int i, LocalCache.i iVar, ListenableFuture listenableFuture) {
        this.f15264e = segment;
        this.f15260a = obj;
        this.f15261b = i;
        this.f15262c = iVar;
        this.f15263d = listenableFuture;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f15264e.getAndRecordStats(this.f15260a, this.f15261b, this.f15262c, this.f15263d);
        } catch (Throwable th) {
            LocalCache.f15182a.log(Level.WARNING, "Exception thrown during refresh", th);
            this.f15262c.a(th);
        }
    }
}
