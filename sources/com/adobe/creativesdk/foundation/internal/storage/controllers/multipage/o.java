package com.adobe.creativesdk.foundation.internal.storage.controllers.multipage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0469s;
import com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0382ed;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFileRenditionType;
import com.adobe.creativesdk.foundation.storage.C0533a;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import java.lang.ref.WeakReference;

/* compiled from: AdobeAssetOneUpRecyclerViewController.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    static int f6299a = -1;

    /* renamed from: b, reason: collision with root package name */
    static int f6300b = -1;

    /* renamed from: c, reason: collision with root package name */
    protected View f6301c;

    /* renamed from: d, reason: collision with root package name */
    protected Context f6302d;

    /* renamed from: e, reason: collision with root package name */
    protected RecyclerView f6303e;

    /* renamed from: f, reason: collision with root package name */
    protected LinearLayoutManager f6304f;

    /* renamed from: g, reason: collision with root package name */
    protected View f6305g;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f6306h;
    protected a i;
    protected View j;
    protected C0533a k;
    protected int l = 1;
    private int m = -1;
    private int n = -1;
    p o;
    private WeakReference<com.adobe.creativesdk.foundation.internal.storage.controllers.a.f> p;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AdobeAssetOneUpRecyclerViewController.java */
    /* loaded from: classes.dex */
    public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements w, InterfaceC0382ed {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AdobeAssetOneUpRecyclerViewController.java */
        /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.o$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class ViewOnClickListenerC0035a extends RecyclerView.ViewHolder implements View.OnClickListener {
            h s;

            public ViewOnClickListenerC0035a(View view, InterfaceC0382ed interfaceC0382ed) {
                super(view);
                this.s = new h();
                this.s.a(view);
                this.s.a(o.this.f6302d.getResources().getDisplayMetrics());
                this.s.a(o.this.f6302d);
                this.s.a(interfaceC0382ed);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }

            public h t() {
                return this.s;
            }
        }

        protected a() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.w
        public void a(int i, int i2) {
            synchronized (a.class) {
                o.f6300b = i;
                o.f6299a = i2;
            }
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.w
        public int getHeight() {
            return o.f6299a;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            C0533a c0533a = o.this.k;
            if (!(c0533a instanceof AdobeAssetFile)) {
                return -1;
            }
            AdobeAssetFile adobeAssetFile = (AdobeAssetFile) c0533a;
            if (adobeAssetFile.getOptionalMetadata() != null) {
                o.this.l = adobeAssetFile.getOptionalMetadata().optInt(com.umeng.analytics.pro.b.s, 1);
            }
            return o.this.l;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.w
        public int getWidth() {
            return o.f6300b;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            BitmapDrawable c2;
            h t = ((ViewOnClickListenerC0035a) viewHolder).t();
            t.c(i);
            t.g();
            DisplayMetrics displayMetrics = o.this.f6302d.getResources().getDisplayMetrics();
            if (o.this.m == -1 || o.this.n == -1) {
                o oVar = o.this;
                double d2 = displayMetrics.widthPixels;
                Double.isNaN(d2);
                oVar.m = (int) (d2 * 0.7d);
                o oVar2 = o.this;
                double d3 = displayMetrics.heightPixels;
                Double.isNaN(d3);
                oVar2.n = (int) (d3 * 0.7d);
            }
            C0582ma c0582ma = new C0582ma(o.this.m, o.this.n);
            if (o.this.k instanceof AdobeAssetFile) {
                n nVar = new n(this, t, c0582ma, i);
                boolean z = true;
                com.adobe.creativesdk.foundation.internal.storage.controllers.a.f g2 = o.this.g();
                if (g2 != null && (c2 = g2.c(com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(o.this.k, AdobeAssetFileRenditionType.ADOBE_ASSET_FILE_RENDITION_TYPE_PNG, c0582ma, i))) != null) {
                    t.a(c2, i);
                    z = false;
                }
                if (z) {
                    ((AdobeAssetFile) o.this.k).getRenditionWithType(AdobeAssetFileRenditionType.ADOBE_ASSET_FILE_RENDITION_TYPE_PNG, c0582ma, i, nVar);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(c.a.a.a.b.g.adobe_multipage_recycler_cellview, viewGroup, false);
            ViewOnClickListenerC0035a viewOnClickListenerC0035a = new ViewOnClickListenerC0035a(inflate, this);
            inflate.setOnTouchListener(new C(o.this.f6302d, new m(this, viewOnClickListenerC0035a)));
            viewOnClickListenerC0035a.t().a((w) this);
            return viewOnClickListenerC0035a;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0382ed
        public C0469s a() {
            return o.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.adobe.creativesdk.foundation.internal.storage.controllers.a.f g() {
        WeakReference<com.adobe.creativesdk.foundation.internal.storage.controllers.a.f> weakReference = this.p;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public C0469s b() {
        return null;
    }

    public void d() {
        this.i.notifyDataSetChanged();
    }

    public void e() {
        View view = this.j;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void f() {
        View view = this.j;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    protected View c() {
        this.f6303e = (RecyclerView) this.f6301c.findViewById(c.a.a.a.b.e.adobe_csdk_multipage_recyclerview);
        this.j = this.f6301c.findViewById(c.a.a.a.b.e.adobe_csdk_listview_container_no_network_notification_bar);
        this.f6305g = this.f6301c.findViewById(c.a.a.a.b.e.adobe_csdk_asset_one_up_multi_page_recycler_section_container);
        this.f6306h = (TextView) this.f6301c.findViewById(c.a.a.a.b.e.adobe_csdk_asset_one_up_multi_page_recycler_section_textview);
        return this.f6301c;
    }

    private int b(C0533a c0533a) {
        if (!(c0533a instanceof AdobeAssetFile)) {
            return 0;
        }
        AdobeAssetFile adobeAssetFile = (AdobeAssetFile) c0533a;
        if (adobeAssetFile.getOptionalMetadata() != null) {
            this.l = adobeAssetFile.getOptionalMetadata().optInt(com.umeng.analytics.pro.b.s, 1);
        }
        return this.l;
    }

    public void a(p pVar) {
        this.o = pVar;
    }

    public void a(C0533a c0533a) {
        this.k = c0533a;
    }

    public void a(View view) {
        this.f6301c = view;
    }

    protected a a() {
        return new a();
    }

    public void a(Context context) {
        c();
        this.f6302d = context;
        this.f6304f = new LinearLayoutManager(context);
        this.f6304f.setOrientation(1);
        this.f6304f.setSmoothScrollbarEnabled(false);
        this.f6303e.setLayoutManager(this.f6304f);
        this.i = a();
        this.f6303e.setAdapter(this.i);
        this.f6303e.setHasFixedSize(true);
        this.f6305g.setVisibility(0);
        this.f6306h.setText(String.format(this.f6302d.getResources().getString(c.a.a.a.b.i.adobe_csdk_asset_view_multi_page_numbering), 1, Integer.valueOf(b(this.k))));
        this.f6305g.setOnClickListener(new i(this));
        this.f6303e.addItemDecoration(new x(this.f6302d));
        this.f6303e.addOnScrollListener(new j(this));
    }

    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar) {
        if (fVar == null) {
            return;
        }
        this.p = new WeakReference<>(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, h hVar, C0582ma c0582ma, int i) {
        if (this.f6301c == null) {
            return;
        }
        if (bArr == null) {
            hVar.e();
            return;
        }
        com.adobe.creativesdk.foundation.internal.storage.controllers.a.f g2 = g();
        if (g2 != null) {
            g2.a(com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(this.k, AdobeAssetFileRenditionType.ADOBE_ASSET_FILE_RENDITION_TYPE_PNG, c0582ma, i), bArr, new k(this, hVar, i), new l(this, hVar));
            return;
        }
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        if (decodeByteArray == null) {
            hVar.e();
        }
        hVar.a(decodeByteArray, i);
    }
}
