package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzc;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzrh;
import com.google.android.gms.internal.zzri;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

/* loaded from: classes.dex */
public interface zzrk extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzrk {

        /* loaded from: classes.dex */
        private static class a implements zzrk {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1828a;

            a(IBinder iBinder) {
                this.f1828a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1828a;
            }

            @Override // com.google.android.gms.internal.zzrk
            public zzrh zza(com.google.android.gms.dynamic.zzd zzdVar, com.google.android.gms.dynamic.zzc zzcVar, WalletFragmentOptions walletFragmentOptions, zzri zzriVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    obtain.writeStrongBinder(zzcVar != null ? zzcVar.asBinder() : null);
                    if (walletFragmentOptions != null) {
                        obtain.writeInt(1);
                        walletFragmentOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzriVar != null ? zzriVar.asBinder() : null);
                    this.f1828a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzrh.zza.zzdV(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzrk zzdY(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzrk)) ? new a(iBinder) : (zzrk) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    zzrh zza = zza(zzd.zza.a(parcel.readStrongBinder()), zzc.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? WalletFragmentOptions.CREATOR.createFromParcel(parcel) : null, zzri.zza.zzdW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zza != null ? zza.asBinder() : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    zzrh zza(com.google.android.gms.dynamic.zzd zzdVar, com.google.android.gms.dynamic.zzc zzcVar, WalletFragmentOptions walletFragmentOptions, zzri zzriVar) throws RemoteException;
}
