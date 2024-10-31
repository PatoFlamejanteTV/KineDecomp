package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.AdobeStorageDataSource;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Hb;
import com.adobe.creativesdk.foundation.internal.storage.controllers.a.c;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.internal.storage.controllers.edit.AdobeCCFilesEditOperation;
import com.adobe.creativesdk.foundation.internal.storage.controllers.edit.C0390h;
import com.adobe.creativesdk.foundation.internal.storage.controllers.edit.C0393k;
import com.adobe.creativesdk.foundation.internal.storage.controllers.edit.C0394l;
import com.adobe.creativesdk.foundation.internal.storage.controllers.edit.C0399q;
import com.adobe.creativesdk.foundation.internal.storage.controllers.utils.AdobeAssetType;
import com.adobe.creativesdk.foundation.internal.utils.CreativeSDKTextView;
import com.adobe.creativesdk.foundation.storage.AdobeCollaborationType;
import com.adobe.creativesdk.foundation.storage.C0578la;
import com.facebook.internal.NativeProtocol;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/* compiled from: CCFilesWithUploadFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.hc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0415hc extends Hb {
    protected FloatingActionsMenu Ba;
    private FloatingActionButton Ca;
    private FloatingActionButton Da;
    private FloatingActionButton Ea;
    private FloatingActionButton Fa;
    protected View Ga;
    private Observer ca;
    private i da;
    private f ea;
    private View fa;
    private ImageView ga;
    private TextView ha;
    private MenuItem ia;
    private MenuItem ja;
    private ImageButton la;
    private ProgressBar ma;
    private Observer na;
    private Menu oa;
    protected d pa;
    private Observer qa;
    com.adobe.creativesdk.foundation.internal.storage.controllers.edit.F ra;
    private Menu sa;
    private ProgressBar ua;
    private ProgressDialog wa;
    private Handler xa;
    private boolean ya;
    private MenuItem za;
    private boolean ka = false;
    private boolean ta = false;
    private boolean va = true;
    private boolean Aa = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CCFilesWithUploadFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.hc$a */
    /* loaded from: classes.dex */
    public class a extends AbstractC0414hb.b {

        /* renamed from: h, reason: collision with root package name */
        protected MenuItem f6127h;

        private a() {
            super();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(c.a.a.a.b.h.adobe_asset_edit_move_menu, menu);
            this.f6127h = menu.findItem(c.a.a.a.b.e.adobe_csdk_uxassetbrowser_loki_assets_view_move_asset);
            this.f6127h.setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0410gc(this));
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void c() {
            super.c();
            if (C0415hc.this.la()) {
                return;
            }
            this.f6127h.setVisible(false);
        }

        /* synthetic */ a(C0415hc c0415hc, Yb yb) {
            this();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(Menu menu) {
            this.f6127h.setVisible(true);
            c();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public boolean a(int i) {
            if (i != c.a.a.a.b.e.adobe_csdk_uxassetbrowser_loki_assets_view_move_asset) {
                return false;
            }
            C0415hc.this.hb();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CCFilesWithUploadFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.hc$b */
    /* loaded from: classes.dex */
    public class b extends AbstractC0414hb.b {

        /* renamed from: h, reason: collision with root package name */
        protected MenuItem f6128h;
        protected MenuItem i;

        private b() {
            super();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(c.a.a.a.b.h.adobe_menu_share, menu);
            this.f6128h = menu.findItem(c.a.a.a.b.e.adobe_csdk_menu_advance);
            this.f6128h.setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0420ic(this));
            this.i = menu.findItem(c.a.a.a.b.e.adobe_csdk_menu_create_new_folder);
            this.i.setOnMenuItemClickListener(new MenuItemOnMenuItemClickListenerC0425jc(this));
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void c() {
            super.c();
            if (C0415hc.this.la()) {
                return;
            }
            MenuItem menuItem = this.f6128h;
            if (menuItem != null) {
                menuItem.setVisible(false);
            }
            MenuItem menuItem2 = this.i;
            if (menuItem2 != null) {
                menuItem2.setVisible(false);
            }
        }

        /* synthetic */ b(C0415hc c0415hc, Yb yb) {
            this();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(Menu menu) {
            MenuItem menuItem = this.f6128h;
            if (menuItem != null) {
                menuItem.setVisible(true);
            }
            MenuItem menuItem2 = this.i;
            if (menuItem2 != null) {
                menuItem2.setVisible(true);
            }
            c();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public boolean a(int i) {
            if (i == c.a.a.a.b.e.adobe_csdk_menu_advance) {
                C0415hc.this.ib();
                return true;
            }
            if (i != c.a.a.a.b.e.adobe_csdk_menu_create_new_folder) {
                return false;
            }
            C0415hc.this.fb();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CCFilesWithUploadFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.hc$d */
    /* loaded from: classes.dex */
    public class d extends com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c {
        private d() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c
        protected EnumSet<AdobeAssetViewBrowserCommandName> a() {
            return EnumSet.of(AdobeAssetViewBrowserCommandName.ASSETVIEW_BROWSER_CCFILES_FORCE_REFRESH_LIST, AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_EDIT_COMPLETED, AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_EDIT_STARTED, AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_LEAVE_FOLDER);
        }

        /* synthetic */ d(C0415hc c0415hc, Yb yb) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c
        public void a(AdobeAssetViewBrowserCommandName adobeAssetViewBrowserCommandName, Object obj) {
            if (adobeAssetViewBrowserCommandName == AdobeAssetViewBrowserCommandName.ASSETVIEW_BROWSER_CCFILES_FORCE_REFRESH_LIST) {
                C0415hc.this._a();
                return;
            }
            if (adobeAssetViewBrowserCommandName == AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_EDIT_STARTED) {
                C0415hc.this.Za();
            } else if (adobeAssetViewBrowserCommandName == AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_EDIT_COMPLETED) {
                C0415hc.this.Ya();
            } else if (adobeAssetViewBrowserCommandName == AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_LEAVE_FOLDER) {
                C0415hc.this.a(false, (String) obj);
            }
        }
    }

    /* compiled from: CCFilesWithUploadFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.hc$e */
    /* loaded from: classes.dex */
    class e implements Observer {
        e() {
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            com.adobe.creativesdk.foundation.internal.notification.c cVar = (com.adobe.creativesdk.foundation.internal.notification.c) obj;
            if (cVar.a() == AdobeInternalNotificationID.AdobeAssetEditProgressChanged) {
                Map<String, Object> b2 = cVar.b();
                if (b2.containsKey("EDIT_PROGRESS_KEY")) {
                    C0415hc.this.a(((Double) b2.get("EDIT_PROGRESS_KEY")).doubleValue());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CCFilesWithUploadFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.hc$f */
    /* loaded from: classes.dex */
    public class f {

        /* renamed from: a, reason: collision with root package name */
        public View f6131a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f6132b;

        f() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CCFilesWithUploadFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.hc$g */
    /* loaded from: classes.dex */
    public class g implements View.OnClickListener {
        private g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == C0415hc.this.Ea.getId()) {
                C0415hc.this.fb();
            } else if (view.getId() == C0415hc.this.Ca.getId()) {
                if (C0415hc.this.kb()) {
                    C0415hc c0415hc = C0415hc.this;
                    c0415hc.a(AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_CANCEL_UPLOAD, c0415hc.Ga());
                } else if (ContextCompat.checkSelfPermission(C0415hc.this.getActivity(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                    C0415hc.this.ya = true;
                    C0415hc.this.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0);
                } else {
                    C0415hc c0415hc2 = C0415hc.this;
                    c0415hc2.a(AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_UPLOAD_FILES, c0415hc2.Ga());
                }
            } else if (view.getId() != C0415hc.this.Da.getId()) {
                if (view.getId() == C0415hc.this.Fa.getId()) {
                    if (C0415hc.this.kb()) {
                        C0415hc c0415hc3 = C0415hc.this;
                        c0415hc3.a(AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_CANCEL_UPLOAD, c0415hc3.Ga());
                    } else if (ContextCompat.checkSelfPermission(C0415hc.this.getActivity(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                        C0415hc.this.ya = true;
                        C0415hc.this.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 0);
                    } else {
                        C0415hc c0415hc4 = C0415hc.this;
                        c0415hc4.a(AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_UPLOAD_IMAGES, c0415hc4.Ga());
                    }
                }
            } else {
                C0415hc c0415hc5 = C0415hc.this;
                c0415hc5.a(AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_UPLOAD_PHOTO_FROM_CAMERA, c0415hc5.Ga());
            }
            C0415hc.this.Ba.d();
        }

        /* synthetic */ g(C0415hc c0415hc, Yb yb) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CCFilesWithUploadFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.hc$h */
    /* loaded from: classes.dex */
    public class h implements FloatingActionsMenu.b {

        /* renamed from: a, reason: collision with root package name */
        private boolean f6135a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f6136b;

        private h() {
        }

        @Override // com.getbase.floatingactionbutton.FloatingActionsMenu.b
        public void a() {
            com.adobe.creativesdk.foundation.internal.utils.b.a(C0415hc.this.getActivity().findViewById(R.id.content), true);
            android.arch.lifecycle.s x = C0415hc.this.x();
            C0415hc.this.b(x instanceof InterfaceC0372cd ? ((InterfaceC0372cd) x).n() : false ? false : true);
            C0415hc.this.Ga.setVisibility(4);
        }

        @Override // com.getbase.floatingactionbutton.FloatingActionsMenu.b
        public void b() {
            com.adobe.creativesdk.foundation.internal.utils.b.a(C0415hc.this.getActivity().findViewById(R.id.content), false);
            C0415hc.this.b(false);
            this.f6135a = !C0415hc.this.aa;
            this.f6136b = C0415hc.this.kb();
            if (!C0415hc.this.la()) {
                C0415hc.this.Da.setVisibility(8);
                C0415hc.this.Ea.setVisibility(8);
                C0415hc.this.Ca.setVisibility(8);
                C0415hc.this.Fa.setVisibility(8);
                return;
            }
            C0415hc.this.Da.setVisibility(0);
            C0415hc.this.Ea.setVisibility(0);
            C0415hc.this.Ca.setVisibility(0);
            C0415hc.this.Fa.setVisibility(0);
            C0415hc.this.Ga.setVisibility(0);
            if (this.f6136b) {
                C0415hc.this.Ca.setTitle(C0415hc.this.x().getResources().getString(c.a.a.a.b.i.adobe_csdk_CANCEL_UPLOAD_ASSET_BROWSER_BUTTON));
            } else {
                C0415hc.this.Ca.setTitle(C0415hc.this.x().getResources().getString(c.a.a.a.b.i.adobe_csdk_UPLOAD_ASSET_BROWSER_BUTTON));
            }
            if (this.f6136b || !this.f6135a) {
                C0415hc.this.Ea.setVisibility(8);
                C0415hc.this.Da.setVisibility(8);
                C0415hc.this.Fa.setVisibility(8);
            } else {
                C0415hc.this.Ea.setVisibility(0);
                C0415hc.this.Da.setVisibility(0);
                C0415hc.this.Fa.setVisibility(0);
            }
            if (C0455p.a(C0415hc.this.x())) {
                return;
            }
            C0415hc.this.Da.setVisibility(8);
        }

        /* synthetic */ h(C0415hc c0415hc, Yb yb) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CCFilesWithUploadFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.hc$i */
    /* loaded from: classes.dex */
    public class i {

        /* renamed from: a, reason: collision with root package name */
        public com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t<C0578la> f6138a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f6139b;

        i() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ya() {
        if (C0394l.c()) {
            return;
        }
        C0394l.a(true);
        C0394l.b(false);
        C0393k.a();
        a(C0394l.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Za() {
        if (C0394l.d()) {
            C0394l.c(false);
            AbstractC0414hb.b bVar = this.f6107f;
            if (bVar instanceof c) {
                ((c) bVar).b(false);
            }
            nb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _a() {
        ra();
    }

    private void ab() {
        com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t<C0578la> a2;
        if (this.da == null && (a2 = com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.a(C0578la.class).a((com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r) Ga())) != null && a2.b().getHref().equals(Ga().getHref())) {
            e(a2);
        }
    }

    private ProgressDialog bb() {
        this.wa = new ProgressDialog(x());
        this.wa.setMessage(getResources().getString(c.a.a.a.b.i.adobe_csdk_asset_edit_in_progress));
        this.wa.setIndeterminate(true);
        this.wa.setCancelable(false);
        return this.wa;
    }

    private void cb() {
        if (this.ea != null) {
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
        this.ea = new f();
        f fVar = this.ea;
        fVar.f6132b = creativeSDKTextView;
        fVar.f6131a = relativeLayout;
        fVar.f6131a.setVisibility(8);
        S().addView(this.ea.f6131a);
    }

    private void db() {
        this.ua = new ProgressBar(x(), null, R.attr.progressBarStyleHorizontal);
        this.ua.setProgressDrawable(getResources().getDrawable(c.a.a.a.b.d.asset_edit_progress_bar));
        this.ua.setVisibility(8);
        this.ua.setIndeterminateDrawable(getResources().getDrawable(c.a.a.a.b.d.asset_edit_progress_bar));
        this.ua.setIndeterminate(false);
        this.ua.setMax(100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, a(getResources().getDimension(c.a.a.a.b.c.adobe_csdk_asset_edit_move_progress_bar_size)));
        this.ua.setProgress(0);
        layoutParams.addRule(10);
        this.ua.setLayoutParams(layoutParams);
        S().addView(this.ua);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eb() {
        this.ja.setVisible(false);
        this.za.setVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fb() {
        com.adobe.creativesdk.foundation.internal.analytics.q.a("mobile.ccmobile.createNewFolder", new HashMap<String, String>() { // from class: com.adobe.creativesdk.foundation.internal.storage.controllers.CCFilesWithUploadFragment$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                put("area", "operations");
                put("type", "folder");
                put(NativeProtocol.WEB_DIALOG_ACTION, "create");
            }
        }, null);
        a(AdobeAssetViewBrowserCommandName.ACTION_MENU_CREATE_NEWFOLDER, Ga());
    }

    private void gb() {
        Yb yb = null;
        this.Ba.setOnFloatingActionsMenuUpdateListener(new h(this, yb));
        this.Ga.setOnTouchListener(new ViewOnTouchListenerC0366bc(this));
        g gVar = new g(this, yb);
        this.Ea.setOnClickListener(gVar);
        this.Ca.setOnClickListener(gVar);
        this.Da.setOnClickListener(gVar);
        this.Fa.setOnClickListener(gVar);
        if (la() && !this.aa) {
            this.Ba.setVisibility(0);
        } else {
            this.Ba.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hb() {
        C0358a.a().a(AdobeAssetViewBrowserCommandName.ACTION_ASSET_EDIT_MOVE_OPERATION, Ga().getHref().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ib() {
        C0358a.a().a(AdobeAssetViewBrowserCommandName.ACTION_ASSET_VIEW_CC_SHARE_ADVANCE, Ga());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jb() {
        Menu menu = this.sa;
        if (menu != null) {
            a(menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kb() {
        i iVar = this.da;
        return iVar != null && iVar.f6139b;
    }

    private boolean lb() {
        return this.Aa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb() {
        Menu menu = this.sa;
        if (menu != null) {
            b(menu);
        }
    }

    private void nb() {
        this.wa = bb();
        this.wa.show();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void B() {
        com.adobe.creativesdk.foundation.internal.utils.b.a(getActivity().findViewById(R.id.content), true);
        b(true);
        FloatingActionsMenu floatingActionsMenu = this.Ba;
        if (floatingActionsMenu != null) {
            floatingActionsMenu.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void Ca() {
        super.Ca();
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeCCFilesCollaborationChangeTitleToCollaborator, this.qa);
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeCCFilesCollaborationChangeTitleToTargetAsset, this.qa);
        if ((x() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.edit.F) || this.na == null) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeAssetEditProgressChanged, this.na);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected AbstractC0414hb.b D() {
        return new c();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb
    protected void Da() {
        ProgressBar progressBar = this.ua;
        if (progressBar != null) {
            progressBar.setVisibility(0);
            this.ua.setIndeterminate(true);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb
    protected void Ea() {
        ProgressBar progressBar = this.ua;
        if (progressBar != null) {
            progressBar.setIndeterminate(false);
            this.ua.setProgress(100);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb
    public AdobeStorageDataSource.DataSourceInternalFilters Fa() {
        if (x() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.edit.F) {
            this.ra = (com.adobe.creativesdk.foundation.internal.storage.controllers.edit.F) x();
            if (this.ra.p() && this.ra.b().d()) {
                return AdobeStorageDataSource.DataSourceInternalFilters.FilterOnlyFolders;
            }
            return null;
        }
        return super.Fa();
    }

    protected void Ja() {
        this.Q.p();
        this.R.p();
        this.da = null;
        q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public String N() {
        if (!(x() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.edit.F)) {
            return getResources().getString(c.a.a.a.b.i.adobe_csdk_cc_title);
        }
        return getResources().getString(c.a.a.a.b.i.adobe_csdk_asset_view_move_fragment_title);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected int Q() {
        f(true);
        return c.a.a.a.b.g.adobe_storage_assetbrowser_empty_state_view;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void ba() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void da() {
        if (this.ja != null) {
            eb();
        }
        MenuItem menuItem = this.ia;
        if (menuItem != null) {
            menuItem.setVisible(false);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void fa() {
        FloatingActionsMenu floatingActionsMenu = this.Ba;
        if (floatingActionsMenu != null) {
            floatingActionsMenu.setVisibility(8);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public Boolean ka() {
        FloatingActionsMenu floatingActionsMenu = this.Ba;
        return Boolean.valueOf(floatingActionsMenu != null && floatingActionsMenu.f());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public boolean na() {
        return super.na();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        int a2 = a((Activity) getActivity());
        int R = R();
        if (this.Ba != null) {
            c(R, a2);
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.ca == null) {
            this.ca = new C0361ac(this);
        }
        new c.a().a(0.1f);
        this.pa = new d(this, null);
        this.xa = new Handler();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeCCFilesUploadSessionStarted, this.ca);
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeCCFilesUploadSessionComplete, this.ca);
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeCCFilesUploadSessionCancelled, this.ca);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (this.ya && i2 == 0) {
            this.ya = false;
            if (iArr.length == 1 && iArr[0] == 0) {
                a(AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_UPLOAD_FILES, Ga());
            } else {
                Toast.makeText(getActivity(), c.a.a.a.b.i.adobe_csdk_extract_permission_denied, 0).show();
            }
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        com.adobe.creativesdk.foundation.internal.utils.b.a(getActivity().findViewById(R.id.content), true);
        android.arch.lifecycle.s x = x();
        b(!(x instanceof InterfaceC0372cd ? ((InterfaceC0372cd) x).n() : false));
        if (!(x() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.edit.F)) {
            this.pa.b();
            if (C0394l.d()) {
                Za();
            }
            if (!C0394l.c()) {
                Ya();
            }
        }
        if (C0394l.e() && this.ma != null) {
            a(C0394l.b());
        }
        if (com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.f6460b) {
            return;
        }
        k(false);
        Ja();
        com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.f6460b = true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (x() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.edit.F) {
            return;
        }
        this.pa.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void qa() {
        super.qa();
        if (this.qa == null) {
            this.qa = new C0405fc(this);
        }
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeCCFilesRefreshNotificationCount, new Xb(this));
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeCCFilesCollaborationChangeTitleToCollaborator, this.qa);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeCCFilesCollaborationChangeTitleToTargetAsset, this.qa);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeCCFilesUploadSessionStarted, this.ca);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeCCFilesUploadSessionComplete, this.ca);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeCCFilesUploadSessionCancelled, this.ca);
        if (x() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.edit.F) {
            return;
        }
        if (this.na == null) {
            this.na = new e();
        }
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeAssetEditProgressChanged, this.na);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void wa() {
        if (ia()) {
            this.ia.setVisible(!na());
            eb();
        }
        K().c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void xa() {
        if (kb()) {
            return;
        }
        super.xa();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void z() {
        if (!Boolean.valueOf(C0455p.b(getContext())).booleanValue() || (x() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.edit.F)) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(c.a.a.a.b.g.files_floating_menu, (ViewGroup) null);
        this.Ba = (FloatingActionsMenu) relativeLayout.findViewById(c.a.a.a.b.e.adobe_files_uploadFAB);
        this.Ca = (FloatingActionButton) relativeLayout.findViewById(c.a.a.a.b.e.adobe_files_uploadAction);
        this.Da = (FloatingActionButton) relativeLayout.findViewById(c.a.a.a.b.e.adobe_files_takePhoto);
        this.Ea = (FloatingActionButton) relativeLayout.findViewById(c.a.a.a.b.e.adobe_files_createFolder);
        this.Fa = (FloatingActionButton) relativeLayout.findViewById(c.a.a.a.b.e.adobe_files_uploadImages);
        this.Ga = relativeLayout.findViewById(c.a.a.a.b.e.adobe_files_alpha_pane);
        gb();
        relativeLayout.removeView(this.Ba);
        relativeLayout.removeView(this.Ga);
        S().addView(this.Ga);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, R(), a((Activity) getActivity()));
        S().addView(this.Ba, layoutParams);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void za() {
        FloatingActionsMenu floatingActionsMenu = this.Ba;
        if (floatingActionsMenu != null) {
            floatingActionsMenu.setVisibility(0);
        }
    }

    private void e(com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t<C0578la> tVar) {
        this.da = new i();
        i iVar = this.da;
        iVar.f6138a = tVar;
        iVar.f6139b = true;
        this.Q.a(Ga());
        this.Q.a(tVar);
        this.R.a(Ga());
        this.R.a(tVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z) {
        this.za.setVisible(z && !lb());
    }

    private void o(boolean z) {
        ImageButton imageButton = this.la;
        if (imageButton != null) {
            imageButton.setEnabled(z);
            this.la.setAlpha(z ? 1.0f : 0.4f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z) {
        J j = new J();
        j.a(new Yb(this, z));
        j.show(getFragmentManager(), "Leave Folder Alert");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i2) {
        com.adobe.creativesdk.foundation.internal.utils.o.a().post(new RunnableC0371cc(this, i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t<C0578la> tVar) {
        e(tVar);
        k(true);
        ga();
        ea();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb
    protected void i(boolean z) {
        boolean na = na();
        if (ia()) {
            this.ia.setVisible(!na);
            eb();
        } else {
            this.ia.setVisible(false);
            q(!na);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb
    public void j(boolean z) {
        if (ia()) {
            MenuItem menuItem = this.ia;
            if (menuItem != null) {
                menuItem.setVisible(z);
                return;
            }
            return;
        }
        MenuItem menuItem2 = this.ja;
        if (menuItem2 != null) {
            menuItem2.setVisible(z);
            n(z);
        }
    }

    protected void k(boolean z) {
        i iVar = this.da;
        if (iVar == null) {
            return;
        }
        iVar.f6139b = z;
    }

    private void q(boolean z) {
        if (getActivity() == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void c(Bundle bundle) {
        super.c(bundle);
        this.fa = getLayoutInflater(null).inflate(c.a.a.a.b.g.adobe_notification_icon_view, (ViewGroup) null);
        this.ga = (ImageView) this.fa.findViewById(c.a.a.a.b.e.adobe_csdk_notification_icon);
        this.ha = (TextView) this.fa.findViewById(c.a.a.a.b.e.adobe_csdk_notification_count);
        if (!this.aa) {
            z();
        }
        if (this.f6104c.a() != null && this.f6104c.a().isPrivateCloud()) {
            this.ga.setImageResource(c.a.a.a.b.d.ic_notif_black_24dp_disabled);
            this.fa.setEnabled(false);
            TextView textView = this.ha;
            if (textView != null) {
                textView.setVisibility(4);
            }
        }
        ab();
        if (x() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.edit.F) {
            this.ra = (com.adobe.creativesdk.foundation.internal.storage.controllers.edit.F) x();
            if (this.ra.p()) {
                a(this.ra.b());
            }
        }
        this.ma = new ProgressBar(x(), null, R.attr.progressBarStyleHorizontal);
        this.ma.setProgressDrawable(getResources().getDrawable(c.a.a.a.b.d.asset_edit_progress_bar));
        this.ma.setVisibility(8);
        this.ma.setIndeterminateDrawable(getResources().getDrawable(c.a.a.a.b.d.asset_edit_progress_bar));
        this.ma.setIndeterminate(false);
        this.ma.setMax(100);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, a(getResources().getDimension(c.a.a.a.b.c.adobe_csdk_asset_edit_progress_bar_size)));
        this.ma.setProgress(0);
        layoutParams.addRule(10);
        this.ma.setLayoutParams(layoutParams);
        S().addView(this.ma);
        AdobeCollaborationType a2 = Ga().a();
        boolean z = true;
        if (a2 != null && a2 != AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_SHAREDBYUSER && a2 != AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_PRIVATE) {
            z = false;
        }
        this.Aa = z;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb, com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void q() {
        super.q();
        c.a.a.a.c.c.a.a a2 = c.a.a.a.c.c.a.a.a();
        if (a2 == null) {
            return;
        }
        a2.b();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t<C0578la> tVar) {
        k(false);
        Ja();
        com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.f6460b = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str) {
        J j = new J();
        j.a(new _b(this, str, z));
        j.show(getFragmentManager(), "Leave Folder Alert");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: CCFilesWithUploadFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.hc$c */
    /* loaded from: classes.dex */
    public class c extends Hb.a {
        private MenuItem n;

        protected c() {
            super();
        }

        private void k() {
            if (this.n == null) {
                return;
            }
            c.a.a.a.c.c.a.a a2 = c.a.a.a.c.c.a.a.a();
            if (a2 == null) {
                boolean kb = C0415hc.this.kb();
                C0415hc.this.Ga();
                boolean z = !C0415hc.this.aa;
                MenuItem menuItem = this.n;
                if (menuItem != null) {
                    menuItem.setTitle(C0415hc.this.n(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_action_edit_asset));
                    this.n.setVisible((C0415hc.this.na() || kb || C0394l.e() || !C0415hc.this.la() || !z) ? false : true);
                }
                if (C0415hc.this.ja != null) {
                    C0415hc.this.ja.setTitle(C0415hc.this.n(c.a.a.a.b.i.adobe_csdk_collaborator));
                }
                if (C0415hc.this.fa != null) {
                    C0415hc.this.ia.setActionView(C0415hc.this.fa);
                    C0415hc.this.fa.setOnClickListener(new ViewOnClickListenerC0430kc(this));
                }
                C0415hc c0415hc = C0415hc.this;
                c0415hc.n(!c0415hc.ia());
                if (C0415hc.this.ia()) {
                    C0415hc.this.ia.setVisible(!C0415hc.this.na());
                    C0415hc.this.ja.setVisible(false);
                } else {
                    C0415hc.this.ia.setVisible(false);
                    C0415hc.this.ja.setVisible(true);
                }
                if (C0415hc.this.f6104c.a() != null && C0415hc.this.f6104c.a().isPrivateCloud()) {
                    C0415hc.this.ia.setVisible(false);
                    C0415hc.this.ja.setVisible(false);
                }
                if (!C0415hc.this.la()) {
                    C0415hc.this.ia.setVisible(false);
                    C0415hc.this.ja.setVisible(false);
                    this.n.setVisible(false);
                }
                if (C0455p.a(C0415hc.this.x())) {
                    return;
                }
                C0415hc.this.Da.setVisibility(8);
                return;
            }
            C0415hc c0415hc2 = C0415hc.this;
            a2.b();
            throw null;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(Menu menu, MenuInflater menuInflater) {
            super.a(menu, menuInflater);
            C0415hc.this.sa = menu;
            menuInflater.inflate(c.a.a.a.b.h.adobe_assetview_loki_upload_menu, menu);
            this.n = menu.findItem(c.a.a.a.b.e.adobe_csdk_uxassetbrowser_assets_view_edit_asset);
            C0415hc.this.ia = menu.findItem(c.a.a.a.b.e.adobe_csdk_asset_browser_adobe_notification);
            C0415hc.this.ja = menu.findItem(c.a.a.a.b.e.adobe_csdk_asset_browser_collaborator_menu);
            C0415hc.this.za = menu.findItem(c.a.a.a.b.e.adobe_csdk_asset_browser_collaborator_leave_folder_menu);
            if (C0415hc.this.ja != null && C0415hc.this.f6104c.a().isPrivateCloud()) {
                C0415hc.this.eb();
                C0415hc.this.n(false);
            } else {
                C0415hc c0415hc = C0415hc.this;
                c0415hc.n(c0415hc.ia() ? false : true);
            }
            C0415hc.this.oa = menu;
        }

        public void b(boolean z) {
            MenuItem menuItem = this.n;
            if (menuItem != null) {
                menuItem.setVisible(z);
            }
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void c() {
            super.c();
            k();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(Menu menu) {
            super.a(menu);
            k();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public boolean a(int i) {
            if (i == c.a.a.a.b.e.adobe_csdk_uxassetbrowser_assets_view_edit_asset) {
                C0415hc c0415hc = C0415hc.this;
                c0415hc.a(AdobeAssetViewBrowserCommandName.ACTION_ASSET_EDIT_OPEN_MULTI_SELECT_EDIT_WINDOW, c0415hc.Ga().getHref().toString());
                return true;
            }
            if (i == c.a.a.a.b.e.adobe_csdk_asset_browser_adobe_notification) {
                C0415hc.this.a(AdobeAssetViewBrowserCommandName.ACTION_MENU_NOTIFICATION, (Object) null);
                return true;
            }
            if (i == c.a.a.a.b.e.adobe_csdk_asset_browser_collaborator_menu) {
                C0415hc c0415hc2 = C0415hc.this;
                c0415hc2.a(AdobeAssetViewBrowserCommandName.ACTION_MENU_COLLABORATION, c0415hc2.Ga().getHref().toString());
                return true;
            }
            if (i == c.a.a.a.b.e.adobe_csdk_asset_browser_collaborator_leave_folder_menu) {
                C0415hc.this.p(true);
            }
            return super.a(i);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb, com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(Object obj, View view) {
        if ((getActivity() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.utils.e) && !C0394l.e() && la()) {
            ((com.adobe.creativesdk.foundation.internal.storage.controllers.utils.e) getActivity()).a(obj, this.f6104c, view, AdobeAssetType.ADOBE_ASSET_TYPE_FILE);
        }
    }

    private int a(float f2) {
        return Math.round(f2 * x().getApplicationContext().getResources().getDisplayMetrics().density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(double d2) {
        this.ma.setVisibility(0);
        this.ma.setProgress((int) (d2 * 100.0d));
    }

    protected void a(C0390h c0390h) {
        if (c0390h.a()) {
            this.Q.c(true);
            db();
            this.va = false;
            Yb yb = null;
            if (!c0390h.c()) {
                this.f6107f = new a(this, yb);
            } else {
                this.f6107f = new b(this, yb);
            }
            if (!ia()) {
                com.adobe.creativesdk.foundation.internal.utils.b.a(getActivity().findViewById(R.id.content), Ga().getName());
            } else {
                com.adobe.creativesdk.foundation.internal.utils.b.a(getActivity().findViewById(R.id.content), c0390h.b());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Hb, com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.utils.b bVar) {
        String string;
        String string2;
        View e2;
        String str;
        FragmentActivity activity = getActivity();
        if (activity == 0) {
            return;
        }
        Sa a2 = bVar.a();
        if (bVar.b()) {
            string = activity.getString(c.a.a.a.b.i.adobe_csdk_coach_mark_screenshot_folder_title);
            string2 = activity.getString(c.a.a.a.b.i.adobe_csdk_coach_mark_screenshot_folder_body);
            e2 = a2.g();
            str = "screenshots_folder";
        } else {
            string = activity.getString(c.a.a.a.b.i.adobe_csdk_coach_mark_asset_title);
            string2 = activity.getString(c.a.a.a.b.i.adobe_csdk_coach_mark_asset_body);
            e2 = a2.e();
            str = "asset";
        }
        View view = e2;
        String str2 = str;
        String str3 = string2;
        String str4 = string;
        if (!(activity instanceof com.adobe.creativesdk.foundation.internal.utils.a.b) || view == null) {
            return;
        }
        ((com.adobe.creativesdk.foundation.internal.utils.a.b) activity).a(activity, str4, str3, activity.getString(c.a.a.a.b.i.adobe_csdk_coach_mark_common_footer), view, false, 0, null, str2);
    }

    private void c(int i2, int i3) {
        ((RelativeLayout.LayoutParams) this.Ba.getLayoutParams()).setMargins(0, 0, i2, i3);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void c(boolean z) {
        o(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t<C0578la> tVar) {
        k(false);
        Ja();
        a((com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t) tVar);
        com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.f6460b = true;
        android.arch.lifecycle.s activity = getActivity();
        if (activity == null || !(activity instanceof InterfaceC0372cd)) {
            return;
        }
        ((InterfaceC0372cd) activity).m();
    }

    private void a(C0399q c0399q) {
        String format;
        C0399q.a a2 = c0399q.a();
        if (a2.c()) {
            ProgressDialog progressDialog = this.wa;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            Toast.makeText(x(), c.a.a.a.b.i.adobe_csdk_asset_move_error_same_location, 1).show();
            return;
        }
        cb();
        int a3 = a2.a();
        String str = "";
        if (a3 > 0) {
            this.ea.f6131a.setBackgroundResource(c.a.a.a.b.b.adobe_csdk_assetview_common_error_banner_background);
            if (a3 == 1) {
                AdobeCCFilesEditOperation adobeCCFilesEditOperation = a2.f6067a;
                if (adobeCCFilesEditOperation == AdobeCCFilesEditOperation.ADOBE_CC_FILE_EDIT_OPERATION_RENAME) {
                    str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_EDIT_SINGLE_ERROR_MSG);
                } else if (adobeCCFilesEditOperation == AdobeCCFilesEditOperation.ADOBE_CC_FILE_EDIT_OPERATION_ERASE) {
                    str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_ARCHIVE_SINGLE_ERROR_MSG);
                } else if (adobeCCFilesEditOperation == AdobeCCFilesEditOperation.ADOBE_CC_FILE_EDIT_OPERATION_MOVE) {
                    str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_MOVE_SINGLE_ERROR_MSG);
                }
            } else {
                AdobeCCFilesEditOperation adobeCCFilesEditOperation2 = a2.f6067a;
                if (adobeCCFilesEditOperation2 == AdobeCCFilesEditOperation.ADOBE_CC_FILE_EDIT_OPERATION_RENAME) {
                    str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_EDIT_ERROR_MSG);
                } else if (adobeCCFilesEditOperation2 == AdobeCCFilesEditOperation.ADOBE_CC_FILE_EDIT_OPERATION_ERASE) {
                    str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_ARCHIVE_MULTIPLE_ERROR_MSG);
                } else if (adobeCCFilesEditOperation2 == AdobeCCFilesEditOperation.ADOBE_CC_FILE_EDIT_OPERATION_MOVE) {
                    str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_MOVE_ERROR_MSG);
                }
            }
            format = String.format(str, Integer.toString(a3));
            this.ea.f6131a.setOnClickListener(new ViewOnClickListenerC0376dc(this, c0399q));
        } else {
            ProgressBar progressBar = this.ma;
            if (progressBar != null) {
                progressBar.setVisibility(0);
                this.ma.setProgress(100);
            }
            this.ea.f6131a.setBackgroundResource(c.a.a.a.b.b.adobe_csdk_assetview_common_success_banner_background);
            if (a2.b() == 1) {
                AdobeCCFilesEditOperation adobeCCFilesEditOperation3 = a2.f6067a;
                if (adobeCCFilesEditOperation3 == AdobeCCFilesEditOperation.ADOBE_CC_FILE_EDIT_OPERATION_RENAME) {
                    str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_EDIT_SINGLE_SUCCESS_MSG);
                } else if (adobeCCFilesEditOperation3 == AdobeCCFilesEditOperation.ADOBE_CC_FILE_EDIT_OPERATION_ERASE) {
                    str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_ARCHIVE_SINGLE_SUCCESS_MSG);
                } else if (adobeCCFilesEditOperation3 == AdobeCCFilesEditOperation.ADOBE_CC_FILE_EDIT_OPERATION_MOVE) {
                    str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_MOVE_SINGLE_SUCCESS_MSG);
                }
            } else {
                AdobeCCFilesEditOperation adobeCCFilesEditOperation4 = a2.f6067a;
                if (adobeCCFilesEditOperation4 == AdobeCCFilesEditOperation.ADOBE_CC_FILE_EDIT_OPERATION_RENAME) {
                    str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_EDIT_SUCCESS_MSG);
                } else if (adobeCCFilesEditOperation4 == AdobeCCFilesEditOperation.ADOBE_CC_FILE_EDIT_OPERATION_ERASE) {
                    str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_ARCHIVE_MULTIPLE_SUCCESS_MSG);
                } else if (adobeCCFilesEditOperation4 == AdobeCCFilesEditOperation.ADOBE_CC_FILE_EDIT_OPERATION_MOVE) {
                    str = getResources().getString(c.a.a.a.b.i.adobe_csdk_IDS_MOVE_SUCCESS_MSG);
                }
            }
            format = String.format(str, Integer.toString(a2.b()));
        }
        ra();
        ProgressDialog progressDialog2 = this.wa;
        if (progressDialog2 != null) {
            progressDialog2.dismiss();
        }
        ProgressBar progressBar2 = this.ma;
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
        this.ea.f6132b.setText(format);
        this.ea.f6131a.setVisibility(0);
        com.adobe.creativesdk.foundation.internal.utils.o.a().postDelayed(new RunnableC0381ec(this), 5000L);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void a(View view) {
        if (Ga().d() || s()) {
            return;
        }
        ((TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_storage_asset_browser_empty_state_message)).setVisibility(this.va ? 0 : 4);
    }
}
