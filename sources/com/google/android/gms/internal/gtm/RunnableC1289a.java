package com.google.android.gms.internal.gtm;

/* renamed from: com.google.android.gms.internal.gtm.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1289a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f13199a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzae f13200b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1289a(zzae zzaeVar, int i) {
        this.f13200b = zzaeVar;
        this.f13199a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1320n c1320n;
        c1320n = this.f13200b.zzvu;
        c1320n.g(this.f13199a * 1000);
    }
}
