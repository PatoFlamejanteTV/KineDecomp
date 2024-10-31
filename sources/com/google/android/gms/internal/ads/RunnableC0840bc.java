package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.bc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC0840bc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicInteger f12075a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ int f12076b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzbcl f12077c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ List f12078d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0840bc(AtomicInteger atomicInteger, int i, zzbcl zzbclVar, List list) {
        this.f12075a = atomicInteger;
        this.f12076b = i;
        this.f12077c = zzbclVar;
        this.f12078d = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List zzk;
        if (this.f12075a.incrementAndGet() >= this.f12076b) {
            try {
                zzbcl zzbclVar = this.f12077c;
                zzk = zzapw.zzk(this.f12078d);
                zzbclVar.set(zzk);
            } catch (InterruptedException | ExecutionException e2) {
                zzbbd.zzc("Unable to convert list of futures to a future of list", e2);
            }
        }
    }
}
