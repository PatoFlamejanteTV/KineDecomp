package com.nextreaming.nexeditorui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: DrawableForColorEffect.java */
/* loaded from: classes.dex */
public class z extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private Drawable f4762a;
    private Path b;

    public z(Drawable drawable) {
        this.f4762a = drawable;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f4762a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f4762a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f4762a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, PorterDuff.Mode mode) {
        this.f4762a.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f4762a.setBounds(getBounds());
        canvas.save();
        this.b = new Path();
        this.b.addRoundRect(new RectF(getBounds()), 5.0f, 5.0f, Path.Direction.CW);
        canvas.clipPath(this.b);
        this.f4762a.draw(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f4762a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f4762a.getIntrinsicWidth();
    }

    public void a(ColorMatrix colorMatrix) {
        if (this.f4762a != null) {
            setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        }
    }
}
