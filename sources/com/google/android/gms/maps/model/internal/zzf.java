package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.model.LatLng;

/* loaded from: classes.dex */
public interface zzf extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzf {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class a implements zzf {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2007a;

            a(IBinder iBinder) {
                this.f2007a = iBinder;
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public void a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.f2007a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public void a(float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    obtain.writeFloat(f);
                    this.f2007a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public void a(float f, float f2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    obtain.writeFloat(f);
                    obtain.writeFloat(f2);
                    this.f2007a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public void a(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.f2007a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public void a(LatLng latLng) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    if (latLng != null) {
                        obtain.writeInt(1);
                        latLng.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2007a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    obtain.writeString(str);
                    this.f2007a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    obtain.writeInt(z ? 1 : 0);
                    this.f2007a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public boolean a(zzf zzfVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    obtain.writeStrongBinder(zzfVar != null ? zzfVar.asBinder() : null);
                    this.f2007a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2007a;
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public String b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.f2007a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public void b(float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    obtain.writeFloat(f);
                    this.f2007a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public void b(float f, float f2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    obtain.writeFloat(f);
                    obtain.writeFloat(f2);
                    this.f2007a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public void b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    obtain.writeString(str);
                    this.f2007a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public void b(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    obtain.writeInt(z ? 1 : 0);
                    this.f2007a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public LatLng c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.f2007a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? LatLng.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public void c(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    obtain.writeInt(z ? 1 : 0);
                    this.f2007a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public String d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.f2007a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public String e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.f2007a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public boolean f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.f2007a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public void g() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.f2007a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public void h() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.f2007a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public boolean i() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.f2007a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public boolean j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.f2007a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public int k() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.f2007a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public boolean l() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.f2007a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public float m() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.f2007a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.model.internal.zzf
            public float n() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    this.f2007a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzf a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzf)) ? new a(iBinder) : (zzf) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    a();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    String b = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    a(parcel.readInt() != 0 ? LatLng.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    LatLng c = c();
                    parcel2.writeNoException();
                    if (c == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    c.writeToParcel(parcel2, 1);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    String d = d();
                    parcel2.writeNoException();
                    parcel2.writeString(d);
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    b(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    String e = e();
                    parcel2.writeNoException();
                    parcel2.writeString(e);
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    boolean f = f();
                    parcel2.writeNoException();
                    parcel2.writeInt(f ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    g();
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    h();
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    boolean i3 = i();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3 ? 1 : 0);
                    return true;
                case 14:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    b(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    boolean j = j();
                    parcel2.writeNoException();
                    parcel2.writeInt(j ? 1 : 0);
                    return true;
                case 16:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    boolean a2 = a(a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(a2 ? 1 : 0);
                    return true;
                case 17:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    int k = k();
                    parcel2.writeNoException();
                    parcel2.writeInt(k);
                    return true;
                case 18:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    a(zzd.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    a(parcel.readFloat(), parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    c(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    boolean l = l();
                    parcel2.writeNoException();
                    parcel2.writeInt(l ? 1 : 0);
                    return true;
                case 22:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    a(parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    float m = m();
                    parcel2.writeNoException();
                    parcel2.writeFloat(m);
                    return true;
                case 24:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    b(parcel.readFloat(), parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    b(parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    float n = n();
                    parcel2.writeNoException();
                    parcel2.writeFloat(n);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.model.internal.IMarkerDelegate");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a() throws RemoteException;

    void a(float f) throws RemoteException;

    void a(float f, float f2) throws RemoteException;

    void a(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException;

    void a(LatLng latLng) throws RemoteException;

    void a(String str) throws RemoteException;

    void a(boolean z) throws RemoteException;

    boolean a(zzf zzfVar) throws RemoteException;

    String b() throws RemoteException;

    void b(float f) throws RemoteException;

    void b(float f, float f2) throws RemoteException;

    void b(String str) throws RemoteException;

    void b(boolean z) throws RemoteException;

    LatLng c() throws RemoteException;

    void c(boolean z) throws RemoteException;

    String d() throws RemoteException;

    String e() throws RemoteException;

    boolean f() throws RemoteException;

    void g() throws RemoteException;

    void h() throws RemoteException;

    boolean i() throws RemoteException;

    boolean j() throws RemoteException;

    int k() throws RemoteException;

    boolean l() throws RemoteException;

    float m() throws RemoteException;

    float n() throws RemoteException;
}
