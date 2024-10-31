package com.google.android.gms.ads.internal.reward.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzem;

/* loaded from: classes.dex */
public interface zzc extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzc {

        /* loaded from: classes.dex */
        private static class a implements zzc {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f646a;

            a(IBinder iBinder) {
                this.f646a = iBinder;
            }

            @Override // com.google.android.gms.ads.internal.reward.client.zzc
            public IBinder a(com.google.android.gms.dynamic.zzd zzdVar, zzem zzemVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    obtain.writeStrongBinder(zzemVar != null ? zzemVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.f646a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f646a;
            }
        }

        public static zzc a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzc)) ? new a(iBinder) : (zzc) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
                    IBinder a2 = a(zzd.zza.a(parcel.readStrongBinder()), zzem.zza.zzE(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a2);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IBinder a(com.google.android.gms.dynamic.zzd zzdVar, zzem zzemVar, int i) throws RemoteException;
}
