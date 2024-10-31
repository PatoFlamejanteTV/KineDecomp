package com.adobe.creativesdk.foundation.internal.auth;

import android.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.adobe.creativesdk.foundation.adobeinternal.net.AdobeNetworkReachability;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class AdobeAuthContinuableEventActivity extends com.adobe.creativesdk.foundation.internal.base.a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f4746a = false;

    /* renamed from: b, reason: collision with root package name */
    Timer f4747b;

    /* renamed from: c, reason: collision with root package name */
    private b f4748c = null;

    /* renamed from: d, reason: collision with root package name */
    String f4749d = null;

    /* renamed from: e, reason: collision with root package name */
    String f4750e = "Continuablefragment";

    /* renamed from: f, reason: collision with root package name */
    private a f4751f;

    /* loaded from: classes.dex */
    public static class a extends Fragment {

        /* renamed from: a, reason: collision with root package name */
        c.a.a.a.c.a.b f4752a;

        /* renamed from: b, reason: collision with root package name */
        boolean f4753b;

        /* renamed from: g, reason: collision with root package name */
        private ProgressBar f4758g;

        /* renamed from: h, reason: collision with root package name */
        private View f4759h;
        private WebView i;
        private U j;
        private ViewGroup k;
        private String m;

        /* renamed from: c, reason: collision with root package name */
        C0023a f4754c = null;

        /* renamed from: d, reason: collision with root package name */
        boolean f4755d = false;

        /* renamed from: e, reason: collision with root package name */
        boolean f4756e = false;

        /* renamed from: f, reason: collision with root package name */
        boolean f4757f = false;
        private AdobeNetworkReachability l = null;

        /* renamed from: com.adobe.creativesdk.foundation.internal.auth.AdobeAuthContinuableEventActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0023a implements Observer {
            C0023a() {
            }

            @Override // java.util.Observer
            public void update(Observable observable, Object obj) {
                if (((com.adobe.creativesdk.foundation.internal.notification.c) obj).a() == AdobeInternalNotificationID.AdobeNetworkStatusChangeNotification) {
                    if (!a.this.l.b()) {
                        a.this.E();
                        return;
                    } else {
                        a.this.B();
                        return;
                    }
                }
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAuthContinuableActivity", "Expected a network status changed message!");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void B() {
            this.f4759h.setVisibility(0);
            C();
            this.f4753b = false;
            F();
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "AdobeAuthContinuableActivity", " _cameOnline");
        }

        private void C() {
            this.f4759h.setVisibility(4);
        }

        private void D() {
            boolean z = this.f4756e;
            if ((!z || (z && this.f4757f)) && this.f4755d) {
                return;
            }
            this.f4755d = true;
            this.i.setVisibility(4);
            URL z2 = z();
            this.f4756e = false;
            this.f4757f = false;
            this.i.loadUrl(z2.toString());
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "AdobeAuthContinuableActivity", " Loading URL" + z2.toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E() {
            this.f4755d = false;
            f(getString(com.adobe.creativesdk.foundation.auth.r.adobe_csdk_common_error_view_no_internet_connection));
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "AdobeAuthContinuableActivity", " _wentOffline");
        }

        private void F() {
            G();
            D();
        }

        private void G() {
            if (this.i == null) {
                this.i = new WebView(getActivity());
                this.i.setClipChildren(false);
                ViewCompat.setLayerType(this.i, 1, null);
                this.i.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.i.getSettings().setLoadWithOverviewMode(true);
                this.i.getSettings().setJavaScriptEnabled(true);
                this.k.addView(this.i);
                this.j = new U(this);
                this.i.setWebViewClient(this.j);
            }
        }

        private void f(String str) {
            if (str != null) {
                this.f4752a.e(str);
            }
            this.f4759h.setVisibility(0);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void A() {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "AdobeAuthContinuableActivity", " Page loaded");
            if (this.f4753b) {
                return;
            }
            this.i.setVisibility(0);
            this.f4758g.setVisibility(4);
            this.f4759h.setVisibility(4);
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "AdobeAuthContinuableActivity", " No Error Condition");
        }

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.m = (String) getArguments().get(C0297a.f4872e);
            setRetainInstance(true);
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            return layoutInflater.inflate(com.adobe.creativesdk.foundation.auth.q.adobe_csdk_ux_auth_fragment_view, viewGroup, false);
        }

        @Override // android.support.v4.app.Fragment
        public void onDestroy() {
            WebView webView = this.i;
            if (webView != null) {
                webView.stopLoading();
            }
            super.onDestroy();
        }

        @Override // android.support.v4.app.Fragment
        public void onDestroyView() {
            this.l = null;
            WebView webView = this.i;
            if (webView != null) {
                this.k.removeView(webView);
                this.i.setWebViewClient(null);
            }
            super.onDestroyView();
        }

        @Override // android.support.v4.app.Fragment
        public void onSaveInstanceState(Bundle bundle) {
            super.onSaveInstanceState(bundle);
        }

        @Override // android.support.v4.app.Fragment
        public void onStart() {
            super.onStart();
            this.f4754c = new C0023a();
            com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeNetworkStatusChangeNotification, this.f4754c);
            this.l.a(getActivity());
            if (this.l.b()) {
                B();
            } else {
                E();
            }
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "AdobeAuthContinuableActivity", "Started continuable event page");
        }

        @Override // android.support.v4.app.Fragment
        public void onStop() {
            super.onStop();
            com.adobe.creativesdk.foundation.adobeinternal.net.a.a();
            com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeNetworkStatusChangeNotification, this.f4754c);
            this.f4754c = null;
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "AdobeAuthContinuableActivity", "Stopped continuable event page");
        }

        @Override // android.support.v4.app.Fragment
        public void onViewCreated(View view, Bundle bundle) {
            super.onViewCreated(view, bundle);
            this.k = (ViewGroup) view.findViewById(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_creativesdk_foundation_auth_webview_container);
            FragmentManager fragmentManager = getFragmentManager();
            WebView webView = this.i;
            if (webView != null) {
                this.k.addView(webView);
                this.i.setWebViewClient(this.j);
            }
            this.f4752a = new c.a.a.a.c.a.b();
            fragmentManager.beginTransaction().replace(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_creativesdk_foundation_auth_signin_error, this.f4752a).commit();
            this.f4758g = (ProgressBar) view.findViewById(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_creativesdk_foundation_auth_progressBar);
            this.f4759h = view.findViewById(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_creativesdk_foundation_auth_signin_error);
            this.l = com.adobe.creativesdk.foundation.adobeinternal.net.a.b();
        }

        @Override // android.support.v4.app.Fragment
        public void onViewStateRestored(Bundle bundle) {
            super.onViewStateRestored(bundle);
        }

        URL z() {
            try {
                return new URL(this.m);
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            AdobeAuthContinuableEventActivity.this.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        f4746a = true;
        setResult(0);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobeNotificationContinualActivityClosed, null));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        new Thread(new RunnableC0300d(this)).start();
    }

    private void v() {
        this.f4748c = new b();
        this.f4747b = new Timer();
        this.f4747b.scheduleAtFixedRate(this.f4748c, 900000L, 900000L);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        f4746a = false;
        com.adobe.creativesdk.foundation.internal.auth.a.a.a();
        this.f4749d = getIntent().getExtras().getString(C0297a.f4872e);
        getWindow().setSoftInputMode(16);
        c.a.a.a.c.a.a.b().a(this);
        super.onCreate(bundle);
        setContentView(com.adobe.creativesdk.foundation.auth.q.adobe_csdk_ux_auth_activity_container_view);
        Toolbar toolbar = (Toolbar) findViewById(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_actionbar_toolbar);
        toolbar.setContentInsetsRelative(getResources().getDimensionPixelSize(com.adobe.creativesdk.foundation.auth.n.abc_action_bar_content_inset_material), 0);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowHomeEnabled(false);
            supportActionBar.setDisplayHomeAsUpEnabled(false);
        }
        com.adobe.creativesdk.foundation.internal.utils.b.a(findViewById(R.id.content), getString(com.adobe.creativesdk.foundation.auth.r.adobe_csdk_auth_sign_in_close));
        com.adobe.creativesdk.foundation.internal.utils.b.a(findViewById(R.id.content)).setOnClickListener(new ViewOnClickListenerC0298b(this));
        getSupportActionBar().setTitle("");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        a aVar = (a) supportFragmentManager.findFragmentByTag(this.f4750e);
        if (aVar == null) {
            a aVar2 = new a();
            Bundle bundle2 = new Bundle();
            bundle2.putString(C0297a.f4872e, this.f4749d);
            aVar2.setArguments(bundle2);
            this.f4751f = aVar2;
            supportFragmentManager.beginTransaction().add(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_creativesdk_foundation_auth_fragment_container, aVar2, this.f4750e).commit();
        } else {
            this.f4751f = aVar;
        }
        v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f4747b.cancel();
    }
}
