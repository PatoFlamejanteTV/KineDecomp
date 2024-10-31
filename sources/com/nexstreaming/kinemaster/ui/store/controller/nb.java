package com.nexstreaming.kinemaster.ui.store.controller;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nexstreaming.kinemaster.ui.store.view.AssetCardView;
import com.nexstreaming.kinemaster.ui.store.view.AssetThumbnailView;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StoreAssetAdapter.java */
/* loaded from: classes2.dex */
public class nb extends RecyclerView.Adapter {

    /* renamed from: d, reason: collision with root package name */
    private final d f23589d;

    /* renamed from: g, reason: collision with root package name */
    private FrameLayout f23592g;

    /* renamed from: h, reason: collision with root package name */
    private Context f23593h;
    private com.bumptech.glide.j i;
    private View j;
    private UnifiedNativeAd k;

    /* renamed from: e, reason: collision with root package name */
    private final int f23590e = 2;

    /* renamed from: f, reason: collision with root package name */
    private int f23591f = -1;

    /* renamed from: c, reason: collision with root package name */
    private final List<com.nexstreaming.kinemaster.ui.store.model.c> f23588c = new ArrayList();

    /* compiled from: StoreAssetAdapter.java */
    /* loaded from: classes2.dex */
    private class a extends RecyclerView.ViewHolder {
        UnifiedNativeAdView s;
        TextView t;
        Button u;
        MediaView v;

        public a(View view) {
            super(view);
            this.s = (UnifiedNativeAdView) view;
            this.t = (TextView) this.s.findViewById(R.id.headline_textview);
            this.u = (Button) this.s.findViewById(R.id.ad_call_to_action);
            this.v = (MediaView) view.findViewById(R.id.ad_media);
        }
    }

    /* compiled from: StoreAssetAdapter.java */
    /* loaded from: classes2.dex */
    private static class b extends RecyclerView.ViewHolder {
        public AssetCardView s;
        public View t;
        public AssetThumbnailView u;
        public TextView v;

        public b(View view) {
            super(view);
            this.s = (AssetCardView) view.findViewById(R.id.bannerAssetCardView);
            this.t = view.findViewById(R.id.asset_item_selection);
            this.u = (AssetThumbnailView) view.findViewById(R.id.thumb);
            this.v = (TextView) view.findViewById(R.id.name);
        }
    }

    /* compiled from: StoreAssetAdapter.java */
    /* loaded from: classes2.dex */
    private static class c extends RecyclerView.ViewHolder {
        public AssetCardView s;
        public View t;
        public AssetThumbnailView u;
        public TextView v;
        public TextView w;

        public c(View view) {
            super(view);
            this.s = (AssetCardView) view.findViewById(R.id.assetCardView);
            this.t = view.findViewById(R.id.asset_item_selection);
            this.u = (AssetThumbnailView) view.findViewById(R.id.thumb);
            this.v = (TextView) view.findViewById(R.id.premium);
            this.w = (TextView) view.findViewById(R.id.name);
        }
    }

    /* compiled from: StoreAssetAdapter.java */
    /* loaded from: classes2.dex */
    public interface d {
        void a(View view, int i, com.nexstreaming.kinemaster.ui.store.model.c cVar);
    }

    /* compiled from: StoreAssetAdapter.java */
    /* loaded from: classes2.dex */
    private class e extends RecyclerView.ViewHolder {
        public ViewGroup s;

        public e(View view) {
            super(view);
            this.s = (ViewGroup) view.findViewById(R.id.ad_container);
        }
    }

    public nb(Context context, com.bumptech.glide.j jVar, d dVar) {
        this.f23589d = dVar;
        this.i = jVar;
        this.f23593h = context;
    }

    private IABManager h() {
        Context context = this.f23593h;
        if (context == null || !(context instanceof com.nextreaming.nexeditorui.I)) {
            return null;
        }
        return ((com.nextreaming.nexeditorui.I) context).y();
    }

    private boolean i() {
        return this.f23588c.size() > 2 && this.f23588c.get(2) != null;
    }

    private void j() {
        if (i()) {
            this.f23588c.remove(2);
            this.f23592g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f23591f = -1;
        notifyDataSetChanged();
    }

    public nb f() {
        this.f23588c.clear();
        if (this.f23592g != null && this.f23588c.size() > 0 && this.f23588c.get(2) != null) {
            this.f23588c.add(2, null);
        }
        return this;
    }

    public void g() {
        if (this.f23588c.size() > 2) {
            this.f23588c.remove(2);
            this.f23592g = null;
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f23588c.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.f23588c.isEmpty()) {
            return -1;
        }
        if (i != 2 || this.f23592g == null) {
            return this.f23588c.get(i).a();
        }
        return 100;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        recyclerView.setOnFocusChangeListener(new mb(this, recyclerView));
        recyclerView.setOnKeyListener(new View.OnKeyListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.na
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return nb.this.a(recyclerView, view, i, keyEvent);
            }
        });
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof c) {
            c cVar = (c) viewHolder;
            cVar.t.setSelected(this.f23591f == i);
            com.nexstreaming.kinemaster.ui.store.model.c cVar2 = this.f23588c.get(i);
            if (cVar2 != null && cVar2.b() != null) {
                InterfaceC1821j b2 = cVar2.b();
                cVar.s.setOnClickListener(new View.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.ma
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        nb.this.a(i, view);
                    }
                });
                String priceType = b2.getPriceType();
                char c2 = 65535;
                int hashCode = priceType.hashCode();
                if (hashCode != 2198156) {
                    if (hashCode != 2479852) {
                        if (hashCode == 1346201143 && priceType.equals("Premium")) {
                            c2 = 1;
                        }
                    } else if (priceType.equals("Paid")) {
                        c2 = 0;
                    }
                } else if (priceType.equals("Free")) {
                    c2 = 2;
                }
                if (c2 == 0) {
                    cVar.v.setVisibility(0);
                    cVar.v.setText(this.f23593h.getResources().getString(R.string.sub_account_type_paid));
                    if (h() != null) {
                        String a2 = h().a(cVar2.b().b(), IABConstant.SKUType.inapp);
                        if (!TextUtils.isEmpty(a2)) {
                            String assetId = b2.getAssetId();
                            if (this.f23588c.size() > i && this.f23588c.get(i) != null && assetId.equalsIgnoreCase(this.f23588c.get(i).b().getAssetId())) {
                                cVar.v.setText(a2);
                            }
                        }
                    }
                } else if (c2 == 1) {
                    cVar.v.setVisibility(0);
                    cVar.v.setText(this.f23593h.getResources().getString(R.string.asset_premium));
                } else if (c2 != 2) {
                    cVar.v.setVisibility(4);
                } else {
                    cVar.v.setVisibility(4);
                }
            }
            cVar.s.setNewAsset(KineMasterApplication.m().q().a(this.f23588c.get(i).b()));
            cVar.u.setGlideRequestManager(this.i);
            cVar.u.setImageUrl(this.f23588c.get(i).d());
            cVar.w.setText(this.f23588c.get(i).c());
            this.j = cVar.u;
            return;
        }
        if (viewHolder instanceof b) {
            b bVar = (b) viewHolder;
            bVar.t.setSelected(this.f23591f == i);
            bVar.s.setOnClickListener(new lb(this, i));
            bVar.s.setNewAsset(KineMasterApplication.m().q().a(this.f23588c.get(i).b()));
            bVar.u.setGlideRequestManager(this.i);
            bVar.u.setImageUrl(this.f23588c.get(i).d());
            bVar.v.setText(this.f23588c.get(i).c());
            return;
        }
        if (viewHolder instanceof a) {
            viewHolder.itemView.findViewById(R.id.asset_item_selection).setSelected(this.f23591f == i);
            a aVar = (a) viewHolder;
            aVar.t.setText(this.k.getHeadline());
            aVar.u.setText(this.k.getCallToAction());
            aVar.s.setHeadlineView(aVar.t);
            aVar.s.setCallToActionView(aVar.u);
            aVar.s.setMediaView(aVar.v);
            aVar.s.setNativeAd(this.k);
            if (this.j != null) {
                ViewGroup.LayoutParams layoutParams = aVar.v.getLayoutParams();
                layoutParams.height = this.j.getHeight();
                aVar.v.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        if (this.f23592g.getParent() != null) {
            ((ViewGroup) this.f23592g.getParent()).removeView(this.f23592g);
        }
        ((e) viewHolder).s.addView(this.f23592g);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_asset_banner, viewGroup, false));
        }
        if (i == 0) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_asset, viewGroup, false));
        }
        if (c.d.b.m.e.f3850a.a()) {
            return new e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tencent_ad, viewGroup, false));
        }
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_admob_in_store, viewGroup, false));
    }

    public nb b(List<com.nexstreaming.kinemaster.ui.store.model.c> list) {
        this.f23588c.addAll(list);
        return this;
    }

    private void b(FrameLayout frameLayout) {
        if (!i() || frameLayout == null) {
            return;
        }
        this.f23588c.add(2, null);
        this.f23592g = frameLayout;
    }

    public nb a(com.nexstreaming.kinemaster.ui.store.model.c cVar) {
        this.f23588c.add(cVar);
        return this;
    }

    public void a(FrameLayout frameLayout, UnifiedNativeAd unifiedNativeAd) {
        this.k = unifiedNativeAd;
        a(frameLayout);
    }

    public void a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            j();
        } else {
            b(frameLayout);
        }
        notifyDataSetChanged();
    }

    public /* synthetic */ void a(int i, View view) {
        d dVar = this.f23589d;
        if (dVar != null) {
            dVar.a(view, i, this.f23588c.get(i));
        }
    }

    public /* synthetic */ boolean a(RecyclerView recyclerView, View view, int i, KeyEvent keyEvent) {
        com.nexstreaming.kinemaster.ui.store.view.a a2 = com.nexstreaming.kinemaster.ui.store.view.a.a();
        int i2 = this.f23591f;
        if (i2 < 0) {
            return true;
        }
        if (getItemViewType(i2) == 1) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (keyEvent.getAction() == 0) {
                if (i == 61) {
                    a2.getClass();
                    a2.a("main_category_view", false);
                    return true;
                }
                if (i != 66) {
                    switch (i) {
                        case 20:
                            a2.getClass();
                            a2.a("feature_asset_view", false);
                        case 19:
                            return true;
                        case 21:
                            if (this.f23591f == 0) {
                                a2.getClass();
                                a2.a("main_category_view", false);
                                return true;
                            }
                            return a(recyclerView, -1);
                        case 22:
                            if (this.f23591f == linearLayoutManager.getItemCount() - 1) {
                                a2.getClass();
                                a2.a("feature_asset_view", false);
                                return true;
                            }
                            return a(recyclerView, 1);
                    }
                } else {
                    d dVar = this.f23589d;
                    if (dVar != null) {
                        int i3 = this.f23591f;
                        dVar.a(view, i3, this.f23588c.get(i3));
                    }
                    return true;
                }
            }
            return false;
        }
        if (getItemViewType(this.f23591f) == 0) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            int spanCount = gridLayoutManager.getSpanCount();
            if (keyEvent.getAction() == 0) {
                if (i == 61) {
                    if (a2.d()) {
                        a2.getClass();
                        a2.a("main_category_view", false);
                        return true;
                    }
                    if (keyEvent.hasModifiers(1) && a2.b()) {
                        a2.getClass();
                        a2.a("sub_category_view", false);
                    } else {
                        a2.getClass();
                        a2.a("main_category_view", false);
                    }
                    return true;
                }
                if (i != 66) {
                    switch (i) {
                        case 19:
                            if (this.f23591f < spanCount) {
                                if (a2.d()) {
                                    a2.getClass();
                                    a2.a("feature_banner_view", false);
                                }
                                return true;
                            }
                            return a(recyclerView, -spanCount);
                        case 20:
                            return a(recyclerView, spanCount);
                        case 21:
                            if (a2.d()) {
                                if (this.f23591f == 0) {
                                    a2.getClass();
                                    a2.a("feature_banner_view", true);
                                    return true;
                                }
                                return a(recyclerView, -1);
                            }
                            if (this.f23591f == 0 && a2.b()) {
                                a2.getClass();
                                a2.a("sub_category_view", false);
                                return true;
                            }
                            if (this.f23591f == 0 && !a2.b()) {
                                a2.getClass();
                                a2.a("main_category_view", false);
                                return true;
                            }
                            return a(recyclerView, -1);
                        case 22:
                            if (this.f23591f == gridLayoutManager.getItemCount() - 1) {
                                return true;
                            }
                            return a(recyclerView, 1);
                    }
                }
                d dVar2 = this.f23589d;
                if (dVar2 != null) {
                    int i4 = this.f23591f;
                    dVar2.a(view, i4, this.f23588c.get(i4));
                }
                return true;
            }
            return false;
        }
        if (getItemViewType(this.f23591f) != 100) {
            return false;
        }
        int spanCount2 = ((GridLayoutManager) recyclerView.getLayoutManager()).getSpanCount();
        if (keyEvent.getAction() == 0) {
            if (i != 61) {
                switch (i) {
                    case 19:
                        a2.getClass();
                        a2.a("feature_banner_view", false);
                        return true;
                    case 20:
                        return a(recyclerView, spanCount2);
                    case 21:
                        return a(recyclerView, -1);
                    case 22:
                        return a(recyclerView, 1);
                }
            }
            a2.getClass();
            a2.a("main_category_view", false);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RecyclerView recyclerView) {
        if (com.nexstreaming.kinemaster.ui.store.view.a.a().c()) {
            this.f23591f = 3;
        } else {
            this.f23591f = 0;
        }
        recyclerView.scrollToPosition(this.f23591f);
        notifyDataSetChanged();
    }

    private boolean a(RecyclerView recyclerView, int i) {
        int i2 = this.f23591f + i;
        if (i2 < 0 || i2 >= getItemCount()) {
            return false;
        }
        notifyItemChanged(this.f23591f);
        this.f23591f = i2;
        notifyItemChanged(this.f23591f);
        recyclerView.scrollToPosition(this.f23591f);
        return true;
    }
}
