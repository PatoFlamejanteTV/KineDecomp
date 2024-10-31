package com.adobe.creativesdk.foundation.internal.utils.photoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import com.adobe.creativesdk.foundation.internal.utils.photoview.g;

/* loaded from: classes.dex */
public class PhotoView extends ImageView implements c {

    /* renamed from: a */
    private final g f6879a;

    /* renamed from: b */
    private ImageView.ScaleType f6880b;

    public PhotoView(Context context) {
        this(context, null);
    }

    public g getAttacher() {
        return this.f6879a;
    }

    public Matrix getDisplayMatrix() {
        return this.f6879a.d();
    }

    public RectF getDisplayRect() {
        return this.f6879a.c();
    }

    public c getIPhotoViewImplementation() {
        return this.f6879a;
    }

    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    public float getMaximumScale() {
        return this.f6879a.f();
    }

    public float getMediumScale() {
        return this.f6879a.g();
    }

    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    public float getMinimumScale() {
        return this.f6879a.h();
    }

    public g.d getOnPhotoTapListener() {
        return this.f6879a.i();
    }

    public g.e getOnViewTapListener() {
        return this.f6879a.j();
    }

    public float getScale() {
        return this.f6879a.k();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f6879a.l();
    }

    public Bitmap getVisibleRectangleBitmap() {
        return this.f6879a.m();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        this.f6879a.b();
        super.onDetachedFromWindow();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f6879a.a(z);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        g gVar = this.f6879a;
        if (gVar != null) {
            gVar.o();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        g gVar = this.f6879a;
        if (gVar != null) {
            gVar.o();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        g gVar = this.f6879a;
        if (gVar != null) {
            gVar.o();
        }
    }

    @Deprecated
    public void setMaxScale(float f2) {
        setMaximumScale(f2);
    }

    public void setMaximumScale(float f2) {
        this.f6879a.a(f2);
    }

    public void setMediumScale(float f2) {
        this.f6879a.b(f2);
    }

    @Deprecated
    public void setMidScale(float f2) {
        setMediumScale(f2);
    }

    @Deprecated
    public void setMinScale(float f2) {
        setMinimumScale(f2);
    }

    public void setMinimumScale(float f2) {
        this.f6879a.c(f2);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f6879a.a(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f6879a.a(onLongClickListener);
    }

    public void setOnMatrixChangeListener(g.c cVar) {
        this.f6879a.a(cVar);
    }

    public void setOnPhotoTapListener(g.d dVar) {
        this.f6879a.a(dVar);
    }

    public void setOnViewTapListener(g.e eVar) {
        this.f6879a.a(eVar);
    }

    public void setPhotoViewRotation(float f2) {
        this.f6879a.e(f2);
    }

    public void setRotationBy(float f2) {
        this.f6879a.d(f2);
    }

    public void setRotationTo(float f2) {
        this.f6879a.e(f2);
    }

    public void setScale(float f2) {
        this.f6879a.f(f2);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        g gVar = this.f6879a;
        if (gVar != null) {
            gVar.a(scaleType);
        } else {
            this.f6880b = scaleType;
        }
    }

    public void setZoomTransitionDuration(int i) {
        this.f6879a.a(i);
    }

    public void setZoomable(boolean z) {
        this.f6879a.b(z);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        this.f6879a = new g(this);
        ImageView.ScaleType scaleType = this.f6880b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f6880b = null;
        }
    }
}
