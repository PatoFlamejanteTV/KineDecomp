package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.internal.storage.C0507f;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0436ld;
import com.adobe.creativesdk.foundation.internal.twowayview.TwoWayLayoutManager;
import com.adobe.creativesdk.foundation.internal.twowayview.widget.GridLayoutManager;
import com.adobe.creativesdk.foundation.storage.AdobeAssetDataSourceType;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFileRenditionType;
import com.adobe.creativesdk.foundation.storage.AdobeAssetPackagePages;
import com.adobe.creativesdk.foundation.storage.C0533a;
import com.adobe.creativesdk.foundation.storage.C0545d;
import com.adobe.creativesdk.foundation.storage.C0547db;
import com.adobe.creativesdk.foundation.storage.C0561h;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: CompositionsListView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.oc */
/* loaded from: classes.dex */
public class C0453oc extends C0436ld {

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: CompositionsListView.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.oc$a */
    /* loaded from: classes.dex */
    public class a extends C0436ld.a {
        private final Context i;
        ArrayList<AdobeAssetPackagePages> j;
        private Boolean k;

        /* compiled from: CompositionsListView.java */
        /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.oc$a$a */
        /* loaded from: classes.dex */
        public class C0036a extends RecyclerView.ViewHolder {
            ImageView A;
            View s;
            ImageView t;
            TextView u;
            TextView v;
            TextView w;
            AdobeAssetPackagePages x;
            ImageView y;
            RelativeLayout z;

            public C0036a(View view) {
                super(view);
                this.s = view;
                this.t = (ImageView) view.findViewById(c.a.a.a.b.e.adobe_csdk_composition_cell_mainImage);
                this.u = (TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_compositio_cell_main_title);
                this.v = (TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_composition_cell_count_text);
                this.w = (TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_composition_cell_modification_date);
                this.w.setVisibility(8);
                this.y = (ImageView) view.findViewById(c.a.a.a.b.e.adobe_csdk_composition_package_icon);
                this.z = (RelativeLayout) view.findViewById(c.a.a.a.b.e.adobe_composition_menu_icon_layout);
                this.A = (ImageView) view.findViewById(c.a.a.a.b.e.adobe_composition_menu_icon);
                if (a.this.k.booleanValue()) {
                    return;
                }
                this.z.setVisibility(8);
            }

            public static /* synthetic */ void a(C0036a c0036a, long j, BitmapDrawable bitmapDrawable) {
                c0036a.a(j, bitmapDrawable);
            }

            public void b(AdobeAssetPackagePages adobeAssetPackagePages) {
                String format;
                AdobeAssetDataSourceType a2 = C0416hd.a(adobeAssetPackagePages);
                if (a2 == AdobeAssetDataSourceType.AdobeAssetDataSourcePSMix) {
                    format = String.format("%s", com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_psmix_collection_singular));
                } else {
                    format = a2 == AdobeAssetDataSourceType.AdobeAssetDataSourcePSFix ? String.format("%s", com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_psfix_collection_singular)) : null;
                }
                this.v.setText(format);
            }

            public void c(AdobeAssetPackagePages adobeAssetPackagePages) {
                this.x = adobeAssetPackagePages;
            }

            public AdobeAssetPackagePages t() {
                return this.x;
            }

            public void u() {
                this.t.setImageResource(c.a.a.a.b.d.empty_folder);
            }

            public void a(long j, BitmapDrawable bitmapDrawable) {
                if (j == 0) {
                    this.t.setVisibility(0);
                    this.t.setImageDrawable(bitmapDrawable);
                }
            }

            public void a(String str) {
                this.u.setText(str);
            }

            public void a(AdobeAssetPackagePages adobeAssetPackagePages) {
                AdobeAssetDataSourceType a2 = C0416hd.a(adobeAssetPackagePages);
                Drawable bitmapDrawable = new BitmapDrawable();
                if (a2 == AdobeAssetDataSourceType.AdobeAssetDataSourcePSMix) {
                    bitmapDrawable = com.adobe.creativesdk.foundation.internal.utils.l.a(c.a.a.a.b.d.mobile_creation_mix);
                } else if (a2 == AdobeAssetDataSourceType.AdobeAssetDataSourcePSFix) {
                    bitmapDrawable = com.adobe.creativesdk.foundation.internal.utils.l.a(c.a.a.a.b.d.mobile_creations_psfix);
                }
                this.y.setImageDrawable(bitmapDrawable);
            }

            public void b(View.OnClickListener onClickListener) {
                this.z.setOnClickListener(onClickListener);
            }

            public void a(View.OnClickListener onClickListener) {
                this.s.setOnClickListener(onClickListener);
            }
        }

        public a(Context context) {
            super(context);
            this.i = context;
            this.j = null;
            this.k = Boolean.valueOf(C0455p.b(C0453oc.this.b()));
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0436ld.a
        public AdobeAssetPackagePages c(int i) {
            ArrayList<AdobeAssetPackagePages> h2 = h();
            if (h2 == null || i < 0 || i >= h2.size()) {
                return null;
            }
            return h2.get(i);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0436ld.a
        protected int f() {
            if (h() != null) {
                return h().size();
            }
            return 0;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0436ld.a
        public void g() {
            this.j = null;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0436ld.a, android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            AdobeAssetDataSourceType adobeAssetDataSourceType = C0453oc.this.l;
            if (adobeAssetDataSourceType != AdobeAssetDataSourceType.AdobeAssetDataSourceDraw && adobeAssetDataSourceType != AdobeAssetDataSourceType.AdobeAssetDataSourceSketches && adobeAssetDataSourceType != AdobeAssetDataSourceType.AdobeAssetDataSourceCompositions) {
                return f();
            }
            return super.getItemCount();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            AdobeAssetDataSourceType a2 = C0416hd.a(c(i));
            return (a2 == AdobeAssetDataSourceType.AdobeAssetDataSourceDraw || a2 == AdobeAssetDataSourceType.AdobeAssetDataSourceSketches || a2 == AdobeAssetDataSourceType.AdobeAssetDataSourceCompositions) ? 0 : 1;
        }

        protected ArrayList<AdobeAssetPackagePages> h() {
            C0507f c0507f;
            if (this.j == null && (c0507f = C0453oc.this.k) != null) {
                ArrayList<C0533a> a2 = this.f6182e ? c0507f.a(this.f6183f) : c0507f.d();
                this.j = new ArrayList<>();
                if (a2 != null) {
                    Iterator<C0533a> it = a2.iterator();
                    while (it.hasNext()) {
                        C0533a next = it.next();
                        if (next instanceof com.adobe.creativesdk.foundation.storage.Ya) {
                            this.j.add((AdobeAssetPackagePages) next);
                        }
                    }
                }
            }
            return this.j;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0436ld.a, android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            AdobeAssetPackagePages c2 = c(i);
            AdobeAssetDataSourceType a2 = C0416hd.a(c2);
            if (a2 != AdobeAssetDataSourceType.AdobeAssetDataSourceDraw && a2 != AdobeAssetDataSourceType.AdobeAssetDataSourceSketches && a2 != AdobeAssetDataSourceType.AdobeAssetDataSourceCompositions) {
                C0036a c0036a = (C0036a) viewHolder;
                c0036a.a(c2.getName());
                c0036a.b(c2);
                c0036a.c(c2);
                c0036a.a(c2);
                if (c2.j() != null && c2.j().size() != 0) {
                    c0036a.a((View.OnClickListener) new AbstractC0476tb.a(i));
                    this.k = Boolean.valueOf(C0455p.b(C0453oc.this.b()));
                    if (this.k.booleanValue()) {
                        C0453oc c0453oc = C0453oc.this;
                        c0453oc.f6417h = new AbstractC0476tb.b(i);
                        c0036a.b(C0453oc.this.f6417h);
                    }
                    ArrayList arrayList = new ArrayList(c2.j());
                    com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ba ba = new com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ba();
                    ba.f4127a = 0L;
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        AdobeAssetFile adobeAssetFile = (AdobeAssetFile) it.next();
                        BitmapDrawable c3 = C0453oc.this.q.c(adobeAssetFile.getGUID() + adobeAssetFile.getMd5Hash());
                        if (c3 != null) {
                            c0036a.a(arrayList.indexOf(adobeAssetFile), c3);
                        } else {
                            adobeAssetFile.getRenditionWithType(AdobeAssetFileRenditionType.ADOBE_ASSET_FILE_RENDITION_TYPE_PNG, AbstractC0452ob.a(com.adobe.creativesdk.foundation.internal.storage.model.util.c.f6622b), new C0448nc(this, adobeAssetFile, c0036a, c2, arrayList));
                        }
                        ba.f4127a++;
                        if (ba.f4127a > 3) {
                            return;
                        }
                    }
                    return;
                }
                c0036a.u();
                return;
            }
            super.onBindViewHolder(viewHolder, i);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0436ld.a, android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return super.onCreateViewHolder(viewGroup, i);
            }
            return new C0036a(LayoutInflater.from(this.i).inflate(c.a.a.a.b.g.adobe_composition_cell, viewGroup, false));
        }
    }

    public C0453oc(Context context) {
        super(context);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected RecyclerView.Adapter<RecyclerView.ViewHolder> a(Context context, RecyclerView recyclerView) {
        this.n = new a(context);
        return this.n;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected RecyclerView.LayoutManager b(Context context) {
        this.p = com.adobe.creativesdk.foundation.internal.utils.q.a(b());
        return new GridLayoutManager(TwoWayLayoutManager.Orientation.VERTICAL, this.p, 1);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0436ld, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    public void a(View view, int i) {
        AdobeAssetPackagePages c2 = this.n.c(i);
        if ((c2 instanceof C0561h) || (c2 instanceof C0547db) || (c2 instanceof C0545d)) {
            super.a(view, i);
            return;
        }
        if (c2 == null) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.storage.controllers.utils.g gVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.utils.g();
        gVar.f6498a = c2;
        gVar.f6500c = c2.j();
        gVar.f6499b = i;
        InterfaceC0362ad interfaceC0362ad = this.f6373b.get();
        if (interfaceC0362ad != null) {
            interfaceC0362ad.a(gVar);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0436ld
    protected com.adobe.creativesdk.foundation.internal.storage.controllers.commands.d a(AdobeAssetPackagePages adobeAssetPackagePages) {
        com.adobe.creativesdk.foundation.internal.storage.controllers.commands.g gVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.commands.g();
        gVar.a(adobeAssetPackagePages.getGUID());
        gVar.c(adobeAssetPackagePages.getName());
        gVar.b(adobeAssetPackagePages.getHref().toString());
        gVar.d(adobeAssetPackagePages.getParentHref().toString());
        gVar.a(adobeAssetPackagePages);
        if (adobeAssetPackagePages instanceof C0561h) {
            gVar.a(AdobeAssetDataSourceType.AdobeAssetDataSourceDraw);
        } else if (adobeAssetPackagePages instanceof C0547db) {
            gVar.a(AdobeAssetDataSourceType.AdobeAssetDataSourceSketches);
        } else if (adobeAssetPackagePages instanceof C0545d) {
            gVar.a(AdobeAssetDataSourceType.AdobeAssetDataSourceCompositions);
        }
        return gVar;
    }
}
