package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public interface zzjx extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzjx {

        /* loaded from: classes.dex */
        private static class a implements zzjx {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1737a;

            a(IBinder iBinder) {
                this.f1737a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1737a;
            }

            @Override // com.google.android.gms.internal.zzjx
            public void zze(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appinvite.internal.IAppInviteCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1737a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.appinvite.internal.IAppInviteCallbacks");
        }

        public static zzjx zzak(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appinvite.internal.IAppInviteCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzjx)) ? new a(iBinder) : (zzjx) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.appinvite.internal.IAppInviteCallbacks");
                    zze(parcel.readInt() != 0 ? Status.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.appinvite.internal.IAppInviteCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zze(Status status) throws RemoteException;
}
