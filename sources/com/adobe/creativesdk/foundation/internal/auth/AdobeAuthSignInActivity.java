package com.adobe.creativesdk.foundation.internal.auth;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.adobe.creativesdk.foundation.adobeinternal.net.AdobeNetworkReachability;
import com.adobe.creativesdk.foundation.auth.AdobeAuthErrorCode;
import com.adobe.creativesdk.foundation.auth.AdobeAuthException;
import com.adobe.creativesdk.foundation.internal.auth.I;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

/* loaded from: classes.dex */
public class AdobeAuthSignInActivity extends com.adobe.creativesdk.foundation.internal.base.a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4777a = "AdobeAuthSignInActivity";

    /* renamed from: b, reason: collision with root package name */
    private static boolean f4778b = false;

    /* renamed from: c, reason: collision with root package name */
    String f4779c = "SignInfragment";

    /* renamed from: d, reason: collision with root package name */
    private a f4780d;

    /* loaded from: classes.dex */
    public static class a extends Fragment {

        /* renamed from: a, reason: collision with root package name */
        c.a.a.a.c.a.b f4781a;

        /* renamed from: b, reason: collision with root package name */
        boolean f4782b;
        private ProgressBar i;
        private View j;
        private WebView k;
        private T l;
        private ViewGroup m;
        private N o;
        private b p;
        private boolean q;

        /* renamed from: c, reason: collision with root package name */
        C0024a f4783c = null;

        /* renamed from: d, reason: collision with root package name */
        String f4784d = null;

        /* renamed from: e, reason: collision with root package name */
        int f4785e = C0297a.f4868a;

        /* renamed from: f, reason: collision with root package name */
        boolean f4786f = false;

        /* renamed from: g, reason: collision with root package name */
        boolean f4787g = false;

        /* renamed from: h, reason: collision with root package name */
        boolean f4788h = false;
        private AdobeNetworkReachability n = null;

        /* renamed from: com.adobe.creativesdk.foundation.internal.auth.AdobeAuthSignInActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0024a implements Observer {
            C0024a() {
            }

            @Override // java.util.Observer
            public void update(Observable observable, Object obj) {
                if (((com.adobe.creativesdk.foundation.internal.notification.c) obj).a() == AdobeInternalNotificationID.AdobeNetworkStatusChangeNotification) {
                    if (!a.this.n.b()) {
                        a.this.J();
                        return;
                    } else {
                        a.this.G();
                        return;
                    }
                }
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "Authentication", "Expected a network status changed message!");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class b {
            b() {
            }

            private void d() {
                I.c(a.this.getActivity());
            }

            Bundle a() {
                return null;
            }

            public boolean b() {
                return I.b(a.this.getActivity());
            }

            public void c() {
                I.a().a(a.this.getActivity(), a(), new G(this));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(I.b bVar, boolean z) {
                P p = (P) a.this.o;
                if (bVar.f4821b) {
                    p.e();
                    return;
                }
                I.c cVar = bVar.f4820a;
                if (cVar != null && z && I.a(cVar)) {
                    d();
                    bVar.f4820a = null;
                }
                p.a(bVar.f4820a);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void G() {
            this.j.setVisibility(0);
            H();
            this.f4782b = false;
            K();
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "Authentication", " _cameOnline");
        }

        private void H() {
            this.j.setVisibility(4);
        }

        private void I() {
            boolean z = this.f4787g;
            if ((!z || (z && this.f4788h)) && this.f4786f) {
                return;
            }
            this.f4786f = true;
            this.k.setVisibility(4);
            URL z2 = z();
            this.f4787g = false;
            this.f4788h = false;
            if (this.f4785e == C0297a.f4870c) {
                String O = AdobeAuthIdentityManagementService.K().O();
                if (O == null) {
                    O = "";
                }
                this.k.postUrl(z2.toString(), O.getBytes());
            } else {
                this.k.loadUrl(z2.toString());
            }
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "Authentication", " Loading URL");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void J() {
            this.f4786f = false;
            g(getString(com.adobe.creativesdk.foundation.auth.r.adobe_csdk_common_error_view_no_internet_connection));
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "Authentication", " _wentOffline");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void K() {
            /*
                r2 = this;
                boolean r0 = r2.F()
                if (r0 == 0) goto L1c
                com.adobe.creativesdk.foundation.internal.auth.AdobeAuthSignInActivity$a$b r0 = new com.adobe.creativesdk.foundation.internal.auth.AdobeAuthSignInActivity$a$b
                r0.<init>()
                r2.p = r0
                com.adobe.creativesdk.foundation.internal.auth.AdobeAuthSignInActivity$a$b r0 = r2.p
                boolean r0 = r0.b()
                if (r0 == 0) goto L1c
                r0 = 0
                com.adobe.creativesdk.foundation.internal.auth.AdobeAuthSignInActivity$a$b r1 = r2.p
                r1.c()
                goto L1d
            L1c:
                r0 = 1
            L1d:
                if (r0 == 0) goto L25
                r2.L()
                r2.I()
            L25:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.auth.AdobeAuthSignInActivity.a.K():void");
        }

        private void L() {
            if (this.k == null) {
                CookieManager.getInstance().removeAllCookie();
                this.k = new WebView(getActivity());
                this.k.setClipChildren(false);
                ViewCompat.setLayerType(this.k, 1, null);
                this.k.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.k.getSettings().setLoadWithOverviewMode(true);
                this.k.getSettings().setJavaScriptEnabled(true);
                this.m.addView(this.k);
                this.l = new T(this);
                this.l.a(this.o);
                this.k.setWebViewClient(this.l);
            }
        }

        private void g(String str) {
            if (str != null) {
                this.f4781a.e(str);
            }
            this.j.setVisibility(0);
        }

        public N A() {
            return this.o;
        }

        public void B() {
            WebView webView = this.k;
            if (webView != null) {
                webView.goBack();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void C() {
            if (isAdded()) {
                this.k.setVisibility(4);
                this.f4782b = true;
                this.f4786f = false;
                if (!this.n.b()) {
                    J();
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "Authentication", " Handle error condition offline");
                } else {
                    g(getString(com.adobe.creativesdk.foundation.auth.r.adobe_csdk_common_error_view_unknown_authenticate_error));
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "Authentication", " Webpage error");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void D() {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "Authentication", " Page loaded");
            if (this.f4782b) {
                return;
            }
            this.k.setVisibility(0);
            this.i.setVisibility(4);
            this.j.setVisibility(4);
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "Authentication", " No Error Condition");
        }

        public boolean E() {
            WebView webView = this.k;
            return webView != null && webView.getVisibility() == 0 && this.j.getVisibility() != 0 && this.k.canGoBack();
        }

        boolean F() {
            return this.q;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void f(String str) {
            if (isAdded()) {
                this.k.setVisibility(4);
                this.f4782b = true;
                this.f4786f = false;
                g(str);
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "Authentication", " Webpage error");
            }
        }

        public void m(int i) {
            this.f4785e = i;
        }

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate = layoutInflater.inflate(com.adobe.creativesdk.foundation.auth.q.adobe_csdk_ux_auth_fragment_view, viewGroup, false);
            if (F()) {
                this.p = new b();
            }
            return inflate;
        }

        @Override // android.support.v4.app.Fragment
        public void onDestroy() {
            WebView webView = this.k;
            if (webView != null) {
                webView.stopLoading();
            }
            super.onDestroy();
        }

        @Override // android.support.v4.app.Fragment
        public void onDestroyView() {
            this.n = null;
            WebView webView = this.k;
            if (webView != null) {
                this.m.removeView(webView);
                this.k.setWebViewClient(null);
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
            this.f4783c = new C0024a();
            com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeNetworkStatusChangeNotification, this.f4783c);
            this.n.a(getActivity());
            if (this.n.b()) {
                G();
            } else {
                J();
            }
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "Authentication", "Started SignIn page");
        }

        @Override // android.support.v4.app.Fragment
        public void onStop() {
            super.onStop();
            com.adobe.creativesdk.foundation.adobeinternal.net.a.a();
            com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeNetworkStatusChangeNotification, this.f4783c);
            this.f4783c = null;
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "Authentication", "Stopped SignIn page");
        }

        @Override // android.support.v4.app.Fragment
        public void onViewCreated(View view, Bundle bundle) {
            super.onViewCreated(view, bundle);
            this.m = (ViewGroup) view.findViewById(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_creativesdk_foundation_auth_webview_container);
            FragmentManager fragmentManager = getFragmentManager();
            WebView webView = this.k;
            if (webView != null) {
                this.m.addView(webView);
                this.k.setWebViewClient(this.l);
            }
            if (!F()) {
                L();
            }
            this.f4781a = new c.a.a.a.c.a.b();
            fragmentManager.beginTransaction().replace(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_creativesdk_foundation_auth_signin_error, this.f4781a).commit();
            this.i = (ProgressBar) view.findViewById(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_creativesdk_foundation_auth_progressBar);
            this.j = view.findViewById(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_creativesdk_foundation_auth_signin_error);
            this.n = com.adobe.creativesdk.foundation.adobeinternal.net.a.b();
        }

        @Override // android.support.v4.app.Fragment
        public void onViewStateRestored(Bundle bundle) {
            super.onViewStateRestored(bundle);
        }

        URL z() {
            int i = this.f4785e;
            if (i == C0297a.f4869b) {
                return AdobeAuthIdentityManagementService.K().N();
            }
            if (i == C0297a.f4870c) {
                return AdobeAuthIdentityManagementService.K().f();
            }
            return AdobeAuthIdentityManagementService.K().L();
        }

        public void a(N n) {
            this.o = n;
        }

        public void b(boolean z) {
            this.q = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(AdobeAuthException adobeAuthException) {
        V e2 = E.m().e();
        if (e2 != null) {
            if (adobeAuthException != null) {
                e2.a(adobeAuthException);
            } else {
                AdobeAuthIdentityManagementService K = AdobeAuthIdentityManagementService.K();
                e2.a(K.e(), K.c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdobeAuthException adobeAuthException) {
        Intent intent = new Intent();
        if (adobeAuthException != null) {
            intent.putExtra("AdobeAuthErrorCode", adobeAuthException.getErrorCode().getValue());
            if (adobeAuthException.getErrorCode() == AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_USER_CANCELLED) {
                setResult(0, intent);
                b(adobeAuthException);
                return;
            }
        } else {
            intent.putExtra("AdobeAuthErrorCode", 0);
        }
        setResult(-1, intent);
        b(adobeAuthException);
    }

    public static boolean s() {
        return f4778b;
    }

    private N u() {
        if (v()) {
            return new P();
        }
        return new O();
    }

    private boolean v() {
        return getIntent().getExtras().getBoolean("uxauth_trysharedtoken", false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        f4778b = false;
        if (!E.j()) {
            finish();
        }
        getWindow().setSoftInputMode(16);
        c.a.a.a.c.a.a.b().a(this);
        super.onCreate(bundle);
        setContentView(com.adobe.creativesdk.foundation.auth.q.adobe_csdk_ux_auth_activity_container_view);
        CookieSyncManager.createInstance(this);
        CookieManager.getInstance().removeAllCookie();
        Toolbar toolbar = (Toolbar) findViewById(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_actionbar_toolbar);
        toolbar.setContentInsetsRelative(getResources().getDimensionPixelSize(com.adobe.creativesdk.foundation.auth.n.abc_action_bar_content_inset_material), 0);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowHomeEnabled(false);
            supportActionBar.setDisplayHomeAsUpEnabled(false);
        }
        com.adobe.creativesdk.foundation.internal.utils.b.a(findViewById(R.id.content), getString(com.adobe.creativesdk.foundation.auth.r.adobe_csdk_auth_sign_in_close));
        com.adobe.creativesdk.foundation.internal.utils.b.a(findViewById(R.id.content)).setOnClickListener(new F(this));
        getSupportActionBar().setTitle("");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        a aVar = (a) supportFragmentManager.findFragmentByTag(this.f4779c);
        if (aVar == null) {
            a aVar2 = new a();
            this.f4780d = aVar2;
            N u = u();
            u.a(this);
            aVar2.a(u);
            supportFragmentManager.beginTransaction().add(com.adobe.creativesdk.foundation.auth.p.adobe_csdk_creativesdk_foundation_auth_fragment_container, aVar2, this.f4779c).commit();
            int i = getIntent().getExtras().getInt(C0297a.f4871d, C0297a.f4868a);
            aVar2.m(i);
            if (v() && i == C0297a.f4868a) {
                z = true;
            }
            aVar2.b(z);
            return;
        }
        this.f4780d = aVar;
        N A = aVar.A();
        if (A == null) {
            N u2 = u();
            u2.a(this);
            aVar.a(u2);
            int i2 = getIntent().getExtras().getInt(C0297a.f4871d, C0297a.f4868a);
            aVar.m(i2);
            if (v() && i2 == C0297a.f4868a) {
                z = true;
            }
            aVar.b(z);
            return;
        }
        A.a(this);
        if (A.b()) {
            A.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        a aVar = this.f4780d;
        if (aVar != null) {
            aVar.A().a((AdobeAuthSignInActivity) null);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            a aVar = (a) getSupportFragmentManager().findFragmentByTag(this.f4779c);
            if (aVar != null && aVar.E()) {
                aVar.B();
                return true;
            }
            c(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_USER_CANCELLED));
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            c(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_USER_CANCELLED));
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void t() {
        this.f4780d.b(false);
        this.f4780d.K();
    }

    public static void a(I.c cVar) {
        if (cVar.f4822a != null && cVar.f4824c != null) {
            I.a().a(c.a.a.a.c.a.a.b().a(), cVar, false);
        } else {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, f4777a, "Add account NUll - check this");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AdobeAuthException adobeAuthException) {
        c(adobeAuthException);
        finish();
    }
}
