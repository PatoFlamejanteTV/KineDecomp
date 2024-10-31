package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.BleDevicesResult;

/* loaded from: classes.dex */
public interface zzow extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzow {

        /* loaded from: classes.dex */
        private static class a implements zzow {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1796a;

            a(IBinder iBinder) {
                this.f1796a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1796a;
            }

            @Override // com.google.android.gms.internal.zzow
            public void zza(BleDevicesResult bleDevicesResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
                    if (bleDevicesResult != null) {
                        obtain.writeInt(1);
                        bleDevicesResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1796a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
        }

        public static zzow zzbL(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzow)) ? new a(iBinder) : (zzow) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
                    zza(parcel.readInt() != 0 ? BleDevicesResult.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(BleDevicesResult bleDevicesResult) throws RemoteException;
}
