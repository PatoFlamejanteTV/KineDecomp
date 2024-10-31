package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public abstract class zzalk extends zzex implements zzalj {
    public zzalk() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzex
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzalm zzalmVar = null;
        switch (i) {
            case 1:
                IObjectWrapper a2 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                zzwf zzwfVar = (zzwf) zzey.zza(parcel, zzwf.CREATOR);
                zzwb zzwbVar = (zzwb) zzey.zza(parcel, zzwb.CREATOR);
                String readString = parcel.readString();
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface instanceof zzalm) {
                        zzalmVar = (zzalm) queryLocalInterface;
                    } else {
                        zzalmVar = new zzalo(readStrongBinder);
                    }
                }
                zza(a2, zzwfVar, zzwbVar, readString, zzalmVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IObjectWrapper zzut = zzut();
                parcel2.writeNoException();
                zzey.zza(parcel2, zzut);
                return true;
            case 3:
                IObjectWrapper a3 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                zzwb zzwbVar2 = (zzwb) zzey.zza(parcel, zzwb.CREATOR);
                String readString2 = parcel.readString();
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface2 instanceof zzalm) {
                        zzalmVar = (zzalm) queryLocalInterface2;
                    } else {
                        zzalmVar = new zzalo(readStrongBinder2);
                    }
                }
                zza(a3, zzwbVar2, readString2, zzalmVar);
                parcel2.writeNoException();
                return true;
            case 4:
                showInterstitial();
                parcel2.writeNoException();
                return true;
            case 5:
                destroy();
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper a4 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                zzwf zzwfVar2 = (zzwf) zzey.zza(parcel, zzwf.CREATOR);
                zzwb zzwbVar3 = (zzwb) zzey.zza(parcel, zzwb.CREATOR);
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface3 instanceof zzalm) {
                        zzalmVar = (zzalm) queryLocalInterface3;
                    } else {
                        zzalmVar = new zzalo(readStrongBinder3);
                    }
                }
                zza(a4, zzwfVar2, zzwbVar3, readString3, readString4, zzalmVar);
                parcel2.writeNoException();
                return true;
            case 7:
                IObjectWrapper a5 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                zzwb zzwbVar4 = (zzwb) zzey.zza(parcel, zzwb.CREATOR);
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface4 instanceof zzalm) {
                        zzalmVar = (zzalm) queryLocalInterface4;
                    } else {
                        zzalmVar = new zzalo(readStrongBinder4);
                    }
                }
                zza(a5, zzwbVar4, readString5, readString6, zzalmVar);
                parcel2.writeNoException();
                return true;
            case 8:
                pause();
                parcel2.writeNoException();
                return true;
            case 9:
                resume();
                parcel2.writeNoException();
                return true;
            case 10:
                zza(IObjectWrapper.Stub.a(parcel.readStrongBinder()), (zzwb) zzey.zza(parcel, zzwb.CREATOR), parcel.readString(), zzawa.zzad(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                zzc((zzwb) zzey.zza(parcel, zzwb.CREATOR), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 12:
                showVideo();
                parcel2.writeNoException();
                return true;
            case 13:
                boolean isInitialized = isInitialized();
                parcel2.writeNoException();
                zzey.writeBoolean(parcel2, isInitialized);
                return true;
            case 14:
                IObjectWrapper a6 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                zzwb zzwbVar5 = (zzwb) zzey.zza(parcel, zzwb.CREATOR);
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface5 instanceof zzalm) {
                        zzalmVar = (zzalm) queryLocalInterface5;
                    } else {
                        zzalmVar = new zzalo(readStrongBinder5);
                    }
                }
                zza(a6, zzwbVar5, readString7, readString8, zzalmVar, (zzacp) zzey.zza(parcel, zzacp.CREATOR), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 15:
                zzals zzuu = zzuu();
                parcel2.writeNoException();
                zzey.zza(parcel2, zzuu);
                return true;
            case 16:
                zzalv zzuv = zzuv();
                parcel2.writeNoException();
                zzey.zza(parcel2, zzuv);
                return true;
            case 17:
                Bundle zzuw = zzuw();
                parcel2.writeNoException();
                zzey.zzb(parcel2, zzuw);
                return true;
            case 18:
                Bundle interstitialAdapterInfo = getInterstitialAdapterInfo();
                parcel2.writeNoException();
                zzey.zzb(parcel2, interstitialAdapterInfo);
                return true;
            case 19:
                Bundle zzux = zzux();
                parcel2.writeNoException();
                zzey.zzb(parcel2, zzux);
                return true;
            case 20:
                zza((zzwb) zzey.zza(parcel, zzwb.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 21:
                zzj(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 22:
                boolean zzuy = zzuy();
                parcel2.writeNoException();
                zzey.writeBoolean(parcel2, zzuy);
                return true;
            case 23:
                zza(IObjectWrapper.Stub.a(parcel.readStrongBinder()), zzawa.zzad(parcel.readStrongBinder()), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 24:
                zzadx zzuz = zzuz();
                parcel2.writeNoException();
                zzey.zza(parcel2, zzuz);
                return true;
            case 25:
                setImmersiveMode(zzey.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 26:
                zzyp videoController = getVideoController();
                parcel2.writeNoException();
                zzey.zza(parcel2, videoController);
                return true;
            case 27:
                zzaly zzva = zzva();
                parcel2.writeNoException();
                zzey.zza(parcel2, zzva);
                return true;
            default:
                return false;
        }
    }
}
