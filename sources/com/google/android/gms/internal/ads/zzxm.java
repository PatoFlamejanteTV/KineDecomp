package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public abstract class zzxm extends zzex implements zzxl {
    public zzxm() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzxl zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        if (queryLocalInterface instanceof zzxl) {
            return (zzxl) queryLocalInterface;
        }
        return new zzxn(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzex
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzxa zzxaVar = null;
        zzxq zzxqVar = null;
        zzxz zzxzVar = null;
        zzwx zzwxVar = null;
        zzxt zzxtVar = null;
        switch (i) {
            case 1:
                IObjectWrapper zzie = zzie();
                parcel2.writeNoException();
                zzey.zza(parcel2, zzie);
                return true;
            case 2:
                destroy();
                parcel2.writeNoException();
                return true;
            case 3:
                boolean isReady = isReady();
                parcel2.writeNoException();
                zzey.writeBoolean(parcel2, isReady);
                return true;
            case 4:
                boolean zzb = zzb((zzwb) zzey.zza(parcel, zzwb.CREATOR));
                parcel2.writeNoException();
                zzey.writeBoolean(parcel2, zzb);
                return true;
            case 5:
                pause();
                parcel2.writeNoException();
                return true;
            case 6:
                resume();
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    if (queryLocalInterface instanceof zzxa) {
                        zzxaVar = (zzxa) queryLocalInterface;
                    } else {
                        zzxaVar = new zzxc(readStrongBinder);
                    }
                }
                zza(zzxaVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    if (queryLocalInterface2 instanceof zzxt) {
                        zzxtVar = (zzxt) queryLocalInterface2;
                    } else {
                        zzxtVar = new zzxv(readStrongBinder2);
                    }
                }
                zza(zzxtVar);
                parcel2.writeNoException();
                return true;
            case 9:
                showInterstitial();
                parcel2.writeNoException();
                return true;
            case 10:
                stopLoading();
                parcel2.writeNoException();
                return true;
            case 11:
                zzih();
                parcel2.writeNoException();
                return true;
            case 12:
                zzwf zzif = zzif();
                parcel2.writeNoException();
                zzey.zzb(parcel2, zzif);
                return true;
            case 13:
                zza((zzwf) zzey.zza(parcel, zzwf.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                zza(zzaox.zzy(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                zza(zzapd.zzaa(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 16:
            case 17:
            case 27:
            case 28:
            default:
                return false;
            case 18:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 19:
                zza(zzabh.zzh(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 20:
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    if (queryLocalInterface3 instanceof zzwx) {
                        zzwxVar = (zzwx) queryLocalInterface3;
                    } else {
                        zzwxVar = new zzwz(readStrongBinder3);
                    }
                }
                zza(zzwxVar);
                parcel2.writeNoException();
                return true;
            case 21:
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    if (queryLocalInterface4 instanceof zzxz) {
                        zzxzVar = (zzxz) queryLocalInterface4;
                    } else {
                        zzxzVar = new zzyb(readStrongBinder4);
                    }
                }
                zza(zzxzVar);
                parcel2.writeNoException();
                return true;
            case 22:
                setManualImpressionsEnabled(zzey.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 23:
                boolean isLoading = isLoading();
                parcel2.writeNoException();
                zzey.writeBoolean(parcel2, isLoading);
                return true;
            case 24:
                zza(zzavc.zzac(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 25:
                setUserId(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 26:
                zzyp videoController = getVideoController();
                parcel2.writeNoException();
                zzey.zza(parcel2, videoController);
                return true;
            case 29:
                zza((zzzw) zzey.zza(parcel, zzzw.CREATOR));
                parcel2.writeNoException();
                return true;
            case 30:
                zza((zzyv) zzey.zza(parcel, zzyv.CREATOR));
                parcel2.writeNoException();
                return true;
            case 31:
                String adUnitId = getAdUnitId();
                parcel2.writeNoException();
                parcel2.writeString(adUnitId);
                return true;
            case 32:
                zzxt zzir = zzir();
                parcel2.writeNoException();
                zzey.zza(parcel2, zzir);
                return true;
            case 33:
                zzxa zzis = zzis();
                parcel2.writeNoException();
                zzey.zza(parcel2, zzis);
                return true;
            case 34:
                setImmersiveMode(zzey.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 35:
                String zzje = zzje();
                parcel2.writeNoException();
                parcel2.writeString(zzje);
                return true;
            case 36:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
                    if (queryLocalInterface5 instanceof zzxq) {
                        zzxqVar = (zzxq) queryLocalInterface5;
                    } else {
                        zzxqVar = new zzxs(readStrongBinder5);
                    }
                }
                zza(zzxqVar);
                parcel2.writeNoException();
                return true;
            case 37:
                Bundle adMetadata = getAdMetadata();
                parcel2.writeNoException();
                zzey.zzb(parcel2, adMetadata);
                return true;
            case 38:
                zzap(parcel.readString());
                parcel2.writeNoException();
                return true;
        }
    }
}
