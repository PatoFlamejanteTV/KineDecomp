package com.google.android.gms.nearby.sharing.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.sharing.internal.zzc;

/* loaded from: classes.dex */
public interface zzd extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzd {

        /* loaded from: classes.dex */
        private static class a implements zzd {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2141a;

            a(IBinder iBinder) {
                this.f2141a = iBinder;
            }

            @Override // com.google.android.gms.nearby.sharing.internal.zzd
            public void a(ProvideContentRequest provideContentRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (provideContentRequest != null) {
                        obtain.writeInt(1);
                        provideContentRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2141a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.nearby.sharing.internal.zzd
            public void a(ReceiveContentRequest receiveContentRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (receiveContentRequest != null) {
                        obtain.writeInt(1);
                        receiveContentRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2141a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.nearby.sharing.internal.zzd
            public void a(StopProvidingContentRequest stopProvidingContentRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (stopProvidingContentRequest != null) {
                        obtain.writeInt(1);
                        stopProvidingContentRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2141a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.nearby.sharing.internal.zzd
            public void a(TrustedDevicesRequest trustedDevicesRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (trustedDevicesRequest != null) {
                        obtain.writeInt(1);
                        trustedDevicesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2141a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.nearby.sharing.internal.zzd
            public void a(zzc zzcVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    obtain.writeStrongBinder(zzcVar != null ? zzcVar.asBinder() : null);
                    this.f2141a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2141a;
            }
        }

        public static zzd a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzd)) ? new a(iBinder) : (zzd) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    a(parcel.readInt() != 0 ? ProvideContentRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    a(parcel.readInt() != 0 ? StopProvidingContentRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    a(parcel.readInt() != 0 ? TrustedDevicesRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    a(parcel.readInt() != 0 ? ReceiveContentRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    a(zzc.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(ProvideContentRequest provideContentRequest) throws RemoteException;

    void a(ReceiveContentRequest receiveContentRequest) throws RemoteException;

    void a(StopProvidingContentRequest stopProvidingContentRequest) throws RemoteException;

    void a(TrustedDevicesRequest trustedDevicesRequest) throws RemoteException;

    void a(zzc zzcVar) throws RemoteException;
}
