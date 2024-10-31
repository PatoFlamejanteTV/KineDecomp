package com.google.android.gms.internal;

import com.google.android.gms.internal.zzgg;

/* loaded from: classes.dex */
class co implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzhs f1481a;
    final /* synthetic */ zzgl b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(zzgl zzglVar, zzhs zzhsVar) {
        this.b = zzglVar;
        this.f1481a = zzhsVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzgg.zza zzaVar;
        zzaVar = this.b.zzDd;
        zzaVar.zzb(this.f1481a);
    }
}
