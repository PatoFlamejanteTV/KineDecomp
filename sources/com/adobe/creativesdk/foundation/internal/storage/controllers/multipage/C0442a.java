package com.adobe.creativesdk.foundation.internal.storage.controllers.multipage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* compiled from: AdobeAssetAutoFitRecyclerCellView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.a */
/* loaded from: classes.dex */
public class C0442a {

    /* renamed from: a */
    protected Context f6262a;

    /* renamed from: b */
    protected View f6263b;

    /* renamed from: c */
    protected View f6264c;

    /* renamed from: d */
    protected DisplayMetrics f6265d;

    /* renamed from: e */
    protected int f6266e;

    public View a(int i) {
        return this.f6263b.findViewById(i);
    }

    public void b(int i) {
        this.f6266e = i;
    }

    public void a(View view) {
        this.f6263b = view;
    }

    public void b() {
        this.f6264c.setAlpha(0.0f);
    }

    public View a() {
        return this.f6263b;
    }

    public void a(DisplayMetrics displayMetrics) {
        this.f6265d = displayMetrics;
    }

    public void a(Context context) {
        this.f6264c = a(c.a.a.a.b.e.adobe_csdk_asset_image_view);
        if (Build.VERSION.SDK_INT >= 18) {
            ((ImageView) this.f6264c).setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            ((ImageView) this.f6264c).setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        this.f6262a = context;
    }

    public void a(BitmapDrawable bitmapDrawable, int i) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.f6266e == i) {
            int intrinsicWidth = bitmapDrawable.getIntrinsicWidth();
            int intrinsicHeight = bitmapDrawable.getIntrinsicHeight();
            DisplayMetrics displayMetrics = this.f6265d;
            if (intrinsicWidth >= displayMetrics.widthPixels && intrinsicHeight >= displayMetrics.heightPixels) {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            }
            layoutParams.addRule(13);
            this.f6264c.setLayoutParams(layoutParams);
            ((ImageView) this.f6264c).setImageDrawable(bitmapDrawable);
            this.f6264c.setAlpha(1.0f);
        }
    }

    public void a(Bitmap bitmap, int i) {
        if (this.f6266e == i) {
            if (bitmap.getWidth() >= this.f6265d.widthPixels && bitmap.getHeight() >= this.f6265d.heightPixels) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                this.f6264c.setLayoutParams(layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams2.addRule(13);
                this.f6264c.setLayoutParams(layoutParams2);
            }
            ((ImageView) this.f6264c).setImageBitmap(bitmap);
            this.f6264c.setAlpha(1.0f);
        }
    }
}
