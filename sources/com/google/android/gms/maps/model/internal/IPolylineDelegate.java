package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

/* loaded from: classes.dex */
public interface IPolylineDelegate extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements IPolylineDelegate {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class a implements IPolylineDelegate {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2001a;

            a(IBinder iBinder) {
                this.f2001a = iBinder;
            }

            @Override // com.google.android.gms.maps.model.internal.IPolylineDelegate
            public void a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.f2001a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.IPolylineDelegate
            public void a(float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    obtain.writeFloat(f);
                    this.f2001a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.IPolylineDelegate
            public void a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    obtain.writeInt(i);
                    this.f2001a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.IPolylineDelegate
            public void a(List<LatLng> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    obtain.writeTypedList(list);
                    this.f2001a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.IPolylineDelegate
            public void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    obtain.writeInt(z ? 1 : 0);
                    this.f2001a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.IPolylineDelegate
            public boolean a(IPolylineDelegate iPolylineDelegate) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    obtain.writeStrongBinder(iPolylineDelegate != null ? iPolylineDelegate.asBinder() : null);
                    this.f2001a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2001a;
            }

            @Override // com.google.android.gms.maps.model.internal.IPolylineDelegate
            public String b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.f2001a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.IPolylineDelegate
            public void b(float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    obtain.writeFloat(f);
                    this.f2001a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.IPolylineDelegate
            public void b(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    obtain.writeInt(z ? 1 : 0);
                    this.f2001a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.IPolylineDelegate
            public List<LatLng> c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.f2001a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(LatLng.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.IPolylineDelegate
            public float d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.f2001a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.IPolylineDelegate
            public int e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.f2001a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.IPolylineDelegate
            public float f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.f2001a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.IPolylineDelegate
            public boolean g() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.f2001a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.IPolylineDelegate
            public boolean h() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.f2001a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.IPolylineDelegate
            public int i() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.f2001a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static IPolylineDelegate a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IPolylineDelegate)) ? new a(iBinder) : (IPolylineDelegate) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    a();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    String b = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    a(parcel.createTypedArrayList(LatLng.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    List<LatLng> c = c();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(c);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    a(parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    float d = d();
                    parcel2.writeNoException();
                    parcel2.writeFloat(d);
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    int e = e();
                    parcel2.writeNoException();
                    parcel2.writeInt(e);
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    b(parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    float f = f();
                    parcel2.writeNoException();
                    parcel2.writeFloat(f);
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    boolean g = g();
                    parcel2.writeNoException();
                    parcel2.writeInt(g ? 1 : 0);
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    b(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    boolean h = h();
                    parcel2.writeNoException();
                    parcel2.writeInt(h ? 1 : 0);
                    return true;
                case 15:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    boolean a2 = a(a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(a2 ? 1 : 0);
                    return true;
                case 16:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    int i3 = i();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a() throws RemoteException;

    void a(float f) throws RemoteException;

    void a(int i) throws RemoteException;

    void a(List<LatLng> list) throws RemoteException;

    void a(boolean z) throws RemoteException;

    boolean a(IPolylineDelegate iPolylineDelegate) throws RemoteException;

    String b() throws RemoteException;

    void b(float f) throws RemoteException;

    void b(boolean z) throws RemoteException;

    List<LatLng> c() throws RemoteException;

    float d() throws RemoteException;

    int e() throws RemoteException;

    float f() throws RemoteException;

    boolean g() throws RemoteException;

    boolean h() throws RemoteException;

    int i() throws RemoteException;
}
