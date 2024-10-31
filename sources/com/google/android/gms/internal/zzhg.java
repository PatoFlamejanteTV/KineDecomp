package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzhs;
import java.util.HashMap;

@zzgr
/* loaded from: classes.dex */
public class zzhg extends com.google.android.gms.ads.internal.zzb implements zzhk {
    private com.google.android.gms.ads.internal.reward.client.zzd zzGX;
    private String zzGY;
    private boolean zzGZ;
    private HashMap<String, zzhh> zzHa;

    public zzhg(Context context, AdSizeParcel adSizeParcel, zzem zzemVar, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, null, zzemVar, versionInfoParcel, null);
        this.zzHa = new HashMap<>();
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzs
    public void destroy() {
        com.google.android.gms.common.internal.zzx.b("destroy must be called on the main UI thread.");
        for (String str : this.zzHa.keySet()) {
            try {
                zzhh zzhhVar = this.zzHa.get(str);
                if (zzhhVar != null && zzhhVar.zzgc() != null) {
                    zzhhVar.zzgc().destroy();
                }
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.e("Fail to destroy adapter: " + str);
            }
        }
    }

    public boolean isLoaded() {
        com.google.android.gms.common.internal.zzx.b("isLoaded must be called on the main UI thread.");
        return this.zzot.g == null && this.zzot.h == null && this.zzot.j != null && !this.zzGZ;
    }

    @Override // com.google.android.gms.internal.zzhk
    public void onRewardedVideoAdClosed() {
        if (this.zzGX == null) {
            return;
        }
        try {
            this.zzGX.d();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call RewardedVideoAdListener.onAdClosed().", e);
        }
    }

    @Override // com.google.android.gms.internal.zzhk
    public void onRewardedVideoAdLeftApplication() {
        if (this.zzGX == null) {
            return;
        }
        try {
            this.zzGX.e();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call RewardedVideoAdListener.onAdLeftApplication().", e);
        }
    }

    @Override // com.google.android.gms.internal.zzhk
    public void onRewardedVideoAdOpened() {
        zza(this.zzot.j, false);
        if (this.zzGX == null) {
            return;
        }
        try {
            this.zzGX.b();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call RewardedVideoAdListener.onAdOpened().", e);
        }
    }

    @Override // com.google.android.gms.internal.zzhk
    public void onRewardedVideoStarted() {
        com.google.android.gms.ads.internal.zzp.q().zza(this.zzot.c, this.zzot.e.b, this.zzot.j, this.zzot.b, false, this.zzot.j.zzzu.zzyU);
        if (this.zzGX == null) {
            return;
        }
        try {
            this.zzGX.c();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call RewardedVideoAdListener.onVideoStarted().", e);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzs
    public void pause() {
        com.google.android.gms.common.internal.zzx.b("pause must be called on the main UI thread.");
        for (String str : this.zzHa.keySet()) {
            try {
                zzhh zzhhVar = this.zzHa.get(str);
                if (zzhhVar != null && zzhhVar.zzgc() != null) {
                    zzhhVar.zzgc().pause();
                }
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.e("Fail to pause adapter: " + str);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzs
    public void resume() {
        com.google.android.gms.common.internal.zzx.b("resume must be called on the main UI thread.");
        for (String str : this.zzHa.keySet()) {
            try {
                zzhh zzhhVar = this.zzHa.get(str);
                if (zzhhVar != null && zzhhVar.zzgc() != null) {
                    zzhhVar.zzgc().resume();
                }
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.e("Fail to resume adapter: " + str);
            }
        }
    }

    public void setUserId(String str) {
        com.google.android.gms.common.internal.zzx.b("setUserId must be called on the main UI thread.");
        this.zzGY = str;
    }

    public void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel) {
        com.google.android.gms.common.internal.zzx.b("loadAd must be called on the main UI thread.");
        if (TextUtils.isEmpty(rewardedVideoAdRequestParcel.c)) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Invalid ad unit id. Aborting.");
            return;
        }
        this.zzGZ = false;
        this.zzot.b = rewardedVideoAdRequestParcel.c;
        super.zzb(rewardedVideoAdRequestParcel.b);
    }

    public void zza(com.google.android.gms.ads.internal.reward.client.zzd zzdVar) {
        com.google.android.gms.common.internal.zzx.b("setRewardedVideoAdListener must be called on the main UI thread.");
        this.zzGX = zzdVar;
    }

    @Override // com.google.android.gms.internal.zzhk
    public void zza(RewardItemParcel rewardItemParcel) {
        com.google.android.gms.ads.internal.zzp.q().zza(this.zzot.c, this.zzot.e.b, this.zzot.j, this.zzot.b, false, this.zzot.j.zzzu.zzyV);
        if (this.zzGX == null) {
            return;
        }
        try {
            if (this.zzot.j == null || this.zzot.j.zzHx == null || TextUtils.isEmpty(this.zzot.j.zzHx.zzzd)) {
                this.zzGX.a(new zzhe(rewardItemParcel.b, rewardItemParcel.c));
            } else {
                this.zzGX.a(new zzhe(this.zzot.j.zzHx.zzzd, this.zzot.j.zzHx.zzze));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call RewardedVideoAdListener.onRewarded().", e);
        }
    }

    @Override // com.google.android.gms.ads.internal.zza
    public void zza(zzhs.zza zzaVar, zzcg zzcgVar) {
        if (zzaVar.errorCode != -2) {
            zzid.zzIE.post(new df(this, zzaVar));
            return;
        }
        this.zzot.C = 0;
        this.zzot.h = new zzhn(this.zzot.c, this.zzGY, zzaVar, this);
        com.google.android.gms.ads.internal.util.client.zzb.a("AdRenderer: " + this.zzot.h.getClass().getName());
        this.zzot.h.zzfu();
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza
    public boolean zza(zzhs zzhsVar, zzhs zzhsVar2) {
        if (this.zzGX == null) {
            return true;
        }
        try {
            this.zzGX.a();
            return true;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call RewardedVideoAdListener.onAdLoaded().", e);
            return true;
        }
    }

    public zzhh zzau(String str) {
        zzhh zzhhVar = this.zzHa.get(str);
        if (zzhhVar != null) {
            return zzhhVar;
        }
        try {
            zzhh zzhhVar2 = new zzhh(this.zzox.zzae(str), this);
            try {
                this.zzHa.put(str, zzhhVar2);
                return zzhhVar2;
            } catch (Exception e) {
                zzhhVar = zzhhVar2;
                e = e;
                com.google.android.gms.ads.internal.util.client.zzb.d("Fail to instantiate adapter " + str, e);
                return zzhhVar;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public boolean zze(int i) {
        com.google.android.gms.ads.internal.util.client.zzb.e("Failed to load ad: " + i);
        if (this.zzGX == null) {
            return false;
        }
        try {
            this.zzGX.a(i);
            return true;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call RewardedVideoAdListener.onAdFailedToLoad().", e);
            return false;
        }
    }

    public void zzga() {
        com.google.android.gms.common.internal.zzx.b("showAd must be called on the main UI thread.");
        if (!isLoaded()) {
            com.google.android.gms.ads.internal.util.client.zzb.e("The reward video has not loaded.");
            return;
        }
        this.zzGZ = true;
        zzhh zzau = zzau(this.zzot.j.zzzw);
        if (zzau == null || zzau.zzgc() == null) {
            return;
        }
        try {
            zzau.zzgc().showVideo();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not call showVideo.", e);
        }
    }

    @Override // com.google.android.gms.internal.zzhk
    public void zzgb() {
        onAdClicked();
    }
}
