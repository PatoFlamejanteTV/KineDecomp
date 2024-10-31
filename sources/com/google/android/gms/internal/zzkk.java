package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyGrpcRequest;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.internal.zzkj;

/* loaded from: classes.dex */
public interface zzkk extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzkk {

        /* loaded from: classes.dex */
        private static class a implements zzkk {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1743a;

            a(IBinder iBinder) {
                this.f1743a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1743a;
            }

            @Override // com.google.android.gms.internal.zzkk
            public void zza(zzkj zzkjVar, ProxyGrpcRequest proxyGrpcRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
                    obtain.writeStrongBinder(zzkjVar != null ? zzkjVar.asBinder() : null);
                    if (proxyGrpcRequest != null) {
                        obtain.writeInt(1);
                        proxyGrpcRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1743a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzkk
            public void zza(zzkj zzkjVar, ProxyRequest proxyRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.internal.IAuthService");
                    obtain.writeStrongBinder(zzkjVar != null ? zzkjVar.asBinder() : null);
                    if (proxyRequest != null) {
                        obtain.writeInt(1);
                        proxyRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1743a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzkk zzaw(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzkk)) ? new a(iBinder) : (zzkk) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
                    zza(zzkj.zza.zzav(parcel.readStrongBinder()), parcel.readInt() != 0 ? ProxyRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
                    zza(zzkj.zza.zzav(parcel.readStrongBinder()), parcel.readInt() != 0 ? ProxyGrpcRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.auth.api.internal.IAuthService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzkj zzkjVar, ProxyGrpcRequest proxyGrpcRequest) throws RemoteException;

    void zza(zzkj zzkjVar, ProxyRequest proxyRequest) throws RemoteException;
}
