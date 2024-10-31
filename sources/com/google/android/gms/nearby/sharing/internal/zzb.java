package com.google.android.gms.nearby.sharing.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.sharing.SharedContent;
import java.util.List;

/* loaded from: classes.dex */
public interface zzb extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzb {

        /* loaded from: classes.dex */
        private static class a implements zzb {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2139a;

            a(IBinder iBinder) {
                this.f2139a = iBinder;
            }

            @Override // com.google.android.gms.nearby.sharing.internal.zzb
            public List<SharedContent> a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.IContentProvider");
                    this.f2139a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(SharedContent.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2139a;
            }
        }

        public static zzb a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.sharing.internal.IContentProvider");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzb)) ? new a(iBinder) : (zzb) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 2:
                    parcel.enforceInterface("com.google.android.gms.nearby.sharing.internal.IContentProvider");
                    List<SharedContent> a2 = a();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(a2);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.nearby.sharing.internal.IContentProvider");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    List<SharedContent> a() throws RemoteException;
}
