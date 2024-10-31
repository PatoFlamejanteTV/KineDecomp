package com.google.android.gms.vision.barcode.internal.client;

import android.os.Binder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;

/* loaded from: classes.dex */
public interface zzb extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzb {
        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
                    Barcode[] a2 = a(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? FrameMetadataParcel.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(a2, 1);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
                    Barcode[] b = b(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? FrameMetadataParcel.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(b, 1);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    Barcode[] a(com.google.android.gms.dynamic.zzd zzdVar, FrameMetadataParcel frameMetadataParcel) throws RemoteException;

    Barcode[] b(com.google.android.gms.dynamic.zzd zzdVar, FrameMetadataParcel frameMetadataParcel) throws RemoteException;
}
