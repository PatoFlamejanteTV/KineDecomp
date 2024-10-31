package com.google.android.gms.vision.barcode.internal.client;

import android.os.Binder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

/* loaded from: classes.dex */
public interface zzc extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzc {
        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
                    zzb a2 = a(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? BarcodeDetectorOptions.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a2 != null ? a2.asBinder() : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    zzb a(com.google.android.gms.dynamic.zzd zzdVar, BarcodeDetectorOptions barcodeDetectorOptions) throws RemoteException;
}
