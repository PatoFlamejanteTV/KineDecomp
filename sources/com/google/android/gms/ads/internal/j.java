package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzhs;

/* loaded from: classes.dex */
class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzhs.zza f583a;
    final /* synthetic */ zzn b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(zzn zznVar, zzhs.zza zzaVar) {
        this.b = zznVar;
        this.f583a = zzaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.zzb(new zzhs(this.f583a, null, null, null, null, null, null));
    }
}
