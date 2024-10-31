package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzen;

/* loaded from: classes.dex */
public interface zzem extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzem {

        /* loaded from: classes.dex */
        private static class a implements zzem {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1706a;

            a(IBinder iBinder) {
                this.f1706a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1706a;
            }

            @Override // com.google.android.gms.internal.zzem
            public zzen zzae(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    obtain.writeString(str);
                    this.f1706a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzen.zza.zzF(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzem
            public boolean zzaf(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    obtain.writeString(str);
                    this.f1706a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        }

        public static zzem zzE(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzem)) ? new a(iBinder) : (zzem) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    zzen zzae = zzae(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzae != null ? zzae.asBinder() : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    boolean zzaf = zzaf(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zzaf ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    zzen zzae(String str) throws RemoteException;

    boolean zzaf(String str) throws RemoteException;
}
