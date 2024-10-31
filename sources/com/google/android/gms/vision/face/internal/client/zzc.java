package com.google.android.gms.vision.face.internal.client;

import android.os.Binder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;

/* loaded from: classes.dex */
public interface zzc extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzc {
        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    FaceParcel[] a2 = a(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? FrameMetadataParcel.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(a2, 1);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    boolean a3 = a(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(a3 ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    a();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a() throws RemoteException;

    boolean a(int i) throws RemoteException;

    FaceParcel[] a(com.google.android.gms.dynamic.zzd zzdVar, FrameMetadataParcel frameMetadataParcel) throws RemoteException;
}
