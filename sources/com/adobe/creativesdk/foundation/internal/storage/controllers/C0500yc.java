package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.R;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.core.ACUserAssetType;
import com.adobe.creativesdk.foundation.internal.storage.C0514m;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb;
import com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager;
import com.adobe.creativesdk.foundation.internal.twowayview.widget.GridLayoutManager;
import com.adobe.creativesdk.foundation.internal.twowayview.widget.TwoWayView;
import com.adobe.creativesdk.foundation.storage.C0551eb;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: DesignLibraryCollectionListView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.yc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0500yc extends AbstractC0476tb {
    private static boolean k = false;
    private C0514m l;
    private int m;
    private TwoWayView n;
    private a o;
    private com.adobe.creativesdk.foundation.internal.storage.controllers.b.b p;
    private int q;
    com.adobe.creativesdk.foundation.internal.storage.controllers.a.f r;
    private Boolean s;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: DesignLibraryCollectionListView.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.yc$a */
    /* loaded from: classes.dex */
    public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: c, reason: collision with root package name */
        private final Context f6544c;

        /* renamed from: d, reason: collision with root package name */
        ArrayList<C0614ub> f6545d;

        /* renamed from: e, reason: collision with root package name */
        private Typeface f6546e;

        /* renamed from: f, reason: collision with root package name */
        boolean f6547f = false;

        /* renamed from: g, reason: collision with root package name */
        String f6548g = "";

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DesignLibraryCollectionListView.java */
        /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.yc$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0039a extends RecyclerView.ViewHolder {
            TextView A;
            C0614ub B;
            View s;
            LinearLayout t;
            RelativeLayout u;
            ImageView v;
            ImageView w;
            RelativeLayout x;
            TextView y;
            ImageView z;

            public C0039a(View view) {
                super(view);
                this.s = view;
                this.t = (LinearLayout) view.findViewById(c.a.a.a.b.e.adobe_csdk_library_collection_cell_colortheme);
                this.u = (RelativeLayout) view.findViewById(c.a.a.a.b.e.adobe_csdk_library_collection_cell_color);
                this.v = (ImageView) view.findViewById(c.a.a.a.b.e.adobe_csdk_library_collection_cell_image);
                this.w = (ImageView) view.findViewById(c.a.a.a.b.e.adobe_csdk_library_collection_cell_shared_folder_icon);
                this.x = (RelativeLayout) view.findViewById(c.a.a.a.b.e.adobe_csdk_library_collection_menu_icon);
                this.z = (ImageView) view.findViewById(c.a.a.a.b.e.adobe_csdk_library_collection_cell_folder_forward_icon);
                this.y = (TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_library_collection_cell_main_title);
                this.A = (TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_library_collection_cell_count_text);
                C0500yc c0500yc = C0500yc.this;
                c0500yc.s = Boolean.valueOf(C0455p.b(c0500yc.b()));
                if (C0500yc.this.s.booleanValue()) {
                    this.y.setTypeface(a.this.f6546e);
                    this.A.setTypeface(a.this.f6546e);
                    this.z.setImageResource(c.a.a.a.b.d.ic_more_vert_black_24dp);
                    return;
                }
                this.x.setVisibility(8);
            }

            public void a(View.OnClickListener onClickListener) {
                this.s.setOnClickListener(onClickListener);
            }

            public void b(View.OnClickListener onClickListener) {
                this.x.setOnClickListener(onClickListener);
            }

            public void c(int i) {
                a((View) this.u);
                this.u.setBackgroundColor(i);
            }

            public void d(int i) {
                this.A.setText(i != 1 ? String.format(a.this.f6544c.getString(c.a.a.a.b.i.adobe_csdk_design_library_collection_count), Integer.toString(i)) : a.this.f6544c.getString(c.a.a.a.b.i.adobe_csdk_design_library_collection_count_single));
            }

            public C0614ub t() {
                return this.B;
            }

            public void u() {
                a((View) this.v);
                this.v.setScaleType(ImageView.ScaleType.CENTER);
                this.v.setImageResource(c.a.a.a.b.d.empty_library);
            }

            public void v() {
                this.w.setVisibility(0);
                c.a.a.a.c.a.a.b().a();
                this.w.setImageResource(c.a.a.a.b.d.ic_vector_asset_folder_ro);
            }

            public void w() {
                this.w.setVisibility(0);
                c.a.a.a.c.a.a.b().a();
                this.w.setImageResource(c.a.a.a.b.d.ic_library_bookmark);
            }

            public void x() {
                this.w.setVisibility(0);
                c.a.a.a.c.a.a.b().a();
                this.w.setImageResource(c.a.a.a.b.d.ic_vector_asset_folder_shared);
            }

            private void a(View view) {
                LinearLayout linearLayout = this.t;
                linearLayout.setVisibility(view == linearLayout ? 0 : 8);
                RelativeLayout relativeLayout = this.u;
                relativeLayout.setVisibility(view == relativeLayout ? 0 : 8);
                this.v.setVisibility(view == this.v ? 0 : 8);
            }

            public void a(ArrayList<Integer> arrayList) {
                a((View) this.t);
                int min = Math.min(this.t.getChildCount(), arrayList.size());
                for (int i = 0; i < min; i++) {
                    this.t.getChildAt(i).setBackgroundColor(arrayList.get(i).intValue());
                }
            }

            public void a(BitmapDrawable bitmapDrawable) {
                a((View) this.v);
                if (bitmapDrawable == null) {
                    this.v.setImageResource(R.color.transparent);
                } else {
                    this.v.setImageDrawable(bitmapDrawable);
                }
            }

            public void a(String str) {
                this.y.setText(str);
            }

            public void a(C0614ub c0614ub) {
                this.B = c0614ub;
            }
        }

        public a(Context context) {
            this.f6544c = context;
            this.f6546e = Typeface.createFromAsset(C0500yc.this.b().getAssets(), "fonts/AdobeClean-SemiLight.otf");
        }

        public C0614ub c(int i) {
            ArrayList<C0614ub> g2 = g();
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

        protected ArrayList<C0614ub> g() {
            if (this.f6545d == null && C0500yc.this.l != null && C0500yc.this.l.d() != null) {
                this.f6545d = new ArrayList<>();
                Iterator<C0614ub> it = (this.f6547f ? C0500yc.this.l.a(this.f6548g) : C0500yc.this.l.d()).iterator();
                while (it.hasNext()) {
                    C0614ub next = it.next();
                    if (!((com.adobe.creativesdk.foundation.adobeinternal.storage.library.F) next).x()) {
                        this.f6545d.add(next);
                    }
                }
                Iterator<C0614ub> it2 = this.f6545d.iterator();
                while (it2.hasNext()) {
                    C0614ub next2 = it2.next();
                    C0455p.a(next2.k(), next2.m());
                }
            }
            return this.f6545d;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return f();
        }

        public void h() {
            this.f6545d = null;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            C0039a c0039a = (C0039a) viewHolder;
            C0614ub c2 = c(i);
            c0039a.a(c2.m());
            c0039a.d(c2.a(c.a.a.a.a.b.a.a.b.c().e()));
            c0039a.a(c2);
            c0039a.a((View.OnClickListener) new AbstractC0476tb.a(i));
            C0500yc c0500yc = C0500yc.this;
            c0500yc.s = Boolean.valueOf(C0455p.b(c0500yc.b()));
            if (C0500yc.this.s.booleanValue()) {
                C0500yc c0500yc2 = C0500yc.this;
                c0500yc2.f6417h = new AbstractC0476tb.b(i);
                c0039a.b(C0500yc.this.f6417h);
            }
            if (!C0455p.a(c2.k())) {
                C0455p.a(c2.k(), c2.m());
            }
            boolean r = c2.r();
            boolean q = c2.q();
            if (c2.p()) {
                c0039a.w();
            } else if (r && q) {
                c0039a.v();
            } else if (r) {
                c0039a.x();
            } else {
                c0039a.w.setImageResource(c.a.a.a.b.d.ic_vector_asset_library);
            }
            if (c2.a(c.a.a.a.a.b.a.a.b.c().e()) == 0) {
                c0039a.u();
                c0039a.s.setTag(c2.k());
                return;
            }
            c0039a.v.setScaleType(ImageView.ScaleType.FIT_CENTER);
            C0622wb a2 = a(c2, ACUserAssetType.kImage);
            if (a2 == null) {
                C0622wb a3 = a(c2, ACUserAssetType.kColorTheme);
                if (a3 != null) {
                    c.a.a.a.a.b.a.b.a.e.b.d a4 = c.a.a.a.a.b.a.b.a.e.a.a.a(c2, a3);
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    Iterator<c.a.a.a.a.b.a.b.a.e.b.a> it = a4.f3444a.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Integer.valueOf(it.next().a()));
                    }
                    c0039a.a(arrayList);
                    c0039a.s.setTag(c2.k());
                    return;
                }
                C0622wb a5 = a(c2, ACUserAssetType.kColor);
                if (a5 != null) {
                    c0039a.c(C0551eb.a(a5, c2).intValue());
                    c0039a.s.setTag(c2.k());
                    return;
                }
                a2 = a(c2, ACUserAssetType.kBrush);
                if (a2 == null && (a2 = a(c2, ACUserAssetType.kCharStyle)) == null && (a2 = a(c2, ACUserAssetType.kLayerStyle)) == null && (a2 = a(c2, ACUserAssetType.kLooks)) == null && (a2 = a(c2, ACUserAssetType.KPattern)) == null && (a2 = a(c2, ACUserAssetType.kTemplate)) == null && (a2 = a(c2, ACUserAssetType.k3DMaterial)) == null && (a2 = a(c2, ACUserAssetType.k3DLight)) == null && (a2 = a(c2, ACUserAssetType.k3DModel)) == null) {
                    a2 = a(c2, ACUserAssetType.kAnimation);
                }
            }
            C0582ma c0582ma = new C0582ma(450.0f, 0.0f);
            if (a2 != null) {
                if (a2.j().equals("application/vnd.adobe.element.characterstyle+dcx")) {
                    c0039a.v.setScaleType(ImageView.ScaleType.CENTER);
                }
                BitmapDrawable c3 = C0500yc.this.r.c(a2.c());
                if (c3 == null) {
                    c.a.a.a.a.b.a.c.e.a(c.a.a.a.a.b.a.c.e.a(a2, C0500yc.this.q, C0500yc.this.b(), true), c2, a2, new C0496xc(this, c0039a, c2, a2, c0582ma), new Handler(Looper.getMainLooper()));
                    return;
                } else {
                    c0039a.a(c3);
                    c0039a.s.setTag(c2.k());
                    return;
                }
            }
            c0039a.a((BitmapDrawable) null);
            c0039a.s.setTag(c2.k());
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C0039a(LayoutInflater.from(this.f6544c).inflate(c.a.a.a.b.g.adobe_library_collection_cell, viewGroup, false));
        }

        private C0622wb a(C0614ub c0614ub, ACUserAssetType aCUserAssetType) {
            ArrayList<C0622wb> a2 = com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.core.a.a().a(aCUserAssetType).a(c0614ub);
            C0482uc c0482uc = new C0482uc(this);
            if (a2 == null || a2.size() <= 0) {
                return null;
            }
            Collections.sort(a2, c0482uc);
            return a2.get(0);
        }
    }

    public C0500yc(Context context) {
        super(context);
        this.m = -1;
    }

    public static boolean s() {
        return k;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb
    public void e() {
        q();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb
    public void f() {
        q();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected SwipeRefreshLayout l() {
        return this.f6415f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        this.o.h();
        this.o.notifyDataSetChanged();
    }

    public void r() {
        a(this.o.f() <= 0);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected RecyclerView.LayoutManager b(Context context) {
        this.q = com.adobe.creativesdk.foundation.internal.utils.q.a(b());
        return new GridLayoutManager(TwoWayLayoutManager.Orientation.VERTICAL, this.q, 1);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected View c(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(c.a.a.a.b.g.adobe_assets_library_items_view, new FrameLayout(context));
        this.f6415f = (SwipeRefreshLayout) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_asset_libraryitemsview_swipe_refresh_layout);
        this.n = (TwoWayView) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_asset_library_design_items_twowayview);
        return inflate;
    }

    public void a(C0514m c0514m) {
        this.l = c0514m;
    }

    public static void b(boolean z) {
        k = z;
    }

    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar) {
        this.r = fVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    public RecyclerView a(Context context) {
        return this.n;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected RecyclerView.ItemDecoration a(RecyclerView recyclerView, Context context) {
        int dimensionPixelSize = b().getResources().getDimensionPixelSize(c.a.a.a.b.c.adobe_csdk_library_items_spacing_size);
        this.p = new com.adobe.creativesdk.foundation.internal.storage.controllers.b.b(dimensionPixelSize, dimensionPixelSize);
        this.q = com.adobe.creativesdk.foundation.internal.utils.q.a(b());
        this.p.a(this.q);
        return this.p;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected RecyclerView.Adapter<RecyclerView.ViewHolder> a(Context context, RecyclerView recyclerView) {
        this.o = new a(context);
        return this.o;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected void a(View view, int i) {
        InterfaceC0362ad interfaceC0362ad;
        C0614ub c2 = this.o.c(i);
        if (c2 == null || (interfaceC0362ad = this.f6373b.get()) == null) {
            return;
        }
        interfaceC0362ad.a(a(c2));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected void a(int i, View view) {
        InterfaceC0362ad interfaceC0362ad;
        C0614ub c2 = this.o.c(i);
        if (c2 == null || (interfaceC0362ad = this.f6373b.get()) == null) {
            return;
        }
        interfaceC0362ad.a(c2, view);
    }

    protected com.adobe.creativesdk.foundation.internal.storage.controllers.commands.d a(C0614ub c0614ub) {
        com.adobe.creativesdk.foundation.internal.storage.controllers.commands.f fVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.commands.f();
        fVar.a(c0614ub.k());
        fVar.b(c0614ub.m());
        fVar.a(c0614ub);
        return fVar;
    }

    public void a(String str) {
        a aVar = this.o;
        aVar.f6547f = true;
        aVar.f6548g = str;
        e();
        r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, C0614ub c0614ub) {
        String string;
        ImageView imageView = (ImageView) view.findViewById(c.a.a.a.b.e.adobe_csdk_library_collection_cell_shared_folder_icon);
        TextView textView = (TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_library_collection_cell_main_title);
        TextView textView2 = (TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_library_collection_cell_count_text);
        textView.setText(c0614ub.m());
        int a2 = c0614ub.a(c.a.a.a.a.b.a.a.b.c().e());
        if (a2 != 1) {
            string = String.format(b().getString(c.a.a.a.b.i.adobe_csdk_design_library_collection_count), Integer.toString(a2));
        } else {
            string = b().getString(c.a.a.a.b.i.adobe_csdk_design_library_collection_count_single);
        }
        textView2.setText(string);
        imageView.setVisibility(0);
        if (c0614ub.p()) {
            imageView.setImageResource(c.a.a.a.b.d.ic_library_bookmark);
            return;
        }
        if (c0614ub.r()) {
            if (c0614ub.q()) {
                imageView.setImageResource(c.a.a.a.b.d.ic_vector_asset_folder_ro);
                return;
            } else {
                imageView.setImageResource(c.a.a.a.b.d.ic_vector_asset_folder_shared);
                return;
            }
        }
        imageView.setImageResource(c.a.a.a.b.d.ic_vector_asset_library);
    }
}
