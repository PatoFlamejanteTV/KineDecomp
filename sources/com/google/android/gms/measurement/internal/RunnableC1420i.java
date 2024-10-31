package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.i */
/* loaded from: classes2.dex */
public final class RunnableC1420i implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f13773a;

    /* renamed from: b */
    private final /* synthetic */ long f13774b;

    /* renamed from: c */
    private final /* synthetic */ zza f13775c;

    public RunnableC1420i(zza zzaVar, String str, long j) {
        this.f13775c = zzaVar;
        this.f13773a = str;
        this.f13774b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13775c.c(this.f13773a, this.f13774b);
    }
}
