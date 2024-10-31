package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.adobe.creativesdk.foundation.internal.storage.C0330a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Ub;
import com.adobe.creativesdk.foundation.internal.storage.controllers.upload.AdobeUploadAssetData;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFileRenditionType;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import com.adobe.creativesdk.foundation.storage.C0578la;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AssetsRecyclerView.java */
/* loaded from: classes.dex */
public abstract class Db extends AbstractC0457pb implements InterfaceC0377dd {

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, C0330a> f5610c;

    /* renamed from: d, reason: collision with root package name */
    protected View f5611d;

    /* renamed from: e, reason: collision with root package name */
    protected RecyclerView f5612e;

    /* renamed from: f, reason: collision with root package name */
    protected RecyclerView.LayoutManager f5613f;

    /* renamed from: g, reason: collision with root package name */
    protected SwipeRefreshLayout f5614g;

    /* renamed from: h, reason: collision with root package name */
    protected a f5615h;
    protected RecyclerView.ItemDecoration i;
    private RecyclerView.OnScrollListener j;

    /* compiled from: AssetsRecyclerView.java */
    /* loaded from: classes.dex */
    public abstract class a extends RecyclerView.Adapter<b> {

        /* renamed from: c, reason: collision with root package name */
        protected int f5616c = -1;

        /* renamed from: d, reason: collision with root package name */
        private Boolean f5617d;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: AssetsRecyclerView.java */
        /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.Db$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class ViewOnClickListenerC0028a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            int f5619a;

            public ViewOnClickListenerC0028a(int i) {
                this.f5619a = 0;
                this.f5619a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Db.this.a(this.f5619a);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: AssetsRecyclerView.java */
        /* loaded from: classes.dex */
        public class b implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            private Sa f5621a;

            /* renamed from: b, reason: collision with root package name */
            private int f5622b;

            /* renamed from: c, reason: collision with root package name */
            private int f5623c;

            public b(Sa sa, int i, int i2) {
                this.f5621a = sa;
                this.f5622b = i;
                this.f5623c = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Db.this.a(this.f5622b, view);
            }
        }

        public a(Context context) {
            this.f5617d = Boolean.valueOf(C0455p.b(Db.this.b()));
        }

        private void c(Sa sa, C0330a c0330a) {
            AdobeUploadAssetData adobeUploadAssetData;
            Bitmap bitmap;
            JSONObject jSONObject = c0330a.f5276e;
            if (jSONObject != null && jSONObject.has("height") && jSONObject.has("width")) {
                try {
                    int i = jSONObject.getInt("height");
                    int i2 = jSONObject.getInt("width");
                    if (i > 0 && i2 > 0) {
                        sa.a(i / i2);
                        return;
                    }
                } catch (JSONException unused) {
                }
            }
            if (!(c0330a instanceof AdobeUploadAssetData) || (bitmap = (adobeUploadAssetData = (AdobeUploadAssetData) c0330a).k) == null) {
                return;
            }
            int height = bitmap.getHeight();
            int width = adobeUploadAssetData.k.getWidth();
            if (height <= 0 || width <= 0) {
                return;
            }
            sa.a(height / width);
        }

        protected abstract Sa a(ViewGroup viewGroup, int i);

        /* JADX INFO: Access modifiers changed from: protected */
        public void a(Sa sa, C0330a c0330a, int i) {
            sa.u();
            sa.c(c0330a.f5273b);
            sa.a(c0330a.f5272a);
            if ((sa instanceof Xc) && !(sa instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.upload.h)) {
                sa.a(c0330a.i);
                sa.a(c0330a.f5275d);
            }
            WeakReference<InterfaceC0362ad> weakReference = Db.this.f6373b;
            InterfaceC0362ad interfaceC0362ad = weakReference != null ? weakReference.get() : null;
            boolean s = interfaceC0362ad != null ? interfaceC0362ad.s() : false;
            Object obj = c0330a.f5278g;
            if (obj instanceof C0578la) {
                sa.d(((C0578la) obj).e());
                sa.c(c0330a.f5279h || s);
            }
            if (c0330a.f5278g instanceof AdobePhotoCollection) {
                sa.n.setVisibility(8);
                Db.this.a(sa, (AdobePhotoCollection) c0330a.f5278g);
            }
            sa.a(0, 0);
            sa.c(i);
            sa.a(Db.this);
            sa.b(c0330a.f5277f);
            if (b(c0330a)) {
                sa.a(Db.this.b(c0330a));
            }
            c(sa, c0330a);
            b(sa, c0330a, i);
        }

        protected abstract boolean a(C0330a c0330a);

        protected abstract boolean a(Sa sa, C0330a c0330a);

        /* JADX INFO: Access modifiers changed from: protected */
        public void b(Sa sa, C0330a c0330a, int i) {
            WeakReference<InterfaceC0362ad> weakReference = Db.this.f6373b;
            InterfaceC0362ad interfaceC0362ad = weakReference != null ? weakReference.get() : null;
            boolean s = interfaceC0362ad != null ? interfaceC0362ad.s() : false;
            if (a(c0330a)) {
                Db.this.b(sa, c0330a, i);
            } else {
                Db.this.a(sa, true, ((C0578la) c0330a.f5278g).e(), c0330a.f5279h || s);
                Db.this.a(sa, c0330a, i);
            }
        }

        protected abstract boolean b(C0330a c0330a);

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract C0330a c(int i);

        protected abstract int f();

        public RecyclerView.Adapter g() {
            return this;
        }

        public C0330a getItem(int i) {
            return c(i);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return f();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            Object obj = c(i).f5278g;
            if (obj instanceof AdobeAssetFile) {
                return 0;
            }
            if (obj instanceof C0578la) {
                return 1;
            }
            return this.f5616c;
        }

        protected abstract void h();

        public void i() {
            g().notifyDataSetChanged();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public b onCreateViewHolder(ViewGroup viewGroup, int i) {
            Sa a2 = a(viewGroup, i);
            b bVar = new b(a2.g());
            bVar.s = i;
            bVar.t = a2;
            return bVar;
        }

        private void b(Sa sa, C0330a c0330a) {
            WeakReference<InterfaceC0362ad> weakReference;
            InterfaceC0362ad interfaceC0362ad;
            Object obj = c0330a.f5278g;
            boolean z = (obj instanceof C0578la) && ((C0578la) obj).getName().equalsIgnoreCase("screenshots");
            if ((C0455p.f6367d && !z) || (weakReference = Db.this.f6373b) == null || (interfaceC0362ad = weakReference.get()) == null) {
                return;
            }
            if (!z) {
                C0455p.f6367d = true;
            }
            interfaceC0362ad.a(new com.adobe.creativesdk.foundation.internal.storage.controllers.utils.b(sa, z));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(b bVar, int i) {
            C0330a c2 = c(i);
            Sa sa = bVar.s == getItemViewType(i) ? bVar.t : null;
            a aVar = Db.this.f5615h;
            if (aVar instanceof Ub.b) {
                if (((Ub.b) aVar).e(i)) {
                    View view = sa.G;
                    if (view != null) {
                        view.setVisibility(8);
                    }
                } else {
                    View view2 = sa.G;
                    if (view2 != null) {
                        view2.setVisibility(0);
                    }
                }
            }
            boolean z = sa != null;
            if (z && sa.f() == i) {
                z = !a(sa, c2);
            }
            if (z) {
                sa.a(new ViewOnClickListenerC0028a(i));
            }
            if (!(Db.this.b() instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.edit.F)) {
                if (this.f5617d.booleanValue() && z) {
                    sa.b(new b(bVar.t, i, bVar.s));
                }
            } else {
                sa.q();
            }
            if (z) {
                a(sa, c2, i);
            }
            b(sa, c2);
        }
    }

    /* compiled from: AssetsRecyclerView.java */
    /* loaded from: classes.dex */
    public static class b extends RecyclerView.ViewHolder {
        public int s;
        Sa t;

        public b(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AssetsRecyclerView.java */
    /* loaded from: classes.dex */
    public interface c {
        void a(C0330a c0330a, Bitmap bitmap, boolean z);
    }

    /* compiled from: AssetsRecyclerView.java */
    /* loaded from: classes.dex */
    protected class d extends AbstractC0457pb.a {

        /* renamed from: b, reason: collision with root package name */
        public Parcelable f5625b;

        protected d() {
            super();
        }
    }

    public Db(Context context) {
        super(context);
        this.j = new C0481ub(this);
        this.f5610c = new HashMap<>();
    }

    private void p() {
        int dimensionPixelSize = this.f6372a.getResources().getDimensionPixelSize(c.a.a.a.b.c.adobe_csdk_assetbrowser_grid_padding);
        this.f5612e.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, com.adobe.creativesdk.foundation.internal.utils.s.c(b()) + dimensionPixelSize);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Bitmap a(String str, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma);

    protected abstract RecyclerView.ItemDecoration a(RecyclerView recyclerView, Context context);

    protected abstract a a(Context context);

    protected abstract void a(int i);

    protected void a(int i, View view) {
    }

    abstract void a(C0330a c0330a);

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Sa sa, boolean z, boolean z2, boolean z3) {
    }

    protected abstract boolean a(C0330a c0330a, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma, com.adobe.creativesdk.foundation.storage.sd<Bitmap, AdobeCSDKException> sdVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean a(byte[] bArr, String str, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma, c.a.a.a.b<Bitmap> bVar, c.a.a.a.c<AdobeAssetException> cVar);

    protected abstract RecyclerView b(Context context);

    void b(Sa sa, C0330a c0330a, int i) {
        boolean c2 = c(c0330a);
        sa.b(c2);
        C0330a c0330a2 = this.f5610c.get(c0330a.f5272a);
        if (c0330a2 != null) {
            a(c0330a2);
        }
        if (sa.q != null && sa.p != null) {
            sa.r.setVisibility(8);
        }
        a(c0330a, new C0487vb(this, sa, i, c2));
    }

    protected abstract boolean b(C0330a c0330a);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract RecyclerView.LayoutManager c(Context context);

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb
    public AbstractC0457pb.a c() {
        if (this.f5613f == null) {
            return null;
        }
        d dVar = new d();
        dVar.f5625b = this.f5613f.onSaveInstanceState();
        return dVar;
    }

    protected boolean c(C0330a c0330a) {
        return false;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb
    public View d() {
        return this.f5611d;
    }

    protected abstract View d(Context context);

    public void e(Context context) {
        RecyclerView.ItemDecoration itemDecoration;
        this.f5611d = d(context);
        this.f5612e = b(context);
        this.f5614g.setOnRefreshListener(new C0499yb(this));
        this.f5613f = c(context);
        this.f5612e.setLayoutManager(this.f5613f);
        this.f5615h = a(context);
        this.f5612e.setAdapter(this.f5615h.g());
        this.f5612e.setItemAnimator(null);
        this.i = a(this.f5612e, b());
        if (!(this.f5615h instanceof Ub.b) && (itemDecoration = this.i) != null) {
            this.f5612e.addItemDecoration(itemDecoration);
        }
        this.f5612e.addItemDecoration(new AbstractC0457pb.b((int) context.getResources().getDimension(c.a.a.a.b.c.adobe_csdk_recylerview_padding_bottom_offset)));
        int parseColor = Color.parseColor("#2098f5");
        int parseColor2 = Color.parseColor("#f5f9fa");
        this.f5614g.setColorSchemeColors(parseColor, parseColor2, parseColor, parseColor2);
        i();
        p();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb
    public void f() {
        e();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb
    public void g() {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb
    public void h() {
        this.f5614g.setRefreshing(false);
    }

    protected void i() {
        this.f5612e.setOnScrollListener(this.j);
    }

    protected int j() {
        if (this.f5612e.getChildCount() == 0) {
            return 0;
        }
        RecyclerView recyclerView = this.f5612e;
        return recyclerView.getChildPosition(recyclerView.getChildAt(0));
    }

    protected int k() {
        int childCount = this.f5612e.getChildCount();
        if (childCount == 0) {
            return 0;
        }
        RecyclerView recyclerView = this.f5612e;
        return recyclerView.getChildPosition(recyclerView.getChildAt(childCount - 1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        int j = j();
        int k = k();
        int itemCount = this.f5615h.getItemCount();
        if (itemCount == 0) {
            return;
        }
        double d2 = k;
        double d3 = itemCount - (k - j);
        Double.isNaN(d2);
        Double.isNaN(d3);
        if (d2 / d3 > 0.8d) {
            WeakReference<InterfaceC0362ad> weakReference = this.f6373b;
            InterfaceC0362ad interfaceC0362ad = weakReference != null ? weakReference.get() : null;
            if (interfaceC0362ad != null) {
                interfaceC0362ad.k();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m() {
        /*
            r4 = this;
            android.support.v7.widget.RecyclerView$ItemDecoration r0 = r4.i
            if (r0 == 0) goto L9
            android.support.v7.widget.RecyclerView r1 = r4.f5612e
            r1.removeItemDecoration(r0)
        L9:
            android.support.v7.widget.RecyclerView$LayoutManager r0 = r4.f5613f
            r1 = -1
            if (r0 != 0) goto L10
        Le:
            r0 = -1
            goto L4a
        L10:
            boolean r2 = r0 instanceof android.support.v7.widget.StaggeredGridLayoutManager
            if (r2 == 0) goto L40
            int r0 = r0.getChildCount()
            if (r0 <= 0) goto L2f
            android.support.v7.widget.RecyclerView$LayoutManager r0 = r4.f5613f
            android.support.v7.widget.StaggeredGridLayoutManager r0 = (android.support.v7.widget.StaggeredGridLayoutManager) r0
            int r0 = r0.getSpanCount()
            int[] r0 = new int[r0]
            android.support.v7.widget.RecyclerView$LayoutManager r2 = r4.f5613f
            android.support.v7.widget.StaggeredGridLayoutManager r2 = (android.support.v7.widget.StaggeredGridLayoutManager) r2
            r2.findFirstVisibleItemPositions(r0)
            r2 = 0
            r0 = r0[r2]
            goto L30
        L2f:
            r0 = -1
        L30:
            android.support.v7.widget.RecyclerView$LayoutManager r2 = r4.f5613f
            android.support.v7.widget.StaggeredGridLayoutManager r2 = (android.support.v7.widget.StaggeredGridLayoutManager) r2
            android.app.Activity r3 = r4.b()
            int r3 = com.adobe.creativesdk.foundation.internal.utils.q.a(r3)
            r2.setSpanCount(r3)
            goto L4a
        L40:
            boolean r2 = r0 instanceof android.support.v7.widget.LinearLayoutManager
            if (r2 == 0) goto Le
            android.support.v7.widget.LinearLayoutManager r0 = (android.support.v7.widget.LinearLayoutManager) r0
            int r0 = r0.findFirstVisibleItemPosition()
        L4a:
            android.support.v7.widget.RecyclerView r2 = r4.f5612e
            android.app.Activity r3 = r4.b()
            android.support.v7.widget.RecyclerView$ItemDecoration r2 = r4.a(r2, r3)
            r4.i = r2
            com.adobe.creativesdk.foundation.internal.storage.controllers.Db$a r2 = r4.f5615h
            boolean r2 = r2 instanceof com.adobe.creativesdk.foundation.internal.storage.controllers.Ub.b
            if (r2 != 0) goto L65
            android.support.v7.widget.RecyclerView$ItemDecoration r2 = r4.i
            if (r2 == 0) goto L65
            android.support.v7.widget.RecyclerView r3 = r4.f5612e
            r3.addItemDecoration(r2)
        L65:
            r4.e()
            if (r0 == r1) goto L6f
            android.support.v7.widget.RecyclerView$LayoutManager r1 = r4.f5613f
            r1.scrollToPosition(r0)
        L6f:
            r4.p()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.storage.controllers.Db.m():void");
    }

    public void n() {
        this.f5612e.getAdapter().notifyDataSetChanged();
    }

    public void o() {
        this.f5614g.setRefreshing(true);
    }

    public static double a(float f2) {
        double d2 = f2;
        int i = c.a.a.a.c.a.a.b().a().getResources().getDisplayMetrics().densityDpi;
        if (i >= 320) {
            return f2 * 2.0f;
        }
        if (i <= 160) {
            return d2;
        }
        Double.isNaN(d2);
        return d2 * 1.5d;
    }

    public static C0582ma a(C0582ma c0582ma) {
        return new C0582ma((float) a(c0582ma.f7348a), (float) a(c0582ma.f7349b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Sa sa, String str) {
        if (b() == null) {
            return;
        }
        sa.l.setImageDrawable(com.adobe.creativesdk.foundation.internal.utils.a.a(b(), str));
        sa.l.setBackgroundColor(-1);
        sa.l.setScaleType(ImageView.ScaleType.CENTER);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Sa sa, C0330a c0330a, int i, boolean z, boolean z2) {
        boolean c2 = c(c0330a);
        sa.b(c2);
        C0330a c0330a2 = this.f5610c.get(c0330a.f5272a);
        if (c0330a2 != null) {
            a(c0330a2);
        }
        if (sa.q != null && sa.p != null) {
            sa.r.setVisibility(8);
        }
        a(c0330a, new C0491wb(this, sa, z, z2, i, c2));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb
    public void e() {
        this.f5615h.h();
        this.f5615h.i();
    }

    void a(C0330a c0330a, c cVar) {
        C0582ma c0582ma;
        C0495xb c0495xb = new C0495xb(this, c0330a, cVar);
        this.f5610c.put(c0330a.f5272a, c0330a);
        JSONObject jSONObject = c0330a.f5276e;
        float optInt = jSONObject != null ? jSONObject.optInt("width", 270) : 270;
        C0582ma c0582ma2 = com.adobe.creativesdk.foundation.internal.storage.model.util.c.f6622b;
        if (optInt >= c0582ma2.f7348a) {
            c0582ma = a(c0582ma2);
        } else {
            c0582ma = new C0582ma(optInt, 0.0f);
        }
        a(c0330a, AdobeAssetFileRenditionType.ADOBE_ASSET_FILE_RENDITION_TYPE_PNG, c0582ma, c0495xb);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb
    public void a(AbstractC0457pb.a aVar) {
        boolean z;
        RecyclerView.LayoutManager layoutManager;
        if (aVar == null || !((z = aVar instanceof d)) || (layoutManager = this.f5613f) == null || !z) {
            return;
        }
        layoutManager.onRestoreInstanceState(((d) aVar).f5625b);
    }

    protected void a(Sa sa, C0330a c0330a, int i) {
        ((C0578la) c0330a.f5278g).a(new C0503zb(this, sa, c0330a, i), new Ab(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Sa sa, AdobePhotoCollection adobePhotoCollection) {
        adobePhotoCollection.assetCount(new Bb(this, sa, adobePhotoCollection), new Cb(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0330a a(AdobeAssetFile adobeAssetFile) {
        C0330a c0330a = new C0330a();
        c0330a.f5272a = adobeAssetFile.getGUID();
        c0330a.f5273b = adobeAssetFile.getName();
        c0330a.f5275d = adobeAssetFile.getModificationDate();
        c0330a.f5274c = adobeAssetFile.getCreationDate();
        c0330a.f5276e = adobeAssetFile.getOptionalMetadata();
        c0330a.f5277f = adobeAssetFile.getMd5Hash();
        c0330a.f5278g = adobeAssetFile;
        c0330a.i = adobeAssetFile.getFileSize();
        return c0330a;
    }
}
