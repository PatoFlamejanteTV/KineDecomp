package com.google.android.gms.internal.gtm;

/* renamed from: com.google.android.gms.internal.gtm.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1312j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzce f13239a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzav f13240b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1312j(zzav zzavVar, zzce zzceVar) {
        this.f13240b = zzavVar;
        this.f13239a = zzceVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f13240b.zzxe.isConnected()) {
            return;
        }
        this.f13240b.zzxe.zzr("Connected to service after a timeout");
        zzat.zza(this.f13240b.zzxe, this.f13239a);
    }
}
