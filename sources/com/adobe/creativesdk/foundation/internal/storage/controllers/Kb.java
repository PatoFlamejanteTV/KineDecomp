package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.adobe.creativesdk.foundation.internal.storage.C0330a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Db;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Rb;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFileRenditionType;
import com.adobe.creativesdk.foundation.storage.C0578la;
import com.adobe.creativesdk.foundation.storage.C0582ma;

/* compiled from: CCFilesGridView.java */
/* loaded from: classes.dex */
public class Kb extends Rb {
    private RecyclerView p;
    private com.adobe.creativesdk.foundation.internal.storage.controllers.a.f q;
    private boolean r;

    /* compiled from: CCFilesGridView.java */
    /* loaded from: classes.dex */
    protected class a extends Rb.a {
        public a(Context context) {
            super(context);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a
        protected void a(Sa sa, C0578la c0578la, boolean z, boolean z2) {
            ((Yc) sa).a(z, z2);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a
        protected Sa b(ViewGroup viewGroup) {
            Xc xc = new Xc();
            xc.a(Kb.this.b().getLayoutInflater(), c.a.a.a.b.g.adobe_generic_staggered_assetviewcell, viewGroup);
            return xc;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a
        protected Sa c(ViewGroup viewGroup) {
            Yc yc = new Yc();
            yc.a(Kb.this.b().getLayoutInflater(), c.a.a.a.b.g.adobe_assetview_assetsgrid_folderviewcell, viewGroup);
            yc.e(true);
            return yc;
        }
    }

    /* compiled from: CCFilesGridView.java */
    /* loaded from: classes.dex */
    protected class b extends Rb.b {
        public b(Context context) {
            super(context);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.b
        protected com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z d(ViewGroup viewGroup) {
            com.adobe.creativesdk.foundation.internal.storage.controllers.upload.g gVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.upload.g();
            gVar.a(Kb.this.b().getLayoutInflater(), c.a.a.a.b.g.adobe_generic_staggered_assetviewcell, viewGroup);
            return gVar;
        }
    }

    public Kb(Context context) {
        super(context);
        this.r = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    public Bitmap a(String str, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma) {
        BitmapDrawable c2 = this.q.c(str + adobeAssetFileRenditionType.ordinal() + c0582ma.f7349b + c0582ma.f7348a);
        if (c2 != null) {
            return c2.getBitmap();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    public RecyclerView b(Context context) {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    public RecyclerView.LayoutManager c(Context context) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(com.adobe.creativesdk.foundation.internal.utils.q.a(b()), 1);
        staggeredGridLayoutManager.setGapStrategy(2);
        return staggeredGridLayoutManager;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    protected View d(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(c.a.a.a.b.g.adobe_storage_assets_gridview, new FrameLayout(context));
        this.f5614g = (SwipeRefreshLayout) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_gridview_swipe_refresh_layout);
        this.p = (RecyclerView) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_storage_assetbrowser_StaggeredGridView);
        this.p.setTag(c.a.a.a.b.f.adobe_csdk_AUTOMATION_FILES_ASSET_RECYCLER_VIEW, "FILES_ASSET_RECYCLER_VIEW");
        return inflate;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb, com.adobe.creativesdk.foundation.internal.storage.controllers.Db, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb
    public void e() {
        this.k.g().a(this.k.d());
        super.e();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb
    protected Rb.b q() {
        return new b(b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    public boolean a(byte[] bArr, String str, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma, c.a.a.a.b<Bitmap> bVar, c.a.a.a.c<AdobeAssetException> cVar) {
        this.q.a(str + adobeAssetFileRenditionType.ordinal() + c0582ma.f7349b + c0582ma.f7348a, bArr, new Ib(this, bVar), new Jb(this, cVar));
        return true;
    }

    public void c(boolean z) {
        this.r = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb
    public boolean a(Bitmap bitmap, String str, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma) {
        this.q.a(str + adobeAssetFileRenditionType.ordinal() + c0582ma.f7349b + c0582ma.f7348a, bitmap);
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    public void e(Context context) {
        super.e(context);
    }

    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar) {
        this.q = fVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    protected Db.a a(Context context) {
        return new a(context);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    protected RecyclerView.ItemDecoration a(RecyclerView recyclerView, Context context) {
        return new com.adobe.creativesdk.foundation.internal.storage.controllers.utils.d(4, b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb, com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    public void a(Sa sa, boolean z, boolean z2, boolean z3) {
        ((Yc) sa).a(z, z2, z3, this.r);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb, com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    public void a(int i) {
        C0330a item = this.f5615h.getItem(i);
        Object obj = item != null ? item.f5278g : null;
        if ((obj instanceof C0578la) && ((C0578la) obj).d() && this.r) {
            return;
        }
        super.a(i);
    }
}
