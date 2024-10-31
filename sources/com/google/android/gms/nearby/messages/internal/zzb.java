package com.google.android.gms.nearby.messages.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface zzb extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzb {

        /* loaded from: classes.dex */
        private static class a implements zzb {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2122a;

            a(IBinder iBinder) {
                this.f2122a = iBinder;
            }

            @Override // com.google.android.gms.nearby.messages.internal.zzb
            public void a(MessageWrapper messageWrapper) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    if (messageWrapper != null) {
                        obtain.writeInt(1);
                        messageWrapper.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2122a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2122a;
            }

            @Override // com.google.android.gms.nearby.messages.internal.zzb
            public void b(MessageWrapper messageWrapper) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    if (messageWrapper != null) {
                        obtain.writeInt(1);
                        messageWrapper.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2122a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.nearby.messages.internal.IMessageListener");
        }

        public static zzb a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzb)) ? new a(iBinder) : (zzb) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    a(parcel.readInt() != 0 ? MessageWrapper.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    b(parcel.readInt() != 0 ? MessageWrapper.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.nearby.messages.internal.IMessageListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(MessageWrapper messageWrapper) throws RemoteException;

    void b(MessageWrapper messageWrapper) throws RemoteException;
}
