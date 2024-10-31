package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzbb;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public class zzbd implements zzbb {
    private final zziz zzoM;

    public zzbd(Context context, VersionInfoParcel versionInfoParcel, zzan zzanVar) {
        this.zzoM = com.google.android.gms.ads.internal.zzp.f().zza(context, new AdSizeParcel(), false, false, zzanVar, versionInfoParcel);
        this.zzoM.getWebView().setWillNotDraw(true);
    }

    private void runOnUiThread(Runnable runnable) {
        if (com.google.android.gms.ads.internal.client.zzl.a().b()) {
            runnable.run();
        } else {
            zzid.zzIE.post(runnable);
        }
    }

    @Override // com.google.android.gms.internal.zzbb
    public void destroy() {
        this.zzoM.destroy();
    }

    @Override // com.google.android.gms.internal.zzbb
    public void zza(com.google.android.gms.ads.internal.client.zza zzaVar, com.google.android.gms.ads.internal.overlay.zzg zzgVar, zzdg zzdgVar, com.google.android.gms.ads.internal.overlay.zzn zznVar, boolean z, zzdm zzdmVar, zzdo zzdoVar, com.google.android.gms.ads.internal.zze zzeVar, zzfi zzfiVar) {
        this.zzoM.zzhe().zzb(zzaVar, zzgVar, zzdgVar, zznVar, z, zzdmVar, zzdoVar, new com.google.android.gms.ads.internal.zze(false), zzfiVar);
    }

    @Override // com.google.android.gms.internal.zzbb
    public void zza(zzbb.zza zzaVar) {
        this.zzoM.zzhe().zza(new u(this, zzaVar));
    }

    @Override // com.google.android.gms.internal.zzbe
    public void zza(String str, zzdk zzdkVar) {
        this.zzoM.zzhe().zza(str, zzdkVar);
    }

    @Override // com.google.android.gms.internal.zzbe
    public void zza(String str, String str2) {
        runOnUiThread(new q(this, str, str2));
    }

    @Override // com.google.android.gms.internal.zzbe
    public void zza(String str, JSONObject jSONObject) {
        runOnUiThread(new p(this, str, jSONObject));
    }

    @Override // com.google.android.gms.internal.zzbe
    public void zzb(String str, zzdk zzdkVar) {
        this.zzoM.zzhe().zzb(str, zzdkVar);
    }

    @Override // com.google.android.gms.internal.zzbe
    public void zzb(String str, JSONObject jSONObject) {
        this.zzoM.zzb(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.zzbb
    public zzbf zzci() {
        return new zzbg(this);
    }

    @Override // com.google.android.gms.internal.zzbb
    public void zzs(String str) {
        runOnUiThread(new r(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", str)));
    }

    @Override // com.google.android.gms.internal.zzbb
    public void zzt(String str) {
        runOnUiThread(new t(this, str));
    }

    @Override // com.google.android.gms.internal.zzbb
    public void zzu(String str) {
        runOnUiThread(new s(this, str));
    }
}
