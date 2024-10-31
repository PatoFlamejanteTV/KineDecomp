package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IGamesClient extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IGamesClient {

        /* loaded from: classes.dex */
        private static class a implements IGamesClient {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1362a;

            a(IBinder iBinder) {
                this.f1362a = iBinder;
            }

            @Override // com.google.android.gms.games.internal.IGamesClient
            public PopupLocationInfoParcelable a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesClient");
                    this.f1362a.transact(1001, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? PopupLocationInfoParcelable.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1362a;
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesClient");
        }

        public static IGamesClient a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesClient");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGamesClient)) ? new a(iBinder) : (IGamesClient) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesClient");
                    PopupLocationInfoParcelable a2 = a();
                    parcel2.writeNoException();
                    if (a2 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    a2.writeToParcel(parcel2, 1);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.games.internal.IGamesClient");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    PopupLocationInfoParcelable a() throws RemoteException;
}
