package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.internal.zzcm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzgr
/* loaded from: classes.dex */
public class zzct extends NativeContentAd {
    private final List<NativeAd.Image> zzxe = new ArrayList();
    private final zzcs zzxg;
    private final zzcn zzxh;

    public zzct(zzcs zzcsVar) {
        zzcn zzcnVar;
        zzcm zzdA;
        this.zzxg = zzcsVar;
        try {
            Iterator it = this.zzxg.getImages().iterator();
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
            zzdA = this.zzxg.zzdA();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to get icon.", e2);
        }
        if (zzdA != null) {
            zzcnVar = new zzcn(zzdA);
            this.zzxh = zzcnVar;
        }
        zzcnVar = null;
        this.zzxh = zzcnVar;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public CharSequence getAdvertiser() {
        try {
            return this.zzxg.getAdvertiser();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to get attribution.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public CharSequence getBody() {
        try {
            return this.zzxg.getBody();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to get body.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public CharSequence getCallToAction() {
        try {
            return this.zzxg.getCallToAction();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to get call to action.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public Bundle getExtras() {
        try {
            return this.zzxg.getExtras();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Failed to get extras", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public CharSequence getHeadline() {
        try {
            return this.zzxg.getHeadline();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to get headline.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public List<NativeAd.Image> getImages() {
        return this.zzxe;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public NativeAd.Image getLogo() {
        return this.zzxh;
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
            return this.zzxg.zzdx();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to retrieve native ad engine.", e);
            return null;
        }
    }
}
