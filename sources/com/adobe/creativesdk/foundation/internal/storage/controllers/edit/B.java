package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.internal.storage.AdobeStorageDataSource;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0358a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0415hc;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Hb;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Kb;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Ub;
import com.adobe.creativesdk.foundation.internal.storage.controllers.a.c;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;

/* compiled from: CCFilesEditFragment.java */
/* loaded from: classes.dex */
public class B extends C0415hc implements G {
    String Ha;
    private int Ia;
    private Toolbar Ja;
    private View Ka;
    private Drawable La;
    private Drawable Ma;
    protected View Oa;
    protected View Pa;
    protected TextView Qa;
    protected AlertDialog Ra;
    protected AlertDialog.Builder Sa;
    public View Ta;
    private E Va;
    private com.adobe.creativesdk.foundation.internal.storage.controllers.a.f Wa;
    private boolean Na = false;
    private boolean Ua = true;

    /* compiled from: CCFilesEditFragment.java */
    /* loaded from: classes.dex */
    protected class a extends Hb.a {
        protected a() {
            super();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(Menu menu) {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(Menu menu, MenuInflater menuInflater) {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(boolean z) {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public boolean a(int i) {
            return true;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public boolean a(MenuItem menuItem) {
            return true;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void b() {
            if (B.this.Va != null) {
                B.this.Va.j();
            }
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void c() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        protected void d() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void e() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb.a
        public void h() {
        }
    }

    private void ob() {
        if (ub()) {
            ((C) this.Q).s();
        } else {
            ((D) this.R).s();
        }
        this.Ia = 0;
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pb() {
        tb();
        C0394l.a(x().getSupportFragmentManager(), AdobeCCFilesEditOperation.ADOBE_CC_FILE_EDIT_OPERATION_ERASE, new y(this), this.f6104c.a()).b();
        x().finish();
    }

    private void qb() {
        if (ub()) {
            ((C) this.Q).t();
        } else {
            ((D) this.R).t();
        }
        this.Ua = false;
    }

    private String r(int i) {
        return getResources().getString(i);
    }

    private void rb() {
        if (ub()) {
            ((C) this.Q).u();
        } else {
            ((D) this.R).u();
        }
        this.Ua = true;
    }

    private int sb() {
        if (ub()) {
            return ((C) this.Q).v().size();
        }
        return ((D) this.R).v().size();
    }

    private void tb() {
        C0393k c2 = C0393k.c();
        if (ub()) {
            c2.a(((C) this.Q).v());
        } else {
            c2.a(((D) this.R).v());
        }
    }

    private boolean ub() {
        return this.Na;
    }

    private boolean vb() {
        if (ub()) {
            return ((C) this.Q).v().get(0) instanceof AdobeAssetFile;
        }
        return ((D) this.R).v().get(0) instanceof AdobeAssetFile;
    }

    private void wb() {
        Toolbar toolbar = this.Ja;
        if (toolbar != null) {
            toolbar.setBackgroundColor(getResources().getColor(c.a.a.a.b.b.adobe_loki_app_bar));
            ((AdobeAssetEditActivity) x()).setSupportActionBar(this.Ja);
            ActionBar supportActionBar = ((AdobeAssetEditActivity) x()).getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setDisplayHomeAsUpEnabled(true);
                supportActionBar.setHomeButtonEnabled(true);
            }
            com.adobe.creativesdk.foundation.internal.utils.b.a(this.Ka, r(c.a.a.a.b.i.adobe_csdk_asset_view_edit_fragment_title), -1);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0415hc, com.adobe.creativesdk.foundation.internal.storage.controllers.Hb, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected AbstractC0414hb.b D() {
        return new a();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0415hc, com.adobe.creativesdk.foundation.internal.storage.controllers.Hb
    protected AdobeStorageDataSource.DataSourceInternalFilters Fa() {
        return null;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb
    protected Kb Ha() {
        C c2 = new C(getActivity());
        c2.a(this.Wa);
        c2.a((G) this);
        return c2;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb
    protected Ub Ia() {
        D d2 = new D(getActivity());
        d2.a((G) this);
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Ka() {
        if (this.Ia <= 0) {
            return false;
        }
        this.Ia = 0;
        rb();
        o();
        if (ub()) {
            ((C) this.Q).s();
            return true;
        }
        ((D) this.R).s();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"InflateParams"})
    public void La() {
        String r;
        if (this.Ta == null) {
            this.Ta = getLayoutInflater(null).inflate(c.a.a.a.b.g.adobe_alert_dialog_view, (ViewGroup) null);
            this.Sa = new AlertDialog.Builder(getActivity());
            this.Sa.setView(this.Ta);
            this.Qa = (TextView) this.Ta.findViewById(c.a.a.a.b.e.adobe_csdk_alert_dialog_box_title_text);
            this.Oa = this.Ta.findViewById(c.a.a.a.b.e.adobe_csdk_alert_dialog_box_positive_button);
            this.Pa = this.Ta.findViewById(c.a.a.a.b.e.adobe_csdk_alert_dialog_box_negative_button);
            this.Ra = this.Sa.create();
        }
        ((TextView) this.Oa).setText(getResources().getString(c.a.a.a.b.i.adobe_csdk_asset_view_edit_archive_dialog_positive_button));
        ((TextView) this.Pa).setText(getResources().getString(c.a.a.a.b.i.adobe_csdk_asset_view_edit_delete_dialog_negative_button));
        if (sb() > 1) {
            r = String.format(r(c.a.a.a.b.i.adobe_csdk_asset_view_edit_archive_dialog_message_multi_select), Integer.valueOf(sb()));
        } else if (vb()) {
            r = r(c.a.a.a.b.i.adobe_csdk_asset_view_edit_archive_dialog_message_file);
        } else {
            r = r(c.a.a.a.b.i.adobe_csdk_asset_view_edit_archive_dialog_message_folder);
        }
        this.Qa.setText(r);
        this.Oa.setOnClickListener(new w(this));
        this.Pa.setOnClickListener(new x(this));
        this.Ra.show();
    }

    public void Ma() {
        tb();
        C0358a.a().a(AdobeAssetViewBrowserCommandName.ACTION_ASSET_EDIT_OPEN_MOVE_CCFILES_BROWSER);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0415hc, com.adobe.creativesdk.foundation.internal.storage.controllers.Hb, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected String N() {
        return r(c.a.a.a.b.i.adobe_csdk_asset_view_edit_fragment_title);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Na() {
        tb();
        C0394l.a(x().getSupportFragmentManager(), AdobeCCFilesEditOperation.ADOBE_CC_FILE_EDIT_OPERATION_RENAME, new z(this), this.f6104c.a()).a(new A(this));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0415hc, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void c(boolean z) {
        if (!z) {
            this.Ua = true;
            qb();
            ob();
        } else if (this.Ua) {
            rb();
        } else {
            qb();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.edit.G
    public void d(int i) {
        r(false);
        this.Ia = i;
        com.adobe.creativesdk.foundation.internal.utils.b.a(this.Ka, "" + i, -1);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb
    protected void i(String str) {
        super.i(this.Ha);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(boolean z) {
        if (z) {
            qb();
        } else {
            rb();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.edit.G
    public void o() {
        E e2 = this.Va;
        if (e2 != null) {
            e2.b(false);
        }
        rb();
        Toolbar toolbar = this.Ja;
        if (toolbar != null) {
            toolbar.setNavigationIcon(this.Ma);
        }
        this.Ia = 0;
        View view = this.Ka;
        if (view != null) {
            com.adobe.creativesdk.foundation.internal.utils.b.a(view, r(c.a.a.a.b.i.adobe_csdk_asset_view_edit_fragment_title), -1);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0415hc, com.adobe.creativesdk.foundation.internal.storage.controllers.Hb, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        setRetainInstance(true);
        this.Ha = arguments.getString("EDIT_MULTI_SELECT_TARGET_HREF");
        c.a aVar = new c.a();
        aVar.a(0.1f);
        this.Wa = new com.adobe.creativesdk.foundation.internal.storage.controllers.a.f(x());
        this.Wa.a(getFragmentManager(), aVar);
        super.onCreate(bundle);
        this.La = ContextCompat.getDrawable(getActivity(), c.a.a.a.b.d.asset_edit_home_as_up_cross);
        this.Ma = ContextCompat.getDrawable(getActivity(), c.a.a.a.b.d.asset_edit_home_as_up_back);
        this.Na = AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout.ADOBE_STORAGE_VISUAL_LAYOUT_LISTVIEW != c.a.a.a.c.a.c.d();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0415hc, com.adobe.creativesdk.foundation.internal.storage.controllers.Hb, android.support.v4.app.Fragment
    public void onDestroy() {
        com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar = this.Wa;
        if (fVar != null) {
            fVar.a();
        }
        this.Wa = null;
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0415hc, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0415hc, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.edit.G
    public void w() {
        E e2 = this.Va;
        if (e2 != null) {
            e2.b(true);
        }
        this.Ja.setNavigationIcon(this.La);
        this.Ia = 1;
        com.adobe.creativesdk.foundation.internal.utils.b.a(this.Ka, "" + this.Ia, -1);
        r(true);
    }

    private void r(boolean z) {
        E e2 = this.Va;
        if (e2 != null) {
            e2.a(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(E e2) {
        this.Va = e2;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0415hc
    protected void a(C0390h c0390h) {
        o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Toolbar toolbar, View view) {
        this.Ja = toolbar;
        this.Ka = view;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0415hc, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void c(Bundle bundle) {
        super.c(bundle);
        wb();
    }
}
