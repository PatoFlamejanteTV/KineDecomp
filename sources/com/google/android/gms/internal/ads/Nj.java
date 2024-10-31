package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Nj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzdl f11718a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Nj(zzdl zzdlVar) {
        this.f11718a = zzdlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaan.initialize(this.f11718a.zzsp);
    }
}
