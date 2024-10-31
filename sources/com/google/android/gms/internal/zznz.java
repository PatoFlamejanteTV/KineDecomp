package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DailyTotalRequest;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.GetSyncInfoRequest;
import com.google.android.gms.fitness.request.ReadRawRequest;
import com.google.android.gms.fitness.request.ReadStatsRequest;

/* loaded from: classes.dex */
public interface zznz extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zznz {

        /* loaded from: classes.dex */
        public static class a implements zznz {

            /* renamed from: a */
            private IBinder f1776a;

            a(IBinder iBinder) {
                this.f1776a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1776a;
            }

            @Override // com.google.android.gms.internal.zznz
            public void zza(DailyTotalRequest dailyTotalRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dailyTotalRequest != null) {
                        obtain.writeInt(1);
                        dailyTotalRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1776a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zznz
            public void zza(DataDeleteRequest dataDeleteRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataDeleteRequest != null) {
                        obtain.writeInt(1);
                        dataDeleteRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1776a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zznz
            public void zza(DataInsertRequest dataInsertRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataInsertRequest != null) {
                        obtain.writeInt(1);
                        dataInsertRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1776a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zznz
            public void zza(DataReadRequest dataReadRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataReadRequest != null) {
                        obtain.writeInt(1);
                        dataReadRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1776a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zznz
            public void zza(GetSyncInfoRequest getSyncInfoRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (getSyncInfoRequest != null) {
                        obtain.writeInt(1);
                        getSyncInfoRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1776a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zznz
            public void zza(ReadRawRequest readRawRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (readRawRequest != null) {
                        obtain.writeInt(1);
                        readRawRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1776a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zznz
            public void zza(ReadStatsRequest readStatsRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (readStatsRequest != null) {
                        obtain.writeInt(1);
                        readStatsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1776a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zznz
            public void zzb(DataInsertRequest dataInsertRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataInsertRequest != null) {
                        obtain.writeInt(1);
                        dataInsertRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1776a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zznz zzbz(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zznz)) ? new a(iBinder) : (zznz) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    zza(parcel.readInt() != 0 ? DataReadRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    zza(parcel.readInt() != 0 ? DataInsertRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    zza(parcel.readInt() != 0 ? DataDeleteRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    zza(parcel.readInt() != 0 ? GetSyncInfoRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    zza(parcel.readInt() != 0 ? ReadStatsRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    zza(parcel.readInt() != 0 ? ReadRawRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    zza(parcel.readInt() != 0 ? DailyTotalRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    zzb(parcel.readInt() != 0 ? DataInsertRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(DailyTotalRequest dailyTotalRequest) throws RemoteException;

    void zza(DataDeleteRequest dataDeleteRequest) throws RemoteException;

    void zza(DataInsertRequest dataInsertRequest) throws RemoteException;

    void zza(DataReadRequest dataReadRequest) throws RemoteException;

    void zza(GetSyncInfoRequest getSyncInfoRequest) throws RemoteException;

    void zza(ReadRawRequest readRawRequest) throws RemoteException;

    void zza(ReadStatsRequest readStatsRequest) throws RemoteException;

    void zzb(DataInsertRequest dataInsertRequest) throws RemoteException;
}
