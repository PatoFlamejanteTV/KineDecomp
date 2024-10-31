package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Xa implements zzbco {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaji f11953a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Xa(zzajm zzajmVar, zzaji zzajiVar) {
        this.f11953a = zzajiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void run() {
        zzaxz.v("Rejecting reference for JS Engine.");
        this.f11953a.reject();
    }
}
