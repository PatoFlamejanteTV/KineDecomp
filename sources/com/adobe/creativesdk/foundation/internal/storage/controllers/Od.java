package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementException;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.controllers.a.c;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.internal.storage.controllers.utils.AdobeAssetType;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCatalog;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;
import com.facebook.internal.NativeProtocol;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Observer;

/* compiled from: PhotosCollectionFragment.java */
/* loaded from: classes.dex */
public class Od extends AbstractC0414hb {
    private Rd P;
    private b Q;
    private com.adobe.creativesdk.foundation.internal.storage.U R;
    private Observer S;
    private a T;
    private View U;
    private FloatingActionsMenu V;
    private com.adobe.creativesdk.foundation.internal.storage.controllers.a.f W;
    private Observer X;

    /* compiled from: PhotosCollectionFragment.java */
    /* loaded from: classes.dex */
    private class a extends com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c {
        private a() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c
        protected EnumSet<AdobeAssetViewBrowserCommandName> a() {
            return EnumSet.of(AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_PHOTOCOLLECTION_CREATED, AdobeAssetViewBrowserCommandName.ACTION_PHOTOVIEW_EDIT_COMPLETED);
        }

        /* synthetic */ a(Od od, Kd kd) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c
        public void a(AdobeAssetViewBrowserCommandName adobeAssetViewBrowserCommandName, Object obj) {
            if (adobeAssetViewBrowserCommandName == AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_PHOTOCOLLECTION_CREATED) {
                Od.this.ra();
            } else if (adobeAssetViewBrowserCommandName == AdobeAssetViewBrowserCommandName.ACTION_PHOTOVIEW_EDIT_COMPLETED) {
                Od.this.ra();
            }
        }
    }

    /* compiled from: PhotosCollectionFragment.java */
    /* loaded from: classes.dex */
    private class b implements com.adobe.creativesdk.foundation.internal.storage.ja {
        private b() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ja
        public void a(AdobeCSDKException adobeCSDKException) {
            a(adobeCSDKException, true);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ja
        public void a(AdobePhotoCatalog adobePhotoCatalog) {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ja
        public void b(AdobeCSDKException adobeCSDKException) {
            a(adobeCSDKException, true);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ja
        public void c(AdobeCSDKException adobeCSDKException) {
            a(adobeCSDKException, false);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ja
        public void d() {
            Od.this.H();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ja
        public void e() {
        }

        /* synthetic */ b(Od od, Kd kd) {
            this();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ja
        public void a() {
            Od.this.J();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ja
        public void b() {
            Od od = Od.this;
            od.a(od.R.getCount(), null, null);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ja
        public void c() {
            Od.this.I();
        }

        private void a(AdobeCSDKException adobeCSDKException, boolean z) {
            Od.this.F();
            AdobePhotoException adobePhotoException = (AdobePhotoException) adobeCSDKException;
            int i = 0;
            if (adobePhotoException.getData() != null && adobePhotoException.getData().containsKey(AdobeEntitlementException.AdobeNetworkHTTPStatusKey)) {
                i = ((Integer) adobePhotoException.getData().get(AdobeEntitlementException.AdobeNetworkHTTPStatusKey)).intValue();
            }
            if (adobeCSDKException instanceof AdobePhotoException) {
                if (i == 401 || i == 404) {
                    if (z) {
                        Od.this.G();
                    }
                } else {
                    if (i != 600) {
                        return;
                    }
                    Od.this.oa();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wa() {
        com.adobe.creativesdk.foundation.internal.analytics.q.a("mobile.ccmobile.createNewPhotoCollection", new HashMap<String, String>() { // from class: com.adobe.creativesdk.foundation.internal.storage.controllers.PhotosCollectionFragment$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                put("area", "operations");
                put("type", "photoCollection");
                put(NativeProtocol.WEB_DIALOG_ACTION, "create");
            }
        }, null);
        a(AdobeAssetViewBrowserCommandName.ACTION_MENU_CREATE_NEW_PHOTOCOLLECTION, (Object) null);
    }

    private void Xa() {
        this.U.setOnClickListener(new Md(this));
        this.V.setOnFloatingActionsMenuUpdateListener(new Nd(this));
        if (!la()) {
            this.V.setVisibility(8);
        } else {
            this.V.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void Ca() {
        super.Ca();
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeStorageSelectedAssetAssetCountChangeNotification, this.S);
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeStorageSelectedAssetMultiselectModeDidChangeNotification, this.S);
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeCCFilesUploadSessionComplete, this.X);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected int L() {
        return com.adobe.creativesdk.foundation.internal.storage.ca.d();
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
        return this.R;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected int Q() {
        f(true);
        return c.a.a.a.b.g.adobe_photo_assetbrowser_empty_state_view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void V() {
        Rd rd = this.P;
        if (rd != null) {
            rd.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void W() {
        com.adobe.creativesdk.foundation.internal.storage.ca.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void Z() {
        C0358a.a().a(AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_OPEN_SELECTED_PHOTOS);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void a(C0474t c0474t) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.utils.b bVar) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(Object obj) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected boolean ca() {
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void fa() {
        FloatingActionsMenu floatingActionsMenu = this.V;
        if (floatingActionsMenu != null) {
            floatingActionsMenu.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public boolean g(String str) {
        Rd rd = this.P;
        if (rd == null) {
            return false;
        }
        rd.a(str);
        return true;
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        int R = R();
        int a2 = a((Activity) getActivity());
        if (this.V != null) {
            c(R, a2);
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c.a aVar = new c.a();
        aVar.a(0.1f);
        this.W = new com.adobe.creativesdk.foundation.internal.storage.controllers.a.f(x());
        this.W.a(getFragmentManager(), aVar);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar = this.W;
        if (fVar != null) {
            fVar.a();
        }
        this.W = null;
        super.onDestroy();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.T.b();
        if (com.adobe.creativesdk.foundation.internal.storage.controllers.upload.f.f6445a) {
            ra();
            com.adobe.creativesdk.foundation.internal.storage.controllers.upload.f.f6445a = false;
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.T.c();
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        RecyclerView b2 = this.P.b(getContext());
        b2.setClipToPadding(false);
        b2.setPadding(b2.getPaddingLeft(), b2.getPaddingTop(), b2.getPaddingRight(), com.adobe.creativesdk.foundation.internal.utils.v.a(getActivity()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void qa() {
        super.qa();
        if (this.S == null) {
            this.S = new Kd(this);
        }
        if (this.X == null) {
            this.X = new Ld(this);
        }
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeStorageSelectedAssetAssetCountChangeNotification, this.S);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeStorageSelectedAssetMultiselectModeDidChangeNotification, this.S);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeCCFilesUploadSessionComplete, this.X);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public boolean s() {
        return false;
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
        this.P = new Rd(getActivity());
        this.P.a(this);
        this.P.a(this.W);
        this.Q = new b(this, null);
        this.R = new com.adobe.creativesdk.foundation.internal.storage.U(this.Q, this.f6104c.a());
        this.P.a(this.R);
        this.P.e(getActivity());
        this.f6105d = this.P;
        this.R.e();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void ya() {
        Rd rd = this.P;
        if (rd != null) {
            rd.p();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void z() {
        if (Boolean.valueOf(C0455p.b(getContext())).booleanValue()) {
            RelativeLayout relativeLayout = (RelativeLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(c.a.a.a.b.g.adobe_design_library_floating_menu, (ViewGroup) null);
            this.V = (FloatingActionsMenu) relativeLayout.findViewById(c.a.a.a.b.e.adobe_library_collection_FAB);
            this.U = relativeLayout.findViewById(c.a.a.a.b.e.adobe_library_alpha_pane);
            Xa();
            relativeLayout.removeView(this.V);
            relativeLayout.removeView(this.U);
            S().addView(this.U);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            layoutParams.setMargins(0, 0, R(), a((Activity) getActivity()));
            S().addView(this.V, layoutParams);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void za() {
        FloatingActionsMenu floatingActionsMenu = this.V;
        if (floatingActionsMenu != null) {
            floatingActionsMenu.setVisibility(0);
        }
    }

    private void c(int i, int i2) {
        ((RelativeLayout.LayoutParams) this.V.getLayoutParams()).setMargins(0, 0, i, i2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected C0474t a(Bundle bundle) {
        G g2 = new G();
        g2.a(getArguments());
        return g2;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void d(boolean z) {
        if (z) {
            this.R.a(this.Q);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(Object obj, View view) {
        if (getActivity() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.utils.e) {
            ((com.adobe.creativesdk.foundation.internal.storage.controllers.utils.e) getActivity()).a(obj, this.f6104c, view, AdobeAssetType.ADOBE_ASSET_TYPE_PHOTOS);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void c(Bundle bundle) {
        super.c(bundle);
        this.T = new a(this, null);
        z();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void a(View view) {
        ((ImageView) view.findViewById(c.a.a.a.b.e.adobe_csdk_photo_asset_browser_empty_state_icon)).setImageResource(c.a.a.a.b.d.adobe_emptystate_lightroom);
        ((TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_photo_asset_browser_empty_state_message)).setText(getResources().getString(c.a.a.a.b.i.adobe_csdk_photo_asset_browser_empty_folder));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.commands.d dVar) {
        com.adobe.creativesdk.foundation.internal.storage.controllers.commands.h hVar = (com.adobe.creativesdk.foundation.internal.storage.controllers.commands.h) dVar;
        com.adobe.creativesdk.foundation.internal.storage.controllers.commands.k kVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.commands.k();
        kVar.c(hVar.c());
        kVar.d(hVar.d());
        kVar.a(hVar.a());
        kVar.b(hVar.b());
        a(AdobeAssetViewBrowserCommandName.NAVIGATE_TO_PHOTO_COLLECTION, kVar);
    }
}
