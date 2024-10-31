package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.internal.view.SupportMenu;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.adobe.creativesdk.foundation.auth.AdobeAuthSessionHelper;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* loaded from: classes.dex */
public class AdobeUxAssetBrowserV2Activity extends com.adobe.creativesdk.foundation.internal.base.a implements InterfaceC0372cd {

    /* renamed from: d, reason: collision with root package name */
    Bundle f5580d;

    /* renamed from: e, reason: collision with root package name */
    C0450o f5581e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5582f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5583g;

    /* renamed from: h, reason: collision with root package name */
    private Toolbar f5584h;
    private int i;
    private a k;
    private com.adobe.creativesdk.foundation.internal.storage.controllers.actionbar.a m;

    /* renamed from: a, reason: collision with root package name */
    private final String f5577a = "AssetBrowserV2_mainBrowserFragmentTag";

    /* renamed from: b, reason: collision with root package name */
    private final String f5578b = "AssetBrowserV2_dataSourcesWaitFragmentTag";

    /* renamed from: c, reason: collision with root package name */
    private final int f5579c = SupportMenu.USER_MASK;
    private AdobeAuthSessionHelper j = null;
    private AdobeAuthSessionHelper.a l = new Pa(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public int f5585a;

        /* renamed from: b, reason: collision with root package name */
        public Intent f5586b;

        /* renamed from: c, reason: collision with root package name */
        public int f5587c;

        public a(int i, int i2, Intent intent) {
            this.f5585a = i;
            this.f5586b = intent;
            this.f5587c = i2;
        }
    }

    public AdobeUxAssetBrowserV2Activity() {
        this.f5582f = false;
        this.f5582f = false;
    }

    private void v() {
        if (this.f5581e != null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.remove(this.f5581e);
            beginTransaction.commit();
            this.f5581e = null;
        }
    }

    private void w() {
        C0450o c0450o;
        a aVar = this.k;
        if (aVar == null || (c0450o = this.f5581e) == null) {
            return;
        }
        c0450o.a(aVar.f5585a, aVar.f5587c, aVar.f5586b);
        this.k = null;
    }

    private void x() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentById = supportFragmentManager.findFragmentById(c.a.a.a.b.e.adobe_csdk_assetbrowser_v2_frame);
        if (!(findFragmentById instanceof C0450o)) {
            this.f5581e = new C0450o();
            this.f5581e.setArguments(getIntent().getExtras());
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            beginTransaction.replace(c.a.a.a.b.e.adobe_csdk_assetbrowser_v2_frame, this.f5581e, "AssetBrowserV2_mainBrowserFragmentTag");
            beginTransaction.commit();
        } else {
            this.f5581e = (C0450o) findFragmentById;
        }
        w();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0372cd
    public void b(Intent intent) {
        setResult(-1, intent);
        finish();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0372cd
    public void g() {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0372cd
    public void l() {
        v();
        c.a.a.a.a.a.a.b().g();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0372cd
    public void m() {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0372cd
    public boolean n() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C0450o c0450o = this.f5581e;
        if (c0450o != null) {
            c0450o.a(i, i2, intent);
        } else {
            this.k = new a(i, i2, intent);
        }
        this.j.a(i, i2, intent);
        if (i == 2002) {
            if (i2 == 0) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, "UxAssetBrowserV2", "Signin cancelled, finishing.");
                finish();
            } else if (i2 == -1) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, "UxAssetBrowserV2", "Signin: restarting.");
                Intent intent2 = getIntent();
                finish();
                startActivity(intent2);
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (s()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i = configuration.orientation;
        if (i != this.i) {
            this.i = i;
            com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobeAppOrientationConfigurationChanged, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.i = getResources().getConfiguration().orientation;
        setContentView(c.a.a.a.b.g.adobe_assetbrowser_v2_activity);
        t();
        this.f5580d = getIntent().getExtras();
        this.j = new AdobeAuthSessionHelper(this.l);
        this.j.a(bundle);
        this.f5582f = false;
        this.f5583g = false;
        com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.d dVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.d();
        dVar.b(null);
        com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.f fVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.f();
        fVar.a(false);
        com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.i iVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.i();
        iVar.a(false);
        com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.g gVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.g();
        gVar.a(false);
        com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.h hVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.h();
        hVar.a(false);
        dVar.a(fVar);
        dVar.a(gVar);
        dVar.a(iVar);
        dVar.a(hVar);
        com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.e.a(com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.c.a(dVar));
        Sa.a(getBaseContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.j.a();
        com.adobe.creativesdk.foundation.internal.storage.controllers.actionbar.a.a(this.m);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 82 || super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            s();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.j.b();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f5583g = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.j.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.j.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.j.e();
    }

    boolean s() {
        C0450o c0450o;
        Toolbar toolbar = this.f5584h;
        if (toolbar == null || toolbar.hasExpandedActionView() || (c0450o = this.f5581e) == null) {
            return false;
        }
        if (!c0450o.C()) {
            return this.f5581e.B();
        }
        com.adobe.creativesdk.foundation.internal.storage.W.c();
        com.adobe.creativesdk.foundation.internal.storage.ca.c();
        finish();
        return true;
    }

    public void t() {
        this.f5584h = (Toolbar) findViewById(c.a.a.a.b.e.adobe_csdk_actionbar_toolbar);
        setSupportActionBar(this.f5584h);
        Toolbar toolbar = this.f5584h;
        if (toolbar != null) {
            toolbar.setBackgroundResource(c.a.a.a.b.b.adobe_csdk_actionbar_background);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        this.m = new com.adobe.creativesdk.foundation.internal.storage.controllers.actionbar.a();
        com.adobe.creativesdk.foundation.internal.storage.controllers.actionbar.a.b(this.m);
        com.adobe.creativesdk.foundation.internal.storage.controllers.actionbar.a.a().a(this);
    }

    public void u() {
        if (this.f5584h.getVisibility() == 8) {
            this.f5584h.setVisibility(0);
        }
        x();
    }
}
