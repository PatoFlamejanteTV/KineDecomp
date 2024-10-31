package com.google.android.gms.iid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface zzb extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzb {

        /* loaded from: classes.dex */
        private static class a implements zzb {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1429a;

            a(IBinder iBinder) {
                this.f1429a = iBinder;
            }

            @Override // com.google.android.gms.iid.zzb
            public void a(Message message) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
                    if (message != null) {
                        obtain.writeInt(1);
                        message.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1429a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1429a;
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.iid.IMessengerCompat");
        }

        public static zzb a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzb)) ? new a(iBinder) : (zzb) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.iid.IMessengerCompat");
                    a(parcel.readInt() != 0 ? (Message) Message.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.iid.IMessengerCompat");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(Message message) throws RemoteException;
}
