package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataStatsResult;

/* loaded from: classes.dex */
public interface zzog extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzog {

        /* loaded from: classes.dex */
        private static class a implements zzog {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1783a;

            a(IBinder iBinder) {
                this.f1783a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1783a;
            }

            @Override // com.google.android.gms.internal.zzog
            public void zza(DataStatsResult dataStatsResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IReadStatsCallback");
                    if (dataStatsResult != null) {
                        obtain.writeInt(1);
                        dataStatsResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1783a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzog zzbG(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IReadStatsCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzog)) ? new a(iBinder) : (zzog) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IReadStatsCallback");
                    zza(parcel.readInt() != 0 ? DataStatsResult.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IReadStatsCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(DataStatsResult dataStatsResult) throws RemoteException;
}
