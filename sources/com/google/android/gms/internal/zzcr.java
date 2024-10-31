package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.internal.zzcm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzgr
/* loaded from: classes.dex */
public class zzcr extends NativeAppInstallAd {
    private final zzcq zzxd;
    private final List<NativeAd.Image> zzxe = new ArrayList();
    private final zzcn zzxf;

    public zzcr(zzcq zzcqVar) {
        zzcn zzcnVar;
        zzcm zzdw;
        this.zzxd = zzcqVar;
        try {
            Iterator it = this.zzxd.getImages().iterator();
            while (it.hasNext()) {
                zzcm zzd = zzd(it.next());
                if (zzd != null) {
                    this.zzxe.add(new zzcn(zzd));
                }
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to get image.", e);
        }
        try {
            zzdw = this.zzxd.zzdw();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to get icon.", e2);
        }
        if (zzdw != null) {
            zzcnVar = new zzcn(zzdw);
            this.zzxf = zzcnVar;
        }
        zzcnVar = null;
        this.zzxf = zzcnVar;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public CharSequence getBody() {
        try {
            return this.zzxd.getBody();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to get body.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public CharSequence getCallToAction() {
        try {
            return this.zzxd.getCallToAction();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to get call to action.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public Bundle getExtras() {
        try {
            return this.zzxd.getExtras();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to get extras", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public CharSequence getHeadline() {
        try {
            return this.zzxd.getHeadline();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to get headline.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public NativeAd.Image getIcon() {
        return this.zzxf;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public List<NativeAd.Image> getImages() {
        return this.zzxe;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public CharSequence getPrice() {
        try {
            return this.zzxd.getPrice();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to get price.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public Double getStarRating() {
        try {
            double starRating = this.zzxd.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to get star rating.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public CharSequence getStore() {
        try {
            return this.zzxd.getStore();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to get store", e);
            return null;
        }
    }

    zzcm zzd(Object obj) {
        if (obj instanceof IBinder) {
            return zzcm.zza.zzt((IBinder) obj);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.formats.NativeAd
    /* renamed from: zzdx, reason: merged with bridge method [inline-methods] */
    public com.google.android.gms.dynamic.zzd zzaH() {
        try {
            return this.zzxd.zzdx();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to retrieve native ad engine.", e);
            return null;
        }
    }
}
