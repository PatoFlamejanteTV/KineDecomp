package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionStopResult;

/* loaded from: classes.dex */
public interface zzoi extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzoi {

        /* loaded from: classes.dex */
        private static class a implements zzoi {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1785a;

            a(IBinder iBinder) {
                this.f1785a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1785a;
            }

            @Override // com.google.android.gms.internal.zzoi
            public void zza(SessionStopResult sessionStopResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.ISessionStopCallback");
                    if (sessionStopResult != null) {
                        obtain.writeInt(1);
                        sessionStopResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1785a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.internal.ISessionStopCallback");
        }

        public static zzoi zzbI(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.ISessionStopCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzoi)) ? new a(iBinder) : (zzoi) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.ISessionStopCallback");
                    zza(parcel.readInt() != 0 ? SessionStopResult.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.ISessionStopCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(SessionStopResult sessionStopResult) throws RemoteException;
}
