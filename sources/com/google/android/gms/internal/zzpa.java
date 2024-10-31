package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.zzoz;

/* loaded from: classes.dex */
public interface zzpa extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzpa {

        /* loaded from: classes.dex */
        private static class a implements zzpa {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1798a;

            a(IBinder iBinder) {
                this.f1798a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1798a;
            }

            @Override // com.google.android.gms.internal.zzpa
            public void zza(zzoz zzozVar, UserAddressRequest userAddressRequest, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.identity.intents.internal.IAddressService");
                    obtain.writeStrongBinder(zzozVar != null ? zzozVar.asBinder() : null);
                    if (userAddressRequest != null) {
                        obtain.writeInt(1);
                        userAddressRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1798a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzpa zzbU(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.identity.intents.internal.IAddressService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzpa)) ? new a(iBinder) : (zzpa) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 2:
                    parcel.enforceInterface("com.google.android.gms.identity.intents.internal.IAddressService");
                    zza(zzoz.zza.zzbT(parcel.readStrongBinder()), parcel.readInt() != 0 ? UserAddressRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.identity.intents.internal.IAddressService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzoz zzozVar, UserAddressRequest userAddressRequest, Bundle bundle) throws RemoteException;
}
