package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ed implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AtomicInteger f1523a;
    final /* synthetic */ int b;
    final /* synthetic */ zzin c;
    final /* synthetic */ List d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed(AtomicInteger atomicInteger, int i, zzin zzinVar, List list) {
        this.f1523a = atomicInteger;
        this.b = i;
        this.c = zzinVar;
        this.d = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        List zzi;
        if (this.f1523a.incrementAndGet() >= this.b) {
            try {
                zzin zzinVar = this.c;
                zzi = zzip.zzi(this.d);
                zzinVar.zzf(zzi);
            } catch (InterruptedException | ExecutionException e) {
                com.google.android.gms.ads.internal.util.client.zzb.d("Unable to convert list of futures to a future of list", e);
            }
        }
    }
}
