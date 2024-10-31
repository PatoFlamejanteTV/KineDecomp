package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.CapabilityParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzdm;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzfp;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzht;
import com.google.android.gms.internal.zzid;
import java.util.ArrayList;
import java.util.UUID;

@zzgr
/* loaded from: classes.dex */
public abstract class zzb extends zza implements com.google.android.gms.ads.internal.overlay.zzg, com.google.android.gms.ads.internal.purchase.zzj, zzdm, zzef {
    private final Messenger mMessenger;
    protected final zzem zzox;
    protected transient boolean zzoy;

    public zzb(Context context, AdSizeParcel adSizeParcel, String str, zzem zzemVar, VersionInfoParcel versionInfoParcel, zzd zzdVar) {
        this(new zzq(context, adSizeParcel, str, versionInfoParcel), zzemVar, null, zzdVar);
    }

    zzb(zzq zzqVar, zzem zzemVar, zzo zzoVar, zzd zzdVar) {
        super(zzqVar, zzoVar, zzdVar);
        this.zzox = zzemVar;
        this.mMessenger = new Messenger(new zzfp(this.zzot.c));
        this.zzoy = false;
    }

    private AdRequestInfoParcel.zza zza(AdRequestParcel adRequestParcel, Bundle bundle) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo = this.zzot.c.getApplicationInfo();
        try {
            packageInfo = this.zzot.c.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        DisplayMetrics displayMetrics = this.zzot.c.getResources().getDisplayMetrics();
        Bundle bundle2 = null;
        if (this.zzot.f != null && this.zzot.f.getParent() != null) {
            int[] iArr = new int[2];
            this.zzot.f.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int width = this.zzot.f.getWidth();
            int height = this.zzot.f.getHeight();
            int i3 = 0;
            if (this.zzot.f.isShown() && i + width > 0 && i2 + height > 0 && i <= displayMetrics.widthPixels && i2 <= displayMetrics.heightPixels) {
                i3 = 1;
            }
            bundle2 = new Bundle(5);
            bundle2.putInt("x", i);
            bundle2.putInt("y", i2);
            bundle2.putInt("width", width);
            bundle2.putInt("height", height);
            bundle2.putInt("visible", i3);
        }
        String zzgm = zzp.h().zzgm();
        this.zzot.l = new zzht(zzgm, this.zzot.b);
        this.zzot.l.zzi(adRequestParcel);
        String zza = zzp.e().zza(this.zzot.c, this.zzot.f, this.zzot.i);
        long j = 0;
        if (this.zzot.p != null) {
            try {
                j = this.zzot.p.b();
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.client.zzb.e("Cannot get correlation id, default to 0.");
            }
        }
        String uuid = UUID.randomUUID().toString();
        Bundle zza2 = zzp.h().zza(this.zzot.c, this, zzgm);
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.zzot.v.size(); i4++) {
            arrayList.add(this.zzot.v.keyAt(i4));
        }
        return new AdRequestInfoParcel.zza(bundle2, adRequestParcel, this.zzot.i, this.zzot.b, applicationInfo, packageInfo, zzgm, zzp.h().getSessionId(), this.zzot.e, zza2, this.zzot.y, arrayList, bundle, zzp.h().zzgq(), this.mMessenger, displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.density, zza, j, uuid, zzby.zzdf(), this.zzot.f668a, this.zzot.w, new CapabilityParcel(this.zzot.q != null, this.zzot.r != null && zzp.h().zzgv()), this.zzot.h());
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public String getMediationAdapterClassName() {
        if (this.zzot.j == null) {
            return null;
        }
        return this.zzot.j.zzzw;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zza
    public void onAdClicked() {
        if (this.zzot.j == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (this.zzot.j.zzHx != null && this.zzot.j.zzHx.zzyY != null) {
            zzp.q().zza(this.zzot.c, this.zzot.e.b, this.zzot.j, this.zzot.b, false, this.zzot.j.zzHx.zzyY);
        }
        if (this.zzot.j.zzzu != null && this.zzot.j.zzzu.zzyR != null) {
            zzp.q().zza(this.zzot.c, this.zzot.e.b, this.zzot.j, this.zzot.b, false, this.zzot.j.zzzu.zzyR);
        }
        super.onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzs
    public void pause() {
        zzx.b("pause must be called on the main UI thread.");
        if (this.zzot.j != null && this.zzot.j.zzBD != null && this.zzot.e()) {
            zzp.g().zza(this.zzot.j.zzBD.getWebView());
        }
        if (this.zzot.j != null && this.zzot.j.zzzv != null) {
            try {
                this.zzot.j.zzzv.pause();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.e("Could not pause mediation adapter.");
            }
        }
        this.zzov.zzg(this.zzot.j);
        this.zzos.b();
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzs
    public void resume() {
        zzx.b("resume must be called on the main UI thread.");
        if (this.zzot.j != null && this.zzot.j.zzBD != null && this.zzot.e()) {
            zzp.g().zzb(this.zzot.j.zzBD.getWebView());
        }
        if (this.zzot.j != null && this.zzot.j.zzzv != null) {
            try {
                this.zzot.j.zzzv.resume();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.e("Could not resume mediation adapter.");
            }
        }
        this.zzos.c();
        this.zzov.zzh(this.zzot.j);
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void showInterstitial() {
        throw new IllegalStateException("showInterstitial is not supported for current ad type");
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzs
    public void zza(zzfs zzfsVar) {
        zzx.b("setInAppPurchaseListener must be called on the main UI thread.");
        this.zzot.q = zzfsVar;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzs
    public void zza(zzfw zzfwVar, String str) {
        zzx.b("setPlayStorePurchaseParams must be called on the main UI thread.");
        this.zzot.z = new com.google.android.gms.ads.internal.purchase.zzk(str);
        this.zzot.r = zzfwVar;
        if (zzp.h().zzgp() || zzfwVar == null) {
            return;
        }
        new com.google.android.gms.ads.internal.purchase.zzc(this.zzot.c, this.zzot.r, this.zzot.z).zzfu();
    }

    public void zza(zzhs zzhsVar, boolean z) {
        if (zzhsVar == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Ad state was null when trying to ping impression URLs.");
            return;
        }
        super.zzc(zzhsVar);
        if (zzhsVar.zzHx != null && zzhsVar.zzHx.zzyZ != null) {
            zzp.q().zza(this.zzot.c, this.zzot.e.b, zzhsVar, this.zzot.b, z, zzhsVar.zzHx.zzyZ);
        }
        if (zzhsVar.zzzu == null || zzhsVar.zzzu.zzyS == null) {
            return;
        }
        zzp.q().zza(this.zzot.c, this.zzot.e.b, zzhsVar, this.zzot.b, z, zzhsVar.zzzu.zzyS);
    }

    @Override // com.google.android.gms.internal.zzdm
    public void zza(String str, ArrayList<String> arrayList) {
        com.google.android.gms.ads.internal.purchase.zzd zzdVar = new com.google.android.gms.ads.internal.purchase.zzd(str, arrayList, this.zzot.c, this.zzot.e.b);
        if (this.zzot.q != null) {
            try {
                this.zzot.q.zza(zzdVar);
                return;
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.e("Could not start In-App purchase.");
                return;
            }
        }
        com.google.android.gms.ads.internal.util.client.zzb.e("InAppPurchaseListener is not set. Try to launch default purchase flow.");
        if (!com.google.android.gms.ads.internal.client.zzl.a().b(this.zzot.c)) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Google Play Service unavailable, cannot launch default purchase flow.");
            return;
        }
        if (this.zzot.r == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("PlayStorePurchaseListener is not set.");
            return;
        }
        if (this.zzot.z == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("PlayStorePurchaseVerifier is not initialized.");
            return;
        }
        if (this.zzot.D) {
            com.google.android.gms.ads.internal.util.client.zzb.e("An in-app purchase request is already in progress, abort");
            return;
        }
        this.zzot.D = true;
        try {
            if (this.zzot.r.isValidPurchase(str)) {
                zzp.o().a(this.zzot.c, this.zzot.e.e, new GInAppPurchaseManagerInfoParcel(this.zzot.c, this.zzot.z, zzdVar, this));
            } else {
                this.zzot.D = false;
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Could not start In-App purchase.");
            this.zzot.D = false;
        }
    }

    @Override // com.google.android.gms.ads.internal.purchase.zzj
    public void zza(String str, boolean z, int i, Intent intent, com.google.android.gms.ads.internal.purchase.zzf zzfVar) {
        try {
            if (this.zzot.r != null) {
                this.zzot.r.zza(new com.google.android.gms.ads.internal.purchase.zzg(this.zzot.c, str, z, i, intent, zzfVar));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Fail to invoke PlayStorePurchaseListener.");
        }
        zzid.zzIE.postDelayed(new a(this, intent), 500L);
    }

    @Override // com.google.android.gms.ads.internal.zza
    public boolean zza(AdRequestParcel adRequestParcel, zzcg zzcgVar) {
        if (!zzaU()) {
            return false;
        }
        Bundle zza = zza(zzp.h().zzE(this.zzot.c));
        this.zzos.a();
        this.zzot.C = 0;
        AdRequestInfoParcel.zza zza2 = zza(adRequestParcel, zza);
        zzcgVar.zze("seq_num", zza2.g);
        zzcgVar.zze("request_id", zza2.v);
        zzcgVar.zze("session_id", zza2.h);
        if (zza2.f != null) {
            zzcgVar.zze("app_version", String.valueOf(zza2.f.versionCode));
        }
        this.zzot.g = zzp.a().a(this.zzot.c, zza2, this.zzot.d, this);
        return true;
    }

    protected boolean zza(AdRequestParcel adRequestParcel, zzhs zzhsVar, boolean z) {
        if (!z && this.zzot.e()) {
            if (zzhsVar.zzzc > 0) {
                this.zzos.a(adRequestParcel, zzhsVar.zzzc);
            } else if (zzhsVar.zzHx != null && zzhsVar.zzHx.zzzc > 0) {
                this.zzos.a(adRequestParcel, zzhsVar.zzHx.zzzc);
            } else if (!zzhsVar.zzEK && zzhsVar.errorCode == 2) {
                this.zzos.a(adRequestParcel);
            }
        }
        return this.zzos.d();
    }

    @Override // com.google.android.gms.ads.internal.zza
    boolean zza(zzhs zzhsVar) {
        AdRequestParcel adRequestParcel;
        boolean z = false;
        if (this.zzou != null) {
            adRequestParcel = this.zzou;
            this.zzou = null;
        } else {
            adRequestParcel = zzhsVar.zzEn;
            if (adRequestParcel.c != null) {
                z = adRequestParcel.c.getBoolean("_noRefresh", false);
            }
        }
        return zza(adRequestParcel, zzhsVar, z);
    }

    @Override // com.google.android.gms.ads.internal.zza
    public boolean zza(zzhs zzhsVar, zzhs zzhsVar2) {
        int i;
        int i2 = 0;
        if (zzhsVar != null && zzhsVar.zzzx != null) {
            zzhsVar.zzzx.zza((zzef) null);
        }
        if (zzhsVar2.zzzx != null) {
            zzhsVar2.zzzx.zza(this);
        }
        if (zzhsVar2.zzHx != null) {
            i = zzhsVar2.zzHx.zzzf;
            i2 = zzhsVar2.zzHx.zzzg;
        } else {
            i = 0;
        }
        this.zzot.A.zzf(i, i2);
        return true;
    }

    protected boolean zzaU() {
        return zzp.e().zza(this.zzot.c.getPackageManager(), this.zzot.c.getPackageName(), "android.permission.INTERNET") && zzp.e().zzH(this.zzot.c);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzg
    public void zzaV() {
        this.zzov.zze(this.zzot.j);
        this.zzoy = false;
        zzaQ();
        this.zzot.l.zzgh();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzg
    public void zzaW() {
        this.zzoy = true;
        zzaS();
    }

    @Override // com.google.android.gms.internal.zzef
    public void zzaX() {
        onAdClicked();
    }

    @Override // com.google.android.gms.internal.zzef
    public void zzaY() {
        zzaV();
    }

    @Override // com.google.android.gms.internal.zzef
    public void zzaZ() {
        zzaO();
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzgg.zza
    public void zzb(zzhs zzhsVar) {
        super.zzb(zzhsVar);
        if (zzhsVar.errorCode != 3 || zzhsVar.zzHx == null || zzhsVar.zzHx.zzza == null) {
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzb.a("Pinging no fill URLs.");
        zzp.q().zza(this.zzot.c, this.zzot.e.b, zzhsVar, this.zzot.b, false, zzhsVar.zzHx.zzza);
    }

    @Override // com.google.android.gms.internal.zzef
    public void zzba() {
        zzaW();
    }

    @Override // com.google.android.gms.internal.zzef
    public void zzbb() {
        if (this.zzot.j != null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Mediation adapter " + this.zzot.j.zzzw + " refreshed, but mediation adapters should never refresh.");
        }
        zza(this.zzot.j, true);
        zzaT();
    }

    @Override // com.google.android.gms.ads.internal.zza
    public boolean zzc(AdRequestParcel adRequestParcel) {
        return super.zzc(adRequestParcel) && !this.zzoy;
    }
}
