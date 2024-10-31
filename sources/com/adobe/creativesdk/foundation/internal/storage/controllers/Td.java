package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.internal.grid.utils.DynamicHeightImageView;

/* compiled from: StaggeredGridCellView.java */
/* loaded from: classes.dex */
public abstract class Td extends Sa {
    private float R = 0.0f;

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    protected void a() {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void a(Bitmap bitmap) {
        if (bitmap != null && this.R == 0.0f) {
            double heightRatio = ((DynamicHeightImageView) this.l).getHeightRatio();
            double height = bitmap.getHeight() / bitmap.getWidth();
            Double.isNaN(height);
            if (Math.abs(heightRatio - height) > 0.01d) {
                ((DynamicHeightImageView) this.l).setHeightRatio(height);
            }
        } else {
            ((DynamicHeightImageView) this.l).setHeightRatio(1.0d);
        }
        super.a(bitmap);
    }

    public void c(float f2) {
        this.R = f2;
        a(this.R);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void n() {
        ImageView imageView = this.l;
        if (imageView != null) {
            ((DynamicHeightImageView) imageView).setHeightRatio(this.I);
        }
        this.u = (LinearLayout) g().findViewById(c.a.a.a.b.e.staggeredCellLinearLayout);
        super.n();
    }

    public void y() {
        TextView textView = (TextView) a(c.a.a.a.b.e.adobe_csdk_assetview_file_size);
        a(c.a.a.a.b.e.adobe_csdk_files_thin_line).setVisibility(8);
        textView.setVisibility(8);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Sa
    public void a(float f2) {
        if (f2 == this.I) {
            return;
        }
        float f3 = this.R;
        if (f3 != 0.0f) {
            f2 = f3;
        }
        super.a(f2);
        ((DynamicHeightImageView) this.l).setHeightRatio(this.I);
    }
}
