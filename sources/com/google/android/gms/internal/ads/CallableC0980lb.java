package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.ads.lb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class CallableC0980lb implements Callable<zzakx> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaku f12290a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzala f12291b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallableC0980lb(zzala zzalaVar, zzaku zzakuVar) {
        this.f12291b = zzalaVar;
        this.f12290a = zzakuVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzakx call() throws Exception {
        Object obj;
        boolean z;
        long j;
        long j2;
        obj = this.f12291b.mLock;
        synchronized (obj) {
            z = this.f12291b.zzdnk;
            if (z) {
                return null;
            }
            zzaku zzakuVar = this.f12290a;
            j = this.f12291b.mStartTime;
            j2 = this.f12291b.zzdni;
            return zzakuVar.zzj(j, j2);
        }
    }
}
