package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzcu;

/* loaded from: classes.dex */
public interface zzcy extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzcy {

        /* loaded from: classes.dex */
        private static class a implements zzcy {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1698a;

            a(IBinder iBinder) {
                this.f1698a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1698a;
            }

            @Override // com.google.android.gms.internal.zzcy
            public void zza(zzcu zzcuVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
                    obtain.writeStrongBinder(zzcuVar != null ? zzcuVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1698a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
        }

        public static zzcy zzB(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzcy)) ? new a(iBinder) : (zzcy) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
                    zza(zzcu.zza.zzy(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzcu zzcuVar, String str) throws RemoteException;
}
