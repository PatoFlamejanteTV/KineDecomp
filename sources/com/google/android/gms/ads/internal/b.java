package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzhs;

/* loaded from: classes.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzhs.zza f531a;
    final /* synthetic */ zzc b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(zzc zzcVar, zzhs.zza zzaVar) {
        this.b = zzcVar;
        this.f531a = zzaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.zzb(new zzhs(this.f531a, null, null, null, null, null, null));
    }
}
