package com.nexstreaming.kinemaster.ui.settings;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nexstreaming.app.general.iab.PurchaseType;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.ProductView;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.ba;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AccountInfoFragment.java */
/* loaded from: classes.dex */
public class a extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4229a = a.class.getName();
    private static final int[][] c = {new int[]{R.string.beta_go_to_google_play, 0, 0}, new int[]{R.string.sns_wechat, R.string.install, R.string.wx_download_url}, new int[]{R.string.xiaomi_store, R.string.install, R.string.mi_app_download_url}};
    private LinearLayout d = null;
    private View e = null;
    private View f = null;
    private View g = null;
    private TextView h = null;
    private TextView i = null;
    private TextView j = null;
    private TextView k = null;
    private TextView l = null;
    private TextView m = null;
    private TextView n = null;
    private TextView o = null;
    private ViewGroup p = null;
    private View q = null;
    private TextView r = null;
    private Button s = null;
    private Button t = null;
    private ProductView[] u = new ProductView[3];
    private View v = null;
    private TextView w = null;
    protected com.nextreaming.nexeditorui.af b = null;

    public static a a(com.nextreaming.nexeditorui.af afVar) {
        a aVar = new a();
        aVar.setArguments(new Bundle());
        aVar.b = afVar;
        return aVar;
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.b == null) {
            getFragmentManager().popBackStackImmediate();
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f();
        return a(layoutInflater);
    }

    protected String a() {
        return "Account Info";
    }

    protected boolean b() {
        return false;
    }

    private void f() {
        if (this.b != null) {
            try {
                KMUsage.getMixpanelInstance(getActivity()).a("Purchase Dialog", new JSONObject().put("Origination", a()).put("Extend Options", this.b.q()));
            } catch (JSONException e) {
                Log.e(f4229a, "Mixpanel json err", e);
            }
        }
    }

    protected View a(LayoutInflater layoutInflater) {
        if (this.b == null || this.b.m() == null) {
            return null;
        }
        View inflate = layoutInflater.inflate(R.layout.fragment_account_info, (ViewGroup) null, false);
        this.d = (LinearLayout) inflate.findViewById(R.id.layout_account_info_container);
        if (b()) {
            this.d.setGravity(17);
        }
        this.e = a(layoutInflater, this.b, this.b.m());
        if (this.e != null) {
            this.d.addView(this.e);
        }
        this.f = b(layoutInflater, this.b, this.b.m());
        if (this.f != null) {
            this.d.addView(this.f);
        }
        this.g = c(layoutInflater, this.b, this.b.m());
        if (this.g != null) {
            this.d.addView(this.g);
        }
        return inflate;
    }

    protected View a(LayoutInflater layoutInflater, com.nextreaming.nexeditorui.af afVar, PurchaseType purchaseType) {
        View inflate = layoutInflater.inflate(R.layout.layout_base_account_info_top, (ViewGroup) null, false);
        this.h = (TextView) inflate.findViewById(R.id.paid_details);
        this.i = (TextView) inflate.findViewById(R.id.tv_account_info);
        this.j = (TextView) inflate.findViewById(R.id.account_type);
        this.k = (TextView) inflate.findViewById(R.id.tv_account_sub_info);
        this.m = (TextView) inflate.findViewById(R.id.tv_account_reset);
        this.l = (TextView) inflate.findViewById(R.id.sub_paidacct_detail_text);
        this.n = (TextView) inflate.findViewById(R.id.tv_account_info_user_id);
        a(afVar, purchaseType);
        return inflate;
    }

    protected View b(LayoutInflater layoutInflater, com.nextreaming.nexeditorui.af afVar, PurchaseType purchaseType) {
        View inflate = layoutInflater.inflate(R.layout.layout_base_account_info_middle, (ViewGroup) null);
        this.o = (TextView) inflate.findViewById(R.id.tv_account_specal_price);
        b(afVar, purchaseType);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View c(LayoutInflater layoutInflater, com.nextreaming.nexeditorui.af afVar, PurchaseType purchaseType) {
        View inflate = layoutInflater.inflate(R.layout.layout_base_account_info_bottom, (ViewGroup) null);
        this.p = (ViewGroup) inflate.findViewById(R.id.layout_account_info_product_views);
        this.u[0] = (ProductView) inflate.findViewById(R.id.product_view_first);
        this.u[1] = (ProductView) inflate.findViewById(R.id.product_view_second);
        this.u[2] = (ProductView) inflate.findViewById(R.id.product_view_third);
        this.v = inflate.findViewById(R.id.button_sub_promo);
        this.w = (TextView) inflate.findViewById(R.id.tv_account_info_promo);
        this.q = inflate.findViewById(R.id.layout_account_info_error);
        this.r = (TextView) inflate.findViewById(R.id.tv_account_info_error_message);
        this.s = (Button) inflate.findViewById(R.id.btn_layout_account_info_signin);
        this.t = (Button) inflate.findViewById(R.id.btn_layout_account_info_retry);
        c(afVar, purchaseType);
        return inflate;
    }

    private boolean a(PurchaseType purchaseType) {
        if (purchaseType == null) {
            return false;
        }
        switch (purchaseType) {
            case SubMonthly:
            case SubAnnual:
            case SubUnknown:
            case Promocode:
            case OneTimeValid:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.nextreaming.nexeditorui.af afVar, PurchaseType purchaseType) {
        if (afVar != null && purchaseType != null) {
            this.k.setOnClickListener(new b(this));
            if (afVar.E() && (a(purchaseType) || afVar.D())) {
                switch (purchaseType) {
                    case SubMonthly:
                    case SubAnnual:
                    case SubUnknown:
                    case Promocode:
                    case OneTimeValid:
                        this.j.setText(R.string.sub_account_type_paid);
                        this.l.setText(R.string.sub_paidacct_detail_vlayer_new);
                        this.m.setVisibility(8);
                        break;
                    default:
                        this.j.setText(R.string.sub_account_type_free);
                        this.h.setText("");
                        this.l.setText("");
                        this.m.setVisibility(!afVar.B() ? 0 : 8);
                        this.m.setOnClickListener(new c(this, afVar));
                        break;
                }
                switch (purchaseType) {
                    case SubMonthly:
                        this.j.setText(R.string.sub_account_type_paid);
                        this.h.setText(R.string.sub_paid_charged_monthly);
                        this.k.setVisibility(0);
                        break;
                    case SubAnnual:
                        this.j.setText(R.string.sub_account_type_paid);
                        this.h.setText(R.string.sub_paid_charged_annually);
                        this.k.setVisibility(0);
                        break;
                    case SubUnknown:
                        this.j.setText(R.string.sub_account_type_paid);
                        this.h.setText("");
                        this.k.setVisibility(8);
                        break;
                    case Promocode:
                        this.j.setText(R.string.sub_account_type_promocode);
                        this.h.setText("");
                        this.k.setVisibility(8);
                        break;
                    case OneTimeValid:
                        this.j.setText(R.string.sub_account_type_paid);
                        int n = afVar.n();
                        this.h.setText(getResources().getQuantityString(R.plurals.sub_days_remaining, n, Integer.valueOf(n)));
                        this.k.setVisibility(8);
                        break;
                    default:
                        this.j.setText(R.string.sub_account_type_free);
                        this.h.setText(R.string.sub_acount_type_free_explain);
                        this.l.setText("");
                        this.k.setVisibility(8);
                        break;
                }
                String t = afVar.d().t();
                if (!TextUtils.isEmpty(t)) {
                    this.n.setVisibility(0);
                    this.n.setText("ID: " + t);
                    return;
                } else {
                    this.n.setVisibility(8);
                    return;
                }
            }
            this.j.setText(R.string.iab_unknown);
            this.h.setText(R.string.iab_connection_fail);
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.l.setText("");
            this.k.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.nextreaming.nexeditorui.af afVar, PurchaseType purchaseType) {
        if (afVar != null && purchaseType != null && this.o != null) {
            if (afVar.q() && afVar.D()) {
                this.o.setText(String.format(getString(R.string.sub_special_price_info), new SimpleDateFormat("dd.MM.yyyy").format(new Date(afVar.w().c().getTime() + (86400000 * afVar.o())))));
                this.o.setVisibility(0);
                return;
            }
            this.o.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.nextreaming.nexeditorui.af afVar, PurchaseType purchaseType) {
        int[] iArr;
        if (afVar != null && purchaseType != null && getActivity() != null) {
            boolean E = afVar.E();
            if (!com.nexstreaming.kinemaster.tracelog.e.a() && E) {
                this.u[0].setVisibility(8);
                ((LinearLayout.LayoutParams) this.u[1].getLayoutParams()).weight = 0.0f;
                ((LinearLayout.LayoutParams) this.u[2].getLayoutParams()).weight = 0.0f;
                this.u[1].getLayoutParams().width = (int) getResources().getDimension(R.dimen.product_view_normal_width);
                this.u[2].getLayoutParams().width = (int) getResources().getDimension(R.dimen.product_view_normal_width);
            }
            if (!com.nexstreaming.kinemaster.tracelog.e.b() && E) {
                this.u[1].setVisibility(8);
                ((LinearLayout.LayoutParams) this.u[0].getLayoutParams()).weight = 0.0f;
                ((LinearLayout.LayoutParams) this.u[2].getLayoutParams()).weight = 0.0f;
                this.u[0].getLayoutParams().width = (int) getResources().getDimension(R.dimen.product_view_normal_width);
                this.u[2].getLayoutParams().width = (int) getResources().getDimension(R.dimen.product_view_normal_width);
            }
            if (!com.nexstreaming.kinemaster.tracelog.e.c() && E) {
                this.u[2].setVisibility(8);
                ((LinearLayout.LayoutParams) this.u[0].getLayoutParams()).weight = 0.0f;
                ((LinearLayout.LayoutParams) this.u[1].getLayoutParams()).weight = 0.0f;
                this.u[0].getLayoutParams().width = (int) getResources().getDimension(R.dimen.product_view_normal_width);
                this.u[1].getLayoutParams().width = (int) getResources().getDimension(R.dimen.product_view_normal_width);
            }
            if (E) {
                if (a(purchaseType) || afVar.D()) {
                    Log.d(f4229a, "initBottomViews() connected");
                    this.p.setVisibility(0);
                    this.v.setVisibility(0);
                    this.q.setVisibility(8);
                    if (afVar.q()) {
                        Log.d(f4229a, "initBottomViews() called with: show Special");
                        a(this.u[0], afVar.k(), false, false);
                        a(this.u[1], afVar.l(), true, false);
                        a(this.u[2], afVar.j(), false, false);
                        this.v.setVisibility(8);
                    } else {
                        switch (purchaseType) {
                            case SubMonthly:
                            case SubAnnual:
                            case SubUnknown:
                            case Promocode:
                            case OneTimeValid:
                                this.p.setVisibility(8);
                                this.v.setVisibility(8);
                                break;
                            default:
                                Log.d(f4229a, "initBottomViews() called with: layout.isShown=[" + this.p.isShown() + "]");
                                a(this.u[0], afVar.h(), false, false);
                                a(this.u[1], afVar.i(), true, true);
                                a(this.u[2], afVar.g(), false, false);
                                break;
                        }
                    }
                } else {
                    Log.d(f4229a, "initBottomViews() disconnected");
                    this.p.setVisibility(8);
                    this.q.setVisibility(0);
                    this.r.setText(afVar.A());
                    this.s.setOnClickListener(new d(this, afVar));
                    this.t.setOnClickListener(new e(this, afVar));
                    if (afVar.B()) {
                        this.s.setText(R.string.check_account);
                    }
                }
            } else {
                Log.d(f4229a, "initBottomViews() has no any module");
                this.p.setVisibility(0);
                this.v.setVisibility(0);
                this.q.setVisibility(8);
                for (int i = 0; i < this.u.length; i++) {
                    if (i < c.length && (iArr = c[i]) != null) {
                        a(this.u[i], iArr[0] > 0 ? getString(iArr[0]) : null, iArr[1] > 0 ? getString(iArr[1]) : null, iArr[2] > 0 ? getString(iArr[2]) : null);
                    }
                }
            }
            a(this.v, this.w);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ProductView productView, String str, String str2, String str3) {
        if (productView != null) {
            productView.setPrice(str);
            productView.setBest(false);
            productView.setBigSIze(false);
            if (str2 != null) {
                productView.getBuyButton().setText(str2);
            } else {
                productView.getBuyButton().setVisibility(8);
            }
            productView.setOnClickListener(new f(this, str3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ProductView productView, SKUDetails sKUDetails, boolean z, boolean z2) {
        if (productView != null) {
            if (sKUDetails != null) {
                productView.setVisibility(0);
                productView.setTitle(sKUDetails.h() >= 0 ? getString(sKUDetails.h()) : sKUDetails.d());
                productView.setPrice(sKUDetails.c());
                productView.setBest(z);
                productView.setBigSIze(z2);
                productView.setBuyButtonText(sKUDetails.i());
                productView.setOnClickListener(new g(this, sKUDetails));
                if (this.b.d().f(sKUDetails)) {
                    productView.setDiscountPercent(this.b.J());
                    return;
                }
                return;
            }
            productView.setVisibility(8);
        }
    }

    protected void a(View view, TextView textView) {
        if (view != null && textView != null) {
            view.setOnClickListener(new h(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SKUDetails sKUDetails) {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ba)) {
            ((ba) activity).a(sKUDetails, e());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ba)) {
            ((ba) getActivity()).H();
        }
    }

    public void d() {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new i(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String e() {
        return "accountInfo";
    }
}
