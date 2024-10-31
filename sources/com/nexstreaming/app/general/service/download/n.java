package com.nexstreaming.app.general.service.download;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.nexstreaming.app.general.service.download.m;

/* compiled from: INexDownloadService.java */
/* loaded from: classes2.dex */
public interface n extends IInterface {
    int a(k kVar) throws RemoteException;

    boolean a(m mVar) throws RemoteException;

    boolean a(String str) throws RemoteException;

    int b(String str) throws RemoteException;

    boolean b(m mVar) throws RemoteException;

    /* compiled from: INexDownloadService.java */
    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements n {
        public a() {
            attachInterface(this, "com.nexstreaming.app.general.service.download.INexDownloadService");
        }

        public static n a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.nexstreaming.app.general.service.download.INexDownloadService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof n)) {
                return (n) queryLocalInterface;
            }
            return new C0100a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.nexstreaming.app.general.service.download.INexDownloadService");
                int a2 = a(parcel.readInt() != 0 ? k.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(a2);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.nexstreaming.app.general.service.download.INexDownloadService");
                boolean a3 = a(m.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(a3 ? 1 : 0);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.nexstreaming.app.general.service.download.INexDownloadService");
                boolean b2 = b(m.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(b2 ? 1 : 0);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface("com.nexstreaming.app.general.service.download.INexDownloadService");
                int b3 = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(b3);
                return true;
            }
            if (i != 5) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.nexstreaming.app.general.service.download.INexDownloadService");
                return true;
            }
            parcel.enforceInterface("com.nexstreaming.app.general.service.download.INexDownloadService");
            boolean a4 = a(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeInt(a4 ? 1 : 0);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: INexDownloadService.java */
        /* renamed from: com.nexstreaming.app.general.service.download.n$a$a */
        /* loaded from: classes2.dex */
        public static class C0100a implements n {

            /* renamed from: a */
            private IBinder f19723a;

            C0100a(IBinder iBinder) {
                this.f19723a = iBinder;
            }

            @Override // com.nexstreaming.app.general.service.download.n
            public int a(k kVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.nexstreaming.app.general.service.download.INexDownloadService");
                    if (kVar != null) {
                        obtain.writeInt(1);
                        kVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f19723a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f19723a;
            }

            @Override // com.nexstreaming.app.general.service.download.n
            public boolean b(m mVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.nexstreaming.app.general.service.download.INexDownloadService");
                    obtain.writeStrongBinder(mVar != null ? mVar.asBinder() : null);
                    this.f19723a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.nexstreaming.app.general.service.download.n
            public boolean a(m mVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.nexstreaming.app.general.service.download.INexDownloadService");
                    obtain.writeStrongBinder(mVar != null ? mVar.asBinder() : null);
                    this.f19723a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.nexstreaming.app.general.service.download.n
            public boolean a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.nexstreaming.app.general.service.download.INexDownloadService");
                    obtain.writeString(str);
                    this.f19723a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
