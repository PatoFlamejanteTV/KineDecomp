package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import java.lang.ref.WeakReference;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzabn implements View.OnClickListener {
    private final zzaqp zzbqa;
    private zzaet zzdai;
    private com.google.android.gms.ads.internal.gmsg.zzu zzdaj;
    String zzdak;
    Long zzdal;
    WeakReference<View> zzdam;

    public zzabn(zzaqp zzaqpVar) {
        this.zzbqa = zzaqpVar;
    }

    private final void zzru() {
        this.zzdak = null;
        this.zzdal = null;
        WeakReference<View> weakReference = this.zzdam;
        if (weakReference == null) {
            return;
        }
        View view = weakReference.get();
        this.zzdam = null;
        if (view == null) {
            return;
        }
        view.setClickable(false);
        view.setOnClickListener(null);
    }

    public final void cancelUnconfirmedClick() {
        if (this.zzdai == null || this.zzdal == null) {
            return;
        }
        zzru();
        try {
            this.zzdai.onUnconfirmedClickCancelled();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WeakReference<View> weakReference = this.zzdam;
        if (weakReference == null || weakReference.get() != view) {
            return;
        }
        if (this.zzdak != null && this.zzdal != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.zzdak);
                jSONObject.put("time_interval", com.google.android.gms.ads.internal.zzbv.l().a() - this.zzdal.longValue());
                jSONObject.put("messageType", "onePointFiveClick");
                this.zzbqa.zza("sendMessageToNativeJs", jSONObject);
            } catch (JSONException e2) {
                zzbbd.zzb("Unable to dispatch sendMessageToNativeJs event", e2);
            }
        }
        zzru();
    }

    public final void zza(zzaet zzaetVar) {
        this.zzdai = zzaetVar;
        com.google.android.gms.ads.internal.gmsg.zzu zzuVar = this.zzdaj;
        if (zzuVar != null) {
            this.zzbqa.zzb("/unconfirmedClick", zzuVar);
        }
        this.zzdaj = new C0992m(this);
        this.zzbqa.zza("/unconfirmedClick", this.zzdaj);
    }

    public final zzaet zzrt() {
        return this.zzdai;
    }
}
