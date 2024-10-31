package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.internal.storage.C0330a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Db;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Jd;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFileRenditionType;
import com.adobe.creativesdk.foundation.storage.AdobePhoto;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import java.util.ArrayList;

/* compiled from: PhotosCollectionListView.java */
/* loaded from: classes.dex */
public class Rd extends Jd {
    private com.adobe.creativesdk.foundation.internal.storage.U k;
    private a l;
    private com.adobe.creativesdk.foundation.internal.storage.controllers.a.f m;
    private int n;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: PhotosCollectionListView.java */
    /* loaded from: classes.dex */
    public class a extends Jd.a {

        /* renamed from: h, reason: collision with root package name */
        boolean f5812h;
        String i;

        public a(Context context) {
            super(context);
            this.f5812h = false;
            this.i = "";
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Jd.a
        protected void a(Xc xc) {
            xc.c(1.0f);
            xc.H.setVisibility(8);
            xc.l.setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout linearLayout = (LinearLayout) xc.g().findViewById(c.a.a.a.b.e.adobe_csdk_assetview_assetgrid_assetcell_bottom_title_section);
            new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = (TextView) linearLayout.findViewById(c.a.a.a.b.e.adobe_csdk_assetview_file_modified_date);
            TextView textView2 = (TextView) linearLayout.findViewById(c.a.a.a.b.e.adobe_csdk_assetview_file_size);
            ImageView imageView = (ImageView) linearLayout.findViewById(c.a.a.a.b.e.adobe_csdk_assetview_file_icon);
            textView.setVisibility(8);
            textView2.setVisibility(8);
            xc.x = (RelativeLayout) linearLayout.findViewById(c.a.a.a.b.e.adobe_csdk_files_menu_icon);
            if (!C0455p.b(Rd.this.b())) {
                xc.x.setVisibility(8);
            }
            imageView.setVisibility(0);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Jd.a
        protected ArrayList<AdobePhoto> j() {
            if (this.f5697f == null && Rd.this.k != null) {
                ArrayList<AdobePhotoCollection> a2 = this.f5812h ? Rd.this.k.a(this.i) : Rd.this.k.d();
                if (a2 != null) {
                    this.f5697f = new ArrayList<>(a2);
                }
            }
            return this.f5697f;
        }
    }

    public Rd(Context context) {
        super(context);
        this.n = -1;
    }

    public void p() {
        a(this.l.f() <= 0);
    }

    public void a(com.adobe.creativesdk.foundation.internal.storage.U u) {
        this.k = u;
    }

    public void a(String str) {
        a aVar = this.l;
        aVar.f5812h = true;
        aVar.i = str;
        e();
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    public Bitmap a(String str, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma) {
        BitmapDrawable c2 = this.m.c(str + adobeAssetFileRenditionType.ordinal() + c0582ma.f7349b + c0582ma.f7348a);
        if (c2 != null) {
            return c2.getBitmap();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    public boolean a(byte[] bArr, String str, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma, c.a.a.a.b<Bitmap> bVar, c.a.a.a.c<AdobeAssetException> cVar) {
        this.m.a(str + adobeAssetFileRenditionType.ordinal() + c0582ma.f7349b + c0582ma.f7348a, bArr, new Pd(this, bVar), new Qd(this, cVar));
        return true;
    }

    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar) {
        this.m = fVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    protected Db.a a(Context context) {
        this.l = new a(b());
        return this.l;
    }

    protected com.adobe.creativesdk.foundation.internal.storage.controllers.commands.d a(AdobePhotoCollection adobePhotoCollection) {
        com.adobe.creativesdk.foundation.internal.storage.controllers.commands.h hVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.commands.h();
        hVar.c(adobePhotoCollection.getGUID());
        hVar.d(adobePhotoCollection.getName());
        hVar.a(adobePhotoCollection.getCatalog().getGUID());
        hVar.b(adobePhotoCollection.getCatalog().getName());
        return hVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    protected void a(int i) {
        Object obj;
        C0330a c2 = this.f5615h.c(i);
        if (c2 == null || (obj = c2.f5278g) == null || !(obj instanceof AdobePhotoCollection)) {
            return;
        }
        AdobePhotoCollection adobePhotoCollection = (AdobePhotoCollection) obj;
        InterfaceC0362ad interfaceC0362ad = this.f6373b.get();
        if (interfaceC0362ad != null) {
            interfaceC0362ad.a(a(adobePhotoCollection));
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    protected void a(int i, View view) {
        C0330a c2 = this.f5615h.c(i);
        if (c2 != null) {
            AdobePhotoCollection adobePhotoCollection = (AdobePhotoCollection) c2.f5278g;
            InterfaceC0362ad interfaceC0362ad = this.f6373b.get();
            if (interfaceC0362ad != null) {
                interfaceC0362ad.a(adobePhotoCollection, view);
            }
        }
    }
}
