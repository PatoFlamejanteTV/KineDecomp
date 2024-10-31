package com.google.android.gms.internal;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;

@zzgr
/* loaded from: classes.dex */
public class zzci implements CustomRenderedAd {
    private final zzcj zzvZ;

    public zzci(zzcj zzcjVar) {
        this.zzvZ = zzcjVar;
    }

    public String getBaseUrl() {
        try {
            return this.zzvZ.zzdr();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not delegate getBaseURL to CustomRenderedAd", e);
            return null;
        }
    }

    public String getContent() {
        try {
            return this.zzvZ.getContent();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not delegate getContent to CustomRenderedAd", e);
            return null;
        }
    }

    public void onAdRendered(View view) {
        try {
            this.zzvZ.zza(view != null ? com.google.android.gms.dynamic.zze.a(view) : null);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not delegate onAdRendered to CustomRenderedAd", e);
        }
    }

    public void recordClick() {
        try {
            this.zzvZ.recordClick();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not delegate recordClick to CustomRenderedAd", e);
        }
    }

    public void recordImpression() {
        try {
            this.zzvZ.recordImpression();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not delegate recordImpression to CustomRenderedAd", e);
        }
    }
}
