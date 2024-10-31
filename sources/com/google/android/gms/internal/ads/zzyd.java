package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public abstract class zzyd extends zzex implements zzyc {
    public zzyd() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzex
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zza();
                parcel2.writeNoException();
                return true;
            case 2:
                setAppVolume(parcel.readFloat());
                parcel2.writeNoException();
                return true;
            case 3:
                zzat(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 4:
                setAppMuted(zzey.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 5:
                zzb(IObjectWrapper.Stub.a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                zza(parcel.readString(), IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                float zzkj = zzkj();
                parcel2.writeNoException();
                parcel2.writeFloat(zzkj);
                return true;
            case 8:
                boolean zzkk = zzkk();
                parcel2.writeNoException();
                zzey.writeBoolean(parcel2, zzkk);
                return true;
            case 9:
                String zzkl = zzkl();
                parcel2.writeNoException();
                parcel2.writeString(zzkl);
                return true;
            case 10:
                zzau(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                zza(zzalh.zzu(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
