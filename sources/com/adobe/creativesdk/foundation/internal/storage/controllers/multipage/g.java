package com.adobe.creativesdk.foundation.internal.storage.controllers.multipage;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFileRenditionType;
import com.adobe.creativesdk.foundation.storage.C0533a;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import java.lang.ref.WeakReference;

/* compiled from: AdobeAssetAutoFitRecyclerViewController.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    protected View f6277a;

    /* renamed from: b, reason: collision with root package name */
    protected Context f6278b;

    /* renamed from: c, reason: collision with root package name */
    protected RecyclerView f6279c;

    /* renamed from: d, reason: collision with root package name */
    protected LinearLayoutManager f6280d;

    /* renamed from: e, reason: collision with root package name */
    protected View f6281e;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f6282f;

    /* renamed from: g, reason: collision with root package name */
    protected a f6283g;

    /* renamed from: h, reason: collision with root package name */
    protected C0533a f6284h;
    protected View j;
    protected View k;
    protected View l;
    protected boolean m;
    p n;
    private WeakReference<com.adobe.creativesdk.foundation.internal.storage.controllers.a.f> p;
    protected int i = 1;
    private boolean o = true;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AdobeAssetAutoFitRecyclerViewController.java */
    /* loaded from: classes.dex */
    public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AdobeAssetAutoFitRecyclerViewController.java */
        /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class ViewOnClickListenerC0034a extends RecyclerView.ViewHolder implements View.OnClickListener {
            C0442a s;

            public ViewOnClickListenerC0034a(View view) {
                super(view);
                this.s = new C0442a();
                this.s.a(view);
                this.s.a(g.this.f6278b.getResources().getDisplayMetrics());
                this.s.a(g.this.f6278b);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }

            public C0442a t() {
                return this.s;
            }
        }

        protected a() {
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            C0533a c0533a = g.this.f6284h;
            if (!(c0533a instanceof AdobeAssetFile)) {
                return -1;
            }
            AdobeAssetFile adobeAssetFile = (AdobeAssetFile) c0533a;
            if (adobeAssetFile.getOptionalMetadata() != null) {
                g.this.i = adobeAssetFile.getOptionalMetadata().optInt(com.umeng.analytics.pro.b.s, 1);
            }
            return g.this.i;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            BitmapDrawable c2;
            C0442a t = ((ViewOnClickListenerC0034a) viewHolder).t();
            t.b(i);
            t.b();
            boolean z = false;
            t.a().measure(0, 0);
            C0582ma c0582ma = new C0582ma(t.a().getMeasuredWidth(), t.a().getMeasuredHeight());
            if (g.this.f6284h instanceof AdobeAssetFile) {
                f fVar = new f(this, t, c0582ma, i);
                com.adobe.creativesdk.foundation.internal.storage.controllers.a.f f2 = g.this.f();
                if (f2 == null || (c2 = f2.c(com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(g.this.f6284h, AdobeAssetFileRenditionType.ADOBE_ASSET_FILE_RENDITION_TYPE_PNG, c0582ma, i))) == null) {
                    z = true;
                } else {
                    t.a(c2, i);
                    g gVar = g.this;
                    gVar.m = true;
                    gVar.j.setVisibility(4);
                }
                if (z) {
                    ((AdobeAssetFile) g.this.f6284h).getRenditionWithType(AdobeAssetFileRenditionType.ADOBE_ASSET_FILE_RENDITION_TYPE_PNG, c0582ma, i, fVar);
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewOnClickListenerC0034a(LayoutInflater.from(viewGroup.getContext()).inflate(c.a.a.a.b.g.adobe_multipage_autorecycler_cellview, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.adobe.creativesdk.foundation.internal.storage.controllers.a.f f() {
        WeakReference<com.adobe.creativesdk.foundation.internal.storage.controllers.a.f> weakReference = this.p;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (h()) {
            return;
        }
        this.n.g();
    }

    private boolean h() {
        return this.o;
    }

    public void c() {
        this.f6283g.notifyDataSetChanged();
    }

    public void d() {
        this.o = false;
        if (this.m) {
            this.l.setVisibility(0);
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
            this.l.setVisibility(4);
            this.j.setVisibility(4);
        }
    }

    public void e() {
        this.o = true;
        this.l.setVisibility(4);
        this.k.setVisibility(4);
        if (this.m) {
            return;
        }
        this.j.setVisibility(0);
        c();
    }

    protected View b() {
        this.f6279c = (RecyclerView) this.f6277a.findViewById(c.a.a.a.b.e.adobe_csdk_multipage_recyclerview);
        this.f6281e = this.f6277a.findViewById(c.a.a.a.b.e.adobe_csdk_asset_one_up_multi_page_recycler_section_container);
        this.f6282f = (TextView) this.f6277a.findViewById(c.a.a.a.b.e.adobe_csdk_asset_one_up_multi_page_recycler_section_textview);
        return this.f6277a;
    }

    public void a(p pVar) {
        this.n = pVar;
    }

    public void a(C0533a c0533a) {
        this.f6284h = c0533a;
    }

    public void a(View view) {
        this.f6277a = view;
    }

    private int b(C0533a c0533a) {
        if (!(c0533a instanceof AdobeAssetFile)) {
            return 0;
        }
        AdobeAssetFile adobeAssetFile = (AdobeAssetFile) c0533a;
        if (adobeAssetFile.getOptionalMetadata() != null) {
            this.i = adobeAssetFile.getOptionalMetadata().optInt(com.umeng.analytics.pro.b.s, 1);
        }
        return this.i;
    }

    protected a a() {
        return new a();
    }

    public void a(Context context) {
        b();
        this.f6278b = context;
        this.f6280d = (LinearLayoutManager) this.f6279c.getLayoutManager();
        this.f6283g = a();
        this.f6279c.setAdapter(this.f6283g);
        this.f6281e.setVisibility(0);
        this.f6281e.setOnClickListener(new ViewOnClickListenerC0443b(this));
        RecyclerView recyclerView = this.f6279c;
        recyclerView.addOnItemTouchListener(new z(context, recyclerView, new C0444c(this)));
        this.f6282f.setText(String.format(this.f6278b.getResources().getString(c.a.a.a.b.i.adobe_csdk_asset_view_multi_page_count), Integer.valueOf(b(this.f6284h))));
        this.f6279c.addItemDecoration(new x(this.f6278b));
        this.j = this.f6277a.findViewById(c.a.a.a.b.e.adobe_csdk_asset_image_progressbar_new);
        this.k = this.f6277a.findViewById(c.a.a.a.b.e.adobe_csdk_asset_viewer_no_internet_connection);
        this.l = this.f6277a.findViewById(c.a.a.a.b.e.adobe_csdk_gridview_container_no_network_notification_bar);
        if (!AbstractActivityC0427k.y()) {
            this.k.setVisibility(0);
            this.o = false;
        } else {
            this.j.setVisibility(0);
        }
        this.m = false;
    }

    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar) {
        if (fVar == null) {
            return;
        }
        this.p = new WeakReference<>(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, C0442a c0442a, C0582ma c0582ma, int i) {
        if (this.f6277a == null) {
            return;
        }
        com.adobe.creativesdk.foundation.internal.storage.controllers.a.f f2 = f();
        if (bArr != null && f2 != null) {
            f2.a(com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(this.f6284h, AdobeAssetFileRenditionType.ADOBE_ASSET_FILE_RENDITION_TYPE_PNG, c0582ma, i), bArr, new d(this, c0442a, i), new e(this));
            return;
        }
        if (bArr != null) {
            c0442a.a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length), i);
            if (!this.m) {
                this.m = true;
                g();
            }
            this.m = true;
            this.j.setVisibility(4);
        }
    }
}
