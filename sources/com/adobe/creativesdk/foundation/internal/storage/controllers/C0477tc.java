package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.internal.storage.C0514m;
import com.adobe.creativesdk.foundation.internal.storage.controllers.a.c;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.internal.storage.controllers.edit.C0393k;
import com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.AdobeDesignLibraryEditOperation;
import com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.l;
import com.adobe.creativesdk.foundation.internal.storage.controllers.utils.AdobeAssetType;
import com.adobe.creativesdk.foundation.internal.utils.CreativeSDKTextView;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.facebook.internal.NativeProtocol;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import java.util.EnumSet;
import java.util.HashMap;

/* compiled from: DesignLibraryCollectionFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.tc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0477tc extends AbstractC0414hb {
    private C0500yc P;
    private a Q;
    private C0514m R;
    private AdobeCloud S;
    com.adobe.creativesdk.foundation.internal.storage.controllers.a.f T;
    private b U;
    private ProgressBar V;
    private View W;
    private FloatingActionsMenu X;
    protected d Y;
    private ProgressDialog Z;
    protected c aa;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DesignLibraryCollectionFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.tc$a */
    /* loaded from: classes.dex */
    public class a implements com.adobe.creativesdk.foundation.internal.storage.ha {
        private a() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ha
        public void a() {
            C0477tc.this.H();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ha
        public void b() {
            C0477tc.this.I();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ha
        public void c() {
            C0477tc.this.sa();
            C0477tc c0477tc = C0477tc.this;
            c0477tc.m(c0477tc.R.getCount());
        }

        /* synthetic */ a(C0477tc c0477tc, C0458pc c0458pc) {
            this();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ha
        public void a(int i) {
            C0477tc c0477tc = C0477tc.this;
            c0477tc.a(c0477tc.R.getCount(), null, null);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ha
        public void a(AdobeAssetException adobeAssetException) {
            C0477tc.this.a(adobeAssetException);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DesignLibraryCollectionFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.tc$b */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public View f6425a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f6426b;

        b() {
        }
    }

    /* compiled from: DesignLibraryCollectionFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.tc$c */
    /* loaded from: classes.dex */
    private class c extends com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c {
        private c() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c
        protected EnumSet<AdobeAssetViewBrowserCommandName> a() {
            return EnumSet.of(AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_COLLECTION_REFRESH_DUE_TO_ITEM_EDIT, AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_COLLECTION_REFRESH_DUE_TO_SHARE_MODIFY);
        }

        /* synthetic */ c(C0477tc c0477tc, C0458pc c0458pc) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c
        public void a(AdobeAssetViewBrowserCommandName adobeAssetViewBrowserCommandName, Object obj) {
            if (adobeAssetViewBrowserCommandName == AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_COLLECTION_REFRESH_DUE_TO_ITEM_EDIT || adobeAssetViewBrowserCommandName == AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_COLLECTION_REFRESH_DUE_TO_SHARE_MODIFY) {
                C0477tc.this.P.e();
            }
        }
    }

    /* compiled from: DesignLibraryCollectionFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.tc$d */
    /* loaded from: classes.dex */
    private class d extends com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c {
        private d() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c
        protected EnumSet<AdobeAssetViewBrowserCommandName> a() {
            return EnumSet.of(AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_COMP_EDIT_STARTED, AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_COMP_EDIT_COMPLTED);
        }

        /* synthetic */ d(C0477tc c0477tc, C0458pc c0458pc) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c
        public void a(AdobeAssetViewBrowserCommandName adobeAssetViewBrowserCommandName, Object obj) {
            Bundle bundle;
            if (adobeAssetViewBrowserCommandName == AdobeAssetViewBrowserCommandName.ASSETVIEW_BROWSER_CCFILES_FORCE_REFRESH_LIST) {
                C0477tc.this.Xa();
                return;
            }
            if (adobeAssetViewBrowserCommandName == AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_COMP_EDIT_STARTED) {
                C0477tc.this.Wa();
            } else {
                if (adobeAssetViewBrowserCommandName != AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_COMP_EDIT_COMPLTED || (bundle = (Bundle) obj) == null) {
                    return;
                }
                C0477tc.this.a(com.adobe.creativesdk.foundation.storage.Gb.f().d(bundle.getString("LIBRARY_COMP_ID")));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wa() {
        if (com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.d()) {
            com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.c(false);
            bb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xa() {
        ra();
    }

    private ProgressDialog Ya() {
        this.Z = new ProgressDialog(x());
        this.Z.setMessage(getResources().getString(c.a.a.a.b.i.adobe_csdk_asset_edit_in_progress));
        this.Z.setIndeterminate(true);
        this.Z.setCancelable(false);
        return this.Z;
    }

    private void Za() {
        if (this.U != null) {
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
        this.U = new b();
        b bVar = this.U;
        bVar.f6426b = creativeSDKTextView;
        bVar.f6425a = relativeLayout;
        bVar.f6425a.setVisibility(8);
        S().addView(this.U.f6425a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _a() {
        com.adobe.creativesdk.foundation.internal.analytics.q.a("mobile.ccmobile.createNewLibrary", new HashMap<String, String>() { // from class: com.adobe.creativesdk.foundation.internal.storage.controllers.DesignLibraryCollectionFragment$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                put("area", "operations");
                put("type", "library");
                put(NativeProtocol.WEB_DIALOG_ACTION, "create");
            }
        }, null);
        a(AdobeAssetViewBrowserCommandName.ACTION_MENU_CREATE_NEWLIBRARY, (Object) null);
    }

    private void ab() {
        this.W.setOnClickListener(new ViewOnClickListenerC0463qc(this));
        this.X.setOnFloatingActionsMenuUpdateListener(new C0467rc(this));
        if (!la()) {
            this.X.setVisibility(8);
        } else {
            this.X.setVisibility(0);
        }
    }

    private void bb() {
        this.Z = Ya();
        this.Z.show();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected int L() {
        return 0;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected String N() {
        if (C0455p.b(x())) {
            if (!(x() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.y)) {
                return getResources().getString(c.a.a.a.b.i.adobe_csdk_cc_title);
            }
            return getResources().getString(c.a.a.a.b.i.adobe_csdk_library_chooser);
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

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(Object obj) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected boolean ca() {
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void fa() {
        FloatingActionsMenu floatingActionsMenu = this.X;
        if (floatingActionsMenu != null) {
            floatingActionsMenu.setVisibility(8);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public boolean ia() {
        return true;
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Boolean.valueOf(com.adobe.creativesdk.foundation.internal.utils.s.a(x()));
        int R = R();
        int a2 = a((Activity) getActivity());
        if (this.X != null) {
            c(R, a2);
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0458pc c0458pc = null;
        this.Y = new d(this, c0458pc);
        this.aa = new c(this, c0458pc);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.Q = null;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onDestroyView() {
        com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar = this.T;
        if (fVar != null) {
            fVar.a();
            this.T = null;
        }
        super.onDestroyView();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (!(x() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.y)) {
            this.Y.b();
            this.aa.b();
            if (com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.f()) {
                this.P.e();
                com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.d(false);
            }
            if (com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.d()) {
                Wa();
            }
            if (!com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.c()) {
                a((C0614ub) null);
            }
        }
        if (com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.e() && this.V != null) {
            a(com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.b());
        }
        c.a.a.a.a.b.a.a.a().b(this);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (!(x() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.y)) {
            this.Y.c();
            this.aa.c();
        }
        c.a.a.a.a.b.a.a.a().c(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        RecyclerView a2 = this.P.a(getContext());
        a2.setClipToPadding(false);
        a2.setPadding(a2.getPaddingLeft(), a2.getPaddingTop(), a2.getPaddingRight(), com.adobe.creativesdk.foundation.internal.utils.v.a(getActivity()));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void q() {
        this.P.h();
        this.Q.a();
        c.a.a.a.a.b.a.a.b.c().d().a((c.a.a.a.a.b.a.a.d) new C0458pc(this));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public boolean s() {
        return false;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void sa() {
        View d2 = this.P.d();
        if (M().indexOfChild(d2) == -1) {
            if (d2.getParent() != null) {
                ((ViewGroup) d2.getParent()).removeView(d2);
            }
            M().addView(d2);
        }
        this.f6105d = this.P;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void va() {
        if (this.P != null) {
            if (C0500yc.s()) {
                this.P.q();
                C0500yc c0500yc = this.P;
                C0500yc.b(false);
                return;
            }
            return;
        }
        this.P = new C0500yc(getActivity());
        this.P.a(this);
        c.a aVar = new c.a();
        aVar.a(0.1f);
        this.T = new com.adobe.creativesdk.foundation.internal.storage.controllers.a.f(getActivity());
        this.T.a(getActivity().getSupportFragmentManager(), aVar);
        this.Q = new a(this, null);
        this.R = new C0514m(this.f6104c.a());
        this.R.a(this.Q);
        this.P.a(this.R);
        this.P.a(this.T);
        this.P.d(getActivity());
        this.f6105d = this.P;
        this.R.a();
        new com.adobe.creativesdk.foundation.internal.analytics.c("grid", "library").a();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void z() {
        if (!Boolean.valueOf(C0455p.b(getContext())).booleanValue() || (x() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.y)) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(c.a.a.a.b.g.adobe_design_library_floating_menu, (ViewGroup) null);
        this.X = (FloatingActionsMenu) relativeLayout.findViewById(c.a.a.a.b.e.adobe_library_collection_FAB);
        this.W = relativeLayout.findViewById(c.a.a.a.b.e.adobe_library_alpha_pane);
        ab();
        relativeLayout.removeView(this.X);
        relativeLayout.removeView(this.W);
        S().addView(this.W);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, R(), a((Activity) getActivity()));
        S().addView(this.X, layoutParams);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void za() {
        FloatingActionsMenu floatingActionsMenu = this.X;
        if (floatingActionsMenu != null) {
            floatingActionsMenu.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void c(Bundle bundle) {
        super.c(bundle);
        this.V = new ProgressBar(x(), null, R.attr.progressBarStyleHorizontal);
        this.V.setProgressDrawable(getResources().getDrawable(c.a.a.a.b.d.asset_edit_progress_bar));
        this.V.setVisibility(8);
        this.V.setIndeterminateDrawable(getResources().getDrawable(c.a.a.a.b.d.asset_edit_progress_bar));
        this.V.setIndeterminate(false);
        this.V.setMax(100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, a(getResources().getDimension(c.a.a.a.b.c.adobe_csdk_asset_edit_progress_bar_size)));
        this.V.setProgress(0);
        layoutParams.addRule(10);
        this.V.setLayoutParams(layoutParams);
        S().addView(this.V);
        z();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void d(boolean z) {
        if (z) {
            this.R.a(this.Q);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public boolean g(String str) {
        C0500yc c0500yc = this.P;
        if (c0500yc == null) {
            return false;
        }
        c0500yc.a(str);
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected C0474t a(Bundle bundle) {
        G g2 = new G();
        g2.a(getArguments());
        this.S = g2.a();
        return g2;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(Object obj, View view) {
        if (getActivity() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.utils.e) {
            ((com.adobe.creativesdk.foundation.internal.storage.controllers.utils.e) getActivity()).a(obj, this.f6104c, view, AdobeAssetType.ADOBE_ASSET_TYPE_LIBRARIES);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void a(View view) {
        ImageView imageView = (ImageView) view.findViewById(c.a.a.a.b.e.adobe_csdk_photo_asset_browser_empty_state_icon);
        imageView.setVisibility(0);
        imageView.setImageResource(c.a.a.a.b.d.adobe_emptystate_libraries);
        ((TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_photo_asset_browser_empty_state_message)).setText(getResources().getString(c.a.a.a.b.i.adobe_csdk_my_libraries_empty_collection));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.commands.d dVar) {
        com.adobe.creativesdk.foundation.internal.storage.controllers.commands.f fVar = (com.adobe.creativesdk.foundation.internal.storage.controllers.commands.f) dVar;
        com.adobe.creativesdk.foundation.internal.storage.controllers.commands.j jVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.commands.j();
        jVar.a(fVar.a());
        jVar.b(fVar.b());
        jVar.a(fVar.c());
        a(AdobeAssetViewBrowserCommandName.NAVIGATE_TO_DESIGNLIBRARY_COLLECTION, jVar);
    }

    private void c(int i, int i2) {
        ((RelativeLayout.LayoutParams) this.X.getLayoutParams()).setMargins(0, 0, i, i2);
    }

    private int a(float f2) {
        return Math.round(f2 * x().getApplicationContext().getResources().getDisplayMetrics().density);
    }

    private void a(double d2) {
        this.V.setVisibility(0);
        this.V.setProgress((int) (d2 * 100.0d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C0614ub c0614ub) {
        if (com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.c()) {
            return;
        }
        boolean z = true;
        com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.a(true);
        com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.c(false);
        com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.b(false);
        C0393k.a();
        if (c0614ub != null) {
            com.adobe.creativesdk.foundation.adobeinternal.storage.library.F f2 = (com.adobe.creativesdk.foundation.adobeinternal.storage.library.F) c0614ub;
            if (f2.i() != null && f2.i().p().c() != "committedDelete" && f2.i().p().c() != "pendingDelete") {
                z = false;
            }
        }
        if (z) {
            this.P.e();
        } else {
            View findViewWithTag = this.P.a(x()).findViewWithTag(c0614ub.k());
            if (findViewWithTag != null) {
                this.P.a(findViewWithTag, c0614ub);
            } else {
                pa();
            }
        }
        a(com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.a());
    }

    private void a(com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.l lVar) {
        String format;
        l.a a2 = lVar.a();
        Za();
        String str = "";
        if (!a2.b()) {
            this.U.f6425a.setBackgroundResource(c.a.a.a.b.b.adobe_csdk_assetview_common_error_banner_background);
            AdobeDesignLibraryEditOperation adobeDesignLibraryEditOperation = a2.f6234a;
            if (adobeDesignLibraryEditOperation == AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_COMP_EDIT_OPERATION_RENAME) {
                str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_EDIT_SINGLE_ERROR_MSG);
            } else if (adobeDesignLibraryEditOperation == AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_COMP_EDIT_OPERATION_DELETE) {
                str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_DELETE_SINGLE_ERROR_MSG);
            }
            format = String.format(str, Integer.toString(1));
        } else {
            ProgressBar progressBar = this.V;
            if (progressBar != null) {
                progressBar.setVisibility(0);
                this.V.setProgress(100);
            }
            this.U.f6425a.setBackgroundResource(c.a.a.a.b.b.adobe_csdk_assetview_common_success_banner_background);
            AdobeDesignLibraryEditOperation adobeDesignLibraryEditOperation2 = a2.f6234a;
            if (adobeDesignLibraryEditOperation2 == AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_COMP_EDIT_OPERATION_RENAME) {
                str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_EDIT_SINGLE_SUCCESS_MSG);
            } else if (adobeDesignLibraryEditOperation2 == AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_COMP_EDIT_OPERATION_DELETE) {
                str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_DELETE_SINGLE_SUCCESS_MSG);
            }
            format = String.format(str, Integer.toString(1));
        }
        ra();
        ProgressDialog progressDialog = this.Z;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        ProgressBar progressBar2 = this.V;
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
        this.U.f6426b.setText(format);
        this.U.f6425a.setVisibility(0);
        com.adobe.creativesdk.foundation.internal.utils.o.a().postDelayed(new RunnableC0472sc(this), 5000L);
    }
}
