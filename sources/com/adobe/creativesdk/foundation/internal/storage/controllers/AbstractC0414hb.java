package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SearchView;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.KeyCharacterMap;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.auth.AdobeAuthUserProfile;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.internal.utils.CreativeSDKTextView;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.facebook.internal.NativeProtocol;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Observer;

/* compiled from: AssetViewFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.hb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0414hb extends Va implements InterfaceC0362ad {
    private boolean[] A;
    private View B;
    private View C;
    private View D;
    private View E;
    private View F;
    private c G;
    private View H;
    private ImageView I;
    private TextView J;
    private MenuItem K;
    private MenuItem L;
    private Observer M;
    protected com.adobe.creativesdk.foundation.internal.storage.controllers.c.b N;
    private boolean O;

    /* renamed from: c, reason: collision with root package name */
    protected C0474t f6104c;

    /* renamed from: d, reason: collision with root package name */
    protected AbstractC0457pb f6105d;

    /* renamed from: f, reason: collision with root package name */
    protected b f6107f;

    /* renamed from: g, reason: collision with root package name */
    AbstractC0457pb.a f6108g;
    private Observer i;
    private boolean k;
    private Observer p;
    private int q;
    private d r;
    private View s;
    private LinearLayout t;
    private LinearLayout u;
    private TextView v;
    private RelativeLayout w;
    private FrameLayout y;
    private RelativeLayout z;

    /* renamed from: b, reason: collision with root package name */
    private final String f6103b = "orientation";

    /* renamed from: e, reason: collision with root package name */
    protected boolean f6106e = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f6109h = false;
    private boolean j = false;
    private boolean l = false;
    private boolean m = false;
    private boolean n = true;
    private boolean o = false;
    private View x = null;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AssetViewFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.hb$b */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        protected MenuItem f6111a;

        /* renamed from: b, reason: collision with root package name */
        private MenuItem f6112b;

        /* renamed from: d, reason: collision with root package name */
        private boolean f6114d;

        /* renamed from: f, reason: collision with root package name */
        a f6116f;

        /* renamed from: c, reason: collision with root package name */
        private final String f6113c = "";

        /* renamed from: e, reason: collision with root package name */
        private String f6115e = "";

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AssetViewFragment.java */
        /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.hb$b$a */
        /* loaded from: classes.dex */
        public class a {

            /* renamed from: a, reason: collision with root package name */
            public boolean f6118a;

            /* renamed from: b, reason: collision with root package name */
            public String f6119b;

            a() {
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public b() {
        }

        public void b() {
        }

        public void c() {
            MenuItem menuItem = this.f6112b;
            if (menuItem != null) {
                menuItem.setVisible(AbstractC0414hb.this.ha());
            }
        }

        protected void d() {
            if (this.f6116f == null) {
                return;
            }
            SearchView searchView = (SearchView) MenuItemCompat.getActionView(this.f6112b);
            searchView.setIconified(!this.f6116f.f6118a);
            if (this.f6116f.f6118a) {
                MenuItemCompat.expandActionView(this.f6112b);
                searchView.setQuery(this.f6116f.f6119b, false);
            }
            this.f6116f = null;
        }

        public void e() {
            this.f6116f = new a();
            this.f6116f.f6118a = !this.f6115e.equalsIgnoreCase("");
            this.f6116f.f6119b = this.f6115e;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean f() {
            return !C0455p.b(AbstractC0414hb.this.x()) && com.adobe.creativesdk.foundation.internal.storage.controllers.utils.a.a();
        }

        public void g() {
            if (AbstractC0414hb.this.L != null) {
                if (!com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.f6459a) {
                    AbstractC0414hb.this.L.setVisible(false);
                } else {
                    com.adobe.creativesdk.foundation.internal.storage.controllers.upload.r.f6459a = true;
                    AbstractC0414hb.this.L.setVisible(true);
                }
            }
        }

        public void a(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(c.a.a.a.b.h.adobe_assetview_common_menu, menu);
            this.f6111a = menu.findItem(c.a.a.a.b.e.adobe_csdk_uxassetbrowser_sdk_common_menu_myaccount);
            this.f6111a.setVisible(f());
            AbstractC0414hb.this.L = menu.findItem(c.a.a.a.b.e.adobe_csdk_asset_browser_adobe_upload_tasks);
            this.f6112b = menu.findItem(c.a.a.a.b.e.adobe_csdk_common_search);
            if (!Boolean.valueOf(C0455p.b(AbstractC0414hb.this.getContext())).booleanValue()) {
                this.f6112b.setIcon(AbstractC0414hb.this.getResources().getDrawable(c.a.a.a.b.d.ic_search_black_24dp));
            }
            SearchView searchView = (SearchView) MenuItemCompat.getActionView(this.f6112b);
            View findViewById = searchView.findViewById(c.a.a.a.b.e.search_plate);
            if (findViewById != null) {
                findViewById.setBackgroundResource(c.a.a.a.b.d.search_box_appearance);
            }
            EditText editText = (EditText) searchView.findViewById(c.a.a.a.b.e.search_src_text);
            editText.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0419ib(this));
            editText.setOnKeyListener(new ViewOnKeyListenerC0424jb(this));
            MenuItemCompat.setOnActionExpandListener(this.f6112b, new C0429kb(this, editText, menu, searchView));
            C0434lb c0434lb = new C0434lb(this, AbstractC0414hb.this.getActivity());
            if (editText != null) {
                try {
                    editText.setTypeface(com.adobe.creativesdk.foundation.internal.utils.c.a(AbstractC0414hb.this.getActivity()));
                    editText.setTextColor(AbstractC0414hb.this.getResources().getColor(c.a.a.a.b.b.adobe_csdk_asset_browser_dark_text));
                    editText.setTextSize(21.0f);
                    editText.addTextChangedListener(new C0439mb(this, findViewById));
                } catch (ClassNotFoundException e2) {
                    e2.printStackTrace();
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                } catch (NoSuchMethodException e4) {
                    e4.printStackTrace();
                } catch (InvocationTargetException e5) {
                    e5.printStackTrace();
                }
            }
            Class<?> cls = Class.forName("android.widget.SearchView$SearchAutoComplete");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
            spannableStringBuilder.append((CharSequence) AbstractC0414hb.this.f(AbstractC0414hb.this.getResources().getString(c.a.a.a.b.i.adobe_csdk_search_query_hint)));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(AbstractC0414hb.this.getResources().getColor(c.a.a.a.b.b.adobe_csdk_asset_browser_light_text)), 0, spannableStringBuilder.length(), 33);
            cls.getMethod("setHint", CharSequence.class).invoke(editText, spannableStringBuilder);
            searchView.setOnQueryTextListener(c0434lb);
        }

        public void a(Menu menu) {
            this.f6111a.setTitle(C0455p.a(AbstractC0414hb.this.getResources().getString(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_sdk_myaccount), AbstractC0414hb.this.getActivity()));
            this.f6111a.setVisible(f());
            g();
            if (AbstractC0414hb.this.M() != null) {
                this.f6112b = menu.findItem(c.a.a.a.b.e.adobe_csdk_common_search);
                boolean z = AbstractC0414hb.this.f6106e || this.f6114d;
                boolean isActionViewExpanded = MenuItemCompat.isActionViewExpanded(this.f6112b);
                if (!isActionViewExpanded && z && this.f6116f == null) {
                    AbstractC0414hb.this.O = false;
                }
                c();
                if (z) {
                    d();
                    this.f6114d = false;
                } else if (isActionViewExpanded) {
                    MenuItemCompat.collapseActionView(this.f6112b);
                }
                if (AbstractC0414hb.this.O) {
                    return;
                }
                if (AbstractC0414hb.this.la()) {
                    AbstractC0414hb.this.za();
                } else {
                    AbstractC0414hb.this.fa();
                }
            }
        }

        public void a() {
            MenuItem menuItem = this.f6112b;
            if (menuItem == null || !MenuItemCompat.isActionViewExpanded(menuItem)) {
                return;
            }
            MenuItemCompat.collapseActionView(this.f6112b);
        }

        public void a(boolean z) {
            MenuItem menuItem = this.f6112b;
            if (menuItem != null) {
                menuItem.setVisible(z);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean a(int i) {
            if (i == c.a.a.a.b.e.adobe_csdk_uxassetbrowser_sdk_common_menu_myaccount) {
                AbstractC0414hb.this.a(AdobeAssetViewBrowserCommandName.ACTION_MENU_SHOW_MY_ACCOUNT, (Object) null);
                return true;
            }
            if (i == c.a.a.a.b.e.adobe_csdk_common_search) {
                com.adobe.creativesdk.foundation.internal.analytics.q.a("Search Button Tapped");
                com.adobe.creativesdk.foundation.internal.analytics.q.a("mobile.ccmobile.searchBarTapped", new HashMap<String, String>() { // from class: com.adobe.creativesdk.foundation.internal.storage.controllers.AssetViewFragment$AssetsViewBaseActionBarController$6
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        put("area", "browser");
                        put("type", "assets");
                        put(NativeProtocol.WEB_DIALOG_ACTION, "searchBarTapped");
                    }
                }, null);
                new com.adobe.creativesdk.foundation.internal.analytics.b("cc_file").a();
                ((SearchView) MenuItemCompat.getActionView(this.f6112b)).setOnSearchClickListener(new ViewOnClickListenerC0447nb(this));
                return true;
            }
            if (i != c.a.a.a.b.e.adobe_csdk_asset_browser_adobe_upload_tasks) {
                return false;
            }
            AbstractC0414hb.this.startActivity(new Intent(AbstractC0414hb.this.getContext(), (Class<?>) AdobeShowUploadTasksActivity.class));
            return false;
        }

        public boolean a(MenuItem menuItem) {
            return a(menuItem.getItemId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AssetViewFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.hb$c */
    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public int f6121a;

        /* renamed from: b, reason: collision with root package name */
        public int f6122b;

        protected c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AssetViewFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.hb$d */
    /* loaded from: classes.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        public View f6124a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f6125b;

        d() {
        }
    }

    private void Da() {
        View view = this.s;
        if (view == null || view.getVisibility() != 4 || L() <= 0) {
            return;
        }
        this.s.setVisibility(0);
    }

    private void Ea() {
        this.C = null;
        this.B = null;
        this.F = null;
    }

    private void Fa() {
        if (this.r != null) {
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
        this.r = new d();
        d dVar = this.r;
        dVar.f6125b = creativeSDKTextView;
        dVar.f6124a = relativeLayout;
        dVar.f6124a.setVisibility(8);
        S().addView(this.r.f6124a);
    }

    private int Ga() {
        return getResources().getConfiguration().orientation;
    }

    private void Ha() {
        this.D.setVisibility(8);
    }

    private void Ia() {
        K().b();
        Oa();
        C();
    }

    private boolean Ja() {
        View view = this.D;
        return view != null && view.getVisibility() == 0;
    }

    private boolean Ka() {
        View view = this.x;
        return view != null && view.getVisibility() == 0;
    }

    private boolean La() {
        return this.B != null;
    }

    private boolean Ma() {
        View view = this.E;
        return view != null && view.getVisibility() == 0;
    }

    private boolean Na() {
        AdobeAuthUserProfile f2 = com.adobe.creativesdk.foundation.internal.auth.E.m().f();
        String countryCode = f2 != null ? f2.getCountryCode() : null;
        if (countryCode != null) {
            return countryCode.equalsIgnoreCase(Locale.SIMPLIFIED_CHINESE.getCountry());
        }
        return false;
    }

    private void Oa() {
        ActionBar supportActionBar = ((com.adobe.creativesdk.foundation.internal.base.a) getActivity()).getSupportActionBar();
        if (supportActionBar == null) {
            return;
        }
        if (ia()) {
            i(N());
            return;
        }
        if (Boolean.valueOf(C0455p.b(getContext())).booleanValue()) {
            if (Build.VERSION.SDK_INT >= 21) {
                supportActionBar.setHomeAsUpIndicator(getResources().getDrawable(c.a.a.a.b.d.ic_arrow_back_white_24dp, null));
            } else {
                supportActionBar.setHomeAsUpIndicator(getResources().getDrawable(c.a.a.a.b.d.ic_arrow_back_white_24dp));
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            supportActionBar.setHomeAsUpIndicator(getResources().getDrawable(c.a.a.a.b.d.ic_arrow_back_black_24dp, null));
        } else {
            supportActionBar.setHomeAsUpIndicator(getResources().getDrawable(c.a.a.a.b.d.ic_arrow_back_black_24dp));
        }
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        i(O());
    }

    private void Pa() {
        sa();
        ta();
    }

    private void Qa() {
        Aa();
        e(false);
        K().c();
    }

    private void Ra() {
        if (this.s != null) {
            return;
        }
        this.s = LayoutInflater.from(getActivity()).inflate(c.a.a.a.b.g.adobe_assetview_container_selection_bottom_bar, (ViewGroup) this.w, false);
        this.t = (LinearLayout) this.s.findViewById(c.a.a.a.b.e.adobe_csdk_storage_selection_open_file_btn);
        this.u = (LinearLayout) this.s.findViewById(c.a.a.a.b.e.adobe_csdk_storage_selection_cancel_btn);
        this.v = (TextView) this.s.findViewById(c.a.a.a.b.e.adobe_csdk_storage_selection_open_file_btn_title);
        this.t.setOnClickListener(new Ya(this));
        this.u.setOnClickListener(new Za(this));
        this.s.setVisibility(8);
        this.z.addView(this.s);
    }

    private void Sa() {
        if (this.B != null) {
            return;
        }
        this.B = LayoutInflater.from(getActivity()).inflate(c.a.a.a.b.g.adobe_csdk_common_errorview, (ViewGroup) this.y, false);
        this.C = LayoutInflater.from(getActivity()).inflate(c.a.a.a.b.g.adobe_csdk_common_popup_bannerview, (ViewGroup) this.y, false);
        this.D = LayoutInflater.from(getActivity()).inflate(c.a.a.a.b.g.adobe_cloud_not_reachable, (ViewGroup) this.y, false);
        this.B.setVisibility(8);
        this.C.setVisibility(8);
        this.D.setVisibility(8);
        if (!com.adobe.creativesdk.foundation.adobeinternal.net.a.b().b()) {
            S().addView(this.B);
            S().addView(this.C);
        } else {
            S().addView(this.D);
            S().findViewById(c.a.a.a.b.e.adobe_csdk_cloud_not_reachable_retry_btn).setOnClickListener(new _a(this));
        }
    }

    private void Ta() {
        Sa();
        CreativeSDKTextView creativeSDKTextView = (CreativeSDKTextView) S().findViewById(c.a.a.a.b.e.adobe_csdk_cloud_not_reachable_error_message);
        if (this.f6104c.a() != null && !this.f6104c.a().isPrivateCloud()) {
            creativeSDKTextView.setText(c.a.a.a.b.i.adobe_csdk_cloud_not_reachable_public_cloud);
        }
        this.D.setVisibility(0);
    }

    private void Ua() {
        if (Na()) {
            this.E = LayoutInflater.from(getActivity()).inflate(c.a.a.a.b.g.adobe_csdk_restricted_region_error, (ViewGroup) this.y, false);
            S().addView(this.E);
        }
    }

    private void Va() {
        AbstractC0457pb abstractC0457pb;
        if (this.l || (abstractC0457pb = this.f6105d) == null) {
            return;
        }
        abstractC0457pb.g();
    }

    private void i(String str) {
        com.adobe.creativesdk.foundation.internal.utils.b.a(getActivity().findViewById(R.id.content), str);
    }

    private void j(boolean z) {
        View view = this.s;
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        this.s.setVisibility(z ? 0 : 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i) {
        if (this.J == null) {
            return;
        }
        if (this.f6104c.a() == null || !this.f6104c.a().isPrivateCloud()) {
            com.adobe.creativesdk.foundation.internal.utils.o.a().post(new Wa(this, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A() {
        b bVar = this.f6107f;
        if (bVar != null) {
            bVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Aa() {
        this.x.setVisibility(0);
        setHasOptionsMenu(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B() {
    }

    protected void Ba() {
        AbstractC0457pb abstractC0457pb = this.f6105d;
        if (abstractC0457pb != null) {
            abstractC0457pb.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C() {
        String format;
        Ra();
        int L = L();
        this.s.setVisibility(L > 0 ? 0 : 8);
        if (L <= 1) {
            format = com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_storage_open_files);
        } else if (L > 99) {
            format = com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_storage_open_multiple_files_99);
        } else {
            format = String.format(com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_storage_open_multiple_files), Integer.toString(L));
        }
        this.v.setText(format);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ca() {
        com.adobe.creativesdk.foundation.internal.storage.controllers.c.b bVar = this.N;
        if (bVar != null) {
            bVar.c(AdobeInternalNotificationID.AdobeNetworkStatusChangeNotification);
            this.N.c(AdobeInternalNotificationID.AdobeAppOrientationConfigurationChanged);
        }
    }

    protected b D() {
        if (!(getActivity() instanceof AdobeUxAssetBrowserV2Activity) && C0455p.b(getActivity())) {
            return new a();
        }
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E() {
        ya();
        pa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F() {
        this.m = false;
        ga();
        Ba();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G() {
        this.j = false;
        xa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H() {
        this.j = false;
        this.l = true;
        if (this.f6105d != null && !this.m) {
            pa();
        }
        Qa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I() {
        if (P().getCount() <= 0 && !this.m) {
            Aa();
            e(false);
        }
        Va();
        Pa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J() {
        if (!this.m) {
            Aa();
            e(false);
        }
        Va();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b K() {
        if (this.f6107f == null) {
            this.f6107f = D();
        }
        return this.f6107f;
    }

    protected abstract int L();

    /* JADX INFO: Access modifiers changed from: protected */
    public FrameLayout M() {
        return this.y;
    }

    protected abstract String N();

    protected abstract String O();

    protected abstract com.adobe.creativesdk.foundation.internal.storage.ga P();

    protected int Q() {
        return c.a.a.a.b.g.adobe_storage_assetbrowser_empty_state_view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int R() {
        return (int) ((getContext().getResources().getDisplayMetrics().density * (a(getContext()) ? 24.0f : 9.0f)) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RelativeLayout S() {
        return this.w;
    }

    protected void T() {
    }

    protected boolean U() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void W();

    /* JADX INFO: Access modifiers changed from: protected */
    public void X() {
        com.adobe.creativesdk.foundation.internal.storage.controllers.c.b bVar = this.N;
        if (bVar != null) {
            bVar.a(AdobeInternalNotificationID.AdobeNetworkStatusChangeNotification);
            this.N.a(AdobeInternalNotificationID.AdobeAppOrientationConfigurationChanged);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Y() {
        this.G = new c();
        a(this.G);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void Z();

    protected abstract C0474t a(Bundle bundle);

    protected void a(View view) {
    }

    protected abstract void a(C0474t c0474t);

    protected void aa() {
    }

    protected void b(Bundle bundle) {
    }

    protected void ba() {
    }

    protected void c(boolean z) {
    }

    protected abstract boolean ca();

    protected abstract void d(boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    public void da() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ea() {
        if (this.F == null) {
            e(true);
            K().c();
        } else {
            i(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fa() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean g(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public void ga() {
        this.x.setVisibility(4);
        setHasOptionsMenu(ca());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ha() {
        return this.y.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ia() {
        return true;
    }

    protected boolean ja() {
        View view = this.F;
        return view != null && view.getVisibility() == 0;
    }

    public void k() {
        P().c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Boolean ka() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean la() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(int i) {
        this.m = false;
        ga();
        if (i > 0) {
            ea();
        } else {
            this.j = false;
            xa();
        }
    }

    protected boolean ma() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SpannableString n(int i) {
        return f(o(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean na() {
        return this.O;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String o(int i) {
        return getResources().getString(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oa() {
        g(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(ca());
        this.f6104c = a(getArguments());
        if (bundle != null) {
            d(bundle);
        } else {
            a(this.f6104c);
        }
        b(bundle);
        this.N = new com.adobe.creativesdk.foundation.internal.storage.controllers.c.b();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.clear();
        K().a(menu, menuInflater);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setHasOptionsMenu(ca());
        this.w = (RelativeLayout) layoutInflater.inflate(c.a.a.a.b.g.adobe_assetview_main_container, viewGroup, false);
        this.x = this.w.findViewById(c.a.a.a.b.e.adobe_csdk_assetview_container_progressBar);
        this.y = (FrameLayout) this.w.findViewById(c.a.a.a.b.e.adobe_csdk_assetview_container_content_assetsview);
        this.z = (RelativeLayout) this.w.findViewById(c.a.a.a.b.e.adobe_csdk_assetview_container_content_rootview);
        this.f6106e = P() != null;
        va();
        this.q = Ga();
        c(bundle);
        return this.w;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ua();
        this.s = null;
        P().b();
        A();
        Ea();
        this.y.removeAllViews();
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (K().a(menuItem)) {
            return true;
        }
        if (menuItem.getItemId() == 16908332 && ia()) {
            a(AdobeAssetViewBrowserCommandName.NAVIGATE_BACK, (Object) null);
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        this.k = false;
        this.q = Ga();
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        K().a(menu);
        if (Ja() || Ka()) {
            for (int i = 0; i < menu.size(); i++) {
                menu.getItem(i).setEnabled(false);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        if (this.q != Ga()) {
            V();
        }
        this.k = true;
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        e(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        boolean z;
        super.onStart();
        ba();
        this.f6109h = false;
        d(true);
        b bVar = this.f6107f;
        if (bVar != null) {
            bVar.g();
        }
        X();
        qa();
        Ia();
        Ua();
        boolean b2 = com.adobe.creativesdk.foundation.adobeinternal.net.a.b().b();
        if (b2) {
            h(false);
            Pa();
            T();
            z = U();
        } else {
            g(true);
            z = false;
        }
        if (this.f6106e && !z) {
            ga();
            if ((P().getCount() == 0 || !this.j || ma()) && b2) {
                this.j = false;
                ra();
                return;
            }
            return;
        }
        if (this.j) {
            return;
        }
        this.j = false;
        ra();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        P().b();
        K().e();
        com.adobe.creativesdk.foundation.adobeinternal.net.a.a();
        Ca();
        this.f6109h = true;
        Y();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pa() {
        this.f6105d.e();
    }

    public void q() {
        A();
        boolean z = this.m;
        this.m = true;
        if (!P().a()) {
            this.m = z;
        } else {
            j(false);
        }
        Ba();
        c.a.a.a.c.c.a.a a2 = c.a.a.a.c.c.a.a.a();
        if (a2 == null) {
            return;
        }
        a2.b();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qa() {
        if (this.i == null) {
            this.i = new C0360ab(this);
        }
        if (this.p == null) {
            this.p = new C0365bb(this);
        }
        if (this.N == null) {
            this.N = new com.adobe.creativesdk.foundation.internal.storage.controllers.c.b();
        }
        if (this.M == null) {
            this.M = new C0370cb(this);
        }
        this.N.a(AdobeInternalNotificationID.AdobeNetworkStatusChangeNotification, this.i);
        this.N.a(AdobeInternalNotificationID.AdobeAppOrientationConfigurationChanged, this.p);
        this.N.a(AdobeInternalNotificationID.AdobeNoUploadSessions, this.M);
        this.N.a(AdobeInternalNotificationID.AdobeUploadSessionsActive, this.M);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeCCFilesRefreshNotificationCount, new C0375db(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ra() {
        P().a();
    }

    protected abstract void sa();

    /* JADX INFO: Access modifiers changed from: protected */
    public void ta() {
        AbstractC0457pb.a aVar = this.f6108g;
        if (aVar != null) {
            this.f6105d.a(aVar);
            this.f6108g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ua() {
        AbstractC0457pb abstractC0457pb = this.f6105d;
        this.f6108g = abstractC0457pb != null ? abstractC0457pb.c() : null;
    }

    protected abstract void va();

    /* JADX INFO: Access modifiers changed from: protected */
    public void wa() {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public FragmentActivity x() {
        return getActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xa() {
        i(true);
    }

    protected void ya() {
    }

    protected void z() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void za() {
    }

    private void f(Bundle bundle) {
        if (bundle == null && this.G == null) {
            return;
        }
        int i = bundle != null ? bundle.getInt("orientation", -1) : this.G.f6122b;
        if (i == -1 || i == Ga()) {
            return;
        }
        V();
    }

    private void i(boolean z) {
        if (Ma()) {
            return;
        }
        if (this.F == null) {
            this.F = LayoutInflater.from(getActivity()).inflate(Q(), (ViewGroup) this.y, false);
            a(this.F);
            S().addView(this.F);
            if (this.o) {
                z();
                this.o = false;
            }
        }
        this.F.setVisibility(z ? 0 : 8);
        e(!z);
        K().c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put("isCollectionRoot", Boolean.valueOf(ia()));
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobeAssetViewNavigateToCollectionNotification, hashMap));
        f(bundle);
    }

    protected void d(Bundle bundle) {
        a(this.f6104c);
    }

    protected void e(Bundle bundle) {
        bundle.putInt("orientation", Ga());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(boolean z) {
        this.n = false;
        Sa();
        fa();
        if (!ha() && !ja()) {
            ga();
            e(false);
            this.B.setVisibility(0);
            this.C.setVisibility(8);
            this.D.setVisibility(8);
            K().a(false);
        } else {
            this.C.setVisibility(0);
        }
        Ba();
        aa();
        c(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(boolean z) {
        this.n = true;
        za();
        if (!ha() && La() && this.B.getVisibility() == 0) {
            e(true);
            this.B.setVisibility(8);
            K().a(true);
            Aa();
        }
        if (La()) {
            this.C.setVisibility(8);
        }
        if (z) {
            q();
        }
        c(true);
    }

    private int b(Context context) {
        int identifier;
        boolean hasPermanentMenuKey = ViewConfiguration.get(context).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey && deviceHasKey) {
            return 0;
        }
        Resources resources = getContext().getResources();
        int i = getResources().getConfiguration().orientation;
        if (a(context)) {
            identifier = resources.getIdentifier(i != 1 ? "navigation_bar_height_landscape" : "navigation_bar_height", "dimen", "android");
        } else {
            identifier = resources.getIdentifier(i != 1 ? "navigation_bar_width" : "navigation_bar_height", "dimen", "android");
        }
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(boolean z) {
        this.y.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SpannableString f(String str) {
        return C0455p.a(str, getActivity());
    }

    public void f(boolean z) {
        this.o = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(Activity activity) {
        float f2;
        Boolean valueOf = Boolean.valueOf(getResources().getConfiguration().orientation == 1);
        Boolean valueOf2 = Boolean.valueOf(com.adobe.creativesdk.foundation.internal.utils.s.a(x()));
        float f3 = getContext().getResources().getDisplayMetrics().density;
        int b2 = (a((Context) activity) || getResources().getConfiguration().orientation != 2) ? b(activity) : 0;
        if (valueOf2.booleanValue()) {
            return b2;
        }
        if (a(getContext())) {
            f2 = 24.0f;
        } else {
            if (!valueOf.booleanValue()) {
                return b2;
            }
            f2 = 16.0f;
        }
        return (int) ((f3 * f2) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Menu menu) {
        if (this.A == null) {
            return;
        }
        int size = menu.size();
        if (this.A.length != size) {
            this.A = null;
        }
        for (int i = 0; i < size; i++) {
            menu.getItem(i).setVisible(this.A[i] && la());
        }
        this.A = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AssetViewFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.hb$a */
    /* loaded from: classes.dex */
    public class a extends b {
        /* JADX INFO: Access modifiers changed from: protected */
        public a() {
            super();
        }

        private void h() {
            c.a.a.a.c.c.a.a a2 = c.a.a.a.c.c.a.a.a();
            if (a2 == null) {
                if (AbstractC0414hb.this.H != null) {
                    AbstractC0414hb.this.K.setActionView(AbstractC0414hb.this.H);
                    AbstractC0414hb.this.H.setOnClickListener(new ViewOnClickListenerC0409gb(this));
                }
                if (AbstractC0414hb.this.K != null) {
                    if (!AbstractC0414hb.this.la() || (AbstractC0414hb.this.f6104c.a() != null && AbstractC0414hb.this.f6104c.a().isPrivateCloud())) {
                        AbstractC0414hb.this.K.setVisible(false);
                        return;
                    }
                    return;
                }
                return;
            }
            AbstractC0414hb abstractC0414hb = AbstractC0414hb.this;
            a2.b();
            throw null;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(c.a.a.a.b.h.adobe_loki_notification_menu, menu);
            AbstractC0414hb.this.K = menu.findItem(c.a.a.a.b.e.adobe_notification_bell);
            AbstractC0414hb abstractC0414hb = AbstractC0414hb.this;
            abstractC0414hb.H = abstractC0414hb.getLayoutInflater(null).inflate(c.a.a.a.b.g.adobe_notification_icon_view, (ViewGroup) null);
            AbstractC0414hb abstractC0414hb2 = AbstractC0414hb.this;
            abstractC0414hb2.I = (ImageView) abstractC0414hb2.H.findViewById(c.a.a.a.b.e.adobe_csdk_notification_icon);
            AbstractC0414hb abstractC0414hb3 = AbstractC0414hb.this;
            abstractC0414hb3.J = (TextView) abstractC0414hb3.H.findViewById(c.a.a.a.b.e.adobe_csdk_notification_count);
            if (AbstractC0414hb.this.f6104c.a() != null && AbstractC0414hb.this.f6104c.a().isPrivateCloud()) {
                AbstractC0414hb.this.K.setVisible(false);
                AbstractC0414hb.this.I.setImageResource(c.a.a.a.b.d.ic_notif_black_24dp_disabled);
                AbstractC0414hb.this.H.setEnabled(false);
                if (AbstractC0414hb.this.J != null) {
                    AbstractC0414hb.this.J.setVisibility(4);
                }
            }
            if (!AbstractC0414hb.this.ia()) {
                AbstractC0414hb.this.K.setVisible(false);
            }
            super.a(menu, menuInflater);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void c() {
            super.c();
            h();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(Menu menu) {
            super.a(menu);
            h();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public boolean a(int i) {
            if (i == c.a.a.a.b.e.adobe_csdk_asset_browser_adobe_notification) {
                AbstractC0414hb.this.a(AdobeAssetViewBrowserCommandName.ACTION_MENU_NOTIFICATION, (Object) null);
                return true;
            }
            return super.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(String str) {
        i(str);
    }

    protected boolean a(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Menu menu) {
        int size = menu.size();
        this.A = new boolean[size];
        for (int i = 0; i < size; i++) {
            MenuItem item = menu.getItem(i);
            this.A[i] = item.isVisible();
            item.setVisible(false);
        }
    }

    public void b(View view) {
        Ha();
        q();
    }

    private void a(c cVar) {
        cVar.f6121a = P() != null ? P().getCount() : -1;
        cVar.f6122b = Ga();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AdobeAssetViewBrowserCommandName adobeAssetViewBrowserCommandName, Object obj) {
        C0358a.a().a(adobeAssetViewBrowserCommandName, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t r7) {
        /*
            r6 = this;
            r6.Fa()
            com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t$c r0 = r7.c()
            int r1 = r0.a()
            r2 = 0
            r3 = 1
            if (r1 <= 0) goto L11
            r4 = 1
            goto L12
        L11:
            r4 = 0
        L12:
            boolean r5 = r0.c()
            if (r4 == 0) goto L51
            com.adobe.creativesdk.foundation.internal.storage.controllers.hb$d r0 = r6.r
            android.view.View r0 = r0.f6124a
            int r4 = c.a.a.a.b.b.adobe_csdk_assetview_common_error_banner_background
            r0.setBackgroundResource(r4)
            if (r1 != r3) goto L2e
            android.content.res.Resources r0 = r6.getResources()
            int r4 = c.a.a.a.b.i.adobe_csdk_IDS_UPLOAD_SINGLE_ERROR_MSG
            java.lang.String r0 = r0.getString(r4)
            goto L38
        L2e:
            android.content.res.Resources r0 = r6.getResources()
            int r4 = c.a.a.a.b.i.adobe_csdk_IDS_UPLOAD_ERROR_MSG
            java.lang.String r0 = r0.getString(r4)
        L38:
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.lang.String r1 = java.lang.Integer.toString(r1)
            r4[r2] = r1
            java.lang.String r0 = java.lang.String.format(r0, r4)
            com.adobe.creativesdk.foundation.internal.storage.controllers.hb$d r1 = r6.r
            android.view.View r1 = r1.f6124a
            com.adobe.creativesdk.foundation.internal.storage.controllers.eb r4 = new com.adobe.creativesdk.foundation.internal.storage.controllers.eb
            r4.<init>(r6, r7)
            r1.setOnClickListener(r4)
            goto L66
        L51:
            if (r5 == 0) goto L68
            com.adobe.creativesdk.foundation.internal.storage.controllers.hb$d r7 = r6.r
            android.view.View r7 = r7.f6124a
            int r0 = c.a.a.a.b.b.adobe_csdk_assetview_common_error_banner_background
            r7.setBackgroundResource(r0)
            android.content.res.Resources r7 = r6.getResources()
            int r0 = c.a.a.a.b.i.adobe_csdk_IDS_UPLOAD_STORAGE_FULL_MSG
            java.lang.String r0 = r7.getString(r0)
        L66:
            r7 = r0
            goto La3
        L68:
            com.adobe.creativesdk.foundation.internal.storage.controllers.hb$d r7 = r6.r
            android.view.View r7 = r7.f6124a
            int r1 = c.a.a.a.b.b.adobe_csdk_assetview_common_success_banner_background
            r7.setBackgroundResource(r1)
            int r7 = r0.b()
            if (r7 != r3) goto L82
            android.content.res.Resources r7 = r6.getResources()
            int r1 = c.a.a.a.b.i.adobe_csdk_IDS_UPLOAD_SINGLE_SUCCESS_MSG
            java.lang.String r7 = r7.getString(r1)
            goto L8c
        L82:
            android.content.res.Resources r7 = r6.getResources()
            int r1 = c.a.a.a.b.i.adobe_csdk_IDS_UPLOAD_SUCCESS_MSG
            java.lang.String r7 = r7.getString(r1)
        L8c:
            java.lang.Object[] r1 = new java.lang.Object[r3]
            int r4 = r0.b()
            java.lang.String r4 = java.lang.Integer.toString(r4)
            r1[r2] = r4
            java.lang.String r7 = java.lang.String.format(r7, r1)
            int r0 = r0.b()
            if (r0 != 0) goto La3
            r3 = 0
        La3:
            if (r3 == 0) goto Lc1
            com.adobe.creativesdk.foundation.internal.storage.controllers.hb$d r0 = r6.r
            android.widget.TextView r0 = r0.f6125b
            r0.setText(r7)
            com.adobe.creativesdk.foundation.internal.storage.controllers.hb$d r7 = r6.r
            android.view.View r7 = r7.f6124a
            r7.setVisibility(r2)
            android.os.Handler r7 = com.adobe.creativesdk.foundation.internal.utils.o.a()
            com.adobe.creativesdk.foundation.internal.storage.controllers.fb r0 = new com.adobe.creativesdk.foundation.internal.storage.controllers.fb
            r0.<init>(r6)
            r1 = 7000(0x1b58, double:3.4585E-320)
            r7.postDelayed(r0, r1)
        Lc1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.a(com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, com.adobe.creativesdk.foundation.internal.storage.model.util.b bVar, ArrayList<com.adobe.creativesdk.foundation.internal.storage.model.util.a> arrayList) {
        Ba();
        this.m = false;
        ga();
        if (i > 0) {
            ea();
            Pa();
            if (this.k) {
                if (this.j) {
                    this.f6105d.f();
                } else {
                    pa();
                }
            } else {
                pa();
            }
            this.j = true;
        } else if (P().getCount() == 0) {
            this.j = false;
            xa();
        }
        Da();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AdobeAssetException adobeAssetException) {
        F();
        if (adobeAssetException.getErrorCode() != AdobeAssetErrorCode.AdobeAssetErrorOffline && com.adobe.creativesdk.foundation.adobeinternal.net.a.b().b()) {
            if (adobeAssetException.getErrorCode() == AdobeAssetErrorCode.AdobeAssetErrorTimeout) {
                Ta();
                return;
            }
            return;
        }
        g(true);
    }
}
