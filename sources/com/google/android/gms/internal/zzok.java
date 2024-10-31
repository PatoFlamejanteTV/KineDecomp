package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SyncInfoResult;

/* loaded from: classes.dex */
public interface zzok extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzok {

        /* loaded from: classes.dex */
        private static class a implements zzok {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1787a;

            a(IBinder iBinder) {
                this.f1787a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1787a;
            }

            @Override // com.google.android.gms.internal.zzok
            public void zza(SyncInfoResult syncInfoResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.ISyncInfoCallback");
                    if (syncInfoResult != null) {
                        obtain.writeInt(1);
                        syncInfoResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1787a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzok zzbK(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.ISyncInfoCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzok)) ? new a(iBinder) : (zzok) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.ISyncInfoCallback");
                    zza(parcel.readInt() != 0 ? SyncInfoResult.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.ISyncInfoCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(SyncInfoResult syncInfoResult) throws RemoteException;
}
