package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzem;

/* loaded from: classes.dex */
public interface zzt extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzt {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class a implements zzt {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f553a;

            a(IBinder iBinder) {
                this.f553a = iBinder;
            }

            @Override // com.google.android.gms.ads.internal.client.zzt
            public IBinder a(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, String str, zzem zzemVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzemVar != null ? zzemVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.f553a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.ads.internal.client.zzt
            public IBinder a(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, String str, zzem zzemVar, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzemVar != null ? zzemVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f553a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f553a;
            }
        }

        public static zzt a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzt)) ? new a(iBinder) : (zzt) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    IBinder a2 = a(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? AdSizeParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), zzem.zza.zzE(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a2);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    IBinder a3 = a(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? AdSizeParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), zzem.zza.zzE(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a3);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IBinder a(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, String str, zzem zzemVar, int i) throws RemoteException;

    IBinder a(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, String str, zzem zzemVar, int i, int i2) throws RemoteException;
}
