package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.zzf;

/* loaded from: classes.dex */
public interface zzm extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzm {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class a implements zzm {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1959a;

            a(IBinder iBinder) {
                this.f1959a = iBinder;
            }

            @Override // com.google.android.gms.maps.internal.zzm
            public boolean a(com.google.android.gms.maps.model.internal.zzf zzfVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerClickListener");
                    obtain.writeStrongBinder(zzfVar != null ? zzfVar.asBinder() : null);
                    this.f1959a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1959a;
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerClickListener");
        }

        public static zzm a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzm)) ? new a(iBinder) : (zzm) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
                    boolean a2 = a(zzf.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(a2 ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.IOnMarkerClickListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean a(com.google.android.gms.maps.model.internal.zzf zzfVar) throws RemoteException;
}
