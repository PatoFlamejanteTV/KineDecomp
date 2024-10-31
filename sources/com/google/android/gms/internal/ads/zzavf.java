package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

@zzark
/* loaded from: classes2.dex */
public final class zzavf extends RemoteCreator<zzauz> {
    public zzavf() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzauz getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        if (queryLocalInterface instanceof zzauz) {
            return (zzauz) queryLocalInterface;
        }
        return new zzava(iBinder);
    }

    public final zzauw zza(Context context, zzalg zzalgVar) {
        try {
            IBinder zza = getRemoteCreatorInstance(context).zza(ObjectWrapper.a(context), zzalgVar, 14300000);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
            if (queryLocalInterface instanceof zzauw) {
                return (zzauw) queryLocalInterface;
            }
            return new zzauy(zza);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbbd.zzc("Could not get remote RewardedVideoAd.", e2);
            return null;
        }
    }
}
