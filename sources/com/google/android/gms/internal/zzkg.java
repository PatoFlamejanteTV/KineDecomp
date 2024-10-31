package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.consent.GetConsentIntentRequest;

/* loaded from: classes.dex */
public interface zzkg extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzkg {

        /* loaded from: classes.dex */
        private static class a implements zzkg {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1741a;

            a(IBinder iBinder) {
                this.f1741a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1741a;
            }

            @Override // com.google.android.gms.internal.zzkg
            public Intent zza(GetConsentIntentRequest getConsentIntentRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.consent.internal.IConsentService");
                    if (getConsentIntentRequest != null) {
                        obtain.writeInt(1);
                        getConsentIntentRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1741a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzkg zzaq(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.consent.internal.IConsentService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzkg)) ? new a(iBinder) : (zzkg) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.auth.api.consent.internal.IConsentService");
                    Intent zza = zza(parcel.readInt() != 0 ? GetConsentIntentRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (zza != null) {
                        parcel2.writeInt(1);
                        zza.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.auth.api.consent.internal.IConsentService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    Intent zza(GetConsentIntentRequest getConsentIntentRequest) throws RemoteException;
}
