package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb;
import com.adobe.creativesdk.foundation.internal.storage.controllers.a.c;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.internal.storage.controllers.edit.C0393k;
import com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.AdobeDesignLibraryEditOperation;
import com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.l;
import com.adobe.creativesdk.foundation.internal.storage.controllers.utils.AdobeAssetType;
import com.adobe.creativesdk.foundation.internal.utils.CreativeSDKTextView;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.AdobeCollaborationType;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import com.facebook.internal.NativeProtocol;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;

/* compiled from: DesignLibraryItemsFragment.java */
/* loaded from: classes.dex */
public class Jc extends AbstractC0414hb {
    private b P;
    Sc Q;
    private a R;
    com.adobe.creativesdk.foundation.internal.storage.controllers.a.f S;
    private C0614ub T;
    private com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa U;
    private AdobeCloud V;
    private Observer W;
    private boolean X = false;
    private boolean Y = false;
    private boolean Z;
    private c aa;
    private ProgressBar ba;
    private ProgressDialog ca;
    protected f da;
    private ProgressDialog ea;
    FloatingActionsMenu fa;
    FloatingActionButton ga;
    FloatingActionButton ha;
    View ia;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DesignLibraryItemsFragment.java */
    /* loaded from: classes.dex */
    public class a implements com.adobe.creativesdk.foundation.internal.storage.ha {
        private a() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ha
        public void a() {
            Jc.this.H();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ha
        public void b() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ha
        public void c() {
            Jc jc = Jc.this;
            jc.m(jc.P.getCount());
        }

        /* synthetic */ a(Jc jc, C0504zc c0504zc) {
            this();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ha
        public void a(int i) {
            Jc.this.a(i, null, null);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ha
        public void a(AdobeAssetException adobeAssetException) {
            Jc.this.a(adobeAssetException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DesignLibraryItemsFragment.java */
    /* loaded from: classes.dex */
    public class b implements com.adobe.creativesdk.foundation.internal.storage.ga {

        /* renamed from: a, reason: collision with root package name */
        a f5689a;

        private b() {
        }

        public void a(a aVar) {
            this.f5689a = aVar;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ga
        public void b() {
            this.f5689a = null;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ga
        public void c() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ga
        public int getCount() {
            return Jc.this.T.h();
        }

        /* synthetic */ b(Jc jc, C0504zc c0504zc) {
            this();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ga
        public boolean a() {
            if (!c.a.a.a.a.b.a.a.b.f()) {
                return true;
            }
            c.a.a.a.a.b.a.a.b.c().a(new Kc(this));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DesignLibraryItemsFragment.java */
    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public View f5691a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f5692b;

        c() {
        }
    }

    /* compiled from: DesignLibraryItemsFragment.java */
    /* loaded from: classes.dex */
    protected class d extends AbstractC0414hb.b {
        protected d() {
            super();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DesignLibraryItemsFragment.java */
    /* loaded from: classes.dex */
    public class e extends AbstractC0414hb.b {

        /* renamed from: h, reason: collision with root package name */
        protected MenuItem f5695h;

        private e() {
            super();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(c.a.a.a.b.h.adobe_asset_edit_move_menu, menu);
            this.f5695h = menu.findItem(c.a.a.a.b.e.adobe_csdk_uxassetbrowser_loki_assets_view_move_asset);
            this.f5695h.setOnMenuItemClickListener(new Lc(this));
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void c() {
            super.c();
            if (Jc.this.la()) {
                return;
            }
            this.f5695h.setVisible(false);
        }

        /* synthetic */ e(Jc jc, C0504zc c0504zc) {
            this();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(Menu menu) {
            this.f5695h.setVisible(true);
            c();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public boolean a(int i) {
            if (i != c.a.a.a.b.e.adobe_csdk_uxassetbrowser_loki_assets_view_move_asset) {
                return false;
            }
            Jc.this.db();
            return true;
        }
    }

    /* compiled from: DesignLibraryItemsFragment.java */
    /* loaded from: classes.dex */
    private class f extends com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c {
        private f() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c
        protected EnumSet<AdobeAssetViewBrowserCommandName> a() {
            return EnumSet.of(AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_ITEM_EDIT_COMPLETED, AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_ITEM_EDIT_STARTED, AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_COMP_EDIT_STARTED, AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_COMP_EDIT_COMPLTED);
        }

        /* synthetic */ f(Jc jc, C0504zc c0504zc) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c
        public void a(AdobeAssetViewBrowserCommandName adobeAssetViewBrowserCommandName, Object obj) {
            Bundle bundle;
            if (adobeAssetViewBrowserCommandName == AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_ITEM_EDIT_STARTED || adobeAssetViewBrowserCommandName == AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_COMP_EDIT_STARTED) {
                Jc.this.Wa();
                return;
            }
            if (adobeAssetViewBrowserCommandName == AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_ITEM_EDIT_COMPLETED) {
                Bundle bundle2 = (Bundle) obj;
                Jc.this.j(bundle2 != null ? bundle2.getString("LIBRARY_ELEMENT_TYPE") : null);
            } else {
                if (adobeAssetViewBrowserCommandName != AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_COMP_EDIT_COMPLTED || (bundle = (Bundle) obj) == null) {
                    return;
                }
                Jc.this.a(com.adobe.creativesdk.foundation.storage.Gb.f().d(bundle.getString("LIBRARY_COMP_ID")));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wa() {
        if (com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.d()) {
            com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.c(false);
            fb();
        }
    }

    private void Xa() {
        this.fa.setOnFloatingActionsMenuUpdateListener(new Ac(this));
        this.ia.setOnClickListener(new Bc(this));
        this.ga.setOnClickListener(new Cc(this));
        this.ha.setOnClickListener(new Dc(this));
    }

    private void Ya() {
        if (this.U == null) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa> a2 = com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa.class).a((com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r) this.U);
        if (a2 != null) {
            b(a2);
        } else {
            Za();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Za() {
        if (this.X) {
            this.Q.r();
            i(false);
            k("application/vnd.adobe.element.image+dcx");
        }
    }

    private ProgressDialog _a() {
        this.ea = new ProgressDialog(x());
        this.ea.setMessage(getResources().getString(c.a.a.a.b.i.adobe_csdk_asset_edit_in_progress));
        this.ea.setIndeterminate(true);
        this.ea.setCancelable(false);
        return this.ea;
    }

    private void ab() {
        if (this.aa != null) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(x());
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(c.a.a.a.b.c.adobe_csdk_theme_actionbar_size)));
        relativeLayout.setGravity(17);
        CreativeSDKTextView creativeSDKTextView = new CreativeSDKTextView(x());
        ViewGroup.LayoutParams layoutParams = creativeSDKTextView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        } else {
            layoutParams.height = -2;
            layoutParams.width = -2;
        }
        creativeSDKTextView.setLayoutParams(layoutParams);
        creativeSDKTextView.setTextColor(-1);
        creativeSDKTextView.setTextSize(0, getResources().getDimension(c.a.a.a.b.c.adobe_csdk_assetbrowser_grid_text_size));
        relativeLayout.addView(creativeSDKTextView);
        this.aa = new c();
        c cVar = this.aa;
        cVar.f5692b = creativeSDKTextView;
        cVar.f5691a = relativeLayout;
        cVar.f5691a.setVisibility(8);
        S().addView(this.aa.f5691a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb() {
        ProgressDialog progressDialog = this.ca;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        Toast.makeText(getActivity(), getResources().getString(c.a.a.a.b.i.adobe_csdk_asset_view_error_fetch_link), 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb() {
        ProgressDialog progressDialog = this.ca;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        Toast.makeText(getActivity(), getResources().getString(c.a.a.a.b.i.adobe_read_only_library_error_fetch_link), 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void db() {
        C0358a.a().a(AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_ELEMENT_EDIT_MOVE_OPERATION, this.T.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eb() {
        this.ca = ProgressDialog.show(getActivity(), null, getString(c.a.a.a.b.i.adobe_csdk_asset_view_dialog_fetch_link));
        String k = this.T.k();
        com.adobe.creativesdk.foundation.internal.collaboration.h c2 = com.adobe.creativesdk.foundation.internal.collaboration.h.c();
        c2.a(k, "application/vnd.adobe.library+dcx", new Gc(this, c2, k));
    }

    private void fb() {
        this.ea = _a();
        this.ea.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void Ca() {
        super.Ca();
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeCCFilesUploadSessionStarted, this.W);
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeCCFilesUploadSessionComplete, this.W);
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeCCFilesUploadSessionCancelled, this.W);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected AbstractC0414hb.b D() {
        if (!(getActivity() instanceof AdobeUxAssetBrowserV2Activity) && C0455p.b(getActivity())) {
            return new g();
        }
        return new d();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected int L() {
        return 0;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected String N() {
        return getString(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_csdk_myassets_main);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected String O() {
        return this.T.m();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected com.adobe.creativesdk.foundation.internal.storage.ga P() {
        return this.P;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected int Q() {
        return c.a.a.a.b.g.adobe_library_items_emptycollectioncell;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void V() {
        this.Q.o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void W() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void Z() {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void fa() {
        FloatingActionsMenu floatingActionsMenu = this.fa;
        if (floatingActionsMenu != null) {
            floatingActionsMenu.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public boolean ia() {
        return false;
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Boolean.valueOf(com.adobe.creativesdk.foundation.internal.utils.s.a(x()));
        int R = R();
        int a2 = a((Activity) getActivity());
        if (!this.T.q() && this.fa != null) {
            c(R, a2);
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.da = new f(this, null);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.X = false;
        this.Q.r();
        com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar = this.S;
        if (fVar != null) {
            fVar.a();
        }
        this.S = null;
        S().removeView(this.ia);
        S().removeView(this.fa);
        this.Q = null;
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.Z && i == 1) {
            this.Z = false;
            if (iArr.length == 1 && iArr[0] == 0) {
                a(AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_UPLOAD_FILES, this.U);
            } else {
                Toast.makeText(getActivity(), c.a.a.a.b.i.adobe_csdk_extract_permission_denied, 0).show();
            }
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        Ya();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (!(x() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.y)) {
            this.da.b();
            if (com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.d()) {
                Wa();
            }
            if (!com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.c()) {
                j((String) null);
            }
        }
        if (com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.e() && this.ba != null) {
            a(com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.b());
        }
        if (x() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.y) {
            a(((com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.y) x()).b());
        }
        c.a.a.a.a.b.a.a.a().b(this);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (!(x() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.y)) {
            this.da.c();
        }
        c.a.a.a.a.b.a.a.a().c(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        RecyclerView a2 = this.Q.a(getContext());
        a2.setClipToPadding(false);
        a2.setPadding(a2.getPaddingLeft(), a2.getPaddingTop(), a2.getPaddingRight(), com.adobe.creativesdk.foundation.internal.utils.v.a(getActivity()));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void q() {
        this.Q.h();
        this.R.a();
        c.a.a.a.a.b.a.a.b.c().d().a((c.a.a.a.a.b.a.a.d) new C0504zc(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void qa() {
        super.qa();
        if (this.W == null) {
            this.W = new Ec(this);
        }
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeCCFilesUploadSessionStarted, this.W);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeCCFilesUploadSessionComplete, this.W);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeCCFilesUploadSessionCancelled, this.W);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public boolean s() {
        return false;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void sa() {
        View d2 = this.Q.d();
        if (M().indexOfChild(d2) == -1) {
            M().addView(d2);
        }
        this.f6105d = this.Q;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void va() {
        C0504zc c0504zc = null;
        this.P = new b(this, c0504zc);
        this.R = new a(this, c0504zc);
        this.P.a(this.R);
        c.a aVar = new c.a();
        aVar.a(0.1f);
        this.S = new com.adobe.creativesdk.foundation.internal.storage.controllers.a.f(getActivity());
        this.S.a(getActivity().getSupportFragmentManager(), aVar);
        this.Q = new Sc(x());
        this.Q.a((C0485v) this.f6104c);
        this.Q.a(this);
        this.Q.a(this.T);
        this.Q.a(this.S);
        this.Q.d(x());
        this.P.a();
        new com.adobe.creativesdk.foundation.internal.analytics.c("grid", "libray_element").a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void za() {
        FloatingActionsMenu floatingActionsMenu = this.fa;
        if (floatingActionsMenu != null) {
            floatingActionsMenu.setVisibility(0);
        }
    }

    public static C0614ub i(String str) {
        return c.a.a.a.a.b.a.a.b.c().e().e(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str) {
        if (com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.c()) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.a(true);
        com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.c(false);
        com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.b(false);
        C0393k.a();
        k(str);
        a(com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.a());
        com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.d(true);
        a(AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_COLLECTION_REFRESH_DUE_TO_ITEM_EDIT, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str) {
        this.Q.a(str);
        this.Q.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str) {
        ProgressDialog progressDialog = this.ca;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        if (getActivity() instanceof _c) {
            ((_c) getActivity()).a();
        }
        List<ResolveInfo> queryIntentActivities = getActivity().getPackageManager().queryIntentActivities(intent, 0);
        Iterator<ResolveInfo> it = queryIntentActivities.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().activityInfo.packageName.equals("com.google.android.apps.docs")) {
                    this.Y = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (this.Y) {
            ArrayList arrayList = new ArrayList();
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                String str2 = resolveInfo.activityInfo.packageName;
                String str3 = resolveInfo.activityInfo.name;
                if (!str3.equals("com.adobe.cc.share.CopyToClipboardActivity")) {
                    Intent intent2 = new Intent("android.intent.action.SEND");
                    intent2.setType("text/plain");
                    intent2.putExtra("android.intent.extra.TEXT", str);
                    intent2.setPackage(str2);
                    intent2.setClassName(str2, str3);
                    arrayList.add(intent2);
                }
            }
            Intent createChooser = Intent.createChooser((Intent) arrayList.remove(0), null);
            createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[arrayList.size()]));
            startActivity(createChooser);
            return;
        }
        intent.putExtra("android.intent.extra.TEXT", str);
        startActivity(Intent.createChooser(intent, null));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void d(boolean z) {
        if (z) {
            this.P.a(this.R);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public boolean g(String str) {
        Sc sc = this.Q;
        if (sc == null) {
            return false;
        }
        sc.b(str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa> tVar) {
        if (this.X) {
            return;
        }
        i(true);
        this.Q.a(tVar);
        ga();
        ea();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void c(Bundle bundle) {
        super.c(bundle);
        if (x() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.y) {
            xa();
        } else if (!this.T.q() && !this.T.p() && !(getActivity() instanceof AdobeUxAssetBrowserV2Activity) && C0455p.b(getActivity())) {
            RelativeLayout relativeLayout = (RelativeLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(c.a.a.a.b.g.design_library_item_upload_floating_menu, (ViewGroup) null);
            this.fa = (FloatingActionsMenu) relativeLayout.findViewById(c.a.a.a.b.e.adobe_library_item_uploadFAB);
            this.ga = (FloatingActionButton) relativeLayout.findViewById(c.a.a.a.b.e.adobe_library_item_uploadAction);
            this.ha = (FloatingActionButton) relativeLayout.findViewById(c.a.a.a.b.e.adobe_library_item_takePhoto);
            this.ia = relativeLayout.findViewById(c.a.a.a.b.e.adobe_library_item_alpha_pane);
            Xa();
            relativeLayout.removeView(this.fa);
            relativeLayout.removeView(this.ia);
            S().addView(this.ia);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            layoutParams.setMargins(0, 0, R(), a((Activity) getActivity()));
            S().addView(this.fa, layoutParams);
        }
        this.ba = new ProgressBar(x(), null, R.attr.progressBarStyleHorizontal);
        this.ba.setProgressDrawable(getResources().getDrawable(c.a.a.a.b.d.asset_edit_progress_bar));
        this.ba.setVisibility(8);
        this.ba.setIndeterminateDrawable(getResources().getDrawable(c.a.a.a.b.d.asset_edit_progress_bar));
        this.ba.setIndeterminate(false);
        this.ba.setMax(100);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, a(getResources().getDimension(c.a.a.a.b.c.adobe_csdk_asset_edit_progress_bar_size)));
        this.ba.setProgress(0);
        layoutParams2.addRule(10);
        this.ba.setLayoutParams(layoutParams2);
        S().addView(this.ba);
    }

    protected void i(boolean z) {
        this.X = z;
        getActivity().invalidateOptionsMenu();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected C0474t a(Bundle bundle) {
        C0485v c0485v = new C0485v();
        c0485v.a(getArguments());
        this.V = c0485v.a();
        return c0485v;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void a(C0474t c0474t) {
        this.T = com.adobe.creativesdk.foundation.storage.Gb.f().d(((C0485v) c0474t).i());
        C0614ub c0614ub = this.T;
        if (c0614ub instanceof com.adobe.creativesdk.foundation.adobeinternal.storage.library.F) {
            this.U = ((com.adobe.creativesdk.foundation.adobeinternal.storage.library.F) c0614ub).i().w();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(Object obj) {
        int a2;
        com.adobe.creativesdk.foundation.internal.storage.controllers.utils.f fVar = (com.adobe.creativesdk.foundation.internal.storage.controllers.utils.f) obj;
        if (!(getActivity() instanceof AdobeUxAssetBrowserV2Activity) && C0455p.b(getActivity())) {
            a2 = com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.e.b();
        } else {
            a2 = com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.e.a();
        }
        com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.g gVar = (com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.g) com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.c.a(a2).a("ADOBE_ONE_UP_VIEW_LIBRARY_CONFIGURATION");
        gVar.a(fVar.f6497c);
        gVar.a(fVar.f6495a);
        gVar.b(fVar.f6496b);
        Intent intent = new Intent();
        intent.setClass(getActivity(), AdobeUXLibraryItemCollectionOneUpViewerActivity.class);
        intent.putExtra("one_up_controller_code", a2);
        getActivity().startActivityForResult(intent, 2136);
    }

    /* compiled from: DesignLibraryItemsFragment.java */
    /* loaded from: classes.dex */
    protected class g extends AbstractC0414hb.a {
        private MenuItem i;
        private MenuItem j;
        private MenuItem k;
        private MenuItem l;
        private MenuItem m;

        protected g() {
            super();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(Menu menu, MenuInflater menuInflater) {
            super.a(menu, menuInflater);
            menuInflater.inflate(c.a.a.a.b.h.adobe_assetview_library_items_container_menu, menu);
            this.m = menu.findItem(c.a.a.a.b.e.adobe_library_collection_unsuscribe);
            this.i = menu.findItem(c.a.a.a.b.e.adobe_csdk_asset_browser_collaborator_menu);
            this.j = menu.findItem(c.a.a.a.b.e.adobe_library_collection_rename);
            this.k = menu.findItem(c.a.a.a.b.e.adobe_library_collection_share);
            this.l = menu.findItem(c.a.a.a.b.e.adobe_library_collection_delete);
            if (Jc.this.V != null && Jc.this.V.isPrivateCloud()) {
                this.i.setVisible(false);
                this.k.setVisible(false);
            }
            AdobeCollaborationType f2 = Jc.this.T.f();
            if (Jc.this.T.p()) {
                this.j.setVisible(false);
                this.k.setVisible(false);
                this.i.setVisible(false);
                this.l.setVisible(false);
                this.m.setVisible(true);
                return;
            }
            this.m.setVisible(false);
            if (Ic.f5670a[f2.ordinal()] != 1) {
                return;
            }
            if (Jc.this.T.q()) {
                this.j.setVisible(false);
                this.k.setVisible(false);
                this.l.setTitle(Jc.this.getResources().getString(c.a.a.a.b.i.adobe_csdk_library_remove_myself));
                return;
            }
            this.l.setTitle(Jc.this.getResources().getString(c.a.a.a.b.i.adobe_csdk_leave_library));
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void c() {
            super.c();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public boolean a(int i) {
            if (i == c.a.a.a.b.e.adobe_csdk_asset_browser_collaborator_menu) {
                if (Jc.this.U.g() != null) {
                    String uri = Jc.this.U.g().toString();
                    if (!uri.startsWith("/")) {
                        uri = "/" + uri;
                    }
                    Jc.this.a(AdobeAssetViewBrowserCommandName.ACTION_MENU_COLLABORATION, uri);
                    return true;
                }
                Toast.makeText(Jc.this.getActivity(), c.a.a.a.b.i.adobe_csdk_library_not_synced_yet, 0).show();
                return true;
            }
            if (i == c.a.a.a.b.e.adobe_library_collection_rename) {
                com.adobe.creativesdk.foundation.internal.analytics.q.a("mobile.ccmobile.operations.libraryRename", new HashMap<String, String>() { // from class: com.adobe.creativesdk.foundation.internal.storage.controllers.DesignLibraryItemsFragment$LibraryItemsContainerCCActionBarController$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        put("area", "operations");
                        put("type", "library");
                        put(NativeProtocol.WEB_DIALOG_ACTION, "rename");
                    }
                }, null);
                com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.a(Jc.this.T.k(), Jc.this.getFragmentManager(), AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_COMP_EDIT_OPERATION_RENAME, new Mc(this)).a(new Nc(this));
                return true;
            }
            if (i == c.a.a.a.b.e.adobe_library_collection_share) {
                Jc.this.eb();
                return true;
            }
            if (i == c.a.a.a.b.e.adobe_library_collection_delete) {
                com.adobe.creativesdk.foundation.internal.analytics.q.a("mobile.ccmobile.operations.libraryDelete", new HashMap<String, String>() { // from class: com.adobe.creativesdk.foundation.internal.storage.controllers.DesignLibraryItemsFragment$LibraryItemsContainerCCActionBarController$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        put("area", "operations");
                        put("type", "library");
                        put(NativeProtocol.WEB_DIALOG_ACTION, "delete");
                    }
                }, null);
                FragmentManager fragmentManager = Jc.this.getFragmentManager();
                com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.t tVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.t();
                tVar.a(Jc.this.T);
                tVar.show(fragmentManager, "Delete Library");
                return true;
            }
            if (i == c.a.a.a.b.e.adobe_library_collection_unsuscribe) {
                FragmentManager fragmentManager2 = Jc.this.getFragmentManager();
                com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.t tVar2 = new com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.t();
                tVar2.a(Jc.this.T);
                tVar2.show(fragmentManager2, "Unsuscribe Library");
                return true;
            }
            return super.a(i);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(Menu menu) {
            super.a(menu);
            C0614ub unused = Jc.this.T;
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(Object obj, View view) {
        if (getActivity() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.utils.e) {
            ((com.adobe.creativesdk.foundation.internal.storage.controllers.utils.e) getActivity()).a(new com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.v((C0622wb) obj, this.T), this.f6104c, view, AdobeAssetType.ADOBE_ASSET_TYPE_LIBRARY_ITEMS);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void a(View view) {
        if (x() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.y) {
            ((TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_storage_asset_browser_empty_state_message)).setVisibility(8);
        }
    }

    protected void a(com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.w wVar) {
        if (wVar.a()) {
            this.f6107f = new e(this, null);
            com.adobe.creativesdk.foundation.internal.utils.b.a(getActivity().findViewById(R.id.content), this.T.m());
        }
    }

    private void c(int i, int i2) {
        ((RelativeLayout.LayoutParams) this.fa.getLayoutParams()).setMargins(0, 0, i, i2);
    }

    private int a(float f2) {
        return Math.round(f2 * x().getApplicationContext().getResources().getDisplayMetrics().density);
    }

    private void a(double d2) {
        this.ba.setVisibility(0);
        this.ba.setProgress((int) (d2 * 100.0d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:            if (r5.i().p().c() != "pendingDelete") goto L18;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.adobe.creativesdk.foundation.storage.C0614ub r5) {
        /*
            r4 = this;
            boolean r0 = com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.c()
            if (r0 != 0) goto L67
            r0 = 1
            com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.a(r0)
            r1 = 0
            com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.c(r1)
            com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.b(r1)
            com.adobe.creativesdk.foundation.internal.storage.controllers.edit.C0393k.a()
            android.app.ProgressDialog r2 = r4.ea
            if (r2 == 0) goto L1b
            r2.dismiss()
        L1b:
            if (r5 != 0) goto L1f
        L1d:
            r1 = 1
            goto L4e
        L1f:
            com.adobe.creativesdk.foundation.adobeinternal.storage.library.F r5 = (com.adobe.creativesdk.foundation.adobeinternal.storage.library.F) r5
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.f r2 = r5.i()
            if (r2 == 0) goto L1d
            boolean r2 = r5.x()
            if (r2 != 0) goto L1d
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.f r2 = r5.i()
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.h r2 = r2.p()
            java.lang.String r2 = r2.c()
            java.lang.String r3 = "committedDelete"
            if (r2 == r3) goto L1d
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.f r5 = r5.i()
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.h r5 = r5.p()
            java.lang.String r5 = r5.c()
            java.lang.String r2 = "pendingDelete"
            if (r5 != r2) goto L4e
            goto L1d
        L4e:
            com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.d(r0)
            if (r1 == 0) goto L5e
            android.support.v4.app.FragmentManager r5 = r4.getFragmentManager()
            com.adobe.creativesdk.foundation.internal.storage.controllers.C0500yc.b(r0)
            r5.popBackStackImmediate()
            goto L67
        L5e:
            com.adobe.creativesdk.foundation.storage.ub r5 = r4.T
            java.lang.String r5 = r5.m()
            com.adobe.creativesdk.foundation.internal.storage.controllers.actionbar.a.a(r5)
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.storage.controllers.Jc.a(com.adobe.creativesdk.foundation.storage.ub):void");
    }

    private void a(com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.l lVar) {
        String format;
        l.a a2 = lVar.a();
        if (a2.a()) {
            ProgressDialog progressDialog = this.ea;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            AdobeDesignLibraryEditOperation adobeDesignLibraryEditOperation = a2.f6234a;
            if (adobeDesignLibraryEditOperation == AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_ITEM_EDIT_OPERATION_MOVE) {
                Toast.makeText(x(), c.a.a.a.b.i.adobe_csdk_asset_move_error_same_location, 1).show();
                return;
            } else {
                if (adobeDesignLibraryEditOperation == AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_ITEM_EDIT_OPERATION_COPY) {
                    Toast.makeText(x(), c.a.a.a.b.i.adobe_csdk_asset_copy_error_same_location, 1).show();
                    return;
                }
                return;
            }
        }
        ab();
        String str = "";
        if (!a2.b()) {
            this.aa.f5691a.setBackgroundResource(c.a.a.a.b.b.adobe_csdk_assetview_common_error_banner_background);
            AdobeDesignLibraryEditOperation adobeDesignLibraryEditOperation2 = a2.f6234a;
            if (adobeDesignLibraryEditOperation2 == AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_ITEM_EDIT_OPERATION_RENAME) {
                str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_EDIT_SINGLE_ERROR_MSG);
            } else if (adobeDesignLibraryEditOperation2 == AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_ITEM_EDIT_OPERATION_ERASE) {
                str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_ARCHIVE_SINGLE_ERROR_MSG);
            } else if (adobeDesignLibraryEditOperation2 == AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_ITEM_EDIT_OPERATION_MOVE) {
                str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_MOVE_SINGLE_ERROR_MSG);
            } else if (adobeDesignLibraryEditOperation2 == AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_ITEM_EDIT_OPERATION_COPY) {
                str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_COPY_SINGLE_ERROR_MSG);
            }
            format = String.format(str, Integer.toString(1));
        } else {
            ProgressBar progressBar = this.ba;
            if (progressBar != null) {
                progressBar.setVisibility(0);
                this.ba.setProgress(100);
            }
            this.aa.f5691a.setBackgroundResource(c.a.a.a.b.b.adobe_csdk_assetview_common_success_banner_background);
            AdobeDesignLibraryEditOperation adobeDesignLibraryEditOperation3 = a2.f6234a;
            if (adobeDesignLibraryEditOperation3 == AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_ITEM_EDIT_OPERATION_RENAME) {
                str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_EDIT_SINGLE_SUCCESS_MSG);
            } else if (adobeDesignLibraryEditOperation3 == AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_ITEM_EDIT_OPERATION_ERASE) {
                str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_ARCHIVE_SINGLE_SUCCESS_MSG);
            } else if (adobeDesignLibraryEditOperation3 == AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_ITEM_EDIT_OPERATION_MOVE) {
                str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_MOVE_SINGLE_SUCCESS_MSG);
            } else if (adobeDesignLibraryEditOperation3 == AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_ITEM_EDIT_OPERATION_COPY) {
                str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_COPY_SINGLE_SUCCESS_MSG);
            }
            format = String.format(str, Integer.toString(1));
        }
        ra();
        ProgressDialog progressDialog2 = this.ea;
        if (progressDialog2 != null) {
            progressDialog2.dismiss();
        }
        ProgressBar progressBar2 = this.ba;
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
        this.aa.f5692b.setText(format);
        this.aa.f5691a.setVisibility(0);
        com.adobe.creativesdk.foundation.internal.utils.o.a().postDelayed(new Hc(this), 5000L);
    }
}
