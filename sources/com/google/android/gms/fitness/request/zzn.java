package com.google.android.gms.fitness.request;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;

/* loaded from: classes.dex */
public interface zzn extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzn {

        /* loaded from: classes.dex */
        private static class a implements zzn {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1281a;

            a(IBinder iBinder) {
                this.f1281a = iBinder;
            }

            @Override // com.google.android.gms.fitness.request.zzn
            public void a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.request.IBleScanCallback");
                    this.f1281a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.fitness.request.zzn
            public void a(BleDevice bleDevice) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.request.IBleScanCallback");
                    if (bleDevice != null) {
                        obtain.writeInt(1);
                        bleDevice.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1281a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1281a;
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.request.IBleScanCallback");
        }

        public static zzn a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.request.IBleScanCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzn)) ? new a(iBinder) : (zzn) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.fitness.request.IBleScanCallback");
                    a(parcel.readInt() != 0 ? BleDevice.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.fitness.request.IBleScanCallback");
                    a();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.request.IBleScanCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a() throws RemoteException;

    void a(BleDevice bleDevice) throws RemoteException;
}
