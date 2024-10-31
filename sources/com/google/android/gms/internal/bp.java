package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbb f1456a;
    final /* synthetic */ bo b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bo boVar, zzbb zzbbVar) {
        this.b = boVar;
        this.f1456a = zzbbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzdz.zzb zzbVar;
        zzbVar = this.b.f1455a.zzyq;
        zzbVar.zzc(this.f1456a);
        this.f1456a.destroy();
    }
}
