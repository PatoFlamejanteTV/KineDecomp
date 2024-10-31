package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

@zzark
/* loaded from: classes2.dex */
public final class zzzg extends RemoteCreator<zzyf> {
    public zzzg() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzyf getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        if (queryLocalInterface instanceof zzyf) {
            return (zzyf) queryLocalInterface;
        }
        return new zzyg(iBinder);
    }

    public final zzyc zzi(Context context) {
        try {
            IBinder zza = getRemoteCreatorInstance(context).zza(ObjectWrapper.a(context), 14300000);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzyc) {
                return (zzyc) queryLocalInterface;
            }
            return new zzye(zza);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbbd.zzc("Could not get remote MobileAdsSettingManager.", e2);
            return null;
        }
    }
}
