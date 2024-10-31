package com.adobe.creativesdk.foundation.internal.storage.controllers.multipage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0402f;

/* compiled from: AdobeAssetOneUpRecyclerCellView.java */
/* loaded from: classes.dex */
public class h extends C0402f {
    protected int l;
    private int m = -1;
    private int n = -1;
    private w o;

    private void a(int i, int i2) {
        DisplayMetrics displayMetrics = this.f6091h;
        if (i >= displayMetrics.widthPixels && i2 >= displayMetrics.heightPixels) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.f6088e.setLayoutParams(layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i2);
            layoutParams2.addRule(13);
            this.f6088e.setLayoutParams(layoutParams2);
        }
    }

    public void c(int i) {
        this.l = i;
    }

    public void g() {
        this.f6086c.setVisibility(0);
        this.f6088e.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f6086c.setLayoutParams(layoutParams);
        this.f6086c.setAlpha(0.0f);
        this.f6089f.setVisibility(0);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0402f
    public void c() {
        super.c();
    }

    public void a(Bitmap bitmap, int i) {
        if (this.l == i) {
            super.a(bitmap);
            this.f6086c.setAlpha(1.0f);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0402f
    public void a(Context context) {
        super.a(context);
        this.f6087d.setVisibility(8);
        this.f6088e.setVisibility(8);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0402f
    public void a(boolean z) {
        if (!z) {
            this.f6086c.setVisibility(8);
            if (this.n == -1 || this.m == -1) {
                this.n = this.o.getWidth();
                this.m = this.o.getHeight();
                a(this.n, this.m);
            }
            this.f6088e.setVisibility(0);
            this.f6089f.setVisibility(8);
        }
        super.a(z);
    }

    public void a(BitmapDrawable bitmapDrawable, int i) {
        if (this.n == -1 || this.m == -1) {
            int intrinsicWidth = bitmapDrawable.getIntrinsicWidth();
            int intrinsicHeight = bitmapDrawable.getIntrinsicHeight();
            if (this.o.getWidth() == -1 || this.o.getHeight() == -1) {
                this.o.a(intrinsicWidth, intrinsicHeight);
            }
            a(intrinsicWidth, intrinsicHeight);
        }
        if (this.l == i) {
            super.a(bitmapDrawable);
            this.f6086c.setAlpha(1.0f);
        }
    }

    public void a(w wVar) {
        this.o = wVar;
    }
}
