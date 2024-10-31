package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb;
import com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager;
import com.adobe.creativesdk.foundation.internal.twowayview.widget.GridLayoutManager;
import com.adobe.creativesdk.foundation.internal.twowayview.widget.TwoWayView;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFileRenditionType;
import com.adobe.creativesdk.foundation.storage.AdobeAssetPackagePages;
import java.util.ArrayList;
import java.util.Date;

/* compiled from: MobileCreationPackageItemsListView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.td */
/* loaded from: classes.dex */
public class C0478td extends AbstractC0476tb {
    private AdobeAssetPackagePages k;
    private TwoWayView l;
    private com.adobe.creativesdk.foundation.internal.storage.controllers.b.b m;
    private int n;
    private a o;
    com.adobe.creativesdk.foundation.internal.storage.controllers.a.f p;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: MobileCreationPackageItemsListView.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.td$a */
    /* loaded from: classes.dex */
    public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: c */
        private final Context f6430c;

        /* compiled from: MobileCreationPackageItemsListView.java */
        /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.td$a$a */
        /* loaded from: classes.dex */
        public class C0037a extends RecyclerView.ViewHolder {
            View s;
            ImageView t;
            TextView u;
            AdobeAssetFile v;

            public C0037a(View view) {
                super(view);
                this.s = view;
                this.t = (ImageView) view.findViewById(c.a.a.a.b.e.adobe_csdk_mobilecreation_item_mainImage);
                this.u = (TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_mobilecreation_item_modifiedDate);
            }

            public static /* synthetic */ void a(C0037a c0037a, BitmapDrawable bitmapDrawable) {
                c0037a.a(bitmapDrawable);
            }

            public AdobeAssetFile t() {
                return this.v;
            }

            public void a(BitmapDrawable bitmapDrawable) {
                this.t.setVisibility(0);
                this.t.setImageDrawable(bitmapDrawable);
            }

            public void a(AdobeAssetFile adobeAssetFile) {
                this.v = adobeAssetFile;
            }

            public void a(Date date) {
                if (date != null) {
                    this.u.setText(com.adobe.creativesdk.foundation.internal.utils.a.a(this.itemView.getContext(), date));
                }
            }

            public void a(View.OnClickListener onClickListener) {
                this.s.setOnClickListener(onClickListener);
            }
        }

        public a(Context context) {
            this.f6430c = context;
        }

        public AdobeAssetFile c(int i) {
            ArrayList<AdobeAssetFile> g2 = g();
            if (g2 == null || i < 0 || i >= g2.size()) {
                return null;
            }
            return g2.get(i);
        }

        protected int f() {
            if (g() != null) {
                return g().size();
            }
            return 0;
        }

        protected ArrayList<AdobeAssetFile> g() {
            return C0478td.this.k.j();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return f();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            C0037a c0037a = (C0037a) viewHolder;
            AdobeAssetFile c2 = c(i);
            c0037a.a(c2);
            c0037a.a(c2.getModificationDate());
            c0037a.a((View.OnClickListener) new AbstractC0476tb.a(i));
            if (c2 == null) {
                return;
            }
            BitmapDrawable c3 = C0478td.this.p.c(c2.getGUID() + c2.getMd5Hash());
            if (c3 != null) {
                c0037a.a(c3);
                return;
            }
            c2.getRenditionWithType(AdobeAssetFileRenditionType.ADOBE_ASSET_FILE_RENDITION_TYPE_PNG, AbstractC0452ob.a(com.adobe.creativesdk.foundation.internal.storage.model.util.c.f6622b), new C0473sd(this, c2, c0037a));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C0037a(LayoutInflater.from(this.f6430c).inflate(c.a.a.a.b.g.adobe_mobilecreation_package_item_cell, viewGroup, false));
        }
    }

    public C0478td(Context context) {
        super(context);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected void a(int i, View view) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected RecyclerView.LayoutManager b(Context context) {
        this.n = com.adobe.creativesdk.foundation.internal.utils.q.a(b());
        return new GridLayoutManager(TwoWayLayoutManager.Orientation.VERTICAL, this.n, 1);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected View c(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(c.a.a.a.b.g.adobe_assets_mobilecreations_items_view, new FrameLayout(context));
        this.f6415f = (SwipeRefreshLayout) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_asset_mobilecreations_itemsview_swipe_refresh_layout);
        this.l = (TwoWayView) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_asset_mobilecreations_items_twowayview);
        return inflate;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected SwipeRefreshLayout l() {
        return this.f6415f;
    }

    public void a(AdobeAssetPackagePages adobeAssetPackagePages) {
        this.k = adobeAssetPackagePages;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    public RecyclerView a(Context context) {
        return this.l;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected RecyclerView.ItemDecoration a(RecyclerView recyclerView, Context context) {
        int dimensionPixelSize = b().getResources().getDimensionPixelSize(c.a.a.a.b.c.adobe_csdk_library_items_spacing_size);
        this.m = new com.adobe.creativesdk.foundation.internal.storage.controllers.b.b(dimensionPixelSize, dimensionPixelSize);
        this.n = com.adobe.creativesdk.foundation.internal.utils.q.a(b());
        this.m.a(this.n);
        return this.m;
    }

    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar) {
        this.p = fVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected RecyclerView.Adapter<RecyclerView.ViewHolder> a(Context context, RecyclerView recyclerView) {
        this.o = new a(context);
        return this.o;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected void a(View view, int i) {
        if (this.o.c(i) == null) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.storage.controllers.utils.g gVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.utils.g();
        AdobeAssetPackagePages adobeAssetPackagePages = this.k;
        gVar.f6498a = adobeAssetPackagePages;
        gVar.f6500c = adobeAssetPackagePages.j();
        gVar.f6499b = i;
        InterfaceC0362ad interfaceC0362ad = this.f6373b.get();
        if (interfaceC0362ad != null) {
            interfaceC0362ad.a(gVar);
        }
    }
}
