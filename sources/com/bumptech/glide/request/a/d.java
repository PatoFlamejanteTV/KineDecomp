package com.bumptech.glide.request.a;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* compiled from: DrawableImageViewTarget.java */
/* loaded from: classes.dex */
public class d extends e<Drawable> {
    public d(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.request.a.e
    /* renamed from: e */
    public void a(Drawable drawable) {
        ((ImageView) this.f9084d).setImageDrawable(drawable);
    }
}
