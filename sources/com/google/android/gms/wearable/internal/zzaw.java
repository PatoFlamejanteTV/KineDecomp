package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import java.util.List;

/* loaded from: classes.dex */
public interface zzaw extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzaw {

        /* loaded from: classes.dex */
        private static class a implements zzaw {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2385a;

            a(IBinder iBinder) {
                this.f2385a = iBinder;
            }

            @Override // com.google.android.gms.wearable.internal.zzaw
            public void a(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2385a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzaw
            public void a(AmsEntityUpdateParcelable amsEntityUpdateParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (amsEntityUpdateParcelable != null) {
                        obtain.writeInt(1);
                        amsEntityUpdateParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2385a.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzaw
            public void a(AncsNotificationParcelable ancsNotificationParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (ancsNotificationParcelable != null) {
                        obtain.writeInt(1);
                        ancsNotificationParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2385a.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzaw
            public void a(CapabilityInfoParcelable capabilityInfoParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (capabilityInfoParcelable != null) {
                        obtain.writeInt(1);
                        capabilityInfoParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2385a.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzaw
            public void a(ChannelEventParcelable channelEventParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (channelEventParcelable != null) {
                        obtain.writeInt(1);
                        channelEventParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2385a.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzaw
            public void a(MessageEventParcelable messageEventParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (messageEventParcelable != null) {
                        obtain.writeInt(1);
                        messageEventParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2385a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzaw
            public void a(NodeParcelable nodeParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (nodeParcelable != null) {
                        obtain.writeInt(1);
                        nodeParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2385a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzaw
            public void a(List<NodeParcelable> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    obtain.writeTypedList(list);
                    this.f2385a.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2385a;
            }

            @Override // com.google.android.gms.wearable.internal.zzaw
            public void b(NodeParcelable nodeParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (nodeParcelable != null) {
                        obtain.writeInt(1);
                        nodeParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2385a.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.wearable.internal.IWearableListener");
        }

        public static zzaw a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaw)) ? new a(iBinder) : (zzaw) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    a(parcel.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    a(parcel.readInt() != 0 ? MessageEventParcelable.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    a(parcel.readInt() != 0 ? NodeParcelable.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    b(parcel.readInt() != 0 ? NodeParcelable.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    a(parcel.createTypedArrayList(NodeParcelable.CREATOR));
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    a(parcel.readInt() != 0 ? AncsNotificationParcelable.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    a(parcel.readInt() != 0 ? ChannelEventParcelable.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    a(parcel.readInt() != 0 ? CapabilityInfoParcelable.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    a(parcel.readInt() != 0 ? AmsEntityUpdateParcelable.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.wearable.internal.IWearableListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(DataHolder dataHolder) throws RemoteException;

    void a(AmsEntityUpdateParcelable amsEntityUpdateParcelable) throws RemoteException;

    void a(AncsNotificationParcelable ancsNotificationParcelable) throws RemoteException;

    void a(CapabilityInfoParcelable capabilityInfoParcelable) throws RemoteException;

    void a(ChannelEventParcelable channelEventParcelable) throws RemoteException;

    void a(MessageEventParcelable messageEventParcelable) throws RemoteException;

    void a(NodeParcelable nodeParcelable) throws RemoteException;

    void a(List<NodeParcelable> list) throws RemoteException;

    void b(NodeParcelable nodeParcelable) throws RemoteException;
}
