package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.nearby.bootstrap.request.ConnectRequest;
import com.google.android.gms.nearby.bootstrap.request.ContinueConnectRequest;
import com.google.android.gms.nearby.bootstrap.request.DisableTargetRequest;
import com.google.android.gms.nearby.bootstrap.request.DisconnectRequest;
import com.google.android.gms.nearby.bootstrap.request.EnableTargetRequest;
import com.google.android.gms.nearby.bootstrap.request.SendDataRequest;
import com.google.android.gms.nearby.bootstrap.request.StartScanRequest;
import com.google.android.gms.nearby.bootstrap.request.StopScanRequest;

/* loaded from: classes.dex */
public interface zzpq extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzpq {

        /* loaded from: classes.dex */
        public static class a implements zzpq {

            /* renamed from: a */
            private IBinder f1802a;

            a(IBinder iBinder) {
                this.f1802a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1802a;
            }

            @Override // com.google.android.gms.internal.zzpq
            public String getToken() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    this.f1802a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpq
            public void zza(zzpp zzppVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    obtain.writeStrongBinder(zzppVar != null ? zzppVar.asBinder() : null);
                    this.f1802a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpq
            public void zza(ConnectRequest connectRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (connectRequest != null) {
                        obtain.writeInt(1);
                        connectRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1802a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpq
            public void zza(ContinueConnectRequest continueConnectRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (continueConnectRequest != null) {
                        obtain.writeInt(1);
                        continueConnectRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1802a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpq
            public void zza(DisableTargetRequest disableTargetRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (disableTargetRequest != null) {
                        obtain.writeInt(1);
                        disableTargetRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1802a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpq
            public void zza(DisconnectRequest disconnectRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (disconnectRequest != null) {
                        obtain.writeInt(1);
                        disconnectRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1802a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpq
            public void zza(EnableTargetRequest enableTargetRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (enableTargetRequest != null) {
                        obtain.writeInt(1);
                        enableTargetRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1802a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpq
            public void zza(SendDataRequest sendDataRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (sendDataRequest != null) {
                        obtain.writeInt(1);
                        sendDataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1802a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpq
            public void zza(StartScanRequest startScanRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (startScanRequest != null) {
                        obtain.writeInt(1);
                        startScanRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1802a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzpq
            public void zza(StopScanRequest stopScanRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (stopScanRequest != null) {
                        obtain.writeInt(1);
                        stopScanRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1802a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzpq zzdf(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzpq)) ? new a(iBinder) : (zzpq) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    zza(parcel.readInt() != 0 ? StartScanRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    zza(parcel.readInt() != 0 ? StopScanRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    zza(parcel.readInt() != 0 ? EnableTargetRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    zza(parcel.readInt() != 0 ? DisableTargetRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    zza(parcel.readInt() != 0 ? ConnectRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    zza(parcel.readInt() != 0 ? DisconnectRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    zza(parcel.readInt() != 0 ? SendDataRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    zza(parcel.readInt() != 0 ? ContinueConnectRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    String token = getToken();
                    parcel2.writeNoException();
                    parcel2.writeString(token);
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    zza(zzpp.zza.zzde(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String getToken() throws RemoteException;

    void zza(zzpp zzppVar) throws RemoteException;

    void zza(ConnectRequest connectRequest) throws RemoteException;

    void zza(ContinueConnectRequest continueConnectRequest) throws RemoteException;

    void zza(DisableTargetRequest disableTargetRequest) throws RemoteException;

    void zza(DisconnectRequest disconnectRequest) throws RemoteException;

    void zza(EnableTargetRequest enableTargetRequest) throws RemoteException;

    void zza(SendDataRequest sendDataRequest) throws RemoteException;

    void zza(StartScanRequest startScanRequest) throws RemoteException;

    void zza(StopScanRequest stopScanRequest) throws RemoteException;
}
