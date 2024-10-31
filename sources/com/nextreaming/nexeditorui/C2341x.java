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
/* renamed from: com.nextreaming.nexeditorui.x */
/* loaded from: classes.dex */
public class C2341x extends Drawable {

    /* renamed from: a */
    private Drawable f24406a;

    /* renamed from: b */
    private Path f24407b;

    public C2341x(Drawable drawable) {
        this.f24406a = drawable;
    }

    public void a(ColorMatrix colorMatrix) {
        if (this.f24406a == null) {
            return;
        }
        setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f24406a.setBounds(getBounds());
        canvas.save();
        this.f24407b = new Path();
        this.f24407b.addRoundRect(new RectF(getBounds()), 5.0f, 5.0f, Path.Direction.CW);
        canvas.clipPath(this.f24407b);
        this.f24406a.draw(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f24406a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f24406a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f24406a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f24406a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f24406a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, PorterDuff.Mode mode) {
        this.f24406a.setColorFilter(i, mode);
    }
}
