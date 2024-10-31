package com.google.android.gms.internal.gtm;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.gtm.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1298d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzcd f13223a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzae f13224b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1298d(zzae zzaeVar, zzcd zzcdVar) {
        this.f13224b = zzaeVar;
        this.f13223a = zzcdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1320n c1320n;
        c1320n = this.f13224b.zzvu;
        c1320n.zza(this.f13223a);
    }
}
