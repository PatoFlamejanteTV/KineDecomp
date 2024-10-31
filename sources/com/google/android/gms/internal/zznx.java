package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.ClaimBleDeviceRequest;
import com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.StopBleScanRequest;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;

/* loaded from: classes.dex */
public interface zznx extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zznx {

        /* loaded from: classes.dex */
        private static class a implements zznx {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1774a;

            a(IBinder iBinder) {
                this.f1774a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1774a;
            }

            @Override // com.google.android.gms.internal.zznx
            public void zza(ClaimBleDeviceRequest claimBleDeviceRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (claimBleDeviceRequest != null) {
                        obtain.writeInt(1);
                        claimBleDeviceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1774a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zznx
            public void zza(ListClaimedBleDevicesRequest listClaimedBleDevicesRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (listClaimedBleDevicesRequest != null) {
                        obtain.writeInt(1);
                        listClaimedBleDevicesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1774a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zznx
            public void zza(StartBleScanRequest startBleScanRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (startBleScanRequest != null) {
                        obtain.writeInt(1);
                        startBleScanRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1774a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zznx
            public void zza(StopBleScanRequest stopBleScanRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (stopBleScanRequest != null) {
                        obtain.writeInt(1);
                        stopBleScanRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1774a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zznx
            public void zza(UnclaimBleDeviceRequest unclaimBleDeviceRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (unclaimBleDeviceRequest != null) {
                        obtain.writeInt(1);
                        unclaimBleDeviceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1774a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zznx zzbx(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zznx)) ? new a(iBinder) : (zznx) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    zza(parcel.readInt() != 0 ? StartBleScanRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    zza(parcel.readInt() != 0 ? StopBleScanRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    zza(parcel.readInt() != 0 ? ClaimBleDeviceRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    zza(parcel.readInt() != 0 ? UnclaimBleDeviceRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    zza(parcel.readInt() != 0 ? ListClaimedBleDevicesRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(ClaimBleDeviceRequest claimBleDeviceRequest) throws RemoteException;

    void zza(ListClaimedBleDevicesRequest listClaimedBleDevicesRequest) throws RemoteException;

    void zza(StartBleScanRequest startBleScanRequest) throws RemoteException;

    void zza(StopBleScanRequest stopBleScanRequest) throws RemoteException;

    void zza(UnclaimBleDeviceRequest unclaimBleDeviceRequest) throws RemoteException;
}
