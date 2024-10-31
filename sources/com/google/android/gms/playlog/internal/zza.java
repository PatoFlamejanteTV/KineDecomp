package com.google.android.gms.playlog.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface zza extends IInterface {

    /* renamed from: com.google.android.gms.playlog.internal.zza$zza, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0044zza extends Binder implements zza {

        /* renamed from: com.google.android.gms.playlog.internal.zza$zza$a */
        /* loaded from: classes.dex */
        private static class a implements zza {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2146a;

            a(IBinder iBinder) {
                this.f2146a = iBinder;
            }

            @Override // com.google.android.gms.playlog.internal.zza
            public void a(String str, PlayLoggerContext playLoggerContext, LogEvent logEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (playLoggerContext != null) {
                        obtain.writeInt(1);
                        playLoggerContext.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (logEvent != null) {
                        obtain.writeInt(1);
                        logEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2146a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.playlog.internal.zza
            public void a(String str, PlayLoggerContext playLoggerContext, List<LogEvent> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (playLoggerContext != null) {
                        obtain.writeInt(1);
                        playLoggerContext.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeTypedList(list);
                    this.f2146a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.playlog.internal.zza
            public void a(String str, PlayLoggerContext playLoggerContext, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (playLoggerContext != null) {
                        obtain.writeInt(1);
                        playLoggerContext.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeByteArray(bArr);
                    this.f2146a.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2146a;
            }
        }

        public static zza a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.playlog.internal.IPlayLogService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zza)) ? new a(iBinder) : (zza) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 2:
                    parcel.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    a(parcel.readString(), parcel.readInt() != 0 ? PlayLoggerContext.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? LogEvent.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    a(parcel.readString(), parcel.readInt() != 0 ? PlayLoggerContext.CREATOR.createFromParcel(parcel) : null, parcel.createTypedArrayList(LogEvent.CREATOR));
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    a(parcel.readString(), parcel.readInt() != 0 ? PlayLoggerContext.CREATOR.createFromParcel(parcel) : null, parcel.createByteArray());
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.playlog.internal.IPlayLogService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(String str, PlayLoggerContext playLoggerContext, LogEvent logEvent) throws RemoteException;

    void a(String str, PlayLoggerContext playLoggerContext, List<LogEvent> list) throws RemoteException;

    void a(String str, PlayLoggerContext playLoggerContext, byte[] bArr) throws RemoteException;
}
