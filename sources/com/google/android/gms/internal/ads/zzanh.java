package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public abstract class zzanh extends zzex implements zzang {
    public zzanh() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzang zzw(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        if (queryLocalInterface instanceof zzang) {
            return (zzang) queryLocalInterface;
        }
        return new zzani(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzex
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzanj zzanjVar = null;
        zzanc zzandVar = null;
        zzane zzanfVar = null;
        zzana zzanbVar = null;
        zzamy zzamzVar = null;
        switch (i) {
            case 1:
                IObjectWrapper a2 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                String readString = parcel.readString();
                Bundle bundle = (Bundle) zzey.zza(parcel, Bundle.CREATOR);
                Bundle bundle2 = (Bundle) zzey.zza(parcel, Bundle.CREATOR);
                zzwf zzwfVar = (zzwf) zzey.zza(parcel, zzwf.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                    if (queryLocalInterface instanceof zzanj) {
                        zzanjVar = (zzanj) queryLocalInterface;
                    } else {
                        zzanjVar = new zzank(readStrongBinder);
                    }
                }
                zza(a2, readString, bundle, bundle2, zzwfVar, zzanjVar);
                parcel2.writeNoException();
                return true;
            case 2:
                zzans zzvi = zzvi();
                parcel2.writeNoException();
                zzey.zzb(parcel2, zzvi);
                return true;
            case 3:
                zzans zzvj = zzvj();
                parcel2.writeNoException();
                zzey.zzb(parcel2, zzvj);
                return true;
            case 4:
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                Bundle bundle3 = (Bundle) zzey.zza(parcel, Bundle.CREATOR);
                IObjectWrapper a3 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                    if (queryLocalInterface2 instanceof zzamy) {
                        zzamzVar = (zzamy) queryLocalInterface2;
                    } else {
                        zzamzVar = new zzamz(readStrongBinder2);
                    }
                }
                zza(readString2, readString3, bundle3, a3, zzamzVar, zzaln.zzv(parcel.readStrongBinder()), (zzwf) zzey.zza(parcel, zzwf.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                zzyp videoController = getVideoController();
                parcel2.writeNoException();
                zzey.zza(parcel2, videoController);
                return true;
            case 6:
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                Bundle bundle4 = (Bundle) zzey.zza(parcel, Bundle.CREATOR);
                IObjectWrapper a4 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                    if (queryLocalInterface3 instanceof zzana) {
                        zzanbVar = (zzana) queryLocalInterface3;
                    } else {
                        zzanbVar = new zzanb(readStrongBinder3);
                    }
                }
                zza(readString4, readString5, bundle4, a4, zzanbVar, zzaln.zzv(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                showInterstitial();
                parcel2.writeNoException();
                return true;
            case 8:
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                Bundle bundle5 = (Bundle) zzey.zza(parcel, Bundle.CREATOR);
                IObjectWrapper a5 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                    if (queryLocalInterface4 instanceof zzane) {
                        zzanfVar = (zzane) queryLocalInterface4;
                    } else {
                        zzanfVar = new zzanf(readStrongBinder4);
                    }
                }
                zza(readString6, readString7, bundle5, a5, zzanfVar, zzaln.zzv(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 9:
                zzvk();
                parcel2.writeNoException();
                return true;
            case 10:
                zzn(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
                zza(parcel.createStringArray(), (Bundle[]) parcel.createTypedArray(Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 12:
                String readString8 = parcel.readString();
                String readString9 = parcel.readString();
                Bundle bundle6 = (Bundle) zzey.zza(parcel, Bundle.CREATOR);
                IObjectWrapper a6 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                    if (queryLocalInterface5 instanceof zzanc) {
                        zzandVar = (zzanc) queryLocalInterface5;
                    } else {
                        zzandVar = new zzand(readStrongBinder5);
                    }
                }
                zza(readString8, readString9, bundle6, a6, zzandVar, zzaln.zzv(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
