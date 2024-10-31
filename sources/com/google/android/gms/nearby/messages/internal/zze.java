package com.google.android.gms.nearby.messages.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface zze extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zze {

        /* loaded from: classes.dex */
        private static class a implements zze {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2125a;

            a(IBinder iBinder) {
                this.f2125a = iBinder;
            }

            @Override // com.google.android.gms.nearby.messages.internal.zze
            public void a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.IPublishCallback");
                    this.f2125a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2125a;
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.nearby.messages.internal.IPublishCallback");
        }

        public static zze a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IPublishCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zze)) ? new a(iBinder) : (zze) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.IPublishCallback");
                    a();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.nearby.messages.internal.IPublishCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a() throws RemoteException;
}
