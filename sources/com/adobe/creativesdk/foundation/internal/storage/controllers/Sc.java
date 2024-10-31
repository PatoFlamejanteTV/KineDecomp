package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.adobe.creativesdk.foundation.adobeinternal.storage.library.C0288q;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb;
import com.adobe.creativesdk.foundation.internal.storage.controllers.b.a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.upload.AdobeUploadAssetData;
import com.adobe.creativesdk.foundation.internal.storage.controllers.utils.AdobeWaterFallLayoutManager;
import com.adobe.creativesdk.foundation.internal.twowayview.widget.StaggeredGridLayoutManager;
import com.adobe.creativesdk.foundation.internal.twowayview.widget.TwoWayView;
import com.adobe.creativesdk.foundation.storage.AdobeAssetDesignLibraryItemType;
import com.adobe.creativesdk.foundation.storage.C0549e;
import com.adobe.creativesdk.foundation.storage.C0551eb;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: DesignLibraryItemsListView.java */
/* loaded from: classes.dex */
public class Sc extends AbstractC0476tb {
    private static final String k = "Sc";
    private ArrayList<C0622wb> A;
    private ArrayList<C0622wb> B;
    private ArrayList<C0622wb> C;
    private com.adobe.creativesdk.foundation.internal.storage.controllers.b.b D;
    private C0485v E;
    private com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa> F;
    private a G;
    com.adobe.creativesdk.foundation.internal.storage.controllers.a.f H;
    private final int I;
    private final int J;
    private final int K;
    private final int L;
    private final int M;
    private final int N;
    private final int O;
    private final int P;
    private final int Q;
    private final int R;
    private final int S;
    private final int T;
    private final int U;
    private final int V;
    private final int W;
    private C0614ub l;
    private TwoWayView m;
    private AdobeWaterFallLayoutManager n;
    private c o;
    private ArrayList<AdobeUploadAssetData> p;
    private ArrayList<C0622wb> q;
    private ArrayList<C0622wb> r;
    private ArrayList<C0622wb> s;
    private ArrayList<C0622wb> t;
    private ArrayList<C0622wb> u;
    private ArrayList<C0622wb> v;
    private ArrayList<C0622wb> w;
    private ArrayList<C0622wb> x;
    private ArrayList<C0622wb> y;
    private ArrayList<C0622wb> z;

    /* compiled from: DesignLibraryItemsListView.java */
    /* loaded from: classes.dex */
    public static class b extends com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z {
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z
        protected RelativeLayout B() {
            return (RelativeLayout) g().findViewById(c.a.a.a.b.e.adobe_csdk_library_image_progressbar_container);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
        public void t() {
            A();
            this.l = (ImageView) g().findViewById(c.a.a.a.b.e.adobe_csdk_library_items_imagecollection_image);
        }
    }

    /* compiled from: DesignLibraryItemsListView.java */
    /* loaded from: classes.dex */
    public abstract class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: c, reason: collision with root package name */
        private final Context f5832c;

        /* renamed from: e, reason: collision with root package name */
        private LayoutInflater f5834e;

        /* renamed from: d, reason: collision with root package name */
        private boolean f5833d = false;

        /* renamed from: f, reason: collision with root package name */
        private SparseArray<b> f5835f = new SparseArray<>();

        /* renamed from: g, reason: collision with root package name */
        private int f5836g = 0;

        /* compiled from: DesignLibraryItemsListView.java */
        /* loaded from: classes.dex */
        public class a {

            /* renamed from: a, reason: collision with root package name */
            public int f5838a;

            /* renamed from: b, reason: collision with root package name */
            public int f5839b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f5840c;

            public a() {
            }
        }

        /* compiled from: DesignLibraryItemsListView.java */
        /* loaded from: classes.dex */
        public class b {

            /* renamed from: a, reason: collision with root package name */
            int f5842a;

            /* renamed from: b, reason: collision with root package name */
            int f5843b;

            public b(int i) {
                this.f5842a = i;
            }
        }

        public d(Context context) {
            this.f5834e = (LayoutInflater) context.getSystemService("layout_inflater");
            this.f5832c = context;
        }

        private void i() {
            if (this.f5833d) {
                return;
            }
            int f2 = f();
            b[] bVarArr = new b[f2];
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < f2; i3++) {
                bVarArr[i3] = new b(i2);
                int d2 = d(i3);
                i2 += d2;
                i += d2;
            }
            this.f5836g = i + f2;
            a(bVarArr);
            this.f5833d = true;
        }

        protected abstract RecyclerView.ViewHolder a(ViewGroup viewGroup, int i);

        protected abstract void a(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3);

        protected abstract void a(RecyclerView.ViewHolder viewHolder, a aVar);

        public void a(b[] bVarArr) {
            this.f5835f.clear();
            Arrays.sort(bVarArr, new Wc(this));
            int i = 0;
            for (b bVar : bVarArr) {
                bVar.f5843b = bVar.f5842a + i;
                this.f5835f.append(bVar.f5843b, bVar);
                i++;
            }
            notifyDataSetChanged();
        }

        protected abstract int b(int i, int i2);

        protected abstract void b(RecyclerView.ViewHolder viewHolder, int i);

        public a c(int i) {
            int i2;
            int size = this.f5835f.size() - 1;
            boolean z = false;
            int i3 = 0;
            while (true) {
                i2 = -1;
                if (size < 0) {
                    size = i3;
                    break;
                }
                int i4 = this.f5835f.valueAt(size).f5843b;
                if (i4 == i) {
                    z = true;
                    break;
                }
                if (i4 < i) {
                    i2 = (i - i4) - 1;
                    break;
                }
                i3 = size;
                size--;
            }
            a aVar = new a();
            aVar.f5838a = size;
            aVar.f5839b = i2;
            aVar.f5840c = z;
            return aVar;
        }

        protected abstract int d(int i);

        protected abstract int e(int i);

        protected abstract int f();

        protected int g() {
            int f2 = f();
            int i = 0;
            for (int i2 = 0; i2 < f2; i2++) {
                i += d(i2);
            }
            this.f5836g = i + f2;
            return this.f5836g;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return g();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            a c2 = c(i);
            if (c2.f5840c) {
                return e(c2.f5838a);
            }
            return b(c2.f5838a, c2.f5839b);
        }

        public void h() {
            this.f5833d = false;
            i();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            a c2 = c(i);
            if (c2.f5840c) {
                b(viewHolder, c2.f5838a);
            } else {
                a(viewHolder, c2.f5838a, c2.f5839b, i);
            }
            a(viewHolder, c2);
            viewHolder.itemView.setTag(viewHolder);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return a(viewGroup, i);
        }
    }

    public Sc(Context context) {
        super(context);
        this.G = new a(this, null);
        this.I = 0;
        this.J = 1;
        this.K = 2;
        this.L = 3;
        this.M = 33;
        this.N = 4;
        this.O = 5;
        this.P = 6;
        this.Q = 7;
        this.R = 8;
        this.S = 9;
        this.T = 10;
        this.U = 11;
        this.V = 12;
        this.W = 13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u() {
        ArrayList<AdobeUploadAssetData> arrayList = this.p;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        x();
    }

    private boolean w() {
        return C0455p.b(b());
    }

    private void x() {
        Oc oc = new Oc(this);
        Collections.sort(this.q, oc);
        Collections.sort(this.r, oc);
        Collections.sort(this.s, oc);
        Collections.sort(this.t, oc);
        Collections.sort(this.u, oc);
        Collections.sort(this.v, oc);
        Collections.sort(this.w, oc);
        Collections.sort(this.x, oc);
        Collections.sort(this.y, oc);
        Collections.sort(this.z, oc);
        Collections.sort(this.A, oc);
        Collections.sort(this.B, oc);
        Collections.sort(this.C, oc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DesignLibraryItemsListView.java */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        Map<String, Observer> f5825a;

        private a() {
            this.f5825a = new HashMap();
        }

        public void a() {
            for (Map.Entry<String, Observer> entry : this.f5825a.entrySet()) {
                AdobeUploadAssetData adobeUploadAssetData = new AdobeUploadAssetData();
                adobeUploadAssetData.f5272a = entry.getKey();
                Sc.this.F.b(adobeUploadAssetData, entry.getValue());
            }
            this.f5825a.clear();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void b(AdobeUploadAssetData adobeUploadAssetData, com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z zVar) {
            ((Activity) Sc.this.f6372a).runOnUiThread(new Qc(this, zVar, adobeUploadAssetData));
        }

        /* synthetic */ a(Sc sc, Oc oc) {
            this();
        }

        public void a(AdobeUploadAssetData adobeUploadAssetData, com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z zVar) {
            a(adobeUploadAssetData);
            Rc rc = new Rc(this, zVar);
            this.f5825a.put(adobeUploadAssetData.f5272a, rc);
            Sc.this.F.a(adobeUploadAssetData, rc);
            b(adobeUploadAssetData, zVar);
        }

        public void a(AdobeUploadAssetData adobeUploadAssetData) {
            Observer observer = this.f5825a.get(adobeUploadAssetData.f5272a);
            if (observer == null) {
                return;
            }
            this.f5825a.remove(adobeUploadAssetData.f5272a);
            Sc.this.F.b(adobeUploadAssetData, observer);
        }
    }

    private void t() {
        this.q = new c.a.a.a.a.b.a.b.a.f.a().a(this.l);
        this.r = new c.a.a.a.a.b.a.b.a.e.a().a(this.l);
        this.s = new c.a.a.a.a.b.a.b.a.d.a().a(this.l);
        this.t = new c.a.a.a.a.b.a.b.a.b.a().a(this.l);
        this.u = new c.a.a.a.a.b.a.b.a.c.a().a(this.l);
        this.v = new c.a.a.a.a.b.a.b.a.g.a().a(this.l);
        this.w = new c.a.a.a.a.b.a.b.a.i.a().a(this.l);
        this.x = new c.a.a.a.a.b.a.b.a.l.a().a(this.l);
        this.y = new c.a.a.a.a.b.a.b.a.n.a().a(this.l);
        this.z = new c.a.a.a.a.b.a.b.a.j.a().a(this.l);
        this.A = new c.a.a.a.a.b.a.b.a.h.a().a(this.l);
        this.B = new c.a.a.a.a.b.a.b.a.k.a().a(this.l);
        this.C = new c.a.a.a.a.b.a.b.a.a.a().a(this.l);
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x00dd, code lost:            if (r3.equals("application/vnd.adobe.element.image+dcx") != false) goto L48;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 466
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.storage.controllers.Sc.b(java.lang.String):boolean");
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected View c(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(c.a.a.a.b.g.adobe_assets_library_items_view, new FrameLayout(context));
        this.f6415f = (SwipeRefreshLayout) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_asset_libraryitemsview_swipe_refresh_layout);
        this.m = (TwoWayView) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_asset_library_design_items_twowayview);
        return inflate;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb
    public void e() {
        this.o.h();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb
    public void f() {
        this.o.h();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected SwipeRefreshLayout l() {
        return this.f6415f;
    }

    public void r() {
        this.G.a();
        this.F = null;
        this.p = null;
    }

    public void s() {
        a(this.o.getItemCount() <= 0);
    }

    public void a(C0614ub c0614ub) {
        this.l = c0614ub;
        t();
        x();
    }

    public void a(String str) {
        if (str == null) {
            str = "";
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1988296473:
                if (str.equals("application/vnd.adobe.element.material+dcx")) {
                    c2 = '\t';
                    break;
                }
                break;
            case -1484987521:
                if (str.equals("application/vnd.adobe.element.color+dcx")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1323798689:
                if (str.equals("application/vnd.adobe.element.look+dcx")) {
                    c2 = 6;
                    break;
                }
                break;
            case -848656710:
                if (str.equals("application/vnd.adobe.element.template+dcx")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -523642159:
                if (str.equals("application/vnd.adobe.element.3d+dcx")) {
                    c2 = 11;
                    break;
                }
                break;
            case -49110665:
                if (str.equals("application/vnd.adobe.element.image+dcx")) {
                    c2 = 0;
                    break;
                }
                break;
            case -15971864:
                if (str.equals("application/vnd.adobe.element.characterstyle+dcx")) {
                    c2 = 4;
                    break;
                }
                break;
            case 30270912:
                if (str.equals("application/vnd.adobe.element.layerstyle+dcx")) {
                    c2 = 5;
                    break;
                }
                break;
            case 511986694:
                if (str.equals("application/vnd.adobe.element.colortheme+dcx")) {
                    c2 = 2;
                    break;
                }
                break;
            case 758810582:
                if (str.equals("application/vnd.adobe.element.brush+dcx")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1514723250:
                if (str.equals("application/vnd.adobe.element.light+dcx")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1658750380:
                if (str.equals("application/vnd.adobe.element.pattern+dcx")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1719943200:
                if (str.equals("application/vnd.adobe.element.animation+dcx")) {
                    c2 = '\f';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.q = new c.a.a.a.a.b.a.b.a.f.a().a(this.l);
                return;
            case 1:
                this.s = new c.a.a.a.a.b.a.b.a.d.a().a(this.l);
                return;
            case 2:
                this.r = new c.a.a.a.a.b.a.b.a.e.a().a(this.l);
                return;
            case 3:
                this.t = new c.a.a.a.a.b.a.b.a.b.a().a(this.l);
                return;
            case 4:
                this.u = new c.a.a.a.a.b.a.b.a.c.a().a(this.l);
                return;
            case 5:
                this.v = new c.a.a.a.a.b.a.b.a.g.a().a(this.l);
                return;
            case 6:
                this.w = new c.a.a.a.a.b.a.b.a.i.a().a(this.l);
                return;
            case 7:
                this.x = new c.a.a.a.a.b.a.b.a.l.a().a(this.l);
                return;
            case '\b':
                this.y = new c.a.a.a.a.b.a.b.a.n.a().a(this.l);
                return;
            case '\t':
                this.z = new c.a.a.a.a.b.a.b.a.j.a().a(this.l);
                return;
            case '\n':
                this.A = new c.a.a.a.a.b.a.b.a.h.a().a(this.l);
                return;
            case 11:
                this.B = new c.a.a.a.a.b.a.b.a.k.a().a(this.l);
                return;
            case '\f':
                this.C = new c.a.a.a.a.b.a.b.a.a.a().a(this.l);
                return;
            default:
                t();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DesignLibraryItemsListView.java */
    /* loaded from: classes.dex */
    public class c extends d {
        final int i;
        private SparseArray<Integer> j;
        private final Context k;
        private Boolean l;
        private Typeface m;
        private a n;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DesignLibraryItemsListView.java */
        /* loaded from: classes.dex */
        public class a {

            /* renamed from: a, reason: collision with root package name */
            public int f5827a;

            /* renamed from: b, reason: collision with root package name */
            public int f5828b;

            /* renamed from: c, reason: collision with root package name */
            public int f5829c;

            /* renamed from: d, reason: collision with root package name */
            public int f5830d;

            a() {
            }
        }

        public c(Context context) {
            super(context);
            this.i = 1;
            this.k = context;
            this.j = new SparseArray<>();
            h();
            this.l = Boolean.valueOf(C0455p.b(Sc.this.b()));
            this.m = Typeface.createFromAsset(Sc.this.b().getAssets(), "fonts/AdobeClean-SemiLight.otf");
        }

        private void b(RecyclerView.ViewHolder viewHolder, int i, int i2) {
            C0622wb c0622wb = (C0622wb) Sc.this.r.get(i);
            a.c cVar = (a.c) viewHolder;
            boolean a2 = Sc.this.a(c0622wb);
            cVar.a(c0622wb);
            cVar.a(a2);
            cVar.a((List<Integer>) a(c0622wb));
            cVar.a(C0288q.b(c0622wb));
            cVar.a(C0288q.a(c0622wb));
            cVar.a(this.m);
            cVar.a((View.OnClickListener) new AbstractC0476tb.a(i2));
            Sc sc = Sc.this;
            sc.f6417h = new AbstractC0476tb.b(i2);
            cVar.b(Sc.this.f6417h);
        }

        private int g(int i) {
            return this.j.get(i).intValue();
        }

        private void j() {
            if (this.n != null) {
                return;
            }
            this.n = new a();
            this.n.f5827a = this.k.getResources().getInteger(c.a.a.a.b.f.adobe_csdk_library_items_default_columns);
            this.n.f5828b = this.k.getResources().getInteger(c.a.a.a.b.f.adobe_csdk_library_items_color_section_columns);
            this.n.f5829c = this.k.getResources().getInteger(c.a.a.a.b.f.adobe_csdk_library_items_colortheme_section_columns);
            this.n.f5830d = this.k.getResources().getInteger(c.a.a.a.b.f.adobe_csdk_library_items_image_section_columns);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sc.d
        protected RecyclerView.ViewHolder a(ViewGroup viewGroup, int i) {
            if (i == 7) {
                return new a.d(LayoutInflater.from(this.k).inflate(c.a.a.a.b.g.adobe_library_items_headercell, viewGroup, false));
            }
            if (i == 0) {
                a.b bVar = new a.b(LayoutInflater.from(this.k).inflate(c.a.a.a.b.g.adobe_library_items_colorcell, viewGroup, false));
                if (!this.l.booleanValue()) {
                    bVar.x().setVisibility(8);
                }
                return bVar;
            }
            if (i == 1) {
                a.c cVar = new a.c(LayoutInflater.from(this.k).inflate(c.a.a.a.b.g.adobe_library_items_colorthemecell, viewGroup, false));
                if (!this.l.booleanValue()) {
                    cVar.x().setVisibility(8);
                }
                return cVar;
            }
            if (i == 2 || i == 4 || i == 3 || i == 5 || i == 6 || i == 8 || i == 9 || i == 10 || i == 11 || i == 12 || i == 13) {
                a.e eVar = new a.e(LayoutInflater.from(this.k).inflate(c.a.a.a.b.g.adobe_library_items_imagecollectioncell, viewGroup, false));
                if (!this.l.booleanValue()) {
                    eVar.x().setVisibility(8);
                }
                return eVar;
            }
            if (i != 33) {
                return null;
            }
            a.f a2 = a.f.a(LayoutInflater.from(this.k), viewGroup);
            if (!this.l.booleanValue()) {
                a2.x().setVisibility(8);
            }
            return a2;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sc.d
        protected int d(int i) {
            switch (g(i)) {
                case 0:
                    return Sc.this.s.size();
                case 1:
                    return Sc.this.r.size();
                case 2:
                    return Sc.this.t.size();
                case 3:
                    return Sc.this.q.size() + Sc.this.u();
                case 4:
                    return Sc.this.u.size();
                case 5:
                    return Sc.this.v.size();
                case 6:
                    return Sc.this.w.size();
                case 7:
                default:
                    return 0;
                case 8:
                    return Sc.this.x.size();
                case 9:
                    return Sc.this.y.size();
                case 10:
                    return Sc.this.z.size();
                case 11:
                    return Sc.this.A.size();
                case 12:
                    return Sc.this.B.size();
                case 13:
                    return Sc.this.C.size();
            }
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sc.d
        protected int e(int i) {
            return 7;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sc.d
        protected int f() {
            int i = 0;
            if (Sc.this.s != null && Sc.this.s.size() > 0) {
                this.j.put(0, 0);
                i = 1;
            }
            if (Sc.this.r != null && Sc.this.r.size() > 0) {
                this.j.put(i, 1);
                i++;
            }
            if (Sc.this.t != null && Sc.this.t.size() > 0) {
                this.j.put(i, 2);
                i++;
            }
            if ((Sc.this.q != null && Sc.this.q.size() > 0) || (Sc.this.p != null && Sc.this.p.size() > 0)) {
                this.j.put(i, 3);
                i++;
            }
            if (Sc.this.u != null && Sc.this.u.size() > 0) {
                this.j.put(i, 4);
                i++;
            }
            if (Sc.this.v != null && Sc.this.v.size() > 0) {
                this.j.put(i, 5);
                i++;
            }
            if (Sc.this.w != null && Sc.this.w.size() > 0) {
                this.j.put(i, 6);
                i++;
            }
            if (Sc.this.x != null && Sc.this.x.size() > 0) {
                this.j.put(i, 8);
                i++;
            }
            if (Sc.this.y != null && Sc.this.y.size() > 0) {
                this.j.put(i, 9);
                i++;
            }
            if (Sc.this.z != null && Sc.this.z.size() > 0) {
                this.j.put(i, 10);
                i++;
            }
            if (Sc.this.A != null && Sc.this.A.size() > 0) {
                this.j.put(i, 11);
                i++;
            }
            if (Sc.this.B != null && Sc.this.B.size() > 0) {
                this.j.put(i, 12);
                i++;
            }
            if (Sc.this.C == null || Sc.this.C.size() <= 0) {
                return i;
            }
            this.j.put(i, 13);
            return i + 1;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sc.d
        public void h() {
            this.n = null;
            Sc.this.v();
            super.h();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sc.d
        protected void b(RecyclerView.ViewHolder viewHolder, int i) {
            int size;
            int i2;
            int i3;
            int i4;
            a.d dVar = (a.d) viewHolder;
            switch (g(i)) {
                case 0:
                    size = Sc.this.s.size();
                    i2 = c.a.a.a.b.i.adobe_csdk_design_library_header_color;
                    int i5 = i2;
                    i3 = size;
                    i4 = i5;
                    break;
                case 1:
                    size = Sc.this.r.size();
                    i2 = c.a.a.a.b.i.adobe_csdk_design_library_header_colortheme;
                    int i52 = i2;
                    i3 = size;
                    i4 = i52;
                    break;
                case 2:
                    size = Sc.this.t.size();
                    i2 = c.a.a.a.b.i.adobe_csdk_design_library_header_brushes;
                    int i522 = i2;
                    i3 = size;
                    i4 = i522;
                    break;
                case 3:
                    size = Sc.this.q.size() + Sc.this.u();
                    i2 = c.a.a.a.b.i.adobe_csdk_design_library_header_graphics;
                    int i5222 = i2;
                    i3 = size;
                    i4 = i5222;
                    break;
                case 4:
                    i4 = c.a.a.a.b.i.adobe_csdk_design_library_header_textstyle;
                    i3 = Sc.this.u.size();
                    break;
                case 5:
                    i4 = c.a.a.a.b.i.adobe_csdk_design_library_header_layoutstyle;
                    i3 = Sc.this.v.size();
                    break;
                case 6:
                    i4 = c.a.a.a.b.i.adobe_csdk_design_library_header_looks;
                    i3 = Sc.this.w.size();
                    break;
                case 7:
                default:
                    i4 = 0;
                    i3 = 0;
                    break;
                case 8:
                    i4 = c.a.a.a.b.i.adobe_csdk_design_library_header_patterns;
                    i3 = Sc.this.x.size();
                    break;
                case 9:
                    i4 = c.a.a.a.b.i.adobe_csdk_design_library_header_templates;
                    i3 = Sc.this.y.size();
                    break;
                case 10:
                    i4 = c.a.a.a.b.i.adobe_csdk_design_library_header_materials;
                    i3 = Sc.this.z.size();
                    break;
                case 11:
                    i4 = c.a.a.a.b.i.adobe_csdk_design_library_header_lights;
                    i3 = Sc.this.A.size();
                    break;
                case 12:
                    i4 = c.a.a.a.b.i.adobe_csdk_design_library_header_models;
                    i3 = Sc.this.B.size();
                    break;
                case 13:
                    i4 = c.a.a.a.b.i.adobe_csdk_design_library_header_animations;
                    i3 = Sc.this.C.size();
                    break;
            }
            String format = i4 != 0 ? String.format(Sc.this.b().getResources().getString(i4), Integer.valueOf(i3)) : null;
            if (format != null) {
                dVar.a(format);
            }
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sc.d
        protected void a(RecyclerView.ViewHolder viewHolder, d.a aVar) {
            View view = viewHolder.itemView;
            view.setLayoutParams(Sc.this.n.a((StaggeredGridLayoutManager.a) view.getLayoutParams(), aVar.f5838a, aVar.f5840c));
        }

        private void a(RecyclerView.ViewHolder viewHolder, int i, int i2) {
            C0622wb c0622wb = (C0622wb) Sc.this.s.get(i);
            a.b bVar = (a.b) viewHolder;
            boolean a2 = Sc.this.a(c0622wb);
            bVar.a(c0622wb);
            bVar.a(a2);
            bVar.c(C0551eb.a(c0622wb, Sc.this.l).intValue());
            bVar.a(C0288q.b(c0622wb));
            bVar.a(C0288q.a(c0622wb));
            bVar.a(this.m);
            bVar.a((View.OnClickListener) new AbstractC0476tb.a(i2));
            Sc sc = Sc.this;
            sc.f6417h = new AbstractC0476tb.b(i2);
            bVar.b(Sc.this.f6417h);
        }

        public int f(int i) {
            int g2 = g(i);
            j();
            a aVar = this.n;
            int i2 = aVar.f5827a;
            switch (g2) {
                case 0:
                    return aVar.f5828b;
                case 1:
                    return aVar.f5829c;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    return aVar.f5830d;
                case 7:
                default:
                    return i2;
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:            return r3 / r4;     */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:            if (r3 > 0.0f) goto L20;     */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:            if (r3 > 0.0f) goto L20;     */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private double a(int r3, com.adobe.creativesdk.foundation.storage.C0622wb r4) {
            /*
                r2 = this;
                r0 = 0
                switch(r3) {
                    case 2: goto L1f;
                    case 3: goto L5;
                    case 4: goto L1f;
                    case 5: goto L1f;
                    case 6: goto L1f;
                    case 7: goto L4;
                    case 8: goto L1f;
                    case 9: goto L1f;
                    case 10: goto L1f;
                    case 11: goto L1f;
                    case 12: goto L1f;
                    case 13: goto L1f;
                    default: goto L4;
                }
            L4:
                goto L3b
            L5:
                com.adobe.creativesdk.foundation.internal.storage.controllers.Sc r3 = com.adobe.creativesdk.foundation.internal.storage.controllers.Sc.this
                com.adobe.creativesdk.foundation.storage.ub r3 = com.adobe.creativesdk.foundation.internal.storage.controllers.Sc.j(r3)
                com.adobe.creativesdk.foundation.storage.ma r3 = com.adobe.creativesdk.foundation.adobeinternal.storage.library.C0288q.b(r4, r3)
                if (r3 != 0) goto L12
                goto L3b
            L12:
                float r4 = r3.f7348a
                int r1 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r1 <= 0) goto L3b
                float r3 = r3.f7349b
                int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r0 <= 0) goto L3b
                goto L38
            L1f:
                com.adobe.creativesdk.foundation.internal.storage.controllers.Sc r3 = com.adobe.creativesdk.foundation.internal.storage.controllers.Sc.this
                com.adobe.creativesdk.foundation.storage.ub r3 = com.adobe.creativesdk.foundation.internal.storage.controllers.Sc.j(r3)
                com.adobe.creativesdk.foundation.storage.ma r3 = com.adobe.creativesdk.foundation.adobeinternal.storage.library.C0288q.c(r4, r3)
                if (r3 != 0) goto L2c
                goto L3b
            L2c:
                float r4 = r3.f7348a
                int r1 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r1 <= 0) goto L3b
                float r3 = r3.f7349b
                int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r0 <= 0) goto L3b
            L38:
                float r3 = r3 / r4
                double r3 = (double) r3
                goto L3d
            L3b:
                r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            L3d:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.storage.controllers.Sc.c.a(int, com.adobe.creativesdk.foundation.storage.wb):double");
        }

        private void a(int i, RecyclerView.ViewHolder viewHolder, C0622wb c0622wb, int i2) {
            a.e eVar = (a.e) viewHolder;
            eVar.a(c0622wb);
            eVar.a(C0288q.b(c0622wb));
            eVar.a(a(i, c0622wb));
            eVar.a(Sc.this.a(c0622wb));
            eVar.a(C0288q.a(c0622wb));
            eVar.a(this.m);
            eVar.u().setScaleType(ImageView.ScaleType.FIT_CENTER);
            eVar.a((View.OnClickListener) new AbstractC0476tb.a(i2));
            Sc sc = Sc.this;
            sc.f6417h = new AbstractC0476tb.b(i2);
            eVar.b(Sc.this.f6417h);
            if (c0622wb.j().equals("application/vnd.adobe.element.characterstyle+dcx")) {
                eVar.u().setScaleType(ImageView.ScaleType.CENTER);
            }
            C0582ma c0582ma = new C0582ma(450.0f, 0.0f);
            eVar.a((Bitmap) null);
            BitmapDrawable c2 = Sc.this.H.c(c0622wb.c());
            if (c2 == null) {
                Vc vc = new Vc(this, eVar, c0622wb, c0582ma, c0622wb);
                Handler handler = new Handler(Looper.getMainLooper());
                int a2 = c.a.a.a.a.b.a.c.e.a(c0622wb, 3, Sc.this.b(), true);
                if (c0622wb.j().equals("application/vnd.adobe.element.animation+dcx")) {
                    com.adobe.creativesdk.foundation.storage.Hb a3 = c0622wb.a("image/png");
                    if (a3 != null) {
                        c.a.a.a.a.b.a.c.e.a(a2, Sc.this.l, a3, c0622wb, vc, handler);
                        return;
                    }
                    com.adobe.creativesdk.foundation.storage.Hb a4 = c0622wb.a("image/jpeg");
                    if (a4 != null) {
                        c.a.a.a.a.b.a.c.e.a(a2, Sc.this.l, a4, c0622wb, vc, handler);
                        return;
                    }
                }
                c.a.a.a.a.b.a.c.e.a(a2, Sc.this.l, c0622wb, vc, handler);
                return;
            }
            eVar.a(c2);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sc.d
        protected int b(int i, int i2) {
            int g2 = g(i);
            if (g2 != 3 || i2 >= Sc.this.u()) {
                return g2;
            }
            return 33;
        }

        private ArrayList<Integer> a(C0622wb c0622wb) {
            JSONObject jSONObject;
            JSONObject a2 = C0288q.a(c0622wb, Sc.this.l);
            if (a2 == null) {
                return null;
            }
            a2.optString("rule");
            a2.optString("mood");
            JSONArray jSONArray = (JSONArray) a2.opt("swatches");
            if (jSONArray == null) {
                return null;
            }
            int length = jSONArray.length();
            ArrayList<Integer> arrayList = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                Object opt = jSONArray.opt(i);
                if (opt instanceof JSONArray) {
                    jSONObject = ((JSONArray) opt).optJSONObject(0);
                } else {
                    jSONObject = opt instanceof JSONObject ? (JSONObject) opt : null;
                }
                if (jSONObject != null) {
                    Object opt2 = jSONObject.opt("value");
                    if (opt2 == null) {
                        opt2 = jSONObject.opt("values");
                    }
                    if (opt2 instanceof JSONObject) {
                        JSONObject jSONObject2 = (JSONObject) opt2;
                        arrayList.add(Integer.valueOf(Color.rgb(jSONObject2.optInt("r"), jSONObject2.optInt("g"), jSONObject2.optInt("b"))));
                    } else if (opt2 instanceof JSONArray) {
                        JSONArray jSONArray2 = (JSONArray) opt2;
                        arrayList.add(Integer.valueOf(Color.rgb((int) (jSONArray2.optDouble(0) * 255.0d), (int) (jSONArray2.optDouble(1) * 255.0d), (int) (jSONArray2.optDouble(2) * 255.0d))));
                    }
                }
            }
            return arrayList;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sc.d
        protected void a(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3) {
            int g2 = g(i);
            switch (g2) {
                case 0:
                    a(viewHolder, i2, i3);
                    return;
                case 1:
                    b(viewHolder, i2, i3);
                    return;
                case 2:
                    a(g2, viewHolder, (C0622wb) Sc.this.t.get(i2), i3);
                    return;
                case 3:
                    if (i2 < Sc.this.u()) {
                        a((a.f) viewHolder, (AdobeUploadAssetData) Sc.this.p.get(i2), i3);
                        return;
                    } else {
                        a(g2, viewHolder, (C0622wb) Sc.this.q.get(i2 - Sc.this.u()), i3);
                        return;
                    }
                case 4:
                    a(g2, viewHolder, (C0622wb) Sc.this.u.get(i2), i3);
                    return;
                case 5:
                    a(g2, viewHolder, (C0622wb) Sc.this.v.get(i2), i3);
                    return;
                case 6:
                    a(g2, viewHolder, (C0622wb) Sc.this.w.get(i2), i3);
                    return;
                case 7:
                default:
                    return;
                case 8:
                    a(g2, viewHolder, (C0622wb) Sc.this.x.get(i2), i3);
                    return;
                case 9:
                    a(g2, viewHolder, (C0622wb) Sc.this.y.get(i2), i3);
                    return;
                case 10:
                    a(g2, viewHolder, (C0622wb) Sc.this.z.get(i2), i3);
                    return;
                case 11:
                    a(g2, viewHolder, (C0622wb) Sc.this.A.get(i2), i3);
                    return;
                case 12:
                    a(g2, viewHolder, (C0622wb) Sc.this.B.get(i2), i3);
                    return;
                case 13:
                    a(g2, viewHolder, (C0622wb) Sc.this.C.get(i2), i3);
                    return;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:6:0x0047  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void a(com.adobe.creativesdk.foundation.internal.storage.controllers.b.a.f r4, com.adobe.creativesdk.foundation.internal.storage.controllers.upload.AdobeUploadAssetData r5, int r6) {
            /*
                r3 = this;
                com.adobe.creativesdk.foundation.internal.storage.controllers.Sc r0 = com.adobe.creativesdk.foundation.internal.storage.controllers.Sc.this
                com.adobe.creativesdk.foundation.internal.storage.controllers.Sc$a r0 = com.adobe.creativesdk.foundation.internal.storage.controllers.Sc.l(r0)
                com.adobe.creativesdk.foundation.internal.storage.controllers.Sc$b r1 = r4.A()
                r0.a(r5, r1)
                com.adobe.creativesdk.foundation.storage.ma r0 = com.adobe.creativesdk.foundation.internal.storage.model.util.c.f6622b
                com.adobe.creativesdk.foundation.storage.ma r0 = com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0452ob.a(r0)
                java.net.URL r5 = r5.a()
                java.lang.String r5 = r5.getPath()
                r1 = 512(0x200, float:7.17E-43)
                r2 = 384(0x180, float:5.38E-43)
                android.graphics.Bitmap r1 = com.adobe.creativesdk.foundation.internal.storage.controllers.upload.v.a(r5, r1, r2)     // Catch: java.lang.Exception -> L24 java.lang.OutOfMemoryError -> L31
                goto L3e
            L24:
                r1 = move-exception
                java.lang.String r2 = com.adobe.creativesdk.foundation.internal.storage.controllers.Sc.q()
                java.lang.String r1 = r1.getMessage()
                android.util.Log.e(r2, r1)
                goto L3d
            L31:
                r1 = move-exception
                java.lang.String r2 = com.adobe.creativesdk.foundation.internal.storage.controllers.Sc.q()
                java.lang.String r1 = r1.getMessage()
                android.util.Log.e(r2, r1)
            L3d:
                r1 = 0
            L3e:
                java.lang.String r5 = org.apache.commons.io.c.a(r5)
                r4.a(r5)
                if (r1 == 0) goto L5f
                int r5 = r1.getHeight()
                float r5 = (float) r5
                int r2 = r1.getWidth()
                float r2 = (float) r2
                float r5 = r5 / r2
                float r0 = r0.f7348a
                int r2 = (int) r0
                float r0 = r0 * r5
                int r5 = (int) r0
                android.graphics.Bitmap r5 = android.media.ThumbnailUtils.extractThumbnail(r1, r2, r5)
                r4.a(r5)
            L5f:
                com.adobe.creativesdk.foundation.internal.storage.controllers.tb$a r5 = new com.adobe.creativesdk.foundation.internal.storage.controllers.tb$a
                com.adobe.creativesdk.foundation.internal.storage.controllers.Sc r0 = com.adobe.creativesdk.foundation.internal.storage.controllers.Sc.this
                r5.<init>(r6)
                r4.a(r5)
                com.adobe.creativesdk.foundation.internal.storage.controllers.Sc r5 = com.adobe.creativesdk.foundation.internal.storage.controllers.Sc.this
                com.adobe.creativesdk.foundation.internal.storage.controllers.tb$b r0 = new com.adobe.creativesdk.foundation.internal.storage.controllers.tb$b
                r0.<init>(r6)
                r5.f6417h = r0
                com.adobe.creativesdk.foundation.internal.storage.controllers.Sc r5 = com.adobe.creativesdk.foundation.internal.storage.controllers.Sc.this
                com.adobe.creativesdk.foundation.internal.storage.controllers.tb$b r5 = r5.f6417h
                r4.b(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.storage.controllers.Sc.c.a(com.adobe.creativesdk.foundation.internal.storage.controllers.b.a$f, com.adobe.creativesdk.foundation.internal.storage.controllers.upload.AdobeUploadAssetData, int):void");
        }
    }

    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar) {
        this.H = fVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected RecyclerView.ItemDecoration a(RecyclerView recyclerView, Context context) {
        int dimensionPixelSize = b().getResources().getDimensionPixelSize(c.a.a.a.b.c.adobe_csdk_library_items_spacing_size);
        this.D = new com.adobe.creativesdk.foundation.internal.storage.controllers.b.b(dimensionPixelSize, dimensionPixelSize);
        this.D.a();
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    public RecyclerView a(Context context) {
        return this.m;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected RecyclerView.Adapter<RecyclerView.ViewHolder> a(Context context, RecyclerView recyclerView) {
        this.o = new c(context);
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(C0622wb c0622wb) {
        C0549e h2;
        EnumSet<AdobeAssetDesignLibraryItemType> a2;
        boolean contains;
        if (C0455p.b(b())) {
            return false;
        }
        if (c0622wb.j().equals("application/vnd.adobe.element.brush+dcx") || c0622wb.j().equals("application/vnd.adobe.element.layerstyle+dcx") || c0622wb.j().equals("application/vnd.adobe.element.characterstyle+dcx") || c0622wb.j().equals("application/vnd.adobe.element.look+dcx")) {
            return true;
        }
        C0485v c0485v = this.E;
        if (c0485v == null || (h2 = c0485v.h()) == null || (a2 = h2.a()) == null) {
            return false;
        }
        if (c0622wb.j().equals("application/vnd.adobe.element.color+dcx")) {
            contains = a2.contains(AdobeAssetDesignLibraryItemType.AdobeAssetDesignLibraryItemColors);
        } else if (c0622wb.j().equals("application/vnd.adobe.element.colortheme+dcx")) {
            contains = a2.contains(AdobeAssetDesignLibraryItemType.AdobeAssetDesignLibraryItemColorThemes);
        } else if (c0622wb.j().equals("application/vnd.adobe.element.image+dcx")) {
            contains = a2.contains(AdobeAssetDesignLibraryItemType.AdobeAssetDesignLibraryItemImages);
        } else if (c0622wb.j().equals("application/vnd.adobe.element.pattern+dcx")) {
            contains = a2.contains(AdobeAssetDesignLibraryItemType.AdobeAssetDesignLibraryItemPattern);
        } else if (c0622wb.j().equals("application/vnd.adobe.element.template+dcx")) {
            contains = a2.contains(AdobeAssetDesignLibraryItemType.AdobeAssetDesignLibraryItemTemplate);
        } else if (c0622wb.j().equals("application/vnd.adobe.element.material+dcx")) {
            contains = a2.contains(AdobeAssetDesignLibraryItemType.AdobeAssetDesignLibraryItem3DMaterial);
        } else if (c0622wb.j().equals("application/vnd.adobe.element.light+dcx")) {
            contains = a2.contains(AdobeAssetDesignLibraryItemType.AdobeAssetDesignLibraryItem3DLight);
        } else if (c0622wb.j().equals("application/vnd.adobe.element.3d+dcx")) {
            contains = a2.contains(AdobeAssetDesignLibraryItemType.AdobeAssetDesignLibraryItem3DModel);
        } else {
            if (!c0622wb.j().equals("application/vnd.adobe.element.animation+dcx")) {
                return false;
            }
            contains = a2.contains(AdobeAssetDesignLibraryItemType.AdobeAssetDesignLibraryItemAnimation);
        }
        return !contains;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected RecyclerView.LayoutManager b(Context context) {
        int integer = context.getResources().getInteger(c.a.a.a.b.f.adobe_csdk_library_items_columns_GCM);
        this.n = new AdobeWaterFallLayoutManager(integer);
        this.n.a(new Pc(this, integer));
        return this.n;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected void a(View view, int i) {
        C0622wb t = ((a.AbstractC0031a) view.getTag()).t();
        if (t == null || a(t)) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.storage.controllers.utils.f fVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.utils.f();
        fVar.f6495a = this.l;
        fVar.f6497c = new ArrayList<>();
        if (this.s.size() > 0 && (!a(this.s.get(0)))) {
            fVar.f6497c.addAll(this.s);
        }
        if (this.r.size() > 0 && (!a(this.r.get(0)))) {
            fVar.f6497c.addAll(this.r);
        }
        if (this.q.size() > 0 && (!a(this.q.get(0)))) {
            fVar.f6497c.addAll(this.q);
        }
        if (this.x.size() > 0 && (!a(this.x.get(0)))) {
            fVar.f6497c.addAll(this.x);
        }
        if (this.y.size() > 0 && (!a(this.y.get(0)))) {
            fVar.f6497c.addAll(this.y);
        }
        if (this.z.size() > 0 && (!a(this.z.get(0)))) {
            fVar.f6497c.addAll(this.z);
        }
        if (this.A.size() > 0 && (!a(this.A.get(0)))) {
            fVar.f6497c.addAll(this.A);
        }
        if (this.B.size() > 0 && (!a(this.B.get(0)))) {
            fVar.f6497c.addAll(this.B);
        }
        if (this.C.size() > 0 && (!a(this.C.get(0)))) {
            fVar.f6497c.addAll(this.C);
        }
        if (w()) {
            fVar.f6497c.addAll(new c.a.a.a.a.b.a.b.a.b.a().a(this.l));
            fVar.f6497c.addAll(new c.a.a.a.a.b.a.b.a.c.a().a(this.l));
            fVar.f6497c.addAll(new c.a.a.a.a.b.a.b.a.g.a().a(this.l));
            fVar.f6497c.addAll(new c.a.a.a.a.b.a.b.a.i.a().a(this.l));
        }
        fVar.f6496b = fVar.f6497c.indexOf(t);
        InterfaceC0362ad interfaceC0362ad = this.f6373b.get();
        if (interfaceC0362ad != null) {
            interfaceC0362ad.a(fVar);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0476tb
    protected void a(int i, View view) {
        InterfaceC0362ad interfaceC0362ad;
        C0622wb t = ((a.AbstractC0031a) view.getTag()).t();
        if (t == null || (interfaceC0362ad = this.f6373b.get()) == null) {
            return;
        }
        interfaceC0362ad.a(t, view);
    }

    public void a(C0485v c0485v) {
        this.E = c0485v;
    }

    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa> tVar) {
        if (this.p == null) {
            this.F = tVar;
            this.p = new ArrayList<>();
            this.p.addAll(this.F.a());
            this.o.h();
        }
    }
}
