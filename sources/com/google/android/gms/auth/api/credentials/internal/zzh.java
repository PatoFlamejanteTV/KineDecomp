package com.google.android.gms.auth.api.credentials.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.internal.zzg;

/* loaded from: classes.dex */
public interface zzh extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzh {

        /* loaded from: classes.dex */
        private static class a implements zzh {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f799a;

            a(IBinder iBinder) {
                this.f799a = iBinder;
            }

            @Override // com.google.android.gms.auth.api.credentials.internal.zzh
            public void a(zzg zzgVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    obtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    this.f799a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.auth.api.credentials.internal.zzh
            public void a(zzg zzgVar, CredentialRequest credentialRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    obtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    if (credentialRequest != null) {
                        obtain.writeInt(1);
                        credentialRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f799a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.auth.api.credentials.internal.zzh
            public void a(zzg zzgVar, DeleteRequest deleteRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    obtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    if (deleteRequest != null) {
                        obtain.writeInt(1);
                        deleteRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f799a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.auth.api.credentials.internal.zzh
            public void a(zzg zzgVar, SaveRequest saveRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    obtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    if (saveRequest != null) {
                        obtain.writeInt(1);
                        saveRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f799a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f799a;
            }
        }

        public static zzh a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzh)) ? new a(iBinder) : (zzh) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    a(zzg.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? CredentialRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    a(zzg.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? SaveRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    a(zzg.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? DeleteRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    a(zzg.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(zzg zzgVar) throws RemoteException;

    void a(zzg zzgVar, CredentialRequest credentialRequest) throws RemoteException;

    void a(zzg zzgVar, DeleteRequest deleteRequest) throws RemoteException;

    void a(zzg zzgVar, SaveRequest saveRequest) throws RemoteException;
}
