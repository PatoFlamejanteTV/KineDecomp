package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzfi;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zziz;

@zzgr
/* loaded from: classes.dex */
public abstract class zzc extends zzb implements zzg, zzfi {
    public zzc(Context context, AdSizeParcel adSizeParcel, String str, zzem zzemVar, VersionInfoParcel versionInfoParcel, zzd zzdVar) {
        super(context, adSizeParcel, str, zzemVar, versionInfoParcel, zzdVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public zziz a(zzhs.zza zzaVar, zze zzeVar) {
        zziz zzizVar;
        View nextView = this.zzot.f.getNextView();
        if (nextView instanceof zziz) {
            com.google.android.gms.ads.internal.util.client.zzb.a("Reusing webview...");
            zziz zzizVar2 = (zziz) nextView;
            zzizVar2.zza(this.zzot.c, this.zzot.i, this.zzoo);
            zzizVar = zzizVar2;
        } else {
            if (nextView != 0) {
                this.zzot.f.removeView(nextView);
            }
            zziz zza = zzp.f().zza(this.zzot.c, this.zzot.i, false, false, this.zzot.d, this.zzot.e, this.zzoo, this.zzow);
            if (this.zzot.i.h == null) {
                zzb(zza.getView());
            }
            zzizVar = zza;
        }
        zzizVar.zzhe().zzb(this, this, this, this, false, this, null, zzeVar, this);
        zzizVar.zzaJ(zzaVar.zzHC.w);
        return zzizVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public void a() {
        onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public void a(View view) {
        this.zzot.B = view;
        zzb(new zzhs(this.zzot.k, null, null, null, null, null, null));
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.zzg
    public void recordImpression() {
        zza(this.zzot.j, false);
    }

    @Override // com.google.android.gms.internal.zzfi
    public void zza(int i, int i2, int i3, int i4) {
        zzaS();
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzs
    public void zza(zzck zzckVar) {
        zzx.b("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzot.x = zzckVar;
    }

    @Override // com.google.android.gms.ads.internal.zza
    protected void zza(zzhs.zza zzaVar, zzcg zzcgVar) {
        if (zzaVar.errorCode != -2) {
            zzid.zzIE.post(new b(this, zzaVar));
            return;
        }
        if (zzaVar.zzqn != null) {
            this.zzot.i = zzaVar.zzqn;
        }
        if (!zzaVar.zzHD.h) {
            zzid.zzIE.post(new c(this, zzaVar, zzcgVar));
            return;
        }
        this.zzot.C = 0;
        this.zzot.h = zzp.d().zza(this.zzot.c, this, zzaVar, this.zzot.d, null, this.zzox, this, zzcgVar);
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza
    public boolean zza(zzhs zzhsVar, zzhs zzhsVar2) {
        if (this.zzot.e() && this.zzot.f != null) {
            this.zzot.f.a().zzaC(zzhsVar2.zzEP);
        }
        return super.zza(zzhsVar, zzhsVar2);
    }

    @Override // com.google.android.gms.internal.zzfi
    public void zzbc() {
        zzaQ();
    }
}
