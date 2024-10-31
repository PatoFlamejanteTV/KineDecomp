package com.bumptech.glide.request.a;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* compiled from: BitmapImageViewTarget.java */
/* loaded from: classes.dex */
public class b extends e<Bitmap> {
    public b(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.request.a.e
    public void a(Bitmap bitmap) {
        ((ImageView) this.f9084d).setImageBitmap(bitmap);
    }
}
