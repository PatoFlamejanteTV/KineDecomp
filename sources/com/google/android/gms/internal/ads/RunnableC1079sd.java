package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.sd */
/* loaded from: classes2.dex */
public final class RunnableC1079sd implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzaxv f12514a;

    public RunnableC1079sd(zzaxv zzaxvVar) {
        this.f12514a = zzaxvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12514a.zzeke = Thread.currentThread();
        this.f12514a.zzki();
    }
}
