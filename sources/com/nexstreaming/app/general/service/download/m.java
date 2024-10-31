package com.nexstreaming.app.general.service.download;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: INexDownloadCallback.java */
/* loaded from: classes2.dex */
public interface m extends IInterface {
    void a(k kVar, int i) throws RemoteException;

    void a(k kVar, b bVar) throws RemoteException;

    void b(k kVar) throws RemoteException;

    void c(k kVar) throws RemoteException;

    void d(k kVar) throws RemoteException;

    /* compiled from: INexDownloadCallback.java */
    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements m {
        public a() {
            attachInterface(this, "com.nexstreaming.app.general.service.download.INexDownloadCallback");
        }

        public static m a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.nexstreaming.app.general.service.download.INexDownloadCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof m)) {
                return (m) queryLocalInterface;
            }
            return new C0099a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.nexstreaming.app.general.service.download.INexDownloadCallback");
                c(parcel.readInt() != 0 ? k.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.nexstreaming.app.general.service.download.INexDownloadCallback");
                a(parcel.readInt() != 0 ? k.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.nexstreaming.app.general.service.download.INexDownloadCallback");
                d(parcel.readInt() != 0 ? k.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface("com.nexstreaming.app.general.service.download.INexDownloadCallback");
                a(parcel.readInt() != 0 ? k.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? b.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i != 5) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.nexstreaming.app.general.service.download.INexDownloadCallback");
                return true;
            }
            parcel.enforceInterface("com.nexstreaming.app.general.service.download.INexDownloadCallback");
            b(parcel.readInt() != 0 ? k.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: INexDownloadCallback.java */
        /* renamed from: com.nexstreaming.app.general.service.download.m$a$a */
        /* loaded from: classes2.dex */
        public static class C0099a implements m {

            /* renamed from: a */
            private IBinder f19722a;

            C0099a(IBinder iBinder) {
                this.f19722a = iBinder;
            }

            @Override // com.nexstreaming.app.general.service.download.m
            public void a(k kVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.nexstreaming.app.general.service.download.INexDownloadCallback");
                    if (kVar != null) {
                        obtain.writeInt(1);
                        kVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.f19722a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f19722a;
            }

            @Override // com.nexstreaming.app.general.service.download.m
            public void b(k kVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.nexstreaming.app.general.service.download.INexDownloadCallback");
                    if (kVar != null) {
                        obtain.writeInt(1);
                        kVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f19722a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.nexstreaming.app.general.service.download.m
            public void c(k kVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.nexstreaming.app.general.service.download.INexDownloadCallback");
                    if (kVar != null) {
                        obtain.writeInt(1);
                        kVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f19722a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.nexstreaming.app.general.service.download.m
            public void d(k kVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.nexstreaming.app.general.service.download.INexDownloadCallback");
                    if (kVar != null) {
                        obtain.writeInt(1);
                        kVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f19722a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.nexstreaming.app.general.service.download.m
            public void a(k kVar, b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.nexstreaming.app.general.service.download.INexDownloadCallback");
                    if (kVar != null) {
                        obtain.writeInt(1);
                        kVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f19722a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
