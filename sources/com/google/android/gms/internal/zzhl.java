package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza;

@zzgr
/* loaded from: classes.dex */
public class zzhl extends zza.AbstractBinderC0029zza {
    private zzhm zzHh;
    private zzhj zzHn;
    private zzhk zzHo;

    public zzhl(zzhk zzhkVar) {
        this.zzHo = zzhkVar;
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zza(com.google.android.gms.dynamic.zzd zzdVar, RewardItemParcel rewardItemParcel) {
        if (this.zzHo != null) {
            this.zzHo.zza(rewardItemParcel);
        }
    }

    public void zza(zzhj zzhjVar) {
        this.zzHn = zzhjVar;
    }

    public void zza(zzhm zzhmVar) {
        this.zzHh = zzhmVar;
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzb(com.google.android.gms.dynamic.zzd zzdVar, int i) {
        if (this.zzHn != null) {
            this.zzHn.zzK(i);
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzc(com.google.android.gms.dynamic.zzd zzdVar, int i) {
        if (this.zzHh != null) {
            this.zzHh.zzb(com.google.android.gms.dynamic.zze.a(zzdVar).getClass().getName(), i);
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzg(com.google.android.gms.dynamic.zzd zzdVar) {
        if (this.zzHn != null) {
            this.zzHn.zzge();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzh(com.google.android.gms.dynamic.zzd zzdVar) {
        if (this.zzHh != null) {
            this.zzHh.zzav(com.google.android.gms.dynamic.zze.a(zzdVar).getClass().getName());
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzi(com.google.android.gms.dynamic.zzd zzdVar) {
        if (this.zzHo != null) {
            this.zzHo.onRewardedVideoAdOpened();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzj(com.google.android.gms.dynamic.zzd zzdVar) {
        if (this.zzHo != null) {
            this.zzHo.onRewardedVideoStarted();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzk(com.google.android.gms.dynamic.zzd zzdVar) {
        if (this.zzHo != null) {
            this.zzHo.onRewardedVideoAdClosed();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzl(com.google.android.gms.dynamic.zzd zzdVar) {
        if (this.zzHo != null) {
            this.zzHo.zzgb();
        }
    }

    @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
    public void zzm(com.google.android.gms.dynamic.zzd zzdVar) {
        if (this.zzHo != null) {
            this.zzHo.onRewardedVideoAdLeftApplication();
        }
    }
}
