package com.google.android.gms.ads.internal.request;

import com.google.android.gms.ads.internal.request.zza;
import com.google.android.gms.internal.zzdz;
import com.google.android.gms.internal.zzhs;

/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzhs.zza f629a;
    final /* synthetic */ zzm b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(zzm zzmVar, zzhs.zza zzaVar) {
        this.b = zzmVar;
        this.f629a = zzaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zza.InterfaceC0027zza interfaceC0027zza;
        zzdz.zzd zzdVar;
        zzdz.zzd zzdVar2;
        interfaceC0027zza = this.b.h;
        interfaceC0027zza.zza(this.f629a);
        zzdVar = this.b.l;
        if (zzdVar != null) {
            zzdVar2 = this.b.l;
            zzdVar2.release();
            this.b.l = null;
        }
    }
}
