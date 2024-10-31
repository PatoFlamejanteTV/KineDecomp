package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzqq;

/* loaded from: classes.dex */
public interface zzqr extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzqr {

        /* loaded from: classes.dex */
        private static class a implements zzqr {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1821a;

            a(IBinder iBinder) {
                this.f1821a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1821a;
            }

            @Override // com.google.android.gms.internal.zzqr
            public void zza(zzqq zzqqVar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthService");
                    obtain.writeStrongBinder(zzqqVar != null ? zzqqVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1821a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqr
            public void zzb(zzqq zzqqVar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthService");
                    obtain.writeStrongBinder(zzqqVar != null ? zzqqVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1821a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzqr zzdK(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.search.internal.ISearchAuthService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzqr)) ? new a(iBinder) : (zzqr) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.search.internal.ISearchAuthService");
                    zza(zzqq.zza.zzdJ(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.search.internal.ISearchAuthService");
                    zzb(zzqq.zza.zzdJ(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.search.internal.ISearchAuthService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzqq zzqqVar, String str, String str2) throws RemoteException;

    void zzb(zzqq zzqqVar, String str, String str2) throws RemoteException;
}
