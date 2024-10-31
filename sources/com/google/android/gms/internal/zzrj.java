package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzrl;
import com.google.android.gms.internal.zzrm;
import com.google.android.gms.wallet.CreateWalletObjectsRequest;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.firstparty.GetBuyFlowInitializationTokenRequest;
import com.google.android.gms.wallet.firstparty.GetInstrumentsRequest;
import com.google.android.gms.wallet.firstparty.InitializeBuyFlowRequest;

/* loaded from: classes.dex */
public interface zzrj extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzrj {

        /* loaded from: classes.dex */
        private static class a implements zzrj {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1827a;

            a(IBinder iBinder) {
                this.f1827a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1827a;
            }

            @Override // com.google.android.gms.internal.zzrj
            public void zzC(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1827a.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzrj
            public void zzD(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1827a.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzrj
            public void zza(Bundle bundle, zzrm zzrmVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzrmVar != null ? zzrmVar.asBinder() : null);
                    this.f1827a.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzrj
            public void zza(CreateWalletObjectsRequest createWalletObjectsRequest, Bundle bundle, zzrm zzrmVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (createWalletObjectsRequest != null) {
                        obtain.writeInt(1);
                        createWalletObjectsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzrmVar != null ? zzrmVar.asBinder() : null);
                    this.f1827a.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzrj
            public void zza(FullWalletRequest fullWalletRequest, Bundle bundle, zzrm zzrmVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (fullWalletRequest != null) {
                        obtain.writeInt(1);
                        fullWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzrmVar != null ? zzrmVar.asBinder() : null);
                    this.f1827a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzrj
            public void zza(MaskedWalletRequest maskedWalletRequest, Bundle bundle, zzrl zzrlVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (maskedWalletRequest != null) {
                        obtain.writeInt(1);
                        maskedWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzrlVar != null ? zzrlVar.asBinder() : null);
                    this.f1827a.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzrj
            public void zza(MaskedWalletRequest maskedWalletRequest, Bundle bundle, zzrm zzrmVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (maskedWalletRequest != null) {
                        obtain.writeInt(1);
                        maskedWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzrmVar != null ? zzrmVar.asBinder() : null);
                    this.f1827a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzrj
            public void zza(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (notifyTransactionStatusRequest != null) {
                        obtain.writeInt(1);
                        notifyTransactionStatusRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1827a.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzrj
            public void zza(GetBuyFlowInitializationTokenRequest getBuyFlowInitializationTokenRequest, Bundle bundle, zzrm zzrmVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (getBuyFlowInitializationTokenRequest != null) {
                        obtain.writeInt(1);
                        getBuyFlowInitializationTokenRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzrmVar != null ? zzrmVar.asBinder() : null);
                    this.f1827a.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzrj
            public void zza(GetInstrumentsRequest getInstrumentsRequest, Bundle bundle, zzrm zzrmVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (getInstrumentsRequest != null) {
                        obtain.writeInt(1);
                        getInstrumentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzrmVar != null ? zzrmVar.asBinder() : null);
                    this.f1827a.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzrj
            public void zza(InitializeBuyFlowRequest initializeBuyFlowRequest, Bundle bundle, zzrm zzrmVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (initializeBuyFlowRequest != null) {
                        obtain.writeInt(1);
                        initializeBuyFlowRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzrmVar != null ? zzrmVar.asBinder() : null);
                    this.f1827a.transact(13, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzrj
            public void zza(String str, String str2, Bundle bundle, zzrm zzrmVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzrmVar != null ? zzrmVar.asBinder() : null);
                    this.f1827a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzrj
            public void zzb(Bundle bundle, zzrm zzrmVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzrmVar != null ? zzrmVar.asBinder() : null);
                    this.f1827a.transact(11, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzrj zzdX(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IOwService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzrj)) ? new a(iBinder) : (zzrj) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(parcel.readInt() != 0 ? MaskedWalletRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, zzrm.zza.zzea(parcel.readStrongBinder()));
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(parcel.readInt() != 0 ? FullWalletRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, zzrm.zza.zzea(parcel.readStrongBinder()));
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, zzrm.zza.zzea(parcel.readStrongBinder()));
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(parcel.readInt() != 0 ? NotifyTransactionStatusRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, zzrm.zza.zzea(parcel.readStrongBinder()));
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(parcel.readInt() != 0 ? CreateWalletObjectsRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, zzrm.zza.zzea(parcel.readStrongBinder()));
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(parcel.readInt() != 0 ? MaskedWalletRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, zzrl.zza.zzdZ(parcel.readStrongBinder()));
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(parcel.readInt() != 0 ? GetInstrumentsRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, zzrm.zza.zzea(parcel.readStrongBinder()));
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zzC(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zzD(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zzb(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, zzrm.zza.zzea(parcel.readStrongBinder()));
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(parcel.readInt() != 0 ? GetBuyFlowInitializationTokenRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, zzrm.zza.zzea(parcel.readStrongBinder()));
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    zza(parcel.readInt() != 0 ? InitializeBuyFlowRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, zzrm.zza.zzea(parcel.readStrongBinder()));
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.wallet.internal.IOwService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zzC(Bundle bundle) throws RemoteException;

    void zzD(Bundle bundle) throws RemoteException;

    void zza(Bundle bundle, zzrm zzrmVar) throws RemoteException;

    void zza(CreateWalletObjectsRequest createWalletObjectsRequest, Bundle bundle, zzrm zzrmVar) throws RemoteException;

    void zza(FullWalletRequest fullWalletRequest, Bundle bundle, zzrm zzrmVar) throws RemoteException;

    void zza(MaskedWalletRequest maskedWalletRequest, Bundle bundle, zzrl zzrlVar) throws RemoteException;

    void zza(MaskedWalletRequest maskedWalletRequest, Bundle bundle, zzrm zzrmVar) throws RemoteException;

    void zza(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Bundle bundle) throws RemoteException;

    void zza(GetBuyFlowInitializationTokenRequest getBuyFlowInitializationTokenRequest, Bundle bundle, zzrm zzrmVar) throws RemoteException;

    void zza(GetInstrumentsRequest getInstrumentsRequest, Bundle bundle, zzrm zzrmVar) throws RemoteException;

    void zza(InitializeBuyFlowRequest initializeBuyFlowRequest, Bundle bundle, zzrm zzrmVar) throws RemoteException;

    void zza(String str, String str2, Bundle bundle, zzrm zzrmVar) throws RemoteException;

    void zzb(Bundle bundle, zzrm zzrmVar) throws RemoteException;
}
