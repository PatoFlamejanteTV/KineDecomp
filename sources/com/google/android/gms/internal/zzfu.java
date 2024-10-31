package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

/* loaded from: classes.dex */
public interface zzfu extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzfu {

        /* loaded from: classes.dex */
        private static class a implements zzfu {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1718a;

            a(IBinder iBinder) {
                this.f1718a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1718a;
            }

            @Override // com.google.android.gms.internal.zzfu
            public IBinder zzf(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.f1718a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzfu zzR(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzfu)) ? new a(iBinder) : (zzfu) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
                    IBinder zzf = zzf(zzd.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzf);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IBinder zzf(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException;
}
