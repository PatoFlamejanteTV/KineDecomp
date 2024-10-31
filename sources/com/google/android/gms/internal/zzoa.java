package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DeleteAllUserDataRequest;

/* loaded from: classes.dex */
public interface zzoa extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzoa {

        /* loaded from: classes.dex */
        private static class a implements zzoa {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1777a;

            a(IBinder iBinder) {
                this.f1777a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1777a;
            }

            @Override // com.google.android.gms.internal.zzoa
            public void zza(DeleteAllUserDataRequest deleteAllUserDataRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitInternalApi");
                    if (deleteAllUserDataRequest != null) {
                        obtain.writeInt(1);
                        deleteAllUserDataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1777a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzoa zzbA(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitInternalApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzoa)) ? new a(iBinder) : (zzoa) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitInternalApi");
                    zza(parcel.readInt() != 0 ? DeleteAllUserDataRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IGoogleFitInternalApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(DeleteAllUserDataRequest deleteAllUserDataRequest) throws RemoteException;
}
