package com.google.android.gms.vision.face.internal.client;

import android.os.Binder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

/* loaded from: classes.dex */
public interface zzd extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzd {
        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
                    zzc a2 = a(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? FaceSettingsParcel.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a2 != null ? a2.asBinder() : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.vision.face.internal.client.INativeFaceDetectorCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    zzc a(com.google.android.gms.dynamic.zzd zzdVar, FaceSettingsParcel faceSettingsParcel) throws RemoteException;
}
