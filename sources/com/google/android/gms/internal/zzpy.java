package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzpx;

/* loaded from: classes2.dex */
public interface zzpy extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class zza extends Binder implements zzpy {

        /* loaded from: classes2.dex */
        private static class a implements zzpy {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1814a;

            a(IBinder iBinder) {
                this.f1814a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1814a;
            }

            @Override // com.google.android.gms.internal.zzpy
            public void zza(zzpx zzpxVar, Uri uri, Bundle bundle, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.panorama.internal.IPanoramaService");
                    obtain.writeStrongBinder(zzpxVar != null ? zzpxVar.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(z ? 1 : 0);
                    this.f1814a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzpy zzdx(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.panorama.internal.IPanoramaService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzpy)) ? new a(iBinder) : (zzpy) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.panorama.internal.IPanoramaService");
                    zza(zzpx.zza.zzdw(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.panorama.internal.IPanoramaService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzpx zzpxVar, Uri uri, Bundle bundle, boolean z) throws RemoteException;
}
