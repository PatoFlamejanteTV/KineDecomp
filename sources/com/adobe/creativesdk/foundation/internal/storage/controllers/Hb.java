package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.AdobeStorageDataSource;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb;
import com.adobe.creativesdk.foundation.internal.storage.controllers.a.c;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.C0578la;
import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observer;

/* compiled from: CCFilesFragment.java */
/* loaded from: classes.dex */
public class Hb extends AbstractC0414hb {
    private C0578la P;
    protected Kb Q;
    protected Ub R;
    private AdobeStorageDataSource S;
    private c T;
    private Observer U;
    private b V;
    private Observer W;
    private int X = -1;
    private Observer Y;
    private AdobeCloud Z;
    protected boolean aa;
    private com.adobe.creativesdk.foundation.internal.storage.controllers.a.f ba;

    /* compiled from: CCFilesFragment.java */
    /* loaded from: classes.dex */
    protected class b {

        /* renamed from: a, reason: collision with root package name */
        public AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout f5658a;

        protected b() {
        }
    }

    /* compiled from: CCFilesFragment.java */
    /* loaded from: classes.dex */
    protected class c implements com.adobe.creativesdk.foundation.internal.storage.ka {
        protected c() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ka
        public void a() {
            Hb.this.H();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ka
        public void a(AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType, AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState) {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ka
        public void b() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ka
        public void c() {
            Hb.this.Ea();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ka
        public void d() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ka
        public void e() {
            Hb.this.Da();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ka
        public void f() {
            Hb.this.I();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ka
        public void g() {
            Hb.this.J();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ka
        public void h() {
            Hb.this.E();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ka
        public void a(int i, com.adobe.creativesdk.foundation.internal.storage.model.util.b bVar, ArrayList<com.adobe.creativesdk.foundation.internal.storage.model.util.a> arrayList) {
            Hb.this.a(i, bVar, arrayList);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ka
        public void a(AdobeAssetException adobeAssetException) {
            Hb.this.a(adobeAssetException);
        }
    }

    private void Wa() {
        k(false);
    }

    private void Xa() {
        l(false);
    }

    private void k(boolean z) {
        FrameLayout M = M();
        M.removeView(this.R.d());
        View d2 = this.Q.d();
        if (M.indexOfChild(d2) == -1) {
            new com.adobe.creativesdk.foundation.internal.analytics.c("grid", "cc_file").a();
            M.addView(d2);
        }
        a((Rb) this.Q);
    }

    private void l(boolean z) {
        FrameLayout M = M();
        M.removeView(this.Q.d());
        View d2 = this.R.d();
        if (M.indexOfChild(d2) == -1) {
            new com.adobe.creativesdk.foundation.internal.analytics.c("list", "cc_file").a();
            M.addView(d2);
        }
        a((Rb) this.R);
    }

    private void m(boolean z) {
        if (AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout.ADOBE_STORAGE_VISUAL_LAYOUT_LISTVIEW == c.a.a.a.c.a.c.d()) {
            l(z);
        } else {
            k(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void B() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void Ca() {
        super.Ca();
        this.N.c(AdobeInternalNotificationID.AdobeStorageSelectedAssetAssetCountChangeNotification);
        this.N.c(AdobeInternalNotificationID.AdobeStorageSelectedAssetMultiselectModeDidChangeNotification);
        this.N.c(AdobeInternalNotificationID.AdobeCCFilesForceRefreshAssetsList);
        this.N.c(AdobeInternalNotificationID.AdobeUxTabDataSourceChanged);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected AbstractC0414hb.b D() {
        return new a();
    }

    protected void Da() {
    }

    protected void Ea() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AdobeStorageDataSource.DataSourceInternalFilters Fa() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C0578la Ga() {
        return this.P;
    }

    protected Kb Ha() {
        Kb kb = new Kb(getActivity());
        kb.a(this.ba);
        return kb;
    }

    protected Ub Ia() {
        return new Ub(getActivity());
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected int L() {
        return com.adobe.creativesdk.foundation.internal.storage.W.d();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected String N() {
        return getString(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_csdk_myassets_main);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public String O() {
        return this.P.getName();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected com.adobe.creativesdk.foundation.internal.storage.ga P() {
        return this.S;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void T() {
        int i = this.X;
        if (i != -1 && this.f6105d != null && i != com.adobe.creativesdk.foundation.internal.storage.W.a()) {
            ((Rb) this.f6105d).n();
        }
        this.X = -1;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected boolean U() {
        return this.S.l();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void V() {
        AbstractC0457pb abstractC0457pb = this.f6105d;
        if (abstractC0457pb != null) {
            if (abstractC0457pb instanceof Kb) {
                this.Q.m();
            } else if (abstractC0457pb instanceof Ub) {
                this.R.m();
            }
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void W() {
        com.adobe.creativesdk.foundation.internal.storage.W.c();
        Kb kb = this.Q;
        if (kb != null) {
            kb.n();
        }
        Ub ub = this.R;
        if (ub != null) {
            ub.n();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void X() {
        super.X();
        com.adobe.creativesdk.foundation.internal.storage.controllers.c.b bVar = this.N;
        if (bVar != null) {
            if (bVar.b(AdobeInternalNotificationID.AdobeCCFilesForceRefreshAssetsList) != null) {
                q();
            }
            this.N.a(AdobeInternalNotificationID.AdobeStorageSelectedAssetAssetCountChangeNotification);
            this.N.a(AdobeInternalNotificationID.AdobeStorageSelectedAssetMultiselectModeDidChangeNotification);
            this.N.a(AdobeInternalNotificationID.AdobeCCFilesForceRefreshAssetsList);
            this.N.a(AdobeInternalNotificationID.AdobeUxTabDataSourceChanged);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void Y() {
        super.Y();
        this.X = com.adobe.creativesdk.foundation.internal.storage.W.a();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void Z() {
        C0358a.a().a(AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_OPEN_SELECTED_FILES);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.utils.b bVar) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(Object obj, View view) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void aa() {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected boolean ca() {
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void d(boolean z) {
        this.S.a(this.T);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected boolean g(String str) {
        AdobeStorageDataSource adobeStorageDataSource = this.S;
        if (adobeStorageDataSource == null) {
            return false;
        }
        adobeStorageDataSource.a(str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(String str) {
        this.P = C0455p.a(str, true);
    }

    protected void i(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public boolean ia() {
        C0578la c0578la = this.P;
        return c0578la == null || com.adobe.creativesdk.foundation.internal.storage.model.util.c.a(c0578la);
    }

    public void j(boolean z) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected boolean ma() {
        return C0363b.a().a(Ga(), true);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c.a aVar = new c.a();
        aVar.a(0.1f);
        this.ba = new com.adobe.creativesdk.foundation.internal.storage.controllers.a.f(x());
        this.ba.a(getFragmentManager(), aVar);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar = this.ba;
        if (fVar != null) {
            fVar.a();
        }
        this.ba = null;
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        RecyclerView b2 = this.Q.b(getContext());
        RecyclerView b3 = this.R.b(getContext());
        b2.setClipToPadding(false);
        b3.setClipToPadding(false);
        int a2 = com.adobe.creativesdk.foundation.internal.utils.v.a(getActivity());
        b2.setPadding(b2.getPaddingLeft(), b2.getPaddingTop(), b2.getPaddingRight(), a2);
        b3.setPadding(b3.getPaddingLeft(), b3.getPaddingTop(), b3.getPaddingRight(), a2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void q() {
        com.adobe.creativesdk.foundation.internal.analytics.q.a("mobile.ccmobile.pullToRefresh", new HashMap<String, String>() { // from class: com.adobe.creativesdk.foundation.internal.storage.controllers.CCFilesFragment$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                put("area", "browser");
                put("type", "assets");
                put(NativeProtocol.WEB_DIALOG_ACTION, "pullToRefresh");
            }
        }, null);
        super.q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void qa() {
        super.qa();
        if (this.U == null) {
            this.U = new Eb(this);
        }
        if (this.W == null) {
            this.W = new Fb(this);
        }
        if (this.Y == null) {
            this.Y = new Gb(this);
        }
        this.N.a(AdobeInternalNotificationID.AdobeStorageSelectedAssetAssetCountChangeNotification, this.U);
        this.N.a(AdobeInternalNotificationID.AdobeStorageSelectedAssetMultiselectModeDidChangeNotification, this.U);
        this.N.a(AdobeInternalNotificationID.AdobeCCFilesForceRefreshAssetsList, this.W);
        this.N.a(AdobeInternalNotificationID.AdobeUxTabDataSourceChanged, this.Y);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public boolean s() {
        return this.f6104c.g();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void sa() {
        m(false);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void ta() {
        if (this.V == null || c.a.a.a.c.a.c.d() != this.V.f5658a) {
            return;
        }
        super.ta();
        this.V = null;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void ua() {
        super.ua();
        this.V = new b();
        this.V.f5658a = c.a.a.a.c.a.c.d();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void va() {
        if (this.Q != null) {
            return;
        }
        this.T = new c();
        this.S = new AdobeStorageDataSource();
        this.S.a(this.P);
        this.S.a(this.T);
        this.S.a(this.f6104c.d());
        this.S.b(this.f6104c.c());
        this.S.a(Fa());
        this.Q = Ha();
        this.Q.a(this);
        this.Q.b(this.f6104c.g());
        this.R = Ia();
        this.R.a(this);
        this.R.b(this.f6104c.g());
        this.Q.a(this.f6104c);
        this.R.a(this.f6104c);
        this.Q.e(getActivity());
        this.R.e(getActivity());
        this.Q.a(this.S);
        this.R.a(this.S);
        this.S.a(true);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void ya() {
        Kb kb = this.Q;
        if (kb != null) {
            kb.r();
        }
        Ub ub = this.R;
        if (ub != null) {
            ub.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: CCFilesFragment.java */
    /* loaded from: classes.dex */
    public class a extends AbstractC0414hb.b {

        /* renamed from: h, reason: collision with root package name */
        AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType f5657h;
        AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState i;
        AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout j;
        private MenuItem k;
        private MenuItem l;

        /* JADX INFO: Access modifiers changed from: protected */
        public a() {
            super();
        }

        private void i() {
            AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType = this.f5657h;
            AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType2 = AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType.SORT_TYPE_ALPHA;
            if (adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType == adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType2) {
                this.f5657h = AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType.SORT_TYPE_TIME;
                this.i = AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState.SORT_STATE_DESCENDING;
            } else {
                this.f5657h = adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType2;
                this.i = AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState.SORT_STATE_ASCENDING;
            }
            c.a.a.a.c.a.c.a(this.f5657h);
            c.a.a.a.c.a.c.a(this.i);
            Hb.this.S.a(this.f5657h, this.i);
        }

        private void j() {
            AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout = this.j;
            AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout2 = AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout.ADOBE_STORAGE_VISUAL_LAYOUT_LISTVIEW;
            if (adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout == adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout2) {
                this.j = AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout.ADOBE_STORAGE_VISUAL_LAYOUT_WATERFALL;
            } else {
                this.j = adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout2;
            }
            Hb.this.a(this.j);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(c.a.a.a.b.h.adobe_asset_browser_menu, menu);
            super.a(menu, menuInflater);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void b() {
            h();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void c() {
            String o;
            String o2;
            super.c();
            if (this.k == null) {
                return;
            }
            if (this.j == AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout.ADOBE_STORAGE_VISUAL_LAYOUT_LISTVIEW) {
                o = Hb.this.o(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_action_asgrid);
            } else {
                o = Hb.this.o(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_action_aslist);
            }
            this.k.setTitleCondensed(o);
            this.k.setTitle(Hb.this.f(o));
            if (this.f5657h == AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType.SORT_TYPE_ALPHA) {
                o2 = Hb.this.o(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_action_sort_date);
            } else {
                o2 = Hb.this.o(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_action_sort_alpha);
            }
            this.l.setTitleCondensed(o2);
            this.l.setTitle(Hb.this.f(o2));
            MenuItem menuItem = this.f6111a;
            Hb hb = Hb.this;
            menuItem.setTitle(hb.f(hb.o(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_sdk_myaccount)));
            this.f6111a.setVisible(!Hb.this.na() && f());
            boolean ha = Hb.this.ha();
            this.k.setVisible(!Hb.this.na() && ha);
            this.l.setVisible(!Hb.this.na() && ha);
            Hb hb2 = Hb.this;
            hb2.i(!hb2.na() && ha);
        }

        public void h() {
            this.j = c.a.a.a.c.a.c.d();
            this.i = c.a.a.a.c.a.c.b();
            this.f5657h = c.a.a.a.c.a.c.c();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(Menu menu) {
            super.a(menu);
            if (Hb.this.M() != null) {
                this.k = menu.findItem(c.a.a.a.b.e.adobe_csdk_uxassetbrowser_assets_viewtype);
                this.l = menu.findItem(c.a.a.a.b.e.adobe_csdk_uxassetbrowser_assets_view_sorttype);
                c();
            }
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(boolean z) {
            MenuItem menuItem = this.k;
            if (menuItem != null) {
                menuItem.setVisible(z && !Hb.this.na());
            }
            MenuItem menuItem2 = this.l;
            if (menuItem2 != null) {
                menuItem2.setVisible(z && !Hb.this.na());
            }
            Hb.this.j(z);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public boolean a(int i) {
            if (i == c.a.a.a.b.e.adobe_csdk_uxassetbrowser_assets_viewtype) {
                j();
                if (this.j == AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout.ADOBE_STORAGE_VISUAL_LAYOUT_LISTVIEW) {
                    com.adobe.creativesdk.foundation.internal.analytics.q.a("View As List");
                    com.adobe.creativesdk.foundation.internal.analytics.q.a("mobile.ccmobile.viewas.list", new HashMap<String, String>() { // from class: com.adobe.creativesdk.foundation.internal.storage.controllers.CCFilesFragment$CCFilesActionBarController$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            put("area", "browser");
                            put("type", "layout");
                            put(NativeProtocol.WEB_DIALOG_ACTION, "viewAsList");
                        }
                    }, null);
                } else {
                    com.adobe.creativesdk.foundation.internal.analytics.q.a("View As Grid");
                    com.adobe.creativesdk.foundation.internal.analytics.q.a("mobile.ccmobile.viewas.grid", new HashMap<String, String>() { // from class: com.adobe.creativesdk.foundation.internal.storage.controllers.CCFilesFragment$CCFilesActionBarController$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            put("area", "browser");
                            put("type", "layout");
                            put(NativeProtocol.WEB_DIALOG_ACTION, "viewAsGrid");
                        }
                    }, null);
                }
                return true;
            }
            if (i == c.a.a.a.b.e.adobe_csdk_uxassetbrowser_assets_view_sorttype) {
                i();
                if (this.f5657h == AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType.SORT_TYPE_ALPHA) {
                    com.adobe.creativesdk.foundation.internal.analytics.q.a("Sort Alphabetically");
                    com.adobe.creativesdk.foundation.internal.analytics.q.a("mobile.ccmobile.sortby.alpha", new HashMap<String, String>() { // from class: com.adobe.creativesdk.foundation.internal.storage.controllers.CCFilesFragment$CCFilesActionBarController$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            put("area", "browser");
                            put("type", "files");
                            put(NativeProtocol.WEB_DIALOG_ACTION, "sortByAlpha");
                        }
                    }, null);
                } else {
                    com.adobe.creativesdk.foundation.internal.analytics.q.a("Sort By Date");
                    com.adobe.creativesdk.foundation.internal.analytics.q.a("mobile.ccmobile.sortby.date", new HashMap<String, String>() { // from class: com.adobe.creativesdk.foundation.internal.storage.controllers.CCFilesFragment$CCFilesActionBarController$4
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            put("area", "browser");
                            put("type", "files");
                            put(NativeProtocol.WEB_DIALOG_ACTION, "sortByDate");
                        }
                    }, null);
                }
                ((Db) Hb.this.f6105d).f5612e.scrollToPosition(0);
                return true;
            }
            if (i == c.a.a.a.b.e.adobe_csdk_uxassetbrowser_sdk_photos_myaccount) {
                Hb.this.a(AdobeAssetViewBrowserCommandName.ACTION_MENU_SHOW_MY_ACCOUNT, (Object) null);
                return true;
            }
            return super.a(i);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected C0474t a(Bundle bundle) {
        C0474t c0474t = new C0474t();
        c0474t.a(bundle);
        this.Z = c0474t.a();
        this.aa = c0474t.g();
        return c0474t;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.commands.d dVar) {
        com.adobe.creativesdk.foundation.internal.storage.controllers.commands.e eVar = (com.adobe.creativesdk.foundation.internal.storage.controllers.commands.e) dVar;
        com.adobe.creativesdk.foundation.internal.storage.controllers.commands.i iVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.commands.i();
        iVar.a(eVar.a());
        iVar.a(eVar.b());
        iVar.a(eVar.c() || this.f6104c.g());
        a(AdobeAssetViewBrowserCommandName.NAVIGATE_TO_COLLECTION, iVar);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(Object obj) {
        if (obj instanceof AdobeAssetFile) {
            a((AdobeAssetFile) obj);
        }
    }

    protected void a(AdobeAssetFile adobeAssetFile) {
        int a2;
        if (!(getActivity() instanceof AdobeUxAssetBrowserV2Activity) && C0455p.b(getActivity())) {
            a2 = com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.e.b();
        } else {
            a2 = com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.e.a();
        }
        com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.f fVar = (com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.f) com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.c.a(a2).a("ADOBE_ONE_UP_VIEW_ASSET_CONFIGURATION");
        fVar.a(adobeAssetFile);
        fVar.a(this.S);
        Intent intent = new Intent();
        intent.setClass(x(), AdobeUXAssetOneUpViewerActivity.class);
        intent.putExtra("one_up_controller_code", a2);
        intent.putExtra("ADOBE_CLOUD", this.f6104c.a());
        x().startActivityForResult(intent, 2134);
    }

    protected void a(com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar) {
        if (eVar != null) {
            this.P = C0455p.a(eVar);
        } else {
            i((String) null);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void a(C0474t c0474t) {
        com.adobe.creativesdk.foundation.internal.storage.model.resources.e f2 = this.f6104c.f();
        if (f2 != null) {
            f2 = new com.adobe.creativesdk.foundation.internal.storage.model.resources.e(f2);
        }
        a(f2);
    }

    protected void a(Rb rb) {
        this.f6105d = rb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout) {
        if (adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout == AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout.ADOBE_STORAGE_VISUAL_LAYOUT_WATERFALL) {
            Wa();
        } else {
            Xa();
        }
        this.f6105d.e();
        c.a.a.a.c.a.c.a(adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout);
    }
}
