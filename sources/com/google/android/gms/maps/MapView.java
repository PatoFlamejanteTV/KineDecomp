package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class MapView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final b f1914a;
    private GoogleMap b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements MapLifecycleDelegate {

        /* renamed from: a, reason: collision with root package name */
        private final ViewGroup f1915a;
        private final IMapViewDelegate b;
        private View c;

        public a(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
            this.b = (IMapViewDelegate) zzx.a(iMapViewDelegate);
            this.f1915a = (ViewGroup) zzx.a(viewGroup);
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void a() {
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void a(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void a(Bundle bundle) {
            try {
                this.b.a(bundle);
                this.c = (View) zze.a(this.b.f());
                this.f1915a.removeAllViews();
                this.f1915a.addView(this.c);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void a(OnMapReadyCallback onMapReadyCallback) {
            try {
                this.b.a(new com.google.android.gms.maps.b(this, onMapReadyCallback));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void b() {
            try {
                this.b.b();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void b(Bundle bundle) {
            try {
                this.b.b(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void c() {
            try {
                this.b.c();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void d() {
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void e() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void f() {
            try {
                this.b.d();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void g() {
            try {
                this.b.e();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public IMapViewDelegate h() {
            return this.b;
        }
    }

    /* loaded from: classes.dex */
    static class b extends com.google.android.gms.dynamic.zza<a> {

        /* renamed from: a, reason: collision with root package name */
        protected zzf<a> f1916a;
        private final ViewGroup b;
        private final Context c;
        private final GoogleMapOptions d;
        private final List<OnMapReadyCallback> e;

        @Override // com.google.android.gms.dynamic.zza
        protected void a(zzf<a> zzfVar) {
            this.f1916a = zzfVar;
            i();
        }

        public void i() {
            if (this.f1916a == null || a() != null) {
                return;
            }
            try {
                MapsInitializer.a(this.c);
                IMapViewDelegate a2 = zzy.a(this.c).a(zze.a(this.c), this.d);
                if (a2 == null) {
                    return;
                }
                this.f1916a.a(new a(this.b, a2));
                Iterator<OnMapReadyCallback> it = this.e.iterator();
                while (it.hasNext()) {
                    a().a(it.next());
                }
                this.e.clear();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            } catch (GooglePlayServicesNotAvailableException e2) {
            }
        }
    }

    @Deprecated
    public final GoogleMap getMap() {
        if (this.b != null) {
            return this.b;
        }
        this.f1914a.i();
        if (this.f1914a.a() == null) {
            return null;
        }
        try {
            this.b = new GoogleMap(this.f1914a.a().h().a());
            return this.b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
