package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import android.R;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0450o;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.storage.AdobeAssetDataSourceFilterType;
import com.adobe.creativesdk.foundation.storage.AdobeAssetDataSourceType;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import java.util.EnumSet;

/* loaded from: classes.dex */
public class AdobeAssetEditActivity extends AdobeTOUHandlerActivity implements F, E {

    /* renamed from: c, reason: collision with root package name */
    private static String f6018c = "DATA_SOURCE_FILTER_ARRAY";

    /* renamed from: f, reason: collision with root package name */
    private View f6021f;

    /* renamed from: g, reason: collision with root package name */
    private View f6022g;

    /* renamed from: h, reason: collision with root package name */
    private View f6023h;
    private String i;
    private FloatingActionsMenu l;
    private FloatingActionButton m;
    private FloatingActionButton n;
    private FloatingActionButton o;
    private View p;
    private Menu q;
    private Toolbar r;
    private View s;
    private int v;
    private C0389g w;
    private C0390h x;

    /* renamed from: d, reason: collision with root package name */
    protected Fragment f6019d = null;

    /* renamed from: e, reason: collision with root package name */
    protected Fragment f6020e = null;
    private boolean k = false;
    private boolean t = false;
    private boolean u = false;
    private a j = new a(this, null);

    /* loaded from: classes.dex */
    private class a extends com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c {
        private a() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c
        protected EnumSet<AdobeAssetViewBrowserCommandName> a() {
            return EnumSet.of(AdobeAssetViewBrowserCommandName.ACTION_ASSET_EDIT_MOVE_OPERATION, AdobeAssetViewBrowserCommandName.ACTION_ASSET_EDIT_OPEN_MOVE_CCFILES_BROWSER);
        }

        /* synthetic */ a(AdobeAssetEditActivity adobeAssetEditActivity, ViewOnTouchListenerC0383a viewOnTouchListenerC0383a) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c
        public void a(AdobeAssetViewBrowserCommandName adobeAssetViewBrowserCommandName, Object obj) {
            if (adobeAssetViewBrowserCommandName == AdobeAssetViewBrowserCommandName.ACTION_ASSET_EDIT_MOVE_OPERATION) {
                AdobeAssetEditActivity.this.c((String) obj);
            }
            if (adobeAssetViewBrowserCommandName == AdobeAssetViewBrowserCommandName.ACTION_ASSET_EDIT_OPEN_MOVE_CCFILES_BROWSER) {
                AdobeAssetEditActivity.this.s();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        Fragment fragment = this.f6020e;
        if (fragment != null) {
            ((B) fragment).Na();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (this.f6022g.getVisibility() == 8 && this.u && this.t) {
            this.f6023h.setVisibility(0);
        } else {
            this.f6023h.setVisibility(8);
        }
    }

    private void C() {
        if (this.w.b() == AdobeAssetViewEditActivityOperationMode.ADOBE_ASSET_VIEW_EDIT_ACTIVITY_OPERATION_MODE_MOVE) {
            H();
        } else {
            G();
        }
    }

    private void D() {
        this.r.setNavigationIcon(c.a.a.a.b.d.asset_edit_home_as_up_back);
    }

    private void E() {
        int size = C0393k.c().b().size();
        this.r.setNavigationIcon(c.a.a.a.b.d.asset_edit_home_as_up_cross);
        com.adobe.creativesdk.foundation.internal.utils.b.a(this.s, "" + size);
        t();
    }

    private void F() {
        this.r = (Toolbar) findViewById(c.a.a.a.b.e.adobe_csdk_actionbar_toolbar_loki);
        this.r.setBackgroundColor(getResources().getColor(c.a.a.a.b.b.adobe_loki_app_bar));
        this.s = findViewById(R.id.content);
        com.adobe.creativesdk.foundation.internal.utils.b.a(this.s, -1);
        setSupportActionBar(this.r);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");
        }
    }

    private void G() {
        this.i = this.w.c();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        int i = c.a.a.a.b.e.adobe_csdk_edit_frame;
        if (this.f6020e == null) {
            this.f6020e = v();
            this.f6022g.setVisibility(8);
            this.f6021f.setVisibility(0);
            ((B) this.f6020e).a(this.r, this.s);
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            beginTransaction.replace(i, this.f6020e, "");
            this.k = true;
            beginTransaction.addToBackStack(null);
            beginTransaction.commit();
        }
        B();
    }

    private void H() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        int i = c.a.a.a.b.e.adobe_csdk_move_frame;
        if (this.f6019d == null) {
            this.p.setVisibility(8);
            this.f6019d = u();
            this.f6021f.setVisibility(8);
            this.f6022g.setVisibility(0);
            D();
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            beginTransaction.replace(i, this.f6019d, "");
            if (this.k) {
                beginTransaction.addToBackStack(null);
            }
            beginTransaction.commit();
        }
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        H();
    }

    private void t() {
        if (this.q != null) {
            for (int i = 0; i < this.q.size(); i++) {
                this.q.removeItem(this.q.getItem(i).getItemId());
            }
        }
    }

    private Fragment u() {
        C0450o c0450o = new C0450o();
        Bundle bundle = new Bundle();
        bundle.putSerializable("ADOBE_CLOUD", com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().c());
        bundle.putSerializable(f6018c, EnumSet.of(AdobeAssetDataSourceType.AdobeAssetDataSourceFiles));
        bundle.putBoolean("CREATE_MOVE_BUTTON", true);
        bundle.putSerializable("SHOULD_SHOW_ONLY_ASSETS", true);
        bundle.putSerializable("DATA_SOURCE_FILTER_TYPE", AdobeAssetDataSourceFilterType.ADOBE_ASSET_DATASOURCE_FILTER_INCLUSION);
        c0450o.setArguments(bundle);
        return c0450o;
    }

    private Fragment v() {
        B b2 = new B();
        b2.a((E) this);
        Bundle bundle = new Bundle();
        bundle.putSerializable("ADOBE_CLOUD", com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().c());
        bundle.putString("EDIT_MULTI_SELECT_TARGET_HREF", this.i);
        b2.setArguments(bundle);
        return b2;
    }

    private boolean w() {
        if (!this.k) {
            Fragment fragment = this.f6019d;
            if (fragment == null) {
                super.onBackPressed();
            } else {
                if (((C0450o) fragment).C()) {
                    finish();
                    return true;
                }
                return ((C0450o) this.f6019d).B();
            }
        } else {
            Fragment fragment2 = this.f6019d;
            if (fragment2 != null) {
                if (((C0450o) fragment2).C()) {
                    boolean B = ((C0450o) this.f6019d).B();
                    this.f6019d = null;
                    E();
                    this.f6022g.setVisibility(8);
                    this.f6021f.setVisibility(0);
                    j();
                    return B;
                }
                return ((C0450o) this.f6019d).B();
            }
            if (!((B) this.f6020e).Ka()) {
                finish();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        Fragment fragment = this.f6020e;
        if (fragment != null) {
            ((B) fragment).La();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        Fragment fragment = this.f6020e;
        if (fragment != null) {
            ((B) fragment).Ma();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z() {
        FloatingActionsMenu floatingActionsMenu = this.l;
        if (floatingActionsMenu == null || !floatingActionsMenu.f()) {
            return false;
        }
        this.l.d();
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.edit.E
    public void j() {
        View view = this.p;
        if (view != null) {
            view.setVisibility(this.t ? 0 : 8);
            B();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        w();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i = configuration.orientation;
        if (i != this.v) {
            this.v = i;
            com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobeAppOrientationConfigurationChanged, null));
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.u = bundle.getBoolean("FLOATING_MENU_EXPANDED", false);
        }
        setContentView(c.a.a.a.b.g.activity_edit_asset);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, c.a.a.a.b.b.adobe_loki_status_bar));
        }
        this.v = getResources().getConfiguration().orientation;
        this.p = findViewById(c.a.a.a.b.e.adobe_csdk_edit_float_action_menu_container);
        View view = this.p;
        if (view != null) {
            view.setOnTouchListener(new ViewOnTouchListenerC0383a(this));
        }
        this.l = (FloatingActionsMenu) findViewById(c.a.a.a.b.e.adobe_csdk_edit_floating_action_menu);
        this.l.setOnFloatingActionsMenuUpdateListener(new C0384b(this));
        this.m = (FloatingActionButton) findViewById(c.a.a.a.b.e.adobe_csdk_edit_delete_button);
        this.n = (FloatingActionButton) findViewById(c.a.a.a.b.e.adobe_csdk_edit_move_button);
        this.o = (FloatingActionButton) findViewById(c.a.a.a.b.e.adobe_csdk_edit_rename_button);
        this.m.setOnClickListener(new ViewOnClickListenerC0385c(this));
        this.n.setOnClickListener(new ViewOnClickListenerC0386d(this));
        this.o.setOnClickListener(new ViewOnClickListenerC0387e(this));
        this.w = C0389g.a(getIntent().getExtras().getBundle("EDIT_ACTIVITY_CONFIGURATION"));
        this.f6021f = findViewById(c.a.a.a.b.e.adobe_csdk_edit_frame);
        this.f6022g = findViewById(c.a.a.a.b.e.adobe_csdk_move_frame);
        this.f6023h = findViewById(c.a.a.a.b.e.adobe_csdk_transparent_frame);
        F();
        C();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return w();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        this.q = menu;
        return super.onPrepareOptionsMenu(menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("FLOATING_MENU_EXPANDED", this.u);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.j.b();
        View view = this.f6022g;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.p.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.j.c();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.edit.F
    public boolean p() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        C0394l.a(str, getSupportFragmentManager(), AdobeCCFilesEditOperation.ADOBE_CC_FILE_EDIT_OPERATION_MOVE, new C0388f(this), this.w.a()).b();
        finish();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.edit.E
    public void b(boolean z) {
        this.t = z;
        if (!z) {
            this.l.d();
        }
        this.p.setVisibility(z ? 0 : 8);
        if (this.u) {
            ((B) this.f6020e).l(true);
        }
        B();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.edit.E
    public void a(boolean z) {
        this.o.setVisibility(z ? 0 : 8);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.edit.F
    public C0390h b() {
        if (this.x == null) {
            this.x = new C0390h();
            this.x.a(true);
            this.x.b(true);
            this.x.a(getResources().getString(c.a.a.a.b.i.adobe_csdk_asset_view_move_fragment_title));
        }
        return this.x;
    }
}
