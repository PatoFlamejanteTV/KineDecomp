package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zziz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzhs.zza f532a;
    final /* synthetic */ zzcg b;
    final /* synthetic */ zzc c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(zzc zzcVar, zzhs.zza zzaVar, zzcg zzcgVar) {
        this.c = zzcVar;
        this.f532a = zzaVar;
        this.b = zzcgVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f532a.zzHD.s && this.c.zzot.x != null) {
            zzch zzchVar = new zzch(this.c, this.f532a.zzHD.b != null ? zzp.e().zzaz(this.f532a.zzHD.b) : null, this.f532a.zzHD.c);
            this.c.zzot.C = 1;
            try {
                this.c.zzot.x.zza(zzchVar);
                return;
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.d("Could not call the onCustomRenderedAdLoadedListener.", e);
            }
        }
        zze zzeVar = new zze();
        zziz a2 = this.c.a(this.f532a, zzeVar);
        zzeVar.a(new zze.zzb(this.f532a, a2));
        a2.setOnTouchListener(new d(this, zzeVar));
        a2.setOnClickListener(new e(this, zzeVar));
        this.c.zzot.C = 0;
        this.c.zzot.h = zzp.d().zza(this.c.zzot.c, this.c, this.f532a, this.c.zzot.d, a2, this.c.zzox, this.c, this.b);
    }
}
