package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.internal.ILocationSourceDelegate;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.internal.zzb;
import com.google.android.gms.maps.internal.zzd;
import com.google.android.gms.maps.internal.zze;
import com.google.android.gms.maps.internal.zzf;
import com.google.android.gms.maps.internal.zzg;
import com.google.android.gms.maps.internal.zzi;
import com.google.android.gms.maps.internal.zzj;
import com.google.android.gms.maps.internal.zzk;
import com.google.android.gms.maps.internal.zzl;
import com.google.android.gms.maps.internal.zzm;
import com.google.android.gms.maps.internal.zzn;
import com.google.android.gms.maps.internal.zzo;
import com.google.android.gms.maps.internal.zzp;
import com.google.android.gms.maps.internal.zzq;
import com.google.android.gms.maps.internal.zzw;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import com.google.android.gms.maps.model.internal.zzb;
import com.google.android.gms.maps.model.internal.zzc;
import com.google.android.gms.maps.model.internal.zzd;
import com.google.android.gms.maps.model.internal.zzf;
import com.google.android.gms.maps.model.internal.zzg;
import com.google.android.gms.maps.model.internal.zzh;

/* loaded from: classes.dex */
public interface IGoogleMapDelegate extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements IGoogleMapDelegate {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class a implements IGoogleMapDelegate {

            /* renamed from: a */
            private IBinder f1939a;

            a(IBinder iBinder) {
                this.f1939a = iBinder;
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public CameraPosition a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.f1939a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? CameraPosition.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public IPolylineDelegate a(PolylineOptions polylineOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (polylineOptions != null) {
                        obtain.writeInt(1);
                        polylineOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1939a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return IPolylineDelegate.zza.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public com.google.android.gms.maps.model.internal.zzb a(CircleOptions circleOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (circleOptions != null) {
                        obtain.writeInt(1);
                        circleOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1939a.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzb.zza.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public com.google.android.gms.maps.model.internal.zzc a(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (groundOverlayOptions != null) {
                        obtain.writeInt(1);
                        groundOverlayOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1939a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzc.zza.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public com.google.android.gms.maps.model.internal.zzf a(MarkerOptions markerOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (markerOptions != null) {
                        obtain.writeInt(1);
                        markerOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1939a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzf.zza.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public com.google.android.gms.maps.model.internal.zzg a(PolygonOptions polygonOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (polygonOptions != null) {
                        obtain.writeInt(1);
                        polygonOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1939a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzg.zza.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public com.google.android.gms.maps.model.internal.zzh a(TileOverlayOptions tileOverlayOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (tileOverlayOptions != null) {
                        obtain.writeInt(1);
                        tileOverlayOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1939a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzh.zza.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeInt(i);
                    this.f1939a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void a(int i, int i2, int i3, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    this.f1939a.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void a(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1939a.transact(54, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void a(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.f1939a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void a(com.google.android.gms.dynamic.zzd zzdVar, int i, zzb zzbVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(zzbVar != null ? zzbVar.asBinder() : null);
                    this.f1939a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void a(com.google.android.gms.dynamic.zzd zzdVar, zzb zzbVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    obtain.writeStrongBinder(zzbVar != null ? zzbVar.asBinder() : null);
                    this.f1939a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void a(ILocationSourceDelegate iLocationSourceDelegate) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(iLocationSourceDelegate != null ? iLocationSourceDelegate.asBinder() : null);
                    this.f1939a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void a(zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.f1939a.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void a(zze zzeVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(zzeVar != null ? zzeVar.asBinder() : null);
                    this.f1939a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void a(zzf zzfVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(zzfVar != null ? zzfVar.asBinder() : null);
                    this.f1939a.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void a(zzg zzgVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    this.f1939a.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void a(zzi zziVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(zziVar != null ? zziVar.asBinder() : null);
                    this.f1939a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void a(zzj zzjVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(zzjVar != null ? zzjVar.asBinder() : null);
                    this.f1939a.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void a(zzk zzkVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(zzkVar != null ? zzkVar.asBinder() : null);
                    this.f1939a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void a(zzl zzlVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(zzlVar != null ? zzlVar.asBinder() : null);
                    this.f1939a.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void a(zzm zzmVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(zzmVar != null ? zzmVar.asBinder() : null);
                    this.f1939a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void a(zzn zznVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(zznVar != null ? zznVar.asBinder() : null);
                    this.f1939a.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void a(zzo zzoVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(zzoVar != null ? zzoVar.asBinder() : null);
                    this.f1939a.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void a(zzp zzpVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(zzpVar != null ? zzpVar.asBinder() : null);
                    this.f1939a.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void a(zzq zzqVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(zzqVar != null ? zzqVar.asBinder() : null);
                    this.f1939a.transact(80, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void a(zzw zzwVar, com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(zzwVar != null ? zzwVar.asBinder() : null);
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.f1939a.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeString(str);
                    this.f1939a.transact(61, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeInt(z ? 1 : 0);
                    this.f1939a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1939a;
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public float b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.f1939a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void b(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1939a.transact(60, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void b(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    this.f1939a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public boolean b(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeInt(z ? 1 : 0);
                    this.f1939a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public float c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.f1939a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void c(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1939a.transact(81, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void c(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeInt(z ? 1 : 0);
                    this.f1939a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.f1939a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void d(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    obtain.writeInt(z ? 1 : 0);
                    this.f1939a.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.f1939a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public int f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.f1939a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public boolean g() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.f1939a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public boolean h() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.f1939a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public boolean i() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.f1939a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public Location j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.f1939a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public IUiSettingsDelegate k() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.f1939a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                    return IUiSettingsDelegate.zza.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public IProjectionDelegate l() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.f1939a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    return IProjectionDelegate.zza.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public boolean m() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.f1939a.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public com.google.android.gms.maps.model.internal.zzd n() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.f1939a.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzd.zza.a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void o() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.f1939a.transact(55, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void p() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.f1939a.transact(56, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void q() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.f1939a.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void r() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.f1939a.transact(58, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public boolean s() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.f1939a.transact(59, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.maps.internal.IGoogleMapDelegate
            public void t() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.f1939a.transact(82, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static IGoogleMapDelegate a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGoogleMapDelegate)) ? new a(iBinder) : (IGoogleMapDelegate) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    CameraPosition a2 = a();
                    parcel2.writeNoException();
                    if (a2 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    a2.writeToParcel(parcel2, 1);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    float b = b();
                    parcel2.writeNoException();
                    parcel2.writeFloat(b);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    float c = c();
                    parcel2.writeNoException();
                    parcel2.writeFloat(c);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    a(zzd.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    b(zzd.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    a(zzd.zza.a(parcel.readStrongBinder()), zzb.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    a(zzd.zza.a(parcel.readStrongBinder()), parcel.readInt(), zzb.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    d();
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IPolylineDelegate a3 = a(parcel.readInt() != 0 ? PolylineOptions.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a3 != null ? a3.asBinder() : null);
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    com.google.android.gms.maps.model.internal.zzg a4 = a(parcel.readInt() != 0 ? PolygonOptions.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a4 != null ? a4.asBinder() : null);
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    com.google.android.gms.maps.model.internal.zzf a5 = a(parcel.readInt() != 0 ? MarkerOptions.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a5 != null ? a5.asBinder() : null);
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    com.google.android.gms.maps.model.internal.zzc a6 = a(parcel.readInt() != 0 ? GroundOverlayOptions.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a6 != null ? a6.asBinder() : null);
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    com.google.android.gms.maps.model.internal.zzh a7 = a(parcel.readInt() != 0 ? TileOverlayOptions.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a7 != null ? a7.asBinder() : null);
                    return true;
                case 14:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    e();
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    int f = f();
                    parcel2.writeNoException();
                    parcel2.writeInt(f);
                    return true;
                case 16:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    boolean g = g();
                    parcel2.writeNoException();
                    parcel2.writeInt(g ? 1 : 0);
                    return true;
                case 18:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    boolean h = h();
                    parcel2.writeNoException();
                    parcel2.writeInt(h ? 1 : 0);
                    return true;
                case 20:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    boolean b2 = b(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(b2 ? 1 : 0);
                    return true;
                case 21:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    boolean i3 = i();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3 ? 1 : 0);
                    return true;
                case 22:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    c(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    Location j = j();
                    parcel2.writeNoException();
                    if (j == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    j.writeToParcel(parcel2, 1);
                    return true;
                case 24:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    a(ILocationSourceDelegate.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IUiSettingsDelegate k = k();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(k != null ? k.asBinder() : null);
                    return true;
                case 26:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IProjectionDelegate l = l();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(l != null ? l.asBinder() : null);
                    return true;
                case 27:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    a(zze.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    a(zzi.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 29:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    a(zzk.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 30:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    a(zzm.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    a(zzn.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    a(zzg.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    a(zzd.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    com.google.android.gms.maps.model.internal.zzb a8 = a(parcel.readInt() != 0 ? CircleOptions.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a8 != null ? a8.asBinder() : null);
                    return true;
                case 36:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    a(zzp.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    a(zzo.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 38:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    a(zzw.zza.a(parcel.readStrongBinder()), zzd.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 39:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 40:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    boolean m = m();
                    parcel2.writeNoException();
                    parcel2.writeInt(m ? 1 : 0);
                    return true;
                case 41:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    d(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    a(zzj.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    com.google.android.gms.maps.model.internal.zzd n = n();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(n != null ? n.asBinder() : null);
                    return true;
                case 45:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    a(zzf.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 53:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    a(zzl.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 54:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 55:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    o();
                    parcel2.writeNoException();
                    return true;
                case 56:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    p();
                    parcel2.writeNoException();
                    return true;
                case 57:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    q();
                    parcel2.writeNoException();
                    return true;
                case 58:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    r();
                    parcel2.writeNoException();
                    return true;
                case 59:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    boolean s = s();
                    parcel2.writeNoException();
                    parcel2.writeInt(s ? 1 : 0);
                    return true;
                case 60:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                    b(bundle);
                    parcel2.writeNoException();
                    if (bundle == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    bundle.writeToParcel(parcel2, 1);
                    return true;
                case 61:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    a(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 80:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    a(zzq.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 81:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    c(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 82:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    t();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    CameraPosition a() throws RemoteException;

    IPolylineDelegate a(PolylineOptions polylineOptions) throws RemoteException;

    com.google.android.gms.maps.model.internal.zzb a(CircleOptions circleOptions) throws RemoteException;

    com.google.android.gms.maps.model.internal.zzc a(GroundOverlayOptions groundOverlayOptions) throws RemoteException;

    com.google.android.gms.maps.model.internal.zzf a(MarkerOptions markerOptions) throws RemoteException;

    com.google.android.gms.maps.model.internal.zzg a(PolygonOptions polygonOptions) throws RemoteException;

    com.google.android.gms.maps.model.internal.zzh a(TileOverlayOptions tileOverlayOptions) throws RemoteException;

    void a(int i) throws RemoteException;

    void a(int i, int i2, int i3, int i4) throws RemoteException;

    void a(Bundle bundle) throws RemoteException;

    void a(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException;

    void a(com.google.android.gms.dynamic.zzd zzdVar, int i, zzb zzbVar) throws RemoteException;

    void a(com.google.android.gms.dynamic.zzd zzdVar, zzb zzbVar) throws RemoteException;

    void a(ILocationSourceDelegate iLocationSourceDelegate) throws RemoteException;

    void a(zzd zzdVar) throws RemoteException;

    void a(zze zzeVar) throws RemoteException;

    void a(zzf zzfVar) throws RemoteException;

    void a(zzg zzgVar) throws RemoteException;

    void a(zzi zziVar) throws RemoteException;

    void a(zzj zzjVar) throws RemoteException;

    void a(zzk zzkVar) throws RemoteException;

    void a(zzl zzlVar) throws RemoteException;

    void a(zzm zzmVar) throws RemoteException;

    void a(zzn zznVar) throws RemoteException;

    void a(zzo zzoVar) throws RemoteException;

    void a(zzp zzpVar) throws RemoteException;

    void a(zzq zzqVar) throws RemoteException;

    void a(zzw zzwVar, com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException;

    void a(String str) throws RemoteException;

    void a(boolean z) throws RemoteException;

    float b() throws RemoteException;

    void b(Bundle bundle) throws RemoteException;

    void b(com.google.android.gms.dynamic.zzd zzdVar) throws RemoteException;

    boolean b(boolean z) throws RemoteException;

    float c() throws RemoteException;

    void c(Bundle bundle) throws RemoteException;

    void c(boolean z) throws RemoteException;

    void d() throws RemoteException;

    void d(boolean z) throws RemoteException;

    void e() throws RemoteException;

    int f() throws RemoteException;

    boolean g() throws RemoteException;

    boolean h() throws RemoteException;

    boolean i() throws RemoteException;

    Location j() throws RemoteException;

    IUiSettingsDelegate k() throws RemoteException;

    IProjectionDelegate l() throws RemoteException;

    boolean m() throws RemoteException;

    com.google.android.gms.maps.model.internal.zzd n() throws RemoteException;

    void o() throws RemoteException;

    void p() throws RemoteException;

    void q() throws RemoteException;

    void r() throws RemoteException;

    boolean s() throws RemoteException;

    void t() throws RemoteException;
}
