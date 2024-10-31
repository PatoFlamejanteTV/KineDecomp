package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

/* loaded from: classes.dex */
public interface zza extends IInterface {

    /* renamed from: com.google.android.gms.ads.internal.reward.mediation.client.zza$zza, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0029zza extends Binder implements zza {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.android.gms.ads.internal.reward.mediation.client.zza$zza$a */
        /* loaded from: classes.dex */
        public static class a implements zza {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f651a;

            a(IBinder iBinder) {
                this.f651a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f651a;
            }

            @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
            public void zza(zzd zzdVar, RewardItemParcel rewardItemParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (rewardItemParcel != null) {
                        obtain.writeInt(1);
                        rewardItemParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f651a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
            public void zzb(zzd zzdVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.f651a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
            public void zzc(zzd zzdVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.f651a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
            public void zzg(zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.f651a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
            public void zzh(zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.f651a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
            public void zzi(zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.f651a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
            public void zzj(zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.f651a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
            public void zzk(zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.f651a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
            public void zzl(zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.f651a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.ads.internal.reward.mediation.client.zza
            public void zzm(zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.f651a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC0029zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        }

        public static zza zzae(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zza)) ? new a(iBinder) : (zza) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    zzg(zzd.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    zzb(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    zzh(zzd.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    zzi(zzd.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    zzj(zzd.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    zzk(zzd.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    zza(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? RewardItemParcel.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    zzl(zzd.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    zzc(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    zzm(zzd.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzd zzdVar, RewardItemParcel rewardItemParcel) throws RemoteException;

    void zzb(zzd zzdVar, int i) throws RemoteException;

    void zzc(zzd zzdVar, int i) throws RemoteException;

    void zzg(zzd zzdVar) throws RemoteException;

    void zzh(zzd zzdVar) throws RemoteException;

    void zzi(zzd zzdVar) throws RemoteException;

    void zzj(zzd zzdVar) throws RemoteException;

    void zzk(zzd zzdVar) throws RemoteException;

    void zzl(zzd zzdVar) throws RemoteException;

    void zzm(zzd zzdVar) throws RemoteException;
}
