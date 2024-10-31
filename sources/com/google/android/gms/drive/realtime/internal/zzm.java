package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.realtime.internal.zzc;
import com.google.android.gms.drive.realtime.internal.zzd;
import com.google.android.gms.drive.realtime.internal.zze;
import com.google.android.gms.drive.realtime.internal.zzf;
import com.google.android.gms.drive.realtime.internal.zzg;
import com.google.android.gms.drive.realtime.internal.zzh;
import com.google.android.gms.drive.realtime.internal.zzi;
import com.google.android.gms.drive.realtime.internal.zzj;
import com.google.android.gms.drive.realtime.internal.zzk;
import com.google.android.gms.drive.realtime.internal.zzl;
import com.google.android.gms.drive.realtime.internal.zzn;
import com.google.android.gms.drive.realtime.internal.zzo;

/* loaded from: classes2.dex */
public interface zzm extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class zza extends Binder implements zzm {

        /* loaded from: classes2.dex */
        public static class a implements zzm {

            /* renamed from: a */
            private IBinder f1197a;

            a(IBinder iBinder) {
                this.f1197a = iBinder;
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.f1197a.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(int i, zzj zzjVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.f1197a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(int i, zzo zzoVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(zzoVar != null ? zzoVar.asBinder() : null);
                    this.f1197a.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(DriveId driveId, zzo zzoVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (driveId != null) {
                        obtain.writeInt(1);
                        driveId.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzoVar != null ? zzoVar.asBinder() : null);
                    this.f1197a.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(BeginCompoundOperationRequest beginCompoundOperationRequest, zzo zzoVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (beginCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        beginCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzoVar != null ? zzoVar.asBinder() : null);
                    this.f1197a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(EndCompoundOperationRequest endCompoundOperationRequest, zzj zzjVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (endCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        endCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.f1197a.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(EndCompoundOperationRequest endCompoundOperationRequest, zzo zzoVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (endCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        endCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzoVar != null ? zzoVar.asBinder() : null);
                    this.f1197a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(ParcelableIndexReference parcelableIndexReference, zzn zznVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (parcelableIndexReference != null) {
                        obtain.writeInt(1);
                        parcelableIndexReference.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zznVar != null ? zznVar.asBinder() : null);
                    this.f1197a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(zzc zzcVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzcVar != null ? zzcVar.asBinder() : null);
                    this.f1197a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.f1197a.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(zze zzeVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzeVar != null ? zzeVar.asBinder() : null);
                    this.f1197a.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(zzh zzhVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzhVar != null ? zzhVar.asBinder() : null);
                    this.f1197a.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(zzi zziVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zziVar != null ? zziVar.asBinder() : null);
                    this.f1197a.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(zzj zzjVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.f1197a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(zzl zzlVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzlVar != null ? zzlVar.asBinder() : null);
                    this.f1197a.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(zzo zzoVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzoVar != null ? zzoVar.asBinder() : null);
                    this.f1197a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(String str, int i, int i2, zzg zzgVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    this.f1197a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(String str, int i, int i2, zzj zzjVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.f1197a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(String str, int i, DataHolder dataHolder, zzg zzgVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    this.f1197a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(String str, int i, DataHolder dataHolder, zzj zzjVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.f1197a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(String str, int i, zzn zznVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(zznVar != null ? zznVar.asBinder() : null);
                    this.f1197a.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(String str, int i, zzo zzoVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(zzoVar != null ? zzoVar.asBinder() : null);
                    this.f1197a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(String str, int i, String str2, int i2, zzj zzjVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.f1197a.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(String str, int i, String str2, zzj zzjVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.f1197a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(String str, DataHolder dataHolder, zzj zzjVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.f1197a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(String str, zzf zzfVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzfVar != null ? zzfVar.asBinder() : null);
                    this.f1197a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(String str, zzj zzjVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.f1197a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(String str, zzk zzkVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzkVar != null ? zzkVar.asBinder() : null);
                    this.f1197a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(String str, zzl zzlVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzlVar != null ? zzlVar.asBinder() : null);
                    this.f1197a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(String str, zzn zznVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zznVar != null ? zznVar.asBinder() : null);
                    this.f1197a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(String str, zzo zzoVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzoVar != null ? zzoVar.asBinder() : null);
                    this.f1197a.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(String str, String str2, DataHolder dataHolder, zzj zzjVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.f1197a.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(String str, String str2, zzf zzfVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzfVar != null ? zzfVar.asBinder() : null);
                    this.f1197a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(String str, String str2, zzg zzgVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    this.f1197a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(String str, String str2, zzj zzjVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.f1197a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void a(boolean z, zzo zzoVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeStrongBinder(zzoVar != null ? zzoVar.asBinder() : null);
                    this.f1197a.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1197a;
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void b(zzc zzcVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzcVar != null ? zzcVar.asBinder() : null);
                    this.f1197a.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void b(zzj zzjVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.f1197a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void b(zzl zzlVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzlVar != null ? zzlVar.asBinder() : null);
                    this.f1197a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void b(zzo zzoVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzoVar != null ? zzoVar.asBinder() : null);
                    this.f1197a.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void b(String str, zzf zzfVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzfVar != null ? zzfVar.asBinder() : null);
                    this.f1197a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void b(String str, zzl zzlVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzlVar != null ? zzlVar.asBinder() : null);
                    this.f1197a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void b(String str, zzn zznVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zznVar != null ? zznVar.asBinder() : null);
                    this.f1197a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void b(String str, zzo zzoVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzoVar != null ? zzoVar.asBinder() : null);
                    this.f1197a.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void b(String str, String str2, zzf zzfVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzfVar != null ? zzfVar.asBinder() : null);
                    this.f1197a.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void c(zzc zzcVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzcVar != null ? zzcVar.asBinder() : null);
                    this.f1197a.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void c(zzo zzoVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzoVar != null ? zzoVar.asBinder() : null);
                    this.f1197a.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void c(String str, zzl zzlVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzlVar != null ? zzlVar.asBinder() : null);
                    this.f1197a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void d(zzc zzcVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzcVar != null ? zzcVar.asBinder() : null);
                    this.f1197a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.realtime.internal.zzm
            public void e(zzc zzcVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzcVar != null ? zzcVar.asBinder() : null);
                    this.f1197a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzm a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzm)) ? new a(iBinder) : (zzm) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readString(), zzn.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(zzc.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(zzo.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readString(), parcel.readString(), zzf.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readString(), zzl.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readString(), parcel.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(parcel) : null, zzj.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readString(), zzj.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    b(parcel.readString(), zzl.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    b(parcel.readString(), zzn.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readString(), parcel.readInt(), parcel.readString(), zzj.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readString(), parcel.readInt(), parcel.readInt(), zzj.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readString(), parcel.readString(), zzj.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    b(parcel.readString(), zzf.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    c(parcel.readString(), zzl.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readString(), parcel.readInt(), parcel.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(parcel) : null, zzj.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readString(), parcel.readInt(), parcel.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(parcel) : null, zzg.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readString(), parcel.readInt(), parcel.readInt(), zzg.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readInt() != 0 ? BeginCompoundOperationRequest.CREATOR.createFromParcel(parcel) : null, zzo.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readInt() != 0 ? EndCompoundOperationRequest.CREATOR.createFromParcel(parcel) : null, zzo.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readString(), zzf.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readString(), parcel.readString(), zzg.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(zzj.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    b(zzj.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    d(zzc.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    e(zzc.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readInt() != 0 ? ParcelableIndexReference.CREATOR.createFromParcel(parcel) : null, zzn.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readString(), zzk.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readString(), parcel.readInt(), zzo.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 29:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    b(zzl.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 30:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readInt(), zzj.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(zze.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(zzd.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    b(zzc.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(zzi.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    b(zzo.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(zzh.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), zzj.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 38:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readString(), zzo.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 39:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    b(parcel.readString(), zzo.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 40:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(zzl.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 41:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readInt() != 0 ? EndCompoundOperationRequest.CREATOR.createFromParcel(parcel) : null, zzj.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    b(parcel.readString(), parcel.readString(), zzf.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(parcel) : null, zzj.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a();
                    parcel2.writeNoException();
                    return true;
                case 45:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    c(zzc.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 46:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readString(), parcel.readInt(), zzn.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 47:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readInt() != 0, zzo.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 48:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readInt() != 0 ? DriveId.CREATOR.createFromParcel(parcel) : null, zzo.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 49:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    c(zzo.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 50:
                    parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    a(parcel.readInt(), zzo.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a() throws RemoteException;

    void a(int i, zzj zzjVar) throws RemoteException;

    void a(int i, zzo zzoVar) throws RemoteException;

    void a(DriveId driveId, zzo zzoVar) throws RemoteException;

    void a(BeginCompoundOperationRequest beginCompoundOperationRequest, zzo zzoVar) throws RemoteException;

    void a(EndCompoundOperationRequest endCompoundOperationRequest, zzj zzjVar) throws RemoteException;

    void a(EndCompoundOperationRequest endCompoundOperationRequest, zzo zzoVar) throws RemoteException;

    void a(ParcelableIndexReference parcelableIndexReference, zzn zznVar) throws RemoteException;

    void a(zzc zzcVar) throws RemoteException;

    void a(zzd zzdVar) throws RemoteException;

    void a(zze zzeVar) throws RemoteException;

    void a(zzh zzhVar) throws RemoteException;

    void a(zzi zziVar) throws RemoteException;

    void a(zzj zzjVar) throws RemoteException;

    void a(zzl zzlVar) throws RemoteException;

    void a(zzo zzoVar) throws RemoteException;

    void a(String str, int i, int i2, zzg zzgVar) throws RemoteException;

    void a(String str, int i, int i2, zzj zzjVar) throws RemoteException;

    void a(String str, int i, DataHolder dataHolder, zzg zzgVar) throws RemoteException;

    void a(String str, int i, DataHolder dataHolder, zzj zzjVar) throws RemoteException;

    void a(String str, int i, zzn zznVar) throws RemoteException;

    void a(String str, int i, zzo zzoVar) throws RemoteException;

    void a(String str, int i, String str2, int i2, zzj zzjVar) throws RemoteException;

    void a(String str, int i, String str2, zzj zzjVar) throws RemoteException;

    void a(String str, DataHolder dataHolder, zzj zzjVar) throws RemoteException;

    void a(String str, zzf zzfVar) throws RemoteException;

    void a(String str, zzj zzjVar) throws RemoteException;

    void a(String str, zzk zzkVar) throws RemoteException;

    void a(String str, zzl zzlVar) throws RemoteException;

    void a(String str, zzn zznVar) throws RemoteException;

    void a(String str, zzo zzoVar) throws RemoteException;

    void a(String str, String str2, DataHolder dataHolder, zzj zzjVar) throws RemoteException;

    void a(String str, String str2, zzf zzfVar) throws RemoteException;

    void a(String str, String str2, zzg zzgVar) throws RemoteException;

    void a(String str, String str2, zzj zzjVar) throws RemoteException;

    void a(boolean z, zzo zzoVar) throws RemoteException;

    void b(zzc zzcVar) throws RemoteException;

    void b(zzj zzjVar) throws RemoteException;

    void b(zzl zzlVar) throws RemoteException;

    void b(zzo zzoVar) throws RemoteException;

    void b(String str, zzf zzfVar) throws RemoteException;

    void b(String str, zzl zzlVar) throws RemoteException;

    void b(String str, zzn zznVar) throws RemoteException;

    void b(String str, zzo zzoVar) throws RemoteException;

    void b(String str, String str2, zzf zzfVar) throws RemoteException;

    void c(zzc zzcVar) throws RemoteException;

    void c(zzo zzoVar) throws RemoteException;

    void c(String str, zzl zzlVar) throws RemoteException;

    void d(zzc zzcVar) throws RemoteException;

    void e(zzc zzcVar) throws RemoteException;
}
