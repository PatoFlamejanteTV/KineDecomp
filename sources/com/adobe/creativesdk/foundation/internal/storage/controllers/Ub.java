package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Db;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Rb;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFileRenditionType;
import com.adobe.creativesdk.foundation.storage.C0578la;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import java.util.ArrayList;

/* compiled from: CCFilesSectionListView.java */
/* loaded from: classes.dex */
public class Ub extends Rb {
    private RecyclerView p;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CCFilesSectionListView.java */
    /* loaded from: classes.dex */
    public class a extends RecyclerView.Adapter<Db.b> implements c.f.a.b {

        /* renamed from: c, reason: collision with root package name */
        b f5865c;

        public a(b bVar) {
            this.f5865c = null;
            this.f5865c = bVar;
        }

        @Override // c.f.a.b
        public RecyclerView.ViewHolder a(ViewGroup viewGroup) {
            return new Tb(this, LayoutInflater.from(viewGroup.getContext()).inflate(c.a.a.a.b.g.adobe_storage_assetslist_headerview, viewGroup, false));
        }

        @Override // c.f.a.b
        public long b(int i) {
            return c(i);
        }

        public int c(int i) {
            return this.f5865c.f(i);
        }

        public String[] f() {
            return this.f5865c.l();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f5865c.getItemCount();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return this.f5865c.getItemViewType(i);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public Db.b onCreateViewHolder(ViewGroup viewGroup, int i) {
            return this.f5865c.onCreateViewHolder(viewGroup, i);
        }

        @Override // c.f.a.b
        public void a(RecyclerView.ViewHolder viewHolder, int i) {
            ((TextView) viewHolder.itemView.findViewById(c.a.a.a.b.e.adobe_csdk_storage_assetslist_group_header_view)).setText(f()[c(i)]);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(Db.b bVar, int i) {
            this.f5865c.onBindViewHolder(bVar, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: CCFilesSectionListView.java */
    /* loaded from: classes.dex */
    public class b extends Rb.a {

        /* renamed from: h, reason: collision with root package name */
        a f5867h;
        c.f.a.c i;

        public b(Context context) {
            super(context);
            this.f5867h = null;
            this.i = null;
            this.f5867h = new a(this);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a
        protected void a(Sa sa, C0578la c0578la, boolean z, boolean z2) {
            ((SectionalListFolderCellView) sa).a(z, z2);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a
        protected Sa b(ViewGroup viewGroup) {
            Sd sd = new Sd();
            sd.a(Ub.this.b().getLayoutInflater(), c.a.a.a.b.g.adobe_assetview_list_assetviewcell, viewGroup);
            return sd;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a
        protected Sa c(ViewGroup viewGroup) {
            SectionalListFolderCellView sectionalListFolderCellView = new SectionalListFolderCellView();
            sectionalListFolderCellView.a(Ub.this.b().getLayoutInflater(), c.a.a.a.b.g.adobe_assetview_list_folderviewcell, viewGroup);
            sectionalListFolderCellView.e(true);
            return sectionalListFolderCellView;
        }

        public boolean e(int i) {
            return Ub.this.k.g().a(i);
        }

        public int f(int i) {
            return Ub.this.k.g().b(i);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        public RecyclerView.Adapter g() {
            if (this.i == null) {
                this.i = new c.f.a.c(this.f5867h);
                Ub.this.p.addItemDecoration(this.i);
                this.f5867h.registerAdapterDataObserver(new Vb(this));
            }
            return this.f5867h;
        }

        public String[] l() {
            ArrayList<String> d2 = Ub.this.k.g().d();
            return (String[]) d2.toArray(new String[d2.size()]);
        }

        public void m() {
            Ub.this.p.removeItemDecoration(this.i);
            this.i = null;
        }
    }

    /* compiled from: CCFilesSectionListView.java */
    /* loaded from: classes.dex */
    protected class c extends Rb.b {
        private a m;

        /* compiled from: CCFilesSectionListView.java */
        /* loaded from: classes.dex */
        class a extends RecyclerView.Adapter<Db.b> {

            /* renamed from: c, reason: collision with root package name */
            private final Rb.b f5868c;

            public a(Rb.b bVar) {
                this.f5868c = bVar;
            }

            @Override // android.support.v7.widget.RecyclerView.Adapter
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onBindViewHolder(Db.b bVar, int i) {
                this.f5868c.onBindViewHolder(bVar, i);
            }

            @Override // android.support.v7.widget.RecyclerView.Adapter
            public int getItemCount() {
                return this.f5868c.getItemCount();
            }

            @Override // android.support.v7.widget.RecyclerView.Adapter
            public int getItemViewType(int i) {
                return this.f5868c.getItemViewType(i);
            }

            @Override // android.support.v7.widget.RecyclerView.Adapter
            public Db.b onCreateViewHolder(ViewGroup viewGroup, int i) {
                return this.f5868c.onCreateViewHolder(viewGroup, i);
            }
        }

        public c(Context context) {
            super(context);
            this.m = null;
            this.m = new a(this);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.b
        protected com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z d(ViewGroup viewGroup) {
            com.adobe.creativesdk.foundation.internal.storage.controllers.upload.h hVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.upload.h();
            hVar.a(Ub.this.b().getLayoutInflater(), c.a.a.a.b.g.adobe_assetview_list_assetviewcell, viewGroup);
            return hVar;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        public RecyclerView.Adapter g() {
            return this.m;
        }
    }

    public Ub(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    public Bitmap a(String str, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb
    public boolean a(Bitmap bitmap, String str, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    public boolean a(byte[] bArr, String str, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma, c.a.a.a.b<Bitmap> bVar, c.a.a.a.c<AdobeAssetException> cVar) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    public RecyclerView b(Context context) {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    public RecyclerView.LayoutManager c(Context context) {
        return new LinearLayoutManager(context);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    protected View d(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(c.a.a.a.b.g.adobe_storage_assets_listview, new FrameLayout(context));
        this.f5614g = (SwipeRefreshLayout) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_listview_swipe_refresh_layout);
        this.p = (RecyclerView) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_storage_assetbrowser_listView);
        return inflate;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb
    protected Rb.b q() {
        return new c(b());
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    protected Db.a a(Context context) {
        return new b(context);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    protected RecyclerView.ItemDecoration a(RecyclerView recyclerView, Context context) {
        return new com.adobe.creativesdk.foundation.internal.storage.controllers.utils.c(context, (int) context.getResources().getDimension(c.a.a.a.b.c.adobe_csdk_assetbrowser_list_view_image_margin_left_margin));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb, com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    public void a(Sa sa, boolean z, boolean z2, boolean z3) {
        ((SectionalListFolderCellView) sa).a(z, z2, z3);
    }
}
