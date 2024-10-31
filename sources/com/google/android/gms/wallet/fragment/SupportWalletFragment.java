package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v4.app.l;
import android.support.v4.app.p;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.dynamic.zzh;
import com.google.android.gms.internal.zzrh;
import com.google.android.gms.internal.zzri;
import com.google.android.gms.internal.zzrp;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

/* loaded from: classes.dex */
public final class SupportWalletFragment extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private b f2303a;
    private boolean b = false;
    private final zzh c = zzh.a(this);
    private final c d = new c();
    private a e = new a(this);
    private final Fragment f = this;
    private WalletFragmentOptions g;
    private WalletFragmentInitParams h;
    private MaskedWalletRequest i;
    private MaskedWallet j;
    private Boolean k;

    /* loaded from: classes.dex */
    public interface OnStateChangedListener {
        void a(SupportWalletFragment supportWalletFragment, int i, int i2, Bundle bundle);
    }

    /* loaded from: classes.dex */
    static class a extends zzri.zza {

        /* renamed from: a, reason: collision with root package name */
        private OnStateChangedListener f2304a;
        private final SupportWalletFragment b;

        a(SupportWalletFragment supportWalletFragment) {
            this.b = supportWalletFragment;
        }

        @Override // com.google.android.gms.internal.zzri
        public void zza(int i, int i2, Bundle bundle) {
            if (this.f2304a != null) {
                this.f2304a.a(this.b, i, i2, bundle);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class b implements LifecycleDelegate {

        /* renamed from: a, reason: collision with root package name */
        private final zzrh f2305a;

        private b(zzrh zzrhVar) {
            this.f2305a = zzrhVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2, Intent intent) {
            try {
                this.f2305a.onActivityResult(i, i2, intent);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(MaskedWallet maskedWallet) {
            try {
                this.f2305a.updateMaskedWallet(maskedWallet);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(MaskedWalletRequest maskedWalletRequest) {
            try {
                this.f2305a.updateMaskedWalletRequest(maskedWalletRequest);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(WalletFragmentInitParams walletFragmentInitParams) {
            try {
                this.f2305a.initialize(walletFragmentInitParams);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z) {
            try {
                this.f2305a.setEnabled(z);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) zze.a(this.f2305a.onCreateView(zze.a(layoutInflater), zze.a(viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void a() {
            try {
                this.f2305a.onStart();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void a(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.f2305a.zza(zze.a(activity), (WalletFragmentOptions) bundle.getParcelable("extraWalletFragmentOptions"), bundle2);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void a(Bundle bundle) {
            try {
                this.f2305a.onCreate(bundle);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void b() {
            try {
                this.f2305a.onResume();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void b(Bundle bundle) {
            try {
                this.f2305a.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void c() {
            try {
                this.f2305a.onPause();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void d() {
            try {
                this.f2305a.onStop();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void e() {
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void f() {
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void g() {
        }
    }

    /* loaded from: classes.dex */
    private class c extends com.google.android.gms.dynamic.zza<b> implements View.OnClickListener {
        private c() {
        }

        @Override // com.google.android.gms.dynamic.zza
        protected void a(FrameLayout frameLayout) {
            WalletFragmentStyle c;
            Button button = new Button(SupportWalletFragment.this.f.getActivity());
            button.setText(R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (SupportWalletFragment.this.g != null && (c = SupportWalletFragment.this.g.c()) != null) {
                DisplayMetrics displayMetrics = SupportWalletFragment.this.f.getResources().getDisplayMetrics();
                i = c.a("buyButtonWidth", displayMetrics, -1);
                i2 = c.a("buyButtonHeight", displayMetrics, -2);
            }
            button.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        @Override // com.google.android.gms.dynamic.zza
        protected void a(zzf<b> zzfVar) {
            l activity = SupportWalletFragment.this.f.getActivity();
            if (SupportWalletFragment.this.f2303a == null && SupportWalletFragment.this.b && activity != null) {
                try {
                    zzrh zza = zzrp.zza(activity, SupportWalletFragment.this.c, SupportWalletFragment.this.g, SupportWalletFragment.this.e);
                    SupportWalletFragment.this.f2303a = new b(zza);
                    SupportWalletFragment.this.g = null;
                    zzfVar.a(SupportWalletFragment.this.f2303a);
                    if (SupportWalletFragment.this.h != null) {
                        SupportWalletFragment.this.f2303a.a(SupportWalletFragment.this.h);
                        SupportWalletFragment.this.h = null;
                    }
                    if (SupportWalletFragment.this.i != null) {
                        SupportWalletFragment.this.f2303a.a(SupportWalletFragment.this.i);
                        SupportWalletFragment.this.i = null;
                    }
                    if (SupportWalletFragment.this.j != null) {
                        SupportWalletFragment.this.f2303a.a(SupportWalletFragment.this.j);
                        SupportWalletFragment.this.j = null;
                    }
                    if (SupportWalletFragment.this.k != null) {
                        SupportWalletFragment.this.f2303a.a(SupportWalletFragment.this.k.booleanValue());
                        SupportWalletFragment.this.k = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l activity = SupportWalletFragment.this.f.getActivity();
            GooglePlayServicesUtil.b(GooglePlayServicesUtil.a(activity), activity, -1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.f2303a != null) {
            this.f2303a.a(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        WalletFragmentOptions walletFragmentOptions;
        super.onCreate(bundle);
        if (bundle != null) {
            bundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) bundle.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.h != null) {
                    Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
                }
                this.h = walletFragmentInitParams;
            }
            if (this.i == null) {
                this.i = (MaskedWalletRequest) bundle.getParcelable("maskedWalletRequest");
            }
            if (this.j == null) {
                this.j = (MaskedWallet) bundle.getParcelable("maskedWallet");
            }
            if (bundle.containsKey("walletFragmentOptions")) {
                this.g = (WalletFragmentOptions) bundle.getParcelable("walletFragmentOptions");
            }
            if (bundle.containsKey("enabled")) {
                this.k = Boolean.valueOf(bundle.getBoolean("enabled"));
            }
        } else if (this.f.getArguments() != null && (walletFragmentOptions = (WalletFragmentOptions) this.f.getArguments().getParcelable("extraWalletFragmentOptions")) != null) {
            walletFragmentOptions.a(this.f.getActivity());
            this.g = walletFragmentOptions;
        }
        this.b = true;
        this.d.a(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.d.a(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.b = false;
    }

    @Override // android.support.v4.app.Fragment
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        if (this.g == null) {
            this.g = WalletFragmentOptions.a(activity, attributeSet);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("attrKeyWalletFragmentOptions", this.g);
        this.d.a(activity, bundle2, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.d.d();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.d.c();
        p supportFragmentManager = this.f.getActivity().getSupportFragmentManager();
        Fragment a2 = supportFragmentManager.a("GooglePlayServicesErrorDialog");
        if (a2 != null) {
            supportFragmentManager.a().a(a2).a();
            GooglePlayServicesUtil.b(GooglePlayServicesUtil.a(this.f.getActivity()), this.f.getActivity(), -1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.d.b(bundle);
        if (this.h != null) {
            bundle.putParcelable("walletFragmentInitParams", this.h);
            this.h = null;
        }
        if (this.i != null) {
            bundle.putParcelable("maskedWalletRequest", this.i);
            this.i = null;
        }
        if (this.j != null) {
            bundle.putParcelable("maskedWallet", this.j);
            this.j = null;
        }
        if (this.g != null) {
            bundle.putParcelable("walletFragmentOptions", this.g);
            this.g = null;
        }
        if (this.k != null) {
            bundle.putBoolean("enabled", this.k.booleanValue());
            this.k = null;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.d.b();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.d.e();
    }
}
