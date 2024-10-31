package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.internal.utils.photoview.PhotoView;

/* compiled from: AdobeAssetOneUpBaseCellView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.f */
/* loaded from: classes.dex */
public class C0402f {

    /* renamed from: a */
    protected Context f6084a;

    /* renamed from: b */
    protected View f6085b;

    /* renamed from: c */
    protected View f6086c;

    /* renamed from: d */
    protected View f6087d;

    /* renamed from: e */
    protected View f6088e;

    /* renamed from: f */
    protected ProgressBar f6089f;

    /* renamed from: g */
    protected b f6090g;

    /* renamed from: h */
    protected DisplayMetrics f6091h;
    protected InterfaceC0382ed i;
    protected a j;
    private com.adobe.creativesdk.foundation.internal.utils.photoview.g k;

    /* compiled from: AdobeAssetOneUpBaseCellView.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.f$a */
    /* loaded from: classes.dex */
    public interface a {
        boolean a(float f2, float f3);
    }

    /* compiled from: AdobeAssetOneUpBaseCellView.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.f$b */
    /* loaded from: classes.dex */
    public class b {
        b() {
        }

        void a() {
            C0402f.this.c();
        }

        void a(boolean z) {
            C0402f.this.a(z);
        }
    }

    public void a(a aVar) {
        this.j = aVar;
    }

    public com.adobe.creativesdk.foundation.internal.utils.photoview.g b() {
        return this.k;
    }

    public void c() {
        this.f6086c.setVisibility(0);
        this.f6087d.setVisibility(8);
        this.f6088e.setVisibility(8);
    }

    public void d() {
        this.f6090g.a(true);
    }

    public void e() {
        this.f6090g.a(false);
    }

    public void f() {
        this.f6090g.a();
    }

    public void a(InterfaceC0382ed interfaceC0382ed) {
        this.i = interfaceC0382ed;
    }

    public void b(Context context) {
        this.f6084a = context;
    }

    public View a(int i) {
        return this.f6085b.findViewById(i);
    }

    public void b(int i) {
        e();
        ((TextView) this.f6088e.findViewById(c.a.a.a.b.e.adobe_csdk_common_view_error_message)).setText(i);
    }

    public void a(View view) {
        this.f6085b = view;
    }

    public void a(DisplayMetrics displayMetrics) {
        this.f6091h = displayMetrics;
    }

    public void a() {
        if (((PhotoView) this.f6086c).getAttacher() != null) {
            this.k = ((PhotoView) this.f6086c).getAttacher();
        } else {
            this.k = new com.adobe.creativesdk.foundation.internal.utils.photoview.g((ImageView) this.f6086c);
        }
        this.k.a(new C0378e(this));
    }

    public void a(Context context) {
        this.f6086c = a(c.a.a.a.b.e.adobe_csdk_asset_image_view);
        this.f6087d = a(c.a.a.a.b.e.adobe_csdk_asset_viewer_no_internet_connection);
        this.f6088e = a(c.a.a.a.b.e.adobe_csdk_asset_viewer_no_preview);
        this.f6089f = (ProgressBar) a(c.a.a.a.b.e.adobe_csdk_asset_image_progressbar_new);
        this.f6089f.setVisibility(0);
        this.f6084a = context;
        this.f6090g = new b();
    }

    public void a(BitmapDrawable bitmapDrawable) {
        RelativeLayout.LayoutParams layoutParams;
        int intrinsicWidth = bitmapDrawable.getIntrinsicWidth();
        int intrinsicHeight = bitmapDrawable.getIntrinsicHeight();
        Bitmap bitmap = bitmapDrawable.getBitmap();
        DisplayMetrics displayMetrics = this.f6091h;
        if (intrinsicWidth >= displayMetrics.widthPixels && intrinsicHeight >= displayMetrics.heightPixels) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        layoutParams.addRule(13);
        this.f6086c.setLayoutParams(layoutParams);
        DisplayMetrics displayMetrics2 = this.f6091h;
        ((ImageView) this.f6086c).setImageBitmap(com.adobe.creativesdk.foundation.internal.utils.p.a(bitmap, displayMetrics2.widthPixels, displayMetrics2.heightPixels));
        this.f6089f.setVisibility(8);
    }

    public void a(Bitmap bitmap) {
        if (bitmap.getWidth() >= this.f6091h.widthPixels && bitmap.getHeight() >= this.f6091h.heightPixels) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.f6086c.setLayoutParams(layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.addRule(13);
            this.f6086c.setLayoutParams(layoutParams2);
        }
        DisplayMetrics displayMetrics = this.f6091h;
        ((ImageView) this.f6086c).setImageBitmap(com.adobe.creativesdk.foundation.internal.utils.p.a(bitmap, displayMetrics.widthPixels, displayMetrics.heightPixels));
        this.f6089f.setVisibility(8);
    }

    public void a(boolean z) {
        this.f6086c.setVisibility(8);
        if (z) {
            this.f6087d.setVisibility(0);
            this.f6088e.setVisibility(8);
        } else {
            this.f6087d.setVisibility(8);
            this.f6088e.setVisibility(0);
        }
        this.f6089f.setVisibility(8);
    }
}
