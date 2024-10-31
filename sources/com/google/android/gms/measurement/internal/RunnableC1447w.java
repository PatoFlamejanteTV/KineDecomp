package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.w */
/* loaded from: classes2.dex */
public final class RunnableC1447w implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f13865a;

    /* renamed from: b */
    private final /* synthetic */ long f13866b;

    /* renamed from: c */
    private final /* synthetic */ zza f13867c;

    public RunnableC1447w(zza zzaVar, String str, long j) {
        this.f13867c = zzaVar;
        this.f13865a = str;
        this.f13866b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13867c.d(this.f13865a, this.f13866b);
    }
}
