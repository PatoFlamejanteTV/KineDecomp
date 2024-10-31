package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;

@zzark
/* loaded from: classes2.dex */
public final class zzada extends NativeAd.AdChoicesInfo {
    private final List<NativeAd.Image> zzdab = new ArrayList();
    private final zzacx zzddp;
    private String zzddq;

    public zzada(zzacx zzacxVar) {
        zzadb zzadbVar;
        IBinder iBinder;
        this.zzddp = zzacxVar;
        try {
            this.zzddq = this.zzddp.getText();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            this.zzddq = "";
        }
        try {
            for (zzadb zzadbVar2 : zzacxVar.zzro()) {
                if (!(zzadbVar2 instanceof IBinder) || (iBinder = (IBinder) zzadbVar2) == null) {
                    zzadbVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    if (queryLocalInterface instanceof zzadb) {
                        zzadbVar = (zzadb) queryLocalInterface;
                    } else {
                        zzadbVar = new zzadd(iBinder);
                    }
                }
                if (zzadbVar != null) {
                    this.zzdab.add(new zzade(zzadbVar));
                }
            }
        } catch (RemoteException e3) {
            zzbbd.zzb("", e3);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final List<NativeAd.Image> getImages() {
        return this.zzdab;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final CharSequence getText() {
        return this.zzddq;
    }
}
