package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
import com.adobe.creativesdk.foundation.internal.storage.C0507f;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb;
import com.adobe.creativesdk.foundation.internal.twowayview.widget.TwoWayView;
import com.adobe.creativesdk.foundation.storage.AdobeAssetDataSourceType;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFileRenditionType;
import com.adobe.creativesdk.foundation.storage.AdobeAssetPackagePages;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: MobileCreationPackageCollectionListView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.ld */
/* loaded from: classes.dex */
public class C0436ld extends AbstractC0476tb {
    C0507f k;
    AdobeAssetDataSourceType l;
    TwoWayView m;
    a n;
    com.adobe.creativesdk.foundation.internal.storage.controllers.b.b o;
    int p;
    com.adobe.creativesdk.foundation.internal.storage.controllers.a.f q;

    /* compiled from: MobileCreationPackageCollectionListView.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.ld$a */
    /* loaded from: classes.dex */
    public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: c */
        private final Context f6180c;

        /* renamed from: g */
        private Boolean f6184g;

        /* renamed from: e */
        boolean f6182e = false;

        /* renamed from: f */
        String f6183f = "";

        /* renamed from: d */
        ArrayList<AdobeAssetPackagePages> f6181d = null;

        /* compiled from: MobileCreationPackageCollectionListView.java */
        /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.ld$a$a */
        /* loaded from: classes.dex */
        public class C0033a extends RecyclerView.ViewHolder {
            TextView A;
            TextView B;
            LinearLayout C;
            AdobeAssetPackagePages D;
            View s;
            ImageView t;
            ImageView u;
            ImageView v;
            ImageView w;
            ImageView x;
            ImageView y;
            RelativeLayout z;

            public C0033a(View view) {
                super(view);
                this.s = view;
                this.t = (ImageView) view.findViewById(c.a.a.a.b.e.adobe_csdk_mobilecreation_package_mainImage);
                this.u = (ImageView) view.findViewById(c.a.a.a.b.e.adobe_csdk_mobilecreation_package_secondImage);
                this.v = (ImageView) view.findViewById(c.a.a.a.b.e.adobe_csdk_mobilecreation_package_thirdImage);
                this.w = (ImageView) view.findViewById(c.a.a.a.b.e.adobe_csdk_mobilecreation_package_FourthImage);
                this.A = (TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_mobilecreation_package_cell_main_title);
                this.B = (TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_mobilecreation_package_cell_count_text);
                this.C = (LinearLayout) view.findViewById(c.a.a.a.b.e.adobe_csdk_mobilecreation_package_threeImages);
                this.x = (ImageView) view.findViewById(c.a.a.a.b.e.adobe_csdk_mobilecreation_package_icon);
                this.y = (ImageView) view.findViewById(c.a.a.a.b.e.adobe_csdk_mobile_creation_menu_icon);
                this.z = (RelativeLayout) view.findViewById(c.a.a.a.b.e.adobe_mobile_creation_menu_icon_layout);
                a.this.f6184g = Boolean.valueOf(C0455p.b(C0436ld.this.b()));
                if (a.this.f6184g.booleanValue()) {
                    return;
                }
                this.z.setVisibility(8);
            }

            public static /* synthetic */ void a(C0033a c0033a, long j, BitmapDrawable bitmapDrawable) {
                c0033a.a(j, bitmapDrawable);
            }

            public void b(AdobeAssetPackagePages adobeAssetPackagePages) {
                String format;
                int size = adobeAssetPackagePages.j() == null ? 0 : adobeAssetPackagePages.j().size();
                AdobeAssetDataSourceType a2 = C0416hd.a(adobeAssetPackagePages);
                if (size == 1) {
                    if (a2 == AdobeAssetDataSourceType.AdobeAssetDataSourceDraw) {
                        format = String.format("%s %s", Integer.toString(size), com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_lineordrawcollection_singular));
                    } else if (a2 == AdobeAssetDataSourceType.AdobeAssetDataSourceSketches) {
                        format = String.format("%s", com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_sketchCollection_single_sketch));
                    } else if (a2 == AdobeAssetDataSourceType.AdobeAssetDataSourcePSMix) {
                        format = String.format("%s", com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_psmix_collection_singular));
                    } else if (a2 == AdobeAssetDataSourceType.AdobeAssetDataSourceCompositions) {
                        format = String.format("%s", com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_comp_collection_singular));
                    } else {
                        if (a2 == AdobeAssetDataSourceType.AdobeAssetDataSourcePSFix) {
                            format = String.format("%s", com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_psfix_collection_singular));
                        }
                        format = null;
                    }
                } else if (a2 == AdobeAssetDataSourceType.AdobeAssetDataSourceDraw) {
                    format = String.format("%s %s", Integer.toString(size), com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_lineordrawcollection_plural));
                } else if (a2 == AdobeAssetDataSourceType.AdobeAssetDataSourceSketches) {
                    format = String.format("%1$s %2$s", Integer.toString(size), com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_sketchCollection_plural));
                } else if (a2 == AdobeAssetDataSourceType.AdobeAssetDataSourcePSMix) {
                    format = String.format("%s", com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_psmix_collection_singular));
                } else if (a2 == AdobeAssetDataSourceType.AdobeAssetDataSourceCompositions) {
                    format = String.format("%s %s", Integer.toString(size), com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_comp_collection_plural));
                } else {
                    if (a2 == AdobeAssetDataSourceType.AdobeAssetDataSourcePSFix) {
                        format = String.format("%s", com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_psfix_collection_singular));
                    }
                    format = null;
                }
                this.B.setText(format);
            }

            public void c(AdobeAssetPackagePages adobeAssetPackagePages) {
                this.D = adobeAssetPackagePages;
            }

            public AdobeAssetPackagePages t() {
                return this.D;
            }

            public void u() {
                this.t.setScaleType(ImageView.ScaleType.CENTER);
                this.t.setVisibility(0);
                this.t.setImageResource(c.a.a.a.b.d.empty_folder);
                this.u.setVisibility(8);
                this.v.setVisibility(8);
                this.w.setVisibility(8);
            }

            public void a(long j, BitmapDrawable bitmapDrawable) {
                if (j == 0) {
                    this.t.setVisibility(0);
                    this.t.setImageDrawable(bitmapDrawable);
                    return;
                }
                if (j == 1) {
                    this.u.setVisibility(0);
                    this.u.setImageDrawable(bitmapDrawable);
                } else if (j == 2) {
                    this.v.setVisibility(0);
                    this.v.setImageDrawable(bitmapDrawable);
                } else if (j == 3) {
                    this.w.setVisibility(0);
                    this.w.setImageDrawable(bitmapDrawable);
                }
            }

            public void a(String str) {
                this.A.setText(str);
            }

            public void a(AdobeAssetPackagePages adobeAssetPackagePages) {
                AdobeAssetDataSourceType a2 = C0416hd.a(adobeAssetPackagePages);
                Drawable bitmapDrawable = new BitmapDrawable();
                if (a2 == AdobeAssetDataSourceType.AdobeAssetDataSourceDraw) {
                    bitmapDrawable = com.adobe.creativesdk.foundation.internal.utils.l.a(c.a.a.a.b.d.mobile_creation_draw);
                } else if (a2 == AdobeAssetDataSourceType.AdobeAssetDataSourceSketches) {
                    bitmapDrawable = com.adobe.creativesdk.foundation.internal.utils.l.a(c.a.a.a.b.d.mobile_creation_sketch);
                } else if (a2 == AdobeAssetDataSourceType.AdobeAssetDataSourceCompositions) {
                    bitmapDrawable = com.adobe.creativesdk.foundation.internal.utils.l.a(c.a.a.a.b.d.mobile_creation_comp);
                }
                this.x.setImageDrawable(bitmapDrawable);
            }

            public void a(View.OnClickListener onClickListener) {
                this.s.setOnClickListener(onClickListener);
            }

            public void b(View.OnClickListener onClickListener) {
                this.z.setOnClickListener(onClickListener);
            }
        }

        public a(Context context) {
            this.f6180c = context;
        }

        public AdobeAssetPackagePages c(int i) {
            throw null;
        }

        protected int f() {
            throw null;
        }

        public void g() {
            throw null;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return f();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            C0033a c0033a = (C0033a) viewHolder;
            AdobeAssetPackagePages c2 = c(i);
            c0033a.a(c2.getName());
            c0033a.b(c2);
            c0033a.c(c2);
            c0033a.a(c2);
            if (!(c2 instanceof com.adobe.creativesdk.foundation.storage.Ua) && !(c2 instanceof com.adobe.creativesdk.foundation.storage.Ra)) {
                c0033a.C.setVisibility(0);
            } else {
                c0033a.C.setVisibility(8);
            }
            c0033a.a((View.OnClickListener) new AbstractC0476tb.a(i));
            this.f6184g = Boolean.valueOf(C0455p.b(C0436ld.this.b()));
            if (this.f6184g.booleanValue()) {
                C0436ld c0436ld = C0436ld.this;
                c0436ld.f6417h = new AbstractC0476tb.b(i);
                c0033a.b(C0436ld.this.f6417h);
            }
            if (c2.j() != null && c2.j().size() != 0) {
                ArrayList arrayList = new ArrayList(c2.j());
                com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ba ba = new com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ba();
                ba.f4127a = 0L;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    AdobeAssetFile adobeAssetFile = (AdobeAssetFile) it.next();
                    BitmapDrawable c3 = C0436ld.this.q.c(adobeAssetFile.getGUID() + adobeAssetFile.getMd5Hash());
                    if (c3 != null) {
                        c0033a.a(arrayList.indexOf(adobeAssetFile), c3);
                    } else {
                        adobeAssetFile.getRenditionWithType(AdobeAssetFileRenditionType.ADOBE_ASSET_FILE_RENDITION_TYPE_PNG, AbstractC0452ob.a(com.adobe.creativesdk.foundation.internal.storage.model.util.c.f6622b), new C0431kd(this, adobeAssetFile, c0033a, c2, arrayList));
                    }
                    ba.f4127a++;
                    if (ba.f4127a > 3) {
                        break;
                    }
                }
                if (arrayList.size() < 4) {
                    int size = arrayList.size();
                    if (size == 1) {
                        c0033a.u.setImageDrawable(null);
                        c0033a.v.setImageDrawable(null);
                        c0033a.w.setImageDrawable(null);
                        return;
                    } else if (size == 2) {
                        c0033a.v.setImageDrawable(null);
                        c0033a.w.setImageDrawable(null);
                        return;
                    } else {
                        if (size != 3) {
                            return;
                        }
                        c0033a.w.setImageDrawable(null);
                        return;
                    }
                }
                return;
            }
            c0033a.u();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C0033a(LayoutInflater.from(this.f6180c).inflate(c.a.a.a.b.g.adobe_mobilecreation_package_cell, viewGroup, false));
        }
    }

    public C0436ld(Context context) {
        super(context);
    }

    private void r() {
        this.n.g();
        this.n.notifyDataSetChanged();
    }

    protected com.adobe.creativesdk.foundation.internal.storage.controllers.commands.d a(AdobeAssetPackagePages adobeAssetPackagePages) {
        throw null;
    }

    public void a(C0507f c0507f) {
        this.k = c0507f;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected View c(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(c.a.a.a.b.g.adobe_assets_mobilecreations_items_view, new FrameLayout(context));
        this.f6415f = (SwipeRefreshLayout) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_asset_mobilecreations_itemsview_swipe_refresh_layout);
        this.m = (TwoWayView) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_asset_mobilecreations_items_twowayview);
        return inflate;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb
    public void e() {
        r();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb
    public void f() {
        r();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected SwipeRefreshLayout l() {
        return this.f6415f;
    }

    public void q() {
        a(this.n.getItemCount() <= 0);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    public RecyclerView a(Context context) {
        return this.m;
    }

    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar) {
        this.q = fVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected RecyclerView.ItemDecoration a(RecyclerView recyclerView, Context context) {
        int dimensionPixelSize = b().getResources().getDimensionPixelSize(c.a.a.a.b.c.adobe_csdk_library_items_spacing_size);
        this.o = new com.adobe.creativesdk.foundation.internal.storage.controllers.b.b(dimensionPixelSize, dimensionPixelSize);
        this.p = com.adobe.creativesdk.foundation.internal.utils.q.a(b());
        this.o.a(this.p);
        return this.o;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    public void a(View view, int i) {
        InterfaceC0362ad interfaceC0362ad;
        AdobeAssetPackagePages c2 = this.n.c(i);
        if (c2 == null || (interfaceC0362ad = this.f6373b.get()) == null) {
            return;
        }
        interfaceC0362ad.a(a(c2));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected void a(int i, View view) {
        InterfaceC0362ad interfaceC0362ad;
        AdobeAssetPackagePages c2 = this.n.c(i);
        if (c2 == null || (interfaceC0362ad = this.f6373b.get()) == null) {
            return;
        }
        interfaceC0362ad.a(c2, view);
    }

    public void a(String str) {
        a aVar = this.n;
        aVar.f6182e = true;
        aVar.f6183f = str;
        e();
        q();
    }
}
