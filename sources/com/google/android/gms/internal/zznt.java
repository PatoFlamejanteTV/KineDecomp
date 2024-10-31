package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DailyTotalResult;

/* loaded from: classes.dex */
public interface zznt extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zznt {

        /* loaded from: classes.dex */
        private static class a implements zznt {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1770a;

            a(IBinder iBinder) {
                this.f1770a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1770a;
            }

            @Override // com.google.android.gms.internal.zznt
            public void zza(DailyTotalResult dailyTotalResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IDailyTotalCallback");
                    if (dailyTotalResult != null) {
                        obtain.writeInt(1);
                        dailyTotalResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1770a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.internal.IDailyTotalCallback");
        }

        public static zznt zzbt(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDailyTotalCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zznt)) ? new a(iBinder) : (zznt) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IDailyTotalCallback");
                    zza(parcel.readInt() != 0 ? DailyTotalResult.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IDailyTotalCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(DailyTotalResult dailyTotalResult) throws RemoteException;
}
