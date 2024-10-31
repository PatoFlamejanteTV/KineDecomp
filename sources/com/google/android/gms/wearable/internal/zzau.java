package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface zzau extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzau {

        /* loaded from: classes.dex */
        private static class a implements zzau {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2383a;

            a(IBinder iBinder) {
                this.f2383a = iBinder;
            }

            @Override // com.google.android.gms.wearable.internal.zzau
            public void a(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IChannelStreamCallbacks");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f2383a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2383a;
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.wearable.internal.IChannelStreamCallbacks");
        }

        public static zzau a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IChannelStreamCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzau)) ? new a(iBinder) : (zzau) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 2:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IChannelStreamCallbacks");
                    a(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.wearable.internal.IChannelStreamCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(int i, int i2) throws RemoteException;
}
