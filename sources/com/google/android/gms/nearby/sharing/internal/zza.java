package com.google.android.gms.nearby.sharing.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.sharing.AppContentReceivedResult;

/* loaded from: classes.dex */
public interface zza extends IInterface {

    /* renamed from: com.google.android.gms.nearby.sharing.internal.zza$zza, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0043zza extends Binder implements zza {

        /* renamed from: com.google.android.gms.nearby.sharing.internal.zza$zza$a */
        /* loaded from: classes.dex */
        private static class a implements zza {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2138a;

            a(IBinder iBinder) {
                this.f2138a = iBinder;
            }

            @Override // com.google.android.gms.nearby.sharing.internal.zza
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.IAppContentReceiver");
                    obtain.writeString(str);
                    this.f2138a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.nearby.sharing.internal.zza
            public void a(AppContentReceivedResult appContentReceivedResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.IAppContentReceiver");
                    if (appContentReceivedResult != null) {
                        obtain.writeInt(1);
                        appContentReceivedResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2138a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2138a;
            }
        }

        public static zza a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.sharing.internal.IAppContentReceiver");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zza)) ? new a(iBinder) : (zza) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.nearby.sharing.internal.IAppContentReceiver");
                    String a2 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a2);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.nearby.sharing.internal.IAppContentReceiver");
                    a(parcel.readInt() != 0 ? AppContentReceivedResult.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.nearby.sharing.internal.IAppContentReceiver");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String a(String str) throws RemoteException;

    void a(AppContentReceivedResult appContentReceivedResult) throws RemoteException;
}
