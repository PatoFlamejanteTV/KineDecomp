package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public abstract class zzyq extends zzex implements zzyp {
    public zzyq() {
        super("com.google.android.gms.ads.internal.client.IVideoController");
    }

    public static zzyp zzg(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        if (queryLocalInterface instanceof zzyp) {
            return (zzyp) queryLocalInterface;
        }
        return new zzyr(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzex
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzys zzyuVar;
        switch (i) {
            case 1:
                play();
                parcel2.writeNoException();
                return true;
            case 2:
                pause();
                parcel2.writeNoException();
                return true;
            case 3:
                mute(zzey.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 4:
                boolean isMuted = isMuted();
                parcel2.writeNoException();
                zzey.writeBoolean(parcel2, isMuted);
                return true;
            case 5:
                int playbackState = getPlaybackState();
                parcel2.writeNoException();
                parcel2.writeInt(playbackState);
                return true;
            case 6:
                float zzqf = zzqf();
                parcel2.writeNoException();
                parcel2.writeFloat(zzqf);
                return true;
            case 7:
                float zzqg = zzqg();
                parcel2.writeNoException();
                parcel2.writeFloat(zzqg);
                return true;
            case 8:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzyuVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
                    if (queryLocalInterface instanceof zzys) {
                        zzyuVar = (zzys) queryLocalInterface;
                    } else {
                        zzyuVar = new zzyu(readStrongBinder);
                    }
                }
                zza(zzyuVar);
                parcel2.writeNoException();
                return true;
            case 9:
                float aspectRatio = getAspectRatio();
                parcel2.writeNoException();
                parcel2.writeFloat(aspectRatio);
                return true;
            case 10:
                boolean isCustomControlsEnabled = isCustomControlsEnabled();
                parcel2.writeNoException();
                zzey.writeBoolean(parcel2, isCustomControlsEnabled);
                return true;
            case 11:
                zzys zzqh = zzqh();
                parcel2.writeNoException();
                zzey.zza(parcel2, zzqh);
                return true;
            case 12:
                boolean isClickToExpandEnabled = isClickToExpandEnabled();
                parcel2.writeNoException();
                zzey.writeBoolean(parcel2, isClickToExpandEnabled);
                return true;
            default:
                return false;
        }
    }
}
