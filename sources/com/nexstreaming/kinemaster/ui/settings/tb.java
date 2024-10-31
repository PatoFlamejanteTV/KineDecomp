package com.nexstreaming.kinemaster.ui.settings;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.crashlytics.android.Crashlytics;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.general.iab.PurchaseType;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.I;
import java.util.HashMap;

/* compiled from: SubscriptionFragment.java */
/* loaded from: classes2.dex */
public class tb extends Fragment implements I.a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f23200a = "com.nexstreaming.kinemaster.ui.settings.tb";

    /* renamed from: b, reason: collision with root package name */
    private static final int[][] f23201b = {new int[]{R.string.beta_go_to_google_play, 0, 0}, new int[]{R.string.sns_wechat, R.string.install, R.string.wx_download_url}, new int[]{R.string.xiaomi_store, R.string.install, R.string.mi_app_download_url}};

    /* renamed from: g, reason: collision with root package name */
    private PurchaseType f23206g;

    /* renamed from: c, reason: collision with root package name */
    private int f23202c = 0;

    /* renamed from: d, reason: collision with root package name */
    private String f23203d = null;

    /* renamed from: e, reason: collision with root package name */
    private String f23204e = null;

    /* renamed from: f, reason: collision with root package name */
    private int f23205f = R.string.no_thanks;

    /* renamed from: h, reason: collision with root package name */
    private com.nexstreaming.kinemaster.ui.a.t f23207h = null;
    private boolean i = false;
    private a j = null;
    private b k = null;
    private LinearLayout l = null;
    private View m = null;
    private View n = null;
    private View o = null;
    private TextView p = null;
    private TextView q = null;
    private TextView r = null;
    private View s = null;
    private View t = null;
    private View u = null;
    private View v = null;
    private View w = null;
    private View x = null;
    private View y = null;
    private TextView z = null;
    private Button A = null;
    private Button B = null;
    private TextView C = null;
    private TextView D = null;
    private TextView E = null;
    private Button F = null;
    private Button G = null;
    private TextView H = null;
    private TextView I = null;
    protected IABManager J = null;
    private boolean K = true;

    /* compiled from: SubscriptionFragment.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(String str);
    }

    /* compiled from: SubscriptionFragment.java */
    /* loaded from: classes2.dex */
    public interface b {
        void i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (getFragmentManager() == null || getFragmentManager().getBackStackEntryCount() <= 0) {
            return;
        }
        getFragmentManager().popBackStack();
    }

    private void m(int i) {
        if (i == 1) {
            this.s.setVisibility(0);
            this.t.setVisibility(0);
            this.u.setVisibility(0);
            this.v.setVisibility(0);
            this.w.setVisibility(0);
            this.x.setVisibility(0);
            this.y.setVisibility(0);
            this.A.setVisibility(0);
            this.B.setVisibility(0);
            this.C.setVisibility(0);
            this.E.setVisibility(0);
            this.q.setVisibility(0);
            this.z.setVisibility(8);
            this.F.setVisibility(8);
            this.G.setVisibility(8);
            this.H.setVisibility(8);
            this.I.setVisibility(8);
            return;
        }
        if (i == 2) {
            this.s.setVisibility(8);
            this.t.setVisibility(8);
            this.u.setVisibility(8);
            this.v.setVisibility(8);
            this.w.setVisibility(8);
            this.x.setVisibility(8);
            this.y.setVisibility(8);
            this.A.setVisibility(8);
            this.B.setVisibility(8);
            this.C.setVisibility(8);
            this.E.setVisibility(8);
            this.q.setVisibility(8);
            this.z.setVisibility(0);
            this.F.setVisibility(0);
            this.G.setVisibility(0);
            this.H.setVisibility(0);
            this.I.setVisibility(0);
            return;
        }
        this.s.setVisibility(8);
        this.t.setVisibility(8);
        this.u.setVisibility(8);
        this.v.setVisibility(8);
        this.w.setVisibility(8);
        this.x.setVisibility(8);
        this.y.setVisibility(8);
        this.A.setVisibility(8);
        this.B.setVisibility(8);
        this.C.setVisibility(8);
        this.E.setVisibility(8);
        this.q.setVisibility(8);
        this.z.setVisibility(8);
        this.F.setVisibility(8);
        this.G.setVisibility(8);
        this.H.setVisibility(8);
        this.I.setVisibility(8);
    }

    protected boolean A() {
        return this.f23206g != null;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        KMEvents.VIEW_SUBSCRIPTION.trackScreen(getActivity());
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() == null || !(getActivity() instanceof a)) {
            return;
        }
        this.j = (a) getActivity();
        this.k = (b) getActivity();
    }

    @Override // com.nextreaming.nexeditorui.I.a
    public boolean onBackPressed() {
        HashMap hashMap = new HashMap();
        hashMap.put("button", "Close");
        KMEvents.SUBSCRIPTION_CLICK_BUTTON.logEvent(hashMap);
        return false;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(tb.class.getName());
        HashMap hashMap = new HashMap();
        String str = this.f23204e;
        if (str != null) {
            hashMap.put("entering_point", str);
        } else {
            hashMap.put("entering_point", "unknown");
        }
        KMEvents.VIEW_SUBSCRIPTION.logEvent(hashMap);
        if (this.J == null) {
            e.a aVar = new e.a(getActivity());
            aVar.e(R.string.Network_server_not_responding);
            aVar.f(18);
            aVar.a(false);
            aVar.b(R.string.button_close, new kb(this));
            aVar.a().show();
        }
        View inflate = layoutInflater.inflate(R.layout.fragment_subscription, (ViewGroup) this.l, true);
        this.r = (TextView) inflate.findViewById(R.id.tv_subscribe_title);
        this.s = inflate.findViewById(R.id.info_view_watermark);
        this.t = inflate.findViewById(R.id.info_view_noads);
        this.u = inflate.findViewById(R.id.info_view_asset);
        this.v = inflate.findViewById(R.id.info_view_feature);
        this.w = inflate.findViewById(R.id.line1);
        this.x = inflate.findViewById(R.id.line2);
        this.y = inflate.findViewById(R.id.line3);
        this.z = (TextView) inflate.findViewById(R.id.tv_info_view_disconnect);
        this.p = (TextView) inflate.findViewById(R.id.tv_subscribe_skip);
        this.A = (Button) inflate.findViewById(R.id.btn_layout_subscribe_info_monthly);
        this.B = (Button) inflate.findViewById(R.id.btn_layout_subscribe_info_annually);
        this.C = (TextView) inflate.findViewById(R.id.tv_layout_subscribe_info_monthly);
        this.E = (TextView) inflate.findViewById(R.id.tv_layout_subscribe_info_annual);
        this.D = (TextView) inflate.findViewById(R.id.tv_layout_subscribe_info_freetrial);
        IABManager iABManager = this.J;
        if (iABManager != null && (iABManager.n() instanceof com.nexstreaming.app.general.iab.Presenter.B)) {
            this.D.setVisibility(8);
            this.E.setGravity(17);
        }
        this.F = (Button) inflate.findViewById(R.id.btn_layout_signin);
        this.G = (Button) inflate.findViewById(R.id.btn_layout_retry);
        this.H = (TextView) inflate.findViewById(R.id.tv_layout_signin);
        this.I = (TextView) inflate.findViewById(R.id.tv_layout_retry);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_subscribe_terms_of_service);
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        textView.setOnClickListener(new lb(this));
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_subscribe_privacy_policy);
        textView2.setPaintFlags(8 | textView2.getPaintFlags());
        textView2.setOnClickListener(new mb(this));
        this.q = (TextView) inflate.findViewById(R.id.tv_layout_subscribe_info_annual_save);
        IABManager iABManager2 = this.J;
        if (iABManager2 != null) {
            a(iABManager2, iABManager2.A());
        }
        inflate.setOnTouchListener(new nb(this));
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.i) {
            try {
                B();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
        }
    }

    public String z() {
        String str = this.f23203d;
        return str == null ? "SubscriptionFragment" : str;
    }

    public static tb a(IABManager iABManager, int i, String str, String str2) {
        return a(iABManager, i, str, str2, 0, null);
    }

    public void b(boolean z) {
        this.i = z;
    }

    public static tb a(IABManager iABManager, int i, String str, String str2, int i2) {
        return a(iABManager, i, str, str2, i2, null);
    }

    public static tb a(IABManager iABManager, int i, String str, String str2, int i2, PurchaseType purchaseType) {
        if (EditorGlobal.p) {
            Crashlytics.log("iab screen / ref=" + str);
        }
        tb tbVar = new tb();
        tbVar.setArguments(new Bundle());
        tbVar.J = iABManager;
        tbVar.f23202c = i;
        tbVar.f23203d = str;
        tbVar.f23204e = str2;
        if (i2 > 0) {
            tbVar.f23205f = i2;
        }
        tbVar.f23206g = purchaseType;
        return tbVar;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getActivity() == null || !(getActivity() instanceof a)) {
            return;
        }
        this.j = (a) getActivity();
        this.k = (b) getActivity();
    }

    protected void a(Button button, TextView textView, SKUDetails sKUDetails, boolean z, boolean z2) {
        IABManager iABManager;
        if (button == null || getActivity() == null) {
            return;
        }
        if (sKUDetails != null && (iABManager = this.J) != null && iABManager.u()) {
            sKUDetails.e();
            button.setOnClickListener(new ob(this, sKUDetails));
            textView.setText(getString(sKUDetails.f()) + "  " + sKUDetails.c());
            return;
        }
        button.setEnabled(false);
        textView.setTextColor(getResources().getColor(R.color.slate_grey));
        this.q.setTextColor(getResources().getColor(R.color.slate_grey));
        this.D.setTextColor(getResources().getColor(R.color.slate_grey));
    }

    protected void a(Button button, String str, String str2, String str3) {
        if (button != null) {
            if (EditorGlobal.p) {
                Crashlytics.log("setStoreInfo(" + String.valueOf(str) + ")");
            }
            if (str2 != null) {
                button.setText(str);
            } else {
                button.setVisibility(8);
            }
            button.setOnClickListener(new pb(this, str3));
        }
    }

    private void a(IABManager iABManager, PurchaseType purchaseType) {
        if (c.d.b.f.a.a(((com.nextreaming.nexeditorui.I) getActivity()).A())) {
            this.p.setVisibility(8);
            return;
        }
        if (iABManager == null || purchaseType == null || getActivity() == null) {
            return;
        }
        if (iABManager.u()) {
            if (iABManager.w()) {
                m(1);
                if (getActivity() != null && c.d.b.f.a.a(((com.nextreaming.nexeditorui.I) getActivity()).A())) {
                    this.p.setVisibility(8);
                } else {
                    this.p.setVisibility(0);
                }
                if (A()) {
                    a(this.A, this.C, iABManager.o(), false, false);
                    a(this.B, this.E, iABManager.s(), true, true);
                } else {
                    switch (jb.f23158a[purchaseType.ordinal()]) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            m(3);
                            this.p.setVisibility(8);
                            break;
                        default:
                            m(1);
                            this.p.setVisibility(0);
                            a(this.A, this.C, iABManager.o(), false, false);
                            a(this.B, this.E, iABManager.s(), true, true);
                            break;
                    }
                }
                this.q.setText(String.format(getResources().getString(R.string.save_percent), Integer.valueOf(a(iABManager))));
            } else {
                m(2);
                this.z.setText(iABManager.g());
                this.F.setOnClickListener(new qb(this, iABManager));
                this.H.setText(R.string.service_login_required);
                this.G.setOnClickListener(new rb(this, iABManager));
                this.I.setText(R.string.retry);
                if (c.d.b.m.e.f3850a.a()) {
                    this.z.setGravity(17);
                } else {
                    this.r.setText(R.string.iab_no_connection);
                }
            }
        } else {
            Log.i(f23200a, "has no any module");
            m(2);
            this.p.setVisibility(0);
            int[] iArr = f23201b[0];
            if (iArr != null) {
                a(this.A, iArr[0] > 0 ? getString(iArr[0]) : null, iArr[1] > 0 ? getString(iArr[1]) : null, iArr[2] > 0 ? getString(iArr[2]) : null);
            }
            int[] iArr2 = f23201b[1];
            if (iArr2 != null) {
                a(this.B, iArr2[0] > 0 ? getString(iArr2[0]) : null, iArr2[1] > 0 ? getString(iArr2[1]) : null, iArr2[2] > 0 ? getString(iArr2[2]) : null);
            }
        }
        a(this.p);
    }

    private int a(IABManager iABManager) {
        if (iABManager == null || iABManager.o() == null || iABManager.s() == null) {
            return 0;
        }
        return Math.round((1.0f - (((float) iABManager.s().d()) / (((float) iABManager.o().d()) * 12.0f))) * 100.0f);
    }

    protected void a(TextView textView) {
        if (this.f23205f == R.string.no_thanks) {
            textView.setText("");
            if (getContext() != null) {
                int a2 = a(22.0f, getContext());
                Drawable drawable = getContext().getResources().getDrawable(R.drawable.layout_ic_cancel);
                drawable.setBounds(0, 0, a2, a2);
                textView.setCompoundDrawables(drawable, null, null, null);
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.layout_ic_cancel, 0);
            }
        }
        textView.setOnClickListener(new sb(this));
    }

    public static int a(float f2, Context context) {
        return (int) (f2 * (context.getResources().getDisplayMetrics().densityDpi / 160.0f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SKUDetails sKUDetails) {
        FragmentActivity activity = getActivity();
        if (activity == null || !(activity instanceof com.nextreaming.nexeditorui.I)) {
            return;
        }
        ((com.nextreaming.nexeditorui.I) activity).a(sKUDetails, z());
    }
}
