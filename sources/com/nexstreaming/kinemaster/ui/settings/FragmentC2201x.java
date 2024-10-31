package com.nexstreaming.kinemaster.ui.settings;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.d.b.b.d;
import com.crashlytics.android.Crashlytics;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.general.iab.PurchaseType;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nextreaming.nexeditorui.EditorGlobal;

/* compiled from: AccountInfoV4Fragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.x, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class FragmentC2201x extends Fragment implements d.a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f23219a = "x";

    /* renamed from: b, reason: collision with root package name */
    private static final int[][] f23220b = {new int[]{R.string.beta_go_to_google_play, 0, 0}, new int[]{R.string.sns_wechat, R.string.install, R.string.wx_download_url}, new int[]{R.string.xiaomi_store, R.string.install, R.string.mi_app_download_url}};
    private TextView D;
    private TextView r;
    private Button s;
    private Button t;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f23221c = null;

    /* renamed from: d, reason: collision with root package name */
    private View f23222d = null;

    /* renamed from: e, reason: collision with root package name */
    private View f23223e = null;

    /* renamed from: f, reason: collision with root package name */
    private TextView f23224f = null;

    /* renamed from: g, reason: collision with root package name */
    private TextView f23225g = null;

    /* renamed from: h, reason: collision with root package name */
    private TextView f23226h = null;
    private TextView i = null;
    private TextView j = null;
    private TextView k = null;
    private ViewGroup l = null;
    private ViewGroup m = null;
    private View n = null;
    private TextView o = null;
    private Button p = null;
    private Button q = null;
    private View u = null;
    private TextView v = null;
    private View w = null;
    private View x = null;
    private View y = null;
    private View z = null;
    private View[] A = new View[3];
    private TextView[] B = new TextView[3];
    private TextView[] C = new TextView[3];
    boolean E = false;
    protected IABManager F = null;
    W G = null;

    private void i() {
        this.s.setOnClickListener(new ViewOnClickListenerC2186p(this));
        this.t.setOnClickListener(new ViewOnClickListenerC2188q(this));
        View view = this.y;
        if (view != null) {
            view.setOnClickListener(new ViewOnClickListenerC2191s(this));
        }
        c.d.b.b.i.b().a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        IABManager iABManager = this.F;
        if (iABManager != null) {
            ResultTask<Boolean> C = iABManager.C();
            if (C == null) {
                a(R.string.Restore_failed);
            } else {
                C.onResultAvailable(new C2176k(this));
            }
        }
    }

    protected String a() {
        return "accountInfo";
    }

    protected boolean b() {
        return false;
    }

    protected View c(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.layout_base_account_info_top_v4, (ViewGroup) null, false);
        this.f23224f = (TextView) inflate.findViewById(R.id.paid_details);
        this.f23225g = (TextView) inflate.findViewById(R.id.tv_account_info);
        this.f23226h = (TextView) inflate.findViewById(R.id.account_type);
        this.i = (TextView) inflate.findViewById(R.id.tv_account_sub_info);
        return inflate;
    }

    protected boolean c() {
        return false;
    }

    protected boolean d() {
        return false;
    }

    protected boolean e() {
        return false;
    }

    public boolean f() {
        IABManager iABManager = this.F;
        return iABManager != null && (iABManager.n() instanceof com.nexstreaming.app.general.iab.Presenter.B);
    }

    protected boolean g() {
        return false;
    }

    public void h() {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new RunnableC2174j(this));
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        KMEvents.VIEW_MY_ACCOUNT.trackScreen(getActivity());
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.F == null) {
            getFragmentManager().popBackStackImmediate();
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return a(layoutInflater);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        c.d.b.b.i.b().b(this);
        super.onDestroyView();
    }

    protected View b(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.layout_base_account_info_bottom_v4, (ViewGroup) null);
        this.l = (ViewGroup) inflate.findViewById(R.id.layout_account_info_product_views);
        this.m = (ViewGroup) inflate.findViewById(R.id.product_30day_pass_holder);
        this.u = inflate.findViewById(R.id.promotion_button);
        this.v = (TextView) inflate.findViewById(R.id.promotion_tv);
        this.w = inflate.findViewById(R.id.license_button);
        if (!f()) {
            this.m.setVisibility(8);
            this.u.setVisibility(8);
            this.v.setVisibility(8);
            this.w.setVisibility(8);
        }
        this.n = inflate.findViewById(R.id.wx_account_container);
        this.o = (TextView) inflate.findViewById(R.id.tv_account_info_error_message);
        this.j = (TextView) inflate.findViewById(R.id.tv_account_info_user_id);
        this.p = (Button) inflate.findViewById(R.id.btn_layout_account_info_signin);
        inflate.findViewById(R.id.km_account_container).setVisibility(c.d.b.m.e.f3850a.a() ? 8 : 0);
        this.p.setOnClickListener(new ViewOnClickListenerC2182n(this));
        this.q = (Button) inflate.findViewById(R.id.btn_account_reset);
        this.q.setOnClickListener(new ViewOnClickListenerC2184o(this));
        this.r = (TextView) inflate.findViewById(R.id.km_account_info);
        this.s = (Button) inflate.findViewById(R.id.km_account_signin);
        this.t = (Button) inflate.findViewById(R.id.km_account_signout);
        this.x = inflate.findViewById(R.id.restore_holder);
        this.y = inflate.findViewById(R.id.restore_button);
        this.A[0] = inflate.findViewById(R.id.product_monthly);
        this.A[1] = inflate.findViewById(R.id.product_annual);
        this.B[0] = (TextView) inflate.findViewById(R.id.monthly_tv);
        this.B[1] = (TextView) inflate.findViewById(R.id.annual_tv);
        this.D = (TextView) inflate.findViewById(R.id.annual_subtitle_tv);
        this.D.setVisibility(8);
        this.C[0] = (TextView) inflate.findViewById(R.id.monthly_price_tv);
        this.C[1] = (TextView) inflate.findViewById(R.id.annual_price_tv);
        this.A[2] = inflate.findViewById(R.id.product_30day_pass);
        this.B[2] = (TextView) inflate.findViewById(R.id.purchase_30days_tv);
        this.C[2] = (TextView) inflate.findViewById(R.id.purchase_30days_price_tv);
        if (!f()) {
            this.A[2].setVisibility(8);
            this.B[2].setVisibility(8);
            this.C[2].setVisibility(8);
            this.D.setVisibility(0);
        }
        return inflate;
    }

    public static FragmentC2201x a(IABManager iABManager) {
        FragmentC2201x fragmentC2201x = new FragmentC2201x();
        fragmentC2201x.setArguments(new Bundle());
        fragmentC2201x.F = iABManager;
        return fragmentC2201x;
    }

    protected View a(LayoutInflater layoutInflater) {
        IABManager iABManager = this.F;
        View view = null;
        if (iABManager != null && iABManager.A() != null) {
            view = layoutInflater.inflate(R.layout.fragment_account_info_v4, (ViewGroup) null, false);
            this.f23221c = (LinearLayout) view.findViewById(R.id.layout_account_info_container);
            if (g()) {
                this.f23221c.setGravity(17);
            }
            this.f23222d = c(layoutInflater);
            View view2 = this.f23222d;
            if (view2 != null) {
                this.f23221c.addView(view2);
            }
            this.f23223e = b(layoutInflater);
            View view3 = this.f23223e;
            if (view3 != null) {
                this.f23221c.addView(view3);
            }
            IABManager iABManager2 = this.F;
            b(iABManager2, iABManager2.A());
            IABManager iABManager3 = this.F;
            a(iABManager3, iABManager3.A());
            i();
        }
        return view;
    }

    private boolean a(PurchaseType purchaseType) {
        if (getActivity() != null && c.d.b.f.a.a(((com.nextreaming.nexeditorui.I) getActivity()).A())) {
            return true;
        }
        if (purchaseType == null) {
            return false;
        }
        switch (C2180m.f23165a[purchaseType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    @Override // c.d.b.b.d.a
    public void a(c.d.b.b.d dVar, c.d.b.b.a.e eVar) {
        if (eVar != null) {
            this.r.setText(eVar.getEmail());
            this.s.setVisibility(8);
            this.t.setVisibility(0);
            com.nexstreaming.kinemaster.ui.gdpr.l.a(getActivity());
        } else {
            this.r.setText(R.string.aboutmyaccount_none);
            this.s.setVisibility(0);
            this.t.setVisibility(8);
        }
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IABManager iABManager, PurchaseType purchaseType) {
        int[] iArr;
        if (c.d.b.f.a.a(((com.nextreaming.nexeditorui.I) getActivity()).A())) {
            this.l.setVisibility(8);
            if (f()) {
                this.m.setVisibility(8);
                this.u.setVisibility(8);
                this.w.setVisibility(8);
            }
            this.n.setVisibility(8);
            return;
        }
        if (iABManager == null || purchaseType == null || getActivity() == null) {
            return;
        }
        boolean u = iABManager.u();
        if (b() && u) {
            this.A[0].setVisibility(8);
        }
        if (c() && u) {
            this.A[1].setVisibility(8);
        }
        if (f() && d() && u) {
            this.A[2].setVisibility(8);
        }
        if (u) {
            if (!c.d.b.m.e.f3850a.a()) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
            }
            if (iABManager.w()) {
                if (c.d.b.m.e.f3850a.a()) {
                    this.o.setVisibility(8);
                    this.p.setVisibility(8);
                    this.q.setVisibility(0);
                }
                this.l.setVisibility(0);
                if (f()) {
                    this.m.setVisibility(0);
                    if (getActivity() != null && c.d.b.f.a.a(((com.nextreaming.nexeditorui.I) getActivity()).A())) {
                        this.u.setVisibility(8);
                        this.w.setVisibility(8);
                    } else {
                        this.u.setVisibility(0);
                        this.w.setVisibility(0);
                    }
                }
                if (e()) {
                    a(this.A[0], iABManager.o(), 0);
                    a(this.A[1], iABManager.s(), 1);
                    if (f()) {
                        a(this.A[2], iABManager.k(), 2);
                    }
                } else {
                    int i = C2180m.f23165a[purchaseType.ordinal()];
                    if (i != 10) {
                        switch (i) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                break;
                            default:
                                a(this.A[0], iABManager.o(), 0);
                                a(this.A[1], iABManager.s(), 1);
                                if (f()) {
                                    this.u.setVisibility(0);
                                    this.w.setVisibility(0);
                                    a(this.A[2], iABManager.k(), 2);
                                    break;
                                }
                                break;
                        }
                    }
                    this.l.setVisibility(8);
                    if (f()) {
                        this.m.setVisibility(8);
                        this.u.setVisibility(8);
                        this.w.setVisibility(8);
                    }
                }
            } else {
                this.l.setVisibility(8);
                if (f()) {
                    this.m.setVisibility(8);
                }
                this.n.setVisibility(0);
                this.o.setText(iABManager.g());
                this.o.setVisibility(0);
                this.p.setVisibility(0);
                this.q.setVisibility(8);
                this.x.setVisibility(8);
                if (!c.d.b.m.e.f3850a.a()) {
                    this.p.setText(R.string.check_account);
                }
            }
        } else {
            Log.i(f23219a, "has no any module");
            this.l.setVisibility(0);
            if (f()) {
                this.m.setVisibility(0);
                this.u.setVisibility(0);
                this.w.setVisibility(0);
            }
            this.n.setVisibility(8);
            int i2 = 0;
            while (true) {
                View[] viewArr = this.A;
                if (i2 >= viewArr.length) {
                    break;
                }
                int[][] iArr2 = f23220b;
                if (i2 < iArr2.length && (iArr = iArr2[i2]) != null) {
                    a(viewArr[i2], iArr[0] > 0 ? getString(iArr[0]) : null, iArr[1] > 0 ? getString(iArr[1]) : null, iArr[2] > 0 ? getString(iArr[2]) : null, i2);
                }
                i2++;
            }
        }
        if (f()) {
            a(this.u, this.v);
            a(this.w);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(IABManager iABManager, PurchaseType purchaseType) {
        char c2;
        int i = 8;
        if (c.d.b.f.a.a(((com.nextreaming.nexeditorui.I) getActivity()).A())) {
            this.f23226h.setText(R.string.sub_account_type_lg_anna);
            this.f23224f.setText("");
            this.i.setVisibility(8);
            return;
        }
        this.i.setVisibility(0);
        if (iABManager == null || purchaseType == null) {
            return;
        }
        this.i.setOnClickListener(new ViewOnClickListenerC2193t(this, iABManager));
        if (iABManager.u() && (a(purchaseType) || iABManager.w())) {
            switch (C2180m.f23165a[purchaseType.ordinal()]) {
                case 1:
                    this.f23226h.setText(R.string.sub_monthly);
                    this.f23224f.setText("");
                    this.i.setVisibility(0);
                    c2 = '\b';
                    break;
                case 2:
                    this.f23226h.setText(R.string.sub_annual);
                    this.f23224f.setText("");
                    this.i.setVisibility(0);
                    c2 = '\b';
                    break;
                case 3:
                    this.f23226h.setText(R.string.sub_account_type_paid);
                    this.f23224f.setText("");
                    this.i.setVisibility(8);
                    c2 = '\b';
                    break;
                case 4:
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                    String string = defaultSharedPreferences.getString("apc_account_type", "Promotional");
                    String string2 = defaultSharedPreferences.getString("apc_account_name", null);
                    if (string.equals("Team") && string2 != null) {
                        this.f23226h.setText(R.string.sub_team);
                    } else if (string.equals("Standard") && string2 != null) {
                        this.f23226h.setText(R.string.sub_standard);
                    } else {
                        this.f23226h.setText(R.string.sub_account_type_promocode);
                    }
                    this.f23224f.setText("");
                    this.i.setVisibility(8);
                    c2 = '\b';
                    break;
                case 5:
                    this.f23226h.setText("");
                    int m = iABManager.m();
                    this.f23224f.setText(getResources().getQuantityString(R.plurals.sub_days_remaining, m, Integer.valueOf(m)));
                    this.i.setVisibility(8);
                    c2 = '\b';
                    break;
                case 6:
                    this.f23226h.setText(R.string.sub_team);
                    this.i.setVisibility(8);
                    this.f23224f.setText("");
                    c2 = '\b';
                    break;
                case 7:
                    this.f23226h.setText(R.string.sub_standard);
                    this.i.setVisibility(8);
                    this.f23224f.setText("");
                    c2 = '\b';
                    break;
                default:
                    this.f23226h.setText(R.string.sub_account_type_free);
                    this.f23224f.setText("");
                    this.i.setVisibility(8);
                    c2 = 0;
                    break;
            }
            String b2 = iABManager.n().b();
            if (!TextUtils.isEmpty(b2)) {
                this.j.setVisibility(0);
                this.j.setText("ID: " + b2);
                if (c2 == 0) {
                    i = 0;
                }
            } else {
                this.j.setVisibility(8);
            }
        } else {
            this.f23226h.setText(R.string.iab_unknown);
            this.f23224f.setText(R.string.iab_connection_fail);
            this.q.setVisibility(8);
            this.j.setVisibility(8);
            this.i.setVisibility(8);
        }
        this.x.setVisibility(i);
    }

    protected void a(View view, String str, String str2, String str3, int i) {
        if (view != null) {
            if (EditorGlobal.p) {
                Crashlytics.log("setStoreInfo(" + String.valueOf(str) + ")");
            }
            if (str2 != null) {
                this.C[i].setText(str2);
            } else {
                this.C[i].setVisibility(8);
            }
            view.setOnClickListener(new ViewOnClickListenerC2195u(this, str3));
        }
    }

    @SuppressLint({"StringFormatInvalid"})
    protected void a(View view, SKUDetails sKUDetails, int i) {
        if (view == null || getActivity() == null) {
            return;
        }
        if (sKUDetails != null) {
            view.setVisibility(0);
            if (i == 1 && !(this.F.n() instanceof com.nexstreaming.app.general.iab.Presenter.B)) {
                this.B[i].setText(R.string.Free_Trial_sub_use_monthly);
                this.D.setText(String.format(getResources().getString(R.string.Free_Trial_sub_use_Yearly_sub_title), sKUDetails.c()));
            } else {
                this.B[i].setText(sKUDetails.i() >= 0 ? getString(sKUDetails.i()) : sKUDetails.j());
            }
            view.setOnClickListener(new ViewOnClickListenerC2197v(this, sKUDetails));
            if (i != 1 || (this.F.n() instanceof com.nexstreaming.app.general.iab.Presenter.B)) {
                this.C[i].setText(sKUDetails.c());
                return;
            }
            return;
        }
        view.setVisibility(8);
    }

    protected void a(View view, TextView textView) {
        if (view == null || textView == null) {
            return;
        }
        view.setOnClickListener(new ViewOnClickListenerC2199w(this));
    }

    protected void a(View view) {
        if (view != null) {
            view.setOnClickListener(new ViewOnClickListenerC2172i(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SKUDetails sKUDetails) {
        Activity activity = getActivity();
        if (activity == null || !(activity instanceof com.nextreaming.nexeditorui.I)) {
            return;
        }
        ((com.nextreaming.nexeditorui.I) activity).a(sKUDetails, a());
    }

    private void a(int i) {
        a(i, (DialogInterface.OnClickListener) null);
    }

    private void a(int i, DialogInterface.OnClickListener onClickListener) {
        e.a aVar = new e.a(getActivity());
        aVar.c(i);
        if (onClickListener == null) {
            onClickListener = new DialogInterfaceOnClickListenerC2178l(this);
        }
        aVar.c(R.string.button_ok, onClickListener);
        aVar.a().show();
    }
}
