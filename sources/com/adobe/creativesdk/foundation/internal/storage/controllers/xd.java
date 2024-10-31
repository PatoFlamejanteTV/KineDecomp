package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.ThumbnailUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.adobe.creativesdk.foundation.internal.storage.C0330a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Db;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Jd;
import com.adobe.creativesdk.foundation.internal.storage.controllers.upload.AdobeUploadAssetData;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFileRenditionType;
import com.adobe.creativesdk.foundation.storage.AdobePhoto;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAsset;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;
import org.json.JSONObject;

/* compiled from: PhotosAssetListView.java */
/* loaded from: classes.dex */
public class xd extends Jd {
    private com.adobe.creativesdk.foundation.internal.storage.I k;
    private com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t<AdobePhotoCollection> l;
    private b m;
    private ArrayList<AdobeUploadAssetData> n;
    private c o;
    private com.adobe.creativesdk.foundation.internal.storage.controllers.a.f p;
    private int q;

    /* compiled from: PhotosAssetListView.java */
    /* loaded from: classes.dex */
    public static class a extends com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z {
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z
        protected RelativeLayout B() {
            return (RelativeLayout) g().findViewById(c.a.a.a.b.e.adobe_csdk_photoasset_image_progressbar_container);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
        public void t() {
            A();
            this.l = (ImageView) g().findViewById(c.a.a.a.b.e.adobe_csdk_photo_assets_image);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: PhotosAssetListView.java */
    /* loaded from: classes.dex */
    public class c extends Jd.a {

        /* renamed from: h, reason: collision with root package name */
        boolean f6537h;
        String i;

        public c(Context context) {
            super(context);
            this.f6537h = false;
            this.i = "";
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Jd.a
        protected void a(Xc xc) {
            xc.y();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Jd.a, com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        protected boolean b(C0330a c0330a) {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Jd.a, com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        public int f() {
            if (j() != null) {
                return 0 + j().size() + xd.this.r();
            }
            return 0;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a, android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i < xd.this.r() ? xd.this.q : super.getItemViewType(i - xd.this.r());
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Jd.a
        protected ArrayList<AdobePhoto> j() {
            ArrayList<AdobePhotoAsset> a2 = this.f6537h ? xd.this.k.a(this.i) : xd.this.k.d();
            if (this.f5697f == null && xd.this.k != null && a2 != null) {
                this.f5697f = new ArrayList<>(a2);
            }
            return this.f5697f;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a, android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(Db.b bVar, int i) {
            if (i >= xd.this.r()) {
                super.onBindViewHolder(bVar, i - xd.this.r());
            } else {
                a((d) bVar, (AdobeUploadAssetData) xd.this.n.get(i));
            }
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a, android.support.v7.widget.RecyclerView.Adapter
        public Db.b onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == xd.this.q) {
                return d.a(LayoutInflater.from(xd.this.f6372a), viewGroup);
            }
            return super.onCreateViewHolder(viewGroup, i);
        }

        private void a(d dVar, AdobeUploadAssetData adobeUploadAssetData) {
            C0582ma c0582ma;
            JSONObject jSONObject = adobeUploadAssetData.f5276e;
            float optInt = jSONObject != null ? jSONObject.optInt("width", 270) : 270;
            C0582ma c0582ma2 = com.adobe.creativesdk.foundation.internal.storage.model.util.c.f6622b;
            if (optInt >= c0582ma2.f7348a) {
                c0582ma = Db.a(c0582ma2);
            } else {
                c0582ma = new C0582ma(optInt, 0.0f);
            }
            adobeUploadAssetData.r = c0582ma;
            adobeUploadAssetData.p = AdobeAssetFileRenditionType.ADOBE_ASSET_FILE_RENDITION_TYPE_PNG;
            xd.this.m.a(adobeUploadAssetData, dVar.u);
            Bitmap bitmap = adobeUploadAssetData.k;
            if (bitmap != null) {
                dVar.a(bitmap, 0.3f);
                return;
            }
            float f2 = c0582ma.f7348a;
            dVar.a(ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile(adobeUploadAssetData.a().getPath()), (int) f2, (int) (f2 * (r6.getHeight() / r6.getWidth()))), 0.3f);
        }
    }

    public xd(Context context) {
        super(context);
        this.m = new b(this, null);
        this.q = 22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int r() {
        ArrayList<AdobeUploadAssetData> arrayList = this.n;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public void p() {
        this.m.a();
        this.l = null;
        this.n = null;
    }

    public void q() {
        a(this.o.f() <= 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotosAssetListView.java */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        Map<String, Observer> f6535a;

        private b() {
            this.f6535a = new HashMap();
        }

        public void a() {
            for (Map.Entry<String, Observer> entry : this.f6535a.entrySet()) {
                AdobeUploadAssetData adobeUploadAssetData = new AdobeUploadAssetData();
                adobeUploadAssetData.f5272a = entry.getKey();
                xd.this.l.b(adobeUploadAssetData, entry.getValue());
            }
            this.f6535a.clear();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void b(AdobeUploadAssetData adobeUploadAssetData, com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z zVar) {
            ((Activity) xd.this.f6372a).runOnUiThread(new yd(this, zVar, adobeUploadAssetData));
        }

        /* synthetic */ b(xd xdVar, vd vdVar) {
            this();
        }

        public void a(AdobeUploadAssetData adobeUploadAssetData, com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z zVar) {
            a(adobeUploadAssetData);
            zd zdVar = new zd(this, adobeUploadAssetData, zVar);
            this.f6535a.put(adobeUploadAssetData.f5272a, zdVar);
            xd.this.l.a(adobeUploadAssetData, zdVar);
            b(adobeUploadAssetData, zVar);
        }

        public void a(AdobeUploadAssetData adobeUploadAssetData) {
            Observer observer = this.f6535a.get(adobeUploadAssetData.f5272a);
            if (observer == null) {
                return;
            }
            this.f6535a.remove(adobeUploadAssetData.f5272a);
            xd.this.l.b(adobeUploadAssetData, observer);
        }
    }

    public void a(com.adobe.creativesdk.foundation.internal.storage.I i) {
        this.k = i;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb
    public void e() {
        this.o.h();
        this.o.notifyDataSetChanged();
    }

    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar) {
        this.p = fVar;
    }

    /* compiled from: PhotosAssetListView.java */
    /* loaded from: classes.dex */
    public static class d extends Db.b {
        public a u;

        private d(View view) {
            super(view);
        }

        public static d a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            a aVar = new a();
            aVar.a(layoutInflater, c.a.a.a.b.g.adobe_upload_photo_asset_cell, viewGroup);
            d dVar = new d(aVar.g());
            dVar.u = aVar;
            return dVar;
        }

        public void a(Bitmap bitmap, float f2) {
            this.u.a(bitmap, f2, false);
        }
    }

    public void a(String str) {
        c cVar = this.o;
        cVar.f6537h = true;
        cVar.i = str;
        e();
        q();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Jd, com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0377dd
    public boolean a() {
        return com.adobe.creativesdk.foundation.internal.storage.ca.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    public Bitmap a(String str, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma) {
        BitmapDrawable c2 = this.p.c(str);
        if (c2 != null) {
            return c2.getBitmap();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    public boolean a(byte[] bArr, String str, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma, c.a.a.a.b<Bitmap> bVar, c.a.a.a.c<AdobeAssetException> cVar) {
        this.p.a(str, bArr, new vd(this, bVar), new wd(this, cVar));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(Bitmap bitmap, String str, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma) {
        this.p.a(str, bitmap);
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    protected Db.a a(Context context) {
        this.o = new c(b());
        return this.o;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    protected void a(int i) {
        InterfaceC0362ad interfaceC0362ad;
        C0330a c2 = this.f5615h.c(i);
        if (c2 == null || this.l != null || (interfaceC0362ad = this.f6373b.get()) == null) {
            return;
        }
        interfaceC0362ad.a(c2.f5278g);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    protected void a(int i, View view) {
        InterfaceC0362ad interfaceC0362ad;
        C0330a c2 = this.f5615h.c(i);
        if (c2 == null || (interfaceC0362ad = this.f6373b.get()) == null) {
            return;
        }
        interfaceC0362ad.a(c2.f5278g, view);
    }

    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t<AdobePhotoCollection> tVar) {
        if (this.n == null) {
            this.l = tVar;
            this.n = new ArrayList<>();
            this.n.addAll(this.l.a());
            e();
        }
    }
}
