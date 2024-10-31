package com.google.android.gms.internal;

import com.google.android.gms.internal.zzhs;

/* loaded from: classes.dex */
class df implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzhs.zza f1499a;
    final /* synthetic */ zzhg b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(zzhg zzhgVar, zzhs.zza zzaVar) {
        this.b = zzhgVar;
        this.f1499a = zzaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.zzb(new zzhs(this.f1499a, null, null, null, null, null, null));
    }
}
