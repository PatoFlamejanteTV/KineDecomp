package com.google.android.gms.internal.gtm;

/* renamed from: com.google.android.gms.internal.gtm.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1292b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f13204a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzae f13205b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1292b(zzae zzaeVar, boolean z) {
        this.f13205b = zzaeVar;
        this.f13204a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1320n c1320n;
        c1320n = this.f13205b.zzvu;
        c1320n.r();
    }
}
