package com.google.android.gms.nearby.messages.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface zzf extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzf {

        /* loaded from: classes.dex */
        private static class a implements zzf {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2126a;

            a(IBinder iBinder) {
                this.f2126a = iBinder;
            }

            @Override // com.google.android.gms.nearby.messages.internal.zzf
            public void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.IStatusCallback");
                    obtain.writeInt(z ? 1 : 0);
                    this.f2126a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2126a;
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.nearby.messages.internal.IStatusCallback");
        }

        public static zzf a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IStatusCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzf)) ? new a(iBinder) : (zzf) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.IStatusCallback");
                    a(parcel.readInt() != 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.nearby.messages.internal.IStatusCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(boolean z) throws RemoteException;
}
