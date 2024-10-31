package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.C0507f;
import com.adobe.creativesdk.foundation.internal.storage.C0532z;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb;
import com.adobe.creativesdk.foundation.internal.storage.controllers.a.c;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.internal.storage.controllers.edit.C0394l;
import com.adobe.creativesdk.foundation.internal.storage.controllers.utils.AdobeAssetType;
import com.adobe.creativesdk.foundation.storage.AdobeAssetDataSourceType;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFolderOrderBy;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFolderOrderDirection;
import com.adobe.creativesdk.foundation.storage.AdobeAssetPackagePages;
import com.adobe.creativesdk.foundation.storage.C0545d;
import com.adobe.creativesdk.foundation.storage.C0547db;
import com.adobe.creativesdk.foundation.storage.C0561h;
import com.facebook.internal.NativeProtocol;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Observer;

/* compiled from: MobileCreationPackageCollectionFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.hd, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0416hd extends AbstractC0414hb {
    C0436ld P;
    C0507f Q;
    AdobeAssetDataSourceType R;
    c S;
    Observer T;
    com.adobe.creativesdk.foundation.internal.storage.controllers.a.f U;
    AdobeCloud V;
    EnumSet<AdobeAssetDataSourceType> W;
    private int X = 0;
    private b Y;

    /* compiled from: MobileCreationPackageCollectionFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.hd$b */
    /* loaded from: classes.dex */
    private class b extends com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c {
        private b() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c
        protected EnumSet<AdobeAssetViewBrowserCommandName> a() {
            return EnumSet.of(AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_EDIT_COMPLETED);
        }

        /* synthetic */ b(C0416hd c0416hd, C0411gd c0411gd) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c
        public void a(AdobeAssetViewBrowserCommandName adobeAssetViewBrowserCommandName, Object obj) {
            if (adobeAssetViewBrowserCommandName != AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_EDIT_COMPLETED) {
                return;
            }
            C0416hd.a(C0416hd.this);
            throw null;
        }
    }

    /* compiled from: MobileCreationPackageCollectionFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.hd$c */
    /* loaded from: classes.dex */
    private class c implements com.adobe.creativesdk.foundation.internal.storage.ha {
        private c() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ha
        public void a() {
            C0416hd.this.H();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ha
        public void b() {
            C0416hd.this.I();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ha
        public void c() {
            C0416hd c0416hd = C0416hd.this;
            c0416hd.m(c0416hd.Q.getCount());
        }

        /* synthetic */ c(C0416hd c0416hd, C0411gd c0411gd) {
            this();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ha
        public void a(int i) {
            C0416hd.this.a(i, null, null);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ha
        public void a(AdobeAssetException adobeAssetException) {
            C0416hd.this.a(adobeAssetException);
        }
    }

    private void Wa() {
        com.adobe.creativesdk.foundation.internal.storage.controllers.edit.u.a().a();
        throw null;
    }

    private boolean Xa() {
        EnumSet<AdobeAssetDataSourceType> enumSet = this.W;
        return enumSet != null && enumSet.size() > 0;
    }

    static /* synthetic */ void a(C0416hd c0416hd) {
        c0416hd.Wa();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void Ca() {
        super.Ca();
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeStorageSelectedAssetAssetCountChangeNotification, this.T);
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeStorageSelectedAssetMultiselectModeDidChangeNotification, this.T);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected AbstractC0414hb.b D() {
        return new a();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected int L() {
        return 0;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected String N() {
        if (C0455p.b(x())) {
            return getResources().getString(c.a.a.a.b.i.adobe_csdk_cc_title);
        }
        return getResources().getString(c.a.a.a.b.i.adobe_csdk_asset_browser_title);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected String O() {
        return null;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected com.adobe.creativesdk.foundation.internal.storage.ga P() {
        return this.Q;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected int Q() {
        return c.a.a.a.b.g.adobe_photo_assetbrowser_empty_state_view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void V() {
        this.P.o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void W() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void Z() {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void a(C0474t c0474t) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.utils.b bVar) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected boolean ca() {
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void d(boolean z) {
        if (z) {
            this.Q.a(this.S);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public boolean g(String str) {
        C0436ld c0436ld = this.P;
        if (c0436ld == null) {
            return false;
        }
        c0436ld.a(str);
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void k() {
        this.Q.c();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void m(int i) {
        super.m(i);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Y = new b(this, null);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar = this.U;
        if (fVar != null) {
            fVar.a();
            this.U = null;
        }
        super.onDestroy();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.Y.b();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.Y.c();
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        C0436ld c0436ld = this.P;
        if (c0436ld == null) {
            return;
        }
        RecyclerView a2 = c0436ld.a(getContext());
        a2.setClipToPadding(false);
        a2.setPadding(a2.getPaddingLeft(), a2.getPaddingTop(), a2.getPaddingRight(), com.adobe.creativesdk.foundation.internal.utils.v.a(getActivity()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void qa() {
        super.qa();
        if (this.T == null) {
            this.T = new C0411gd(this);
        }
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeStorageSelectedAssetAssetCountChangeNotification, this.T);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeStorageSelectedAssetMultiselectModeDidChangeNotification, this.T);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public boolean s() {
        return this.f6104c.g();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void sa() {
        View d2 = this.P.d();
        if (M().indexOfChild(d2) == -1) {
            M().addView(d2);
        }
        this.f6105d = this.P;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void va() {
        if (this.P != null) {
            return;
        }
        c.a aVar = new c.a();
        aVar.a(0.1f);
        this.U = new com.adobe.creativesdk.foundation.internal.storage.controllers.a.f(getActivity());
        this.U.a(getActivity().getSupportFragmentManager(), aVar);
        this.P = new C0453oc(getActivity());
        this.P.a(this);
        this.P.a(this.U);
        if (Xa()) {
            this.Q = new C0532z(this.W, this.f6104c.a());
        } else {
            this.R = AdobeAssetDataSourceType.AdobeAssetDataSourceMobileCreations;
            this.Q = new C0532z(this.R, this.f6104c.a());
        }
        this.S = new c(this, null);
        this.Q.a(this.S);
        this.P.a(this.Q);
        this.P.d(getActivity());
        this.Q.a(true);
        this.f6105d = this.P;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected C0474t a(Bundle bundle) {
        C0474t c0474t = new C0474t();
        c0474t.a(getArguments());
        this.R = c0474t.b();
        this.V = c0474t.a();
        this.W = c0474t.e();
        return c0474t;
    }

    /* compiled from: MobileCreationPackageCollectionFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.hd$a */
    /* loaded from: classes.dex */
    class a extends AbstractC0414hb.a {
        protected MenuItem i;

        a() {
            super();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(c.a.a.a.b.h.adobe_assetview_common_sort, menu);
            this.i = menu.findItem(c.a.a.a.b.e.adobe_csdk_uxassetbrowser_sdk_common_menu_sortbydate);
            super.a(menu, menuInflater);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(Menu menu) {
            this.i.setTitle(C0455p.a(C0416hd.this.getResources().getString(c.a.a.a.b.i.adobe_csdk_mobilecreations_sort), C0416hd.this.getActivity()));
            this.i.setVisible(false);
            super.a(menu);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public boolean a(int i) {
            if (i == c.a.a.a.b.e.adobe_csdk_uxassetbrowser_sdk_common_menu_sortbydate) {
                com.adobe.creativesdk.foundation.internal.analytics.q.a("mobile.ccmobile.sortby.date", new HashMap<String, String>() { // from class: com.adobe.creativesdk.foundation.internal.storage.controllers.MobileCreationPackageCollectionFragment$ActionBarController$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        put("area", "browser");
                        put("type", "mobileCreations");
                        put(NativeProtocol.WEB_DIALOG_ACTION, "sortByDate");
                    }
                }, null);
                AdobeAssetFolderOrderBy adobeAssetFolderOrderBy = AdobeAssetFolderOrderBy.ADOBE_ASSET_FOLDER_ORDER_BY_MODIFIED;
                AdobeAssetFolderOrderDirection adobeAssetFolderOrderDirection = AdobeAssetFolderOrderDirection.ADOBE_ASSET_FOLDER_ORDER_ASCENDING;
                C0507f c0507f = (C0507f) C0416hd.this.P();
                c0507f.f().b(adobeAssetFolderOrderBy, adobeAssetFolderOrderDirection);
                c0507f.a(true);
                return true;
            }
            return super.a(i);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(Object obj, View view) {
        if ((x() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.utils.e) && !C0394l.e() && la()) {
            ((com.adobe.creativesdk.foundation.internal.storage.controllers.utils.e) getActivity()).a(obj, this.f6104c, view, AdobeAssetType.ADOBE_ASSET_TYPE_MOBILE_CREATION);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void a(View view) {
        view.findViewById(c.a.a.a.b.e.adobe_csdk_photo_asset_browser_empty_state_icon).setVisibility(0);
        ((TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_photo_asset_browser_empty_state_message)).setText(getResources().getString(c.a.a.a.b.i.adobe_csdk_all_mobilecreations_empty_collection));
    }

    public static AdobeAssetDataSourceType a(AdobeAssetPackagePages adobeAssetPackagePages) {
        AdobeAssetDataSourceType adobeAssetDataSourceType = AdobeAssetDataSourceType.AdobeAssetDataSourceFiles;
        if (adobeAssetPackagePages instanceof C0547db) {
            return AdobeAssetDataSourceType.AdobeAssetDataSourceSketches;
        }
        if (adobeAssetPackagePages instanceof C0561h) {
            return AdobeAssetDataSourceType.AdobeAssetDataSourceDraw;
        }
        if (adobeAssetPackagePages instanceof com.adobe.creativesdk.foundation.storage.Ua) {
            return AdobeAssetDataSourceType.AdobeAssetDataSourcePSMix;
        }
        if (adobeAssetPackagePages instanceof C0545d) {
            return AdobeAssetDataSourceType.AdobeAssetDataSourceCompositions;
        }
        return adobeAssetPackagePages instanceof com.adobe.creativesdk.foundation.storage.Ra ? AdobeAssetDataSourceType.AdobeAssetDataSourcePSFix : adobeAssetDataSourceType;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.commands.d dVar) {
        a(AdobeAssetViewBrowserCommandName.NAVIGATE_TO_MOBILECREATION_COLLECTION, dVar);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(Object obj) {
        int a2;
        com.adobe.creativesdk.foundation.internal.storage.controllers.utils.g gVar = (com.adobe.creativesdk.foundation.internal.storage.controllers.utils.g) obj;
        if (!(getActivity() instanceof AdobeUxAssetBrowserV2Activity) && C0455p.b(getActivity())) {
            a2 = com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.e.b();
        } else {
            a2 = com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.e.a();
        }
        com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.h hVar = (com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.h) com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.c.a(a2).a("ADOBE_ONE_UP_VIEW_MOBILE_CREATION_CONFIGURATION");
        hVar.a(gVar.f6500c);
        hVar.a(gVar.f6498a);
        hVar.b(0);
        Intent intent = new Intent();
        intent.setClass(getActivity(), AdobeUXCompositionOneUpViewerActivity.class);
        intent.putExtra("one_up_controller_code", a2);
        getActivity().startActivityForResult(intent, 2137);
    }
}
