package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

/* loaded from: classes2.dex */
public abstract class zzxh extends zzex implements zzxg {
    public zzxh() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.zzex
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzxa zzxaVar = null;
        zzxz zzxzVar = null;
        switch (i) {
            case 1:
                zzxd zzkd = zzkd();
                parcel2.writeNoException();
                zzey.zza(parcel2, zzkd);
                return true;
            case 2:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    if (queryLocalInterface instanceof zzxa) {
                        zzxaVar = (zzxa) queryLocalInterface;
                    } else {
                        zzxaVar = new zzxc(readStrongBinder);
                    }
                }
                zzb(zzxaVar);
                parcel2.writeNoException();
                return true;
            case 3:
                zza(zzaec.zzn(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                zza(zzaef.zzo(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 5:
                zza(parcel.readString(), zzael.zzq(parcel.readStrongBinder()), zzaei.zzp(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                zza((zzacp) zzey.zza(parcel, zzacp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    if (queryLocalInterface2 instanceof zzxz) {
                        zzxzVar = (zzxz) queryLocalInterface2;
                    } else {
                        zzxzVar = new zzyb(readStrongBinder2);
                    }
                }
                zzb(zzxzVar);
                parcel2.writeNoException();
                return true;
            case 8:
                zza(zzaeo.zzr(parcel.readStrongBinder()), (zzwf) zzey.zza(parcel, zzwf.CREATOR));
                parcel2.writeNoException();
                return true;
            case 9:
                zza((PublisherAdViewOptions) zzey.zza(parcel, PublisherAdViewOptions.CREATOR));
                parcel2.writeNoException();
                return true;
            case 10:
                zza(zzaer.zzs(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
            case 12:
            default:
                return false;
            case 13:
                zza((zzafz) zzey.zza(parcel, zzafz.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                zza(zzagg.zzt(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
        }
    }
}
