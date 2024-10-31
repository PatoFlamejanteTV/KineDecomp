package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GestureRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.internal.zzh;
import com.google.android.gms.location.internal.zzj;
import com.google.android.gms.location.zzd;
import java.util.List;

/* loaded from: classes.dex */
public interface zzi extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzi {

        /* loaded from: classes.dex */
        public static class a implements zzi {

            /* renamed from: a */
            private IBinder f1860a;

            a(IBinder iBinder) {
                this.f1860a = iBinder;
            }

            @Override // com.google.android.gms.location.internal.zzi
            public Location a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.f1860a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public Status a(GestureRequest gestureRequest, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (gestureRequest != null) {
                        obtain.writeInt(1);
                        gestureRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1860a.transact(60, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? Status.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public ActivityRecognitionResult a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.f1860a.transact(64, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? ActivityRecognitionResult.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void a(long j, boolean z, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeLong(j);
                    obtain.writeInt(z ? 1 : 0);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1860a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void a(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1860a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void a(PendingIntent pendingIntent, zzh zzhVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzhVar != null ? zzhVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1860a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void a(Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1860a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void a(Location location, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.f1860a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void a(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzh zzhVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (geofencingRequest != null) {
                        obtain.writeInt(1);
                        geofencingRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzhVar != null ? zzhVar.asBinder() : null);
                    this.f1860a.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void a(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1860a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void a(LocationRequest locationRequest, com.google.android.gms.location.zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.f1860a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void a(LocationRequest locationRequest, com.google.android.gms.location.zzd zzdVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1860a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void a(LocationSettingsRequest locationSettingsRequest, zzj zzjVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationSettingsRequest != null) {
                        obtain.writeInt(1);
                        locationSettingsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1860a.transact(63, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void a(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequestInternal != null) {
                        obtain.writeInt(1);
                        locationRequestInternal.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1860a.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void a(LocationRequestInternal locationRequestInternal, com.google.android.gms.location.zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequestInternal != null) {
                        obtain.writeInt(1);
                        locationRequestInternal.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.f1860a.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void a(LocationRequestUpdateData locationRequestUpdateData) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequestUpdateData != null) {
                        obtain.writeInt(1);
                        locationRequestUpdateData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1860a.transact(59, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void a(zzh zzhVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(zzhVar != null ? zzhVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1860a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void a(com.google.android.gms.location.zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.f1860a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void a(List<ParcelableGeofence> list, PendingIntent pendingIntent, zzh zzhVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeTypedList(list);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzhVar != null ? zzhVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1860a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeInt(z ? 1 : 0);
                    this.f1860a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void a(String[] strArr, zzh zzhVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStringArray(strArr);
                    obtain.writeStrongBinder(zzhVar != null ? zzhVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1860a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1860a;
            }

            @Override // com.google.android.gms.location.internal.zzi
            public Location b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.f1860a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public Status b(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1860a.transact(65, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? Status.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public Status c(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1860a.transact(66, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? Status.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public LocationAvailability c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.f1860a.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? LocationAvailability.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public Status d(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1860a.transact(61, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? Status.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.location.internal.zzi
            public void e(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1860a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzi a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzi)) ? new a(iBinder) : (zzi) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(parcel.createTypedArrayList(ParcelableGeofence.CREATOR), parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, zzh.zza.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, zzh.zza.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(parcel.createStringArray(), zzh.zza.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(zzh.zza.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(parcel.readLong(), parcel.readInt() != 0, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    Location a2 = a();
                    parcel2.writeNoException();
                    if (a2 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    a2.writeToParcel(parcel2, 1);
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(parcel.readInt() != 0 ? LocationRequest.CREATOR.createFromParcel(parcel) : null, zzd.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(parcel.readInt() != 0 ? LocationRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(zzd.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    e(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(parcel.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(parcel.readInt() != 0 ? LocationRequest.CREATOR.createFromParcel(parcel) : null, zzd.zza.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    Location b = b(parcel.readString());
                    parcel2.writeNoException();
                    if (b == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    b.writeToParcel(parcel2, 1);
                    return true;
                case 26:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(parcel.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    LocationAvailability c = c(parcel.readString());
                    parcel2.writeNoException();
                    if (c == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    c.writeToParcel(parcel2, 1);
                    return true;
                case 52:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(parcel.readInt() != 0 ? LocationRequestInternal.CREATOR.createFromParcel(parcel) : null, zzd.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 53:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(parcel.readInt() != 0 ? LocationRequestInternal.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 57:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(parcel.readInt() != 0 ? GeofencingRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null, zzh.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 59:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(parcel.readInt() != 0 ? LocationRequestUpdateData.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 60:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    Status a3 = a(parcel.readInt() != 0 ? GestureRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (a3 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    a3.writeToParcel(parcel2, 1);
                    return true;
                case 61:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    Status d = d(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (d == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    d.writeToParcel(parcel2, 1);
                    return true;
                case 63:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    a(parcel.readInt() != 0 ? LocationSettingsRequest.CREATOR.createFromParcel(parcel) : null, zzj.zza.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 64:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    ActivityRecognitionResult a4 = a(parcel.readString());
                    parcel2.writeNoException();
                    if (a4 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    a4.writeToParcel(parcel2, 1);
                    return true;
                case 65:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    Status b2 = b(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (b2 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    b2.writeToParcel(parcel2, 1);
                    return true;
                case 66:
                    parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    Status c2 = c(parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (c2 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    c2.writeToParcel(parcel2, 1);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    Location a() throws RemoteException;

    Status a(GestureRequest gestureRequest, PendingIntent pendingIntent) throws RemoteException;

    ActivityRecognitionResult a(String str) throws RemoteException;

    void a(long j, boolean z, PendingIntent pendingIntent) throws RemoteException;

    void a(PendingIntent pendingIntent) throws RemoteException;

    void a(PendingIntent pendingIntent, zzh zzhVar, String str) throws RemoteException;

    void a(Location location) throws RemoteException;

    void a(Location location, int i) throws RemoteException;

    void a(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzh zzhVar) throws RemoteException;

    void a(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException;

    void a(LocationRequest locationRequest, com.google.android.gms.location.zzd zzdVar) throws RemoteException;

    void a(LocationRequest locationRequest, com.google.android.gms.location.zzd zzdVar, String str) throws RemoteException;

    void a(LocationSettingsRequest locationSettingsRequest, zzj zzjVar, String str) throws RemoteException;

    void a(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent) throws RemoteException;

    void a(LocationRequestInternal locationRequestInternal, com.google.android.gms.location.zzd zzdVar) throws RemoteException;

    void a(LocationRequestUpdateData locationRequestUpdateData) throws RemoteException;

    void a(zzh zzhVar, String str) throws RemoteException;

    void a(com.google.android.gms.location.zzd zzdVar) throws RemoteException;

    void a(List<ParcelableGeofence> list, PendingIntent pendingIntent, zzh zzhVar, String str) throws RemoteException;

    void a(boolean z) throws RemoteException;

    void a(String[] strArr, zzh zzhVar, String str) throws RemoteException;

    Location b(String str) throws RemoteException;

    Status b(PendingIntent pendingIntent) throws RemoteException;

    Status c(PendingIntent pendingIntent) throws RemoteException;

    LocationAvailability c(String str) throws RemoteException;

    Status d(PendingIntent pendingIntent) throws RemoteException;

    void e(PendingIntent pendingIntent) throws RemoteException;
}
