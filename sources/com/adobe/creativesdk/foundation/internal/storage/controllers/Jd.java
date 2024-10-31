package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.adobe.creativesdk.foundation.internal.storage.C0330a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Db;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFileRenditionType;
import com.adobe.creativesdk.foundation.storage.AdobePhoto;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAsset;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAssetRendition;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import java.util.ArrayList;

/* compiled from: PhotosBaseListView.java */
/* loaded from: classes.dex */
public abstract class Jd extends Db {
    public Jd(Context context) {
        super(context);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    protected RecyclerView.ItemDecoration a(RecyclerView recyclerView, Context context) {
        return new com.adobe.creativesdk.foundation.internal.storage.controllers.utils.d(4, b());
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0377dd
    public boolean a() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    public RecyclerView b(Context context) {
        return this.f5612e;
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
        this.f5612e = (RecyclerView) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_storage_assetbrowser_StaggeredGridView);
        this.f5612e.setTag(c.a.a.a.b.f.adobe_csdk_AUTOMATION_PHOTOS_ASSET_RECYCLER_VIEW, "PHOTOS_ASSET_RECYCLER_VIEW");
        return inflate;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0377dd
    public void a(Sa sa) {
        AdobePhoto adobePhoto = (AdobePhoto) this.f5615h.getItem(sa.f()).f5278g;
        if (adobePhoto != null && (adobePhoto instanceof AdobePhotoAsset) && com.adobe.creativesdk.foundation.internal.storage.ca.b()) {
            AdobePhotoAsset adobePhotoAsset = (AdobePhotoAsset) adobePhoto;
            if (sa.s()) {
                sa.a(false);
                com.adobe.creativesdk.foundation.internal.storage.ca.c(adobePhotoAsset);
            } else {
                sa.a(true);
                com.adobe.creativesdk.foundation.internal.storage.ca.a(adobePhotoAsset);
            }
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    protected boolean b(C0330a c0330a) {
        Object obj = c0330a.f5278g;
        if (obj instanceof AdobePhotoAsset) {
            return com.adobe.creativesdk.foundation.internal.storage.ca.b((AdobePhotoAsset) obj);
        }
        return false;
    }

    /* compiled from: PhotosBaseListView.java */
    /* loaded from: classes.dex */
    protected abstract class a extends Db.a {

        /* renamed from: f, reason: collision with root package name */
        ArrayList<AdobePhoto> f5697f;

        public a(Context context) {
            super(context);
        }

        C0330a a(AdobePhoto adobePhoto) {
            C0330a c0330a = new C0330a();
            c0330a.f5278g = adobePhoto;
            c0330a.f5272a = adobePhoto.getGUID();
            c0330a.f5273b = b(adobePhoto);
            c0330a.f5274c = adobePhoto.getCreationDate();
            c0330a.f5275d = adobePhoto.getModificationDate();
            c0330a.f5276e = adobePhoto instanceof AdobePhotoAsset ? ((AdobePhotoAsset) adobePhoto).getMetadata() : null;
            return c0330a;
        }

        protected abstract void a(Xc xc);

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        protected boolean a(C0330a c0330a) {
            return true;
        }

        protected String b(AdobePhoto adobePhoto) {
            if (adobePhoto instanceof AdobePhotoCollection) {
                return ((AdobePhotoCollection) adobePhoto).getName();
            }
            if (adobePhoto instanceof AdobePhotoAsset) {
                return ((AdobePhotoAsset) adobePhoto).getName();
            }
            return null;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        protected boolean b(C0330a c0330a) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        public C0330a c(int i) {
            ArrayList<AdobePhoto> j = j();
            if (j == null || i < 0 || i >= j.size()) {
                return null;
            }
            return a(j.get(i));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        public int f() {
            if (j() != null) {
                return j().size();
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        public void h() {
            this.f5697f = null;
        }

        protected abstract ArrayList<AdobePhoto> j();

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        protected boolean a(Sa sa, C0330a c0330a) {
            if (c0330a.f5278g instanceof AdobePhotoAsset) {
                String c2 = sa.c();
                String str = c0330a.f5272a;
                if (c2 != null && str != null && c2.equalsIgnoreCase(str)) {
                    if (com.adobe.creativesdk.foundation.internal.storage.ca.b()) {
                        boolean s = sa.s();
                        boolean b2 = Jd.this.b(c0330a);
                        if (s != b2) {
                            sa.a(b2);
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        protected Sa a(ViewGroup viewGroup, int i) {
            Xc xc = new Xc();
            xc.a(Jd.this.b().getLayoutInflater(), c.a.a.a.b.g.adobe_generic_staggered_assetviewcell, viewGroup);
            a(xc);
            return xc;
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    protected boolean a(C0330a c0330a, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma, com.adobe.creativesdk.foundation.storage.sd<Bitmap, AdobeCSDKException> sdVar) {
        String str = c0330a.f5272a;
        Object obj = c0330a.f5278g;
        if (obj instanceof AdobePhotoCollection) {
            AdobePhotoCollection adobePhotoCollection = (AdobePhotoCollection) obj;
            if (adobePhotoCollection.getCoverAsset() != null) {
                str = adobePhotoCollection.getCoverAsset().getGUID();
            }
        }
        String str2 = str;
        Bitmap a2 = a(str2, adobeAssetFileRenditionType, c0582ma);
        if (a2 != null) {
            sdVar.b(a2);
            return true;
        }
        Id id = new Id(this, sdVar, str2, adobeAssetFileRenditionType, c0582ma);
        Object obj2 = c0330a.f5278g;
        if (obj2 instanceof AdobePhotoCollection) {
            com.adobe.creativesdk.foundation.internal.storage.U.a((AdobePhotoCollection) obj2, id);
        } else if (obj2 instanceof AdobePhotoAsset) {
            AdobePhotoAsset adobePhotoAsset = (AdobePhotoAsset) obj2;
            AdobePhotoAssetRendition adobePhotoAssetRendition = adobePhotoAsset.getRenditions().get(AdobePhotoAsset.AdobePhotoAssetRenditionImageThumbnail2x);
            if (adobePhotoAssetRendition != null) {
                adobePhotoAsset.downloadRendition(adobePhotoAssetRendition, id);
            } else {
                sdVar.b(null);
            }
        }
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    void a(C0330a c0330a) {
        Object obj = c0330a.f5278g;
        if (obj instanceof AdobePhotoAsset) {
            ((AdobePhotoAsset) obj).cancelDownloadRequest();
        }
    }
}
