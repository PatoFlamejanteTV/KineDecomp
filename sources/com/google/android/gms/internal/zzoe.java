package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

/* loaded from: classes.dex */
public interface zzoe extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzoe {

        /* loaded from: classes.dex */
        private static class a implements zzoe {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1781a;

            a(IBinder iBinder) {
                this.f1781a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1781a;
            }

            @Override // com.google.android.gms.internal.zzoe
            public void zza(ListSubscriptionsResult listSubscriptionsResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
                    if (listSubscriptionsResult != null) {
                        obtain.writeInt(1);
                        listSubscriptionsResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1781a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
        }

        public static zzoe zzbE(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzoe)) ? new a(iBinder) : (zzoe) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
                    zza(parcel.readInt() != 0 ? ListSubscriptionsResult.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(ListSubscriptionsResult listSubscriptionsResult) throws RemoteException;
}
