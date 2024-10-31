package com.google.android.gms.internal;

/* loaded from: classes.dex */
class av implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzdt f1436a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(zzdt zzdtVar) {
        this.f1436a = zzdtVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.google.android.gms.ads.internal.zzp.r().zzb(this.f1436a);
    }
}
