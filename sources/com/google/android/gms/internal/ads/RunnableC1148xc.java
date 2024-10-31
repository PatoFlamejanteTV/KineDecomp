package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.xc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1148xc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbbh f12653a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f12654b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1148xc(zzare zzareVar, zzbbh zzbbhVar, String str) {
        this.f12653a = zzbbhVar;
        this.f12654b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12653a.zzed(this.f12654b);
    }
}
