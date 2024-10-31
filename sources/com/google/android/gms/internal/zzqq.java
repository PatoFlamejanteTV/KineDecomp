package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;

/* loaded from: classes.dex */
public interface zzqq extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzqq {

        /* loaded from: classes.dex */
        private static class a implements zzqq {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1820a;

            a(IBinder iBinder) {
                this.f1820a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1820a;
            }

            @Override // com.google.android.gms.internal.zzqq
            public void zza(Status status, GoogleNowAuthState googleNowAuthState) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (googleNowAuthState != null) {
                        obtain.writeInt(1);
                        googleNowAuthState.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1820a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqq
            public void zzbb(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1820a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.search.internal.ISearchAuthCallbacks");
        }

        public static zzqq zzdJ(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.search.internal.ISearchAuthCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzqq)) ? new a(iBinder) : (zzqq) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.search.internal.ISearchAuthCallbacks");
                    zza(parcel.readInt() != 0 ? Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? GoogleNowAuthState.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.search.internal.ISearchAuthCallbacks");
                    zzbb(parcel.readInt() != 0 ? Status.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.search.internal.ISearchAuthCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(Status status, GoogleNowAuthState googleNowAuthState) throws RemoteException;

    void zzbb(Status status) throws RemoteException;
}
