package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface zzla extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzla {

        /* loaded from: classes.dex */
        private static class a implements zzla {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1749a;

            a(IBinder iBinder) {
                this.f1749a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1749a;
            }

            @Override // com.google.android.gms.internal.zzla
            public void zzbg(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplaySessionCallbacks");
                    obtain.writeInt(i);
                    this.f1749a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.cast.remote_display.ICastRemoteDisplaySessionCallbacks");
        }

        public static zzla zzaF(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplaySessionCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzla)) ? new a(iBinder) : (zzla) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplaySessionCallbacks");
                    zzbg(parcel.readInt());
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.cast.remote_display.ICastRemoteDisplaySessionCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zzbg(int i) throws RemoteException;
}
