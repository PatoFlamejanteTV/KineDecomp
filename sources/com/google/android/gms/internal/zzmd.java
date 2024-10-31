package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzmc;

/* loaded from: classes.dex */
public interface zzmd extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzmd {

        /* loaded from: classes.dex */
        private static class a implements zzmd {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1769a;

            a(IBinder iBinder) {
                this.f1769a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1769a;
            }

            @Override // com.google.android.gms.internal.zzmd
            public void zza(zzmc zzmcVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonService");
                    obtain.writeStrongBinder(zzmcVar != null ? zzmcVar.asBinder() : null);
                    this.f1769a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzmd zzaQ(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzmd)) ? new a(iBinder) : (zzmd) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.common.internal.service.ICommonService");
                    zza(zzmc.zza.zzaP(parcel.readStrongBinder()));
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.common.internal.service.ICommonService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzmc zzmcVar) throws RemoteException;
}
