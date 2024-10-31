package com.larvalabs.svgandroid;

import android.graphics.Picture;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Picture f2982a;
    private RectF b;
    private RectF c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Picture picture, RectF rectF) {
        this.f2982a = picture;
        this.b = rectF;
    }

    public PictureDrawable a() {
        return new PictureDrawable(this.f2982a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RectF rectF) {
        this.c = rectF;
    }
}
