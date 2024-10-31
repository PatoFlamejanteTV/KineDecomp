package com.google.android.gms.internal.gtm;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.gtm.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1295c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f13213a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Runnable f13214b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzae f13215c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1295c(zzae zzaeVar, String str, Runnable runnable) {
        this.f13215c = zzaeVar;
        this.f13213a = str;
        this.f13214b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1320n c1320n;
        c1320n = this.f13215c.zzvu;
        c1320n.e(this.f13213a);
        Runnable runnable = this.f13214b;
        if (runnable != null) {
            runnable.run();
        }
    }
}
