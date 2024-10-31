package com.nexstreaming.kinemaster.ui.store.controller;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import c.d.a.a.d.a.d;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.general.iab.Presenter.IABBasePresent;
import com.nexstreaming.app.general.iab.PurchaseType;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nexstreaming.kinemaster.ui.settings.tb;
import com.nexstreaming.kinemaster.usage.AssetDownloadResult;
import com.nexstreaming.kinemaster.usage.AssetStoreEntry;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: AssetDetailFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.store.controller.ya, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2290ya extends Fragment implements d.c, com.nexstreaming.kinemaster.usage.f {
    private Context A;
    private com.nexstreaming.kinemaster.ui.a.t C;

    /* renamed from: a, reason: collision with root package name */
    private NestedScrollView f23632a;

    /* renamed from: b, reason: collision with root package name */
    private LinearLayout f23633b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f23634c;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f23635d;

    /* renamed from: e, reason: collision with root package name */
    private View f23636e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f23637f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f23638g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f23639h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private ProgressBar q;
    private RecyclerView r;
    private Ha s;
    private int t;
    private String u;
    private c.d.a.a.d.a.d v;
    private InterfaceC1821j w;
    private boolean x;
    private boolean y;
    private final int z = 1;
    private String B = null;
    boolean D = false;
    private ResultTask.OnResultAvailableListener<com.nexstreaming.app.general.service.download.k> E = new C2282ua(this);
    private Task.OnFailListener F = new C2284va(this);
    private Task.OnProgressListener G = new C2286wa(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void A() {
        if (this.y) {
            return;
        }
        int height = this.f23632a.getHeight();
        this.f23633b.getLayoutParams().height = height;
        this.f23633b.setMinimumHeight(this.f23632a.getHeight());
        ViewGroup.LayoutParams layoutParams = this.f23634c.getLayoutParams();
        double d2 = height;
        Double.isNaN(d2);
        layoutParams.height = (int) Math.round(0.6d * d2);
        ViewGroup.LayoutParams layoutParams2 = this.f23635d.getLayoutParams();
        Double.isNaN(d2);
        layoutParams2.height = (int) Math.round(d2 * 0.4d);
        int width = (this.f23634c.getWidth() - (this.f23634c.getPaddingLeft() + this.f23634c.getPaddingRight())) / 2;
        int height2 = this.f23634c.getHeight() - (this.f23634c.getPaddingTop() + this.f23634c.getPaddingBottom());
        int i = (int) (height2 * 1.7777778f);
        if (i < width) {
            width = i;
        } else {
            height2 = (int) (width * 0.5625f);
        }
        this.f23637f.getLayoutParams().width = width;
        this.f23637f.getLayoutParams().height = height2;
        this.f23637f.requestLayout();
        this.f23636e.getLayoutParams().width = width;
        this.f23636e.getLayoutParams().height = height2;
        this.f23636e.requestLayout();
        this.f23634c.requestLayout();
        this.f23635d.requestLayout();
    }

    private void E() {
        IABBasePresent n;
        IABManager I = I();
        if (I != null) {
            int i = C2288xa.f23630a[I.i().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3 && (n = I.n()) != null && (n instanceof com.nexstreaming.app.general.iab.Presenter.B)) {
                        com.nexstreaming.app.general.iab.Presenter.B b2 = (com.nexstreaming.app.general.iab.Presenter.B) n;
                        if (b2.D()) {
                            if (b2.s()) {
                                a(IABConstant.SKUType.wechat);
                                return;
                            } else {
                                I.F();
                                return;
                            }
                        }
                        b2.a(getActivity());
                        return;
                    }
                    return;
                }
                a(IABConstant.SKUType.inapp);
            }
        }
    }

    private void F() {
        if (this.y) {
            return;
        }
        this.y = true;
        if (this.w != null) {
            this.k.setText(G());
            this.f23634c.getLayoutParams().height = -2;
            this.f23633b.getLayoutParams().height = -2;
            this.f23633b.setMinimumHeight(this.f23632a.getHeight());
            this.f23634c.requestLayout();
        }
    }

    private String G() {
        return com.nexstreaming.app.general.util.J.a(getActivity(), this.w.m(), this.w.q());
    }

    private com.nexstreaming.app.general.service.download.i H() {
        if (getActivity() == null || !(getActivity() instanceof com.nextreaming.nexeditorui.I)) {
            return null;
        }
        return ((com.nextreaming.nexeditorui.I) getActivity()).w();
    }

    private IABManager I() {
        if (getActivity() == null || !(getActivity() instanceof com.nextreaming.nexeditorui.I)) {
            return null;
        }
        return ((com.nextreaming.nexeditorui.I) getActivity()).y();
    }

    private boolean J() {
        return NexEditorDeviceProfile.getDeviceProfile().getMaxImportHeight(EditorGlobal.i().b(), true) >= 720 && !(TextUtils.isEmpty(this.w.u()) && TextUtils.isEmpty(this.w.d()));
    }

    private void K() {
        this.o.setEnabled(false);
        this.o.setVisibility(4);
        this.q.setVisibility(0);
        this.n.setVisibility(4);
        b(this.w);
    }

    public /* synthetic */ void B() {
        getFragmentManager().popBackStackImmediate();
    }

    public /* synthetic */ void C() {
        if (getActivity() != null) {
            if (this.k.getLineCount() * this.k.getLineHeight() > this.k.getHeight()) {
                int length = this.k.getText().length() / this.k.getLineCount();
                String string = getString(R.string.read_more);
                String str = ((Object) this.k.getText().subSequence(0, length)) + string;
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(new StyleSpan(1), str.length() - string.length(), str.length(), 0);
                this.k.setText(spannableString);
            } else {
                this.y = true;
            }
            this.k.setVisibility(0);
        }
    }

    @Override // c.d.a.a.d.a.d.c
    public boolean i(int i) {
        return this.t == i;
    }

    @Override // c.d.a.a.d.a.d.c
    public boolean isShowing() {
        return isVisible();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.A = getActivity().getApplicationContext();
        this.t = getArguments().getInt("index");
        this.u = getArguments().getString("thumbnail");
        this.B = getArguments().getString("entry");
        this.v = c.d.a.a.d.a.d.a(getActivity());
        this.x = PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("asset_dev_mode", false);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(C2290ya.class.getName());
        View inflate = layoutInflater.inflate(R.layout.fragment_asset_detail, (ViewGroup) null);
        d(inflate);
        inflate.setOnClickListener(null);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        com.nexstreaming.kinemaster.ui.a.t tVar = this.C;
        if (tVar != null) {
            tVar.dismiss();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.D) {
            this.D = false;
            if (getFragmentManager() == null || getFragmentManager().getBackStackEntryCount() <= 1) {
                return;
            }
            new Handler().post(new Runnable() { // from class: com.nexstreaming.kinemaster.ui.store.controller.h
                @Override // java.lang.Runnable
                public final void run() {
                    C2290ya.this.B();
                }
            });
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("expanded_description", this.y);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(final View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.C = new com.nexstreaming.kinemaster.ui.a.t(getActivity());
        this.C.show();
        KineMasterApplication.m().q().a(this.t, true).onResultAvailable(new ResultTask.OnResultAvailableListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.l
            @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
            public final void onResultAvailable(ResultTask resultTask, Task.Event event, Object obj) {
                C2290ya.this.a(view, resultTask, event, (InterfaceC1821j) obj);
            }
        }).onFailure(new Task.OnFailListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.n
            @Override // com.nexstreaming.app.general.task.Task.OnFailListener
            public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
                C2290ya.this.a(task, event, taskError);
            }
        });
        KMEvents.VIEW_ASSET_DETAIL.trackScreen(getActivity());
    }

    @Override // android.support.v4.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            this.y = bundle.getBoolean("expanded_description", false);
        }
    }

    public void z() {
        b(this.w);
    }

    private void d(View view) {
        this.f23632a = (NestedScrollView) view.findViewById(R.id.scroll_fragment_asset_detail);
        this.p = (TextView) view.findViewById(R.id.tv_fragment_asset_sell_finish);
        this.f23633b = (LinearLayout) view.findViewById(R.id.layout_fragment_asset_detail_container);
        this.f23634c = (LinearLayout) view.findViewById(R.id.layout_fragment_asset_detail_top);
        this.f23635d = (LinearLayout) view.findViewById(R.id.layout_fragment_asset_detail_bottom);
        this.f23636e = view.findViewById(R.id.layout_fragment_asset_detail_image);
        this.f23637f = (ImageView) view.findViewById(R.id.iv_fragment_asset_detail_main);
        this.f23639h = (ImageView) view.findViewById(R.id.iv_fragment_asset_detail_new_badge);
        this.i = (TextView) view.findViewById(R.id.tv_fragment_asset_detail_title);
        this.j = (TextView) view.findViewById(R.id.tv_fragment_asset_detail_category);
        this.k = (TextView) view.findViewById(R.id.tv_fragment_asset_detail_desc);
        this.l = (TextView) view.findViewById(R.id.tv_fragment_asset_detail_level);
        this.m = (TextView) view.findViewById(R.id.tv_fragment_asset_detail_file_size);
        this.r = (RecyclerView) view.findViewById(R.id.rv_fragment_asset_detail_images);
        this.f23638g = (ImageView) view.findViewById(R.id.iv_fragment_asset_detail_preview_play);
        this.n = (TextView) view.findViewById(R.id.tv_fragment_asset_detail_progress);
        this.o = (TextView) view.findViewById(R.id.tv_fragment_asset_detail_action);
        this.q = (ProgressBar) view.findViewById(R.id.pb_fragment_asset_detail_progress);
        this.q.setMax(100);
        this.f23633b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.j
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                C2290ya.this.A();
            }
        });
        this.r.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        this.o.setOnClickListener(new View.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2290ya.this.a(view2);
            }
        });
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2290ya.this.b(view2);
            }
        };
        this.f23637f.setOnClickListener(onClickListener);
        this.f23638g.setOnClickListener(onClickListener);
        this.k.setOnClickListener(new View.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2290ya.this.c(view2);
            }
        });
        if (!TextUtils.isEmpty(this.u)) {
            com.bumptech.glide.h<Drawable> a2 = com.bumptech.glide.c.a(getActivity()).a(this.u);
            a2.b(0.1f);
            a2.a(this.f23637f);
        }
        this.f23638g.requestFocus();
    }

    private void e(InterfaceC1821j interfaceC1821j) {
        this.o.setText(R.string.themecat_installed);
        this.o.setEnabled(false);
        this.o.setVisibility(0);
        this.n.setVisibility(8);
        if (I() != null) {
            String a2 = I().a(interfaceC1821j.b(), IABConstant.SKUType.inapp);
            FragmentActivity activity = getActivity();
            if (!isAdded() || activity == null || TextUtils.isEmpty(a2)) {
                return;
            }
            this.l.setText(a2);
            this.l.setTextColor(getResources().getColor(R.color.grapefruit));
        }
    }

    private void f(String str) {
        this.q.setVisibility(4);
        this.o.setVisibility(4);
        this.n.setVisibility(4);
        this.p.setVisibility(0);
        this.p.setText(str);
    }

    public /* synthetic */ void b(View view) {
        Fragment a2;
        if (this.w == null) {
            return;
        }
        if ((getFragmentManager().findFragmentById(R.id.fragmentHolder) == null || !(getFragmentManager().findFragmentById(R.id.fragmentHolder) instanceof eb)) && (a2 = Ca.a(this.w)) != null) {
            getFragmentManager().beginTransaction().addToBackStack("AssetDetailPreview").replace(android.R.id.content, a2).commit();
        }
    }

    public /* synthetic */ void c(View view) {
        F();
    }

    public static Fragment a(InterfaceC1821j interfaceC1821j, AssetStoreEntry assetStoreEntry) {
        Bundle bundle = new Bundle();
        bundle.putInt("index", interfaceC1821j.a());
        bundle.putString("thumbnail", interfaceC1821j.e());
        if (assetStoreEntry != null) {
            bundle.putString("entry", assetStoreEntry.getValue());
        }
        C2290ya c2290ya = new C2290ya();
        c2290ya.setArguments(bundle);
        return c2290ya;
    }

    private boolean c(InterfaceC1821j interfaceC1821j) {
        if (interfaceC1821j == null || H() == null) {
            return false;
        }
        return H().b(this.v.a(interfaceC1821j.a()));
    }

    private void b(InterfaceC1821j interfaceC1821j) {
        if (interfaceC1821j == null || H() == null || getActivity() == null || c(interfaceC1821j)) {
            return;
        }
        String a2 = com.nexstreaming.app.general.util.J.a(getActivity(), interfaceC1821j.j(), interfaceC1821j.f());
        if (a2 == null) {
            a2 = interfaceC1821j.f();
        }
        H().a(new com.nexstreaming.app.general.service.download.k(String.valueOf(interfaceC1821j.a()), a2, interfaceC1821j.p(), interfaceC1821j.l(), this.v.a(interfaceC1821j.a()), interfaceC1821j.h())).onResultAvailable(this.E).onProgress(this.G).onFailure(this.F);
    }

    public static Fragment a(int i, String str, AssetStoreEntry assetStoreEntry) {
        Bundle bundle = new Bundle();
        bundle.putInt("index", i);
        bundle.putString("thumbnail", str);
        if (assetStoreEntry != null) {
            bundle.putString("entry", assetStoreEntry.getValue());
        }
        C2290ya c2290ya = new C2290ya();
        c2290ya.setArguments(bundle);
        return c2290ya;
    }

    public /* synthetic */ void a(View view, ResultTask resultTask, Task.Event event, InterfaceC1821j interfaceC1821j) {
        this.C.dismiss();
        d(interfaceC1821j);
        view.requestFocus();
    }

    public /* synthetic */ void a(Task task, Task.Event event, Task.TaskError taskError) {
        Log.w("AssetDetailFragment", "failed assetInfo ", taskError.getException());
        this.C.dismiss();
    }

    public /* synthetic */ void a(View view) {
        InterfaceC1821j interfaceC1821j = this.w;
        if (interfaceC1821j == null || c(interfaceC1821j)) {
            return;
        }
        if (a(this.w)) {
            K();
            return;
        }
        if (this.w.getPriceType().equalsIgnoreCase("Premium")) {
            if (getFragmentManager().findFragmentById(R.id.fragmentHolder) == null || !(getFragmentManager().findFragmentById(R.id.fragmentHolder) instanceof eb)) {
                getFragmentManager().beginTransaction().replace(android.R.id.content, tb.a(I(), 0, "assetStorePremium", "Asset Store"), tb.f23200a).addToBackStack(tb.f23200a).commitAllowingStateLoss();
                return;
            }
            return;
        }
        if (I() != null && I().b(this.w.b())) {
            K();
        } else {
            E();
        }
    }

    public void b(boolean z) {
        this.D = z;
        b(this.w, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(InterfaceC1821j interfaceC1821j, boolean z) {
        if (interfaceC1821j == null || this.o == null || I() == null) {
            return;
        }
        if (interfaceC1821j.i() == 1) {
            this.q.setVisibility(4);
            a(interfaceC1821j, z);
            if (z) {
                b(this.w);
                return;
            }
            return;
        }
        f(getResources().getString(R.string.asset_detail_Unavailable));
    }

    private void d(final InterfaceC1821j interfaceC1821j) {
        if (interfaceC1821j == null || getActivity() == null || H() == null) {
            return;
        }
        this.w = interfaceC1821j;
        if (this.u != null && !TextUtils.isEmpty(interfaceC1821j.p())) {
            this.u = interfaceC1821j.p();
            com.bumptech.glide.h<Drawable> a2 = com.bumptech.glide.c.a(getActivity()).a(this.u);
            a2.b(0.1f);
            a2.a(this.f23637f);
        }
        String a3 = com.nexstreaming.app.general.util.J.a(KineMasterApplication.f24056d, interfaceC1821j.j(), interfaceC1821j.f());
        String G = G();
        this.i.setText(a3);
        this.j.setText("");
        if (getActivity() instanceof StoreActivity) {
            ((StoreActivity) getActivity()).c(interfaceC1821j.r()).onResultAvailable(new ResultTask.OnResultAvailableListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.d
                @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
                public final void onResultAvailable(ResultTask resultTask, Task.Event event, Object obj) {
                    C2290ya.this.a(interfaceC1821j, resultTask, event, (Map) obj);
                }
            });
        }
        if (G != null && !G.contains("http://") && !G.contains("https://")) {
            this.k.setAutoLinkMask(0);
        }
        this.k.setText(G);
        if (interfaceC1821j.getPriceType() != null) {
            String priceType = interfaceC1821j.getPriceType();
            char c2 = 65535;
            int hashCode = priceType.hashCode();
            if (hashCode != 2198156) {
                if (hashCode != 2479852) {
                    if (hashCode == 1346201143 && priceType.equals("Premium")) {
                        c2 = 1;
                    }
                } else if (priceType.equals("Paid")) {
                    c2 = 2;
                }
            } else if (priceType.equals("Free")) {
                c2 = 0;
            }
            if (c2 == 0) {
                this.l.setText(R.string.sub_use_free);
            } else if (c2 == 1) {
                this.l.setText(R.string.asset_premium);
            } else if (c2 != 2) {
                this.l.setText(R.string.sub_use_free);
            } else {
                this.l.setText(R.string.sub_account_type_paid);
                this.l.setTextColor(getResources().getColor(R.color.amedia_category_divider));
            }
        }
        if (interfaceC1821j.getCategoryAliasName() != null) {
            this.m.setMinimumWidth(0);
            this.m.setText(EditorGlobal.a(KineMasterApplication.f24056d, interfaceC1821j.h()));
        }
        this.f23639h.setVisibility(KineMasterApplication.m().q().a(interfaceC1821j) ? 0 : 8);
        if (c(interfaceC1821j)) {
            H().a(String.valueOf(interfaceC1821j.a())).onResultAvailable(this.E).onProgress(this.G).onFailure(this.F);
        }
        b(interfaceC1821j, false);
        this.s = new Ha(new ArrayList(interfaceC1821j.o()), getFragmentManager());
        this.r.setAdapter(this.s);
        if (J()) {
            this.f23638g.setVisibility(0);
        } else {
            this.f23638g.setVisibility(8);
        }
        new Handler().post(new Runnable() { // from class: com.nexstreaming.kinemaster.ui.store.controller.g
            @Override // java.lang.Runnable
            public final void run() {
                C2290ya.this.C();
            }
        });
        InterfaceC1821j interfaceC1821j2 = this.w;
        if (interfaceC1821j2 != null) {
            com.nexstreaming.kinemaster.usage.analytics.j.a(interfaceC1821j2);
        }
        this.f23638g.requestFocus();
    }

    public /* synthetic */ void a(InterfaceC1821j interfaceC1821j, ResultTask resultTask, Task.Event event, Map map) {
        String a2 = com.nexstreaming.app.general.util.J.a(getActivity(), (Map<String, String>) map);
        this.j.setText(a2);
        ((StoreActivity) getActivity()).a(interfaceC1821j.g(), a2);
    }

    private void a(InterfaceC1821j interfaceC1821j, boolean z) {
        String b2 = interfaceC1821j.b();
        if (this.v.b(interfaceC1821j.a())) {
            String priceType = interfaceC1821j.getPriceType();
            char c2 = 65535;
            int hashCode = priceType.hashCode();
            if (hashCode != 2198156) {
                if (hashCode != 2479852) {
                    if (hashCode == 1346201143 && priceType.equals("Premium")) {
                        c2 = 1;
                    }
                } else if (priceType.equals("Paid")) {
                    c2 = 2;
                }
            } else if (priceType.equals("Free")) {
                c2 = 0;
            }
            if (c2 == 0 || c2 == 1) {
                e(interfaceC1821j);
                return;
            }
            if (c2 != 2) {
                a(interfaceC1821j, b2, Boolean.valueOf(z));
                return;
            } else if (I() != null && I().b(b2)) {
                e(interfaceC1821j);
                return;
            } else {
                a(interfaceC1821j, b2, Boolean.valueOf(z));
                return;
            }
        }
        a(interfaceC1821j, b2, Boolean.valueOf(z));
    }

    private void a(InterfaceC1821j interfaceC1821j, String str, Boolean bool) {
        char c2;
        String priceType = interfaceC1821j.getPriceType();
        int hashCode = priceType.hashCode();
        if (hashCode == 2198156) {
            if (priceType.equals("Free")) {
                c2 = 0;
            }
            c2 = 65535;
        } else if (hashCode != 2479852) {
            if (hashCode == 1346201143 && priceType.equals("Premium")) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (priceType.equals("Paid")) {
                c2 = 2;
            }
            c2 = 65535;
        }
        if (c2 == 0 || c2 == 1) {
            this.o.setText(R.string.check_before_download_download);
            this.o.setVisibility(0);
            this.o.setEnabled(true);
            this.n.setVisibility(8);
            return;
        }
        if (c2 != 2) {
            this.o.setText(R.string.check_before_download_download);
            this.o.setVisibility(0);
            this.o.setEnabled(true);
            this.n.setVisibility(8);
            return;
        }
        FragmentActivity activity = getActivity();
        if (!isAdded() || activity == null || I() == null) {
            return;
        }
        String a2 = I().a(str, IABConstant.SKUType.inapp);
        if (!TextUtils.isEmpty(a2)) {
            this.l.setText(a2);
            this.l.setTextColor(getResources().getColor(R.color.grapefruit));
            if (I().b(str)) {
                if (c(this.w)) {
                    return;
                }
                this.o.setText(R.string.check_before_download_download);
                this.o.setVisibility(0);
                this.o.setEnabled(true);
                this.n.setVisibility(8);
                return;
            }
            this.o.setText(R.string.buy);
            this.o.setVisibility(0);
            this.o.setEnabled(true);
            this.n.setVisibility(8);
            return;
        }
        f(getResources().getString(R.string.product_not_available));
    }

    private boolean a(InterfaceC1821j interfaceC1821j) {
        char c2;
        PurchaseType A;
        String priceType = interfaceC1821j.getPriceType();
        int hashCode = priceType.hashCode();
        if (hashCode == 2198156) {
            if (priceType.equals("Free")) {
                c2 = 0;
            }
            c2 = 65535;
        } else if (hashCode != 2479852) {
            if (hashCode == 1346201143 && priceType.equals("Premium")) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (priceType.equals("Paid")) {
                c2 = 2;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            return c2 != 1 ? c2 != 2 : (I() == null || (A = I().A()) == null || 2 != A.getLevel()) ? false : true;
        }
        return true;
    }

    private void a(IABConstant.SKUType sKUType) {
        final FragmentActivity activity = getActivity();
        if (activity == null || !(activity instanceof com.nextreaming.nexeditorui.I) || I() == null) {
            return;
        }
        I().a(activity, this.w.b(), sKUType, new IABBasePresent.b() { // from class: com.nexstreaming.kinemaster.ui.store.controller.m
            @Override // com.nexstreaming.app.general.iab.Presenter.IABBasePresent.b
            public final void a(SKUDetails sKUDetails) {
                ((com.nextreaming.nexeditorui.I) activity).a(sKUDetails, "assetStorePaid");
            }
        });
    }

    public void a(AssetDownloadResult assetDownloadResult) {
        InterfaceC1821j interfaceC1821j;
        if ((assetDownloadResult == AssetDownloadResult.PURCHASE_CANCEL || assetDownloadResult == AssetDownloadResult.PURCHASE_FAIL) && (interfaceC1821j = this.w) != null) {
            com.nexstreaming.kinemaster.usage.analytics.j.a(interfaceC1821j, assetDownloadResult);
        }
    }
}
