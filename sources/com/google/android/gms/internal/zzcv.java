package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import java.util.List;

@zzgr
/* loaded from: classes.dex */
public class zzcv implements NativeCustomTemplateAd {
    private final zzcu zzxi;

    public zzcv(zzcu zzcuVar) {
        this.zzxi = zzcuVar;
    }

    public List<String> getAvailableAssetNames() {
        try {
            return this.zzxi.getAvailableAssetNames();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to get available asset names.", e);
            return null;
        }
    }

    public String getCustomTemplateId() {
        try {
            return this.zzxi.getCustomTemplateId();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to get custom template id.", e);
            return null;
        }
    }

    public NativeAd.Image getImage(String str) {
        try {
            zzcm zzV = this.zzxi.zzV(str);
            if (zzV != null) {
                return new zzcn(zzV);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to get image.", e);
        }
        return null;
    }

    public CharSequence getText(String str) {
        try {
            return this.zzxi.zzU(str);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to get string.", e);
            return null;
        }
    }

    public void performClick(String str) {
        try {
            this.zzxi.performClick(str);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to perform click.", e);
        }
    }

    public void recordImpression() {
        try {
            this.zzxi.recordImpression();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to record impression.", e);
        }
    }
}
