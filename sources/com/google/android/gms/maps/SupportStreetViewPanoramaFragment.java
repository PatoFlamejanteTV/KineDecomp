package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class SupportStreetViewPanoramaFragment extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private final b f1929a = new b(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements StreetViewLifecycleDelegate {

        /* renamed from: a, reason: collision with root package name */
        private final Fragment f1930a;
        private final IStreetViewPanoramaFragmentDelegate b;

        public a(Fragment fragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
            this.b = (IStreetViewPanoramaFragmentDelegate) zzx.a(iStreetViewPanoramaFragmentDelegate);
            this.f1930a = (Fragment) zzx.a(fragment);
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) zze.a(this.b.a(zze.a(layoutInflater), zze.a(viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void a() {
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void a(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.b.a(zze.a(activity), (StreetViewPanoramaOptions) null, bundle2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void a(Bundle bundle) {
            if (bundle == null) {
                try {
                    bundle = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.f1930a.getArguments();
            if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                com.google.android.gms.maps.internal.zzx.a(bundle, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
            }
            this.b.a(bundle);
        }

        public void a(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            try {
                this.b.a(new f(this, onStreetViewPanoramaReadyCallback));
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
            try {
                this.b.d();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void f() {
            try {
                this.b.e();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void g() {
            try {
                this.b.f();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    static class b extends com.google.android.gms.dynamic.zza<a> {

        /* renamed from: a, reason: collision with root package name */
        protected zzf<a> f1931a;
        private final Fragment b;
        private Activity c;
        private final List<OnStreetViewPanoramaReadyCallback> d = new ArrayList();

        b(Fragment fragment) {
            this.b = fragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Activity activity) {
            this.c = activity;
            i();
        }

        @Override // com.google.android.gms.dynamic.zza
        protected void a(zzf<a> zzfVar) {
            this.f1931a = zzfVar;
            i();
        }

        public void i() {
            if (this.c == null || this.f1931a == null || a() != null) {
                return;
            }
            try {
                MapsInitializer.a(this.c);
                this.f1931a.a(new a(this.b, zzy.a(this.c).c(zze.a(this.c))));
                Iterator<OnStreetViewPanoramaReadyCallback> it = this.d.iterator();
                while (it.hasNext()) {
                    a().a(it.next());
                }
                this.d.clear();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            } catch (GooglePlayServicesNotAvailableException e2) {
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f1929a.a(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1929a.a(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f1929a.a(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.f1929a.g();
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        this.f1929a.f();
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.f1929a.a(activity);
        this.f1929a.a(activity, new Bundle(), bundle);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.f1929a.h();
        super.onLowMemory();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        this.f1929a.d();
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f1929a.c();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f1929a.b(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
