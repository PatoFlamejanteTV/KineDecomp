package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzjx;

/* loaded from: classes.dex */
public interface zzjy extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzjy {

        /* loaded from: classes.dex */
        private static class a implements zzjy {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1738a;

            a(IBinder iBinder) {
                this.f1738a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1738a;
            }

            @Override // com.google.android.gms.internal.zzjy
            public void zza(zzjx zzjxVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appinvite.internal.IAppInviteService");
                    obtain.writeStrongBinder(zzjxVar != null ? zzjxVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1738a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzjy
            public void zzb(zzjx zzjxVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appinvite.internal.IAppInviteService");
                    obtain.writeStrongBinder(zzjxVar != null ? zzjxVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1738a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzjy zzal(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appinvite.internal.IAppInviteService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzjy)) ? new a(iBinder) : (zzjy) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.appinvite.internal.IAppInviteService");
                    zzb(zzjx.zza.zzak(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.appinvite.internal.IAppInviteService");
                    zza(zzjx.zza.zzak(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.appinvite.internal.IAppInviteService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzjx zzjxVar, String str) throws RemoteException;

    void zzb(zzjx zzjxVar, String str) throws RemoteException;
}
