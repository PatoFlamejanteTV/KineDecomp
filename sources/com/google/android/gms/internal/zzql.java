package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.AttestationData;
import com.google.android.gms.safetynet.SafeBrowsingData;

/* loaded from: classes.dex */
public interface zzql extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzql {

        /* loaded from: classes.dex */
        private static class a implements zzql {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1816a;

            a(IBinder iBinder) {
                this.f1816a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1816a;
            }

            @Override // com.google.android.gms.internal.zzql
            public void zza(Status status, AttestationData attestationData) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (attestationData != null) {
                        obtain.writeInt(1);
                        attestationData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1816a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzql
            public void zza(Status status, SafeBrowsingData safeBrowsingData) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (safeBrowsingData != null) {
                        obtain.writeInt(1);
                        safeBrowsingData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1816a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzql
            public void zzes(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    obtain.writeString(str);
                    this.f1816a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
        }

        public static zzql zzdG(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzql)) ? new a(iBinder) : (zzql) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    zza(parcel.readInt() != 0 ? Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? AttestationData.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    zzes(parcel.readString());
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    zza(parcel.readInt() != 0 ? Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? SafeBrowsingData.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(Status status, AttestationData attestationData) throws RemoteException;

    void zza(Status status, SafeBrowsingData safeBrowsingData) throws RemoteException;

    void zzes(String str) throws RemoteException;
}
