package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

@zzark
/* loaded from: classes2.dex */
public final class zzvy extends RemoteCreator<zzxj> {
    public zzvy() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzxj getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        if (queryLocalInterface instanceof zzxj) {
            return (zzxj) queryLocalInterface;
        }
        return new zzxk(iBinder);
    }

    public final zzxg zza(Context context, String str, zzalg zzalgVar) {
        try {
            IBinder zza = getRemoteCreatorInstance(context).zza(ObjectWrapper.a(context), str, zzalgVar, 14300000);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzxg) {
                return (zzxg) queryLocalInterface;
            }
            return new zzxi(zza);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbbd.zzc("Could not create remote builder for AdLoader.", e2);
            return null;
        }
    }
}
