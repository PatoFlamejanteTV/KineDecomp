package com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit;

import android.R;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0450o;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.storage.AdobeAssetDataSourceFilterType;
import com.adobe.creativesdk.foundation.storage.AdobeAssetDataSourceType;
import java.util.EnumSet;

/* loaded from: classes.dex */
public class AdobeDesignLibraryMoveActivity extends AdobeTOUHandlerActivity implements y {

    /* renamed from: c, reason: collision with root package name */
    private int f6186c;

    /* renamed from: e, reason: collision with root package name */
    private Toolbar f6188e;

    /* renamed from: f, reason: collision with root package name */
    private View f6189f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f6190g;

    /* renamed from: h, reason: collision with root package name */
    private w f6191h;

    /* renamed from: d, reason: collision with root package name */
    protected Fragment f6187d = null;
    private a i = new a(this, null);

    /* loaded from: classes.dex */
    private class a extends com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c {
        private a() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c
        protected EnumSet<AdobeAssetViewBrowserCommandName> a() {
            return EnumSet.of(AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_ELEMENT_EDIT_MOVE_OPERATION);
        }

        /* synthetic */ a(AdobeDesignLibraryMoveActivity adobeDesignLibraryMoveActivity, m mVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c
        public void a(AdobeAssetViewBrowserCommandName adobeAssetViewBrowserCommandName, Object obj) {
            if (adobeAssetViewBrowserCommandName == AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_ELEMENT_EDIT_MOVE_OPERATION) {
                AdobeDesignLibraryMoveActivity.this.c((String) obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        AdobeDesignLibraryEditOperation adobeDesignLibraryEditOperation = AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_ITEM_EDIT_OPERATION_MOVE;
        if (this.f6190g) {
            adobeDesignLibraryEditOperation = AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_ITEM_EDIT_OPERATION_COPY;
        }
        com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.a(str, getSupportFragmentManager(), adobeDesignLibraryEditOperation, new m(this)).b();
        finish();
    }

    private Fragment s() {
        C0450o c0450o = new C0450o();
        Bundle bundle = new Bundle();
        bundle.putSerializable("ADOBE_CLOUD", com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().c());
        bundle.putSerializable("DATA_SOURCE_FILTER_ARRAY", EnumSet.of(AdobeAssetDataSourceType.AdobeAssetDataSourceLibrary));
        bundle.putSerializable("DATA_SOURCE_FILTER_TYPE", AdobeAssetDataSourceFilterType.ADOBE_ASSET_DATASOURCE_FILTER_INCLUSION);
        bundle.putBoolean("SHOW_LIBRARY_ITEM", true);
        c0450o.setArguments(bundle);
        return c0450o;
    }

    private boolean t() {
        Fragment fragment = this.f6187d;
        if (fragment == null) {
            super.onBackPressed();
            return false;
        }
        if (((C0450o) fragment).C()) {
            finish();
            return true;
        }
        com.adobe.creativesdk.foundation.internal.utils.b.a(this.f6189f, getResources().getString(c.a.a.a.b.i.adobe_csdk_library_chooser));
        return ((C0450o) this.f6187d).B();
    }

    private void u() {
        x();
    }

    private void v() {
        this.f6188e.setNavigationIcon(c.a.a.a.b.d.asset_edit_home_as_up_back);
    }

    private void w() {
        this.f6188e = (Toolbar) findViewById(c.a.a.a.b.e.adobe_csdk_actionbar_toolbar);
        this.f6188e.setBackgroundColor(getResources().getColor(c.a.a.a.b.b.adobe_csdk_asset_browser_edit_actionbar_background));
        this.f6189f = findViewById(R.id.content);
        com.adobe.creativesdk.foundation.internal.utils.b.a(this.f6189f, -1);
        com.adobe.creativesdk.foundation.internal.utils.b.a(this.f6189f, getResources().getString(c.a.a.a.b.i.adobe_csdk_library_chooser));
        setSupportActionBar(this.f6188e);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");
        }
    }

    private void x() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        int i = c.a.a.a.b.e.adobe_csdk_library_element_move_frame;
        if (this.f6187d == null) {
            this.f6187d = s();
            v();
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            beginTransaction.replace(i, this.f6187d, "");
            beginTransaction.commit();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.y
    public w b() {
        if (this.f6191h == null) {
            this.f6191h = new w();
            this.f6191h.a(true);
            this.f6191h.b(true);
        }
        return this.f6191h;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        t();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i = configuration.orientation;
        if (i != this.f6186c) {
            this.f6186c = i;
            com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobeAppOrientationConfigurationChanged, null));
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() != null) {
            this.f6190g = getIntent().getExtras().getBoolean("IS_COPY", false);
        }
        setContentView(c.a.a.a.b.g.activity_library_element_move);
        this.f6186c = getResources().getConfiguration().orientation;
        w();
        u();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            t();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.i.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.i.c();
    }
}
