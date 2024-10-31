package com.google.android.gms.cast.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;

/* loaded from: classes.dex */
public interface zzj extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzj {
        public zza() {
            attachInterface(this, "com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    a(parcel.readInt());
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    a(parcel.readInt() != 0 ? ApplicationMetadata.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), parcel.readInt() != 0);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    b(parcel.readInt());
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    a(parcel.readString(), parcel.readDouble(), parcel.readInt() != 0);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    a(parcel.readString(), parcel.readString());
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    a(parcel.readString(), parcel.createByteArray());
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    d(parcel.readInt());
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    c(parcel.readInt());
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    e(parcel.readInt());
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    a(parcel.readString(), parcel.readLong(), parcel.readInt());
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    a(parcel.readString(), parcel.readLong());
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    a(parcel.readInt() != 0 ? ApplicationStatus.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    a(parcel.readInt() != 0 ? DeviceStatus.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(int i) throws RemoteException;

    void a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) throws RemoteException;

    void a(ApplicationStatus applicationStatus) throws RemoteException;

    void a(DeviceStatus deviceStatus) throws RemoteException;

    void a(String str, double d, boolean z) throws RemoteException;

    void a(String str, long j) throws RemoteException;

    void a(String str, long j, int i) throws RemoteException;

    void a(String str, String str2) throws RemoteException;

    void a(String str, byte[] bArr) throws RemoteException;

    void b(int i) throws RemoteException;

    void c(int i) throws RemoteException;

    void d(int i) throws RemoteException;

    void e(int i) throws RemoteException;
}
