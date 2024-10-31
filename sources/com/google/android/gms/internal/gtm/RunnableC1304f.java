package com.google.android.gms.internal.gtm;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.gtm.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1304f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbw f13229a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzae f13230b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1304f(zzae zzaeVar, zzbw zzbwVar) {
        this.f13230b = zzaeVar;
        this.f13229a = zzbwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1320n c1320n;
        c1320n = this.f13230b.zzvu;
        c1320n.a(this.f13229a);
    }
}
