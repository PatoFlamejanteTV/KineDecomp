package com.nexstreaming.kinemaster.ui.assetbrowser;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.general.nexasset.assetpackage.AssetCategoryAlias;
import com.nexstreaming.app.general.nexasset.assetpackage.ItemRatioType;
import com.nexstreaming.app.general.nexasset.assetpackage.r;
import com.nexstreaming.app.general.nexasset.assetpackage.s;
import com.nexstreaming.app.general.nexasset.assetpackage.t;
import com.nexstreaming.app.general.nexasset.assetpackage.y;
import com.nexstreaming.app.general.util.J;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.ui.projectedit.AssetSettingsView;
import com.nexstreaming.kinemaster.ui.projectedit.D;
import com.nexstreaming.kinemaster.ui.settings.tb;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.I;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexTransitionItem;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AssetBrowserBaseFragment.java */
/* loaded from: classes.dex */
public abstract class i extends com.nexstreaming.kinemaster.ui.b.c implements I.a {
    private IABManager A;
    private View r;
    private ListView s;
    private GridView t;
    private AssetSettingsView u;
    private m v;
    private k w;
    private AssetBrowserType x;
    private boolean y = false;
    private boolean z = false;
    private int B = -1;
    private r C = null;
    private D.a D = new c(this);
    private Animation.AnimationListener E = new d(this);
    private AdapterView.OnItemClickListener F = new e(this);
    private AdapterView.OnItemClickListener G = new h(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AssetBrowserBaseFragment.java */
    /* loaded from: classes.dex */
    public class a extends Animation {

        /* renamed from: a, reason: collision with root package name */
        private final float f21382a;

        /* renamed from: b, reason: collision with root package name */
        private final float f21383b;

        /* renamed from: c, reason: collision with root package name */
        private View f21384c;

        public a(float f2, float f3, View view) {
            this.f21382a = f2;
            this.f21383b = f3 - f2;
            this.f21384c = view;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f2, Transformation transformation) {
            ((RelativeLayout.LayoutParams) this.f21384c.getLayoutParams()).width = (int) (this.f21382a + (this.f21383b * f2));
            this.f21384c.requestLayout();
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    /* compiled from: AssetBrowserBaseFragment.java */
    /* loaded from: classes.dex */
    public interface b {
    }

    private ItemRatioType Da() {
        float l = EditorGlobal.l();
        if (l == 0.5625f) {
            return ItemRatioType.RATIO_9v16;
        }
        if (l == 1.0f) {
            return ItemRatioType.RATIO_1v1;
        }
        return ItemRatioType.RATIO_16v9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ea() {
        return this.x.getTitleResource();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fa() {
        tb a2 = tb.a(this.A, 0, "assetBrowser", "Asset Browser");
        if (getFragmentManager() != null) {
            getFragmentManager().beginTransaction().replace(R.id.content, a2, tb.f23200a).addToBackStack(tb.f23200a).commitAllowingStateLoss();
        }
    }

    private void Ga() {
        if (Y() != null) {
            String effectItemID = Y() instanceof NexTimelineItem.l ? ((NexTimelineItem.l) Y()).getEffectItemID() : null;
            int i = 0;
            int i2 = -1;
            if (effectItemID != null && !effectItemID.equals(NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE)) {
                r a2 = com.nexstreaming.app.general.nexasset.assetpackage.h.a(getActivity()).a(effectItemID);
                if (a2 == null || this.v == null) {
                    return;
                }
                while (true) {
                    if (i >= this.v.getCount()) {
                        i = -1;
                        break;
                    }
                    if (a2.getAssetPackage().getAssetId().equals(((com.nexstreaming.app.general.nexasset.assetpackage.b) this.v.getItem(i)).getAssetId())) {
                        Iterator<? extends r> it = a(a2.getAssetPackage()).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            r next = it.next();
                            if (!next.isHidden()) {
                                if (a2.getId().equals(next.getId())) {
                                    i2++;
                                    break;
                                }
                                i2++;
                            }
                        }
                    } else {
                        i++;
                    }
                }
                d(i, i2);
                return;
            }
            d(0, -1);
        }
    }

    protected void Aa() {
        if (this.y) {
            return;
        }
        this.y = true;
        this.s.getWidth();
        a(0.0f);
    }

    public void Ba() {
        ua();
    }

    public void Ca() {
        m mVar = this.v;
        if (mVar != null) {
            mVar.a(W());
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public Class<? extends NexTimelineItem> Z() {
        return null;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public boolean ja() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        this.y = false;
        if (Y() != null) {
            Ga();
            if (Y() instanceof NexTransitionItem) {
                qa();
            }
        }
        m mVar = this.v;
        if (mVar != null && mVar.a() != W()) {
            this.v.a(W());
        }
        super.na();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        AssetSettingsView assetSettingsView = this.u;
        if (assetSettingsView != null) {
            assetSettingsView.a(i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() != null && (getActivity() instanceof I)) {
            this.A = ((I) getActivity()).y();
            return;
        }
        throw new IllegalStateException("AssetDetailFragment must be attached to KineMasterBaseActivity");
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, com.nextreaming.nexeditorui.I.a
    public boolean onBackPressed() {
        ListView listView = this.s;
        if (listView != null && listView.getWidth() <= 0) {
            ya();
            n(Ea());
            return true;
        }
        return za();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AssetBrowserType assetBrowserType;
        com.nexstreaming.kinemaster.usage.analytics.b.a(getClass().getName());
        if (bundle != null && (assetBrowserType = (AssetBrowserType) bundle.getSerializable("AssetBrowserType")) != null) {
            this.x = assetBrowserType;
        }
        if (this.x == null) {
            this.x = wa();
        }
        this.r = a(layoutInflater, viewGroup, bundle);
        this.r.setOnClickListener(new com.nexstreaming.kinemaster.ui.assetbrowser.a(this));
        a(this.r);
        n(Ea());
        f(true);
        g(false);
        this.s = (ListView) this.r.findViewById(com.nexstreaming.app.kinemasterfree.R.id.assetList);
        this.t = (GridView) this.r.findViewById(com.nexstreaming.app.kinemasterfree.R.id.assetGridView);
        this.u = (AssetSettingsView) this.r.findViewById(com.nexstreaming.app.kinemasterfree.R.id.settingsView);
        this.u.setFragment(this);
        this.u.setOnAssetSettingsChangeListener(this.D);
        List<com.nexstreaming.app.general.nexasset.assetpackage.b> b2 = com.nexstreaming.app.general.nexasset.assetpackage.h.a(requireActivity()).b(this.x.getItemCategory());
        AssetBrowserType assetBrowserType2 = this.x;
        if (assetBrowserType2 == AssetBrowserType.ClipEffect || assetBrowserType2 == AssetBrowserType.Transition) {
            b2.add(0, t.f19555a);
        }
        this.v = new m(b2, getActivity(), getFragmentManager(), W());
        this.s.setOnItemClickListener(this.F);
        this.t.setOnItemClickListener(this.G);
        View inflate = layoutInflater.inflate(com.nexstreaming.app.kinemasterfree.R.layout.asset_list_footer, (ViewGroup) null, false);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelOffset(com.nexstreaming.app.kinemasterfree.R.dimen.asset_footer_height)));
        inflate.setOnClickListener(new com.nexstreaming.kinemaster.ui.assetbrowser.b(this));
        this.s.addFooterView(inflate);
        this.s.setAdapter((ListAdapter) this.v);
        this.t.setVisibility(0);
        na();
        return this.r;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroy() {
        this.r = null;
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        if (this.z) {
            this.z = false;
            G();
        }
        super.onPause();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.putSerializable("AssetBrowserType", this.x);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        if (!M().pa()) {
            if (Y() instanceof NexTransitionItem) {
                m(true);
            } else {
                m(false);
            }
        }
        if (Y() != null && (Y() instanceof NexTimelineItem.l)) {
            if (com.nexstreaming.app.general.nexasset.assetpackage.h.a(getActivity()).a(((NexTimelineItem.l) Y()).getEffectItemID()) != null) {
                sa();
            } else {
                ta();
            }
        }
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        fa();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void va() {
        k kVar = this.w;
        if (kVar != null) {
            kVar.a(-1);
        }
    }

    public abstract AssetBrowserType wa();

    public AssetCategoryAlias xa() {
        return this.x.getAssetCategoryAlias();
    }

    protected void ya() {
        if (this.y) {
            this.y = false;
            a(getResources().getDimension(com.nexstreaming.app.kinemasterfree.R.dimen.pedit_expand_option_panel_width_half));
        }
    }

    public boolean za() {
        if (Y() == null || !(Y() instanceof NexLayerItem)) {
            return false;
        }
        d(Y());
        return true;
    }

    private void d(int i, int i2) {
        m mVar = this.v;
        if (mVar != null) {
            com.nexstreaming.app.general.nexasset.assetpackage.b bVar = (com.nexstreaming.app.general.nexasset.assetpackage.b) mVar.getItem(i);
            r(i);
            if (b(bVar)) {
                return;
            }
            q(i2);
        }
    }

    private void q(int i) {
        GridView gridView;
        if (i < 0 || (gridView = this.t) == null || gridView.getAdapter() == null) {
            return;
        }
        GridView gridView2 = this.t;
        gridView2.performItemClick(gridView2.getChildAt(i), i, this.t.getAdapter().getItemId(i));
        this.t.setSelection(i);
    }

    private void r(int i) {
        ListView listView;
        if (i < 0 || (listView = this.s) == null || listView.getAdapter() == null) {
            return;
        }
        ListView listView2 = this.s;
        listView2.performItemClick(listView2.getChildAt(i), i, this.s.getAdapter().getItemId(i));
        this.s.setSelection(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.assetbrowser.i.h(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(com.nexstreaming.app.general.nexasset.assetpackage.b bVar) {
        return bVar instanceof t;
    }

    protected View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.nexstreaming.app.kinemasterfree.R.layout.effect_browser_base, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(float f2) {
        if (this.s.getLayoutParams().width == f2) {
            return;
        }
        a aVar = new a(this.s.getLayoutParams().width, f2, this.s);
        aVar.setDuration(100L);
        aVar.setAnimationListener(this.E);
        this.s.startAnimation(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NexTimelineItem.l lVar) {
        this.u.a(lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<? extends r> a(com.nexstreaming.app.general.nexasset.assetpackage.b bVar) {
        return com.nexstreaming.app.general.nexasset.assetpackage.h.a(getActivity()).a(bVar.getAssetId(), this.x.getItemCategory(), Da());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(r rVar) {
        if (this.x.needSettings()) {
            List<s> list = null;
            try {
                list = y.a(getActivity(), rVar.getId()).e();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (XmlPullParserException e3) {
                e3.printStackTrace();
            }
            if (list != null && list.size() > 0) {
                Aa();
                g(J.a(getActivity(), rVar.getAssetPackage().getAssetName()));
            } else if (this.y) {
                ya();
            }
        }
    }
}
