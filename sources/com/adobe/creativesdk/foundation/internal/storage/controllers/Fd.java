package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementException;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb;
import com.adobe.creativesdk.foundation.internal.storage.controllers.a.c;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.internal.storage.controllers.utils.AdobeAssetType;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAsset;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCatalog;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;
import com.facebook.internal.AnalyticsEvents;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import java.util.EnumSet;
import java.util.Observer;

/* compiled from: PhotosAssetsFragment.java */
/* loaded from: classes.dex */
public class Fd extends AbstractC0414hb {
    private e P;
    private com.adobe.creativesdk.foundation.internal.storage.I Q;
    private AdobePhotoCollection R;
    private xd S;
    private Observer T;
    private int U = -1;
    private b V;
    private FloatingActionsMenu W;
    private FloatingActionButton X;
    private FloatingActionButton Y;
    private View Z;
    private Observer aa;
    private boolean ba;
    private boolean ca;
    private com.adobe.creativesdk.foundation.internal.storage.controllers.a.f da;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotosAssetsFragment.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == Fd.this.X.getId()) {
                if (Fd.this.R != null) {
                    if (!Fd.this.ba) {
                        if (ContextCompat.checkSelfPermission(Fd.this.getActivity(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                            Fd.this.ca = true;
                            Fd.this.getParentFragment().requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 2);
                        } else {
                            Fd fd = Fd.this;
                            fd.a(AdobeAssetViewBrowserCommandName.ACTION_PHOTO_UPLOAD_FILES, fd.R);
                        }
                    } else {
                        Fd fd2 = Fd.this;
                        fd2.a(AdobeAssetViewBrowserCommandName.ACTION_CANCEL_PHOTO_UPLOAD, fd2.R);
                    }
                }
            } else if (view.getId() == Fd.this.Y.getId()) {
                Fd fd3 = Fd.this;
                fd3.a(AdobeAssetViewBrowserCommandName.ACTION_PHOTO_UPLOAD_FILES_FROM_CAMERA, fd3.R);
            }
            Fd.this.W.d();
        }

        /* synthetic */ a(Fd fd, Ad ad) {
            this();
        }
    }

    /* compiled from: PhotosAssetsFragment.java */
    /* loaded from: classes.dex */
    private class b extends com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c {
        private b() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c
        protected EnumSet<AdobeAssetViewBrowserCommandName> a() {
            return EnumSet.of(AdobeAssetViewBrowserCommandName.ACTION_PHOTOVIEW_EDIT_COMPLETED);
        }

        /* synthetic */ b(Fd fd, Ad ad) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c
        public void a(AdobeAssetViewBrowserCommandName adobeAssetViewBrowserCommandName, Object obj) {
            if (adobeAssetViewBrowserCommandName == AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_EDIT_COMPLETED || adobeAssetViewBrowserCommandName == AdobeAssetViewBrowserCommandName.ACTION_PHOTOVIEW_EDIT_COMPLETED) {
                Fd.this.ra();
            }
        }
    }

    /* compiled from: PhotosAssetsFragment.java */
    /* loaded from: classes.dex */
    protected class c extends AbstractC0414hb.b {
        protected c() {
            super();
        }

        private void h() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(Menu menu, MenuInflater menuInflater) {
            super.a(menu, menuInflater);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void c() {
            h();
            super.c();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(Menu menu) {
            h();
            super.a(menu);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public boolean a(int i) {
            return super.a(i);
        }
    }

    /* compiled from: PhotosAssetsFragment.java */
    /* loaded from: classes.dex */
    protected class d extends AbstractC0414hb.b {
        protected d() {
            super();
        }
    }

    /* compiled from: PhotosAssetsFragment.java */
    /* loaded from: classes.dex */
    private class e implements com.adobe.creativesdk.foundation.internal.storage.ia {
        private e() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ia
        public void a() {
            Fd.this.H();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ia
        public void b() {
            Fd fd = Fd.this;
            fd.a(fd.Q.getCount(), null, null);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ia
        public void c() {
            Fd.this.I();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ia
        public void d() {
            b();
        }

        /* synthetic */ e(Fd fd, Ad ad) {
            this();
        }

        private void c(AdobeCSDKException adobeCSDKException) {
            Fd.this.F();
            if ((adobeCSDKException instanceof AdobePhotoException) && ((AdobePhotoException) adobeCSDKException).getData().get(AdobeEntitlementException.AdobeNetworkHTTPStatusKey).equals(600)) {
                Fd.this.oa();
            }
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ia
        public void a(AdobeCSDKException adobeCSDKException) {
            c(adobeCSDKException);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ia
        public void b(AdobeCSDKException adobeCSDKException) {
            c(adobeCSDKException);
        }
    }

    private void Wa() {
        if (this.R == null) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t<AdobePhotoCollection> a2 = com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.a(AdobePhotoCollection.class).a((com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r) this.R);
        if (a2 != null) {
            b(a2);
        } else if (a2 == null && this.ba) {
            Xa();
        } else {
            i(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xa() {
        if (this.ba) {
            this.S.p();
            i(false);
            com.adobe.creativesdk.foundation.internal.utils.o.a().postDelayed(new Ed(this), 400L);
        }
    }

    private void Ya() {
        this.W.setOnFloatingActionsMenuUpdateListener(new Ad(this));
        this.Z.setOnClickListener(new Bd(this));
        a aVar = new a(this, null);
        this.X.setOnClickListener(aVar);
        this.Y.setOnClickListener(aVar);
        if (!la()) {
            this.W.setVisibility(8);
        } else {
            this.W.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void Ca() {
        super.Ca();
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeStorageSelectedAssetAssetCountChangeNotification, this.T);
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeStorageSelectedAssetMultiselectModeDidChangeNotification, this.T);
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeCCFilesUploadSessionStarted, this.aa);
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeCCFilesUploadSessionComplete, this.aa);
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeCCFilesUploadSessionCancelled, this.aa);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected AbstractC0414hb.b D() {
        if (!(getActivity() instanceof AdobeUxAssetBrowserV2Activity) && C0455p.b(getActivity())) {
            return new c();
        }
        return new d();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected int L() {
        return com.adobe.creativesdk.foundation.internal.storage.ca.d();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected String N() {
        return getString(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_csdk_myassets_main);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected String O() {
        return this.R.getName();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected com.adobe.creativesdk.foundation.internal.storage.ga P() {
        return this.Q;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected int Q() {
        super.f(true);
        return c.a.a.a.b.g.adobe_photo_assetbrowser_empty_state_view;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void T() {
        int i = this.U;
        if (i != -1 && this.f6105d != null && i != com.adobe.creativesdk.foundation.internal.storage.ca.a()) {
            this.S.n();
        }
        this.U = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void V() {
        xd xdVar = this.S;
        if (xdVar != null) {
            xdVar.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void W() {
        com.adobe.creativesdk.foundation.internal.storage.ca.c();
        xd xdVar = this.S;
        if (xdVar != null) {
            xdVar.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void Y() {
        super.Y();
        this.U = com.adobe.creativesdk.foundation.internal.storage.ca.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void Z() {
        C0358a.a().a(AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_OPEN_SELECTED_PHOTOS);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.commands.d dVar) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.utils.b bVar) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected boolean ca() {
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void fa() {
        FloatingActionsMenu floatingActionsMenu = this.W;
        if (floatingActionsMenu != null) {
            floatingActionsMenu.setVisibility(8);
        }
    }

    protected void i(boolean z) {
        this.ba = z;
        getActivity().invalidateOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public boolean ia() {
        return false;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void k() {
        if (this.Q.f()) {
            super.k();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Boolean.valueOf(com.adobe.creativesdk.foundation.internal.utils.s.a(x()));
        int a2 = a((Activity) getActivity());
        int R = R();
        if (this.W != null) {
            c(R, a2);
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c.a aVar = new c.a();
        aVar.a(0.1f);
        this.da = new com.adobe.creativesdk.foundation.internal.storage.controllers.a.f(x());
        this.da.a(getFragmentManager(), aVar);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar = this.da;
        if (fVar != null) {
            fVar.a();
        }
        this.da = null;
        super.onDestroy();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.ba = false;
        this.S.p();
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.ca && i == 2) {
            this.ca = false;
            if (iArr.length == 1 && iArr[0] == 0) {
                a(AdobeAssetViewBrowserCommandName.ACTION_CANCEL_PHOTO_UPLOAD, this.R);
            } else {
                Toast.makeText(getActivity(), c.a.a.a.b.i.adobe_csdk_extract_permission_denied, 0).show();
            }
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        Wa();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.V.b();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.V.c();
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        RecyclerView b2 = this.S.b(getContext());
        b2.setClipToPadding(false);
        b2.setPadding(b2.getPaddingLeft(), b2.getPaddingTop(), b2.getPaddingRight(), com.adobe.creativesdk.foundation.internal.utils.v.a(getActivity()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void qa() {
        super.qa();
        if (this.T == null) {
            this.T = new Cd(this);
        }
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeStorageSelectedAssetAssetCountChangeNotification, this.T);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeStorageSelectedAssetMultiselectModeDidChangeNotification, this.T);
        if (this.aa == null) {
            this.aa = new Dd(this);
        }
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeCCFilesUploadSessionStarted, this.aa);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeCCFilesUploadSessionComplete, this.aa);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeCCFilesUploadSessionCancelled, this.aa);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public boolean s() {
        return false;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void sa() {
        View d2 = this.S.d();
        if (M().indexOfChild(d2) == -1) {
            M().addView(d2);
        }
        this.f6105d = this.S;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void va() {
        if (this.S != null) {
            return;
        }
        this.S = new xd(getActivity());
        this.S.a(this);
        this.P = new e(this, null);
        this.Q = new com.adobe.creativesdk.foundation.internal.storage.I(this.R, this.P);
        this.S.a(this.Q);
        this.S.e(getActivity());
        this.S.a(this.da);
        this.f6105d = this.S;
        this.Q.g();
        new com.adobe.creativesdk.foundation.internal.analytics.c("grid", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO).a();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void ya() {
        xd xdVar = this.S;
        if (xdVar != null) {
            xdVar.q();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void z() {
        if (Boolean.valueOf(C0455p.b(getContext())).booleanValue()) {
            RelativeLayout relativeLayout = (RelativeLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(c.a.a.a.b.g.adobe_photos_items_floating_menu, (ViewGroup) null);
            this.W = (FloatingActionsMenu) relativeLayout.findViewById(c.a.a.a.b.e.adobe_photos_items_uploadFAB);
            this.X = (FloatingActionButton) relativeLayout.findViewById(c.a.a.a.b.e.adobe_photos_items_uploadAction);
            this.Y = (FloatingActionButton) relativeLayout.findViewById(c.a.a.a.b.e.adobe_photos_items_takePhoto);
            this.Z = relativeLayout.findViewById(c.a.a.a.b.e.adobe_photos_items_alpha_pane);
            Ya();
            relativeLayout.removeView(this.W);
            relativeLayout.removeView(this.Z);
            S().addView(this.Z);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            layoutParams.setMargins(0, 0, R(), a((Activity) getActivity()));
            S().addView(this.W, layoutParams);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void za() {
        FloatingActionsMenu floatingActionsMenu = this.W;
        if (floatingActionsMenu != null) {
            floatingActionsMenu.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t<AdobePhotoCollection> tVar) {
        i(true);
        this.S.a(tVar);
        ga();
        ea();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void c(Bundle bundle) {
        super.c(bundle);
        this.U = -1;
        z();
        this.V = new b(this, null);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void d(boolean z) {
        if (z) {
            this.Q.a(this.P);
        } else {
            this.Q.a((com.adobe.creativesdk.foundation.internal.storage.ia) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public boolean g(String str) {
        xd xdVar = this.S;
        if (xdVar == null) {
            return false;
        }
        xdVar.a(str);
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected C0474t a(Bundle bundle) {
        G g2 = new G();
        g2.a(bundle);
        return g2;
    }

    private void c(int i, int i2) {
        ((RelativeLayout.LayoutParams) this.W.getLayoutParams()).setMargins(0, 0, i, i2);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(Object obj, View view) {
        if (getActivity() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.utils.e) {
            ((com.adobe.creativesdk.foundation.internal.storage.controllers.utils.e) getActivity()).a(obj, this.f6104c, view, AdobeAssetType.ADOBE_ASSET_TYPE_PHOTOS);
        }
    }

    AdobePhotoCollection a(G g2) {
        return new AdobePhotoCollection(g2.k(), g2.j(), new AdobePhotoCatalog(g2.i(), g2.h(), this.f6104c.a()));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void a(C0474t c0474t) {
        a(a((G) c0474t));
    }

    private void a(AdobePhotoCollection adobePhotoCollection) {
        this.R = adobePhotoCollection;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(Object obj) {
        int a2;
        if (obj instanceof AdobePhotoAsset) {
            if (!(getActivity() instanceof AdobeUxAssetBrowserV2Activity) && C0455p.b(getActivity())) {
                a2 = com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.e.b();
            } else {
                a2 = com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.e.a();
            }
            com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.i iVar = (com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.i) com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.c.a(a2).a("ADOBE_ONE_UP_VIEW_PHOTO_CONFIGURATION");
            iVar.a((AdobePhotoAsset) obj);
            iVar.a(this.Q);
            Intent intent = new Intent();
            intent.setClass(getActivity(), AdobeUXPhotoAssetOneUpViewerActivity.class);
            intent.putExtra("one_up_controller_code", a2);
            getActivity().startActivityForResult(intent, 2135);
        }
    }
}
