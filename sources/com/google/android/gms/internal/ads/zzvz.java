package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

@zzark
/* loaded from: classes2.dex */
public final class zzvz extends RemoteCreator<zzxo> {
    @VisibleForTesting
    public zzvz() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzxo getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (queryLocalInterface instanceof zzxo) {
            return (zzxo) queryLocalInterface;
        }
        return new zzxp(iBinder);
    }

    public final zzxl zza(Context context, zzwf zzwfVar, String str, zzalg zzalgVar, int i) {
        try {
            IBinder zza = getRemoteCreatorInstance(context).zza(ObjectWrapper.a(context), zzwfVar, str, zzalgVar, 14300000, i);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzxl) {
                return (zzxl) queryLocalInterface;
            }
            return new zzxn(zza);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbbd.zza("Could not create remote AdManager.", e2);
            return null;
        }
    }
}
